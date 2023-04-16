package ca.mcmaster.pathfinder.Cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Polygon;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import ca.mcmaster.pathfinder.properties.CityProperty;

public class CitySize {
    public Mesh setCitySize(Mesh m, String size){
        Integer i;
        if(size.equals("medium")){
            i = 2;
        }else if(size.equals("large")){
            i = 1;
        }else{
            return m;
        }
        List<Polygon> oldPolygons = m.getPolygonsList();
        ArrayList<Polygon> polygons = new ArrayList<>();
        CityProperty cityProperty = new CityProperty();
        Optional<Boolean> city;
        List<Integer> nieghbor;

        Property color = Property.newBuilder().setKey("rgb_color").setValue("128,125,120").build();
        for(Polygon p : oldPolygons){
            city = cityProperty.extract(p.getPropertiesList());
            if(city.isPresent() && city.get()){
                nieghbor = p.getNeighborIdxsList();
                for(int j=0 ; j < nieghbor.size()/i ; j++){
                    polygons.add(Polygon.newBuilder(oldPolygons.get(nieghbor.get(j))).addProperties(color).build());
                }
            }
        }
        return Mesh.newBuilder(m).addAllPolygons(polygons).build();
    }
}
