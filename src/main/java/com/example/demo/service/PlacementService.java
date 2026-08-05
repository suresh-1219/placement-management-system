package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Placement;
import com.example.demo.repository.PlacementRepository;

@Service
public class PlacementService {
	
	@Autowired
	public PlacementRepository prepo;

	public Placement addPlacement(Placement pla)
	{
		
		return prepo.save(pla);
	}
	
	public List<Placement> getPlacement()
	{
		return prepo.findAll();
	}

	public void deletePlacement(long id)
	{
		prepo.deleteById(id);
	}
	
	public Placement updatePlacement(Placement pla)
	{
	    Long plaid=pla.getId();
	    Placement pla1=prepo.findById(plaid).get();
	    pla1.setName(pla.getName());
	    pla1.setDate(pla.getDate());
	    pla1.setQualification(pla.getQualification());
	    pla1.setYear(pla.getYear());
	    return prepo.save(pla1);
	}
}
