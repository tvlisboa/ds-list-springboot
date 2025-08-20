package com.devsuperior.services;
import com.devsuperior.dto.GameListDTO;
import com.devsuperior.entities.GameList;
import com.devsuperior.repositories.GameListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    public List<GameListDTO> findByListId(Long listId) {
        List<GameList> result = gameListRepository.findById(Long listId);
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}

