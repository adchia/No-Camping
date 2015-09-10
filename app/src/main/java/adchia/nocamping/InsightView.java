package adchia.nocamping;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Controls a single insight for a user
 */
public class InsightView extends LinearLayout {

  private TextView titleView;
  private TextView valueView;

  public InsightView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();

    this.titleView = (TextView) findViewById(R.id.insight_title);
    this.valueView = (TextView) findViewById(R.id.insight_value);
  }

  public void setTitle(String title) {
    titleView.setText(title);
  }

  public void setValue(String value) {
    valueView.setText(value);
  }
}
