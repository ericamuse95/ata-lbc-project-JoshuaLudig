package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewMusicFeaturesResponse {

    @JsonProperty("songId")
    private String songId;

    @JsonProperty("featureName")
    private String featureName;

    @JsonProperty("featureId")
    private String featureId;

    @JsonProperty("featureDescription")
    private String featureDescription;

    @JsonProperty("featureImage")
    private String featureImage;

    @JsonProperty("featureLink")
    private String featureLink;


    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

    public String getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(String featureImage) {
        this.featureImage = featureImage;
    }

    public String getFeatureLink() {
        return featureLink;
    }

    public void setFeatureLink(String featureLink) {
        this.featureLink = featureLink;
    }
}
