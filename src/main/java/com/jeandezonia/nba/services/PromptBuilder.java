package com.jeandezonia.nba.services;

import com.jeandezonia.nba.model.GameStats;

public class PromptBuilder {

    public static String build(GameStats stats){
        return String.format("Summarize the performance of %s with %d points, %d rebounds, %d assists, %d steals, %d blocks, %d turnovers, %s field goal percentage, %s three point percentage, %s free throw percentage, %d fouls, %d plus/minus and %d bench points.",
                stats.getTeamName(),
                Integer.parseInt(stats.getPoints()),
                Integer.parseInt(stats.getRebounds()),
                Integer.parseInt(stats.getAssists()),
                Integer.parseInt(stats.getSteals()),
                Integer.parseInt(stats.getBlocks()),
                Integer.parseInt(stats.getTurnovers()),
                stats.getFieldGoalPercentage(),
                stats.getThreePointPercentage(),
                stats.getFreeThrowPercentage(),
                Integer.parseInt(stats.getFouls()),
                Integer.parseInt(stats.getPlusMinus()),
                Integer.parseInt(stats.getBenchPoints()));
    }


}
