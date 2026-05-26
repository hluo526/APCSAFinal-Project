package animalkingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Animal> kingdom = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Welcome to the Animal Kingdom Manager!");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create an Animal");
            System.out.println("2. View Created Animals");
            System.out.println("3. Make Animals Perform Actions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> createAnimalMenu();
                case 2 -> viewAnimals();
                case 3 -> performActions();
                case 4 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAnimalMenu() {
        System.out.println("\n--- What kind of animal do you want to create? ---");
        System.out.println("1. Reptile");
        System.out.println("2. Mammal");
        System.out.println("3. Bird");
        System.out.print("Choose a type: ");
        int type = readInt();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = readInt();
        System.out.print("Enter habitat: ");
        String habitat = scanner.nextLine();

        switch (type) {
            case 1 -> {
                System.out.print("Enter scale color: ");
                String scaleColor = scanner.nextLine();
                System.out.print("Does it have a shell? (true/false): ");
                boolean hasShell = readBoolean();
                
                kingdom.add(new Reptile(name, age, habitat, scaleColor, hasShell));
                System.out.println(name + " the Reptile has been added!");
            }
            case 2 -> {
                System.out.print("Enter fur color: ");
                String furColor = scanner.nextLine();
                
                kingdom.add(new Mammal(name, age, habitat, furColor));
                System.out.println(name + " the Mammal has been added!");
            }
            case 3 -> {
                System.out.print("Enter feather color: ");
                String featherColor = scanner.nextLine();
                System.out.print("Enter wingspan (in meters, e.g., 1.5): ");
                double wingspan = readDouble();
                System.out.print("Can it fly? (true/false): ");
                boolean canFly = readBoolean();
                
                kingdom.add(new Bird(name, age, habitat, featherColor, wingspan, canFly));
                System.out.println(name + " the Bird has been added!");
            }
            default -> System.out.println("Invalid animal type selection.");
        }
    }

    private static void viewAnimals() {
        if (kingdom.isEmpty()) {
            System.out.println("\nNo animals have been created yet.");
            return;
        }
        System.out.println("\n--- Current Animals ---");
        for (int i = 0; i < kingdom.size(); i++) {
            System.out.println((i + 1) + ". " + kingdom.get(i));
        }
    }

    private static void performActions() {
        if (kingdom.isEmpty()) {
            System.out.println("\nCreate some animals first!");
            return;
        }

        System.out.println("\n--- Trigger Animal Actions ---");
        for (Animal animal : kingdom) {
            System.out.println("\n--- " + animal.getName() + "'s turn ---");
            animal.makeSound();
            animal.move();
            animal.eat();
            animal.sleep();
            
            if (animal instanceof Reptile reptile) {
                reptile.sunbathe();
                reptile.shedSkin();
            } else if (animal instanceof Mammal mammal) {
                mammal.nurseYoung();
            } else if (animal instanceof Bird bird) {
                bird.layEggs();
            }
        }
    }
    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private static double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a decimal number: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    private static boolean readBoolean() {
        while (!scanner.hasNextBoolean()) {
            System.out.print("Invalid input. Enter true or false: ");
            scanner.next();
        }
        boolean val = scanner.nextBoolean();
        scanner.nextLine();
        return val;
    }
}