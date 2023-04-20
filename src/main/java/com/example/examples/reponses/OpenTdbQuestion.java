package com.example.examples.reponses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenTdbQuestion {
    String category;
    String type;
    String difficulty;
    String question;
    String correct_answer;
    Iterable<String> incorrect_answers;

    public OpenTdbQuestion() {
    }

    public OpenTdbQuestion(String category, String type, String difficulty, String question, String correct_answer,
            Iterable<String> incorrect_answers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }
}
