package com.example.musicproject.service;

import java.util.List;
import java.util.Optional;

import com.example.musicproject.model.Song;
import com.example.musicproject.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAll() {
        return songRepository.getAll();
    }

    public Optional<Song> getById(Integer id){
        return songRepository.getById(id);
    }

    public Song add(Song song) {
        return songRepository.add(song);
    }

    public void delete (Integer id) {
        songRepository.delete(id);
    }

    public Song update(Integer id, Song song) {
        
        song.setId(id);

        return songRepository.update(song);
    }
}
