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
    public int id;
    public double prix;
    public int jourDebut;
    public int jourFin;
    /*
        TODO QUESTION : Que vaut initialement 'type' à la ligne suivante ?
        Votre réponse :
     */
    public TypeHebergement type;

    // TODO : Améliorez le code de ce constructeur
    // TODO : Ecrire la javadoc (la plus complète possible) de la méthode ci-dessous
    public Home(int id, double prix, int jourDebut, int jourFin, TypeHebergement type) {
        this.id = id;
        this.prix = prix;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
        this.type = type;
    }

    /*
        TODO QUESTION : La méthode ci-dessous n'a pas de code, c'est bizarre non ?
        Votre réponse :
     */
    public abstract void display();

    // TODO : Codez ci-dessous les accesseurs/modificateurs UNIQUEMENT nécessaires


    // TODO : Rajoutez ce qu'il manque avant la signature de cette méthode
    public void louer(int debut, int fin) throws LocationException {
        if (this.jourDebut != 0 || this.jourFin != 0) {
            // TODO : Déclencher la bonne Exception avec un message clair
        }
        this.jourDebut = debut;
        this.jourFin = fin;
    }

    // TODO : Rajoutez ce qu'il manque avant la signature de cette méthode
    public void liberer() throws LocationException {
        if (this.jourDebut == 0 && this.jourFin == 0) {
            // TODO : Déclencher la bonne Exception avec un message clair
        }
        this.jourDebut = 0;
        this.jourFin = 0;
    }

    // TODO : Rajoutez ce qu'il manque avant la signature de cette méthode
    public double calculerFacture() {
        if (this.jourDebut == 0 && this.jourFin == 0) {
            return 0.0;
        }
        return // TODO : Calculer le montant de la location
    }

}