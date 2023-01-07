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
    public void getBySongId_Exists() throws Exception {
        //GIVEN
        String songId = "Streets";
        String artistByUserId = "Doja Cat";
        String artistByGenre = "Pop";
        String artistByYear = "2019";

        SongInfo songInfo = new SongInfo(songId,artistByUserId,artistByGenre,artistByYear);

        songService.addNewSong(songInfo);

        String songName = songService.findBySongId(songInfo.getSongId()).getSongId();

        mvc.perform(get("/song/{songId}", songInfo.getSongId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("songId"))
                        .value((is(songId))))
                .andExpect(status().isOk());
    }

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
}
