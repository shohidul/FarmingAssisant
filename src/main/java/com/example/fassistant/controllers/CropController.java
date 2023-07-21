package com.example.fassistant.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fassistant.models.Crop;
import com.example.fassistant.service.CropService;

@CrossOrigin
@RestController
public class CropController {

	@Autowired
	private CropService cropService;

	@PostMapping("/crop")
	public Crop saveCrop(@RequestBody Crop crop) {
		System.out.println("saveCrop " + crop);
		return cropService.saveCrop(crop);
	}

	@GetMapping("/crop")
	public List<Crop> getAllCrop() {
		return cropService.fatchAllCrop();
	}

	@CrossOrigin
	@GetMapping("/crop/{id}")
	public ResponseEntity<Crop> getCropById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(cropService.getCropId(id));
	}
	@PutMapping("/updateCropNotification/{id}")
	public Crop updateCropNotification(@PathVariable("id") Long id, @RequestBody Map<String, String> body) {
		Crop crop = cropService.getCropId(id);
		//crop.setNotification(Integer.parseInt(body.get("count")));
		return cropService.updateCropId(id, crop);
	}
	@PutMapping("/crop/{id}")
	public Crop updateCrop(@PathVariable("id") Long id, @RequestBody Crop crop) {
		System.out.println("updateCrop " + crop);
		return cropService.updateCropId(id, crop);
	}
	
	@DeleteMapping("/crop/{id}")
	public String deleteCrop(@PathVariable("id")Long id){
		return cropService.deleteCrop(id);
	}

}
