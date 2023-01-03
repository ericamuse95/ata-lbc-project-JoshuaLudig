package com.kenzie.appserver.repositories.model;

public class AppDisplayRecord {
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

