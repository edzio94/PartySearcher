package mainpackage.googleMapsParserClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 11.03.16.
 */
public class  Geocode
{
    public List<AddressComponents> address_components;
    public String formatted_address;
    public Geometry geometry;
    public String place_id;
    public List<String> types = new ArrayList<>();


}
