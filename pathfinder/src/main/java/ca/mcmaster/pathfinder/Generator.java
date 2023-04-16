package ca.mcmaster.pathfinder;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.pathfinder.Configuration.Configuration;

public interface Generator {
    public Mesh generate(Mesh m, Configuration config);
}
