//package com.kenzie.appserver.service;
//
//
//import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
//import com.kenzie.appserver.service.model.NewMusicFeatures;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NewMusicFeaturesService {
//
//    private NewMusicFeaturesRepository newMusicFeaturesRepository;
//
//    /**
//     * @param newMusicFeaturesRepository the repository to use
//     */
//    public NewMusicFeaturesService(NewMusicFeaturesRepository newMusicFeaturesRepository) {
//        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
//    }
//
//    public NewMusicFeatures findById(String id) {
//        NewMusicFeatures newMusicFeaturesFromBackend = newMusicFeaturesRepository.findById(id)
//                .map(newmusicfeatures -> new NewMusicFeatures(newmusicfeatures))
//                .orElse(null);
//        return newMusicFeaturesFromBackend;
//    }
//
//    /**
//     * @param songId the songId to use
//     * @return the song info
//     */
//
//
//
//}
