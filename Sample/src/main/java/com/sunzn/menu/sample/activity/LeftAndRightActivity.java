package com.sunzn.menu.sample.activity;

import android.os.Bundle;

import com.sunzn.menu.library.SlidingMenu;
import com.sunzn.menu.sample.R;
import com.sunzn.menu.sample.fragment.SampleListFragment;

public class LeftAndRightActivity extends BaseActivity {

    public LeftAndRightActivity() {
        super(R.string.left_and_right);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCH_MODE_FULLSCREEN);

        setContentView(R.layout.content_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();

        getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
        getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_two, new SampleListFragment()).commit();
    }

}
