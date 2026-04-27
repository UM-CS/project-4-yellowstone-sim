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
    int fleeSpeed;
    
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
                System.out.print(" and made a baby\n");
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
                System.out.print("and found it");
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
        if(wolfNearby())
        {
            flee();
            System.out.println(ID+" has fled a wolf");
        }
        else if(hunger<=0)
        {
            perish();
            return;
        }
        else if(hunger<75)
        {
            findFood();
            System.out.println(ID+ " has looked for food ");
        }
        else if(canReproduce && checkForMate())
        {
            System.out.print(ID+" tried to reproduce");
            reproduce();
        }
        else
        {
            System.out.println(ID +" wandered around");
            wander();
        }
    

    }
    private void wander() {

        moveTo(position.randomPosition(position,speed));
    }

    public void flee()
    {
        List<wolf> closeWolfs=sim.getOrganismsWithinRange(this, sightRange, wolf.class);

        for(wolf x:closeWolfs)
        {
            position=position.flee(this,x,fleeSpeed);
        }
    }

    private boolean wolfNearby()
    {
        if(sim.getOrganismsWithinRange(this, sightRange, wolf.class).size()!=0)
            return true;
        return false;
    }

    public String getID()
    {
        return ID;
    }

    public boolean canReproduce()
    {
        return canReproduce;
    }


    public boolean checkForMate()
    {
        List<elk> elkNear=sim.getOrganismsWithinRange(this, sightRange, elk.class);
        if(elkNear.size()==0)
            return false;
        else
        {
            for(elk x:elkNear)
                if(x.canReproduce())
                    return true;
        }
        return false;
    }

}
