package com.example.Day12_File_Upload_Download.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Day12_File_Upload_Download.model.FileEntity;

public interface FileRepository  extends JpaRepository<FileEntity ,Long>{

}
