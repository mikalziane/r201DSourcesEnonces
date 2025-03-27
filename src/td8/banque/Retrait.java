package td8.banque;

import java.text.DateFormat;
import java.util.Date;

public class Retrait {
  /** Duree d'un jour exprimee en millisecondes */
  private static final long UN_JOUR = 24 * 60 * 60 * 1000L;

  /** Montant du retrait */
  private long montant;
  /** Date du retrait */
  private Date date;

  /**
   * Construit un retrait antidate par rapport a aujourd'hui
   * 
   * @param montant
   *          Montant du retrait
   * @param nbj
   *          Nombre de jours a retirer par rapport a aujourd'hui
   */
  public Retrait(long montant, int nbj) {
    assert (montant > 0);
    this.montant = montant;
    Date aujourdhui = new Date();
    this.date = new Date(aujourdhui.getTime() - (UN_JOUR * nbj));
  }

  /**
   * Construit un retrait date a la date d'aujourd'hui
   * 
   * @param montant
   *          Montant du retrait
   */
  public Retrait(long montant) {
    this(montant, 0);
  }

  /**
   * Retourne le nombre de jours separant le retrait de la date d'aujourd'hui
   */
  public long age() {
    Date aujourdhui = new Date();
    return (aujourdhui.getTime() - date.getTime()) / UN_JOUR;
  }

  /**
   * Retourne le montant du retrait
   */
  public long montant() {
    return montant;
  }

  @Override
  public String toString() {
    DateFormat df = DateFormat.getDateInstance();
    return montant + "€ (le " + df.format(date) + ")";
  }

  public static void main(String[] args) {
    System.out.println(new Retrait(300));
    Retrait r = new Retrait(600, 3);
    System.out.println(r);
    System.out.println("il date de " + r.age() + " jour(s)");
  }
}
