package Animals;
import java.util.List;

import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;
import Organisms.Organism;

public abstract class Animal extends Organism{
    private int hunger;
    private int maxAge;
    private int sightRange;
    private double speed;
    private int reproductionAge;
    protected SpaceCheck spaceCheck;
    protected String ID;

    public Animal(String ID, Environment e, SpaceCheck sc, double intitialHealth, int hunger, double speed, int reproductionAge, int sightRange, Position position) {
        super(e, sc, intitialHealth);
        this.hunger=hunger;
        this.sightRange=sightRange;
        this.speed=speed;
        this.reproductionAge=reproductionAge;
        this.position = position;
        this.ID=ID;
        
    }

 
    

    public void change()
    {
        
        // hunger=hunger-10;
       
        // if(hunger<1)
        // {
        //     System.out.println(ID+"'s hunger:" + hunger);
        //     perish();
            
        // }

        List<Organism> close =spacecheck.getOrganismsWithinRange(this,sightRange);

        
        System.out.print(this.getID() +" is close to ");
        for(Organism x:close)
        {
            System.out.print(x.getID());
            System.out.println("\n");

        }

    }

    protected abstract void reproduce();
    
    protected abstract void moveTo(Position position);
    
    protected abstract Position findFood();


    @Override
public String toString() {
    return super.toString() + String.format(" | Hunger: %d | Speed: %.1f | Sight: %d",
        hunger, speed, sightRange);
}
}
