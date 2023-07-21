package com.example.fassistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fassistant.models.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

}
