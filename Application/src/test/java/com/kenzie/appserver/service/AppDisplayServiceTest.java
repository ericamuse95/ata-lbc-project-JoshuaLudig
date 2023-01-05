package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.model.AppDisplayRecord;
import jdk.internal.icu.lang.UCharacterDirection;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppDisplayServiceTest<AppDisplay> {
    private AppDisplayService appDisplayService;
    private Object SongId;
    private AppDisplay ArtistByUserId;
    private UCharacterDirection appDisplay;
    private AppDisplay ArtistByGenre;
    private Object ArtistByYear;

    public AppDisplayServiceTest(AppDisplayService appDisplayService) {
        this.appDisplayService = appDisplayService;
    }

    @BeforeEach
    void setup() {
        appDisplayService = mock(AppDisplayService.class);
    }
    /**------------------------------------------------------------------------
            *appDisplayService.findBySongId
     *------------------------------------------------------------------------**/
    // Need to add a test for findBySongId
    @ParameterizedTest
    @Test
   void findBySongId() {
        // GIVEN
        String id = randomUUID().toString();

        AppDisplayRecord record = new AppDisplayRecord();
        record.setSongId(id);
        record.setArtistByUserId("artistname");

        // WHEN
        when(appDisplayService.findBySongId(id)).thenReturn(Optional.of(record));


        // THEN
        Assertions.assertEquals(record, appDisplayService.findBySongId(id), "The id matches");
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

        public Object findArtistsByYear(String id) {
            return ArtistsByYear(id);
        }
    }
    // I will add a test to locate Artists by their User Ids
    @ParameterizedTest
    @Test
    void findArtists() {
        // GIVEN
        String id = randomUUID().toString();

        // WHEN
        when(appDisplayService.findArtistsByUserId(id)).thenReturn((AppDisplay) Optional.of(ArtistByUserId));
        AppDisplay appDisplay = appDisplayService.findArtistsByUserId(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The Artist user Id is successfully located");
    }
    // I will also add a test to find Artists in our display by their Genres
    @ParameterizedTest
    @Test
    void findArtistsByGenre() {
        // GIVEN
        String id = randomUUID().toString();


        // WHEN
        when (appDisplayService.findArtistsByGenre(id)).thenReturn(ArtistByGenre);
        AppDisplay appDisplay = appDisplayService.findArtistsByGenre(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The app displays the Artist Genre");
    }
    // Adding in a test to locate Artists by their year of music release

    @ParameterizedTest
    @Test
    void findArtistsByYear() {
        // GIVEN
        String id = randomUUID().toString();

        // WHEN
        when (appDisplayService.findArtistsByYear(id)).thenReturn(ArtistByYear);
        AppDisplay appDisplay = ArtistsByYear(id);

        // THEN
        Assertions.assertTrue((BooleanSupplier) appDisplay, "The appDisplay shows the year of release");
    }

    private AppDisplay ArtistsByYear(String id) {
        return ArtistsByYear(id);
    }
}


