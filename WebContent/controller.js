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

function dayModel(){
	var style = new ol.style.Style({
		  fill: new ol.style.Fill({ //矢量图层填充颜色，以及透明度
		    color: 'rgba(255, 255, 255, 0.6)'
		  }),
		  stroke: new ol.style.Stroke({ //边界样式
		    color: '#319FD3',
		    width: 1
		  }),
		  text: new ol.style.Text({ //文本样式
		    font: '12px Calibri,sans-serif',
		    fill: new ol.style.Fill({
		      color: '#000'
		    }),
		    stroke: new ol.style.Stroke({
		      color: '#fff',
		      width: 3
		    })
		  })
		});
	
	map.setStyle(style);
}

function nightModel(){
	
}