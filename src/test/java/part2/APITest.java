package part2;


import com.fasterxml.jackson.databind.JsonNode;
import com.flipkart.zjsonpatch.JsonDiff;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FakeDBClient;
import utils.HttpClient;
import utils.JsonHelper;

import java.io.IOException;

public class APITest {

    private static final String POKEMON = "pikachu";
    private static final String BASE_URL = "https://pokeapi.co";

    @Test
    public void testAPI() throws IOException {
        CloseableHttpResponse response = new HttpClient().doGet(BASE_URL + "/api/v2/pokemon/" + POKEMON);
        JsonNode jsonResponse = JsonHelper.parseJsonNode(response.getEntity().getContent());

        JsonNode actual = jsonResponse.at("/abilities");
        JsonNode expected = FakeDBClient.getPokemonByName(POKEMON);
        //JsonNode expected = FakeDBClient.getPokemonByNameNotMatching(POKEMON);

        JsonNode diff = JsonDiff.asJson(actual, expected);
        Assert.assertTrue(diff.isEmpty(), "Diff is following: "+ diff);
    }
}
