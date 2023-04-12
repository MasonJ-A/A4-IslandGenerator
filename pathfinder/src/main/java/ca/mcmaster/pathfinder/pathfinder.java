package ca.mcmaster.pathfinder;

import java.util.HashMap;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Graph.Graph;
import ca.mcmaster.pathfinder.Graph.Node;


public interface pathfinder {
    public HashMap<Node, Node> shortestPathDijksra(Graph<Node> G, Node n);
    public List<Node> shortestPath(Graph<Node> G, Node start, Node end);
}