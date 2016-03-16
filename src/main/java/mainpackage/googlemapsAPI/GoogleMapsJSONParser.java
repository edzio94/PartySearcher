package mainpackage.googlemapsAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import mainpackage.location.GeocodingLocationDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lukasz on 16.02.16.
 */
@Component
public class GoogleMapsJSONParser {

    ObjectMapper jacksonMapper;

    public GoogleMapsJSONParser(String JSON) throws IOException {
        jacksonMapper = new ObjectMapper();


    }

    public GoogleMapsJSONParser()
    {
        jacksonMapper = new ObjectMapper();
    }

    public GeocodingLocationDTO returnGeocoingLocationDTO(String Json) throws IOException {
        return jacksonMapper.readValue(Json,GeocodingLocationDTO.class);
    }

}
