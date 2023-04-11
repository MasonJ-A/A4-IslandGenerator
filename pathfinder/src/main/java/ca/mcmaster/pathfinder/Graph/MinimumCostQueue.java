package ca.mcmaster.pathfinder.Graph;


import java.util.ArrayList;
import java.util.HashMap;


import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.pathfinder.Graph.Node;
import ca.mcmaster.pathfinder.Graph.Graph;

public class MinimumCostQueue {
    private static HashMap<Node, Double> queueMap;
    private static ArrayList<Node> queue;
    MinimumCostQueue(){
        queue = new ArrayList<>();
        queueMap = new HashMap<>();
    }
    public void EnQueue(Node n, Double cost){
        if(queue.isEmpty()){
            queue.add(n);
            return;
        }
        queueMap.put(n, cost);
        int i = 0;
        Node temp = n;
        for(Node key : queue){
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
    public Node DeQueue(){
        return queue.get(0);
    }
    public int size(){
        return queue.size();
    }
}
