package com.example.musicproject.controller;

import java.util.List;
import java.util.Optional;

import com.example.musicproject.model.Song;
import com.example.musicproject.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
public class Songcontroller {
    
    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAll(){
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Song> getById(@PathVariable Integer id) {
        return songService.getById(id);
    }

    @PostMapping
    public Song add(@RequestBody Song song){
        return songService.add(song);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        
        songService.delete(id);
        return "Música com id: " + id + "foi deletado com sucesso!"; 
    }

    @PutMapping("/{id}")
    public Song update(@PathVariable Integer id, @RequestBody Song song){

        return songService.update(id, song);
    }

}
