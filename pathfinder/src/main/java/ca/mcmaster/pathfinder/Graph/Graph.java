package ca.mcmaster.pathfinder.Graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.pathfinder.pathfinder;

public class Graph {

    

    
    protected ArrayList<Node> vertices;
    protected ArrayList<Edge> edges; 
    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    public void addVertex(Node n){
        vertices.add(n);
    }
    public void addEdge(Edge e){
        edges.add(e);
        vertices.add(e.getStartNode());
        vertices.add(e.getEndNode());
    }
    public List<Node> getVertices(){
        return vertices;
    }
    public List<Edge> getEdges(){
        return edges;
    }
    public List<Edge> getEdges(Node n){
        List<Edge> tempedges = new ArrayList<>();
        for(Edge e : this.edges){
            if(e.getStartNode().equals(n) || e.getEndNode().equals(n)){
                tempedges.add(e);
            }
        }
        return tempedges;
    }
    public void addEdge(Node nstart, Node nend){
        edges.add(new Edge(nstart, nend));
        vertices.add(nstart);
        vertices.add(nend);
    }
    public Node getVertex(int i){
        return vertices.get(i);
    }
    public Edge getEdge(int i){
        return edges.get(i);
    }
    public Boolean vertexExist(Node v){
        for(Node n : vertices){
            if(n.equals(v)){
                return true;
            }
        }
        return false;
    }
    public Boolean edgeExist(Edge e){
        for(Edge s : edges){
            if(s.equals(e)){
                return true;
            }
        }
        return false;
    }
    public Integer vertexIndex(Node n){
        for(int i = 0 ; i < vertices.size() ; i++){
            if (vertices.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }
    public Integer edgeIndex(Edge e){
        for(int i = 0 ; i < edges.size() ; i++){
            if (edges.get(i).equals(e)){
                return i;
            }
        }
        return -1;
    }

}
