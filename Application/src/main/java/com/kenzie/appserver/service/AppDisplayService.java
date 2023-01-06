package com.kenzie.appserver.service;


import com.kenzie.appserver.repositories.AppDisplayRepository;
import com.kenzie.appserver.repositories.ExampleRepository;
import com.kenzie.appserver.service.model.SongInfo;
import org.springframework.stereotype.Service;


@Service
public class AppDisplayService {
    private AppDisplayRepository appDisplayRepository;

    public AppDisplayService(AppDisplayRepository appDisplayRepository) {
        this.appDisplayRepository = appDisplayRepository;
    }
    private SongInfo SongId;
    private com.kenzie.appserver.service.model.SongInfo SongInfo;

    public AppDisplayService addNewAppDisplayService(AppDisplayService appDisplayService) {
        return appDisplayService;
    }
    public SongInfo findBySongId(String id) {
        return SongInfo;
    }
}

