package com.placement.placement.controller;


import com.placement.placement.entity.College;
import com.placement.placement.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @PostMapping("add-college")
    public ResponseEntity<?> addCollege(@RequestBody College college){
        try{
            College response = collegeService.addCollege(college);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @GetMapping("all-colleges")
    public ResponseEntity<List<College>> getAllCollege(){
        try {
            List<College> response = collegeService.getAllCollege();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
