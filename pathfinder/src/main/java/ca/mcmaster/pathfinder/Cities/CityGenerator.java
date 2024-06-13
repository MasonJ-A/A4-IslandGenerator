package ca.mcmaster.pathfinder.Cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.pathfinder.Generator;
import ca.mcmaster.pathfinder.Configuration.Configuration;
import ca.mcmaster.pathfinder.properties.TileProperty;

public class CityGenerator implements Generator{

    @Override
    public Mesh generate(Mesh m, Configuration config) {
        String num = config.cityNum();
        TileProperty tileProperty = new TileProperty();
        ArrayList<Polygon> polygons = new ArrayList<>();
        List<Polygon> oldPolygons = m.getPolygonsList();
        Random rand = new Random();
        Optional<String> tile;
        Property propCity;

        Integer citynum = Integer.parseInt(num);
        int j = 0;
        Property color = Property.newBuilder().setKey("rgb_color").setValue("128,125,120").build();
        for (Polygon p : oldPolygons) {
            tile = tileProperty.extract(p.getPropertiesList());
            if(tile.isPresent() && tile.get().equals("landTile") && j<citynum && rand.nextInt(2)== 0){
                propCity = Property.newBuilder().setKey("city").setValue(String.valueOf(true)).build();
                polygons.add(Polygon.newBuilder(p).addProperties(propCity).addProperties(color).build());
                j++;
            }else{
                propCity = Property.newBuilder().setKey("city").setValue(String.valueOf(false)).build();
                polygons.add(Polygon.newBuilder(p).addAllProperties(p.getPropertiesList()).addProperties(propCity).build());
            }
        }
        Mesh cityMesh = Mesh.newBuilder(m).clearPolygons().addAllPolygons(polygons).build();
        return cityMesh;
    }
}
