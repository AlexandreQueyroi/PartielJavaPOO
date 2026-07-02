package com.camping;

/**
 * Ce fichier décrit une Enumeration Java
 * De quoi s'agit il ?
 * Les énumérations permettent de définir un ensemble fini d’éléments constants.
 * Ici l'énumération {@link TypeHebergement} définit les 2 types d'hébergement gérés : Emplacement pour un tente (parcelle) ou Mobil-home
 */
public enum TypeHebergement {
    EMPLACEMENT("Emplacement"),
    MOBIL_HOME("Mobil-home");
    // TODO : Un erreur s'est glissée dans cette classe => la corriger

    private final String label;

    TypeHebergement(String label) {
        this.label = label;
    }

    // TODO : Coder le getter
    public String getLabel() {
        return label;
    }

}