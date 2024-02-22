package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Songs;

public interface SongsService {
	
	public String addSong(Songs song);
	
	public boolean songExists(String name);
	
	List<Songs> getAllSongsInfo();
	


}
