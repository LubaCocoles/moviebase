package com.vmware.moviebase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovieServiceTest {
	private MovieService movieService;

	@BeforeMethod
	public void setup() {
		// subject under test
		movieService = new MovieService("VMWare movie night");
	}

	@Test
	public void addTwoMoviesAndGetTheTotal() throws MovieException {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 2);

	}

	@Test
	public void addOneMovieAndGetTheTotal() throws MovieException {

		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 1);
	}

	@Test
	public void addTheTotalWithNoMovies() {
		assertEquals(movieService.getCount(), 0);
	}

	@Test
	public void removeAMovieAndGetTheTotal() throws MovieException {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		movieService.removeByName("Wall-E");
		assertEquals(movieService.getCount(), 1);
	}

	@Test
	public void removeAMovieFromAnEmptyService() {

		try {
			movieService.removeByName("Wall-E");
			fail("Was expecting an exception in removeAMovieFromAnEmptyService");
		} catch (MovieException e) {
			assertEquals(e.getMessage(), "There are no movies in the service");
		}
	}

	@Test
	public void removeAMovieThatDoesntExist() throws MovieException {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		try {
			movieService.removeByName("Titanic");
			fail("Was expecting an exception in removeAMovieThatDoesntExist");
		} catch (MovieException e) {
			assertEquals(e.getMessage(),
					"There is no movie with this title in the service");
		}

	}

	@Test
	public void removeAMovieThatDoesntExist2() throws MovieException {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		try {
			movieService.removeByName("Casablanca");
			fail("Was expecting an exception in removeAMovieThatDoesntExist");
		} catch (MovieException e) {
			assertEquals(e.getMessage(),
					"There is no movie with this title in the service");
		}
	}

	@Test
	public void solveTheBug2() {
	
		try {
			movieService.addMovie(new Movie("Wall-E"));
			movieService.addMovie(new Movie("Wall-E"));
			fail("Was expecting an exception in solveTheBug2");
		} catch (MovieException e) {
			assertEquals(e.getMessage(),
					"Movie already exists");
		}
	}
}
