package Environment;

import java.util.List;
import Organisms.Organism;

public interface SpaceCheck {
    List<Organism> getOrganismsWithinRange(Organism source, int range);
}
