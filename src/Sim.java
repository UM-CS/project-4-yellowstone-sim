 
import java.util.ArrayList;
import java.util.List;

import Enviorment.Enviroment;
import Organisms.Grass;
import Organisms.Organism;
import Animals.*;

public class Sim {

private final int gridSize=100;
private List<Organism> organisms = new ArrayList<>();
private int tickCount = 0;
Enviroment e= new Enviroment();
private final int seasonLength=75;

private final int INITIAL_ELK =10;
private final int INITIAL_GRASS =50;
private final int INITIAL_WOLVES =10;

private void spawnInitial() {
       // for (int i = 0; i < INITIAL_GRASS;  i++) organisms.add(new Grass(e,10));
        for (int i = 0; i < INITIAL_ELK;    i++) organisms.add(new elk(e, 1000, 100, 1, 1, 1,"ELK".concat(String.valueOf(i))));
        for (int i = 0; i < INITIAL_WOLVES; i++) organisms.add(new wolf(e, 1000, 100, 1,1 ,1));

        organisms.add(new elk(e, 1, 1, 1, 1, 1, "Weakling"));
    }

    


public void go()
{
    spawnInitial();
    System.out.println(organisms.size());
    for(Organism x : organisms)
    x.change();
}



}

