package ca.mcmaster.pathfinder.Graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.pathfinder;


public class GraphPathfinder implements pathfinder{

    public HashMap<Graph<Vertex>.Edge, Double> getWeights(Graph<Vertex> G){
        HashMap<Graph<Vertex>.Edge, Double> weightMap = new HashMap<>();
        List<Graph<Vertex>.Edge> edges = G.getEdges();
        Double sx;
        Double sy;
        Double ex;
        Double ey;
        for(Graph<Vertex>.Edge e : edges){
            sx = e.getStartNode().getVertex().getX();
            sy = e.getStartNode().getVertex().getY();
            ex = e.getEndNode().getVertex().getX();
            ey = e.getEndNode().getVertex().getY();
            weightMap.put(e, Math.sqrt(Math.pow(ex - sx,2) + Math.pow(ey - sy, 2)));
        }
        return weightMap;
    }
    @Override
    public HashMap<Graph<Vertex>.Node, Double> shortestPath(Graph<Vertex> G, Graph<Vertex>.Node N){
        HashMap<Graph<Vertex>.Edge, Double> weight = getWeights(G);
        HashMap<Graph<Vertex>.Node, Double> path = new HashMap<>();

    }

    
}
