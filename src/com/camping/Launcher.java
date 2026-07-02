package com.camping;

import com.camping.exception.LocationException;
import com.camping.parcelle.Home;
import com.camping.parcelle.Location;
import com.camping.parcelle.MobilHome;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        // la méthode ci-dessous permet de tester un scénario
        // une fois utilisée, corrigée, commentez la ligne
        testScenario();

        // Méthode pour lancer le programme à son gestionnaire
        runApp();
    }


    /* TODO QUESTION : Cette méthode est déclarée private. Qu'en pensez vous ?
       Votre réponse : C'est pour protéger la méthode de modifications externes
     */
    /* TODO QUESTION : Cette méthode est déclarée static. Qu'en pensez vous ?
       Votre réponse : C'est pour pouvoir l'appeler sans instancier la classe Launcher
     */
    private static void testScenario() {
        HomeList camping = new HomeList();
        camping.init();

        int jourJ = 150;

        System.out.println("=====================================================");
        System.out.println("  OUVERTURE SAISONNIÈRE DU CAMPING - ÉTAT INITIAL J" + jourJ);
        System.out.println("=====================================================");
        camping.display();
        System.out.println("=====================================================\n");

        System.out.println("--- TRAITEMENT DES ARRIVÉES CLIENTS ---");

        // TODO : Coder le scénario ci-dessous pour tester le bon fonctionnement du programme

        // 1. 7 personnes / Emplacement 200m2 / 10 jours
        // TODO : Coder ce scénario
        System.out.println("\n[1] 7 personnes / Emplacement 200m2 / 10 jours");
        traiterDemandeEmplacement(camping, 200, jourJ, jourJ + 10);

        // 2. Famille 3 personnes / Mobil-home (petit adéquat) / 15 jours
        // TODO : Coder ce scénario
        System.out.println("\n[2] Famille 3 personnes / Mobil-home petit / 15 jours");
        traiterDemandeMobilHome(camping, true, jourJ, jourJ + 15);

        // 3. Couple / Emplacement 60m2 / 7 jours
        // TODO : Coder ce scénario
        System.out.println("\n[3] Couple / Emplacement 60m2 / 7 jours");
        traiterDemandeEmplacement(camping, 60, jourJ, jourJ + 7);

        // 4. Famille 6 personnes / Mobil-home (obligatoirement grand) / 21 jours
        // TODO : Coder ce scénario
        System.out.println("\n[4] Famille 6 personnes / Mobil-home grand / 21 jours");
        traiterDemandeMobilHome(camping, false, jourJ, jourJ + 21);

        // 5. 3 copines / Emplacement 100m2 / 18 jours
        // TODO : Coder ce scénario
        System.out.println("\n[5] 3 copines / Emplacement 100m2 / 18 jours");
        traiterDemandeEmplacement(camping, 100, jourJ, jourJ + 18);

        // 6. Papi & mamie / Mobil-home 4 personnes (petit) / 60 jours
        // TODO : Coder ce scénario
        System.out.println("\n[6] Papi & mamie / Mobil-home petit / 60 jours");
        traiterDemandeMobilHome(camping, true, jourJ, jourJ + 60);

        System.out.println("\n=====================================================");
        System.out.println("  ÉTAT DU CAMPING APRÈS LES ENREGISTREMENTS DE J" + jourJ);
        System.out.println("=====================================================");
        camping.display();
        System.out.println("=====================================================");
    }



    private static void runApp() {
        HomeList camping = new HomeList();
        camping.init();

        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;
        int jourActuel = 150; // On démarre par défaut à la réouverture (J150)

        System.out.println("=====================================================");
        System.out.println("  BIENVENUE DANS L'INTERFACE DE GESTION DU CAMPING   ");
        System.out.println("=====================================================");

        // TODO : Inverser la condition 'continuer' par 'quitter'
        while (continuer) {
            System.out.println("\n--- [ JOUR ACTUEL DE LA SIMULATION : " + jourActuel + " ] ---");
            System.out.println("1. Afficher l'état global du camping (Emplacements & MH)");
            System.out.println("2. Enregistrer une location d'EMPLACEMENT (Tente)");
            System.out.println("3. Enregistrer une location de MOBIL-HOME");
            System.out.println("4. Rendre une location (Libérer un hébergement)");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");

            int choix = lireEntier(scanner);

            switch (choix) {
                case 1:
                    System.out.println("\n=== ÉTAT DES LOCATIONS ===");
                    // TODO : Coder ce qu'il faut pour afficher les locations
                    System.out.println("==========================");
                    break;
                case 2:
                    System.out.println("\n--- NOUVEL EMPLACEMENT (Tente) ---");
                    System.out.print("Taille souhaitée (60, 100, 150, 200) : ");
                    int taille = lireEntier(scanner);
                    System.out.print("Nombre de jours de séjour : ");
                    int nbJours = lireEntier(scanner);

                    // TODO : Coder ce qu'il faut pour faire la réservation (attention aux données)
                    // Si erreur avec la demande (données saisies), afficher un message explicatif
                    break;
                case 3:
                    System.out.println("\n--- NOUVEAU MOBIL-HOME ---");
                    System.out.println("1. Petit (4 personnes max - 30€/j)");
                    System.out.println("2. Grand (6 personnes max - 50€/j)");
                    System.out.print("Votre choix : ");
                    int typeMh = lireEntier(scanner);
                    System.out.print("Nombre de jours de séjour : ");
                    int joursM = lireEntier(scanner);

                    // TODO : Gérer la réservation de MobilHome selon le souhait du client
                    // Si erreur avec la demande (données saisies), afficher un message explicatif
                    break;
                case 4:
                    System.out.println("\n--- RENDRE UNE LOCATION ---");
                    System.out.print("Entrez le numéro (ID) de la location à libérer : ");
                    int idALiberer = lireEntier(scanner);

                    // TODO : Ici il faut spécifier l'ID de la location, mais ce n'est pas du tout intuitif de l'avoir
                    // => Coder ce qu'il faut (ailleurs dans le code) pour que l'utilisateur puisse connaitre l'ID de chaque location

                    // On cherche l'hébergement dans la liste globale
                    // TODO : Coder ce qu'il faut pour rendre la location
                    break;
                case 5:
                    System.out.println("\nBye Bye !");
                    // TODO : Oups.. apparemment le programme ne s'arrête jamais, corrigez
                    break;
                // TODO : prévoir un cas par défaut au cas où la saisie est incorrect pour afficher "[Erreur] Choix inconnu. Veuillez recommencer."
            }
        }

        scanner.close();
    }

    private static void traiterDemandeEmplacement(HomeList camping, int tailleDemandee, int debut, int fin) {
        int[] tailles = {60, 100, 150, 200};
        Home trouve = null;

        for (int t : tailles) {
            if (t >= tailleDemandee) {
                try {
                    trouve = camping.getFreeHome(t, debut);
                } catch (LocationException e) {
                    throw new RuntimeException(e);
                }
                if (trouve != null) break;
            }
        }

        if (trouve != null) {
            // TODO : Améliorer le code juste ci-dessous
            trouve.setJourDebut(debut);
            trouve.setJourFin(fin);

            /*
                TODO QUESTION : Que fait l'instruction suivante ? Et pourquoi ça marche ?
                Votre réponse :
             */
            Location loc = (Location) trouve;

            if (loc.getTaille() > tailleDemandee) {
                System.out.println("-> Succès ! Affecté à l'emplacement n°" + loc.getId() + " [SURCLASSÉ en " + loc.getTaille() + "m2]");
            } else {
                System.out.println("-> Succès ! Affecté à l'emplacement n°" + loc.getId() + " (" + loc.getTaille() + "m2)");
            }

            // TODO : Afficher le montant prévu pour la location
        } else {
            System.out.println("-> ÉCHEC : Aucun emplacement de disponible (même en surclassement).");
        }
    }

    private static void traiterDemandeMobilHome(HomeList camping, boolean veutPetit, int debut, int fin) {
        Home trouve = null;
        try {
            trouve = camping.getFreeHome(veutPetit, debut);
        } catch (LocationException e) {
            throw new RuntimeException(e);
        }

        // Surclassement automatique de petit vers grand si complet
        if (trouve == null && veutPetit) {
            try {
                trouve = camping.getFreeHome(false, debut);
            } catch (LocationException e) {
                throw new RuntimeException(e);
            }
        }

        if (trouve != null) {
            trouve.setJourDebut(debut);
            trouve.setJourFin(fin);

            MobilHome mh = (MobilHome) trouve;

            // TODO : Oups, un "magic number" => corrigez
            if (veutPetit && mh.getNbPersonnesMax() == 6) {
                System.out.println("-> Succès ! Affecté au Mobil-Home n°" + mh.getId() + " [SURCLASSÉ en Grand MH]");
            } else {
                System.out.println("-> Succès ! Affecté au Mobil-Home n°" + mh.getId());
            }
            System.out.printf("   Tarif : %.2f€/jour. Total prévu : %.2f€\n", mh.getPrix(), (fin - debut) * mh.getPrix());
        } else {
            System.out.println("-> ÉCHEC : Aucun Mobil-Home de cette catégorie (ou supérieure) disponible.");
        }
    }





    // Méthode utilitaire pour sécuriser les saisies du clavier
    private static int lireEntier(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Erreur : Veuillez entrer un nombre entier valide.");
            scanner.next();
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // Consomme le retour à la ligne restant
        return valeur;
    }
}