package com.example.musicproject.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.example.musicproject.model.Song;

import org.springframework.stereotype.Repository;

@Repository
public class  SongRepository {

    private List<Song> songs = new ArrayList<Song>();
    private Integer lastId = 0;

    /**
     * the method returns all the songs
     * @return songs list
     */
    public List<Song> getAll() {
        return songs;
    }

    /**
     * method returns the song by its id
     * @param id of the song that will be located
     * @return returns a song if found
     */
    public Optional<Song> getById(Integer id) {
        return songs
                .stream()
                .filter(song -> song.getId() == id)
                .findFirst();
    }

    /**
     * Method to add music to the list
     * @param song song to be added
     * @return returns the song that was added to the list
     */
    public Song add(Song song) {
        lastId++;

        song.setId(lastId);
        songs.add(song);

        return song;
    }

    /**
     * Method to remove music to the list by id
     * @param id id of the music to be deleted.
     */
    public void delete (Integer id) {
        songs.removeIf(song -> song.getId() == id);
    }

    public Song update(Song song) {
        Optional<Song> songFound = getById(song.getId());

        if(songFound.isEmpty()){
            throw new InputMismatchException("Música não encontrada.");
        }

        delete(song.getId());

        songs.add(song);

        return song;
    }

}