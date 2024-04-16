package com.placement.placement.service;


import com.placement.placement.entity.Certificate;
import com.placement.placement.entity.Student;
import com.placement.placement.repository.CertificateRepository;
import com.placement.placement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    StudentRepository studentRepository;
    public Certificate addCertificate(Certificate certificate) {
        Student student = studentRepository.findById(certificate.getStudentId()).orElse(null);
        if(student != null){
            return certificateRepository.save(certificate);
        }else {
            return null;
        }
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }
}
