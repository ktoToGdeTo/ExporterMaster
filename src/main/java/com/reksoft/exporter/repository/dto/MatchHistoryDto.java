package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class MatchHistoryDto {
    private Integer id;
    private Integer winnerId;
    private Integer loserId;
    private Integer tournamentId;
    private OffsetDateTime date;
    private String winner;
    private String loser;
    private TournamentDto tournament;
}
