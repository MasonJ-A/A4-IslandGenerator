package ca.mcmaster.pathfinder.properties;

import java.util.List;
import java.util.Optional;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;

public class CityProperty implements PropertyAccess<Boolean>{
    private String CITY = "city";
    @Override
    public Optional<Boolean> extract(List<Property> props) {
        Boolean value = Boolean.parseBoolean(new Reader(props).get(CITY));
        if (value == null)
            return Optional.empty();
        return Optional.of(value);
    }
    
}
