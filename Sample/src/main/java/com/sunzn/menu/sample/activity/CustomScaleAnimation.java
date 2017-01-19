package com.sunzn.menu.sample.activity;

import android.graphics.Canvas;

import com.sunzn.menu.library.SlidingMenu;
import com.sunzn.menu.sample.R;

public class CustomScaleAnimation extends CustomAnimation {

	public CustomScaleAnimation() {
		super(R.string.anim_scale, new SlidingMenu.CanvasTransformer() {
			@Override
			public void transformCanvas(Canvas canvas, float percentOpen) {
				canvas.scale(percentOpen, 1, 0, 0);
			}			
		});
	}

}
