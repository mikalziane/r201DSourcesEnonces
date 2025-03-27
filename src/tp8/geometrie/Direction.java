package tp8.geometrie;
import java.util.Random;

public enum Direction {
  EST(1, 0), NORD_EST(1, 1), NORD(0, 1), NORD_OUEST(-1, 1),
  OUEST (-1, 0), SUD_OUEST(-1, -1), SUD(0, -1), SUD_EST(1, -1);
  
  // deplacement relatif de la direction
  private final int dx, dy;

  private Direction(int dx, int dy) {
    this.dx = dx; this.dy = dy;
  }

  /** Retourne le deplacement sur l'axe des x correspondant a la
   * direction courante.
   * @return le deplacement en x
   */
  public int getDx() {
    return dx;
  }

  /** Retourne le deplacement sur l'axe des y correspondant a la
   * direction courante.
   * @return le déplacement en y
   */
  public int getDy() {
    return dy;
  }
  /** Retourne une direction inverse a la direction courante.
   * @return la direction opposee
   */
  public Direction inverser() {
    return Direction.values()[(this.ordinal() + 4) % 8];
  }
  
  /** Retourne une direction derivee par rapport a la 
   * direction courante d'un angle aleatoirement choisi et
   * compris entre (-marge * 45°) et (+marge * 45°). La derivation
   * est choisie necessairement pour etre un multiple de 45°.
   * @param marge la tolerance
   * @return la nouvelle direction
   */
  public Direction deriver(int marge) {
    Random rd = new Random();
    int d = (8 + this.ordinal() + (rd.nextInt(marge * 2 + 1) - marge)) % 8;
    return Direction.values()[d];
  }
}
