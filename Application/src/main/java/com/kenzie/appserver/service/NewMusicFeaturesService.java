package com.kenzie.appserver.service;


import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import org.springframework.stereotype.Service;

@Service
public class NewMusicFeaturesService {

    private NewMusicFeaturesRepository newMusicFeaturesRepository;
    private NewMusicFeatures songId;
    private NewMusicFeatures NewMusicFeatures;

    /**
     * @param newMusicFeaturesRepository the repository to use
     * @param newMusicFeatures
     */
    public NewMusicFeaturesService(NewMusicFeaturesRepository newMusicFeaturesRepository,
                                   NewMusicFeaturesService.NewMusicFeatures newMusicFeatures) {
        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
        NewMusicFeatures = newMusicFeatures;
    }

    /**
     * @param songId the songId to use
     * @return the song info
     */

    private NewMusicFeaturesService(NewMusicFeaturesRepository newMusicFeaturesRepository,
                                    NewMusicFeatures songId, NewMusicFeaturesService.NewMusicFeatures newMusicFeatures) {

        this.songId = songId;
        NewMusicFeatures = newMusicFeatures;
    }

    /**
     * @return the song info
     */
    public static NewMusicFeaturesService createNewMusicFeaturesService() {
        return createNewMusicFeaturesService(null, null, null);
    }

    public static NewMusicFeaturesService createNewMusicFeaturesService
            (NewMusicFeaturesRepository newMusicFeaturesRepository, NewMusicFeaturesService.NewMusicFeatures songId,
             NewMusicFeaturesService.NewMusicFeatures newMusicFeatures) {
        return new NewMusicFeaturesService(newMusicFeaturesRepository, songId, newMusicFeatures);
    }

    public NewMusicFeatures findByFeatureId(String id) {
        findByFeatureId(id);
        return findByFeatureId(id);

    }

    public String findBySongId(String id) {
        return id;
    }

    public <NewMusicFeatures> NewMusicFeatures getNewMusicFeaturesRecord() {
        return (NewMusicFeatures) NewMusicFeatures;
    }

    public class NewMusicFeatures {
    }
}

