package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "NewMusicFeatures")
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
   @DynamoDBHashKey(attributeName = "songId")
   public String getSongId() {
       return songId;
    }

   public void setSongId(String songId) {
       this.songId = songId;
    }
    @DynamoDBAttribute(attributeName = "featureName")
    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    @DynamoDBAttribute(attributeName = "featureDescription")
    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }
    @DynamoDBAttribute(attributeName = "featureImage")
    public String getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(String featureImage) {
        this.featureImage = featureImage;
    }
    @DynamoDBAttribute(attributeName = "featureLink")
    public String getFeatureLink() {
        return featureLink;
    }

    public void setFeatureLink(String featureLink) {
        this.featureLink = featureLink;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        NewMusicFeaturesRecord rhs = (NewMusicFeaturesRecord) obj;
        return songId.equals(rhs.songId);
    }

    @Override
    public int hashCode() {return songId.hashCode();
    }
}

