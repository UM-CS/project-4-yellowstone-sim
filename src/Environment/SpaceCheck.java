package Environment;

import java.util.List;
import Organisms.Organism;

public interface SpaceCheck {
public <x> List<x> getOrganismsWithinRange(Organism source, int range, Class<?> x);
}
