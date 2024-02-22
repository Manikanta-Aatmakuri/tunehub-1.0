package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongsService;

@Controller
public class PlaylistController 
{
	
	@Autowired
	PlaylistService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model)
	{
		List<Songs> songslist = sserv.getAllSongsInfo();
		model.addAttribute("songslist", songslist);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		return "playlistsuccess";
	}
	

}
