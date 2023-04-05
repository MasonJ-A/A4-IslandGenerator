package ca.mcmaster.pathfinder.Graph;


import java.util.ArrayList;
import java.util.HashMap;


import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Graph.Graph.Node;

public class MinimumCostQueue {
    private static HashMap<Graph<Vertex>.Node, Double> queueMap;
    private static ArrayList<Graph<Vertex>.Node> queue;
    MinimumCostQueue(){
        queue = new ArrayList<>();
        queueMap = new HashMap<>();
    }
    public void EnQueue(Graph<Vertex>.Node n, Double cost){
        if(queue.isEmpty()){
            queue.add(n);
            return;
        }
        queueMap.put(n, cost);
        int i = 0;
        Graph<Vertex>.Node temp = n;
        for(Graph<Vertex>.Node key : queue){
            if(queueMap.get(key)> cost){
                temp = queue.set(i, n);
                break;
            }
            i++;
        }
        i++;
            while( i < queue.size()){
                temp = queue.set(i, temp);
                i++;
            }
            queue.add(temp);
    }
    public Graph<Vertex>.Node DeQueue(){
        return queue.get(0);
    }
    public int size(){
        return queue.size();
    }
}
