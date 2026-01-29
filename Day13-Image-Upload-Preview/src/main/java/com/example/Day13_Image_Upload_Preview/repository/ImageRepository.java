package com.example.Day13_Image_Upload_Preview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Day13_Image_Upload_Preview.model.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity , Long>{

}
