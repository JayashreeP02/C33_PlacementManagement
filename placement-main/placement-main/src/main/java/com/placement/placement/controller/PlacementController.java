package com.placement.placement.controller;


import com.placement.placement.entity.Placement;
import com.placement.placement.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    PlacementService placementService;

    @PostMapping("add-placement")
    public ResponseEntity<?> addPlacement(@RequestBody Placement placement){
        try{
            Placement response = placementService.addPlacement(placement);
            if(response != null){
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Student not exist!");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("all-placements")
    public ResponseEntity<List<Placement>> getAllPlacements(){
        try{
            List<Placement> response = placementService.getAllPlacements();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
