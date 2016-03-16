package mainpackage.googlemapsAPI;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * Created by lukasz on 16.02.16.
 */

@Component
public class GoogleRequest {
    private HttpClient client;
    private HttpResponse response;
    private HttpGet request;
    public GoogleRequest(

    ){
        client =  HttpClientBuilder.create().build();
    }



    public org.apache.http.HttpResponse getResponse(String URL) throws IOException {


     request = new HttpGet("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyAH4PpkdHM6nXyfbu6b7HNqnKp201Yq1AI");

        return client.execute(request);
    }

    public String returnResponse(String URL) throws IOException {
        return EntityUtils.toString(getResponse(URL).getEntity());
    }
}
