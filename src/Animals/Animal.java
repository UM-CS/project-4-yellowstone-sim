package Animals;
import Enviorment.Enviroment;
import Enviorment.Position;
import Organisms.Organism;

public abstract class Animal extends Organism{
    private int hunger;
    private int maxAge;
    private int sightRange;
    private double speed;
    private int reproductionAge;

    public Animal(Enviroment e,double intitialHealth,int hunger, double speed,int reproductionAge,int sightRange) {
        super(e, intitialHealth);
        this.hunger=hunger;
        this.sightRange=sightRange;
        this.speed=speed;
        this.reproductionAge=reproductionAge;
        
    }

 
    

    public void change()
    {
        
        hunger=hunger-10;
       
        if(hunger<1)
        {
            System.out.println(ID+"'s hunger:" + hunger);
            perish();
            
        }
    }

    protected abstract void reproduce();
    
    protected abstract void moveTo(Position position);
    
    protected abstract Position findFood();


}
