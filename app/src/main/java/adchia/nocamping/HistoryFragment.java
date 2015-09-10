package adchia.nocamping;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedHashSet;
import java.util.Set;

public class HistoryFragment extends Fragment {

  private BadgeClickListener listener;
  private ViewGroup badgesView;
  private Set<Badge> badges = new LinkedHashSet<>();

  private static final String LISTENER_KEY = "BadgeClickListener";

  public static HistoryFragment newInstance(BadgeClickListener listener) {
    HistoryFragment fragment = new HistoryFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(LISTENER_KEY, listener);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_history, container, false);
    listener = (BadgeClickListener) getArguments().getSerializable(LISTENER_KEY);
    badgesView = (ViewGroup) view.findViewById(R.id.history_badges);
    badges.add(Badge.COFFEE);
    badges.add(Badge.FOODIE);
    badges.add(Badge.NO_CAMPING);
    badges.add(Badge.LAPLACIAN);
    badges.add(Badge.PLAYA);
    badges.add(Badge.MEETING);

    for(Badge badge : badges) {
      addBadgeRow(inflater, badge, (int) (Math.random() * 10));
    }
    return view;
  }

  private void addBadgeRow(LayoutInflater inflater, Badge badge, int count) {
    BadgeRow badgeRow = (BadgeRow) inflater.inflate(
        R.layout.history_badge, badgesView, false);
    badgeRow.setBadge(badge, count, listener);
    badgesView.addView(badgeRow);
  }
}