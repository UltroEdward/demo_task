package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FakeDBClient {

    private static ObjectMapper mapper = new ObjectMapper();

    // TODO: add real DB invocation, for now return only `pikachu`
    public static JsonNode getPokemonByName(String name) {
        String fakeMockedDBResponse = "[{\"ability\":{\"name\":\"lightning-rod\",\"url\":\"https://pokeapi.co/api/v2/ability/31/\"},\"is_hidden\":true,\"slot\":3},{\"ability\":{\"name\":\"static\",\"url\":\"https://pokeapi.co/api/v2/ability/9/\"},\"is_hidden\":false,\"slot\":1}]";
        try {
            return mapper.readTree(fakeMockedDBResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode getPokemonByNameNotMatching(String name) {
        String fakeMockedDBResponse = "[{\"ability\":{\"name\":\"lightning-rod\",\"url\":\"https://pokeapi.co/api/v2/ability/31/\"},\"is_hidden\":true,\"slot\":5},{\"ability\":{\"name\":\"static\",\"url\":\"https://pokeapi.co/api/v2/ability/9/\"},\"is_hidden\":false,\"slot\":1}]";
        try {
            return mapper.readTree(fakeMockedDBResponse);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
