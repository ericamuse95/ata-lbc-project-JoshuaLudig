package com.kenzie.appserver.service;


import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import com.kenzie.appserver.service.model.NewMusicFeatures;
import org.springframework.stereotype.Service;
import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;

import java.util.ArrayList;
import java.util.List;

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

    public NewMusicFeatures findById(String id) {
        NewMusicFeatures newMusicFeaturesFromBackend = newMusicFeaturesRepository.findById(id)
                .map(newmusicfeatures -> new NewMusicFeatures(newmusicfeatures.getSongId(),newmusicfeatures.getFeatureName(),newmusicfeatures.getFeatureId(),
                        newmusicfeatures.getFeatureDescription(),newmusicfeatures.getFeatureImage(),newmusicfeatures.getFeatureLink()))
                .orElse(null);
        return newMusicFeaturesFromBackend;
    }

    public List<NewMusicFeatures> findAllFeatures(){
        List<NewMusicFeatures> musicFeaturesList = new ArrayList<>();
        newMusicFeaturesRepository.findAll().forEach(newmusicfeatures -> musicFeaturesList.add(new NewMusicFeatures(newmusicfeatures.getSongId(),newmusicfeatures.getFeatureName(),newmusicfeatures.getFeatureId(),newmusicfeatures.getFeatureDescription(),
                newmusicfeatures.getFeatureImage(), newmusicfeatures.getFeatureLink())));
        return musicFeaturesList;
    }

}
