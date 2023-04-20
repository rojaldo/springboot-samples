package com.example.examples.reponses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenTdbResponse {
    public String response_code;
    public Iterable<OpenTdbQuestion> results;

    public OpenTdbResponse() {
    }

    public OpenTdbResponse(String response_code, Iterable<OpenTdbQuestion> results) {
        this.response_code = response_code;
        this.results = results;
    }
}
