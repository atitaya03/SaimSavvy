package siamsavvy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public JSONObject generatePlan(String prompt){
        try {
            // Construct the request body
            String requestBody = "{\n" +
                    "  \"model\": \"gpt-4o-mini\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt + "\"}\n" +
                    "  ]\n" +
                    "}";

            // Set up the headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + openAiApiKey);

            // Set up the HTTP entity with headers and body
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            // Create RestTemplate instance and make the POST request to OpenAI
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                    OPENAI_API_URL,
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            // Return the response body from OpenAI as a JSON response
            String responseBody = response.getBody();
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray choices = jsonResponse.getJSONArray("choices");
            String content = choices.getJSONObject(0).getJSONObject("message").getString("content");
            JSONObject jsonObject = new JSONObject(content);

            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
