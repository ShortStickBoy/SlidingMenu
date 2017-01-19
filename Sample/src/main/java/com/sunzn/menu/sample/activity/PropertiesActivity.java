package com.sunzn.menu.sample.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.sunzn.menu.library.SlidingMenu;
import com.sunzn.menu.sample.R;
import com.sunzn.menu.sample.fragment.SampleListFragment;

public class PropertiesActivity extends BaseActivity {

    public PropertiesActivity() {
        super(R.string.app_name);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSlidingActionBarEnabled(true);

        setContentView(R.layout.properties);

        // left and right modes
        RadioGroup mode = (RadioGroup) findViewById(R.id.mode);
        mode.check(R.id.left);
        mode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SlidingMenu sm = getSlidingMenu();
                switch (checkedId) {
                    case R.id.left:
                        sm.setMode(SlidingMenu.LEFT);
                        sm.setShadowDrawable(R.drawable.shadow);
                        break;
                    case R.id.right:
                        sm.setMode(SlidingMenu.RIGHT);
                        sm.setShadowDrawable(R.drawable.shadowright);
                        break;
                    case R.id.left_right:
                        sm.setMode(SlidingMenu.LEFT_RIGHT);
                        sm.setSecondaryMenu(R.layout.menu_frame_two);
                        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_two, new SampleListFragment()).commit();
                        sm.setSecondaryShadowDrawable(R.drawable.shadowright);
                        sm.setShadowDrawable(R.drawable.shadow);
                }
            }
        });

        // touch mode stuff
        RadioGroup touchAbove = (RadioGroup) findViewById(R.id.touch_above);
        touchAbove.check(R.id.touch_above_full);
        touchAbove.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.touch_above_full:
                        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCH_MODE_FULLSCREEN);
                        break;
                    case R.id.touch_above_margin:
                        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCH_MODE_MARGIN);
                        break;
                    case R.id.touch_above_none:
                        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCH_MODE_NONE);
                        break;
                }
            }
        });

        // scroll scale stuff
        SeekBar scrollScale = (SeekBar) findViewById(R.id.scroll_scale);
        scrollScale.setMax(1000);
        scrollScale.setProgress(333);
        scrollScale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                getSlidingMenu().setBehindScrollScale((float) seekBar.getProgress() / seekBar.getMax());
            }
        });


        // behind width stuff
        SeekBar behindWidth = (SeekBar) findViewById(R.id.behind_width);
        behindWidth.setMax(1000);
        behindWidth.setProgress(750);
        behindWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float percent = (float) seekBar.getProgress() / seekBar.getMax();
                getSlidingMenu().setBehindWidth((int) (percent * getSlidingMenu().getWidth()));
                getSlidingMenu().requestLayout();
            }
        });

        // shadow stuff
        CheckBox shadowEnabled = (CheckBox) findViewById(R.id.shadow_enabled);
        shadowEnabled.setChecked(true);
        shadowEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    getSlidingMenu().setShadowDrawable(getSlidingMenu().getMode() == SlidingMenu.LEFT ? R.drawable.shadow : R.drawable.shadowright);
                else
                    getSlidingMenu().setShadowDrawable(null);
            }
        });
        SeekBar shadowWidth = (SeekBar) findViewById(R.id.shadow_width);
        shadowWidth.setMax(1000);
        shadowWidth.setProgress(75);
        shadowWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float percent = (float) seekBar.getProgress() / (float) seekBar.getMax();
                int width = (int) (percent * (float) getSlidingMenu().getWidth());
                getSlidingMenu().setShadowWidth(width);
                getSlidingMenu().invalidate();
            }
        });

        // fading stuff
        CheckBox fadeEnabled = (CheckBox) findViewById(R.id.fade_enabled);
        fadeEnabled.setChecked(true);
        fadeEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getSlidingMenu().setBehindFadeEnabled(isChecked);
            }
        });
        SeekBar fadeDeg = (SeekBar) findViewById(R.id.fade_degree);
        fadeDeg.setMax(1000);
        fadeDeg.setProgress(666);
        fadeDeg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                getSlidingMenu().setBehindFadeDegree((float) seekBar.getProgress() / seekBar.getMax());
            }
        });
    }

}
