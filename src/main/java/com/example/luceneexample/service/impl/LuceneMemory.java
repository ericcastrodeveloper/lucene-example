package com.example.luceneexample.service.impl;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.memory.MemoryIndex;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LuceneMemory {
    private Analyzer analyzer;
    @Value("${lucene.memory.content}")
    private String memoryContent;

    public LuceneMemory() {
        this.analyzer = new StandardAnalyzer();
    }

    public float getSearchResult(String query){
        QueryParser parser = new QueryParser("content", analyzer);
        try {
            return getMemoryIndex().search(parser.parse(query));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error to parser a query");
        }
    }

    private MemoryIndex getMemoryIndex(){
        MemoryIndex memoryIndex = new MemoryIndex();
        memoryIndex.addField("content", memoryContent, analyzer);
        return memoryIndex;
    }
}
