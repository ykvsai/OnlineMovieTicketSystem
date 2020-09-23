package com.capgemini.omts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.omts.entity.Theatre;
import com.capgemini.omts.exception.TheatreAlreadyExists;
import com.capgemini.omts.exception.TheatreNotFoundException;
import com.capgemini.omts.repositry.TheatreRepositry;
import com.capgemini.omts.service.TheatreServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineMovieTicketSystemApplicationTests {

	@Mock
	private Theatre theatre;
	
	@Mock
	private TheatreRepositry repo;
	
	@InjectMocks
	private TheatreServiceImpl ser;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addTheaterTest1() throws TheatreAlreadyExists {
		//Theatre theatre = new Theatre();
		theatre.setTheatreId(1002);
		theatre.setTheatreName("priya");
		theatre.setTheatreCity("Tenali");
		theatre.setManagerName("swami");
		theatre.setManagerContact("swami@xyz.com");
		//Theatre th = ser.addTheatre(theatre);
		//System.out.println("th"+th);
		when(ser.addTheatre(theatre)).thenReturn(theatre);
		assertEquals(null,theatre);
		
		//Mockito.verify(ser.addTheatre(theatre));
		//System.out.println("th"+th);
		
		
	}
	
	@Test
	public void viewTheatersTest()throws TheatreNotFoundException, TheatreAlreadyExists{
		
		theatre.setTheatreId(1010);
		theatre.setTheatreName("priya");
		theatre.setTheatreCity("Tenali");
		theatre.setManagerName("swami");
		theatre.setManagerContact("swami@xyz.com");
		System.out.println("viewlist"+ser.viewTheatres().size());
		ser.addTheatre(theatre);
		assertEquals(5, ser.viewTheatres().size());
	}

}
