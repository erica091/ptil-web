<!DOCTYPE html>
<html>
<head>
<#import "/spring.ftl" as spring>
<meta charset="UTF-8">
<title><@spring.message "modulesPageTitle"/></title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/common.css" type="text/css"/>
<link rel="icon" type="img/ico" href="img/icon/favicon.ico">
</head>
<body>
	<div id="modules">
		<div class="content-wrapper menu-wrapper"
			style="overflow-x: auto; overflow-y: hidden;">
			<div class="all-modules-panel">
				
				<div class="all-modules-panel-row-block">
					<div class="all-modules-panel-row-block-logo">
						<input type="image"
							style="height: 130px; width: 130px; outline: none;" type="image"
							src="img/cat.png" onclick=forward("/pets")>
					</div>
					<div class="all-modules-panel-row-block-title" onclick=forward("/pets")><@spring.message "petsModule"/></div>
				</div>
				
				<div class="all-modules-panel-row-block">
					<div class="all-modules-panel-row-block-logo">
						<input type="image"
							style="height: 130px; width: 130px; outline: none;" type="image"
							src="img/weather.png" onclick=forward("/weather")>
					</div>
					<div class="all-modules-panel-row-block-title" onclick=forward("/weather")><@spring.message "weatherModule"/></div>
				</div>
				
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/common/common.js"></script>
</body>
</html>