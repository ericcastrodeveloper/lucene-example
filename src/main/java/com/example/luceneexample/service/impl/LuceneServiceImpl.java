package com.example.luceneexample.service.impl;

import com.example.luceneexample.service.LuceneService;
import org.springframework.stereotype.Service;

@Service
public class LuceneServiceImpl implements LuceneService {

    public LuceneServiceImpl(LuceneMemory luceneMemory) {
        this.luceneMemory = luceneMemory;
    }

    private LuceneMemory luceneMemory;


    @Override
    public float searchMatchInIndexForQuery(String query) {
        return luceneMemory.getSearchResult(query);

    }
}
