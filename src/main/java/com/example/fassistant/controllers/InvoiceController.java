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

import com.example.fassistant.models.Invoice;
import com.example.fassistant.repository.InvoiceRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	InvoiceRepository invoiceRepository;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/byid")
	public ResponseEntity<?> getItemById(@Valid @RequestBody Map<String, String> payload) {

		Optional<Invoice> optional = invoiceRepository.findById(Long.valueOf(payload.get("id")));
		Invoice invoice = optional.get();

		return ResponseEntity.ok().body(invoice);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/byshopid")
	public ResponseEntity<?> getInvoiceByShopId(@Valid @RequestBody Map<String, String> payload) {

		List<Invoice> invoices = invoiceRepository.getInvoicesByShopId(payload.get("id"));
		return ResponseEntity.ok().body(invoices);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/bycustomerid")
	public ResponseEntity<?> getInvoiceByCustomerId(@Valid @RequestBody Map<String, String> payload) {

		List<Invoice> invoices = invoiceRepository.getInvoicesByCustomerId(payload.get("id"));
		return ResponseEntity.ok().body(invoices);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<?> updateInvoice(@Valid @RequestBody Map<String, String> payload) {
		Invoice invoice = null;
		if (payload.get("id") == null) {
			invoice = new Invoice();
		}else {
			Optional<Invoice> optional = invoiceRepository.findById(Long.valueOf(payload.get("id")));
			invoice = optional.get();
		}
		
		invoice.setCustomerId(payload.get("cusId"));
		invoice.setCustomer(payload.get("cusName"));
		invoice.setString2(payload.get("cusMobile"));
		invoice.setString3(payload.get("cusAddress"));
		invoice.setString1(payload.get("additionalInfo"));
		invoice.setTotalAmt(new BigDecimal(payload.get("subTotalAmt")));
		invoice.setVatAmt(new BigDecimal(payload.get("vatTotalAmt")));
		invoice.setNetAmt(new BigDecimal(payload.get("totalAmt")));
		invoice.setPaymentType(payload.get("paymentMethod"));
		invoice.setStatus(payload.get("status"));
		invoice.setInteger1(Integer.parseInt(payload.get("shipping")));
		invoice.setStatusOrder("Confirmed");
		invoice.setShop(payload.get("shop"));

		invoiceRepository.save(invoice);
		return ResponseEntity.ok().body(invoice);
	}
	
}