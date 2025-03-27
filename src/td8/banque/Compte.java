package td8.banque;

public class Compte {
  private static long decouvertMax = 1000;
  private static int numeroSuivant = 1;

  public static void setDecouvertMax(long val) {
    assert (val >= 0);
    decouvertMax = val;
  }

  public static long getDecouvertMax() {
    return decouvertMax;
  }

  private int numero;
  private long solde;

  public Compte(long val) {
    assert (val >= 0);
    numero = numeroSuivant;
    ++numeroSuivant;
    solde = val;
  }

  public void deposer(long val) {
    assert (val > 0);
    solde += val;
  }

  public boolean retraitPossible(long val) {
    return val > 0 && solde - val >= -decouvertMax;
  }

  public void retirer(long val) {
    assert (retraitPossible(val));
    solde -= val;
  }

  @Override
  public String toString() {
    String s = "le compte n°" + numero + " est ";
    if (solde >= 0)
      s += "credite de " + solde;
    else
      s += "a decouvert de " + (-solde);
    return s + "€";
  }

  public static void main(String[] args) {
    Compte c = new Compte(0);
    c.deposer(1234);
    System.out.println(c);
    c.retirer(1734);
    System.out.println(c);
  }
}
