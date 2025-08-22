package com.devsuperior.controllers;
import com.devsuperior.dto.GameDTO;
import com.devsuperior.dto.GameListDTO;
import com.devsuperior.dto.GameMinDTO;
import com.devsuperior.dto.ReplacementDTO;
import com.devsuperior.entities.GameList;
import com.devsuperior.services.GameListService;
import com.devsuperior.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    /**
     * Busca todas as listas de jogos
     */

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    /**
     * Busca a lista por um id
     * especifico
     */

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findBylist(@PathVariable  Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    /**
     * Reposicionamento do jogo na lista
     * atualizando no banco de dados
     */

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable  Long listId, @RequestBody ReplacementDTO body) {
        gameListService.moveList(listId, body.getSourceIndex(), body.getDestIndex());
    }
}
