package s57map.model;

import org.springframework.stereotype.Component;

/**
 * 坐标
 * 
 * @author Zephyr
 *
 */
@Component("coordinates")
public class Coordinates {
	public double xcoo; // 经度
	public double ycoo; // 维度
	public double ve3d; // 深度

	/**
	 * @return the xcoo
	 */
	public double getXcoo() {
		return xcoo;
	}

	/**
	 * @param xcoo
	 *            the xcoo to set
	 */
	public void setXcoo(double xcoo) {
		this.xcoo = xcoo;
	}

	/**
	 * @return the ycoo
	 */
	public double getYcoo() {
		return ycoo;
	}

	/**
	 * @param ycoo
	 *            the ycoo to set
	 */
	public void setYcoo(double ycoo) {
		this.ycoo = ycoo;
	}

	/**
	 * @return the ve3d
	 */
	public double getVe3d() {
		return ve3d;
	}

	/**
	 * @param ve3d
	 *            the ve3d to set
	 */
	public void setVe3d(double ve3d) {
		this.ve3d = ve3d;
	}

	/**
	 * @param xcoo
	 * @param ycoo
	 * @param ve3d
	 */
	public Coordinates(double xcoo, double ycoo, double ve3d) {
		super();
		this.xcoo = xcoo;
		this.ycoo = ycoo;
		this.ve3d = ve3d;
	}

	public Coordinates() {
		super();
	}
}
