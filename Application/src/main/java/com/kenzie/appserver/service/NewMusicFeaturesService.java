//package com.kenzie.appserver.service;
//
//
//import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;
//import com.kenzie.appserver.service.model.NewMusicFeatures;
//import org.springframework.stereotype.Service;
//import com.kenzie.appserver.repositories.NewMusicFeaturesRepository;
//import java.util.Optional;
//
//@Service
//public class NewMusicFeaturesService {
//
//    private NewMusicFeaturesRepository newMusicFeaturesRepository;
//    public NewMusicFeaturesService(com.kenzie.appserver.repositories.NewMusicFeaturesRepository newMusicFeaturesRepository) {
//        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
//    }
//    private NewMusicFeatures SongId;
//
//
//
//    public NewMusicFeatures findByFeatureId(String id) {
//        NewMusicFeatures newMusicFeaturesFromBackend = newMusicFeaturesRepository
//                .findByFeatureId(id)
//                .map(newMusicFeatures -> {
//                    NewMusicFeatures musicFeatures = new NewMusicFeatures();
//                    return musicFeatures;
//                })
//                .orElse(null);
//
//        return newMusicFeaturesFromBackend;
//    }
//
//    public NewMusicFeatures SongId(String id) {
//        NewMusicFeatures newMusicFeaturesFromBackend = newMusicFeaturesRepository
//                .findBySongId(id)
//                .map(newMusicFeatures -> {
//                    NewMusicFeatures musicFeatures = new NewMusicFeatures();
//                    return musicFeatures;
//                })
//                .orElse(null);
//
//        return SongId;
//    }
//
//    public NewMusicFeatures addNewNewMusicFeatures(NewMusicFeatures newMusicFeatures) {
//        NewMusicFeaturesRecord newMusicFeaturesRecord = new NewMusicFeaturesRecord();
//        newMusicFeaturesRecord.setFeatureId(newMusicFeatures.getFeatureId());
//        newMusicFeaturesRecord.setFeatureId(newMusicFeatures.getFeatureId());
//        newMusicFeaturesRepository.save(newMusicFeaturesRecord);
//        return newMusicFeatures;
//    }
//
//    public Object findBySongId(String id) {
//        return SongId(id);
//    }
//
//}
//
