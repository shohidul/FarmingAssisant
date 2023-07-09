package com.example.fassistant;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.fassistant.service.FilesStorageService;

@SpringBootApplication
public class FarmingAssistantApplication  implements CommandLineRunner{
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FarmingAssistantApplication.class, args);
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "dnbgoewwn",
				  "api_key", "881599265691226",
				  "api_secret", "Ff3g19ZsymZwDB-KTgYOnRUG2PA"));
	}
	
	  @Override
	  public void run(String... arg) throws Exception {
	    //storageService.deleteAll();
	    //storageService.init();
	  }

}
