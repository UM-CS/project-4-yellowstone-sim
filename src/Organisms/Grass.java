package Organisms;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;
import Drivers.Sim;
public class Grass extends Organism{

    private double growthRate=environment.getGrowthChange();
    private boolean isGrazed;

    public Grass(Sim sim ,String ID, Environment e,Position position, double intitialHealth ) {
       
        super(sim ,ID, e, position, intitialHealth);
        isGrazed=false;
        
    }

    @Override
    public void act(){
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }
    @Override
    public void change() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }

    private void grow()
    {
        //TODO
    }

    private void spread(){

    }
    public void graze()
    {
        isGrazed=true;
    }
    public boolean isGrazed()
    {
        return isGrazed;
    }
    
    public String toString()
    {
       return super.toString()+ String.format(" | Grazed: %b ", isGrazed);
        
    }
}
