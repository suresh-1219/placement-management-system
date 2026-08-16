package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PlacementDTO;
import com.example.demo.entity.Placement;
import com.example.demo.exception.PlacementNotFoundException;
import com.example.demo.repository.PlacementRepository;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public PlacementDTO addPlacement(PlacementDTO dto) {
        Placement placement = convertToEntity(dto);
        Placement saved = placementRepository.save(placement);
        return convertToDTO(saved);
    }

    public List<PlacementDTO> getPlacement() {
        return placementRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deletePlacement(long id) {
        Placement existing = placementRepository.findById(id)
                .orElseThrow(() ->
                        new PlacementNotFoundException("Placement not found with id : " + id));
        placementRepository.delete(existing);
    }

    public PlacementDTO updatePlacement(Long id, PlacementDTO dto) {
        Placement existing = placementRepository.findById(id)
                .orElseThrow(() ->
                        new PlacementNotFoundException("Placement not found with id : " + id));

        existing.setName(dto.getName());
        existing.setDate(dto.getDate());
        existing.setQualification(dto.getQualification());
        existing.setYear(dto.getYear());

        Placement updated = placementRepository.save(existing);
        return convertToDTO(updated);
    }

    private PlacementDTO convertToDTO(Placement p) {
        return new PlacementDTO(p.getId(), p.getName(), p.getDate(), p.getQualification(), p.getYear());
    }

    private Placement convertToEntity(PlacementDTO dto) {
        Placement p = new Placement();
        p.setName(dto.getName());
        p.setDate(dto.getDate());
        p.setQualification(dto.getQualification());
        p.setYear(dto.getYear());
        return p;
    }
}