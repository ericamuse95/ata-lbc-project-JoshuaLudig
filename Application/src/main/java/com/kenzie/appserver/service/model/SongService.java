package com.kenzie.appserver.service.model;

import com.kenzie.appserver.repositories.SongServiceRepository;
import com.kenzie.appserver.repositories.model.SongServiceRecord;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    private SongServiceRepository songServiceRepository;

    public SongService(SongServiceRepository songServiceRepository) {
        this.songServiceRepository = songServiceRepository;
    }

    public SongInfo findBySongId(String songId) {
        SongInfo songInfoFromBackend = songServiceRepository
                .findById(songId)
                .map(songService -> new SongInfo(songService.getSongId(),songService.getArtistByUserId(),
                        songService.getArtistByGenre(), songService.getArtistByYear()))
                .orElse(null);

        return songInfoFromBackend;
    }
    public List<SongInfo> findAll(){
        List<SongInfo> songInfoList = new ArrayList<>();
        songServiceRepository.findAll().forEach(songInfo -> songInfoList.add(new SongInfo(songInfo.getSongId(),songInfo.getArtistByGenre(),songInfo.getArtistByUserId(),songInfo.getArtistByYear())));
        return songInfoList;
    }

    public void addNewSong(SongInfo songInfo) {
        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId(songInfo.getSongId());
        songServiceRecord.setArtistByGenre(songInfo.getArtistByGenre());
        songServiceRecord.setArtistByUserId(songInfo.getArtistByUserId());
        songServiceRecord.setArtistByYear(songInfo.getArtistByYear());
        songServiceRepository.save(songServiceRecord);
    }
}
