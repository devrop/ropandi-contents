package ropandi.contents.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ropandi.contents.entity.Vehicle;
@Repository
public interface VehicleRepository  extends MongoRepository<Vehicle,String> {

}
