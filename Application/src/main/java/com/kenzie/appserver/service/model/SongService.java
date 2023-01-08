package com.kenzie.appserver.service.model;

import com.kenzie.appserver.repositories.SongServiceRepository;
import com.kenzie.appserver.repositories.model.SongServiceRecord;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongServiceRepository songServiceRepository;

    public SongService(SongServiceRepository songServiceRepository) {
        this.songServiceRepository = songServiceRepository;
    }

    public SongInfo findBySongId(String songId) {

        return songServiceRepository
                .findById(songId)
                .map(songService -> new SongInfo(songService.getSongId(),songService.getArtistByUserId(),
                        songService.getArtistByGenre(), songService.getArtistByYear(), songService.getIsFavorite()))
                .orElse(null);
    }

    public SongInfo findArtistByUserId(String artistByUserId) {

        return songServiceRepository
                .findById(artistByUserId)
                .map(songService -> new SongInfo(songService.getSongId(),songService.getArtistByUserId(),
                        songService.getArtistByGenre(), songService.getArtistByYear(), songService.getIsFavorite()))
                .orElse(null);
    }
    public SongInfo findArtistByGenre(String artistByGenre) {

        return songServiceRepository
                .findById(artistByGenre)
                .map(songService -> new SongInfo(songService.getSongId(),songService.getArtistByUserId(),
                        songService.getArtistByGenre(), songService.getArtistByYear(), songService.getIsFavorite()))
                .orElse(null);
    }

    public SongInfo findArtistByYear(String findArtistByYear) {

        return songServiceRepository
                .findById(findArtistByYear)
                .map(songService -> new SongInfo(songService.getSongId(),songService.getArtistByUserId(),
                        songService.getArtistByGenre(), songService.getArtistByYear(), songService.getIsFavorite()))
                .orElse(null);
    }

    public List<SongInfo> findAll(){
        List<SongInfo> songInfoList = new ArrayList<>();
        songServiceRepository.findAll().forEach(songInfo -> songInfoList.add(new SongInfo(songInfo.getSongId(),songInfo.getArtistByGenre(),songInfo.getArtistByUserId(),songInfo.getArtistByYear(), songInfo.getIsFavorite())));
        return songInfoList;
    }

    public void addNewSong(SongInfo songInfo) {
        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId(songInfo.getSongId());
        songServiceRecord.setArtistByGenre(songInfo.getArtistByGenre());
        songServiceRecord.setArtistByUserId(songInfo.getArtistByUserId());
        songServiceRecord.setArtistByYear(songInfo.getArtistByYear());
        songServiceRecord.setIsFavorite(songInfo.getIsFavorite());
        songServiceRepository.save(songServiceRecord);
    }

    public void deleteSong(String songId){

        Optional<SongServiceRecord> recordOptional = songServiceRepository.findById(songId);

        if(!recordOptional.isPresent()){
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), "Song does not exist.");
        }
        songServiceRepository.deleteById(songId);
    }

    public List<SongInfo> getFavoriteSongs(){

        List<SongInfo> favoriteSongInfoList = new ArrayList<>();
        for (SongInfo song : findAll()){
            if (song.getIsFavorite()){
                favoriteSongInfoList.add(song);
            }
        }
        return favoriteSongInfoList;
    }
}
