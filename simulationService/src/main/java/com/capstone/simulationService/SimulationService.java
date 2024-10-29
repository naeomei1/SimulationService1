package com.capstone.simulationService;

//this class will handle the logic for starting the simulation and saving the results to MongoDB.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationService {

    @Autowired
    private SimulationResultsRepository resultsRepository; 

    public SimulationResults startSimulation(SimulationParameters params) {
        // Mock BodyState creation
        List<BodyState> bodyStates = new ArrayList<>(); 
        BodyState mockBodyState = new BodyState(); // Assuming BodyState class is defined properly
        bodyStates.add(mockBodyState); // Add mock data

        // Create a new SimulationResults object and populate it
        SimulationResults results = new SimulationResults();
        results.setBodyStates(bodyStates); // Set mock body states

        // Save to the repository
        return resultsRepository.save(results); 
    }

    public List<SimulationResults> getAllResults() {
        return resultsRepository.findAll();
    }

    public SimulationResults getResultsById(String id) {
        return resultsRepository.findById(id).orElse(null);
    }

    public SimulationResults updateResults(String id, SimulationResults updatedResults) {
        if (resultsRepository.existsById(id)) {
            updatedResults.setId(id); 
            return resultsRepository.save(updatedResults); 
        }
        return null; 
    }

    public void deleteResults(String id) {
        resultsRepository.deleteById(id);
    }
}
