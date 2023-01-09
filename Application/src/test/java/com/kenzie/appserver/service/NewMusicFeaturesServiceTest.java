package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.model.NewMusicFeaturesRecord;
import com.kenzie.appserver.repositories.model.NewMusicFeaturesRepository;
import com.kenzie.appserver.service.model.NewMusicFeatures;
import com.kenzie.appserver.service.model.SongInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewMusicFeaturesServiceTest{
    private NewMusicFeaturesRepository newMusicFeaturesRepository;
    private NewMusicFeaturesService newMusicFeaturesService;

    @BeforeEach
    void setup() {
        this.newMusicFeaturesRepository = mock(NewMusicFeaturesRepository.class);
        this.newMusicFeaturesService = new NewMusicFeaturesService(this.newMusicFeaturesRepository);

    }
    @Test
    void findByFeatureId() {
        // GIVEN
        String id = randomUUID().toString();
        NewMusicFeaturesRecord record = new NewMusicFeaturesRecord();
        // WHEN
        when(newMusicFeaturesRepository.findById(id)).thenReturn(Optional.of(record));
        // THEN
        Assertions.assertEquals(newMusicFeaturesService.findById(id).getFeatureId(), record.getFeatureId());
    }

    @Test
    void findBySongId() {
        // GIVEN
        String id = randomUUID().toString();

        NewMusicFeaturesRecord record = new NewMusicFeaturesRecord();
        record.setSongId(id);

        // WHEN
        when(newMusicFeaturesRepository.findById(id)).thenReturn(Optional.of(record));
        // THEN
        Assertions.assertEquals(newMusicFeaturesService.findById(id).getSongId(), id);

    }
    @Test
    void NewMusicFeaturesService() {
        // GIVEN
        String id = randomUUID().toString();

        NewMusicFeaturesRecord record = new NewMusicFeaturesRecord();
        record.setSongId(id);

        // WHEN
        when(newMusicFeaturesRepository.findById(id)).thenReturn(Optional.of(record));
        // THEN
        Assertions.assertEquals(newMusicFeaturesService.findById(id).getFeatureLink(), record.getFeatureLink());
    }
    @Test
    void addNewFeature(){
        // GIVEN
        String id = randomUUID().toString();
        NewMusicFeaturesRecord record = new NewMusicFeaturesRecord();
        record.setSongId(id);
        // WHEN
        when(newMusicFeaturesRepository.save(record)).thenReturn(record);
        // THEN
        Assertions.assertEquals(newMusicFeaturesService.addNewFeature(new NewMusicFeatures(record.getSongId(),record.getFeatureName(),record.getFeatureId(),record.getFeatureDescription(),record.getFeatureImage(),record.getFeatureLink())).getSongId(), record.getSongId());
    }
    @Test
    void findAllFeatures() {
        // GIVEN
        String id = randomUUID().toString();
        NewMusicFeaturesRecord record = new NewMusicFeaturesRecord();
        record.setSongId(id);
       // WHEN
        when(newMusicFeaturesRepository.findById(id)).thenReturn(Optional.of(record));
        // THEN
        Assertions.assertEquals(newMusicFeaturesService.findById(id).getFeatureName(), record.getFeatureName());
    }
}


