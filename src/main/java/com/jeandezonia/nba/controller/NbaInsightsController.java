package com.jeandezonia.nba.controller;

import com.jeandezonia.nba.model.GameStats;
import com.jeandezonia.nba.services.OpenAiService;
import com.jeandezonia.nba.services.PromptBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nba")
public class NbaInsightsController {

    @Autowired
    private OpenAiService openAiService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateInsight(@RequestBody GameStats stats) {
        String prompt = PromptBuilder.build(stats);
        String response = openAiService.generateInsight(prompt);
        return ResponseEntity.ok(response);
    }

}
