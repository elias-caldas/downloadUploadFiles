package com.downup.project.controller;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.downup.project.service.serviceUpDownFiles;

import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class controllerFile {
    @Autowired
    serviceUpDownFiles service;

    @Autowired
    ServletContext servletContext;

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("arquivo") MultipartFile arquivo){
        log.info("Upload arquivo {}", arquivo.getOriginalFilename());
        return service.uploadFiles(arquivo);
    }

    @GetMapping("/downloadarquivo/{nomeArquivo}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable("nomeArquivo") String nomeArquivo){
     log.info("Baixando arquivo {}", nomeArquivo);
     InputStreamResource recurso  = service.downloadFiles(nomeArquivo);
     return ResponseEntity.ok().contentType(getMediaTypeForFileName(servletContext, nomeArquivo))
     .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + nomeArquivo).body(recurso);
    }

    private MediaType getMediaTypeForFileName(ServletContext servletContext, String nomeArquivo){
        String type = servletContext.getMimeType(nomeArquivo);
        try{
            MediaType mediaType = MediaType.parseMediaType(type);
            return mediaType;
        }catch(Exception e){
            return MediaType.APPLICATION_OCTET_STREAM;
        }

}
    
}
