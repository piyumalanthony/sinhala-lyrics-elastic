package com.piyumal.elastic.sinhalalyricselastic.queryDsl;

import com.piyumal.elastic.sinhalalyricselastic.model.Lyrics;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    IndexCoordinates index = IndexCoordinates.of("songs");
    public SearchScrollHits<Lyrics> getAll(String text){
        text = text.trim();
        QueryBuilder query = QueryBuilders.boolQuery()
                .should(QueryBuilders.queryStringQuery(text).lenient(true).field("track_name_en").field("track_name_si",300.0f)
                        .field("album_name_en").field("album_name_si",2.0f).field("artist_name_en").field("artist_name_si",500.0f)
                .field("lyrics",50.0f).fuzziness(Fuzziness.AUTO).analyzeWildcard(true).analyzer("keyword"))
                .should(QueryBuilders.queryStringQuery("*"+text+"*")
                .lenient(true).field("track_name_en").field("track_name_si",300.0f)
                .field("album_name_en").field("album_name_si",2.0f).field("artist_name_en").field("artist_name_si",500.0f)
                .field("lyrics",150.0f).fuzziness(Fuzziness.AUTO).analyzeWildcard(true).analyzer("pattern"))
                .should(QueryBuilders.multiMatchQuery(text).field("track_name_en").field("track_name_si",300.0f)
                        .field("album_name_en").field("album_name_si",10.0f).field("artist_name_en").field("artist_name_si",500.0f)
                        .field("lyrics",50.0f).fuzziness(Fuzziness.AUTO).type(MultiMatchQueryBuilder.Type.BEST_FIELDS).analyzer("keyword"));
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
        SearchScrollHits<Lyrics> lyrics = elasticsearchRestTemplate.searchScrollStart(1000, nativeSearchQuery, Lyrics.class, index);
        return lyrics;
    }

}
