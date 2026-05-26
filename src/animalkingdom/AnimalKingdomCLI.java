package animalkingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalKingdomCLI {
    private static List<Animal> animals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   🦁 Animal Kingdom Simulation 🐦");
        System.out.println("========================================");
        System.out.println();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ", 1, 7);
            
            switch (choice) {
                case 1:
                    createAnimal();
                    break;
                case 2:
                    listAnimals();
                    break;
                case 3:
                    selectAnimal();
                    break;
                case 4:
                    deleteAnimal();
                    break;
                case 5:
                    displayAllInfo();
                    break;
                case 6:
                    demonstratePolymorphism();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using Animal Kingdom Simulation!");
                    break;
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Create a new animal");
        System.out.println("2. List all animals");
        System.out.println("3. Select and interact with an animal");
        System.out.println("4. Delete an animal");
        System.out.println("5. Display all animal information");
        System.out.println("6. Demonstrate polymorphism");
        System.out.println("7. Exit");
        System.out.println();
    }
    
    private static void createAnimal() {
        System.out.println("\n--- Create New Animal ---");
        
        String name = getStringInput("Enter animal name: ");
        int age = getIntInput("Enter animal age: ", 0, 200);
        String habitat = getStringInput("Enter habitat: ");
        
        System.out.println("\nSelect animal type:");
        System.out.println("1. Mammal");
        System.out.println("2. Bird");
        System.out.println("3. Reptile");
        int typeChoice = getIntInput("Enter choice (1-3): ", 1, 3);
        
        Animal animal;
        
        switch (typeChoice) {
            case 1:
                String furColor = getStringInput("Enter fur color: ");
                animal = new Mammal(name, age, habitat, furColor);
                break;
            case 2:
                String featherColor = getStringInput("Enter feather color: ");
                double wingspan = getDoubleInput("Enter wingspan (in meters): ", 0.1, 5.0);
                System.out.print("Can this bird fly? (yes/no): ");
                boolean canFly = scanner.nextLine().trim().equalsIgnoreCase("yes");
                animal = new Bird(name, age, habitat, featherColor, wingspan, canFly);
                break;
            case 3:
                String scaleColor = getStringInput("Enter scale color: ");
                System.out.print("Does this reptile have a shell? (yes/no): ");
                boolean hasShell = scanner.nextLine().trim().equalsIgnoreCase("yes");
                animal = new Reptile(name, age, habitat, scaleColor, hasShell);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        
        animals.add(animal);
        System.out.println("\n✓ Successfully created: " + animal.getName() + " the " + animal.getClass().getSimpleName());
        System.out.println("Total animals: " + animals.size());
    }
    
    private static void listAnimals() {
        System.out.println("\n--- All Animals ---");
        if (animals.isEmpty()) {
            System.out.println("No animals created yet.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println((i + 1) + ". " + animals.get(i).getName() + 
                    " (" + animals.get(i).getClass().getSimpleName() + ")");
            }
        }
    }
    
    private static void selectAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals available. Create an animal first.");
            return;
        }
        
        listAnimals();
        int index = getIntInput("\nEnter animal number to select: ", 1, animals.size()) - 1;
        Animal animal = animals.get(index);
        
        System.out.println("\n--- Interacting with " + animal.getName() + " ---");
        System.out.println(animal.toString());
        System.out.println();
        
        boolean interacting = true;
        while (interacting) {
            System.out.println("Actions:");
            System.out.println("1. Make Sound");
            System.out.println("2. Move");
            System.out.println("3. Eat");
            System.out.println("4. Sleep");
            System.out.println("5. Special Action");
            System.out.println("6. Back to main menu");
            
            int action = getIntInput("Choose action: ", 1, 6);
            
            switch (action) {
                case 1:
                    animal.makeSound();
                    break;
                case 2:
                    animal.move();
                    break;
                case 3:
                    animal.eat();
                    break;
                case 4:
                    animal.sleep();
                    break;
                case 5:
                    performSpecialAction(animal);
                    break;
                case 6:
                    interacting = false;
                    break;
            }
            System.out.println();
        }
    }
    
    private static void performSpecialAction(Animal animal) {
        if (animal instanceof Mammal) {
            ((Mammal) animal).nurseYoung();
        } else if (animal instanceof Bird) {
            ((Bird) animal).layEggs();
        } else if (animal instanceof Reptile) {
            ((Reptile) animal).sunbathe();
        }
    }
    
    private static void deleteAnimal() {
        if (animals.isEmpty()) {
            System.out.println("No animals available to delete.");
            return;
        }
        
        listAnimals();
        int index = getIntInput("\nEnter animal number to delete: ", 1, animals.size()) - 1;
        Animal removed = animals.remove(index);
        System.out.println("✓ Deleted: " + removed.getName());
        System.out.println("Total animals: " + animals.size());
    }
    
    private static void displayAllInfo() {
        System.out.println("\n--- All Animal Information ---");
        if (animals.isEmpty()) {
            System.out.println("No animals created yet.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + animals.get(i).toString());
            }
        }
    }
    
    private static void demonstratePolymorphism() {
        System.out.println("\n--- Demonstrating Polymorphism ---");
        System.out.println("Creating different animal types and calling the same methods:\n");
        
        Animal lion = new Mammal("Leo", 5, "African Savanna", "Golden");
        Animal eagle = new Bird("Sky", 3, "Mountains", "Brown", 2.5, true);
        Animal snake = new Reptile("Slither", 2, "Desert", "Green", false);
        
        Animal[] demoAnimals = {lion, eagle, snake};
        
        System.out.println("1. Calling makeSound() on different animal types:");
        for (Animal animal : demoAnimals) {
            System.out.print("   " + animal.getName() + " (" + animal.getClass().getSimpleName() + "): ");
            animal.makeSound();
        }
        
        System.out.println("\n2. Calling move() on different animal types:");
        for (Animal animal : demoAnimals) {
            System.out.print("   " + animal.getName() + " (" + animal.getClass().getSimpleName() + "): ");
            animal.move();
        }
        
        System.out.println("\n3. Calling eat() on different animal types:");
        for (Animal animal : demoAnimals) {
            System.out.print("   " + animal.getName() + " (" + animal.getClass().getSimpleName() + "): ");
            animal.eat();
        }
        
        System.out.println("\n4. Demonstrating type-specific methods:");
        System.out.print("   Leo (Mammal): ");
        ((Mammal) lion).nurseYoung();
        System.out.print("   Sky (Bird): ");
        ((Bird) eagle).layEggs();
        System.out.print("   Slither (Reptile): ");
        ((Reptile) snake).sunbathe();
        
        System.out.println("\n\nThis demonstrates polymorphism - the same method calls behave differently");
        System.out.println("based on the actual object type, while inheritance allows code reuse.");
    }
    
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static double getDoubleInput(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
