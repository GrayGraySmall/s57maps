package s57map.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 岛屿类
 * @author Zephyr
 *
 */
@Component("landArea")
public class LandArea {
	private ArrayList<Coordinates> coord = new ArrayList<Coordinates>(); //岛屿坐标

	/**
	 * @param vectorId
	 * @param coord
	 * @param objl
	 */
	public LandArea(Coordinates coord) {
		super();
		this.coord.add(coord);
	}

	public LandArea() {

	}
	
	/**
	 * @return the coord
	 */
	public ArrayList<Coordinates> getCoord() {
		return coord;
	}

	/**
	 * @param coord
	 *            the coord to set
	 */
	public void setCoord(Coordinates coord) {
		this.coord.add(coord);
	}
}
