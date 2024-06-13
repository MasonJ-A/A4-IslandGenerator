package ca.mcmaster.pathfinder.properties;

import java.util.List;
import java.util.Optional;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;


public class SegementElevationProperty implements PropertyAccess<String> {

    private static final String ELEVATION = "segmentElevation";
    
    @Override
    public Optional<String> extract(List<Property> props){
        String value = new Reader(props).get(ELEVATION);
        if (value == null)
            return Optional.empty();
        return Optional.of(value);
    }
    
}