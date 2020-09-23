package com.capgemini.omts.service;

import java.util.List;

import com.capgemini.omts.entity.Theatre;
import com.capgemini.omts.exception.TheatreAlreadyExists;
import com.capgemini.omts.exception.TheatreNotFoundException;

public interface TheatreService {

	public Theatre addTheatre(Theatre theatre) throws TheatreAlreadyExists;

	public void deleteTheatre(int theatreId) throws TheatreNotFoundException;

	public Theatre updateTheatre(Theatre theatre) throws TheatreNotFoundException;

	public List<Theatre> viewTheatres() throws TheatreNotFoundException;

}
