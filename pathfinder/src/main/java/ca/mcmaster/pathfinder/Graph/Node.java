package ca.mcmaster.pathfinder.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;

public class Node{
    private List<Property> propertiesList;
    private Double X;
    private Double Y;
    public Node(Double X , Double Y){
        this.X = X;
        this.Y = Y;
        this.propertiesList = new ArrayList<>();
    }
    public void addProperty(Property p){
        propertiesList.add(p);
    }
    public List<Property> getPropertiesList(){
        return propertiesList;
    }
    public double getX(){
        return this.X;
    }
    public double getY(){
        return this.Y;
    }
    public boolean hasX(){
        if (Objects.isNull(X)){
            return false;
        }
        return true;
    }public boolean hasY(){
        if (Objects.isNull(Y)){
            return false;
        }
        return true;
    }
    public boolean equals(Node n){
        if(!Objects.isNull(n)){
            return (X.compareTo(n.getX()) == 0 && Y.compareTo(n.getY()) == 0);
        }
            return false;
    }
}
