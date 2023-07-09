package com.example.fassistant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Invoice;
import com.example.fassistant.models.Item;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	//List<Item> findByType(String type);

	Optional<Invoice> findById(Long id);
	
	@Query(value = "SELECT * FROM invoices WHERE shop=?1 ORDER BY date_updated DESC", nativeQuery = true)
	List<Invoice> getInvoicesByShopId(String shop);
	
	@Query(value = "SELECT * FROM invoices WHERE customer_id=?1 ORDER BY date_updated DESC", nativeQuery = true)
	List<Invoice> getInvoicesByCustomerId(String customerId);
}