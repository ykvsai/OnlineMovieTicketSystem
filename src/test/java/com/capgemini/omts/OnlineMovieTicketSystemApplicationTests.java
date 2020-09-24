package com.capgemini.omts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.capgemini.omts.repository.TheatreRepository;
import com.capgemini.omts.service.TheatreServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineMovieTicketSystemApplicationTests {

	@Mock
	private TheatreRepository repo;

	@InjectMocks
	private TheatreServiceImpl ser;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addTheaterTest1() throws TheatreAlreadyExists {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(1001);
		theatre.setTheatreName("priya");
		theatre.setTheatreCity("Tenali");
		theatre.setManagerName("swami");
		theatre.setManagerContact("swami@xyz.com");
		when(ser.addTheatre(theatre)).thenReturn(theatre);
		assertNotEquals(null, ser.addTheatre(theatre));
	}

	@Test
	public void viewTheatersTest() throws TheatreNotFoundException, TheatreAlreadyExists {
		Theatre theatre1 = new Theatre();
		theatre1.setTheatreId(1003);
		theatre1.setTheatreName("MBD");
		theatre1.setTheatreCity("Jalandhar");
		theatre1.setManagerName("keshav");
		theatre1.setManagerContact("keshav@gca.com");

		Theatre theatre2 = new Theatre();
		theatre2.setTheatreId(1002);
		theatre2.setTheatreName("prime");
		theatre2.setTheatreCity("phagwara");
		theatre2.setManagerName("deepu");
		theatre2.setManagerContact("deepu@lpu.com");

		List<Theatre> theatreList = new ArrayList<>();
		theatreList.add(theatre1);
		theatreList.add(theatre2);

		when(repo.findAll()).thenReturn(theatreList);
		assertThat(ser.viewTheatres()).isEqualTo(theatreList);
		assertEquals(theatreList.size(), 2);
	}

}