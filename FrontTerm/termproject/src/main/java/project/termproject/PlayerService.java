package project.termproject;

import java.util.List;

public interface PlayerService {
    PlayerModel addPlayer(PlayerModel player);
    PlayerModel editPlayer(PlayerModel player);
    List<PlayerModel> getAllPlayers();
    PlayerModel getLatestPlayer();
}
