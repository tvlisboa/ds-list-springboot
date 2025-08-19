package com.devsuperior.entities;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

/**
 * Classe intermediaria recebendo as chaves estrageiras
 */
@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

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
