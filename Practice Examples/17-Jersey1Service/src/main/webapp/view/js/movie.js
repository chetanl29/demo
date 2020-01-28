$(document).ready(function() {
	
	M.updateTextFields();
	
	$('select').formSelect();
	
	$('.datepicker').datepicker({
		format: "mmm dd, yyyy"
	});

	displayMovieDetails();
	
	$("#create").click(function(e) {
		$("#MOVIE_NAME").val("");
		$("#MOVIE_LANGUAGE").val("");
		$("#MOVIE_RELEASE_DATE").val("");
		$('.modal').modal();
	});
	
	$("#add").click(function(e) {
		var movieName = $("#MOVIE_NAME").val();
		var movieLanguage = $("#MOVIE_LANGUAGE").val();
		var movieReleaseDate = $("#MOVIE_RELEASE_DATE").val();
		var movieJson = {"MOVIE_NAME":movieName, "MOVIE_LANGUAGE":movieLanguage, "MOVIE_RELEASE_DATE":movieReleaseDate};
		$.ajax({
			url: movieUrl+"/rest/movie/add",
			type: "POST",
			data: JSON.stringify(movieJson),
			dataType: "JSON",
			success:  function(movieObj) {
				if(movieObj.SUCCESS != null) {
					$('.modal').modal('close');
					displayMovieDetails();
				}else {
					$('.modal').modal('close');
					alert("Retry after some time.");
					displayMovieDetails();
				}
			},error: function(){
				$('.modal').modal('close');
				alert("Retry after some time.");
			}
		});
	});
	
	$("#delete").click(function() {
		var movieRow  = $("#movie input[type=radio]:checked");
		var movieId   = movieRow.val();
		var movieName = movieRow.closest("tr")[0].cells[1].innerHTML;
		var movieJson = {"MOVIE_ID":movieId, "MOVIE_NAME":movieName };
		
		$.confirm({
			title: '',
		    content: 'Are you sure you want to delete selected movie!',
		    boxWidth: '50%',
		    useBootstrap: false,
		    /*autoClose: 'false',*/
		    buttons: {
		        confirm: function () {
		        	$.ajax({
		    			url: movieUrl+"/rest/movie/delete",
		    			type: "DELETE",
		    			data: JSON.stringify(movieJson),
		    			dataType: "JSON",
		    			success: function(movieObj) {
		    				if(movieObj.SUCCESS != null) {
		    					displayMovieDetails();
		    				}else {
		    					alert("Retry after some time.");
		    					displayMovieDetails();
		    				}
		    			},error: function() {
		    				alert("Retry after some time.");
		    			}
		    		});
		        },
		        cancel: function () {
		            //$.alert('Canceled!');
		        },
		    }
		});
	});
	
	$("#edit").click(function(e) {
		var movieRow = $("#movie input[type=radio]:checked");
		var movieId  = movieRow.val();
		var movieName = movieRow.closest("tr")[0].cells[1].innerHTML;
		var movieLang = movieRow.closest("tr")[0].cells[2].innerHTML;
		var movieRelDate = movieRow.closest("tr")[0].cells[3].innerHTML;
		//alert(movieId + "-"+movieName+"-"+movieLang+movieRelDate);
		//var movieJson = {"MOVIE_ID":movieId , "MOVIE_NAME":movieName , "MOVIE_LANGUAGE":movieLang , "MOVIE_RELEASE_DATE":movieRelDate };

		$("#UPDATE_MOVIE_NAME").val(movieName);
		$("#UPDATE_MOVIE_LANGUAGE").find('option[value="'+movieLang+'"]').prop('selected', true);
		$("#UPDATE_MOVIE_LANGUAGE").formSelect();
		$("#UPDATE_MOVIE_RELEASE_DATE").val(movieRelDate);
		$("#MOVIE_ID").val(movieId);
		M.updateTextFields();
		$('.modal').modal();
	});
	
	$("#update").click(function(e){
		var movieId = $("#MOVIE_ID").val();
		var movieName = $("#UPDATE_MOVIE_NAME").val();
		var movieLang = $("#UPDATE_MOVIE_LANGUAGE").val();
		var movieRelDate = $("#UPDATE_MOVIE_RELEASE_DATE").val();
		var movieJson = {"MOVIE_ID":movieId,"MOVIE_NAME":movieName, "MOVIE_LANGUAGE":movieLang, "MOVIE_RELEASE_DATE":movieRelDate};
		//alert(movieId + "-"+movieName+"-"+movieLang+"-"+movieRelDate);
		
		$.ajax({
			url: movieUrl+"/rest/movie/update",
			type: "PUT",
			data: JSON.stringify(movieJson),
			dataType: "JSON",
			success: function(movieObj) {
				if(movieObj.SUCCESS != null){
					$('.modal').modal('close');
					displayMovieDetails();
				}else{
					alert("Retry after some time.");
					$('.modal').modal('close');
					displayMovieDetails();
				}
			},error:function() {
				alert("Retry after some time.");
				$('.modal').modal('close');
			}
		});
	});
	
});

function displayMovieDetails() {
	$.ajax({
		url: movieUrl+"/rest/movie/list",
		type: "GET",
		dataType: "JSON",
		success:  function(movieObj) {
			$('#movie tbody').empty();
			$.each(movieObj , function(index,value) {
				var row = '<tr><td><p><label><input name="group1" type="radio" value='+value.MOVIE_ID+' /><span/></label></p></td><td>'
					+value.MOVIE_NAME+'</td><td>'+value.MOVIE_LANGUAGE+'</td><td>'+value.MOVIE_RELEASE_DATE+'</td></tr>';
				$("#movie").append(row);
			});
		},error: function(){
			alert("Retry after some time.");
		}
	});
}