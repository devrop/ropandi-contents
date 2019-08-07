package ropandi.contents.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ropandi.contents.entity.Menu;




@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

}
