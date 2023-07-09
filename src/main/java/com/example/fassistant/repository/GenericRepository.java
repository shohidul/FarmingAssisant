package com.example.fassistant.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Generic;
import com.example.fassistant.models.User;

@Repository
public interface GenericRepository extends JpaRepository<Generic, Long> {
	List<Generic> findByType(String type);

	Optional<Generic> findById(Long id);
	
	@Query(value = "SELECT * FROM generics WHERE type='category' and shop=?1 ORDER BY row_index", nativeQuery = true)
	List<Generic> getCategoryList(String shop);
}