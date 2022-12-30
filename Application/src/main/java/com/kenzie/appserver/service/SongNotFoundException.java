package com.kenzie.appserver.service;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(String songId) {
        super("Could not find song " + songId);
    }
}
