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
import android.content.res.Resources;

import com.github.ybq.android.spinkit.sprite.Sprite;

/**
 * Created by ybq.
 */
public class SpinKitView extends ProgressBar {

	private Style mStyle;
	private int mColor;
	private Sprite mSprite;

	public SpinKitView(Context context) {
		this(context, null);
	}

	public SpinKitView(Context context, AttributeSet attrs) {
		// original version
		// this(context, attrs, R.attr.SpinKitViewStyle);
		// Titanium implementation:
		this(context, attrs, RHelper.getResource("attr", "SpinKitViewStyle"));
	}

	public SpinKitView(Context context, AttributeSet attrs, int defStyleAttr) {
		// original version :
		// this(context, attrs, defStyleAttr, R.style.SpinKitView);
		// Titanium implementation:
		this(context, attrs, defStyleAttr, RHelper.getResource("style",
				"SpinKitView"));
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public SpinKitView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		int s[] = { RHelper.getResource("styleable", "SpinKitView") }; // this will not found
		TypedArray a = context.obtainStyledAttributes(attrs, s, defStyleAttr,
				defStyleRes);
		mStyle = Style.values()[a.getInt(
				RHelper.getResource("styleable", "SpinKitView_SpinKit_Style"),
				0)];
		mColor = a.getColor(
				RHelper.getResource("styleable", "SpinKitView_SpinKit_Color"),
				Color.WHITE);
		a.recycle();
		init();
		setIndeterminate(true);
	}

	private void init() {
		Sprite sprite = SpriteFactory.create(mStyle);
		setIndeterminateDrawable(sprite);
	}

	@Override
	public void setIndeterminateDrawable(Drawable d) {
		if (!(d instanceof Sprite)) {
			throw new IllegalArgumentException(
					"this d must be instanceof Sprite");
		}
		setIndeterminateDrawable((Sprite) d);
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
