package siamsavvy.model;

import lombok.Data;

@Data
public class GeneratePlanRequest {
    private int numberOfDay;
    private String categories;
    private String city;
    private double maxDistance;
}
