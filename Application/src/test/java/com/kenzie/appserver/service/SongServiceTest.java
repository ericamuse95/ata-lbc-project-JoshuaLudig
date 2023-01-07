package com.kenzie.appserver.service;
import com.kenzie.appserver.repositories.SongServiceRepository;
import com.kenzie.appserver.repositories.model.SongServiceRecord;
import com.kenzie.appserver.service.model.SongInfo;
import com.kenzie.appserver.service.model.SongService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import java.util.Optional;
import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SongServiceTest {
    private SongServiceRepository songServiceRepository;
    private SongService songService;

    @BeforeEach
    void setup() {
        songServiceRepository = mock(SongServiceRepository.class);
        songService = new SongService(songServiceRepository);
    }

    /**
     * ------------------------------------------------------------------------
     * songService.findById
     * ------------------------------------------------------------------------
     **/

    @Test
    void findBySongId() {
        // GIVEN
        String id = randomUUID().toString();
        SongServiceRecord record = new SongServiceRecord();
        record.setSongId(id);
        record.setArtistByGenre("genre");
        record.setArtistByUserId("userid");
        record.setArtistByYear("year");

        // WHEN
        when(songServiceRepository.findById(id)).thenReturn(Optional.of(record));
        SongInfo songInfo = songService.findBySongId(id);

        // THEN
        Assertions.assertNotNull(songInfo, "The object is returned");
        Assertions.assertEquals(record.getSongId(), songInfo.getSongId(), "The id matches");
        Assertions.assertEquals(record.getArtistByGenre(), songInfo.getArtistByGenre(), "The genre matches");
        Assertions.assertEquals(record.getArtistByUserId(), songInfo.getArtistByUserId(), "The userid matches");
        Assertions.assertEquals(record.getArtistByYear(), songInfo.getArtistByYear(), "The year matches");
    }

    @Test
    void findAll() {
        // GIVEN
        String id = randomUUID().toString();
        SongServiceRecord record = new SongServiceRecord();
        record.setSongId(id);
        record.setArtistByGenre("genre");
        record.setArtistByUserId("userid");
        record.setArtistByYear("year");

        // WHEN
        when(songServiceRepository.findById(id)).thenReturn(Optional.of(record));
        SongInfo songInfo = songService.findBySongId(id);


        // THEN
        Assertions.assertNotNull(songInfo, "The object is returned");
        Assertions.assertEquals(record.getSongId(), songInfo.getSongId(), "The id matches");
        Assertions.assertEquals(record.getArtistByGenre(), songInfo.getArtistByGenre(), "The genre matches");
        Assertions.assertEquals(record.getArtistByUserId(), songInfo.getArtistByUserId(), "The userid matches");
        Assertions.assertEquals(record.getArtistByYear(), songInfo.getArtistByYear(), "The year matches");
    }

    @Test
    void addNewSong() {
        // GIVEN
        String id = randomUUID().toString();
        SongServiceRecord record = new SongServiceRecord();
        record.setSongId(id);
        record.setArtistByGenre("genre");
        record.setArtistByUserId("userid");
        record.setArtistByYear("year");

        // WHEN
        when(songServiceRepository.findById(id)).thenReturn(Optional.of(record));
        SongInfo songInfo = songService.findBySongId(id);

        // THEN
        Assertions.assertNotNull(songInfo, "The object is returned");
        Assertions.assertEquals(record.getSongId(), songInfo.getSongId(), "The id matches");
        Assertions.assertEquals(record.getArtistByGenre(), songInfo.getArtistByGenre(), "The genre matches");
        Assertions.assertEquals(record.getArtistByUserId(), songInfo.getArtistByUserId(), "The userid matches");
        Assertions.assertEquals(record.getArtistByYear(), songInfo.getArtistByYear(), "The year matches");
    }
}