package com.kenzie.appserver.service;


import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import com.kenzie.appserver.service.model.NewMusicFeatures;
import org.springframework.stereotype.Service;
import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;

@Service
public class NewMusicFeaturesService {

    private NewMusicFeaturesRepository newMusicFeaturesRepository;

    /**
     * @param newMusicFeaturesRepository the repository to use
     */
    public NewMusicFeaturesService(NewMusicFeaturesRepository newMusicFeaturesRepository) {
        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
    }

    public NewMusicFeatures addNewFeature(NewMusicFeatures newMusicFeatures) {
        NewMusicFeaturesRecord newMusicFeaturesRecord = new NewMusicFeaturesRecord();
        newMusicFeaturesRecord.setFeatureId(newMusicFeatures.getFeatureId());
        newMusicFeaturesRecord.setFeatureDescription(newMusicFeatures.getFeatureDescription());
        newMusicFeaturesRecord.setFeatureImage(newMusicFeatures.getFeatureImage());
        newMusicFeaturesRecord.setFeatureLink(newMusicFeatures.getFeatureLink());
        newMusicFeaturesRecord.setFeatureName(newMusicFeatures.getFeatureName());
        newMusicFeaturesRecord.setSongId(newMusicFeatures.getSongId());
        newMusicFeaturesRepository.save(newMusicFeaturesRecord);
        return newMusicFeatures;
    }

}
