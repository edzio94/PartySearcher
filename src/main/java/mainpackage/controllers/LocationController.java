package mainpackage.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mainpackage.database.LocationDatabaseOperations;
import mainpackage.googlemapsAPI.GoogleMapsJSONParser;
import mainpackage.googlemapsAPI.GoogleRequest;
import mainpackage.location.GeocodingLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by lukasz on 17.02.16.
 */
@RestController
public class LocationController {

    @Autowired
    GoogleMapsJSONParser jsonParser;

    @Autowired
    GoogleRequest request;

    @Autowired
    LocationDatabaseOperations locationDatabaseOperations;

    @RequestMapping(value = "/getLocation")
    @ResponseBody
    public GeocodingLocationDTO returnLocation() throws IOException {
        String Json  = request.returnResponse("ww");
        System.out.println("Json: "+Json);

        return jsonParser.returnGeocoingLocationDTO(Json);

    }

    @RequestMapping(value = "/insertLocationIntoDatabase")
    public String insertLocationIntoDatabase()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String w = request.returnResponse("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyAH4PpkdHM6nXyfbu6b7HNqnKp201Yq1AI");
            GeocodingLocationDTO s = objectMapper.readValue(w,GeocodingLocationDTO.class);
            locationDatabaseOperations.InsertGeocodingLocationIntoTable(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
