package com.devsuperior.dto;
import com.devsuperior.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    /**
     * Construtor vazio
     */
    public GameListDTO() {
    }

    /**
     * Construtor com parametros
     * pra receber as entidades
     */

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
