package com.example.fassistant.controllers;

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
import com.example.fassistant.models.User;
import com.example.fassistant.payload.request.UserUpdateRequest;
import com.example.fassistant.payload.response.MessageResponse;
import com.example.fassistant.repository.GenericRepository;
import com.example.fassistant.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/generics")
public class GenericController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	GenericRepository genericRepository;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/byid")
	public ResponseEntity<?> getGenericById(@Valid @RequestBody Map<String, String> payload) {

		Optional<Generic> optional = genericRepository.findById(Long.valueOf(payload.get("id")));
		Generic generic = optional.get();

		return ResponseEntity.ok().body(generic);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/bytype")
	public ResponseEntity<?> getGenericByType(@Valid @RequestBody Map<String, String> payload) {
		List<Generic> generics = genericRepository.findByType(payload.get("type"));
		return ResponseEntity.ok().body(generics);
	}
	
	@PostMapping("/byshop")
	public ResponseEntity<?> getGenericByShop(@Valid @RequestBody Map<String, String> payload) {
		List<Generic> generics = genericRepository.getCategoryList(payload.get("shop"));
		return ResponseEntity.ok().body(generics);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<?> updateGeneric(@Valid @RequestBody Map<String, String> payload) {
		Generic generic = null;
		if (payload.get("id").equals("")) {
			generic = new Generic();
		}else {
			Optional<Generic> optional = genericRepository.findById(Long.valueOf(payload.get("id")));
			generic = optional.get();
		}
		generic.setType(payload.get("type"));
		generic.setName(payload.get("name"));
		generic.setStatus(payload.get("status"));
		generic.setRowIndex(payload.get("orderno"));
		generic.setShop(payload.get("shop"));
		generic.setImage(payload.get("image"));
		
		genericRepository.save(generic);
		return ResponseEntity.ok().body(generic);
	}
	
}