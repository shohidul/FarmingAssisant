package com.example.fassistant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByType(String type);

	Optional<Item> findById(Long id);
	
	@Query(value = "SELECT * FROM items WHERE shop=?1 and category=?2 ORDER BY short_code", nativeQuery = true)
	List<Item> getItemList(String shop, String category);
}