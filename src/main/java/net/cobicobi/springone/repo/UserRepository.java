package net.cobicobi.springone.repo;

import net.cobicobi.springone.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
