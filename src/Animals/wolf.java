package Animals;
import Enviorment.Enviroment;
import Enviorment.Position;

public class wolf extends Animal{

    private double huntSpeed;

    public wolf(Enviroment e, double intitialHealth, int hunger, double speed, int reproductionAge, int sightRange) {
        super(e, intitialHealth, hunger, speed, reproductionAge, sightRange);
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
