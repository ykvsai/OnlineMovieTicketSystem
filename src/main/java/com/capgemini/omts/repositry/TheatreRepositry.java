package com.capgemini.omts.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.omts.entity.Theatre;

@Repository
public interface TheatreRepositry extends JpaRepository<Theatre, Integer> {

}
