package com.piyumal.elastic.sinhalalyricselastic.textprocessor;

import org.deeplearning4j.models.word2vec.Word2Vec;

import java.util.Collection;

public class preprocessor {

    private Word2Vec  word2Vec ;

    public Collection<String> getSimilarWords(String text) {
        Collection<String> list = word2Vec.wordsNearest(text,10);
        return list;
    }
}
