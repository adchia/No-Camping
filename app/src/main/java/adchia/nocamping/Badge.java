package adchia.nocamping;

import android.content.res.Resources;

/**
 * Possible badges a user can own.
 */
public enum Badge {
  NO_CAMPING(R.string.no_camping_name,
      R.string.no_camping_blurb, R.string.no_camping_explanation, R.drawable.nocamping),
  COFFEE(R.string.coffee_name,
      R.string.coffee_blurb, R.string.coffee_explanation, R.drawable.coffee),
  FOODIE(R.string.foodie_name,
      R.string.foodie_blurb, R.string.foodie_explanation, R.drawable.foodie),
  JET_SETTER(R.string.jet_setter_name,
      R.string.jet_setter_blurb, R.string.jet_setter_explanation, R.drawable.jet_setter),
  LAPLACIAN(R.string.laplacian_name,
      R.string.laplacian_blurb, R.string.laplacian_explanation, R.drawable.laplacian),
  LISTENER(R.string.listener_name,
      R.string.listener_blurb, R.string.listener_explanation, R.drawable.listener),
  MEETING(R.string.meeting_name,
      R.string.meeting_blurb, R.string.meeting_explanation, R.drawable.meeting),
  PLAYA(R.string.playa_name,
      R.string.playa_blurb, R.string.playa_explanation, R.drawable.playa),
  WATER(R.string.water_name,
      R.string.water_blurb, R.string.water_explanation, R.drawable.water);

  private final int badgeNameId;
  private final int badgeBlurbId;
  private final int badgeExplanationId;
  private final int drawableId;

  Badge(int badgeNameId, int badgeBlurbId, int badgeExplanationId, int drawableId) {
    this.badgeNameId = badgeNameId;
    this.badgeBlurbId = badgeBlurbId;
    this.badgeExplanationId = badgeExplanationId;
    this.drawableId = drawableId;
  }

  public int getDrawableId() {
    return drawableId;
  }

  public String getBadgeName(Resources resources) {
    return resources.getString(badgeNameId);
  }

  public String getBadgeBlurb(Resources resources) {
    return resources.getString(badgeBlurbId);
  }

  public String getBadgeExplanation(Resources resources) {
    return resources.getString(badgeExplanationId);
  }
}
