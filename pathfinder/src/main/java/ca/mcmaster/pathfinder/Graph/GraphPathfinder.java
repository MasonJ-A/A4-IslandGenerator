package ca.mcmaster.pathfinder.Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.pathfinder;


public class GraphPathfinder implements pathfinder{

    public HashMap<Edge<Node>, Double> getWeights(Graph<Node> G){
        HashMap<Edge<Node>, Double> weightMap = new HashMap<>();
        List<Edge<Node>> edges = G.getEdges();
        Double sx;
        Double sy;
        Double ex;
        Double ey;
        for(Edge<Node> e : edges){
            sx = e.getStartNode().getX();
            sy = e.getStartNode().getY();
            ex = e.getEndNode().getX();
            ey = e.getEndNode().getY();
            weightMap.put(e, Math.sqrt(Math.pow(ex - sx,2) + Math.pow(ey - sy, 2)));
        }
        return weightMap;
    }

    public HashMap<Node, Node> shortestPathDijksra(Graph<Node> G, Node n){
        HashMap<Node, Node> shortestPath = new HashMap<>();
        HashMap<Node, Double> distance = new HashMap<>();
        HashMap<Node, Boolean> visited = new HashMap<>();
        HashMap<Edge<Node>, Double> weightMap = getWeights(G);
        List<Node> vertices = G.getVertices();
        List<Edge<Node>> edges = G.getEdges();
        for(Node v : vertices){
            distance.put(v, Double.MAX_VALUE);
            visited.put(v, false);
        }
        distance.put(n, 0.0);
        for(int i = 0; i < vertices.size(); i++){
            Node u = minDistance(distance, visited);
            visited.put(u, true);
            for(Edge<Node> e : edges){
                if(e.getStartNode().equals(u)){
                    Node v = e.getEndNode();
                    if(!visited.get(v)){
                        Double alt = distance.get(u) + weightMap.get(e);
                        if(alt < distance.get(v)){
                            distance.put(v, alt);
                            shortestPath.put(v, u);
                        }
                    }
                }
            }
        }
        return shortestPath;
    }
    public Node minDistance(HashMap<Node, Double> distance, HashMap<Node, Boolean> visited){
        Double min = Double.MAX_VALUE;
        Node minNode = null;
        for(Node n : distance.keySet()){
            if(!Objects.isNull(visited.get(n)) && !Objects.isNull(distance.get(n)) && !visited.get(n) && distance.get(n) <= min){
                min = distance.get(n);
                minNode = n;
            }
        }
        return minNode;
    }

    public List<Node> shortestPath(Graph<Node> G, Node start, Node end){
        HashMap<Node, Node> shortestPath = shortestPathDijksra(G, start);
        List<Node> path = new ArrayList<>();
        Node current = end;
        while(!Objects.isNull(current) && !current.equals(start)){
            path.add(current);
            current = shortestPath.get(current);
        }
        path.add(start);
        return path;
    }


}
