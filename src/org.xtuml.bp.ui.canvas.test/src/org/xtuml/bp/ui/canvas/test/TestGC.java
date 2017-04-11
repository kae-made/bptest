/*
 * Created on Feb 25, 2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package org.xtuml.bp.ui.canvas.test;

import java.util.ArrayList;

import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.ScaledGraphics;

/**
 * @author campbell
 * 
 *         To change the template for this generated type comment go to
 *         Window>Preferences>Java>Code Generation>Code and Comments
 */
public class TestGC extends ScaledGraphics {
	ArrayList<String> testRecord = new ArrayList<String>();
	/**
	 * @param graphics
	 */
	public TestGC(SWTGraphics graphics) {
		super(graphics);
	}

	public void drawLine(int i, int j, int k, int l) {
		super.drawLine(i, j, k, l);
		testRecord.add("drawline(...)");			  
	}

	public void drawRectangle(int i, int j, int k, int l) {
		super.drawRectangle(i, j, k, l);
		testRecord.add("drawRectangle(...)");
	}

	public void drawText(String str, int i, int j) {
		super.drawText(str, i, j);
		String substring = str;
		if (str.length() > 17) {
			substring = str.substring(0, 16);
			substring += "...";
		}
		testRecord.add("drawText(\"" + substring + "\", ...)");
	}

	@Override
	public void drawString(String s, int x, int y) {
		super.drawString(s, x, y);
		String substring = s;
		if (s.length() > 17) {
			substring = s.substring(0, 16);
			substring += "...";
		}
		testRecord.add("drawString(\"" + substring + "\", ...)");
	}

	@Override
	public void drawPolyline(int[] points) {
		super.drawPolyline(points);
		String pointString = "drawPolyline(\"";
		for(int i = 0 ; i < points.length; i++) {
			if(i != points.length - 1)
				pointString = pointString + points[i] + ", ";
			else
				pointString = pointString + points[i];
		}
		pointString = pointString + ")";
		testRecord.add("drawPolyline(" + points.length + " omitted points)");
	}

	public String[] getResults() {
		String[] result = new String[testRecord.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = (String) testRecord.get(i);
		}
		return result;
	}
}
