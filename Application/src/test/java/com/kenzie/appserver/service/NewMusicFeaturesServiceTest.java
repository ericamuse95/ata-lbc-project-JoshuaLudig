package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;
import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewMusicFeaturesServiceTest<NewMusicFeatures> {
    private NewMusicFeaturesRepository newMusicFeaturesRepository;
    private NewMusicFeaturesService newMusicFeaturesService;
    private boolean newMusicFeatures;

//    public NewMusicFeaturesServiceTest(NewMusicFeaturesRepository newMusicFeaturesRepository,
//                                       NewMusicFeaturesService newMusicFeaturesService) {
//        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
//        this.newMusicFeaturesService = newMusicFeaturesService;
//    }

    @BeforeEach
    void setup() {
        newMusicFeaturesRepository = mock(NewMusicFeaturesRepository.class);
        newMusicFeaturesService = new NewMusicFeaturesService(newMusicFeaturesRepository);
    }


    @Test
    void findByFeatureId() {
        // GIVEN
        String id = randomUUID().toString();

        NewMusicFeaturesRecord record = new NewMusicFeaturesRecord();

        // WHEN
        when(newMusicFeaturesRepository.findById(id)).thenReturn(Optional.of(record));
        // THEN
       AssertEquals (newMusicFeaturesService.findByFeatureId(id), record);
    }

    private void AssertEquals(NewMusicFeaturesService.NewMusicFeatures byFeatureId, NewMusicFeaturesRecord record) {
    }

    @Test
    void findBySongId() {
        // GIVEN
        String id = randomUUID().toString();

        // WHEN
        newMusicFeaturesRepository.findBySongId(id);
        // THEN
        Assertions.assertEquals(newMusicFeatures, newMusicFeaturesService.findBySongId(id), "The id matches");
    }
}

