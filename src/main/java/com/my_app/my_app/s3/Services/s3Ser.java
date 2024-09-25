package com.my_app.my_app.s3.Services;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class s3Ser {

    @Autowired
    private AmazonS3 amazonS3;

    private String bucketName = "your-s3-bucket-name";

    public String uploadMedia(MultipartFile file) throws AmazonServiceException, SdkClientException, IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); //Prende il nome del file
        amazonS3.putObject(bucketName, fileName, file.getInputStream(), null);
        return amazonS3.getUrl(bucketName, fileName).toString(); // Restituisce l'URL pubblico
    }

    public String getMediaUrl(String fileName) {
        return amazonS3.getUrl(bucketName, fileName).toString(); // Restituisce l'URL per il file specificato
    }
}
