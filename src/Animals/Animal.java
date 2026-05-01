package Animals;
import Drivers.Sim;

import java.util.List;
import Environment.*;
import Organisms.Organism;
import java.awt.Color;


public abstract class Animal extends Organism{
    protected double hunger;
    protected int maxAge;
    protected int sightRange;
    protected int speed;
    protected int birthDay;
    protected SpaceCheck world;

    public Animal(Sim sim, String ID, Environment e, Position position, double hunger,  int birthDay, int sightRange, int speed,  Color color) {        
        super(sim, ID, e, position, sightRange, color);
        this.hunger=hunger;
        this.sightRange=sightRange;
        this.speed=speed;
        this.birthDay=birthDay;
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
    


    @Override
public String toString() {
    return super.toString() + String.format(" | Hunger: %.1f | Speed: %d | Sight: %d",
        hunger, speed, sightRange);
}
}
