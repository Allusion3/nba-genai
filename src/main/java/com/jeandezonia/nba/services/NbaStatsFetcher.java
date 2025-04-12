package com.jeandezonia.nba.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Map;

@Service
public class NbaStatsFetcher {

    private final WebClient client = WebClient.create("https://www.balldontlie.io/api/v1");

    // Map team names to their corresponding team IDs
    private static final Map<String, Integer> TEAM_NAME_TO_ID = Map.of(
            "Lakers", 14,
            "Warriors", 10,
            "Celtics", 2
            // Add more teams as needed
    );



    public String getLatestGameStats(String teamName) {
        Integer teamId = TEAM_NAME_TO_ID.get(teamName);
        if (teamId == null) {
            return String.format("Team '%s' not found. Please provide a valid team name.", teamName);
        }

        try {
            String response = client.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/games")
                            .queryParam("team_ids[]", teamId)
                            .queryParam("per_page", 1)
                            .queryParam("seasons[]", 2024)
                            .build())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            System.out.println("Fetching: /games?team_ids[]=" + teamId + "&per_page=1&seasons[]=2024");
            System.out.println("Raw response: " + response);

            return response;
        } catch (WebClientResponseException e) {
            System.err.println("Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw new RuntimeException("API call failed: " + e.getMessage());
        }
    }
}