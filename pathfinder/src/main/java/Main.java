import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
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
    public static void main( String[] args )
    {
        PathPrinter PP = new PathPrinter();
        Graph graph = new Graph();
        Node node1 = new Node(10.0,15.0);
        Node node2 = new Node(35.0,15.0);
        graph.addEdge(node1, node2);
        Node node3 = new Node(85.0, 105.0);
        graph.addEdge(node2, node3);
        Node node4 = new Node(17.0, 157.0);
        //graph.addEdge(node3, node4);
        Node node5 = new Node(12.0, 15.0);
        graph.addEdge(node3, node5);
        graph.addEdge(node5, node4);
        PP.print(graph, node1, node4);
        
    }
}
