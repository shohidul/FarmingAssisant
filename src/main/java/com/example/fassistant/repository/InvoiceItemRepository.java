package com.example.fassistant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.InvoiceItem;
import com.example.fassistant.models.Item;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
	//List<Item> findByType(String type);

	Optional<InvoiceItem> findById(Long id);
	
	@Query(value = "SELECT * FROM invoice_items WHERE invoice_id=?1 ORDER BY date_created", nativeQuery = true)
	List<InvoiceItem> getIvoiceItemList(String invoiceId);
}