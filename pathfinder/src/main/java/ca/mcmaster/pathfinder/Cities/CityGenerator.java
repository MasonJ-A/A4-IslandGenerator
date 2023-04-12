package ca.mcmaster.pathfinder.Cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.pathfinder.Generator;
import ca.mcmaster.pathfinder.properties.TileProperty;

public class CityGenerator implements Generator{

    @Override
    public Mesh generate(Mesh m) {
        TileProperty tileProperty = new TileProperty();
        ArrayList<Polygon> polygons = new ArrayList<>();
        Random rand = new Random();
        Optional<String> tile;
        Property propCity;
        Property color;
        for (Polygon p : m.getPolygonsList()) {
            tile = tileProperty.extract(p.getPropertiesList());
            if(tile.isPresent() && tile.get().equals("landTile") && rand.nextInt(m.getPolygonsCount())%20 == 0){
                propCity = Property.newBuilder().setKey("city").setValue(String.valueOf(true)).build();
                color = Property.newBuilder().setKey("rgb_color").setValue("128,125,120").build();
                polygons.add(Polygon.newBuilder(p).addProperties(propCity).addProperties(color).build());
            }else{
                propCity = Property.newBuilder().setKey("city").setValue(String.valueOf(false)).build();
                polygons.add(Polygon.newBuilder(p).addAllProperties(p.getPropertiesList()).addProperties(propCity).build());
            }
        }
        Mesh cityMesh = Mesh.newBuilder(m).clearPolygons().addAllPolygons(polygons).build();
        return cityMesh;
    }
}
