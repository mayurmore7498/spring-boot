package com.example.Day12_File_Upload_Download.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Day12_File_Upload_Download.model.FileEntity;
import com.example.Day12_File_Upload_Download.repository.FileRepository;
import com.example.Day12_File_Upload_Download.service.FileService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileRepository repository;

    @Autowired
    private FileService service;

    // Upload
    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {

        String path = service.upload(file);

        FileEntity f = new FileEntity();
        f.setFileName(file.getOriginalFilename());
        f.setFileType(file.getContentType());
        f.setFilePath(path);

        repository.save(f);

        return "File uploaded successfully";
    }

    // Download
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id) throws Exception {

        FileEntity file = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));

        Path path = Paths.get(file.getFilePath());
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFileName() + "\"")
                .body(resource);
    }
}
