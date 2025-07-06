package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerApiRepository playerApiRepository;

    @Override
    public List<Player> getPlayers() {
        List<PlayerViewDto> playerViewDtos = playerApiRepository.getPlayers();
        return playerViewDtos.stream().map(this::map).toList();
    }

    private Player map(PlayerViewDto playerViewDto) {
        Player player = new Player();
        player.setId(playerViewDto.getId());
        player.setCountry(playerViewDto.getCountry());
        player.setNickname(playerViewDto.getNickName());
        player.setCombinedName(playerViewDto.getCombinedName());
        player.setTeamName(playerViewDto.getTeamName());
        player.setFullName(generateFullName(
                playerViewDto.getCombinedName(),
                playerViewDto.getNickName()
        ));
        return player;
    }

    private String generateFullName(String combinedName, String nickname) {
        String[] names = combinedName.split(" ");
        String firstName = names.length > 0 ? names[0] : "";
        String lastName = names.length > 1 ? names[1] : "";

        return String.format("%s \"%s\" %s", firstName, nickname, lastName).trim();
    }
}
