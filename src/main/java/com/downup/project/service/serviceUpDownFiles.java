package com.downup.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class serviceUpDownFiles {

    @Value("${cod.file.storage.location}")
    String fileLocation;

    public String uploadFiles(MultipartFile file){

        String message = null;

        if (file.isEmpty()){
            message = "Arquivo vazio";
            return message;
        }
        log.info("Fazendo o upload do arquivo {}", file.getOriginalFilename());
        try{

            byte[] dados = file.getBytes();
            Path path = Paths.get(fileLocation +  file.getOriginalFilename());
            Files.write(path, dados);

            message = "Upload feito com sucesso! Arquivo " + file.getOriginalFilename() + " upado com sucesso!";


        }catch (IOException e){
            e.printStackTrace();
        }

        return message;
    }

    public InputStreamResource downloadFiles(String fileName){
        log.info("Baixando arquivo {}" + fileName);
        InputStreamResource recurso = null;

        try{

            File arquivo = new File(fileLocation + fileName);
            recurso = new InputStreamResource(new FileInputStream(arquivo));

        }catch(FileNotFoundException e){
            e.printStackTrace();

        }

        return recurso;

    }

}
