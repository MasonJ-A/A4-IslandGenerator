package ca.mcmaster.pathfinder.Graph;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;

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
        return this.nstart;
    }
    public Node getEndNode(){
        return this.nend;
    }
    public boolean equals(Edge e){
        return(nstart.equals(e.getStartNode()) && nend.equals(e.getEndNode()));
    }

}
