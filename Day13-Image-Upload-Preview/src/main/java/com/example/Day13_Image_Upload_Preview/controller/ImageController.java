package com.example.Day13_Image_Upload_Preview.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Day13_Image_Upload_Preview.model.ImageEntity;
import com.example.Day13_Image_Upload_Preview.repository.ImageRepository;
import com.example.Day13_Image_Upload_Preview.service.ImageService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageRepository repository;
	
	@Autowired
	private ImageService service;
	
	@PostMapping("/upload")
	public String uploadImage(@RequestParam MultipartFile image) throws IOException{
		String path=service.uploadImage(image);
		
		ImageEntity img=new ImageEntity();
		img.setImageName(image.getOriginalFilename());
		img.setImageType(image.getContentType());
		img.setImagePath(path);
		
		repository.save(img);
		return "image uploaded succesfully";
		
		
	}
	
	public ResponseEntity<Resource> viewImage(@PathVariable long id )  throws Exception{
		
		ImageEntity image=repository.findById(id)
				.orElseThrow(()-> new RuntimeException("image not found"));
		Path path=Paths.get(image.getImagePath());
		  Resource resource = new UrlResource(path.toUri());
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(image.getImageType()))
		        .body(resource);
		
		
		
	}
	
	

}
