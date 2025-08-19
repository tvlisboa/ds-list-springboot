package com.devsuperior.services;
import com.devsuperior.dto.GameDTO;
import com.devsuperior.dto.GameMinDTO;
import com.devsuperior.entities.Game;
import com.devsuperior.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    /**
     * Busca no banco de dados o GAME
     * e converte para um DTO
     * salvando na variavel result.
     */

    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).collect(Collectors.toList());
        return dto;
    }
}

