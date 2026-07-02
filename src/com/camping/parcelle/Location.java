package com.camping.parcelle;

import com.camping.TypeHebergement;

public class Location extends Home {
    private int taille;

    public Location(int id, int taille, double prix, int jourDebut, int jourFin) {
        // TODO : Coder ce qu'il faut pour que ça marche
        super(id, prix, jourDebut, jourFin, TypeHebergement.EMPLACEMENT);
        this.taille = taille;
    }

    public int getTaille() { return taille; }

    // TODO : Cette classe ne semble pas compiler, pourquoi ? Coder ce qui manque pour que ça compile
    @Override
    public void display() {
        if (getJourDebut() == 0 && getJourFin() == 0) {
            System.out.println("Emplacement n°" + getId() + " (" + taille + "m2, " + getPrix() + "€/j) : libre");
        } else {
            System.out.println("Emplacement n°" + getId() + " (" + taille + "m2, " + getPrix() + "€/j) : loué du jour " + getJourDebut() + " au jour " + getJourFin());
        }
    }
}