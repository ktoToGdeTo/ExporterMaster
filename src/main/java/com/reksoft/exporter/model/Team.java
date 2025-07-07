package com.reksoft.exporter.model;

import lombok.Data;

import java.util.List;

@Data
public class Team {
    private Integer Id;
    private String TeamName;
    private List<Player> Players;
}
