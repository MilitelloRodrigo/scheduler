package ar.com.bds.repository;

import ar.com.bds.model.JobBDs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends MongoRepository<JobBDs, String> {

    Optional<JobBDs> findByName(String name);

}
