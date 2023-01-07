package com.kenzie.appserver.service;


import com.kenzie.appserver.service.model.SongInfo;
import org.springframework.stereotype.Service;


@Service
public class AppDisplayService<AppDisplayRepository> {

    private AppDisplayRepository appDisplayRepository;
    private String SongId;
    private com.kenzie.appserver.service.model.SongInfo SongInfo;
    private AppDisplayService appDisplayService;

    public AppDisplayService(AppDisplayRepository appDisplayRepository, String songId, com.kenzie.appserver.service.model.SongInfo songInfo) {
        this.appDisplayRepository = appDisplayRepository;
        SongId = songId;
        SongInfo = songInfo;
    }

    /**
     * @param appDisplayService
     * @return
     */
    public AppDisplayService addNewAppDisplayService(AppDisplayService appDisplayService) {
        this.appDisplayService = appDisplayService;
        return appDisplayService;
    }

    /**
     * @param id
     * @return
     */
    public SongInfo findBySongId(String id) {
        return SongInfo;
    }
}

