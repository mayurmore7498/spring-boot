package com.example.Day13_Image_Upload_Preview.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	private final String uploadDir="uploads/";
	
	
	public String uploadImage(MultipartFile file) throws IOException{
		
		Files.createDirectories(Paths.get(uploadDir));
		
		String fileName=System.currentTimeMillis()+"-"+file.getOriginalFilename();
		String filePath=uploadDir+fileName;
		
		file.transferTo(new File(filePath));
		
		return filePath;
		
		
	}

}
