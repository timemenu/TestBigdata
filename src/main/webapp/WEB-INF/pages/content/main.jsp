<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>

		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<style type="text/css">
${demo.css}
		</style>
		<script type="text/javascript">
		var chart1;
$(function () {
    $(document).ready(function () {    	
    	Highcharts.setOptions({
            global: {
                useUTC: false
            }
        });

    	chart1 = $('#container').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {
                        // set up the updating of the chart each second
//                         var series = this.series[0];
//                         setInterval(function () {
//                             var x = (new Date()).getTime(), // current time
//                                 y = test();
//                             series.addPoint([x, y], true, true);
//                         }, 1000);
						var series = this.series[0];
						setInterval(function(){ test(series); }, 1000);
                    }
                }
            },
            title: {
                text: 'Live real-time access log'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Value'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'Random data',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -5; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000
                        });
                    }
                    return data;
                }())
            }]
        });
    });
});

function test(series){
	$.ajax({
		type:"post",
		url:"/bigdata/logdata.do",
		success:function(response){
			var result = response;
			var x = (new Date()).getTime(), // current time
            y = result;
        	series.addPoint([x, y], true, true);
		}
	});
};

		</script>
	</head>
	<body>
<script src="/static-resources/js/highchart/js/highcharts.js"></script>
<script src="/static-resources/js/highchart/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	</body>
</html>