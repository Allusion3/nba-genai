package com.jeandezonia.nba.services;

import org.springframework.stereotype.Service;

@Service
public class OpenAiService {

    private final String apiKey = System.getenv("OPENAI_API_KEY");

    public String generateInsight(String prompt){
        // Here you would call the OpenAI API with the prompt and return the response.
        // For now, we'll just return a placeholder string.
        return "AI Response to: " + prompt;
    }

}
