import java.io.IOException;

import ca.mcmaster.cas.se2aa4.a2.io.MeshFactory;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;

import ca.mcmaster.pathfinder.Cities.CityGenerator;
import ca.mcmaster.pathfinder.Cities.CitySize;
import ca.mcmaster.pathfinder.Cities.RoadGenerator;
import ca.mcmaster.pathfinder.Configuration.Configuration;


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
        CitySize citySize = new CitySize();

        Structs.Mesh finalMesh = citySize.setCitySize(roadGenerator.generate(cityGenerator.generate(aMesh)), "medium");
        new MeshFactory().write(finalMesh, config.output());
    }
}
