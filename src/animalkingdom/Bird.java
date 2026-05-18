package animalkingdom;

public class Bird extends Animal {
    protected String featherColor;
    protected double wingspan;
    protected boolean canFly;
    
    public Bird(String name, int age, String habitat, String featherColor, double wingspan, boolean canFly) {
        super(name, age, habitat);
        this.featherColor = featherColor;
        this.wingspan = wingspan;
        this.canFly = canFly;
    }
    
    public String getFeatherColor() {
        return featherColor;
    }
    
    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }
    
    public double getWingspan() {
        return wingspan;
    }
    
    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps and sings.");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " flies through the air.");
        } else {
            System.out.println(name + " walks and hops on the ground.");
        }
    }
    
    @Override
    public void eat() {
        System.out.println(name + " pecks at seeds and insects.");
    }
    
    public void layEggs() {
        System.out.println(name + " is laying eggs in a nest.");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Type: Bird, Feather Color: " + featherColor + ", Wingspan: " + wingspan + "m, Can Fly: " + canFly;
    }
}
