package com.example.examples.entities;

import java.util.List;

import com.example.examples.reponses.OpenTdbQuestion;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String RightAnswer;
    private List<String> incorrectAnswers;

    public CardEntity() {
    }

    public CardEntity(String category, String type, String difficulty, String question, String rightAnswer,
            Iterable<String> incorrectAnswers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        RightAnswer = rightAnswer;
        this.incorrectAnswers = (List<String>) incorrectAnswers;
    }

    public CardEntity(OpenTdbQuestion otdb) {
        this.category = otdb.getCategory();
        this.type = otdb.getType();
        this.difficulty = otdb.getDifficulty();
        this.question = otdb.getQuestion();
        RightAnswer = otdb.getCorrect_answer();
        this.incorrectAnswers = (List<String>) otdb.getIncorrect_answers();
    }
    
}
