package com.camping.parcelle;

import com.camping.Louable;
import com.camping.TypeHebergement;
import com.camping.exception.LocationException;

/*
    TODO QUESTION : Quel est l'intérêt pour cette classe d'être abstraite ?
    Votre réponse : Cela permet de forcer les classes qui héritent de Home à implémenter les méthodes requises.
 */
public abstract class Home implements Louable {
    // TODO : Merci de respecter le principe d'encapsulation !
    private final int id;
    private final double prix;
    private int jourDebut;
    private int jourFin;
    /*
        TODO QUESTION : Que vaut initialement 'type' à la ligne suivante ?
        Votre réponse : 'type' vaut null, car un attribut de type objet non initialisé vaut null par défaut.
     */
    private final TypeHebergement type;

    // TODO : Améliorez le code de ce constructeur
    // TODO : Ecrire la javadoc (la plus complète possible) de la méthode ci-dessous
    /**
     * Construit un hébergement du camping.
     *
     * @param id        l'identifiant unique de l'hébergement
     * @param prix      le prix de la location par jour (doit être positif)
     * @param jourDebut le jour de début de la location (0 si non loué)
     * @param jourFin   le jour de fin de la location (0 si non loué)
     * @param type      le type d'hébergement ({@link TypeHebergement#EMPLACEMENT} ou {@link TypeHebergement#MOBIL_HOME})
     * @throws IllegalArgumentException si le prix est négatif
     */
    public Home(int id, double prix, int jourDebut, int jourFin, TypeHebergement type) {
        this.id = id;
        this.prix = prix;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
        this.type = type;
    }

    /*
        TODO QUESTION : La méthode ci-dessous n'a pas de code, c'est bizarre non ?
        Votre réponse : Non, c'est une méthode abstraite : elle n'a pas de corps ici,
        ce sont les classes filles (Location, MobilHome) qui sont obligées de fournir leur propre implémentation.
     */
    public abstract void display();

    // TODO : Codez ci-dessous les accesseurs/modificateurs UNIQUEMENT nécessaires
    @Override
    public int getId() {
        return id;
    }

    public double getPrix() {
        return prix;
    }

    public int getJourDebut() {
        return jourDebut;
    }

    public int getJourFin() {
        return jourFin;
    }

    public TypeHebergement getType() {
        return type;
    }

    public void setJourDebut(int jourDebut) {
        this.jourDebut = jourDebut;
    }

    public void setJourFin(int jourFin) {
        this.jourFin = jourFin;
    }

    // TODO : Rajoutez ce qu'il manque avant la signature de cette méthode
    @Override
    public void louer(int debut, int fin) throws LocationException {
        if (this.jourDebut != 0 || this.jourFin != 0) {
            // TODO : Déclencher la bonne Exception avec un message clair
            throw new LocationException("Impossible de louer : l'hébergement n°" + id + " est déjà loué.");
        }
        this.jourDebut = debut;
        this.jourFin = fin;
    }

    // TODO : Rajoutez ce qu'il manque avant la signature de cette méthode
    @Override
    public void liberer() throws LocationException {
        if (this.jourDebut == 0 && this.jourFin == 0) {
            // TODO : Déclencher la bonne Exception avec un message clair
            throw new LocationException("Impossible de libérer : l'hébergement n°" + id + " n'est pas loué.");
        }
        this.jourDebut = 0;
        this.jourFin = 0;
    }

    // TODO : Rajoutez ce qu'il manque avant la signature de cette méthode
    @Override
    public double calculerFacture() {
        if (this.jourDebut == 0 && this.jourFin == 0) {
            return 0.0;
        }
        return (this.jourFin - this.jourDebut) * this.prix; // TODO : Calculer le montant de la location
    }

}