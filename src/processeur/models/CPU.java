package processeur.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Application "CPU".
 *
 * Cette classe représente un CPU d'un ordinateur.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class CPU {

    /**
     * Cette constante (-1.0) représente une performance MIPS (Millions Instructions
     * Per Second) inconnue.
     */
    public static final double UNKNOWN_MIPS = -1.0;

    /**
     * Attribut qui représente le nom du CPU.
     */
    private final String nom;

    /**
     * Attribut qui représente l'année de sortie du CPU.
     */
    private final int annee;

    /**
     * Attribut qui représente le nombre de transistors utilisés dans le CPU.
     */
    private final long transistors;

    /**
     * Attribut qui représente la performance en MIPS (Millions Instructions Per
     * Second) du CPU.
     */
    private final double mips;

    /**
     * Constructeur de la classe CPU à utiliser lorsqu'on connaît la valeur de
     * chaque attribut.
     *
     * @param nom         le nom du CPU
     * @param annee       l'année de sortie du CPU
     * @param transistors le nombre de transistors utilisés dans le CPU
     * @param mips        la performance en MIPS (Millions Instructions Per Second)
     *                    du CPU
     */
    public CPU(String nom, int annee, long transistors, double mips) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
        this.mips = mips;
    }

    /**
     * Constructeur de la classe CPU à utiliser lorsqu'on ne connaît pas la
     * performance du CPU. Dans ce cas, l'attribut
     * "mips" sera initialisé avec la valeur UNKNOWN_MIPS pour indiquer que cette
     * information n'est pas connue.
     *
     * @param nom         le nom du CPU
     * @param annee       l'année de sortie du CPU
     * @param transistors le nombre de transistors utilisés dans le CPU
     */
    public CPU(String nom, int annee, long transistors) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
        this.mips = UNKNOWN_MIPS;
    }

    public String toString() {
        String aRetourner = "";
        DecimalFormat formatage = new DecimalFormat("#,###");
        DecimalFormat formatageMips = new DecimalFormat("#,###0.00");
        DecimalFormatSymbols apostrophe = new DecimalFormatSymbols();
        DecimalFormatSymbols point = new DecimalFormatSymbols();
        apostrophe.setGroupingSeparator('\'');
        point.setDecimalSeparator('.');
        point.setGroupingSeparator('\'');

        formatage.setDecimalFormatSymbols(apostrophe);
        formatageMips.setDecimalFormatSymbols(point);

        if (mips == UNKNOWN_MIPS) {
            aRetourner = "En " + annee + " le CPU " + nom + " avec " + formatage.format(transistors) +
            " transistors et une puissance de calcul inconnue.";
        } else {
            aRetourner = "En " + annee + " le CPU " + nom + " avec " + formatage.format(transistors) +
            " transistors et une puissance de calcul de " + formatageMips.format(mips) + " mips.";
        }

        return aRetourner;
    }

    /**
     * Getter de l'attribut nom.
     *
     * @return la valeur de l'attribut nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter de l'attribut annee.
     *
     * @return la valeur de l'attribut annee
     */

    public int getAnnee() {
        return this.annee;
    }

    /**
     * Getter de l'attribut transistors.
     *
     * @return la valeur de l'attribut transistors
     */
    public long getTransistors() {
        return this.transistors;
    }

    /**
     * Getter de l'attribut mips.
     *
     * @return la valeur de l'attribut mips
     */
    public double getMips() {
        return this.mips;
    }
}