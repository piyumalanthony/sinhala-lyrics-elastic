package com.piyumal.elastic.sinhalalyricselastic;

import com.piyumal.elastic.sinhalalyricselastic.model.Lyrics;
import com.piyumal.elastic.sinhalalyricselastic.repository.LyricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication

public class SinhalaLyricsElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinhalaLyricsElasticApplication.class, args);
	}

}
