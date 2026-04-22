 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;

import Organisms.Grass;
import Organisms.Organism;
import Animals.*;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;

public class Sim implements SpaceCheck {

private final int gridSize=100;
private List<Organism> organisms = new ArrayList<>();
private int tickCount = 0;
Environment e= new Environment();
private final int seasonLength=75;


private final int INITIAL_ELK =10;
private final int INITIAL_GRASS =50;
private final int INITIAL_WOLVES =10;


private void spawnInitial() {
        //for (int i = 0; i < INITIAL_GRASS;  i++) organisms.add(new Grass(e,10));
        //for (int i = 0; i < INITIAL_ELK;    i++) organisms.add(new elk(e, 1000, randomPosition(), 100, 1, 1, 1,"ELK".concat(String.valueOf(i))));
        //for (int i = 0; i < INITIAL_WOLVES; i++) organisms.add(new wolf(e, 1000, randomPosition(), 100, 1,1 ,1,"WOLF".concat(String.valueOf(i))));

        organisms.add(new elk("Weakling ELK",e,this,100,100,10,10,2,new Position(1,1)));
        organisms.add(new elk("Strong ELK",e,this,100,100,10,10,2,new Position(1,1)));

    }

private Position randomPosition() {
    Random rand = new Random();
    int x = rand.nextInt(gridSize);
    int y = rand.nextInt(gridSize);
    return new Position(x, y);
}    


public void go()
{
    spawnInitial();
    System.out.println("we have " + organisms.size() + " Organisms\n");
    System.out.println(organisms.get(0).toString());
    organisms.get(0).act();
    System.out.println(organisms.get(0).toString());
}

@Override
public List<Organism> getOrganismsWithinRange(Organism source, double range) {
    List<Organism> thingsNear =new ArrayList<>();
    Position OrgPos=source.getPosition();

          for (Organism o : organisms) {
            if (o != source && o.isAlive()) 
            {
                if (OrgPos.distaceTo(o.getPosition()) <= range) thingsNear.add(o);
            }
            
        }
        return thingsNear;

}

public int getGridSize()
{
    return gridSize;
}


}