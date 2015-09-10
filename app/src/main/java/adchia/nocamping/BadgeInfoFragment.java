package adchia.nocamping;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import adchia.nocamping.R;

/**
 * Created by adchia on 9/10/15.
 */
public class BadgeInfoFragment extends DialogFragment {

  private static final String BADGE_KEY = "Badge";

  private Badge badge;
  private ImageView badgeIconView;
  private TextView badgeBlurbView;
  private TextView badgeExplanationView;

  static BadgeInfoFragment newInstance(Badge badge) {
    BadgeInfoFragment fragment = new BadgeInfoFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(BADGE_KEY, badge);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    badge = (Badge) getArguments().getSerializable(BADGE_KEY);

    inflater = inflater.cloneInContext(new ContextThemeWrapper(getActivity(),
        R.style.FullScreenDialog));
    View view = inflater.inflate(R.layout.fragment_badge_info, container, false);
    badgeIconView = (ImageView) view.findViewById(R.id.badge_main_icon);
    badgeBlurbView = (TextView) view.findViewById(R.id.badge_blurb);
    badgeExplanationView = (TextView) view.findViewById(R.id.badge_explanation);
    badgeIconView.setImageResource(badge.getDrawableId());
    badgeBlurbView.setText(badge.getBadgeBlurb(getResources()));
    badgeExplanationView.setText(badge.getBadgeExplanation(getResources()));

    Toolbar toolbar = (Toolbar) view.findViewById(R.id.tabanim_toolbar);
    toolbar.inflateMenu(R.menu.badge_info_menu);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.menu_share) {
          dismiss();
          return true;
        }
        return false;
      }
    });
    return view;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    // creating the fullscreen dialog
    final Dialog dialog = new Dialog(getActivity(), R.style.FullScreenDialog);
    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    return dialog;
  }
}
