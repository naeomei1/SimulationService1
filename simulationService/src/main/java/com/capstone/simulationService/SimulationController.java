package com.capstone.simulationService;

//will handle incoming HTTP requests related to the simulation??

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    // POST: Start a NEWWW simulation
    @PostMapping("/start")
    public ResponseEntity<String> startSimulation(@RequestBody SimulationParameters params) {
        try {
            simulationService.startSimulation(params);
            return ResponseEntity.ok("Simulation started successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Simulation failed: " + e.getMessage());
        }
    }

    // GET: all simulation results
    @GetMapping("/results")
    public ResponseEntity<List<SimulationResults>> getAllResults() {
        List<SimulationResults> results = simulationService.getAllResults();
        return ResponseEntity.ok(results);
    }

    // GETt simulation result by ID
    @GetMapping("/results/{id}")
    public ResponseEntity<SimulationResults> getResultsById(@PathVariable String id) {
        SimulationResults result = simulationService.getResultsById(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(result);
    }

    // PUT whichc is  Update simulation result by ID
    @PutMapping("/results/{id}")
    public ResponseEntity<SimulationResults> updateSimulationResult(
            @PathVariable String id,
            @RequestBody SimulationResults updatedResults) {
        SimulationResults result = simulationService.updateResults(id, updatedResults);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(result);
    }

    // DELETe simulation result by ID!!!!!!!!!!!!!
    @DeleteMapping("/results/{id}")
    public ResponseEntity<Void> deleteSimulationResult(@PathVariable String id) {
        simulationService.deleteResults(id);
        return ResponseEntity.noContent().build();
    }
}
