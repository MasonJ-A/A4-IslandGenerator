package ca.mcmaster.pathfinder.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

public class PathPrinter {
    public void print(Graph G, Node n, Node m){
        GraphPathfinder graphPathfinder = new GraphPathfinder();

        HashMap<Node, Node> path = graphPathfinder.shortestPathDijksra(G, n);
        Node M = m;
        ArrayList<String> pathList = new ArrayList<>();
        for(Node N = path.get(M); N != null; N = path.get(N)){
            pathList.add("(" + N.getX() + ", " + N.getY() + ")" + " -> " + "(" + M.getX() + ", " + M.getY()+ ")");
            M = N;
        }
        for(int i = pathList.size()-1; i>=0; i--){
            System.out.println(pathList.get(i));
        }
    }
    
    
}
