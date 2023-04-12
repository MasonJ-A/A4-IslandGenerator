import java.io.IOException;

import ca.mcmaster.cas.se2aa4.a2.io.MeshFactory;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Cities.CityGenerator;
import ca.mcmaster.pathfinder.Cities.RoadGenerator;
import ca.mcmaster.pathfinder.Configuration.Configuration;
import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.GraphPathfinder;
import ca.mcmaster.pathfinder.Graph.Node;
import ca.mcmaster.pathfinder.Graph.PathPrinter;;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) throws IOException
    {
        Configuration config = new Configuration(args);
        Structs.Mesh aMesh = new MeshFactory().read(config.input());
        CityGenerator cityGenerator = new CityGenerator();
        RoadGenerator roadGenerator = new RoadGenerator();
        Structs.Mesh finalMesh = roadGenerator.generate(cityGenerator.generate(aMesh));
        new MeshFactory().write(finalMesh, config.output());
    }
}
