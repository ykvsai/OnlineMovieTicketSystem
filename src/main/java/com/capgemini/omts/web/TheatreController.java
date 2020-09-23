package com.capgemini.omts.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.omts.dto.TheatreMessage;
import com.capgemini.omts.entity.Theatre;
import com.capgemini.omts.exception.TheatreAlreadyExists;
import com.capgemini.omts.exception.TheatreNotFoundException;
import com.capgemini.omts.service.TheatreService;
import com.capgemini.omts.util.TheatreConstants;

@RestController
@RequestMapping("theatre")
public class TheatreController {
	
	@Autowired
	TheatreService theatreSer;
	
	@CrossOrigin
	@PostMapping(path = "/addtheatre")
	public TheatreMessage addTheatre(@RequestBody Theatre theatre, HttpServletRequest request) throws TheatreAlreadyExists{
				theatreSer.addTheatre(theatre);
				TheatreMessage msg = new TheatreMessage();
				msg.setMessage(TheatreConstants.ADDED);
				return msg;
	}
	
	@CrossOrigin
	@PutMapping(path = "/updatetheatre")
	public TheatreMessage updateTheatre(@RequestBody Theatre theatre, HttpServletRequest request) throws TheatreNotFoundException{
		theatreSer.updateTheatre(theatre);
		TheatreMessage msg = new TheatreMessage();
		msg.setMessage(TheatreConstants.UPDATED);
		return msg;
	}
	
	@CrossOrigin
	@DeleteMapping(path = "/deletetheatre/{theatreId}")
	public TheatreMessage deleteTheatre(@PathVariable int theatreId, HttpServletRequest request) throws TheatreNotFoundException{
		theatreSer.deleteTheatre(theatreId);
		TheatreMessage msg = new TheatreMessage();
		msg.setMessage(TheatreConstants.DELETED);
		return msg;
	}
	
	@CrossOrigin
	@GetMapping(path = "/viewtheatres")
	public List<Theatre> viewTheatres(HttpServletRequest request) throws TheatreNotFoundException{
		return theatreSer.viewTheatres();
	}

}
