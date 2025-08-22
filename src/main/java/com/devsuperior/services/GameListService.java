package com.devsuperior.services;
import com.devsuperior.dto.GameListDTO;
import com.devsuperior.entities.GameList;
import com.devsuperior.projections.GameMinProjection;
import com.devsuperior.repositories.GameListRepository;
import com.devsuperior.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    /**
     * Busca todas as lista de jogos em banco
     */

    @Transactional
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    /**
     * Mover a ordem do jogo dentro da lista
     */


    @Transactional
    public void moveList(Long listId, int sourceIndex, int destIndex) {
        List<GameMinProjection> list  = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(sourceIndex, obj);

        int min = sourceIndex <  destIndex ? sourceIndex : destIndex;
        int max = sourceIndex < destIndex ? destIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}

