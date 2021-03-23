<!DOCTYPE html>
<html>
<head>
<#import "/spring.ftl" as spring>
<meta charset="UTF-8">
<title><@spring.message "petsPageTitle"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="icon" type="img/ico" href="img/icon/favicon.ico">
</head>
<body>
	<div id="cats">
		<div class="box" v-cloak>
			<div class="box-body">
				<div class="panel-body box-content">

					<div class="row form-row"
						style="padding-left: 100px; padding-top: 60px;">
						
						<ul v-for="(key, value) in catsList" :key="key">
							<li>{{key}}</li>
							<ul v-for="val in value">
								<li>{{val}}</li>
							</ul> 
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/plugins/vue.js"></script>
	<script type="text/javascript" src="js/plugins/vue-resource.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.min.js"></script>
	<script type="text/javascript" src="js/plugins/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/service/pets.js"></script>
	<script type="text/javascript" src="js/common/common.js"></script>
</body>
</html>