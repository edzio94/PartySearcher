package mainpackage.location;

/**
 * Created by lukasz on 11.03.16.
 */
public interface GeocodingLocationOperations {
    String INSERT_GEOCODING_LOCATION_INTO_TABLE="INSERT INTO map_location" +
            "(place_id,address,lat,lng)" +
            " VALUES(?,?,?,?)";
    void InsertGeocodingLocationIntoTable(GeocodingLocationDTO geocodingLocationDTO);
}
