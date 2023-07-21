package com.example.fassistant.service;

import java.util.List;

import com.example.fassistant.models.Crop;


public interface CropService {
	
	Crop saveCrop(Crop crop);
	
	List<Crop> fatchAllCrop();
		
	Crop getCropId(Long id);

	Crop updateCropId(Long id, Crop crop);
	String deleteCrop(Long id);
	
}
