package com.piyumal.elastic.sinhalalyricselastic.controller;

import com.piyumal.elastic.sinhalalyricselastic.model.Lyrics;
import com.piyumal.elastic.sinhalalyricselastic.queryDsl.SearchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manual")
public class ManualSearch {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @CrossOrigin
    @GetMapping(value = "/search")
    public SearchScrollHits<Lyrics> getAll(@RequestParam String id) {
        return searchQueryBuilder.getAll(id);
    }
}

