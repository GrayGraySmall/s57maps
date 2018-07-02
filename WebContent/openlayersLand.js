/**
 * 	适配服务端取得的数据
 */

var vectorLayerLands = new Array();
/*
 * 显示岛屿数据
 */
function show_island_openlayers() {
	request_island();
}

/*
 * 利用ajax从服务端请求岛屿数据
 */
function request_island() {
	$.ajax({
		type : "GET",
		url : "showland",
		contentType : 'application/json;charset=utf-8', //设置请求头信息
		dataType : "json",
		success : function(landInfo) {
			process_island(landInfo);
		}
	})
}

/*
 * 处理获取到的岛屿信息数据
 */
function process_island(landInfo) {
	
	//设置岛屿颜色属性
	var style = new ol.style.Style({
        fill: new ol.style.Fill({
            color: '#D3D3D3'
        }),
        stroke: new ol.style.Stroke({
            color: 'DarkGoldenRod',
            width: 2
        }),
        image: new ol.style.Circle({
            radius: 7,
            fill: new ol.style.Fill({
                color: 'DarkGoldenRod'
            })
        })
    });
	
	//遍历每个岛屿信息
	$.each(landInfo, function(i, landArea) {
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

	    var vectorLayerLand = new ol.layer.Vector({
	        source: vectorSource
	    });
	    vectorLayerLands.push(vectorLayerLand);
	    map.addLayer(vectorLayerLand);
	});
}

function landNotShow(){
	//alert("Test111");
	for (var i = 0; i < vectorLayerLands.length; i++){		
		vectorLayerLands[i].setVisible(false);
	}
}

function landShow(){
	for (var i = 0; i < vectorLayerLands.length; i++){		
		vectorLayerLands[i].setVisible(true);
	}
}