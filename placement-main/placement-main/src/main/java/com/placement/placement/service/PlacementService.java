package com.placement.placement.service;


import com.placement.placement.entity.Placement;
import com.placement.placement.entity.Student;
import com.placement.placement.repository.PlacementRepository;
import com.placement.placement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    @Autowired
    PlacementRepository placementRepository;

    @Autowired
    StudentRepository studentRepository;


    public Placement addPlacement(Placement placement) {
        Student student = studentRepository.findById(placement.getStudentId()).orElse(null);
        if(student != null){
            return placementRepository.save(placement);
        }else {
            return null;
        }
    }

    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }
}
