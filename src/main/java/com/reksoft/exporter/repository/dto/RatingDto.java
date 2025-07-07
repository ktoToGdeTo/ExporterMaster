package com.reksoft.exporter.repository.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class RatingDto {
    private Integer id;
    private Integer score;
    private OffsetDateTime atMoment;
    private Integer teamId;
    private TeamDto team;
}