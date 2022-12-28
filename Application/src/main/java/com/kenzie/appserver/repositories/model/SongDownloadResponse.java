package com.kenzie.appserver.repositories.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SongDownloadResponse {
    @JsonProperty("songId")
    private String songId;

    @JsonProperty("artistId")
    private String artistId;

    @JsonProperty("artistByYear")
    private String artistByYear;

    @JsonProperty("artistByGenre")
    private String artistByGenre;

    public String getSongId() {return songId;}

    public void setSongId(String songId) {this.songId = songId;}

    public String getArtistId() {return artistId;}

    public void setArtistId(String artistId) {this.artistId = artistId;}

    public String getArtistByYear() {return artistByYear;}

    public void setArtistByYear(String artistByYear) {this.artistByYear = artistByYear;}

    public String getArtistByGenre() {return artistByGenre;}

    public void setArtistByGenre(String artistByGenre) {this.artistByGenre = artistByGenre;}
}
