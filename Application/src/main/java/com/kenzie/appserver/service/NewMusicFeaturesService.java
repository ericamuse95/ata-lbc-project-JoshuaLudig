package com.kenzie.appserver.service;


import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import com.kenzie.appserver.service.model.SongInfo;
import org.springframework.stereotype.Service;

@Service
public class NewMusicFeaturesService {

    private NewMusicFeaturesRepository newMusicFeaturesRepository;
    private NewMusicFeatures songId;
    private NewMusicFeatures NewMusicFeatures;

    /**
     * @param newMusicFeaturesRepository the repository to use
     */
    public NewMusicFeaturesService(NewMusicFeaturesRepository newMusicFeaturesRepository) {
        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
    }

    public NewMusicFeaturesService(com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository newMusicFeaturesRepository, NewMusicFeatures songId) {

        this.songId = songId;
    }

    public NewMusicFeatures findByFeatureId(String id) {
        findByFeatureId(id);
        return findByFeatureId(id);

    }

    public SongInfo findBySongId(String id) {
        return null;
    }

    public <NewMusicFeatures> NewMusicFeatures getNewMusicFeaturesRecord() {
        return (NewMusicFeatures) NewMusicFeatures;
    }

    public class NewMusicFeatures {
    }
}

