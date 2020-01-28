<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Details</title>
<%
String sMovieUrl = request.getContextPath();
%>

<script type="text/javascript">
	var movieUrl = "<%=sMovieUrl%>";
	
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/view/js/movie.js"></script>

<style>
.modal {
  left: 0;
  right: 0;
  background-color: #fafafa;
  padding: 0;
  max-height: 80%;
  width: 70%;
  will-change: top, opacity;
}
</style>

</head>
<body>

	<div class="row" align="center">
		<div class="col l12" style="width: 100%;" align="center">
			<p>Movie Details</p>
			<!-- <form action="#"> -->
			<table id="movie"
				class="bordered highlight centered responsive-table"
				style="width: 100%">
				<thead>
					<tr>
						<th>Select</th>
						<th>Movie Title</th>
						<th>Movie Language</th>
						<th>Movie Release Date</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div align="center">
			<br/><br/><br/><br/>
				<table>
					<tr>
						<a class="waves-effect waves-light btn-small modal-trigger" id="create" href="#demo-modal"> Add
						</a> &nbsp;&nbsp;&nbsp;
						<a class="waves-effect waves-light btn-small" id="delete">Delete</a>
						&nbsp;&nbsp;&nbsp;
						<a class="waves-effect waves-light btn-small modal-trigger" id="edit" href="#edit-modal"> Edit
						</a> 
					</tr>
				</table>
			</div>
			<!-- </form> -->
		</div>
	</div>

	<div id="demo-modal" class="modal">
		<div class="modal-content" align="center">
			<div>Movie Details<hr/></div>
			<form action="#">
				<div class="row">
					<div class="input-field col s6" align="center">
						<input id="MOVIE_NAME" type="text" class="validate"> 
						<label for="MOVIE_NAME">Movie Name</label>
					</div>
				</div>

				<div class="row">
					<div class="input-field col s6">
						<select id="MOVIE_LANGUAGE">
							<option value="" disabled selected>Choose your option</option>
							<option value="KANNADA">Kannada</option>
							<option value="TELUGU">Telugu</option>
							<option value="TAMIL">Tamil</option>
						</select> <label>Language</label>
					</div>
				</div>

				<div class="row">
					<div class="input-field col s12">
						<input id="MOVIE_RELEASE_DATE" type="text" class="datepicker">
						<label for="MOVIE_RELEASE_DATE">Release Date</label>
					</div>
				</div>
				
			</form>
			<div class="modal-footer">
				<a href="#!" id = "add" class="modal-action btn waves-effect waves-light">Submit</a>
				<a href="#!" class="modal-action modal-close btn waves-effect waves-light">Close</a>
			</div>
		</div>
	</div>
	
	<div id="edit-modal" class="modal">
		<div class="modal-content" align="center">
			<div>Movie Details<hr/></div>
			<form action="#">
				<div class="row">
					<div class="input-field col s6" align="center">
						<input id="UPDATE_MOVIE_NAME" type="text" class="validate"> 
						<label class="active" for="UPDATE_MOVIE_NAME">Movie Name</label>
					</div>
				</div>

				<div class="row">
					<div class="input-field col s6">
						<select id="UPDATE_MOVIE_LANGUAGE">
							<option value="" disabled selected>Choose your option</option>
							<option value="KANNADA">Kannada</option>
							<option value="TELUGU">Telugu</option>
							<option value="TAMIL">Tamil</option>
						</select> <label>Language</label>
					</div>
				</div>

				<div class="row">
					<div class="input-field col s12">
						<input id="UPDATE_MOVIE_RELEASE_DATE" type="text" class="datepicker">
						<label for="UPDATE_MOVIE_RELEASE_DATE">Release Date</label>
					</div>
				</div>
				<input type="hidden" name="MOVIE_ID" id="MOVIE_ID"/>
			</form>
			<div class="modal-footer">
				<a href="#!" id = "update" class="modal-action btn waves-effect waves-light">Update</a>
				<a href="#!" class="modal-action modal-close btn waves-effect waves-light">Close</a>
			</div>
		</div>
	</div>
	
</body>
</html>