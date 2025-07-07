package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerCsvReportService {

    private final PlayerService playerService;

    public File generateReport(String filePath) throws IOException {
        List<Player> players = playerService.getPlayers();

        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("ID; Combined Name; Nickname; Country; Team Name; Full Name");

            for (Player player : players) {
                String line = String.join("; ",
                        String.valueOf(player.getId()),
                        player.getCombinedName(),
                        player.getNickname(),
                        player.getCountry() != null ? String.valueOf(player.getCountry()) : "",
                        player.getTeamName(),
                        player.getFullName().replace("\"\"", "\"")
                );
                writer.println(line);
            }
        }
        return file;
    }
}
