<!DOCTYPE html>
<html>
<head>
<#import "/spring.ftl" as spring>
<meta charset="UTF-8">
<title><@spring.message "weatherPageTitle"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="icon" type="img/ico" href="img/icon/favicon.ico">
</head>
<body>
	<div id="getWeatherByCity">
		<div class="box" v-cloak>
			<div class="box-body">
				<div class="panel-body box-content">

					<div class="row form-row">
						<div class="col-md-4 form-inline"
							style="padding-left: 100px; padding-top: 50px;">
							<span class="input-group-addon"><@spring.message "cityLabel"/></span> 
							<select class="form-control" name="city" id="city" v-model="city" v-on:change="getWeatherInfo();">
								<option v-for="city in cityList"
									value="{{city.cityEng}}">{{city.cityEng}}</option>
							</select>
						</div>
					</div>
					<div class="col-md-4" style="padding-left: 100px; padding-top: 60px;width:500px;">
						<table id="weatherTable" class="table table-bordered" style="display:none">
                            <tbody>
								<tr>
									<td style="width:200px;font-weight: bold"><@spring.message "cityGridColumn"/></td>
									<td style="width:200px">{{weatherObject.city}}</td>
								</tr>
								<tr>
									<td style="width:200px;font-weight: bold"><@spring.message "updatedTimeGridColumn"/></td>
									<td style="width:200px">{{weatherObject.updatedTime}}</td>
								</tr>
								<tr>
									<td style="width:200px;font-weight: bold"><@spring.message "weatherGridColumn"/></td>
									<td style="width:200px">{{weatherObject.weather}}</td>
								</tr>
								<tr>
									<td style="width:200px;font-weight: bold"><@spring.message "temperatureGridColumn"/></td>
									<td style="width:200px">{{weatherObject.temperature}}</td>
								</tr>
								<tr>
									<td style="width:200px;font-weight: bold"><@spring.message "windGridColumn"/></td>
									<td style="width:200px">{{weatherObject.wind}}</td>
								</tr>
                            </tbody>
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/plugins/vue.js"></script>
	<script type="text/javascript" src="js/plugins/vue-resource.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.min.js"></script>
	<script type="text/javascript" src="js/plugins/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/service/weather.js"></script>
</body>
</html>