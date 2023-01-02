package com.kenzie.appserver.service;


import com.kenzie.appserver.service.model.SongInfo;
import org.springframework.stereotype.Service;


@Service
public class AppDisplayService<AppDisplayRepository> {

    private AppDisplayRepository appDisplayRepository;
    private Object SongId;
    private com.kenzie.appserver.service.model.SongInfo SongInfo;

    public AppDisplayService(AppDisplayRepository appDisplayRepository) {
        this.appDisplayRepository = appDisplayRepository;
    }

    public AppDisplayService addNewAppDisplayService(AppDisplayService appDisplayService) {
        return appDisplayService;
    }
    public SongInfo findBySongId(String id) {
        return SongInfo;
    }
}

