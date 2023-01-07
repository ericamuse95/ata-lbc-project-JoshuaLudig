package com.kenzie.appserver.repositories.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NewMusicFeaturesRepository<NewMusicFeaturesRecord> extends CrudRepository<NewMusicFeaturesRecord, String> {
    Optional<NewMusicFeaturesRecord> findByFeatureId(String id);
    Optional<NewMusicFeaturesRecord> findBySongId(String id);

    void getNewMusicFeaturesRecord();
}

