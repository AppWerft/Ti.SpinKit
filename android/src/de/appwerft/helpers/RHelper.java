package de.appwerft.helpers;

import org.appcelerator.titanium.util.TiRHelper;
import android.content.Context;
import java.lang.reflect.Field;
import org.appcelerator.titanium.util.TiRHelper.ResourceNotFoundException;
import org.appcelerator.kroll.common.Log;

public class RHelper {
	public static int getString(String str) {
		try {
			return TiRHelper.getApplicationResource("string." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getStyle(String str) {
		try {
			return TiRHelper.getApplicationResource("style." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getAttr(String str) {
		try {
			return TiRHelper.getApplicationResource("attr." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getStyleable(String str) {
		Log.d("RHelper", "styleable." + str);
		try {
			return TiRHelper.getApplicationResource("styleable." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getLayout(String str) {
		try {
			return TiRHelper.getApplicationResource("layout." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getId(String str) {
		try {
			return TiRHelper.getApplicationResource("id." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getDrawable(String str) {
		try {
			return TiRHelper.getApplicationResource("drawable." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getColor(String str) {
		try {
			return TiRHelper.getApplicationResource("color." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getRaw(String str) {
		try {
			return TiRHelper.getApplicationResource("raw." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getXML(String str) {
		try {
			return TiRHelper.getApplicationResource("xml." + str);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int getResource(String type, String name) {
		int res = 0;
		if (name != null) {
			int index = name.lastIndexOf(".");
			if (index > 0)
				name = name.substring(0, index);
			try {
				res = TiRHelper.getApplicationResource(type + "." + name);
				Log.d("RHelper", "try to get platform/android/res/" + type
						+ "/" + name);
			} catch (TiRHelper.ResourceNotFoundException ex) {
				Log.e("RHelper", type + "." + name
						+ " not found; make sure it's in platform/android/res/"
						+ type);
			}
		}
		return res;
	}

	/*********************************************************************************
	 * Returns the resource-IDs for all attributes specified in the given
	 * <declare-styleable>-resource tag as an int array.
	 *
	 * @param context
	 *            The current application context.
	 * @param name
	 *            The name of the <declare-styleable>-resource-tag to pick.
	 * @return All resource-IDs of the child-attributes for the given
	 *         <declare-styleable>-resource or <code>null</code> if this tag
	 *         could not be found or an error occured.
	 *********************************************************************************/
	public static final int[] getResourceDeclareStyleableIntArray(
			Context context, String name) {
		try {
			Field[] fields2 = Class.forName(
					context.getPackageName() + ".R$styleable").getFields();
			for (Field f : fields2) {
				if (f.getName().equals(name)) {
					int[] ret = (int[]) f.get(null);
					return ret;
				}
			}
		} catch (Throwable t) {
		}

		return null;
	}

}
