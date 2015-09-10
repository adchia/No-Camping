package adchia.nocamping;

import java.io.Serializable;

public interface BadgeClickListener extends Serializable {
  void onBadgeClicked(Badge badge);
}