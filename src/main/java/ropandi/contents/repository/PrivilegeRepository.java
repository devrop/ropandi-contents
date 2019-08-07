package ropandi.contents.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ropandi.contents.entity.Privilege;


@Repository
public interface PrivilegeRepository extends MongoRepository<Privilege, String> {

}
