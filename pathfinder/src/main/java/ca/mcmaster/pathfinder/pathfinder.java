package ca.mcmaster.pathfinder;

import java.util.HashMap;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.Node;


public interface pathfinder {
    public HashMap<Node, Node> shortestPathDijksra(Graph<Node> G, Node n);
}