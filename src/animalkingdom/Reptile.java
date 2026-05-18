package animalkingdom;

public class Reptile extends Animal {
    protected String scaleColor;
    protected boolean isColdBlooded;
    protected boolean hasShell;
    
    public Reptile(String name, int age, String habitat, String scaleColor, boolean hasShell) {
        super(name, age, habitat);
        this.scaleColor = scaleColor;
        this.isColdBlooded = true;
        this.hasShell = hasShell;
    }
    
    public String getScaleColor() {
        return scaleColor;
    }
    
    public void setScaleColor(String scaleColor) {
        this.scaleColor = scaleColor;
    }
    
    public boolean isColdBlooded() {
        return isColdBlooded;
    }
    
    public boolean hasShell() {
        return hasShell;
    }
    
    public void setHasShell(boolean hasShell) {
        this.hasShell = hasShell;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " hisses and makes reptile sounds.");
    }
    
    @Override
    public void move() {
        if (hasShell) {
            System.out.println(name + " slowly moves with its shell.");
        } else {
            System.out.println(name + " slithers on the ground.");
        }
    }
    
    @Override
    public void eat() {
        System.out.println(name + " catches and eats prey.");
    }
    
    public void sunbathe() {
        System.out.println(name + " is sunbathing to regulate body temperature.");
    }
    
    public void shedSkin() {
        System.out.println(name + " is shedding its old skin.");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Type: Reptile, Scale Color: " + scaleColor + ", Cold-blooded: " + isColdBlooded + ", Has Shell: " + hasShell;
    }
}
