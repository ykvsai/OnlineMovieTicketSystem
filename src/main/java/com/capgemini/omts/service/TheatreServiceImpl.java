package com.capgemini.omts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.omts.entity.Theatre;
import com.capgemini.omts.exception.TheatreNotFoundException;
import com.capgemini.omts.repositry.TheatreRepositry;

@Service
@Transactional
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	TheatreRepositry TheatreRepo;
	
	@Override
	public Theatre addTheatre(Theatre theatre) throws TheatreNotFoundException{
		if(TheatreRepo.existsById(theatre.getTheatreId())) {
			throw new TheatreNotFoundException("Already a Theatre exists with same Theatre ID");
		}else {
			return TheatreRepo.save(theatre);
		}
	}

	@Override
	public void deleteTheatre(int theatreId) throws TheatreNotFoundException{
		if(TheatreRepo.existsById(theatreId)) {
			TheatreRepo.deleteById(theatreId);
		}else {
			throw new TheatreNotFoundException("Theatre not found");
		}		
	}

	@Override
	public Theatre updateTheatre(Theatre theatre) throws TheatreNotFoundException{		
		if(TheatreRepo.existsById(theatre.getTheatreId())) {
			return TheatreRepo.save(theatre); 
		}else {
			throw new TheatreNotFoundException("Theatre not found");
		}
	}

	@Override
	public List<Theatre> viewTheatres() throws TheatreNotFoundException{
		List<Theatre> theatreList = TheatreRepo.findAll();
		if(theatreList.isEmpty()) {
			throw new TheatreNotFoundException("Theatre List is Empty");
		}else {
			return theatreList;
		}
		
	}

}
