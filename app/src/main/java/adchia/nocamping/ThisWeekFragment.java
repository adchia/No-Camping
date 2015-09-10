package adchia.nocamping;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.LinkedHashSet;
import java.util.Set;

public class ThisWeekFragment extends Fragment {

  private ViewGroup insightsView;
  private ViewGroup badgesView;
  private Set<Badge> badges = new LinkedHashSet<>();

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.this_week, container, false);
    insightsView = (ViewGroup) view.findViewById(R.id.week_insights);
    badgesView = (ViewGroup) view.findViewById(R.id.this_week_badges);
    badges.add(Badge.COFFEE);
    badges.add(Badge.FOODIE);
    badges.add(Badge.FRENCH);
    badges.add(Badge.LAPLACIAN);
    badges.add(Badge.PLAYA);

    int badgeSize = getResources().getDimensionPixelSize(R.dimen.this_week_badge_size);
    for(Badge badge : badges) {
      ImageView badgeView = new ImageView(getActivity());
      badgeView.setImageResource(badge.getDrawableId());
      badgeView.setLayoutParams(new ViewGroup.LayoutParams(badgeSize, badgeSize));
      badgesView.addView(badgeView);
    }

    addInsight(inflater, "Your favorite meeting room", "Empire Theater");
    addInsight(inflater, "Your favorite cafe", "Water Tower");
    addInsight(inflater, "Average time spent in meetings a day", "2 hours 13 min");
    return view;
  }

  private void addInsight(LayoutInflater inflater, String title, String value) {
    InsightView insightView = (InsightView) inflater.inflate(
        R.layout.this_week_insight, null);
    insightView.setTitle(title);
    insightView.setValue(value);
    insightsView.addView(insightView);
  }
}