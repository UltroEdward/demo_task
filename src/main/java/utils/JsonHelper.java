package utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JsonHelper {

    private static final Logger log = LoggerFactory.getLogger(JsonHelper.class);

    public static JsonNode parseJsonNode(InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode newNode = null;
        try {
            newNode = mapper.readTree(stream);
        } catch (IOException e) {
            log.warn("Can't read data from input stream, it can be empty", e);
        }
        return newNode;
    }

}
