package adchia.nocamping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Splash page fragment
 */
public class SplashFragment extends android.support.v4.app.Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_splash, container, false);
    View button = view.findViewById(R.id.login_button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getFragmentManager().beginTransaction()
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
            .remove(SplashFragment.this)
            .add(R.id.activity_container, new DashboardFragment())
            .commit();
      }
    });
    return view;
  }
}
