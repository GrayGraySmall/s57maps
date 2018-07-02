package s57map.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import s57map.model.LandArea;
import s57map.model.Object2dAnd3d;
import s57map.service.Object2dAnd3dService;
import s57map.utils.JsonUtils;

@Controller
public class LandRest {
	@Autowired
	private Object2dAnd3dService object2dAnd3dService = null;

	/**
	 * 请求岛屿坐标
	 * 
	 * @return 岛屿坐标集合
	 */
	@RequestMapping(value = { "showland" }, method = RequestMethod.GET)
	public @ResponseBody HashMap<Integer, LandArea> showLand() {
		// 获取岛屿坐标，id为71表示大陆
		HashMap<Integer, LandArea> maps = object2dAnd3dService.getLand(71);
		// 返回岛屿坐标
		// System.out.println(JsonUtils.objectToJson(maps));
		HashMap<Integer, LandArea> maps2 = object2dAnd3dService.getLand(73);
		maps.putAll(maps2);
		return maps;
	}

	/**
	 * 请求危险区域信息
	 * @return
	 */
	@RequestMapping(value = { "showcuation" }, method = RequestMethod.GET)
	public @ResponseBody HashMap<Integer, LandArea> showCuation() {
		// 获取危险区域坐标，id为27表示危险区域
		HashMap<Integer, LandArea> maps = object2dAnd3dService.getLand(27);
		return maps;
	}

	/**
	 * 请求海岸线信息
	 * 
	 * @return 海岸线坐标集
	 */
	@RequestMapping(value = { "coastline" }, method = RequestMethod.GET)
	public @ResponseBody HashMap<Integer, LandArea> showCoast() {
		// id为30表示海岸线
		HashMap<Integer, LandArea> maps = object2dAnd3dService.getLand(30);
		return maps;
	}

	/**
	 * 请求等深线等信息
	 * 
	 * @return
	 */
	@RequestMapping(value = { "depthcontour" }, method = RequestMethod.GET)
	public @ResponseBody HashMap<Integer, LandArea> showDepthContour() {
		// id为43的为等深线
		HashMap<Integer, LandArea> maps = object2dAnd3dService.getLand(43);
		return maps;
	}

	/**
	 * 查找深度信息並返回
	 * 
	 * @return
	 */
	@RequestMapping(value = { "depthnum" }, method = RequestMethod.GET)
	public @ResponseBody Object2dAnd3d[] showDepthArea() {
		return object2dAnd3dService.select3Dobject();
	}

	/**
	 * 查找并返回孤立灯塔区域信息
	 * 
	 * @return
	 */
	@RequestMapping(value = { "tower" }, method = RequestMethod.GET)
	public @ResponseBody Object2dAnd3d[] showTower() {
		System.out.println("tower请求成功！");
		return object2dAnd3dService.selectDanger();
	}
}
