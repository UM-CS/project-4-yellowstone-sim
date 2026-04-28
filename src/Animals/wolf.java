package Animals;
import java.awt.Color;

import Drivers.Sim;
import Environment.Environment;
import Environment.Position;

public class wolf extends Animal{

    private double huntSpeed;

    public wolf(Sim sim, String ID, Environment e, Position position, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange,Color color) {
        super(sim, ID, e, position, hunger, reproductionAge, sightRange, speed, color);
        huntSpeed= speed*1.5;
       
        
    }

    @Override
    protected void reproduce() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reproduce'");
    }

    @Override
    public void act() {
      
    }



    @Override
    protected void moveTo(Position position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveTo'");
    }

    
    
    protected void hunt()
    {}

    protected void wander()
    {}
    }
