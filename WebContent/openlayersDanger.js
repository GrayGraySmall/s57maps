/**
 * 显示危险区域
 */

var vectorLayerCuations = new Array();
var vectorLayerTowers = new Array();
/*
 * 显示危险区域
 */
function show_danger_openlayers() {
	quest_tower();
	quest_cuation()
}

/*
 * 请求危险灯塔区域信息
 */
function quest_tower() {
	$.ajax({
		type : "GET",
		url : "tower",
		contentType : 'application/json;charset=utf-8', //设置请求头信息
		dataType : "json",
		success : function(towerInfo) {
			process_tower(towerInfo);
		}
	})
}

/*
 * 处理危险灯塔信息区域
 */
function process_tower(towerInfo) {
	var style = new ol.style.Style({
		image : new ol.style.Icon(/** @type {olx.style.IconOptions} */
		({
			color : '#B22222',
			crossOrigin : 'anonymous',
			src : 'resources/lighthouse.png'
		}))
	});

	//点坐标
	var coordinate;
	for (var i = 0; i < towerInfo.length; i++) {
		//点标注
		coordinate = [ towerInfo[i].xcoo, towerInfo[i].ycoo ];
		var dPoint = new ol.geom.Point(coordinate);
		var circle = new ol.geom.Circle(coordinate, 0.05)
		dPoint.applyTransform(ol.proj.getTransform('EPSG:4326', 'EPSG:3857'));
		circle.applyTransform(ol.proj.getTransform('EPSG:4326', 'EPSG:3857'));
		var feature = new ol.Feature(dPoint);
		var feature2 = new ol.Feature(circle);
		
		feature.setStyle(style);

		var vectorSource = new ol.source.Vector();
		vectorSource.addFeature(feature);
		vectorSource.addFeature(feature2);

		var vectorLayerTower = new ol.layer.Vector({
			source : vectorSource
		});
		vectorLayerTowers.push(vectorLayerTower);
		
		map.addLayer(vectorLayerTower);
	}
}

/*
 * 请求危险区域信息
 */
function quest_cuation() {
	$.ajax({
		type : "GET",
		url : "showcuation",
		contentType : 'application/json;charset=utf-8', //设置请求头信息
		dataType : "json",
		success : function(cuationInfo) {
			process_cuation(cuationInfo);
		}
	})
}

/*
 * 处理危险区域信息
 */
function process_cuation(cuationInfo) {
	//设置岛屿颜色属性
	var style = new ol.style.Style({
        fill: new ol.style.Fill({
            color: 'Red'
        }),
        stroke: new ol.style.Stroke({
            color: 'Red',
            width: 2
        }),
        image: new ol.style.Circle({
            radius: 7,
            fill: new ol.style.Fill({
                color: 'Red'
            })
        })
    });
	
	//遍历每个岛屿信息
	$.each(cuationInfo, function(i, landArea) {
		var points = new Array();
		//alert(JSON.stringify(landArea.coord.length));
		var coordinate;
		for (var j = 0; j < landArea.coord.length; j++) {
			//初始化坐标
			coordinate = [ landArea.coord[j].xcoo, landArea.coord[j].ycoo ];
			points.push(coordinate);
		}
		//points.push([ landArea.coord[0].xcoo, landArea.coord[0].ycoo ]);
		//在地图上画图
		var polygon = new ol.geom.Polygon([points]);
	    polygon.applyTransform(ol.proj.getTransform('EPSG:4326', 'EPSG:3857'));
	    var feature = new ol.Feature(polygon);

	    //设置岛屿的颜色
	    feature.setStyle(style);
	    
	    var vectorSource = new ol.source.Vector();
	    vectorSource.addFeature(feature);

	    var vectorLayerCuation = new ol.layer.Vector({
	        source: vectorSource
	    });
	    
	    vectorLayerCuations.push(vectorLayerCuation);
	    map.addLayer(vectorLayerCuation);
	});
}

/*
 * 显示危险区域
 */
function dangerShow(){
	for (var i = 0; i < vectorLayerCuations.length; i++){		
		vectorLayerCuations[i].setVisible(true);
	}
	
	for (var i = 0; i < vectorLayerTowers.length; i++){		
		vectorLayerTowers[i].setVisible(true);
	}
}

/*
 * 显示危险区域
 */
function dangerNotShow(){
	for (var i = 0; i < vectorLayerCuations.length; i++){		
		vectorLayerCuations[i].setVisible(false);
	}
	
	for (var i = 0; i < vectorLayerTowers.length; i++){		
		vectorLayerTowers[i].setVisible(false);
	}
}