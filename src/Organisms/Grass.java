package Organisms;
import Enviorment.Enviroment;
public class Grass extends Organism{

    private double growthRate=enviroment.getGrowthChange();
    private boolean isGrazed;

    public Grass(Enviorment.Enviroment e, double intitialHealth) {
        super(e, intitialHealth);
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
