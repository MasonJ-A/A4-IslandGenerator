package ca.mcmaster.pathfinder.properties;

import java.util.List;
import java.util.Optional;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class RoadProperty implements PropertyAccess<Boolean>{
    private static String ROAD = "road";
    @Override
    public Optional<Boolean> extract(List<Structs.Property> props) {
        Boolean value = Boolean.parseBoolean(new Reader(props).get(ROAD));
        if (value == null)
            return Optional.empty();
        return Optional.of(value);
    }
    
}
