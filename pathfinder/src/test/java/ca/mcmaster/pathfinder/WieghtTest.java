package ca.mcmaster.pathfinder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.GraphPathfinder;
import ca.mcmaster.pathfinder.Graph.Node;
import ca.mcmaster.pathfinder.Graph.Edge;
import java.math.BigDecimal;  
import java.math.RoundingMode;

public class WieghtTest {

    public Graph<Node> GraphSetup(){
        Graph<Node> graph = new Graph<>();
        Node node1 = new Node(10.0,15.0);
        Node node2 = new Node(35.0,15.0);
        graph.addEdge(node1, node2);
        Node node3 = new Node(85.0, 105.0);
        graph.addEdge(node2, node3);
        Node node4 = new Node(17.0, 157.0);
        graph.addEdge(node3, node4);
        Node node5 = new Node(12.0, 15.0);
        graph.addEdge(node3, node5);
        graph.addEdge(node5, node4);
        return graph;
    }
    public Double edgeweight(Edge<Node> e){
        Double sx = e.getStartNode().getX();
        Double sy = e.getStartNode().getY();
        Double ex = e.getEndNode().getX();
        Double ey = e.getEndNode().getY();
        return Math.sqrt(Math.pow(ex - sx,2) + Math.pow(ey - sy, 2));
    }
    @Test
    public void testWieght(){
        Graph<Node> graph = GraphSetup();
        GraphPathfinder pathfinder = new GraphPathfinder();
        HashMap<Edge<Node>, Double> weights = pathfinder.getWeights(graph);
        boolean result = true;
        
        for(Edge<Node> e : weights.keySet()){
            BigDecimal d1 = new BigDecimal(weights.get(e)).setScale(2, RoundingMode.HALF_UP); 
            BigDecimal d2 = new BigDecimal(edgeweight(e)).setScale(2, RoundingMode.HALF_UP); 
            result = result && Double.compare(d1.doubleValue(), d2.doubleValue())==0;
        }
        assertTrue(result);
    }
}
