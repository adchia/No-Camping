package adchia.nocamping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NoCampingActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_no_camping);
    getSupportFragmentManager().beginTransaction()
        .add(R.id.activity_container, new SplashFragment())
        .commit();
  }
}
