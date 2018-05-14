/**
 * 控制地图是否显示
 */

var showall = 0;
/**
 * 控制全部显示
 * @returns
 */
function showAll(){
	if(showall == 0){
		show_coastline_openlayers();
		show_danger_openlayers();
		show_depth_openlayers();
		show_island_openlayers();
		showall = 1;
	}else{
		layer.msg("当前已全部显示");
	}
}

/*
 * 设置全部可见
 */
function visibleAll(){
	coastShow();
	dangerShow();
	depthShow();
	landShow();
}

/*
 * 设置全部不可见
 */
function inVisibleAll(){
	coastNotShow();
	dangerNotShow();
	depthNotShow();
	landNotShow();
}