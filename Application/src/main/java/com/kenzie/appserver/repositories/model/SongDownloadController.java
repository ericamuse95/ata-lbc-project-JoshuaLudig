package com.kenzie.appserver.repositories.model;

import com.kenzie.appserver.controller.model.ExampleCreateRequest;
import com.kenzie.appserver.controller.model.ExampleResponse;
import com.kenzie.appserver.service.ExampleService;

import com.kenzie.appserver.service.NewMusicFeaturesService;
import com.kenzie.appserver.service.model.Example;
import com.kenzie.appserver.service.model.SongInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("song")
public class SongDownloadController {

    private NewMusicFeaturesService newMusicFeaturesService;

    SongDownloadController(NewMusicFeaturesService newMusicFeaturesService) {
        this.newMusicFeaturesService = newMusicFeaturesService;
    }

    @GetMapping("/{songId}")
    public ResponseEntity<GetSongDownloadResponse> get(@PathVariable("songId") String songId) {
    //maybe a findBySongID method in NewMusicFeatureService
        SongInfo song  = newMusicFeaturesService.findBySongId(songId);


        if (song == null) {
            return ResponseEntity.notFound().build();
        }
        GetSongDownloadResponse response = createGetSongDownloadResponse(song);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SongDownloadResponse> addNewSong(@RequestBody SongDownloadResponse songDownloadResponse) {
        SongInfo song = new SongInfo();
        song.setSongId(songDownloadResponse.getSongId());
        song.setArtistByUserId(songDownloadResponse.getArtistId());
        song.setArtistByYear(songDownloadResponse.getArtistByYear());
        song.setArtistByGenre(songDownloadResponse.getArtistByGenre());


        return ResponseEntity.created(URI.create("/songId/" + songDownloadResponse.getSongId())).body(songDownloadResponse);
    }


    private SongDownloadResponse createSongDownloadResponse(SongInfo songInfo) {
        SongDownloadResponse songDownloadResponse = new SongDownloadResponse();
        songDownloadResponse.setSongId(songInfo.getSongId());
        songDownloadResponse.setArtistId(songInfo.getArtistByUserId());
        songDownloadResponse.setArtistByYear(songInfo.getArtistByYear());
        songDownloadResponse.setArtistByGenre(songInfo.getArtistByGenre());
        return songDownloadResponse;
    }
    private GetSongDownloadResponse createGetSongDownloadResponse(SongInfo songInfo){
        GetSongDownloadResponse songDownloadResponse = new GetSongDownloadResponse();
        songDownloadResponse.setSongId(songInfo.getSongId());
        songDownloadResponse.setArtistId(songInfo.getArtistByUserId());
        songDownloadResponse.setArtistByYear(songInfo.getArtistByYear());
        songDownloadResponse.setArtistByGenre(songInfo.getArtistByGenre());
        return songDownloadResponse;
    }


}
