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

import com.example.fassistant.models.User;
import com.example.fassistant.payload.request.UserUpdateRequest;
import com.example.fassistant.payload.response.MessageResponse;
import com.example.fassistant.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserRepository userRepository;

	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<?> getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	

		Optional<User> optional = userRepository.findByUsername(userDetails.getUsername());
		User user = optional.get();

		return ResponseEntity.ok().body(user);
	}
	
//	@GetMapping("/shops")
//	public ResponseEntity<?> getShops() {
//		List<User> shops = userRepository.getShopList();
//		return ResponseEntity.ok().body(shops);
//	}
	
//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	@PostMapping("/shopbyid")
//	public ResponseEntity<?> getShopById(@Valid @RequestBody Map<String, String> payload) {
//
//		User user = userRepository.getShopById(Long.valueOf(payload.get("id")));
//		return ResponseEntity.ok().body(user);
//	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateRequest signUpRequest) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	

		Optional<User> optional = userRepository.findByUsername(userDetails.getUsername());
		User user = optional.get();
		user.setName(signUpRequest.getName());
		user.setNid(signUpRequest.getNid());
		user.setPhone(signUpRequest.getPhone());
		user.setTin(signUpRequest.getTin());
		user.setLocation(signUpRequest.getLocation());
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}
	
//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	@PostMapping("/updatecover")
//	public ResponseEntity<?> updateCover(@Valid @RequestBody Map<String, String> payload) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	
//
//		Optional<User> optional = userRepository.findByUsername(userDetails.getUsername());
//		User user = optional.get();
//		user.setImageCover(payload.get("imageCover"));
//		userRepository.save(user);
//		return ResponseEntity.ok(new MessageResponse("Cover updated successfully!"));
//	}
	
//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	@PostMapping("/updateimage")
//	public ResponseEntity<?> updateImage(@Valid @RequestBody Map<String, String> payload) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	
//
//		Optional<User> optional = userRepository.findByUsername(userDetails.getUsername());
//		User user = optional.get();
//		user.setImage(payload.get("image"));
//		userRepository.save(user);
//		return ResponseEntity.ok(new MessageResponse("Profile image updated successfully!"));
//	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/updatepassword")
	public ResponseEntity<?> updateUserPassword(@Valid @RequestBody Map<String, String> payload) {
		String newPassword = payload.get("newPassword");
		String retypePassword = payload.get("retypePassword");
		
		if (newPassword.equals(retypePassword)) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();	

			Optional<User> optional = userRepository.findByUsername(userDetails.getUsername());
			User user = optional.get();
			user.setPassword(encoder.encode(newPassword));
			userRepository.save(user);
			
			return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
		}

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new MessageResponse("Password doesn't match!"));
	}

}