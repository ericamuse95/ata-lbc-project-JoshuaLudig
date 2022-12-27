package com.kenzie.appserver.repositories.model;

import java.util.Objects;

public class NewMusicFeaturesRecord {
    private String featureId;
    private String featureName;
    private String featureDescription;
    private String featureImage;
    private String featureLink;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof NewMusicFeaturesRecord )) return false;
        NewMusicFeaturesRecord that = (NewMusicFeaturesRecord) o;
        return Objects.equals(getFeatureId(), that.getFeatureId()) && Objects.equals(getFeatureName(), that.getFeatureName()) && Objects.equals(getFeatureDescription(), that.getFeatureDescription()) && Objects.equals(getFeatureImage(), that.getFeatureImage()) && Objects.equals(getFeatureLink(), that.getFeatureLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeatureId(), getFeatureName(), getFeatureDescription(), getFeatureImage(), getFeatureLink());
    }
}

