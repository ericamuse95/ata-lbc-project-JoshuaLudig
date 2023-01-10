package com.kenzie.appserver.service;
import com.kenzie.appserver.repositories.SongServiceRepository;
import com.kenzie.appserver.repositories.model.SongServiceRecord;
import com.kenzie.appserver.service.model.SongInfo;
import com.kenzie.appserver.service.model.SongService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import java.util.UUID;
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

    @Test
    void findBySongId_Null_ThrowsException(){
        //GIVEN
        String songId = randomUUID().toString();

        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId(songId);
        songServiceRecord.setArtistByUserId("Lorde");
        songServiceRecord.setArtistByYear("2013");
        songServiceRecord.setArtistByGenre("Pop");

        when(songServiceRepository.findById(songId)).thenReturn(Optional.of(songServiceRecord));

        //WHEN
        SongInfo songInfo = songService.findBySongId(songId);

        //THEN
        Assertions.assertThrows(NullPointerException.class, () -> {
            songService.findBySongId(null);
        });
    }

    @Test
    void findBySongId_Empty_ThrowsException(){

        //GIVEN
        String songId = randomUUID().toString();

        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId(songId);
        songServiceRecord.setArtistByUserId("Doja Cat");
        songServiceRecord.setArtistByYear("2019");
        songServiceRecord.setArtistByGenre("Pop");

        when(songServiceRepository.findById(songId)).thenReturn(Optional.of(songServiceRecord));

        //WHEN
        SongInfo songInfo = songService.findBySongId(songId);

        //THEN
        Assertions.assertThrows(NullPointerException.class, () -> {
            songService.findBySongId("");
        });
    }

    @Test
    void deleteSongInfo_Success(){
        //GIVEN
        String songId = UUID.randomUUID().toString();

        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId("Streets");
        songServiceRecord.setArtistByUserId("Doja Cat");
        songServiceRecord.setArtistByYear("2019");
        songServiceRecord.setArtistByGenre("Pop");

        ArgumentCaptor<String> songCapture = ArgumentCaptor.forClass(String.class);
        //WHEN/THEN
        Optional<SongServiceRecord> recordOptional = Optional.of(songServiceRecord);
        Mockito.when(songServiceRepository.findById(songId)).thenReturn(recordOptional);
        Mockito.doNothing().when(songServiceRepository).deleteById(songCapture.capture());
        songService.deleteSong(songId);

        Assertions.assertEquals(songId, songCapture.getValue());
    }

    @Test
    void deleteSongInfo_SongDoesNotExist_ThrowsException(){
        //GIVEN
        String songId = UUID.randomUUID().toString();
        Optional<SongServiceRecord> songRecordOptional = Optional.empty();

        //WHEN/THEN

        Mockito.when(songServiceRepository.findById(songId)).thenReturn(songRecordOptional);

        Exception exception = Assertions.assertThrows(ResponseStatusException.class, () -> {
            songService.deleteSong(songId);
        });

        String expectedMessage = "Song does not exist.";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void findArtistByUserId(){
      //GIVEN
          String songId = UUID.randomUUID().toString();

            SongServiceRecord songServiceRecord = new SongServiceRecord();
            songServiceRecord.setSongId("Streets");
            songServiceRecord.setArtistByUserId("Doja Cat");
            songServiceRecord.setArtistByYear("2019");
            songServiceRecord.setArtistByGenre("Pop");

            ArgumentCaptor<String> songCapture = ArgumentCaptor.forClass(String.class);
            //WHEN/THEN
            Optional<SongServiceRecord> recordOptional = Optional.of(songServiceRecord);
            Mockito.when(songServiceRepository.findById(songId)).thenReturn(recordOptional);
    }
    @Test
    void findArtistByGenre(){
        //GIVEN
        String songId = UUID.randomUUID().toString();
        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId("Streets");
        songServiceRecord.setArtistByUserId("Doja Cat");
        songServiceRecord.setArtistByYear("2019");
        songServiceRecord.setArtistByGenre("Pop");
        ArgumentCaptor<String> songCapture = ArgumentCaptor.forClass(String.class);
        //WHEN/THEN
        Optional<SongServiceRecord> recordOptional = Optional.of(songServiceRecord);
    }
    @Test
    void findArtistByYear(){
        //GIVEN
        String songId = UUID.randomUUID().toString();
        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId("Streets");
        songServiceRecord.setArtistByUserId("Doja Cat");
        songServiceRecord.setArtistByYear("2019");
        songServiceRecord.setArtistByGenre("Pop");
        ArgumentCaptor<String> songCapture = ArgumentCaptor.forClass(String.class);
        //WHEN/THEN
        Optional<SongServiceRecord> recordOptional = Optional.of(songServiceRecord);
    }
    @Test
    void getFavoriteSongs(){
        //GIVEN
        String songId = UUID.randomUUID().toString();
        SongServiceRecord songServiceRecord = new SongServiceRecord();
        songServiceRecord.setSongId("Streets");
        songServiceRecord.setArtistByUserId("Doja Cat");
        songServiceRecord.setArtistByYear("2019");
        songServiceRecord.setArtistByGenre("Pop");
        ArgumentCaptor<String> songCapture = ArgumentCaptor.forClass(String.class);
        //WHEN/THEN
        Optional<SongServiceRecord> recordOptional = Optional.of(songServiceRecord);
    }
}