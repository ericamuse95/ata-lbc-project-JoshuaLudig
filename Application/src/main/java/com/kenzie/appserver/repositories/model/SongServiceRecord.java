package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Music")
public class SongServiceRecord{
    private String songId;
    private String artistByUserId;
    private String artistByGenre;
    private String artistByYear;
    private boolean isFavorite;
    @DynamoDBHashKey(attributeName = "SongId")
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }
    @DynamoDBAttribute(attributeName = "ArtistByUserId")
    public String getArtistByUserId() {
        return artistByUserId;
    }

    public void setArtistByUserId(String artistByUserId) {
        this.artistByUserId = artistByUserId;
    }
    @DynamoDBAttribute(attributeName = "ArtistByGenre")
    public String getArtistByGenre() {
        return artistByGenre;
    }

    public void setArtistByGenre(String artistByGenre) {
        this.artistByGenre = artistByGenre;
    }

    @DynamoDBAttribute(attributeName = "ArtistByYear")
    public String getArtistByYear() {
        return artistByYear;
    }

    public void setArtistByYear(String artistByYear) {
        this.artistByYear = artistByYear;
    }

    @DynamoDBAttribute(attributeName = "isFavorite")
    public boolean getIsFavorite() {return isFavorite;}

    public void setIsFavorite(boolean isFavorite) {this.isFavorite = isFavorite;}


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
        SongServiceRecord rhs = (SongServiceRecord) obj;
        return songId.equals(rhs.songId);
    }

    @Override
    public int hashCode() {
        return songId.hashCode();
    }
}

