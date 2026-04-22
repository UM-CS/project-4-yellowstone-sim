package Animals;
import java.util.ArrayList;
import java.util.List;

import Drivers.Sim;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;
import Organisms.Organism;

public class elk extends Animal {
    boolean canReproduce;
    double fleeSpeed;
    
    public elk(Sim sim,String ID, Environment e, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange, Position position) {
        super(sim,ID, e, intitialHealth, hunger, speed, reproductionAge, sightRange, position);
        canReproduce=true;
        fleeSpeed=2*speed;
        this.ID=ID;
    }

 

    @Override
    protected void reproduce() {
        List<elk> elkNear= new ArrayList<>();
        List<Organism> nearThis=sim.getOrganismsWithinRange(this, sightRange);
        for(Organism x: nearThis)
        {
            if(x.getClass()==elk.class)
                elkNear.add((elk) x);
                
        }

        for(elk x: elkNear)
        {
            if(x.canReproduce())
            {
                moveTo(x.getPosition());
                sim.takeBabies(new elk(sim,"Baby", environment,  health, hunger, speed, reproductionAge, sightRange, position));
            }
        }
        canReproduce=false;
    }

    @Override
    protected void moveTo(Position position) {
        this.position=position;
    }
    
    @Override
    protected Position findFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFood'");
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
