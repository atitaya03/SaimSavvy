package siamsavvy.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import siamsavvy.model.GeneratePlanRequest;
import siamsavvy.service.OpenAIService;

@RestController
@RequestMapping("openai")
public class OpenAIController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/generate-plan")
    public ResponseEntity<?> generatePlan(@RequestBody GeneratePlanRequest planRequest) {
        try{
            String format = "Generate a %d-day travel plan in Thailand. Focus on %s in %s, with a max distance of %.2f km. Return the result in JSON format only (start with { and end with }), including a trip object with the following fields: 'destination' (the city name), 'duration' (number of days), and 'itinerary' (an array of day plan objects). Each day plan object should include: 'day' (the day number) and 'places' (an array of place objects). Each place object should contain: 'place_name' (in Thai Language), 'location' (latitude, longitude), 'start_time', and 'end_time'.";

            String prompt = String.format(format,
                                planRequest.getNumberOfDay(), planRequest.getCategories(), planRequest.getCity(), planRequest.getMaxDistance());

            JSONObject result = openAIService.generatePlan(prompt);

            if (result != null) {
                return ResponseEntity.ok(result.toString());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating plan.");
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
