package com.capgemini.omts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.omts.entity.Theatre;

/*************************************************************************************************************************
 * @author Yakkala Kesava Venkata Sai
 * @since 21-September-2020
 * @Description: It is a Repository interface for Theatre module in Online Movie
 *               Ticket System
 *************************************************************************************************************************/
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

}
