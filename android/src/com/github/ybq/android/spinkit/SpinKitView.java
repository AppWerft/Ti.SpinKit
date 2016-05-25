package com.github.ybq.android.spinkit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import de.appwerft.helpers.RHelper;

import com.github.ybq.android.spinkit.sprite.Sprite;

import org.appcelerator.kroll.common.Log;

/**
 * Created by ybq.
 */

public class SpinKitView extends ProgressBar {
	private static final String LCAT = "SpinView";
	private Style mStyle;
	private int mColor;
	private Sprite mSprite;

	public SpinKitView(Context context) {
		super(context);
		setIndeterminate(true);
	}

	public void initView(int color, int style) {
		mColor = color;
		mStyle = Style.values()[style];
		Sprite sprite = SpriteFactory.create(mStyle);
		setIndeterminateDrawable(sprite);
	}

	@Override
	public void setIndeterminateDrawable(Drawable d) {
		if (d instanceof Sprite) {
			setIndeterminateDrawable((Sprite) d);
		}
	}

	public void setIndeterminateDrawable(Sprite d) {
		super.setIndeterminateDrawable(d);
		mSprite = d;
		if (mSprite.getColor() == 0) {
			mSprite.setColor(mColor);
		}
		onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
		if (getVisibility() == VISIBLE) {
			mSprite.start();
		}
	}

	@Override
	public Sprite getIndeterminateDrawable() {
		return mSprite;
	}

	@Override
	public void unscheduleDrawable(Drawable who) {
		super.unscheduleDrawable(who);
		if (who instanceof Sprite) {
			((Sprite) who).stop();
		}
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		super.onWindowFocusChanged(hasWindowFocus);
		if (hasWindowFocus) {
			if (mSprite != null && getVisibility() == VISIBLE) {
				mSprite.start();
			}
		}
	}

	@Override
	public void onScreenStateChanged(int screenState) {
		super.onScreenStateChanged(screenState);
		if (screenState == View.SCREEN_STATE_OFF) {
			if (mSprite != null) {
				mSprite.stop();
			}
		}
	}

}
