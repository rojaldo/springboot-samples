package com.example.examples.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.examples.dtos.CardDto;
import com.example.examples.entities.CardEntity;
import com.example.examples.reponses.OpenTdbQuestion;
import com.example.examples.reponses.OpenTdbResponse;
import com.example.examples.repositories.TdbRepository;

@Service
public class TdbService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TdbRepository tdbRepository;

    public void getQuestionsFromApi() {
        OpenTdbResponse questions = restTemplate.getForObject("https://opentdb.com/api.php?amount=10", OpenTdbResponse.class);
        for (OpenTdbQuestion otdb : questions.results) {
                this.tdbRepository.save(new CardEntity(otdb));
        }
    }

    public Iterable<CardDto> getQuestions() {
        List<CardDto> questions = new ArrayList<>();
        for (CardEntity card : this.tdbRepository.findAll()) {
            questions.add(new CardDto(card));
        }
        return questions;
    }
    
}
