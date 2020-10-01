package com.capgemini.omts.web;

import java.util.List;

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

/*************************************************************************************************************************
 * @author Yakkala Kesava Venkata Sai
 * @since 21-September-2020
 * @Description: It is a Controller class for Theatre module in Online Movie
 *               Ticket System
 *************************************************************************************************************************/
@CrossOrigin
@RestController
@RequestMapping("theatre")
public class TheatreController {

	@Autowired
	TheatreService theatreSer;

	/*********************************************************************************************************************************
	 * @Method addTheatre
	 * @Description To add a Theatre into Data Base
	 * @param Theatre object theatre
	 * @return user defined String message
	 * @throws TheatreAlreadyExists
	 * @since 22-September-2020
	 **********************************************************************************************************************************/
	@PostMapping(path = "/addTheatre")
	public TheatreMessage addTheatre(@RequestBody Theatre theatre) throws TheatreAlreadyExists {

		theatreSer.addTheatre(theatre);
		TheatreMessage msg = new TheatreMessage();
		msg.setMessage(TheatreConstants.ADDED);
		return msg;

	}

	/*********************************************************************************************************************************
	 * @Method updateTheatre
	 * @Description To update an existing Theatre in Data Base
	 * @param Theatre object theatre
	 * @return user defined String message
	 * @since 22-September-2020
	 **********************************************************************************************************************************/
	@PutMapping(path = "/updateTheatre")
	public TheatreMessage updateTheatre(@RequestBody Theatre theatre) throws TheatreNotFoundException {

		theatreSer.updateTheatre(theatre);
		TheatreMessage msg = new TheatreMessage();
		msg.setMessage(TheatreConstants.UPDATED);
		return msg;

	}

	/*********************************************************************************************************************************
	 * @Method deleteTheatre
	 * @Description To delete a Theatre with the help of Theatre ID in Data Base
	 * @param Integer Theatre ID
	 * @return user defined String message
	 * @throws TheatreNotFoundException
	 * @since 22-September-2020
	 **********************************************************************************************************************************/
	@DeleteMapping(path = "/deleteTheatre/{theatreId}")
	public TheatreMessage deleteTheatre(@PathVariable int theatreId) throws TheatreNotFoundException {

		theatreSer.deleteTheatre(theatreId);
		TheatreMessage msg = new TheatreMessage();
		msg.setMessage(TheatreConstants.DELETED);
		return msg;

	}

	/*********************************************************************************************************************************
	 * @Method viewTheatres
	 * @Description To view all Theatres present in the Data Base
	 * @return List of all theatres present in Data Base
	 * @since 22-September-2020
	 **********************************************************************************************************************************/
	@GetMapping(path = "/viewTheatres")
	public List<Theatre> viewTheatres() throws TheatreNotFoundException {

		return theatreSer.viewTheatres();

	}

}
