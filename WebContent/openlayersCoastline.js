/**
 * 加载海岸线
 */

var vectorLayerCoasts = new Array();
/*
 * 显示海岸线信息
 */
function show_coastline_openlayers(){
	request_coastline();
}

/*
 * 请求海岸线信息
 */
function request_coastline(){
	$.ajax({
		type : "GET",
		url : "coastline",
		contentType : 'application/json;charset=utf-8', //设置请求头信息
		dataType : "json",
		success : function(coastInfo) {
			process_coastline(coastInfo);
		}
	})
}

/*
 * 处理海岸线信息
 */
function process_coastline(coastInfo){
	var style = new ol.style.Style({
	  stroke: new ol.style.Stroke({ //边界样式
	    color: '#8B0000',
	    width: 1
	  }),
	});
	
	//遍历每个岛屿信息
	$.each(coastInfo, function(i, coastInfo) {
		var points = new Array();
		//alert(JSON.stringify(coastInfo.coord.length));
		var coordinate;
		for (var j = 0; j < coastInfo.coord.length; j++) {
			//初始化坐标
			coordinate = [ coastInfo.coord[j].xcoo, coastInfo.coord[j].ycoo ];
			points.push(coordinate);
		}
		//points.push([ coastInfo.coord[0].xcoo, coastInfo.coord[0].ycoo ]);
		//在地图上画图
		var coastline = new ol.geom.LineString(points);
		coastline.applyTransform(ol.proj.getTransform('EPSG:4326', 'EPSG:3857'));
	    var feature = new ol.Feature(coastline);
	    feature.setStyle(style);
	    
	    var vectorSource = new ol.source.Vector();
	    vectorSource.addFeature(feature);

	    var vectorLayerCoast = new ol.layer.Vector({
	        source: vectorSource
	    });
	    vectorLayerCoasts.push(vectorLayerCoast);
	    map.addLayer(vectorLayerCoast);
	});
}

/*
 * 显示海岸线
 */
function coastShow(){
	for (var i = 0; i < vectorLayerCoasts.length; i++){		
		vectorLayerCoasts[i].setVisible(true);
	}
}

/*
 * 不显示海岸线
 */
function coastNotShow(){
	for (var i = 0; i < vectorLayerCoasts.length; i++){		
		vectorLayerCoasts[i].setVisible(false);
	}
}
