package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCsvReportService {

    private final TeamService teamService;

    public File generateReport(String filePath) throws IOException {
        List<Team> players = teamService.getTeams();

        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("ID; Team Name; Players");

            for (Team team : players) {
                String line = String.join("; ",
                        String.valueOf(team.getId()),
                        team.getTeamName(),
                        getStringPlayers(team.getPlayers())

                );
                writer.println(line);
            }
        }
        return file;
    }

    private String getStringPlayers(List<Player> players){
        String res = "";
        for(Player player : players){
            res += player.getCombinedName() + ", ";
        }
        res = res.substring(0, res.length()-2);
        return res;
    }
}
