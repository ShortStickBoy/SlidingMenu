package com.sunzn.menu.sample.activity;

import android.os.Bundle;

import com.sunzn.menu.library.SlidingMenu;
import com.sunzn.menu.sample.R;
import com.sunzn.menu.sample.fragment.SampleListFragment;

public abstract class CustomAnimation extends BaseActivity {

    private SlidingMenu.CanvasTransformer mTransformer;

    public CustomAnimation(int titleRes, SlidingMenu.CanvasTransformer transformer) {
        super(titleRes);
        mTransformer = transformer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the Above View
        setContentView(R.layout.content_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SampleListFragment()).commit();

        SlidingMenu sm = getSlidingMenu();
        setSlidingActionBarEnabled(true);
        sm.setBehindScrollScale(0.0f);
        sm.setBehindCanvasTransformer(mTransformer);
    }

}
