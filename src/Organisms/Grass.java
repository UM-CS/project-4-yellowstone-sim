package Organisms;
import Enviorment.Enviroment;
import Enviorment.SpaceCheck;
public class Grass extends Organism{

    private double growthRate=enviroment.getGrowthChange();
    private boolean isGrazed;

    public Grass(Enviroment e, SpaceCheck sc, double intitialHealth) {
        super(e, sc, intitialHealth);
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
