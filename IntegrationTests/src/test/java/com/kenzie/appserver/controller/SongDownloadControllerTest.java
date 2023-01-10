package com.kenzie.appserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.SongDownloadResponse;
import com.kenzie.appserver.service.model.SongInfo;
import com.kenzie.appserver.service.model.SongService;
import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@IntegrationTest
class SongDownloadControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    SongService songService;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createSongRequest_CreateSuccessful() throws Exception {
        //GIVEN
        String songId = "Crystallize";
        String artistByUserId = "Lindsey Stirling";
        String artistByGenre = "Pop";
        String artistByYear = "2012";

        SongDownloadResponse songDownloadResponse = new SongDownloadResponse();

        songDownloadResponse.setSongId(songId);
        songDownloadResponse.setArtistId(artistByUserId);
        songDownloadResponse.setArtistByGenre(artistByGenre);
        songDownloadResponse.setArtistByYear(artistByYear);
        songDownloadResponse.setIsFavorite(false);

        mapper.registerModule(new JavaTimeModule());

        //WHEN/THEN
        mvc.perform(post("/song")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(songDownloadResponse)))
                .andExpect(jsonPath("songId")
                        .exists())
                .andExpect(status().isCreated());

    }
    @Test
    public void getAllSongs_Success() throws Exception {
        //GIVEN
        String songId = "Royals";
        String artistByUserId = "Lorde";
        String artistByGenre = "Pop";
        String artistByYear = "2013";
        boolean isFavorite = false;

        songService.addNewSong(new SongInfo(songId, artistByUserId, artistByGenre, artistByYear, isFavorite));

        String songId2 = "Streets";
        String artistByUserId2 = "Doja Cat";
        String artistByGenre2 = "Pop";
        String artistByYear2 = "2019";
        boolean isFavorite2 = false;

        songService.addNewSong(new SongInfo(songId2,artistByUserId2,artistByGenre2,artistByYear2,isFavorite2));

        mvc.perform(get("/song/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].songId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistByYear").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistByGenre").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].isFavorite").isBoolean())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].songId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistByYear").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistByGenre").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].isFavorite").isBoolean());
    }
    @Test
    public void getAllFavoriteSongs_Success() throws Exception {
        //GIVEN
        String songId = "Royals";
        String artistByUserId = "Lorde";
        String artistByGenre = "Pop";
        String artistByYear = "2013";
        boolean isFavorite = false;

        songService.addNewSong(new SongInfo(songId, artistByUserId, artistByGenre, artistByYear, isFavorite));

        String songId2 = "Streets";
        String artistByUserId2 = "Doja Cat";
        String artistByGenre2 = "Pop";
        String artistByYear2 = "2019";
        boolean isFavorite2 = true;

        songService.addNewSong(new SongInfo(songId2,artistByUserId2,artistByGenre2,artistByYear2,isFavorite2));

        String songId3 = "Montero";
        String artistByUserId3 = "Lil Nas X";
        String artistByGenre3 = "Hip Hop";
        String artistByYear3 = "2021";
        boolean isFavorite3 = true;

        songService.addNewSong(new SongInfo(songId3,artistByUserId3,artistByGenre3,artistByYear3,isFavorite3));

        mvc.perform(get("/song/favorites")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].songId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistByYear").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistByGenre").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].isFavorite").isBoolean())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].songId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistId").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistByYear").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artistByGenre").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].isFavorite").isBoolean());
    }
}
