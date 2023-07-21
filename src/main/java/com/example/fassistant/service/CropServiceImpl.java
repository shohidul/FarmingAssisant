package com.example.fassistant.service;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.fassistant.models.Crop;
import com.example.fassistant.repository.CropRepository;
@Service
public class CropServiceImpl implements CropService {

	@Autowired
	private CropRepository cropRepository;

	@Override
	public Crop saveCrop(Crop crop) {
		return cropRepository.save(crop);
	}

	@Override
	public List<Crop> fatchAllCrop() {
		List<Crop> allCrop = cropRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
		return allCrop;
	}

	@Override
	public Crop getCropId(Long id) {
		java.util.Optional<Crop>crop=cropRepository.findById(id);
		if(crop.isPresent()) {
			return crop.get();
		}
		return null;
	}

	@Override
	public Crop updateCropId(Long id, Crop crop) {
		java.util.Optional<Crop>crop1=cropRepository.findById(id);
		if(crop1.isPresent()) {
			Crop originalCrop=crop1.get();
			if (Objects.nonNull(crop.getName()) && !"".equalsIgnoreCase(crop.getName())) {
				originalCrop.setName(crop.getName());
				System.out.println(crop.getName() + "crop");
			}
			if (Objects.nonNull(crop.getSeedRequirements()) && !"".equalsIgnoreCase(crop.getSeedRequirements())) {
				originalCrop.setSeedRequirements(crop.getSeedRequirements());
			}
			if (Objects.nonNull(crop.getTimeToMaturity()) && !"".equalsIgnoreCase(crop.getTimeToMaturity())) {
				originalCrop.setTimeToMaturity(crop.getTimeToMaturity());
			}
			if (Objects.nonNull(crop.getSuitableSeasons())) {
				originalCrop.setSuitableSeasons(crop.getSuitableSeasons());
			}
			if (Objects.nonNull(crop.getSuitableSoilTypes())) {
				originalCrop.setSuitableSoilTypes(crop.getSuitableSoilTypes());
			}
			if (Objects.nonNull(crop.getPesticides())) {
				originalCrop.setPesticides(crop.getPesticides());
			}
			if (Objects.nonNull(crop.getCreatedDate())) {
				originalCrop.setCreatedDate(crop.getCreatedDate());
			}
			if (Objects.nonNull(crop.getUpdatedDate())) {
				originalCrop.setUpdatedDate(crop.getUpdatedDate());
			}
			
			return cropRepository.save(originalCrop);
		}

		return null;
	}

	@Override
	public String deleteCrop(Long id) {
		if(cropRepository.findById(id).isPresent()){
			cropRepository.deleteById(id);
		}
		return null;
	}

}
