package com.piyumal.elastic.sinhalalyricselastic.controller;

import com.piyumal.elastic.sinhalalyricselastic.model.Lyrics;
import com.piyumal.elastic.sinhalalyricselastic.model.User;
import com.piyumal.elastic.sinhalalyricselastic.repository.LyricsRepository;
import com.piyumal.elastic.sinhalalyricselastic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {


    @Autowired
    UserRepository userRepository;

    @Autowired
    LyricsRepository lyricsRepository;

    @PostMapping(value = "/user", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public int saveUser(@RequestBody List<User> userdata) {
        userRepository.saveAll(userdata);
        return userdata.size();
    }

    @GetMapping("/findAll")
    public Iterable<User> findAllCustomers() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/lyrics", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public int saveLyrics(@RequestBody List<Lyrics> lyricsData) {
        lyricsRepository.saveAll(lyricsData);
        return lyricsData.size();
    }

    @GetMapping("/findAllLyrics")
    public Iterable<Lyrics> findAllLyrics() {
        return lyricsRepository.findAll();
    }

}
