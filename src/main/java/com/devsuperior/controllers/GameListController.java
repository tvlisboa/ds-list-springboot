package com.devsuperior.controllers;
import com.devsuperior.dto.GameDTO;
import com.devsuperior.dto.GameListDTO;
import com.devsuperior.dto.GameMinDTO;
import com.devsuperior.entities.GameList;
import com.devsuperior.services.GameListService;
import com.devsuperior.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/{listId/games}")
    public List<GameListDTO> findByListId(@PathVariable  Long listId) {
        List<GameListDTO> result = gameListService.findByListId(listId);
        return result;
    }
}
