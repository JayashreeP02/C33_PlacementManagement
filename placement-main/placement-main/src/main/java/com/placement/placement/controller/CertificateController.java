package com.placement.placement.controller;


import com.placement.placement.entity.Certificate;
import com.placement.placement.repository.CertificateRepository;
import com.placement.placement.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @PostMapping("add-certificate")
    public ResponseEntity<?> addCertificate(@RequestBody Certificate  certificate){
        try{
            Certificate response = certificateService.addCertificate(certificate);
            if(response != null){
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Student not exist");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("all-certificate")
    public ResponseEntity<List<Certificate>> getAllCertificates(){
        try{
            List<Certificate> response = certificateService.getAllCertificates();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
