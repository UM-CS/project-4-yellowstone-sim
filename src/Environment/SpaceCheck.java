package Environment;

import Organisms.Organism;
import java.util.List;

public interface SpaceCheck {
    List<Organism> getOrganismsWithinRange(Organism source, double range);
    
}
