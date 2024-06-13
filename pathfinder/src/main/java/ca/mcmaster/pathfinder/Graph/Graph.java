package ca.mcmaster.pathfinder.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<N> {

    

    
    protected ArrayList<N> vertices;
    protected ArrayList<Edge<N>> edges; 
    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    public void addVertex(N n){
        vertices.add(n);
    }
    public void addEdge(Edge<N> e){
        edges.add(e);
        vertices.add(e.getStartNode());
        vertices.add(e.getEndNode());
    }
    public List<N> getVertices(){
        return vertices;
    }
    public List<Edge<N>> getEdges(){
        return edges;
    }
    public List<Edge<N>> getEdges(N n){
        List<Edge<N>> tempedges = new ArrayList<>();
        for(Edge<N> e : this.edges){
            if(e.getStartNode().equals(n) || e.getEndNode().equals(n)){
                tempedges.add(e);
            }
        }
        return tempedges;
    }
    public void addEdge(N nstart, N nend){
        edges.add(new Edge<N>(nstart, nend));
        vertices.add(nstart);
        vertices.add(nend);
    }
    public N getVertex(int i){
        return vertices.get(i);
    }
    public Edge<N> getEdge(int i){
        return edges.get(i);
    }
    public Boolean vertexExist(N v){
        for(N n : vertices){
            if(n.equals(v)){
                return true;
            }
        }
        return false;
    }
    public Boolean edgeExist(Edge e){
        for(Edge<N> s : edges){
            if(s.equals(e)){
                return true;
            }
        }
        return false;
    }
    public Integer vertexIndex(N n){
        for(int i = 0 ; i < vertices.size() ; i++){
            if (vertices.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }
    public Integer edgeIndex(Edge<N> e){
        for(int i = 0 ; i < edges.size() ; i++){
            if (edges.get(i).equals(e)){
                return i;
            }
        }
        return -1;
    }

}
