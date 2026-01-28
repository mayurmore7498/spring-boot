package com.example.Day12_File_Upload_Download.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	private final String uploadDir= "uploads/";
	
	public String upload(MultipartFile file) throws IOException{
		Files.createDirectories(Paths.get(uploadDir));
		
		String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
		String filePath=uploadDir+fileName;
		
		file.transferTo(new File(filePath));
		
		return filePath;
		
		
	}

}
