package ca.mcmaster.pathfinder.Graph;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;

public class Edge<N>{
    private N nstart;
    private N nend;

    private List<Property> propertiesList;
    Edge(N nstart, N nend){
        this.nstart = nstart;
        this.nend = nend;
    }
    public void addProperty(Property p){
        propertiesList.add(p);
    }
    public List<Property> getPropertiesList(){
        return propertiesList;
    }
    public N getStartNode(){
        return nstart;
    }
    public N getEndNode(){
        return nend;
    }
    public boolean equals(Edge<N> e){
        return(nstart.equals(e.getStartNode()) && nend.equals(e.getEndNode()));
    }

}
