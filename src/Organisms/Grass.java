package Organisms;
import Environment.Environment;
import Environment.SpaceCheck;
public class Grass extends Organism{

    private double growthRate=enviroment.getGrowthChange();
    private boolean isGrazed;

    public Grass(Environment e, SpaceCheck spaceCheck, double intitialHealth) {
        super(e, spaceCheck, intitialHealth);
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
    
}
