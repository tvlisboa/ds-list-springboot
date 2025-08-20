package com.devsuperior.projections;

/**
 * Metodos correspondentes a consulta sql
 */

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
