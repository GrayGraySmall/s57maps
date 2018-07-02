package s57map.dao;

import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import s57map.model.Object2dAnd3d;

@Repository
public class Object2dAnd3dDao {
	@Resource
	private JdbcTemplate jdbcTemplate = null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * 查找所有物体信息
	 */
	public Object2dAnd3d[] selectObject2d(int objl) {
		
		 String sql = "select vectorId, ycoo, xcoo, objectClass, objl, primitives from object2d where objl = ? and "
		  + " vectorId in (select vectorId from object2d where objl = ? GROUP BY vectorId HAVING COUNT(*)>2)";
		 
		//String sql = "select vectorId, ycoo, xcoo, objectClass, objl, primitives from object2d where objl = ? ";
		List<Object2dAnd3d> landAreas = jdbcTemplate.query(sql, new Object[] { objl, objl },
				BeanPropertyRowMapper.newInstance(Object2dAnd3d.class));
		/*
		 * System.out.println(landAreas.size()); for (int i = 0; i < 100; i++) {
		 * System.out.println(landAreas.get(i).toString()); }
		 */
		return landAreas.toArray(new Object2dAnd3d[0]);
	}
	
	/*
	 * 查找所有孤立灯塔
	 */
	public Object2dAnd3d[] selectDanger(int objl) {
		String sql = "select vectorId, ycoo, xcoo, objectClass, objl, primitives from object2d where objl = ?";
		List<Object2dAnd3d> danger = jdbcTemplate.query(sql, new Object[] {objl},
				BeanPropertyRowMapper.newInstance(Object2dAnd3d.class));
		System.out.println(danger.size());
		return danger.toArray(new Object2dAnd3d[0]);
	}

	
	/*
	 * 查找所有深度信息
	 */
	public Object2dAnd3d[] selectDepth() {
		String sql = "select vectorId, ycoo, xcoo, ve3d,objectClass, objl, primitives from object3d";
		List<Object2dAnd3d> landAreas = jdbcTemplate.query(sql, new Object[] {},
				BeanPropertyRowMapper.newInstance(Object2dAnd3d.class));
		/*
		 * System.out.println(landAreas.size()); for (int i = 0; i < 100; i++) {
		 * System.out.println(landAreas.get(i).toString()); }
		 */
		System.out.println(landAreas.size());
		return landAreas.toArray(new Object2dAnd3d[0]);
	}

	@Test
	public void lllselectObject2ds() {
		String sql = "select count(*) from s57vector";
		int y = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(y);
		// return y;
	}
}
