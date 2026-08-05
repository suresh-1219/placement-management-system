package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Placement;
import com.example.demo.service.PlacementService;

@RestController
public class PlacementController {
    
	@Autowired
	public PlacementService pser;
	
	@PostMapping("/addpla")
	public Placement regPlacement(@RequestBody Placement pla)
	{
		return pser.addPlacement(pla);
		
	}
	
	@GetMapping("/getpla")
	public List<Placement> getpla()
	{
		return pser.getPlacement();
	}
	
	@DeleteMapping("deletepla/{id}")
	public void deletePla(@PathVariable Long id)
	{
		pser.deletePlacement(id);
	
	}
	
	@PutMapping("/updatepla")
	public Placement updatePla(@RequestBody Placement pla)
	{
		return pser.updatePlacement(pla);
	}
}
