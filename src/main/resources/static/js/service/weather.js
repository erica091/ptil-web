var myDivApp = new Vue({
	el: '#getWeatherByCity',
	data: {
		cityList:[],
		weatherObject:{
			city: '',
			updatedTime:'',
			weather:'',
			temperature:'',
			wind:''
		}
	},
	methods: {
		getCityList : function(){
			this.$http.get("/ptil/weatherApi/getCityList").then(function(res){
				if(res.data.code ==0){
					this.cityList = res.data.data;
				} else {
					alert(r.message, {btn: ['OK'], title: "Tips"});
				}
			},function(){
				alert(r.message, {btn: ['OK'], title: "Tips"});
			});
		},
		getWeatherInfo : function(){
			this.weatherList= [];
			if(this.city != null){
				this.$http.get("/ptil/weatherApi/getWeatherInfo", {city:this.city}).then(function(res){
					if(res.data.code ==0){
						$("#weatherTable").show();
						this.weatherObject = res.data.data;
					} else {
						alert(r.message, {btn: ['OK'], title: "Tips"});
					}
					
				},function(){
					alert(r.message, {btn: ['OK'], title: "Tips"});
				});
			}
		}
	},
	mounted () {

	}
});


myDivApp.getCityList();