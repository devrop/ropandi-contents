package ropandi.contents.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ropandi.contents.entity.Role;

@Repository
public interface RoleRepository  extends MongoRepository<Role,String> {

}
