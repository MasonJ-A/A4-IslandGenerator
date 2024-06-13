package ca.mcmaster.pathfinder.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.pathfinder;
import ca.mcmaster.pathfinder.properties.ElevationProperty;

public class MeshPathfinder implements pathfinder{
    public Double WieghtCalculator(Mesh m, Segment s){
        List<Vertex> vertices = m.getVerticesList();
        Vertex v1 = vertices.get(s.getV1Idx());
        Vertex v2 = vertices.get(s.getV2Idx());
        ElevationProperty elevationProperty = new ElevationProperty();
        Optional<String> sz1 = elevationProperty.extract(v1.getPropertiesList());
        Optional<String> sz2 = elevationProperty.extract(v2.getPropertiesList());
        Double z1 = 0.0;
        Double z2 = 0.0;
        if(sz1.isPresent()){
            z1 = Double.parseDouble(sz1.get());
        }
        if(sz2.isPresent()){
            z2 = Double.parseDouble(sz1.get());
        }
        Double x1 = v1.getX();
        Double x2 = v2.getX();
        Double y1 = v1.getY();
        Double y2 = v2.getY();
        Double wieght = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) + Math.pow(z2-z1, 2));
        return wieght;
    }

    
    
    public HashMap<Vertex, Vertex> shortestPathDijksra(Mesh m, Vertex n) {
        HashMap<Vertex, Vertex> shortestPath = new HashMap<>();
        HashMap<Vertex, Double> distance = new HashMap<>();
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        List<Segment> segments = m.getSegmentsList();
        List<Vertex> vertices = m.getVerticesList();
        for(Vertex v : vertices){
            distance.put(v, Double.MAX_VALUE);
            visited.put(v, false);
        }
        distance.put(n, 0.0);
        for(int i = 0; i < vertices.size(); i++){
            
            Vertex minNode = minDistance(distance, visited);
            visited.put(minNode, true);
            for(Segment s : segments){
                if(s.getV1Idx() == vertices.indexOf(minNode)){
                    
                    Vertex v = vertices.get(s.getV2Idx());
                    Double weight = WieghtCalculator(m, s);
                    if(!visited.get(v) && distance.get(minNode) + weight < distance.get(v)){
                        
                        distance.put(v, distance.get(minNode) + weight);
                        shortestPath.put(v, minNode);
                    }
                }
                if(s.getV2Idx() == vertices.indexOf(minNode)){
                    
                    Vertex v = vertices.get(s.getV1Idx());
                    Double weight = WieghtCalculator(m, s);
                    if(!visited.get(v) && distance.get(minNode) + weight < distance.get(v)){
                        distance.put(v, distance.get(minNode) + weight);
                        shortestPath.put(v, minNode);
                    }
                }
            }
        }
        
        return shortestPath;
    }
    public Vertex minDistance(HashMap<Vertex, Double> distance, HashMap<Vertex, Boolean> visited){
        Double min = Double.MAX_VALUE;
        Vertex minNode = null;
        for(Vertex n : distance.keySet()){
            if(!Objects.isNull(visited.get(n)) && !Objects.isNull(distance.get(n)) && !visited.get(n) && distance.get(n) <= min){
                min = distance.get(n);
                minNode = n;
            }
        }
        return minNode;
    }
    //find the shortest path from a vertex to another vertex
    public List<Vertex> shortestPath(HashMap<Vertex, Vertex> shortestPath, Vertex v, Vertex n){
        List<Vertex> path = new ArrayList<>();
        Vertex current = v;
        while(!Objects.isNull(shortestPath.get(current))){
            path.add(current);
            current = shortestPath.get(current);
        }
        path.add(n);
        return path;
    }


    
}
