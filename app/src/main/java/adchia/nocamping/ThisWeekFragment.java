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

  private static final String LISTENER_KEY = "BadgeClickListener";

  private BadgeClickListener listener;
  private ViewGroup insightsView;
  private ViewGroup badgesView;
  private Set<Badge> badges = new LinkedHashSet<>();

  public static ThisWeekFragment newInstance(BadgeClickListener listener) {
    ThisWeekFragment fragment = new ThisWeekFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(LISTENER_KEY, listener);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_this_week, container, false);
    listener = (BadgeClickListener) getArguments().getSerializable(LISTENER_KEY);
    insightsView = (ViewGroup) view.findViewById(R.id.week_insights);
    badgesView = (ViewGroup) view.findViewById(R.id.this_week_badges);
    badges.add(Badge.COFFEE);
    badges.add(Badge.FOODIE);
    badges.add(Badge.NO_CAMPING);
    badges.add(Badge.LAPLACIAN);
    badges.add(Badge.PLAYA);

    int badgeSize = getResources().getDimensionPixelSize(R.dimen.this_week_badge_size);
    for(final Badge badge : badges) {
      ImageView badgeView = new ImageView(getActivity());
      badgeView.setImageResource(badge.getDrawableId());
      badgeView.setLayoutParams(new ViewGroup.LayoutParams(badgeSize, badgeSize));
      badgeView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          listener.onBadgeClicked(badge);
        }
      });
      badgesView.addView(badgeView);
    }

    addInsight(inflater, "Your favorite meeting room", "Empire Theater");
    addInsight(inflater, "Your favorite cafe", "Water Tower");
    addInsight(inflater, "Average time spent in meetings a day", "2 hours 13 min");
    return view;
  }

  private void addInsight(LayoutInflater inflater, String title, String value) {
    InsightView insightView = (InsightView) inflater.inflate(
        R.layout.this_week_insight, insightsView, false);
    insightView.setTitle(title);
    insightView.setValue(value);
    insightsView.addView(insightView);
  }
}