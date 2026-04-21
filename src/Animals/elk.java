package Animals;
import Enviorment.Enviroment;
import Enviorment.Position;
import Enviorment.SpaceCheck;

public class elk extends Animal {
    boolean canReproduce;
    double fleeSpeed;
    
    public elk(Enviroment e, SpaceCheck sc, double intitialHealth, Position position, int hunger, double speed, int reproductionAge, int sightRange, String ID) {
        super(e, sc, intitialHealth, hunger, speed, reproductionAge, sightRange, position);
        canReproduce=false;
        fleeSpeed=2.0*speed;
        this.ID=ID;
    }

 

    @Override
    protected void reproduce() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reproduce'");
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
    
    @Override
    public void act() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'act'");
    }
    public String getID()
    {
        return ID;
    }




}
