package project.termproject;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerModel addPlayer(PlayerModel player) {
        PlayerEntity playerEntity = new PlayerEntity();
        BeanUtils.copyProperties(player, playerEntity);
        playerRepository.save(playerEntity);
        return player;
    }

}
