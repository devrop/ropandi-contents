package ropandi.contents.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import ropandi.contents.entity.UserLogin;

@Repository
public interface UserLoginRepository extends MongoRepository<UserLogin,String> {
	
	@Query("{'username' : ?0 , 'password' : ?1 }")
	List<UserLogin> findUsersByNameAndPassword(String username, String password);

}
