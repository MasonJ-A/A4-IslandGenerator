package ca.mcmaster.pathfinder;

import java.util.HashMap;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Graph.Graph;


public interface pathfinder {
    public HashMap<Graph<Vertex>.Node, Double> shortestPath(Graph<Vertex> G, Graph<Vertex>.Node N);
}
