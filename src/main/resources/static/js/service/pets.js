var catsApp = new Vue({
	el:"#cats",
	data:{
		catsList:[]
	},
	methods:{
		getCatsList : function(){
			this.$http.get("/ptil/petsApi/getCatsList").then(function(res){
				if(res.data.code ==0){
					this.catsList = res.data.data;
				} else {
					alert(res.data.message, {btn: ['OK'], title: "Tips"});
				}
			},function(r){
				alert(r.message, {btn: ['OK'], title: "Tips"});
			});
		}
	}
});

catsApp.getCatsList();