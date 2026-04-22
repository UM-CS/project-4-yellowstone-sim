package Animals;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;

public class elk extends Animal {
    boolean canReproduce;
    double fleeSpeed;
    
    public elk(String ID, Environment e, SpaceCheck spaceCheck, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange, Position position) {
        super(ID, e, spaceCheck, intitialHealth, hunger, speed, reproductionAge, sightRange, position);
        canReproduce=false;
        fleeSpeed=2*speed;
        this.ID=ID;
    }

 

    @Override
    protected void reproduce() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reproduce'");
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




}
