package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.GetSongDownloadResponse;
import com.kenzie.appserver.controller.model.SongDownloadCreateRequest;
import com.kenzie.appserver.controller.model.SongDownloadResponse;

import com.kenzie.appserver.service.NewMusicFeaturesService;
import com.kenzie.appserver.service.model.SongInfo;
import com.kenzie.appserver.service.model.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/song")
public class SongDownloadController {

    private SongService songService;


    SongDownloadController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/{songId}")
    public ResponseEntity<SongDownloadResponse> getSongById(@PathVariable("songId") String songId) {


        SongInfo songInfo = songService.findBySongId(songId);
        if (songId == null) {
            return ResponseEntity.notFound().build();
        }

        SongDownloadResponse songDownloadResponse = new SongDownloadResponse();
        songDownloadResponse.setSongId(songInfo.getSongId());

        return ResponseEntity.ok(songDownloadResponse);
    }

    @PostMapping
    public ResponseEntity<SongDownloadResponse> addNewSong(@RequestBody SongDownloadCreateRequest songDownloadCreateRequest) {
        SongInfo songInfo = new SongInfo(songDownloadCreateRequest.getSongId(),
                songDownloadCreateRequest.getArtistId(), songDownloadCreateRequest.getArtistByYear(),
                songDownloadCreateRequest.getArtistByGenre());

        SongDownloadResponse songDownloadResponse = new SongDownloadResponse();

        songDownloadResponse.setSongId(songInfo.getSongId());
        songDownloadResponse.setArtistId(songInfo.getArtistByUserId());
        songDownloadResponse.setArtistByYear(songInfo.getArtistByYear());
        songDownloadResponse.setArtistByGenre(songInfo.getArtistByGenre());

        return ResponseEntity.created(URI.create("/songId/" + songDownloadResponse.getSongId())).body(songDownloadResponse);
    }

    @GetMapping("/songId/all")
    public ResponseEntity<List<SongDownloadResponse>> getAllSongs() {
        List<SongInfo> songInfoList = songService.findAll();
        List<SongDownloadResponse> responses = new ArrayList<>();
        for(SongInfo songInfo : songInfoList) {
            SongDownloadResponse songDownloadResponse = createSongDownloadResponse(songInfo);
            responses.add(songDownloadResponse);
        }
        return ResponseEntity.ok(responses);
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
