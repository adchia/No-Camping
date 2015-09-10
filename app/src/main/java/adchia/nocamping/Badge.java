package adchia.nocamping;

/**
 * Possible badges a user can own.
 */
public enum Badge {
  COFFEE(R.drawable.coffee),
  FOODIE(R.drawable.foodie),
  FRENCH(R.drawable.french),
  JET_SETTER(R.drawable.jet_setter),
  LAPLACIAN(R.drawable.laplacian),
  LISTENER(R.drawable.listener),
  MEETING(R.drawable.meeting),
  PLAYA(R.drawable.playa),
  WATER(R.drawable.water);

  private final int drawableId;

  Badge(int drawableId) {
    this.drawableId = drawableId;
  }

  public int getDrawableId() {
    return drawableId;
  }
}
