package com.ecommerce.library.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.InputStream;

@Component
public class ImageUpload {
    private final String UPLOAD_FOLDER = "D:\\IdeaProjects\\Ecommerce-Springboot\\Library\\src\\main\\java\\com\\ecommerce\\library\\utils\\img";

    public boolean uploadFile(MultipartFile file) {
        boolean isUpload = false;
        try (InputStream in = file.getInputStream()) {
            File destinationFile = new File(UPLOAD_FOLDER + File.separator + file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(in, destinationFile);
            isUpload = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpload;
    }

    public boolean checkExist(MultipartFile multipartFile) {
        boolean isExist = false;
        try {
            File file = new File(UPLOAD_FOLDER + File.separator + multipartFile.getOriginalFilename());
            isExist = file.exists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
}