package com.piyumal.elastic.sinhalalyricselastic.config;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.piyumal.elastic.sinhalalyricselastic.repository")
public class Config {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
//}
//
//// ...
//
//    @Autowired
//    RestHighLevelClient highLevelClient;
//
//    RestClient lowLevelClient = highLevelClient.lowLevelClient();
//
//// ...
//
//    IndexRequest request = new IndexRequest("spring-data", "elasticsearch", randomID())
//            .source(singletonMap("feature", "high-level-rest-client"))
//            .setRefreshPolicy(IMMEDIATE);
//
//    IndexResponse response = highLevelClient.index(request);
}
