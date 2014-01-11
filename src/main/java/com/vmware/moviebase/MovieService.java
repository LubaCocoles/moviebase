package com.vmware.moviebase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieService {
	private int count = 0;

	// private List<Movie> movies = new ArrayList<Movie>(); allows duplicates
	// private Set<Movie> movies = new HashSet<Movie>();
	// better
	private Set<String> movies = new HashSet<String>();

	public MovieService(String title) {

	}

	public void addMovie(Movie movie) throws MovieException {
		// count++; don't need it anymore
		if (movies.contains(movie.getName()))
			throw new MovieException ("Movie already exists");
		movies.add(movie.getName());

	}

	public int getCount() {

		return movies.size();
	}

	public void removeByName(String name) throws MovieException {
		if (getCount() == 0)
			throw new MovieException("There are no movies in the service");
		if (!movies.remove(name)) {
			throw new MovieException(
					"There is no movie with this title in the service");
		}
	}
}
