package com.kenzie.appserver.service;


import org.springframework.stereotype.Service;


@Service
public class AppDisplayService<AppDisplayRepository> {

    private AppDisplayRepository appDisplayRepository;
    private AppDisplayService appDisplayService;
    private AppDisplayService ArtistByUserId;
    private Object SongId;
    private AppDisplayService ArtistByGenre;
    private AppDisplayService ArtistByYear;

    public AppDisplayService() {
        this.appDisplayRepository = appDisplayRepository;
    }
    public AppDisplayService getAppDisplayService() {
            return appDisplayService;
    }
    public AppDisplayRepository getAppDisplayRepository() {
        return appDisplayRepository;

    }
    public AppDisplayService findBySongId(String id) {
        return appDisplayService;
    }
    public AppDisplayService addNewAppDisplayService(AppDisplayService appDisplayService) {
        appDisplayService = new AppDisplayService();
        appDisplayService.addNewAppDisplayService((AppDisplayService) appDisplayService.getSongId());
        appDisplayService.addNewAppDisplayService(appDisplayService.getArtistByUserId());
        appDisplayRepository.equals(appDisplayService);
        return appDisplayService;
    }
    public AppDisplayService getArtistByGenre() {
        return ArtistByGenre;
    }
    public AppDisplayService getArtistByUserId() {
        return ArtistByUserId;
    }
    public AppDisplayService getArtistByYear() {
        return ArtistByYear;
    }

    private Object getSongId() {
        return SongId;
    }

}

