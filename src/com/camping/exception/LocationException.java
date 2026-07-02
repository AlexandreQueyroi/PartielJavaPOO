package com.camping.exception;

public class LocationException extends Exception {

    /* TODO QUESTION : Selon vous, A quoi sert ce constructeur ?
       Votre réponse : Il permet de créer une exception avec un message personnalisé.
     */
    public LocationException(String message) {
        super(message);
    }
}
