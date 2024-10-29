//This interface will allow you to perform CRUD operations on the SimulationResults objects stored in MongoDB. Spring Data MongoDB provides the MongoRepository interface, which you can extend for this purpose.

package com.capstone.simulationService;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SimulationResultsRepository extends MongoRepository<SimulationResults, String> {
    // Custom queries can be added here if needed
}
