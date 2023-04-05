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
    public HashMap<Graph<Vertex>.Node, Graph<Vertex>.Node> shortestPathDijksra(Graph<Vertex> G, Graph<Vertex>.Node n){
        HashMap<Graph<Vertex>.Edge, Double> weight = getWeights(G);
        HashMap<Graph<Vertex>.Node, Graph<Vertex>.Node> path = new HashMap<>();
        HashMap<Graph<Vertex>.Node, Double> cost = new HashMap<>();
        MinimumCostQueue Q = new MinimumCostQueue();
        if(!G.vertexExist(n)){
            return path;
        }
        path.put(n, n);
        cost.put(n, 0.0);
        Double maxValue = 100000.0;
        for(Graph<Vertex>.Node node : G.getVertices()){
            if(!node.equals(n)){
                cost.put(node, maxValue);
            }
        }
        Q.EnQueue(n, 0.0);
        while(Q.size() > 0){
            for(Graph<Vertex>.Edge edges : G.getEdges()){
                if (cost.get(edges.getStartNode()) + weight.get(edges) < cost.get(edges.getEndNode())){
                    try{
                        path.put(edges.getStartNode(), edges.getEndNode());
                        cost.replace(edges.getEndNode(), cost.get(edges.getEndNode()), cost.get(edges.getStartNode()) + weight.get(edges));
                    }catch(Exception e){
                        path.replace(edges.getStartNode(), path.get(edges.getStartNode()), edges.getEndNode());
                        cost.replace(edges.getEndNode(), cost.get(edges.getEndNode()), cost.get(edges.getStartNode()) + weight.get(edges));
                    }
                    Q.EnQueue(edges.getEndNode(), cost.get(edges.getEndNode()));
                }
            }
        }
        return path;
    }

    
}
