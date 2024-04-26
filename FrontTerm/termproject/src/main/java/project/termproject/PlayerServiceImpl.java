package project.termproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
        if (player != null) {
            BeanUtils.copyProperties(player, playerEntity);
        }
        playerRepository.save(playerEntity);
        return player;
    }

    @Override
    public PlayerModel editPlayer(PlayerModel player) {
        PlayerEntity playerEntity = playerRepository.findById(player.getId()).get();
        if (playerEntity != null) {
            BeanUtils.copyProperties(player, playerEntity);
            playerRepository.save(playerEntity);
        }
        return player;
    }

    @Override
    public List<PlayerModel> getAllPlayers() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();
        List<PlayerModel> playerModels = new ArrayList<>();
        for (PlayerEntity playerEntity : playerEntities) {
            PlayerModel playerModel = new PlayerModel();
            BeanUtils.copyProperties(playerEntity, playerModel);
            playerModels.add(playerModel);
        }
        return playerModels;
    }

    @Override
    public PlayerModel getLatestPlayer() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();
        PlayerModel playerModel = new PlayerModel();
        if (playerEntities.size() > 0) {
            PlayerEntity playerEntity = playerEntities.get(playerEntities.size() - 1);
            BeanUtils.copyProperties(playerEntity, playerModel);
        }
        return playerModel;
    }
}
