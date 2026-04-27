package Environment;

import Organisms.Organism;
import java.util.List;

public interface SpaceCheck {
public <x> List<x> getOrganismsWithinRange(Organism source, int range, Class<?> x);
}
