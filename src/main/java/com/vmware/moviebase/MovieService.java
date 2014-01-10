package com.vmware.moviebase;

public class MovieService {
private int count = 0;
	public MovieService(String title) {
		// TODO Auto-generated constructor stub
	}

	public void addMovie(Movie movie) {
 
		count++;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		
		return count;
	}

	public void removeByName(String name) {
		// TODO Auto-generated method stub
		count--;
		
	}

}
