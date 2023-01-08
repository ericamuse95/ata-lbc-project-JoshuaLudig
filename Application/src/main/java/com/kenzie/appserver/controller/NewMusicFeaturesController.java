package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.NewMusicFeaturesCreateRequest;
import com.kenzie.appserver.controller.model.NewMusicFeaturesResponse;
import com.kenzie.appserver.service.model.NewMusicFeatures;
import com.kenzie.appserver.service.NewMusicFeaturesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/feature")
public class NewMusicFeaturesController {

    private NewMusicFeaturesService newMusicFeaturesService;

    NewMusicFeaturesController(NewMusicFeaturesService newMusicFeaturesService) {
        this.newMusicFeaturesService = newMusicFeaturesService;
    }

    @GetMapping("/{featureId}")
    public ResponseEntity<NewMusicFeaturesResponse> getFeatureById(@PathVariable("featureId") String featureId) {
        NewMusicFeatures newMusicFeatures = newMusicFeaturesService.findById(featureId);

        NewMusicFeaturesResponse newMusicFeaturesResponse = new NewMusicFeaturesResponse();
        newMusicFeaturesResponse.setFeatureId(newMusicFeatures.getFeatureId());

        return ResponseEntity.ok(newMusicFeaturesResponse);
    }

    @PostMapping
    public ResponseEntity<NewMusicFeaturesResponse> addNewFeature(@RequestBody NewMusicFeaturesCreateRequest newMusicFeaturesCreateRequest) {
        NewMusicFeatures newMusicFeatures = new NewMusicFeatures(newMusicFeaturesCreateRequest.getFeatureId(), newMusicFeaturesCreateRequest.getFeatureDescription(), newMusicFeaturesCreateRequest.getFeatureImage(),
                newMusicFeaturesCreateRequest.getFeatureLink(), newMusicFeaturesCreateRequest.getFeatureName(), newMusicFeaturesCreateRequest.getSongId());

        NewMusicFeaturesResponse newMusicFeaturesResponse = new NewMusicFeaturesResponse();

        newMusicFeaturesResponse.setFeatureDescription(newMusicFeatures.getFeatureDescription());
        newMusicFeaturesResponse.setFeatureImage(newMusicFeatures.getFeatureImage());
        newMusicFeaturesResponse.setFeatureLink(newMusicFeatures.getFeatureLink());
        newMusicFeaturesResponse.setFeatureName(newMusicFeatures.getFeatureName());
        newMusicFeaturesResponse.setFeatureId(newMusicFeatures.getFeatureId());
        newMusicFeaturesResponse.setSongId(newMusicFeatures.getSongId());

        return ResponseEntity.created(URI.create("/featureId/" + newMusicFeaturesResponse.getFeatureId())).body(newMusicFeaturesResponse);
    }

    @GetMapping("/featureId/all")
    public ResponseEntity<List<NewMusicFeaturesResponse>> getAllFeatures() {
        List<NewMusicFeatures> newMusicFeaturesList = newMusicFeaturesService.findAllFeatures();
        List<NewMusicFeaturesResponse> responses = new ArrayList<>();
        for(NewMusicFeatures newMusicFeatures : newMusicFeaturesList) {
            NewMusicFeaturesResponse newMusicFeaturesResponse = createNewMusicFeaturesResponse(newMusicFeatures);
            responses.add(newMusicFeaturesResponse);
        }
        return ResponseEntity.ok(responses);
    }

    private NewMusicFeaturesResponse createNewMusicFeaturesResponse(NewMusicFeatures newMusicFeatures) {
        NewMusicFeaturesResponse newMusicFeaturesResponse = new NewMusicFeaturesResponse();
        newMusicFeaturesResponse.setFeatureId(newMusicFeatures.getFeatureId());
        newMusicFeaturesResponse.setFeatureLink(newMusicFeatures.getFeatureLink());
        newMusicFeaturesResponse.setFeatureDescription(newMusicFeatures.getFeatureDescription());
        newMusicFeaturesResponse.setFeatureImage(newMusicFeatures.getFeatureImage());
        newMusicFeaturesResponse.setFeatureName(newMusicFeatures.getFeatureName());
        newMusicFeaturesResponse.setSongId(newMusicFeatures.getSongId());
        return newMusicFeaturesResponse;
    }
}
