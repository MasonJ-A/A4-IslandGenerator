package ca.mcmaster.pathfinder.Cities;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;

import ca.mcmaster.pathfinder.Graph.Node;

public class Converter {
    public Vertex convertToVertex(Node n){
        Vertex v = Structs.Vertex.newBuilder().setX(n.getX()).setY(n.getY()).build();
        return v;
    }
    public Node convertToNode(Vertex v){
        Node n = new Node(v.getX(), v.getY());
        return n;
    }
}
