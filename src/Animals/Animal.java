package Animals;
import Drivers.Sim;
import Environment.*;

import Organisms.Organism;

public abstract class Animal extends Organism{
    protected double hunger;
    protected int maxAge;
    protected int sightRange;
    protected int speed;
    protected int reproductionAge;
    protected SpaceCheck world;
    protected String ID;

    public Animal(Sim sim, String ID, Environment e,Position position, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange) {
        super(sim, ID, e, position, intitialHealth);
        this.hunger=hunger;
        this.sightRange=sightRange;
        this.speed=speed;
        this.reproductionAge=reproductionAge;
       
        
        
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
