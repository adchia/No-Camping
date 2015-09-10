package adchia.nocamping;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedHashSet;
import java.util.Set;

public class HistoryFragment extends Fragment {

  private ViewGroup badgesView;
  private Set<Badge> badges = new LinkedHashSet<>();

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_history, container, false);
    badgesView = (ViewGroup) view.findViewById(R.id.history_badges);
    badges.add(Badge.COFFEE);
    badges.add(Badge.FOODIE);
    badges.add(Badge.FRENCH);
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
    badgeRow.setBadge(badge, count);
    badgesView.addView(badgeRow);
  }
}