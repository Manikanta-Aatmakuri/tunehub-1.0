package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongsService;

@Controller
public class SongsController {
	
	@Autowired
	SongsService sonserv;
	
	@PostMapping("/addsong")
	public String addUser(@ModelAttribute Songs song)
	{
		
		if((sonserv.songExists(song.getName()))== false)
		{		
		sonserv.addSong(song);
		System.out.println("Song is added");
		return "songaddsuccess";
		}
		else
		{
			return "songfail";
		}
	}

	@GetMapping("/viewsongstoadmin")
	public String getAllSongInfo(Model model)
	{
		List<Songs> songsList = sonserv.getAllSongsInfo();
		System.out.println(songsList);
		model.addAttribute("songsList", songsList);
		return "displaysongs";
	}
	
	@GetMapping("/viewsongstocustomer")
	public String viewAllSongs(Model model)
	{
		boolean primeStatus = true;
		if(primeStatus == true)
		{
		List<Songs> songsList = sonserv.getAllSongsInfo();
		System.out.println(songsList);
		model.addAttribute("songsList", songsList);
		return "displaysongs";
		}
		else
		{
			return "makepayment";
		}
	}
	
		
	
}
