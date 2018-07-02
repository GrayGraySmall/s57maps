package s57map.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s57map.dao.Object2dAnd3dDao;
import s57map.model.Coordinates;
import s57map.model.LandArea;
import s57map.model.Object2dAnd3d;
import s57map.utils.SpringUtils;

@Service
public class Object2dAnd3dService {
	@Autowired
	private Object2dAnd3dDao object2dAnd3dDao = null;

	public void setObject2dAnd3dDao(Object2dAnd3dDao object2dAnd3dDao) {
		this.object2dAnd3dDao = object2dAnd3dDao;
	}

	/**
	 * 查找二维物标信息
	 */
	public void selectObject2ds() {
		object2dAnd3dDao.lllselectObject2ds();
	}

	/**
	 * 查找所有岛屿信息
	 * 
	 * @param objl
	 *            岛屿的编号
	 * @return
	 */
	public Object2dAnd3d[] selectObject2d(int objl) {
		return object2dAnd3dDao.selectObject2d(objl);
	}
	
	/**
	 * 查找深度信息
	 * @return
	 */
	public Object2dAnd3d[] select3Dobject() {
		return object2dAnd3dDao.selectDepth();
	}

	/**
	 * 查找孤立灯塔区域
	 * @return
	 */
	public Object2dAnd3d[] selectDanger(){
		return object2dAnd3dDao.selectDanger(6);
	}
	/**
	 * 岛屿信息整理
	 * 
	 * @return
	 */
	public HashMap<Integer, LandArea> getLand(int objl) {
		// 讲岛屿坐标与岛屿编号相对应
		HashMap<Integer, LandArea> maps = new HashMap<Integer, LandArea>();
		// 获取岛屿信息
		Object2dAnd3d[] objects = selectObject2d(objl);
		// System.out.println(objects.length+objects.toString());
		for (int i = 0; i < objects.length; i++) {
			// 获取当前岛屿信息坐标
			int vectorId = objects[i].getVectorId();
			// 初始化坐标信息
			Coordinates coordinate = new Coordinates(objects[i].getXcoo(), objects[i].getYcoo(), 0.0);
			// 判断当前key是否已在maps中
			if (maps.containsKey(objects[i].getVectorId())) {
				// 获取当前岛屿编号的坐标集
				LandArea landArea = maps.get(vectorId);
				// 添加坐标
				landArea.setCoord(coordinate);
				// 放入岛屿编号中
				maps.put(vectorId, landArea);
			} else {
				// 创建岛屿类
				LandArea landArea = new LandArea();
				// 放入坐标
				landArea.setCoord(coordinate);
				// 放入maps
				maps.put(vectorId, landArea);
			}
		}
		System.out.println(maps.size());
		/*
		 * int j = 0; for (int i : maps.keySet()){
		 * System.out.println(maps.get(i).getCoord().size()); j++; if (j==100) {
		 * break; } }
		 */
		return maps;
	}
}
