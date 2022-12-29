package com.kenzie.appserver.repositories.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NewMusicFeaturesRepository extends CrudRepository<NewMusicFeaturesRecord, String> {
    Optional<NewMusicFeaturesRecord> findByfeatureId(String id);
    Optional<NewMusicFeaturesRecord> findBySongId(String id);
}

