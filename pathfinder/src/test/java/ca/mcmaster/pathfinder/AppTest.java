package ca.mcmaster.pathfinder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.Node;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testequals()
    {
        Graph<Node> G = new Graph<>();
        Node n1 = new Node(1.0, 1.0);
        Node n2 = new Node(2.0, 2.0);
        G.addEdge(n1, n2);
        G.addEdge(n1, n2);
        assertTrue(n1.equals(n1));
        assertTrue(n2.equals(n2));
        assertTrue(G.getEdge(0).equals(G.getEdge(1)));
    }
}
