package ca.mcmaster.pathfinder.Graph;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.pathfinder.pathfinder;

public abstract class Graph<V> {

    public class Node{
        private V vertex;
        private List<Property> propertiesList;
        Node(V v){
            this.vertex = v;
            this.propertiesList = new ArrayList<>();
        }
        public void addProperty(Property p){
            propertiesList.add(p);
        }
        public List<Property> getPropertiesList(){
            return propertiesList;
        }
        public V getVertex(){
            return vertex;
        }
        
        public boolean equals(Node n){
            return vertex.equals(n.getVertex());
        }
    }

    public class Edge{
        private Node nstart;
        private Node nend;

        private List<Property> propertiesList;
        Edge(Node nstart, Node nend){
            this.nstart = nstart;
            this.nend = nend;
        }
        public void addProperty(Property p){
            propertiesList.add(p);
        }
        public List<Property> getPropertiesList(){
            return propertiesList;
        }
        public Node getStartNode(){
            return nstart;
        }
        public Node getEndNode(){
            return nend;
        }
        public boolean equals(Edge e){
            return(nstart.equals(e.getStartNode()) && nend.equals(e.getEndNode()));
        }

    }

    protected ArrayList<Node> vertices = new ArrayList<>();
    protected ArrayList<Edge> edges = new ArrayList<>();
    public void addVertex(Node n){
        vertices.add(n);
    }
    public void addEdge(Edge e){
        edges.add(e);
    }
    public List<Node> getVertices(){
        return vertices;
    }
    public List<Edge> getEdges(){
        return edges;
    }
    public void addEdge(Node nstart, Node nend){
        edges.add(new Edge(nstart, nend));
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
