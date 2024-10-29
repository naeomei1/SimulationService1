package com.capstone.simulationService;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "simulation_results")  // lets be speceficc on  the collection name
public class SimulationResults {

    @Id  
    private String id;
    private List<BodyState> bodyStates; // Assuming BodyState is already defined

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public List<BodyState> getBodyStates() {
        return bodyStates;
    }

    


    public void setBodyStates(List<BodyState> bodyStates) {
        this.bodyStates = bodyStates;
    }




}
