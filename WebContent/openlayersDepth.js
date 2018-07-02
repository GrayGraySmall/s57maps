/**
 * 显示等深线信息
 */

var vectorLayerDepths = new Array();
/**
 * 显示等深线
 */
function show_depth_openlayers() {
	request_depth();
}

/**
 * 请求深度信息
 */
function request_depth() {
	$.ajax({
		type : "GET",
		url : "depthcontour",
		contentType : 'application/json;charset=utf-8', //设置请求头信息
		dataType : "json",
		success : function(depthInfo) {
			process_depth(depthInfo);
		}
	//layer.msg("岛屿显示完成");
	})
}

/**
 * 处理深度信息
 */
function process_depth(depthInfo) {
	//遍历每个深度值信息
	$.each(depthInfo, function(i, depthInfo) {
		var points = new Array();
		//alert(JSON.stringify(depthInfo.coord.length));
		var coordinate;
		for (var j = 0; j < depthInfo.coord.length; j++) {
			//初始化坐标
			coordinate = [ depthInfo.coord[j].xcoo, depthInfo.coord[j].ycoo ];
			points.push(coordinate);
		}
		//points.push([ depthInfo.coord[0].xcoo, depthInfo.coord[0].ycoo ]);
		//在地图上画图
		var depth = new ol.geom.LineString(points);
		depth.applyTransform(ol.proj.getTransform('EPSG:4326', 'EPSG:3857'));
	    var feature = new ol.Feature(depth);
	    
	    var vectorSource = new ol.source.Vector();
	    vectorSource.addFeature(feature);

	    var vectorLayerDepth = new ol.layer.Vector({
	        source: vectorSource
	    });
	    
	    vectorLayerDepths.push(vectorLayerDepth);
	    map.addLayer(vectorLayerDepth);
	});
}



function depthShow(){
	for (var i = 0; i < vectorLayerDepths.length; i++){		
		vectorLayerDepths[i].setVisible(true);
	}
}

function depthNotShow(){
	for (var i = 0; i < vectorLayerDepths.length; i++){		
		vectorLayerDepths[i].setVisible(false);
	}
}
