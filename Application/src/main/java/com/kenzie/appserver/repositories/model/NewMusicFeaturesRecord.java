package com.kenzie.appserver.repositories.model;

public class NewMusicFeaturesRecord {
private String featureId;
private String featureName;
private String featureDescription;
private String featureImage;
private String featureLink;
private String songId;

  @DynamoDBAttribute(attributeName = "featureId")
   public String getFeatureId() {
       return featureId;
  }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }
   @DynamoDBHashKey(attributeName = "featureName")
   public String getSongId() {
       return songId;
    }

   public void setSongId(String songId) {
       this.songId = songId;
//    }
//    @DynamoDBAttribute(attributeName = "featureDescription")
//    public String getFeatureName() {
//        return featureName;
//    }
//
//    public void setFeatureName(String featureName) {
//        this.featureName = featureName;
//    }
//    @DynamoDBAttribute(attributeName = "featureDescription")
//    public String getFeatureDescription() {
//        return featureDescription;
//    }
//
//    public void setFeatureDescription(String featureDescription) {
//        this.featureDescription = featureDescription;
//    }
//    @DynamoDBAttribute(attributeName = "featureImage")
//    public String getFeatureImage() {
//        return featureImage;
//    }
//
//    public void setFeatureImage(String featureImage) {
//        this.featureImage = featureImage;
//    }
//    @DynamoDBAttribute(attributeName = "featureLink")
//    public String getFeatureLink() {
//        return featureLink;
//    }
//
//    public void setFeatureLink(String featureLink) {
//        this.featureLink = featureLink;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!( o instanceof NewMusicFeaturesRecord )) return false;
//        NewMusicFeaturesRecord that = (NewMusicFeaturesRecord) o;
//        return Objects.equals(getFeatureId(),
//                that.getFeatureId()) && Objects.equals(getFeatureName(),
//                that.getFeatureName()) && Objects.equals(getFeatureDescription(),
//                that.getFeatureDescription()) && Objects.equals(getFeatureImage(),
//                that.getFeatureImage()) && Objects.equals(getFeatureLink(),
//                that.getFeatureLink());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getFeatureId(), getFeatureName(), getFeatureDescription(), getFeatureImage(), getFeatureLink());
//    }
//}
//
