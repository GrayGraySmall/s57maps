package s57map.model;
/**
 * ����2d��3d����
 */
import org.springframework.stereotype.Component;

@Component("object2dand3d")
public class Object2dAnd3d {
	private int vectorId = 0; //矢量标识
	private int objl = 0; //物标标识
	private double xcoo = 0.0;//经度
	private double ycoo = 0.0;//纬度
	private double ve3d = 0.0;//深度
	private String objectClass = null;//物标名称
	private String primitives = null;//物标属性
	
	public Object2dAnd3d() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param vectorId
	 * @param objl
	 * @param xcoo
	 * @param ycoo
	 * @param ve3d
	 * @param objectClass
	 * @param primitives
	 */
	public Object2dAnd3d(int vectorId, int objl, double xcoo, double ycoo, double ve3d, String objectClass,
			String primitives) {
		super();
		this.vectorId = vectorId;
		this.objl = objl;
		this.xcoo = xcoo;
		this.ycoo = ycoo;
		this.ve3d = ve3d;
		this.objectClass = objectClass;
		this.primitives = primitives;
	}



	public int getVectorId() {
		return vectorId;
	}

	public void setVectorId(int vectorId) {
		this.vectorId = vectorId;
	}

	public int getobjl() {
		return objl;
	}

	public void setobjl(int objl) {
		this.objl = objl;
	}

	public double getXcoo() {
		return xcoo;
	}

	public void setXcoo(double xcoo) {
		this.xcoo = xcoo;
	}

	public double getYcoo() {
		return ycoo;
	}

	public void setYcoo(double ycoo) {
		this.ycoo = ycoo;
	}

	public double getVe3d() {
		return ve3d;
	}

	public void setVe3d(double ve3d) {
		this.ve3d = ve3d;
	}

	public String getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}

	public String getPrimitives() {
		return primitives;
	}

	public void setPrimitives(String primitives) {
		this.primitives = primitives;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Object2dAnd3d [vectorId=" + vectorId + ", objl=" + objl + ", xcoo=" + xcoo + ", ycoo=" + ycoo
				+ ", ve3d=" + ve3d + ", objectClass=" + objectClass + ", primitives=" + primitives + "]";
	}
	
}
