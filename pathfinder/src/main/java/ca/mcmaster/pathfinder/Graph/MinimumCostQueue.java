package ca.mcmaster.pathfinder.Graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.pathfinder;

public class MinimumCostQueue {
    private static ArrayList<Graph<Vertex>.Node> queue;
    MinimumCostQueue(){
        queue = new ArrayList<>();
    }
    public static void EnQueue(Graph<Vertex>.Node n, HashMap<Graph<Vertex>.Edge, Double> weight){
        if(queue.isEmpty()){
            queue.add(n);
            return;
        }
        for(Graph<Vertex>.Edge key : weight.keySet()){
            
        }
    }
}
