package com.example.nextgen.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.nextgen.model.User;


@Repository
public interface UserRepository extends  JpaRepository<User, Long>{
	
	@Query("from User u where u.username=:username")
	public User getUserByUsername(@Param("username")String username);

}
