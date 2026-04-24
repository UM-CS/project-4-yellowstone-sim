package Animals;
import Drivers.Sim;
import Environment.Environment;
import Environment.Position;
import java.awt.Color;

public class elk extends Animal {
    boolean canReproduce;
    double fleeSpeed;
    //public elk(Sim sim,String ID, Environment e, Position position, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange)
    public elk(Sim sim, String ID, Environment e, Position position, double intitialHealth, double hunger, int speed, int reproductionAge, int sightRange, Color color) {
        super(ID,e,sim,intitialHealth,hunger,speed,reproductionAge,sightRange,position,color);
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

        //throw new UnsupportedOperationException("Unimplemented method 'findFood'");
        //Ignore this, it sent me so many errors before i told it to just return postition and that terrified me
         return position;
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
