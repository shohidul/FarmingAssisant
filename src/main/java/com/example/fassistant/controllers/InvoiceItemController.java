package com.example.fassistant.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fassistant.models.InvoiceItem;
import com.example.fassistant.repository.InvoiceItemRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/invoiceitems")
public class InvoiceItemController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	InvoiceItemRepository invoiceItemRepository;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/byid")
	public ResponseEntity<?> getItemById(@Valid @RequestBody Map<String, String> payload) {

		Optional<InvoiceItem> optional = invoiceItemRepository.findById(Long.valueOf(payload.get("id")));
		InvoiceItem invoiceItem = optional.get();

		return ResponseEntity.ok().body(invoiceItem);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/byinvoiceid")
	public ResponseEntity<?> getItemByInvoiceId(@Valid @RequestBody Map<String, String> payload) {

		List<InvoiceItem> invoiceItems = invoiceItemRepository.getIvoiceItemList(payload.get("id"));
		return ResponseEntity.ok().body(invoiceItems);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<?> updateInvoiceItem(@Valid @RequestBody Map<String, String> payload) {
		InvoiceItem invoiceItem = null;
		if (payload.get("id") == null) {
			invoiceItem = new InvoiceItem();
		}else {
			Optional<InvoiceItem> optional = invoiceItemRepository.findById(Long.valueOf(payload.get("id")));
			invoiceItem = optional.get();
		}
		
		invoiceItem.setInvoiceId(payload.get("invoiceId"));
		invoiceItem.setItemId(payload.get("itemId"));
		invoiceItem.setName(payload.get("itemName"));
		invoiceItem.setQuantity(new BigDecimal(payload.get("itemQty")));
		invoiceItem.setPrice(new BigDecimal(payload.get("itemPrice")));
		invoiceItem.setCategory(payload.get("itemCategory"));
		invoiceItem.setShop(payload.get("shop"));
//		System.out.println(invoiceItem);
		invoiceItemRepository.save(invoiceItem);
		return ResponseEntity.ok().body(invoiceItem);
	}
	
}