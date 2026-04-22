package Animals;
import java.util.ArrayList;
import java.util.List;

import Drivers.Sim;
import Environment.Environment;
import Environment.Position;
import Organisms.Grass;
import Organisms.Organism;

public class elk extends Animal {
    boolean canReproduce;
    double fleeSpeed;
    
    public elk(Sim sim,String ID, Environment e, Position position, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange) {
        super(sim,ID, e, position, intitialHealth, hunger, speed, reproductionAge, sightRange);
        canReproduce=true;
        fleeSpeed=2*speed;
        this.ID=ID;
    }

 

    @Override
    protected void reproduce() {
        List<elk> elkNear=sim.getOrganismsWithinRange(this, sightRange, elk.class);

        for(elk x: elkNear)
        {
            if(x.canReproduce())
            {
                moveTo(x.getPosition());
                sim.takeBabies(new elk(sim,"Baby", environment, position, health, hunger, speed, reproductionAge, sightRange));
            }
        }
        canReproduce=false;
    }

    @Override
    protected void moveTo(Position position) {
        this.position=position;
    }
    
    protected void findFood() {
        
        List<Grass> closeGrass1=sim.getOrganismsWithinRange(this, sightRange, Grass.class);

        for(Grass x: closeGrass1)
        {
            if(!x.isGrazed())
            {
                moveTo(x.getPosition());
                x.graze();
                hunger+=10;
                continue;
            }
        }
 
        } 
    

    
    @Override 
    public void change()
    {
        super.change();
        if(environment.getSeason()=="Fall")
        {
            this.canReproduce=true;
        }
        else
        {
            this.canReproduce=false;
        }

    }
    
    @Override
    public void act() {
        if(hunger<=0)
        {
            perish();
            return;
        }
        else if(hunger<75)
        {
            findFood();
        }
        else if(canReproduce)
        {
            reproduce();
        }
        else
        {
            wander();
        }
    

    }
    private void wander() {

        moveTo(position.randomPosition(position,speed));
    }



    public String getID()
    {
        return ID;
    }

    public boolean canReproduce()
    {
        return canReproduce;
    }



}
