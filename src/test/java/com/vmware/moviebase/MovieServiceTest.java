package com.vmware.moviebase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MovieServiceTest {
	private MovieService movieService;
	
	@BeforeMethod
	public void setup(){
		//subject under test
		movieService = new MovieService("VMWare movie night");	
	}
	@Test
	public void addTwoMoviesAndGetTheTotal() throws Exception {
		movieService.addMovie(new Movie("E.T. - The Extra Terrestrial"));
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 2);
		
	}
	@Test
	public void addOneMovieAndGetTheTotal() throws Exception{
		
		movieService.addMovie(new Movie("Wall-E"));
		assertEquals(movieService.getCount(), 1);
	}
	@Test
	public void addTheTotalWithNoMovies() throws Exception{
		assertEquals(movieService.getCount(), 0);
	}
		
	
}
