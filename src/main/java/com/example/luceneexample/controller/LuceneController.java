package com.example.luceneexample.controller;

import com.example.luceneexample.service.LuceneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lucene")
public class LuceneController {

    private LuceneService service;

    public LuceneController(LuceneService service) {
        this.service = service;
    }

    @GetMapping("{query}")
    public ResponseEntity<?> searchMatchInIndexForQuery(@RequestHeader String query){
        float result = service.searchMatchInIndexForQuery(query);
        return result > 0 ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
