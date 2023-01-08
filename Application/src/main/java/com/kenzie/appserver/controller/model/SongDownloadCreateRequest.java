package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SongDownloadCreateRequest {
    @JsonProperty("songId")
    private String songId;

    @JsonProperty("artistId")
    private String artistId;

    @JsonProperty("artistByYear")
    private String artistByYear;

    @JsonProperty("artistByGenre")
    private String artistByGenre;

    @JsonProperty("isFavorite")
    private boolean isFavorite;


    public String getSongId() {return songId;}

    public void setSongId(String songId) {this.songId = songId;}

    public String getArtistId() {return artistId;}

    public void setArtistId(String artistId) {this.artistId = artistId;}

    public String getArtistByYear() {return artistByYear;}

    public void setArtistByYear(String artistByYear) {this.artistByYear = artistByYear;}

    public String getArtistByGenre() {return artistByGenre;}

    public void setArtistByGenre(String artistByGenre) {this.artistByGenre = artistByGenre;}

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
