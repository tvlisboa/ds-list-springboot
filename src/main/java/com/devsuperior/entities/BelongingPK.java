package com.devsuperior.entities;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

/**
 * Classe intermediaria recebendo as chaves estrageiras
 * multiplas, com mais de um uso
 */

@Embeddable
public class BelongingPK {


    /**
     * O meu jogo sera mapeado na
     * tabela game_id
     */

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    /**
     * A minha lista de jogos sera
     * mapeado na tabela
     * list_id
     */

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    /**
     * Construtor vazio
     */

    public BelongingPK() {
    }

    /**
     * Construtor cheio
     */

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    /**
     * Metodos acessores
     * Getters and setters
     */

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        BelongingPK that = (BelongingPK) object;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
