package com.kenzie.appserver.service.model;

public class NewMusicFeatures {
    private final String songId;
    private final String featureName;
    private final String featureId;
    private final String featureDescription;
    private final String featureImage;
    private final String featureLink;

    public NewMusicFeatures(String songId,String featureName, String featureId, String featureDescription, String featureImage, String featureLink) {
        this.songId = songId;
        this.featureName = featureName;
        this.featureId = featureId;
        this.featureDescription = featureDescription;
        this.featureImage = featureImage;
        this.featureLink = featureLink;
    }
    //add String getter methods for each field
    public String getSongId() {
        return songId;
    }
    public String getFeatureName() {
        return featureName;
    }
    public String getFeatureId() {
        return featureId;
    }
    public String getFeatureDescription() {
        return featureDescription;
    }
    public String getFeatureImage() {
        return featureImage;
    }
    public String getFeatureLink() {
        return featureLink;
    }

}
