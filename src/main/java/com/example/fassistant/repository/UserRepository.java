package com.example.fassistant.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Generic;
import com.example.fassistant.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
  
//	@Query(value = "SELECT * FROM users WHERE type='shop'", nativeQuery = true)
//	List<User> getShopList();
//	
//	@Query(value = "SELECT * FROM users WHERE type='shop' and id=?", nativeQuery = true)
//	User getShopById(Long id);
}