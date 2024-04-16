package com.placement.placement.service;

import com.placement.placement.entity.College;
import com.placement.placement.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    CollegeRepository collegeRepository;


    public College addCollege(College college) {
        try {
            return collegeRepository.save(college);
        }
        catch (Exception e){
            return null;
        }
    }

    public List<College> getAllCollege() {
        try {
            return collegeRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }
}
