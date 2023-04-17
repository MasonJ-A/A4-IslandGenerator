package ca.mcmaster.pathfinder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.GraphPathfinder;
import ca.mcmaster.pathfinder.Graph.Node;
public class PathTest {
    @Test
    public void testPath(){
        Graph<Node> graph = new WieghtTest().GraphSetup();
        GraphPathfinder pathfinder = new GraphPathfinder();
        List<Node> nodes = graph.getVertices();
        HashMap<Node, Node> path = pathfinder.shortestPathDijksra(graph, nodes.get(0));
        //should go from nodes 1 -> 2 -> 3 -> 4 and ignore node 5;
        boolean result = true;
        for(Node n : path.keySet()){
            if( n.equals(graph.getVertex(0))){
                result = result & path.get(n).equals(graph.getVertex(0));
            }else{
                result = result & path.get(n).equals(graph.getVertex(graph.vertexIndex(n)-1));
            }
        }
        assertTrue(result);
    }
}
