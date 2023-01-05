package com.kenzie.appserver.service.model;

public class SongInfo {
    private final String songId;
    private final String artistByUserId;
    private final String artistByGenre;
    private final String artistByYear;

    public SongInfo(String songId, String artistByUserId, String artistByGenre, String artistByYear) {
        this.songId = songId;
        this.artistByUserId = artistByUserId;
        this.artistByGenre = artistByGenre;
        this.artistByYear = artistByYear;
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
}
