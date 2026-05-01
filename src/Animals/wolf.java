package Animals;
import java.awt.Color;

import Drivers.Sim;
import Environment.Environment;
import Environment.Position;
import java.util.List;
import Animals.elk;

public class wolf extends Animal{

    private double huntSpeed;
    private boolean canReproduce = true;

    public wolf(Sim sim, String ID, Environment e, Position position, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange,Color color) {
        super(sim, ID, e, position, hunger, reproductionAge, sightRange,speed, color);
        huntSpeed= speed*1.5;

    }

    @Override
    protected void reproduce() {
        List<wolf> wolfNear =sim.getOrganismsWithinRange(this, sightRange, wolf.class);
        
        for(wolf x: wolfNear)
        {
            if(x.canReproduce())
            {
                moveTo(x.getPosition());
                sim.takeBabies(new wolf(sim,"Baby", environment, position, health, hunger, speed, birthDay, sightRange, color));
                System.out.print(" and made a baby\n");
                x.canReproduce=false;
            }
        }
        this.canReproduce=false;
    }

    @Override
    public void act() {
      if (hunger <= 0) {
        perish();
        return;
      }

      if (hunger < 75 && elkNearby()) {
        System.out.println(ID+ " has looked for food ");
        hunt();
      }

      else if (canReproduce && checkForMate()) {
        System.out.print(ID+" tried to reproduce");
        reproduce();
      }

      else {
        System.out.println(ID + " wandered around");
        wander();
      }


    
    }


    @Override
    protected void moveTo(Position position) {
        this.position = position;
        if (position != null) {
            this.position = position;
        }
    }

    
    
    protected void hunt()
    {List<elk> targets = sim.getOrganismsWithinRange(this, sightRange, elk.class);
        if (!targets.isEmpty()) {
            elk target = targets.get(0);
            moveTo(target.getPosition());
            target.perish();
            this.hunger += 50;
            System.out.println(ID + " hunted " + target.getID());
        }
    }

    protected void wander()
    {moveTo(position.randomPosition(position, speed));}

    public boolean canReproduce() {
        return canReproduce;
    }

    public String getID() {
        return ID;
    }

    public boolean checkForMate() {
        List<wolf> mates = sim.getOrganismsWithinRange(this, sightRange, wolf.class);

        for (wolf m : mates) {
            if (m.canReproduce()) {
                return true;
            }
        }
        return false;
    }
        
    private boolean elkNearby() {
        return !sim.getOrganismsWithinRange(this, sightRange, elk.class).isEmpty();
    }
}
