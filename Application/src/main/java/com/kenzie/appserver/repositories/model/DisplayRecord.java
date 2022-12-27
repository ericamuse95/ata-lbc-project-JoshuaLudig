package com.kenzie.appserver.repositories.model;

public class DisplayRecord {
    private String SongId;
    private String ArtistByUserId;
    private String ArtistByGenre;
    private String ArtistByYear;

    public String getSongId() {
        return SongId;
    }

    public void setSongId(String songId) {
        SongId = songId;
    }

    public String getArtistByUserId() {
        return ArtistByUserId;
    }

    public void setArtistByUserId(String artistByUserId) {
        ArtistByUserId = artistByUserId;
    }

    public String getArtistByGenre() {
        return ArtistByGenre;
    }

    public void setArtistByGenre(String artistByGenre) {
        ArtistByGenre = artistByGenre;
    }

    public String getArtistByYear() {
        return ArtistByYear;
    }

    public void setArtistByYear(String artistByYear) {
        ArtistByYear = artistByYear;
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

