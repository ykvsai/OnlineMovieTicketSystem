package com.capgemini.omts;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.omts.entity.Theatre;
import com.capgemini.omts.exception.TheatreAlreadyExists;
import com.capgemini.omts.repositry.TheatreRepositry;
import com.capgemini.omts.service.TheatreServiceImpl;

@SpringBootTest
class OnlineMovieTicketSystemApplicationTests {

	@Mock
	private Theatre theatre;
	
	@Mock
	private TheatreRepositry repo;
	
	@InjectMocks
	private TheatreServiceImpl ser;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void contextLoads() {
		
		theatre.setTheatreId(1005);
		theatre.setTheatreName("priya");
		theatre.setTheatreCity("Tenali");
		theatre.setManagerName("swami");
		theatre.setManagerContact("swami@xyz.com");
		when(repo.save(theatre)).thenReturn(theatre);
		assertThrows(TheatreAlreadyExists.class,()-> {ser.addTheatre(theatre);});
		
	}

}
