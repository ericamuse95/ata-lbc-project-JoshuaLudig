package com.kenzie.appserver.service;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewMusicFeaturesService {

    private NewMusicFeaturesRepository newMusicFeaturesRepository;

    public NewMusicFeaturesService(NewMusicFeaturesRepository newMusicFeaturesRepository) {
        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
    }

    public <NewMusicFeatures> NewMusicFeaturesService(Object newMusicFeaturesRepository) {

    }

    public NewMusicFeatures findByFeatureId(String id) {
        NewMusicFeatures newMusicFeaturesFromBackend = newMusicFeaturesRepository
                .findByfeatureId(id)
                .map(newMusicFeatures -> {
                    NewMusicFeatures musicFeatures = new NewMusicFeatures();
                    return musicFeatures;
                })
                .orElse(null);

        return newMusicFeaturesFromBackend;
    }

    public NewMusicFeatures addNewNewMusicFeatures(NewMusicFeatures newMusicFeatures) {
        NewMusicFeaturesRecord newMusicFeaturesRecord = new NewMusicFeaturesRecord();
        newMusicFeaturesRecord.setFeatureId(newMusicFeatures.getFeatureId());
        newMusicFeaturesRecord.setFeatureId(newMusicFeatures.getFeatureId());
        newMusicFeaturesRepository.save(newMusicFeaturesRecord);
        return newMusicFeatures;
    }

    private class NewMusicFeatures {
        private Object NewMusicFeatures;

        public Object getFeatureId() {
            return NewMusicFeatures;
        }
    }

    private class NewMusicFeaturesRecord {
        public void setFeatureId(Object featureId) {
        }
    }

    private class NewMusicFeaturesRepository {
        public void save(NewMusicFeaturesRecord newMusicFeaturesRecord) {

        }

        public Optional<Object> findByfeatureId(String id) {
            return newMusicFeaturesRepository.findByfeatureId(id);
        }
    }
}

