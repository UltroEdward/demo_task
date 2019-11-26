package utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HttpClient {

    private static final Logger log = LoggerFactory.getLogger(HttpClient.class);
    private static CloseableHttpClient client = HttpClients.createDefault();

    public CloseableHttpResponse doGet(String url) {
        HttpRequestBase httpGet = new HttpGet(url);

        return invoke(httpGet);
    }

    private CloseableHttpResponse invoke(HttpRequestBase http) {
        CloseableHttpResponse response = null;
        try {
            response = client.execute(http);
            return response;
        } catch (IOException e) {
            throw new RuntimeException("HTTP request failed: " + http.toString());
        }
    }

}

