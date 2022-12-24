package com.kenzie.appserver.service;

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

    public NewMusicFeaturesServiceTest(NewMusicFeaturesRepository newMusicFeaturesRepository,
                                       NewMusicFeaturesService newMusicFeaturesService) {
        this.newMusicFeaturesRepository = newMusicFeaturesRepository;
        this.newMusicFeaturesService = newMusicFeaturesService;
    }

    @BeforeEach
    void setup() {
        newMusicFeaturesRepository = mock(NewMusicFeaturesRepository.class);
        newMusicFeaturesService = new NewMusicFeaturesService(newMusicFeaturesRepository);
    }
    @Test
        void findByFeatureId ( ) {
            // GIVEN
            String id = randomUUID().toString();

            // WHEN
            Object record = new Object();
            when(newMusicFeaturesRepository.findByfeatureId(id)).thenReturn(Optional.of(record));
            // THEN
            Assertions.assertEquals(record, newMusicFeaturesService.findByFeatureId(id), "The id matches");
        }
    }
