package com.kenzie.appserver.service.model;

public class SongInfo {
    private String songId;
    private String artistByUserId;
    private String artistByGenre;
    private String artistByYear;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getArtistByUserId() {
        return artistByUserId;
    }

    public void setArtistByUserId(String artistByUserId) {
        this.artistByUserId = artistByUserId;
    }

    public String getArtistByGenre() {
        return artistByGenre;
    }

    public void setArtistByGenre(String artistByGenre) {
        this.artistByGenre = artistByGenre;
    }

    public String getArtistByYear() {
        return artistByYear;
    }

    public void setArtistByYear(String artistByYear) {
        this.artistByYear = artistByYear;
    }
}
