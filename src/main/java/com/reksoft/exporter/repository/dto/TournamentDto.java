package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class TournamentDto {
    private Integer id;
    private String name;
    private String organizer;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private List<TournamentParticipantInfoDto> teamParticipantInfos;
    private List<TournamentPrizeDto> tournamentPrizes;
}
