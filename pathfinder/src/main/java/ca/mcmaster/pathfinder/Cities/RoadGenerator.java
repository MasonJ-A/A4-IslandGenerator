package ca.mcmaster.pathfinder.Cities;

import javax.crypto.Cipher;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Generator;
import ca.mcmaster.pathfinder.Graph.Edge;
import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.GraphPathfinder;
import ca.mcmaster.pathfinder.Graph.Node;
import ca.mcmaster.pathfinder.Graph.PathPrinter;
import ca.mcmaster.pathfinder.properties.CityProperty;
import ca.mcmaster.pathfinder.properties.RoadProperty;
import ca.mcmaster.pathfinder.properties.TileProperty;

import org.locationtech.jts.algorithm.Centroid;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.triangulate.DelaunayTriangulationBuilder;
import org.locationtech.jts.triangulate.quadedge.QuadEdge;
import org.locationtech.jts.triangulate.quadedge.QuadEdgeSubdivision;
import java.util.*;
import java.util.stream.Collectors;

public class RoadGenerator implements Generator{

    @Override
    public Mesh generate(Mesh m) {
        List<Vertex> Vertices = m.getVerticesList();
        List<Polygon> Polygons = m.getPolygonsList();
        ArrayList<Vertex> Centroids = new ArrayList<>();
        Set<Coordinate> sites = new HashSet<>();
        Graph<Node> graph = new Graph<>();
        TileProperty tileProperty = new TileProperty();
        CityProperty cityProperty = new CityProperty();
        Optional<String> tile;
        Optional<Boolean> city;
        Converter converter = new Converter();
        GraphPathfinder pathfinder = new GraphPathfinder();
        ArrayList<Segment> segments = new ArrayList<>();
        for(Polygon p : Polygons){
            tile = tileProperty.extract(p.getPropertiesList());
            if(tile.isPresent() && tile.get().equals("landTile")){
                Centroids.add(Vertex.newBuilder(Vertices.get(p.getCentroidIdx())).addAllProperties(p.getPropertiesList()).build());
                sites.add(new Coordinate(Vertices.get(p.getCentroidIdx()).getX(), Vertices.get(p.getCentroidIdx()).getY()));
            }
        }
        DelaunayTriangulationBuilder DTB = new DelaunayTriangulationBuilder();
        DTB.setSites(sites);
        Collection<QuadEdge> QEdges = DTB.getSubdivision().getEdges();
        for(QuadEdge q : QEdges){
            Node n1 = new Node(q.orig().getX(),q.orig().getY());
            Node n2 = new Node(q.dest().getX(), q.dest().getY());
            graph.addEdge(n1, n2);
        }
        ArrayList<Node> cities = new ArrayList<>();
        ArrayList<Vertex> cityPath = new ArrayList<>();
        for(Vertex c : Centroids){
            
            city = cityProperty.extract(c.getPropertiesList());
            if(city.get()){
                cities.add(converter.convertToNode(c));
            }
        }
        HashMap<Node,Node> path = new HashMap<>();
        int j = 0;
        Property road = Property.newBuilder().setKey("road").setValue("true").build();
     
        path = pathfinder.shortestPathDijksra(graph, converter.convertToNode(new FindMiddleCity().middle(m)));
        new PathPrinter().print(graph, converter.convertToNode(new FindMiddleCity().middle(m)), cities.get(1));
        return Mesh.newBuilder(m).build();  
    }
    
    
}
