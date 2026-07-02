package com.camping.parcelle;

import com.camping.TypeHebergement;

public class MobilHome extends Home {
    private int nbPersonnesMax;

    public MobilHome(int id, int nbPersonnesMax, double prix, int jourDebut, int jourFin) {
        // TODO : Coder ce qu'il faut pour que ça marche

        this.nbPersonnesMax = nbPersonnesMax;
    }

    public int getNbPersonnesMax() { return nbPersonnesMax; }

    @Override
    public void display() {
        // TODO : Transformer le code ci-dessous avec une expression ternaire
        String type;
        if (this.nbPersonnesMax <= 4) {
            type = "petit";
        }
        else type = "grand";

        // TODO : Afficher dans la console les infos du MobilHome mais
        // 1. S'il est pas loué, le fait qu'il soit 'libre'
        // 2. S'il n'est pas disponible, ses jours de réservation
    }
}