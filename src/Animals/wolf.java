package Animals;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;

public class wolf extends Animal{

    private double huntSpeed;

    public wolf(String ID, Environment e, SpaceCheck spaceCheck, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange, Position position) {
        super(ID, e, spaceCheck,intitialHealth, hunger, speed, reproductionAge, sightRange, position, color);
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

    @Override
    protected Position findFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFood'");
    }
    
    protected void hunt()
    {}

    protected void wander()
    {}
    }
