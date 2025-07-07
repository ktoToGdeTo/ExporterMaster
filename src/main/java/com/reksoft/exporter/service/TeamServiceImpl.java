package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.PlayerDto;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import com.reksoft.exporter.repository.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamApiRepository teamApiRepository;

    @Override
    public List<Team> getTeams() {
        List<TeamDto> teamDtos = teamApiRepository.getTeams();
        return teamDtos.stream().map(this::map).toList();
    }

    private Team map(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setTeamName(teamDto.getName());
        List<Player> players = new ArrayList<>();
        List<PlayerViewDto> playersDtos = teamDto.getPlayers();
        for (PlayerViewDto playerViewDto : playersDtos){
            Player player = new Player();
            player.setId(playerViewDto.getId());
            player.setCombinedName(playerViewDto.getCombinedName());
            player.setNickname(playerViewDto.getNickName());
            player.setCountry(playerViewDto.getCountry());
            player.setTeamName(playerViewDto.getTeamName());
            players.add(player);
        }
        team.setPlayers(players);
        return team;
    }
}
