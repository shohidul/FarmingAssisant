package com.example.fassistant.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fassistant.models.Generic;
import com.example.fassistant.models.Item;
import com.example.fassistant.models.User;
import com.example.fassistant.payload.request.UserUpdateRequest;
import com.example.fassistant.payload.response.MessageResponse;
import com.example.fassistant.repository.GenericRepository;
import com.example.fassistant.repository.ItemRepository;
import com.example.fassistant.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/items")
public class ItemController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ItemRepository itemRepository;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/byid")
	public ResponseEntity<?> getItemById(@Valid @RequestBody Map<String, String> payload) {

		Optional<Item> optional = itemRepository.findById(Long.valueOf(payload.get("id")));
		Item item = optional.get();

		return ResponseEntity.ok().body(item);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/bytype")
	public ResponseEntity<?> getItemByType(@Valid @RequestBody Map<String, String> payload) {
		List<Item> items = itemRepository.findByType(payload.get("type"));
		return ResponseEntity.ok().body(items);
	}
	
	@PostMapping("/bycategory")
	public ResponseEntity<?> getItemByShop(@Valid @RequestBody Map<String, String> payload) {
		List<Item> items = itemRepository.getItemList(payload.get("shop"), payload.get("category"));
		return ResponseEntity.ok().body(items);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<?> updateItem(@Valid @RequestBody Map<String, String> payload) {
		Item item = null;
		if (payload.get("id").equals("")) {
			item = new Item();
		}else {
			Optional<Item> optional = itemRepository.findById(Long.valueOf(payload.get("id")));
			item = optional.get();
		}
		item.setCategory(payload.get("category"));
		item.setName(payload.get("name"));
		item.setDetail(payload.get("detail"));
		item.setStatus(payload.get("status"));
		item.setShortCode(payload.get("orderno"));
		item.setPrice(new BigDecimal(payload.get("price")));
		item.setVatRate(new BigDecimal(payload.get("vatRate")));
		item.setDiscountRate(new BigDecimal(payload.get("discountRate")));
		item.setShop(payload.get("shop"));
		item.setImage(payload.get("image"));
		
		itemRepository.save(item);
		return ResponseEntity.ok().body(item);
	}
	
}