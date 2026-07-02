package com.camping;

import com.camping.exception.LocationException;
import com.camping.parcelle.Home;
import com.camping.parcelle.Location;
import com.camping.parcelle.MobilHome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    TODO QUESTION : A quoi sert selon vous la classe Serializable (vous avez le droit faire des recherches dans la doc 😉) ?
    Votre réponse : Permet de sérialiser les objets pour les stocker dans un fichier ou les envoyer sur un réseau.

 */
public class HomeList implements Serializable {
    /*
        TODO QUESTION : Les hébergements sont tous stockés dans une List. Pourquoi pas un tableau ? ou une autre structure ?
        Votre réponse : Contrairement à un tableau de taille fixe, une List a une taille dynamique
        et offre des méthodes pratiques (add, remove...). On aurait aussi pu utiliser une Map<Integer, Home> pour des
        recherches plus rapides.
     */
    private final List<Home> listeHebergements;

    public HomeList() {
        // TODO : Oups, une ligne a été supprimée ici. Pouvez-vous remettre comme avant.
        this.listeHebergements = new ArrayList<>();
    }

    // Méthode init() pour remplir le camping (12 emplacements + 7 mobil-homes)
    public void init() {
        // TODO : Remplacez les lignes suivantes d'initialisation par un code plus "pro" et correct

        // 12 Emplacements de tentes
        listeHebergements.add(new Location(0, 60, 10.0, 0, 0));
        listeHebergements.add(new Location(1, 60, 10.0, 0, 0));
        listeHebergements.add(new Location(2, 60, 10.0, 0, 0));
        listeHebergements.add(new Location(3, 100, 20.0, 0, 0));
        listeHebergements.add(new Location(4, 100, 20.0, 0, 0));
        listeHebergements.add(new Location(5, 100, 20.0, 0, 0));
        listeHebergements.add(new Location(6, 100, 20.0, 0, 0));
        listeHebergements.add(new Location(7, 150, 30.0, 0, 0));
        listeHebergements.add(new Location(8, 150, 30.0, 0, 0));
        listeHebergements.add(new Location(9, 150, 30.0, 0, 0));
        listeHebergements.add(new Location(10, 200, 40.0, 0, 0));
        listeHebergements.add(new Location(11, 200, 40.0, 0, 0));

        // 7 Mobil-homes
        listeHebergements.add(new MobilHome(0, 4, 30.0, 0, 0));
        listeHebergements.add(new MobilHome(1, 4, 30.0, 0, 0));
        listeHebergements.add(new MobilHome(2, 4, 30.0, 0, 0));
        listeHebergements.add(new MobilHome(3, 6, 50.0, 0, 0));
        listeHebergements.add(new MobilHome(4, 6, 50.0, 0, 0));
        listeHebergements.add(new MobilHome(5, 6, 50.0, 0, 0));
        listeHebergements.add(new MobilHome(6, 6, 50.0, 0, 0));
    }

    // TODO : Coder une méthode pour afficher l'ensemble des emplacements
    public void display() {
        for (Home home : listeHebergements) {
            home.display();
        }
    }

    // TODO : Coder une méthode statique pour afficher l'ensemble des emplacements selon un type donné (Location ou MobilHome) passé en paramètre
    public static void displayAllByType(List<Home> listeHebergements, TypeHebergement type) {
        for (Home home : listeHebergements) {
            if (home.getType() == type) {
                home.display();
            }
        }
    }

    // TODO : Coder une méthode 'getFreeHome' permettant de renvoyer le 1er emplacement disponible (non utilisée) selon une taille et une journée.
    // Si aucun dispo, renvoyer la bonne exception
    public Home getFreeHome(int taille, int jour) throws LocationException {
        for (Home home : listeHebergements) {
            if (home instanceof Location location) {
                if (location.getTaille() == taille && location.getJourDebut() == 0 && location.getJourFin() == 0) {
                    return location;
                }
            }
        }
        throw new LocationException("Aucun emplacement de " + taille + "m2 disponible au jour " + jour + ".");
    }

    // TODO : Coder une méthode 'getFreeHome' permettant de renvoyer le 1er Mobil-Home disponible (non utilisée) selon une taille et une journée.
    // Si aucun dispo, renvoyer la bonne exception
    public Home getFreeHome(boolean petit, int jour) throws LocationException {
        int capacite = petit ? MobilHome.CAPACITE_PETIT : MobilHome.CAPACITE_GRAND;
        for (Home home : listeHebergements) {
            if (home instanceof MobilHome mobilHome) {
                if (mobilHome.getNbPersonnesMax() == capacite && mobilHome.getJourDebut() == 0 && mobilHome.getJourFin() == 0) {
                    return mobilHome;
                }
            }
        }
        throw new LocationException("Aucun Mobil-Home " + (petit ? "petit" : "grand") + " disponible au jour " + jour + ".");
    }

    // TODO : Coder une méthode 'freeHome' permettant de libérer un hébergement selon son ID et afficher le montant de la facture.
    // Si l'hébergement n'existe pas, renvoyer la bonne exception
    public void freeHome(int id) throws LocationException {
        for (Home home : listeHebergements) {
            if (home.getId() == id) {
                System.out.println("Montant de la facture : " + home.calculerFacture() + "€");
                home.liberer();
                return;
            }
        }
        throw new LocationException("Aucun hébergement avec l'ID " + id + ".");
    }

}