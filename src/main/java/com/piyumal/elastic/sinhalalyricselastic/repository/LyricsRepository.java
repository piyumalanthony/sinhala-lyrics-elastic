package com.piyumal.elastic.sinhalalyricselastic.repository;

import com.piyumal.elastic.sinhalalyricselastic.model.Lyrics;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LyricsRepository extends ElasticsearchRepository<Lyrics, String> {
}
