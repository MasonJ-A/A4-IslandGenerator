package ca.mcmaster.pathfinder.Cities;

import java.util.List;
import java.util.Optional;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.distance;
import ca.mcmaster.pathfinder.properties.CityProperty;

public class FindMiddleCity {
    private Double max_y;
    private Double max_x;
    public Vertex middle(Mesh m, List<Vertex> cities){
        MeshSize size = new MeshSize(m);
        max_x = size.getMaxX();
        max_y = size.getMaxY();
        Double mid_x = max_x/2;
        Double mid_y = max_y/2;
        distance distance = new distance();
        Vertex centerVertex = cities.get(0);
        Double minDistance = Double.MAX_VALUE;
        
        for(Vertex v : cities){
            if (distance.centerDistance(v, mid_x, mid_y)<= minDistance){
                minDistance = distance.centerDistance(v, mid_x, mid_y);
                centerVertex = v;
            }
        }
        return centerVertex;
    }
}
