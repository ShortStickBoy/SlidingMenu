package com.sunzn.menu.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;

import com.sunzn.menu.sample.R;

/**
 * Created by sunzn on 2017/1/17.
 */

public class ExampleListActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);

        this.addPreferencesFromResource(R.xml.main);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen screen, Preference pref) {
        Class<?> cls = null;
        String title = pref.getTitle().toString();
        if (title.equals(getString(R.string.properties))) {
            cls = PropertiesActivity.class;
        } else if (title.equals(getString(R.string.attach))) {
            cls = AttachExample.class;
        } else if (title.equals(getString(R.string.changing_fragments))) {
            cls = FragmentChangeActivity.class;
        } else if (title.equals(getString(R.string.left_and_right))) {
            cls = LeftAndRightActivity.class;
        } else if (title.equals(getString(R.string.responsive_ui))) {
            cls = ResponsiveUIActivity.class;
        } else if (title.equals(getString(R.string.viewpager))) {
            cls = ViewPagerActivity.class;
        } else if (title.equals(getString(R.string.title_bar_slide))) {
            cls = SlidingTitleBar.class;
        } else if (title.equals(getString(R.string.title_bar_content))) {
            cls = SlidingContent.class;
        } else if (title.equals(getString(R.string.anim_zoom))) {
            cls = CustomZoomAnimation.class;
        } else if (title.equals(getString(R.string.anim_scale))) {
            cls = CustomScaleAnimation.class;
        } else if (title.equals(getString(R.string.anim_slide))) {
            cls = CustomSlideAnimation.class;
        }
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        return true;
    }

}
