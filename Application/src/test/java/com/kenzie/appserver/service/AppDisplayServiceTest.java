package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.model.DisplayRepository;
import com.kenzie.appserver.repositories.model.ExampleRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppDisplayServiceTest<AppDisplay> {
    private DisplayRepository displayRepository;
    private AppDisplayService appDisplayService;
    private Object SongId;
    private AppDisplay ArtistByUserId;

    public <AppDisplayService> AppDisplayServiceTest(DisplayRepository displayRepository,
                                                     AppDisplayService appDisplayService) {
        this.displayRepository = displayRepository;
        this.appDisplayService = (AppDisplayServiceTest.AppDisplayService) appDisplayService;
    }

    @BeforeEach
    void setup() {
        displayRepository = mock(DisplayRepository.class);
        appDisplayService = new AppDisplayService();
    }
    /**------------------------------------------------------------------------
            *appDisplayService.findBySongId
     *------------------------------------------------------------------------**/

// Need to add a test for findBySongId
    @Test
   void findBySongId() {
        // GIVEN
        String id = randomUUID().toString();

        ExampleRecord record = new ExampleRecord();
        record.setId(id);
        record.setName("songname");

        // WHEN
        when(DisplayRepository.findBySongId(id)).thenReturn(Optional.of(record));
        AppDisplay appDisplay = (AppDisplay) appDisplayService.findBySongId(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The object is returned");
        Assertions.assertEquals(record.getSongId(), appDisplay.toString(), "The song id matches");
        Assertions.assertEquals(record.getName(), appDisplay.toString(), "The name matches");
    }

    private class AppDisplayService {
        private AppDisplay ArtistByGenre;


        public AppDisplay findArtistsByUserId(String id) {
            return ArtistByUserId;
        }

        public Object findBySongId(String id) {
            return SongId;
        }

        public AppDisplay findArtistsByGenre(String id) {
            return ArtistByGenre;
        }
    }
    // I will add a test to locate Artists by their User Ids

    @Test
    void findArtists() {
        // GIVEN
        String id = randomUUID().toString();

        when(DisplayRepository.findArtistsByUserId(id)).thenReturn(Optional.empty());

        // WHEN
        AppDisplay appDisplay = appDisplayService.findArtistsByUserId(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The Artist user Id is successfully located");
    }
    // I will also add a test to find Artists in our display by their Genres
    @Test
    void findArtistsByGenre() {
        // GIVEN
        String id = randomUUID().toString();

        when(DisplayRepository.findArtistsByGenre(id)).thenReturn(Optional.empty());

        // WHEN
        AppDisplay appDisplay = appDisplayService.findArtistsByGenre(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The app displays the Artist Genre");
    }
    // Adding in a test to locate Artists by their year of music release

    @Test
    void findArtistsByYear() {
        // GIVEN
        String id = randomUUID().toString();

        when(DisplayRepository.findArtistsByYear(id)).thenReturn(Optional.empty());

        // WHEN
        AppDisplay appDisplay = ArtistsByYear(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The appDisplay shows the year of release");
    }

    private AppDisplay ArtistsByYear(String id) {
        return ArtistsByYear(id);
    }
}


