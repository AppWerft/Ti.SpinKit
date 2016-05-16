package de.appwerft.spinkit;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

@Kroll.module(name = "SpinKit", id = "de.appwerft.spinkit")
public class SpinKitModule extends KrollModule {
	private static final String LCAT = "SpinModule";
	
	@Kroll.constant
	public static final int TYPE_ROTATINGPLANE = 0;
	public static final int TYPE_DOUBLEBOUNCE = 1;
	public static final int TYPE_WAVE = 2;
	public static final int TYPE_WANDERINGCUBES = 3;
	public static final int TYPE_PULSE = 4;
	public static final int TYPE_CHASINGDOTS = 5;
	public static final int TYPE_THREEBOUNCE = 6;
	public static final int TYPE_CIRCLE = 7;
	public static final int TYPE_CUBEGRID = 8;
	public static final int TYPE_FADINGCIRCLE = 9;
	public static final int TYPE_FOLDINGCUBE = 10;
	public static final int TYPE_ROTATINGCIRCLE = 11;
	public SpinKitModule() {
		super();
	}
	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(LCAT, "inside onAppCreate");
	}

}
