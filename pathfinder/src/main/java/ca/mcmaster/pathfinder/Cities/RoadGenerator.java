package ca.mcmaster.pathfinder.Cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Generator;
import ca.mcmaster.pathfinder.pathfinder;
import ca.mcmaster.pathfinder.Graph.MeshPathfinder;
import ca.mcmaster.pathfinder.properties.CityProperty;
import ca.mcmaster.pathfinder.properties.RoadProperty;
import ca.mcmaster.pathfinder.properties.TileProperty;



public class RoadGenerator implements Generator{

    @Override
    public Mesh generate(Mesh m) {
        MeshPathfinder meshPathfinder = new MeshPathfinder();
        ArrayList<Vertex> vertices = new ArrayList<>(m.getVerticesList());
        ArrayList<Segment> segments = new ArrayList<>(m.getSegmentsList());
        List<Polygon> polygons = m.getPolygonsList();
        ArrayList<Vertex> centroids = new ArrayList<>();
        ArrayList<Vertex> cities = new ArrayList<>();
        CityProperty cityProperty = new CityProperty();
        TileProperty tileProperty = new TileProperty();
        Optional<Boolean> city;
        Optional<String> tile;
        for(Polygon p : polygons){
            tile = tileProperty.extract(p.getPropertiesList());
            if(tile.isPresent() && tile.get().equals("landTile")){
                city = cityProperty.extract(p.getPropertiesList());
                centroids.add(vertices.get(p.getCentroidIdx()));
                if(city.isPresent() && city.get()){
                    cities.add(vertices.get(p.getCentroidIdx()));
                }
            }
        }
        ArrayList<Segment> centroidsegments = new ArrayList<>();
        HashMap<Polygon, Boolean> segmentsfilled = new HashMap<>();
        for(Polygon p: polygons){
            tile = tileProperty.extract(p.getPropertiesList());
            if(tile.isPresent() && tile.get().equals("landTile")){
                segmentsfilled.put(p, false);
            }
        }
        List<Integer> neighbors;
        for(Polygon p : polygons){
            tile = tileProperty.extract(p.getPropertiesList());
            if(tile.isPresent() && tile.get().equals("landTile")){
                neighbors = p.getNeighborIdxsList();
                Integer v1 = p.getCentroidIdx();
                for(Integer i : neighbors){
                    tile = tileProperty.extract(polygons.get(i).getPropertiesList());
                    if(tile.isPresent() && tile.get().equals("landTile")){
                        Integer v2 = polygons.get(i).getCentroidIdx();
                        centroidsegments.add(Segment.newBuilder().setV1Idx(v1).setV2Idx(v2).build());
                    }
                }
                segmentsfilled.replace(p, true);
            }
            
        }
        Mesh centroidmesh = Mesh.newBuilder().addAllVertices(centroids).addAllSegments(centroidsegments).build();
        HashMap<Vertex, List<Vertex>> paths = new HashMap<>();
        Vertex c = cities.get(0);
        for(Vertex n : cities){
            if(!n.equals(c)){
                List<Vertex> path = meshPathfinder.shortestPath(centroidmesh, n, c);
                paths.put(n, path);
            }
        }
        Property roadprop = Property.newBuilder().setKey("road").setValue("true").build();
        for(Vertex n : paths.keySet()){
            for(Vertex v : paths.get(n)){
                vertices.add(Vertex.newBuilder(v).addProperties(roadprop).build());
            }
            vertices.add(Vertex.newBuilder().setX(0).setY(0).build());
        }
        RoadProperty roadProperty = new RoadProperty();
        Optional<Boolean> road1;
        Optional<Boolean> road2;
        for(int i = 0 ; i < vertices.size() -1 ; i++){
            Vertex v1 =vertices.get(i);
            Vertex v2 = vertices.get(i + 1);
            road1 = roadProperty.extract(v1.getPropertiesList());
            road2 = roadProperty.extract(v2.getPropertiesList());
            if(road1.isPresent() && road2.isPresent() && road1.get() && road2.get()){
                segments.add(Segment.newBuilder().setV1Idx(i).setV2Idx(i+1).addProperties(roadprop).build());
            }
        }
        return Mesh.newBuilder(m).addAllPolygons(polygons).addAllVertices(vertices).addAllSegments(segments).build();
    }
    
    
}
