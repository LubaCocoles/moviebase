package com.vmware.moviebase;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
	private int count = 0;

	private List<Movie> movies = new ArrayList<Movie>();

	public MovieService(String title) {

	}

	public void addMovie(Movie movie) {
		count++;
		movies.add(movie);

	}

	public int getCount() {

		return count;
	}

	public void removeByName(String name) throws MovieException {
		if (count == 0)
			throw new MovieException("There are no movies in the service");
		Movie selectedMovie = null;
		for  (Movie m : movies){
			if (m.getName().equals(name)){
				movies.remove(m);
				count--;
				return;
			}
		}
					throw new MovieException(
					"There is no movie with this title in the service");
		}

}
