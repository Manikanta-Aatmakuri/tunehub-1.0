package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repositories.SongsRepository;

@Service
public class SongsServiceImplementation implements SongsService {

	
	@Autowired
	SongsRepository srepo;
	@Override
	public String addSong(Songs song) {
		srepo.save(song);
		return "song is added and saved";
	}
	
	@Override
	public boolean songExists(String name) {
		if(srepo.findByName(name) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public List<Songs> getAllSongsInfo() {
		
		List<Songs> songsList = srepo.findAll();
		return songsList;
	}

	
	
	
	

}
