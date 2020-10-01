package com.capgemini.omts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.omts.entity.Theatre;
import com.capgemini.omts.exception.TheatreAlreadyExists;
import com.capgemini.omts.exception.TheatreNotFoundException;
import com.capgemini.omts.repository.TheatreRepository;
import com.capgemini.omts.util.TheatreConstants;

/*************************************************************************************************************************
 * @author Yakkala Kesava Venkata Sai
 * @since 21-September-2020
 * @Description: It is a Service implementation class for Theatre module in
 *               Online Movie Ticket System
 *************************************************************************************************************************/
@Service
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	TheatreRepository TheatreRepo;

	/*********************************************************************************************************************************
	 * @Method addTheatre
	 * @Description To add a Theatre and check if Theatre ID is not present in Data
	 *              Base
	 * @param Theatre object theatre
	 * @throws TheatreAlreadyExists
	 * @return theatre if added in data base
	 * @since 21-September-2020
	 **********************************************************************************************************************************/
	@Override
	public Theatre addTheatre(Theatre theatre) throws TheatreAlreadyExists {
		if (TheatreRepo.existsById(theatre.getTheatreId())) {
			throw new TheatreAlreadyExists(TheatreConstants.ALREADYEXIST);
		} else {
			return TheatreRepo.save(theatre);
		}
	}

	/*********************************************************************************************************************************
	 * @Method deleteTheatre
	 * @Description To delete a Theatre after verifying existence of Theatre ID in
	 *              Data Base
	 * @param integer Theatre ID
	 * @throws TheatreNotFoundException
	 * @return void
	 * @since 21-September-2020
	 **********************************************************************************************************************************/
	@Override
	public void deleteTheatre(int theatreId) throws TheatreNotFoundException {
		if (TheatreRepo.existsById(theatreId)) {
			TheatreRepo.deleteById(theatreId);
		} else {
			throw new TheatreNotFoundException(TheatreConstants.NOTFOUND);
		}
	}

	/*********************************************************************************************************************************
	 * @Method updateTheatre
	 * @Description To update a Theatre after verifying existence of Theatre ID in
	 *              Data Base
	 * @param Theatre object theatre
	 * @throws TheatreNotFoundException
	 * @return theatre if updated in data base
	 * @since 21-September-2020
	 **********************************************************************************************************************************/
	@Override
	public Theatre updateTheatre(Theatre theatre) throws TheatreNotFoundException {
		if (TheatreRepo.existsById(theatre.getTheatreId())) {
			return TheatreRepo.save(theatre);
		} else {
			throw new TheatreNotFoundException(TheatreConstants.NOTFOUND);
		}
	}

	/*********************************************************************************************************************************
	 * @Method viewTheatres
	 * @Description To view all Theatres after sorting in ascending order present in
	 *              the Data Base
	 * @throws TheatreNotFoundException
	 * @return list of all theatres in ascending order if data base is not empty
	 * @since 21-September-2020
	 **********************************************************************************************************************************/
	@Override
	public List<Theatre> viewTheatres() throws TheatreNotFoundException {
		List<Theatre> theatreList = TheatreRepo.findAll(Sort.by(Sort.Direction.ASC, "theatreId"));
		if (theatreList.isEmpty()) {
			throw new TheatreNotFoundException(TheatreConstants.NOTHEATRE);
		} else {
			return theatreList;
		}

	}

}
