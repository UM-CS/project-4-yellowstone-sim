package Animals;
import Enviorment.Enviroment;
import Enviorment.Position;
import Enviorment.SpaceCheck;

public class wolf extends Animal{

    private double huntSpeed;

    public wolf(Enviroment e, SpaceCheck sc, double intitialHealth, Position position, int hunger, double speed, int reproductionAge, int sightRange, String ID) {
        super(e, sc,intitialHealth, hunger, speed, reproductionAge, sightRange, position);
        huntSpeed= speed*1.5;
        this.ID = ID;
        
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
