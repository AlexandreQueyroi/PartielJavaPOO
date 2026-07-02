package com.camping;

import com.camping.exception.LocationException;

public interface Louable {

    // TODO : Corriger les 2 incohérences dans cette interface

    void louer() throws LocationException;

    void liberer() throws LocationException;

    double calculerFacture();

    int getId();

    public default boolean estDisponible() {
        return true;
    }
}