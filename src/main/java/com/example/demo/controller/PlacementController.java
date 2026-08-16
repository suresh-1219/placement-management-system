package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PlacementDTO;
import com.example.demo.service.PlacementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @PostMapping
    public PlacementDTO addPlacement(@Valid @RequestBody PlacementDTO placement) {
        return placementService.addPlacement(placement);
    }

    @GetMapping
    public List<PlacementDTO> getPlacements() {
        return placementService.getPlacement();
    }

    @PutMapping("/{id}")
    public PlacementDTO updatePlacement(
            @PathVariable Long id,
            @Valid @RequestBody PlacementDTO placement) {
        return placementService.updatePlacement(id, placement);
    }

    @DeleteMapping("/{id}")
    public void deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
    }
}