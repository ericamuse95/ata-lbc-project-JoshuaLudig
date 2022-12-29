package com.kenzie.appserver.service;


import com.kenzie.appserver.service.model.SongInfo;
import com.kenzie.appserver.repositories.model.AppDisplayRecord;
import org.springframework.stereotype.Service;


@Service
public class AppDisplayService<AppDisplayRepository> {

    private AppDisplayRepository appDisplayRepository;
    private Object SongId;

    public AppDisplayService(AppDisplayRepository appDisplayRepository) {
        this.appDisplayRepository = appDisplayRepository;
    }

    public AppDisplayService addNewAppDisplayService(AppDisplayService appDisplayService) {
        return appDisplayService;
    }
    public SongInfo findBySongId(String id) {
        AppDisplayRecord record = appDisplayRepository.findBySongId(id);
        SongInfo songInfo = new SongInfo();
        songInfo.setSongId(record.getSongId());
        songInfo.setArtistByUserId(record.getArtistByUserId());
        songInfo.setArtistByGenre(record.getArtistByGenre());
        songInfo.setArtistByYear(record.getArtistByYear());
        return songInfo;
    }
}

