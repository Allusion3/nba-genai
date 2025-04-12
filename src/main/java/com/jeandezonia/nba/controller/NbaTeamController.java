package com.jeandezonia.nba.controller;

import com.jeandezonia.nba.services.NbaStatsFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nba")
public class NbaTeamController {

    private final NbaStatsFetcher statsFetcher;

    public NbaTeamController(NbaStatsFetcher statsFetcher) {
        this.statsFetcher = statsFetcher;
    }

    @GetMapping("/{teamName}")
    public String getTeamStats(@PathVariable String teamName) {
        return statsFetcher.getLatestGameStats(teamName);
    }
}