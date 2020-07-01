package com.piyumal.elastic.sinhalalyricselastic.repository;

import com.piyumal.elastic.sinhalalyricselastic.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
}
