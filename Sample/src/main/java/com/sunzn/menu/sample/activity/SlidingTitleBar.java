package com.sunzn.menu.sample.activity;

import android.os.Bundle;

import com.sunzn.menu.sample.R;
import com.sunzn.menu.sample.fragment.SampleListFragment;

public class SlidingTitleBar extends BaseActivity {

    public SlidingTitleBar() {
        super(R.string.title_bar_slide);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the Above View
        setContentView(R.layout.content_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();

        setSlidingActionBarEnabled(true);
    }

}
