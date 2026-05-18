package animalkingdom;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String habitat;
    
    public Animal(String name, int age, String habitat) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    public abstract void makeSound();
    public abstract void move();
    public abstract void eat();
    
    public void sleep() {
        System.out.println(name + " is sleeping in " + habitat + ".");
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Habitat: " + habitat;
    }
}
