package Animals;

import java.util.List;
import Environment.*;
import Organisms.Organism;
import java.awt.Color;


public abstract class Animal extends Organism{
    protected double hunger;
    private int maxAge;
    private int sightRange;
    protected int speed;
    private int reproductionAge;
    protected SpaceCheck spaceCheck;
    protected String ID;

    public Animal(String ID, Environment e, SpaceCheck sc, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange, Position position, Color color) {        
        super(ID, e, sc, intitialHealth, color);
        this.hunger=hunger;
        this.sightRange=sightRange;
        this.speed=speed;
        this.reproductionAge=reproductionAge;
        this.position = position;
        this.color=color;
        
        
    }

 
    

    public void change()
    {
        hunger = hunger-(5*environment.getHungerMultiplier());
        age=age+1;

    }

    public void act()
    {

    }

    protected abstract void reproduce();
    
    protected abstract void moveTo(Position position);
    
    
    protected abstract Position findFood();


    @Override
public String toString() {
    return super.toString() + String.format(" | Hunger: %.1f | Speed: %d | Sight: %d",
        hunger, speed, sightRange);
}
}
