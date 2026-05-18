package animalkingdom;

public class Mammal extends Animal {
    protected String furColor;
    protected boolean isWarmBlooded;
    
    public Mammal(String name, int age, String habitat, String furColor) {
        super(name, age, habitat);
        this.furColor = furColor;
        this.isWarmBlooded = true;
    }
    
    public String getFurColor() {
        return furColor;
    }
    
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    
    public boolean isWarmBlooded() {
        return isWarmBlooded;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " makes a mammal sound.");
    }
    
    @Override
    public void move() {
        System.out.println(name + " walks on four legs.");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating food.");
    }
    
    public void nurseYoung() {
        System.out.println(name + " is nursing its young.");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Type: Mammal, Fur Color: " + furColor + ", Warm-blooded: " + isWarmBlooded;
    }
}
