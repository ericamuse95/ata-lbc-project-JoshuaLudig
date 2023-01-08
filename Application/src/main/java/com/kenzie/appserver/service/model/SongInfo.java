package com.kenzie.appserver.service.model;

public class SongInfo {
    private final String songId;
    private final String artistByUserId;
    private final String artistByGenre;
    private final String artistByYear;
    private final boolean isFavorite;


    public SongInfo(String songId, String artistByUserId, String artistByGenre, String artistByYear, boolean isFavorite) {
        this.songId = songId;
        this.artistByUserId = artistByUserId;
        this.artistByGenre = artistByGenre;
        this.artistByYear = artistByYear;
        this.isFavorite = isFavorite;
    }

    public String getSongId() {
        return songId;
    }

    public String getArtistByUserId() {
        return artistByUserId;
    }

    public String getArtistByGenre() {
        return artistByGenre;
    }

    public String getArtistByYear() {
        return artistByYear;
    }

    public boolean getIsFavorite(){ return isFavorite;}

}
