package adchia.nocamping;

/**
 * Possible badges a user can own.
 */
public enum Badge {
  COFFEE("Coffee Addict badge", R.drawable.coffee),
  FOODIE("Foodie badge", R.drawable.foodie),
  FRENCH("Fancy French badge", R.drawable.french),
  JET_SETTER("Jet Setter badge", R.drawable.jet_setter),
  LAPLACIAN("Laplacian badge", R.drawable.laplacian),
  LISTENER("Listener badge", R.drawable.listener),
  MEETING("Meeting Monster badge", R.drawable.meeting),
  PLAYA("Playa badge", R.drawable.playa),
  WATER("Water Coolie badge", R.drawable.water);

  private final String badgeName;
  private final int drawableId;

  Badge(String badgeName, int drawableId) {
    this.badgeName = badgeName;
    this.drawableId = drawableId;
  }

  public int getDrawableId() {
    return drawableId;
  }

  public String getBadgeName() {
    return badgeName;
  }
}
