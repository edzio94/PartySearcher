package mainpackage.database;

import mainpackage.googleMapsParserClasses.Geocode;
import mainpackage.location.GeocodingLocationDTO;
import mainpackage.location.GeocodingLocationOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lukasz on 11.03.16.
 */
@Repository
public class LocationDatabaseOperations implements GeocodingLocationOperations{

    @Autowired
    JdbcTemplate template;

    @Override
    public void InsertGeocodingLocationIntoTable(GeocodingLocationDTO geocodingLocationDTO) {

        Geocode g = geocodingLocationDTO.results.get(0);

        template.update(INSERT_GEOCODING_LOCATION_INTO_TABLE,
                g.place_id,g.formatted_address,Double.parseDouble(g.geometry.location.lat),Double.parseDouble(g.geometry.location.lng));

    }
}
