package ca.mcmaster.cas.se2aa4.a2.generator;

import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

import java.awt.Color;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;

public class DotGen {

    private final int width = 500;
    private final int height = 500;
    private final int square_size = 20;

    public Mesh generate() {
        
        ArrayList<Vertex> vertices = new ArrayList<>();
        ArrayList<Segment> segments = new ArrayList<>();
        ArrayList<Vertex> verticesWithColors = new ArrayList<>();

        // Create all the vertices
        for(int x = 0; x < width; x += square_size) {
            for(int y = 0; y < height; y += square_size) {
                vertices.add(Vertex.newBuilder().setX((double) x).setY((double) y).build());
                vertices.add(Vertex.newBuilder().setX((double) x+square_size).setY((double) y).build());
                vertices.add(Vertex.newBuilder().setX((double) x).setY((double) y+square_size).build());
                vertices.add(Vertex.newBuilder().setX((double) x+square_size).setY((double) y+square_size).build());
            }
        }

        // Distribute colors randomly. Vertices are immutable, need to enrich them
        Random bag = new Random();
        for(Vertex v: vertices){
            int red = bag.nextInt(255);
            int green = bag.nextInt(255);
            int blue = bag.nextInt(255);
            String colorCode = red + "," + green + "," + blue;
            Property color = Property.newBuilder().setKey("rgb_color").setValue(colorCode).build();
            Vertex colored = Vertex.newBuilder(v).addProperties(color).build();
            verticesWithColors.add(colored);
        }

        /*for(int i = 0; i < 25; i++) {
            for(int j = 0; j < 25; j++){
                int pos1 = 4*j + (i*100);
                int pos2 = pos1 + 1;
                int pos3 = pos1 + 2;
                if(j != 24){
                    Property c = avgColor(verticesWithColors.get(pos1).getPropertiesList(), verticesWithColors.get(pos2).getPropertiesList());
                    Segment s = Segment.newBuilder().setV1Idx(pos1).setV2Idx(pos2).addProperties(c).build();
                    segments.add(s);
                }
                if(i != 24){
                    Property c = avgColor(verticesWithColors.get(pos1).getPropertiesList(), verticesWithColors.get(pos3).getPropertiesList());
                    Segment s = Segment.newBuilder().setV1Idx(pos1).setV2Idx(pos3).addProperties(c).build();
                    segments.add(s);
                }
            }
        }*/
        Segment s = Segment.newBuilder().setV1Idx(40).setV2Idx(4).build();
        segments.add(s);


        return Mesh.newBuilder().addAllVertices(verticesWithColors).addAllSegments(segments).build();

    }

    private Property avgColor(List<Property> prop1, List<Property> prop2) {
    
        String val1 = null;
        String val2 = null;
        for(Property p: prop1) {
            if (p.getKey().equals("rgb_color")) {
                System.out.println(p.getValue());
                val1 = p.getValue();
            }
        }
        for(Property p: prop2) {
            if (p.getKey().equals("rgb_color")) {
                System.out.println(p.getValue());
                val2 = p.getValue();
            }
        }
        String[] raw1 = val1.split(",");
        String[] raw2 = val2.split(",");
        int red = (Integer.parseInt(raw1[0]) + Integer.parseInt(raw2[0]))/2;
        int green = (Integer.parseInt(raw1[1]) + Integer.parseInt(raw2[1]))/2;
        int blue = (Integer.parseInt(raw1[2]) + Integer.parseInt(raw2[2]))/2;
        String colorCode = red + "," + green + "," + blue;
        Property color = Property.newBuilder().setKey("rgb_color").setValue(colorCode).build();
        return color;
    }

}
