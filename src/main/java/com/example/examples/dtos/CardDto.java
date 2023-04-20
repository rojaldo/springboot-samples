package com.example.examples.dtos;

import com.example.examples.entities.CardEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDto {
    public long id;
    public String question;
    @JsonProperty("right_answer")
    public String rightAnswer;
    @JsonProperty("incorrect_answers")
    public String[] incorrectAnswers;

    public CardDto() {
    }

    public CardDto(long id, String question, String rightAnswer, String[] incorrectAnswers) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public CardDto(CardEntity card){
        this.id = card.getId();
        this.question = card.getQuestion();
        this.rightAnswer = card.getRightAnswer();
        this.incorrectAnswers = card.getIncorrectAnswers().toArray(new String[0]);
    }
}
