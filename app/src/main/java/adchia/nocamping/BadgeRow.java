package adchia.nocamping;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import adchia.nocamping.Badge;
import adchia.nocamping.R;

/**
 * Custom layout for a row of a badge in the history fragment.
 */
public class BadgeRow extends FrameLayout {

  private ImageView badgeIcon;
  private TextView badgeTitle;
  private TextView badgeCount;

  public BadgeRow(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();

    badgeIcon = (ImageView) findViewById(R.id.history_badge_icon);
    badgeTitle = (TextView) findViewById(R.id.history_badge_name);
    badgeCount = (TextView) findViewById(R.id.history_badge_count);
  }

  public void setBadge(Badge badge, int count) {
    badgeIcon.setImageResource(badge.getDrawableId());
    badgeTitle.setText(badge.getBadgeName());
    badgeCount.setText(Integer.toString(count));
    if (count > 10) {
      badgeCount.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
    } else if (count > 5) {
      badgeCount.getBackground().setColorFilter(0xff7077, PorterDuff.Mode.SRC_ATOP);
    } else {
      badgeCount.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
    }
  }
}
