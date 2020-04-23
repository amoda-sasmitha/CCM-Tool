<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text], select {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	margin-left: 100px; display : inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	display: inline-block;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
table#t01 th {
  background-color: black;
  color: white;
}
.warning {background-color: #ff9800;} /* Orange */
.warning:hover {background: #2196F3;}
</style>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<br>
	<button type="button" class="btn btn-primary" style="margin-left: 20px;padding: 12px 20px;" onclick="goBack()">BACK</button>	<script>
function goBack() {
  window.history.back();
}

</script>




	<label style="margin-left: 250px;font-size: 30px;">CODE COMPLEXITY MEASURING TOOL</label>
	<button type="button" class="btn btn-primary" style="margin-right: 20px;float: right;padding: 12px 20px;">HOME</button>
	<br>
	<br>





	<div>
		<form action="/action_page.php">

			<input type="text" name="flname" class="flname" placeholder="Your file name" style="border:2px solid Violet;">
			<button type="button" class="btn btn-danger" style="margin-left: 20px; padding: 12px 45px;" onclick=alertt()>Remove</button>
			
			<script type="text/javascript">
			function alertt() {
				//alert("Are you sure to resubmit a File again   ");
				var txt;
				  var r = confirm("Are you sure to remove uploaded file ?");
				  if (r == true) {
				    alert("File Removed Successfuly ");
				    location.href = 'uploadpage.jsp';
				  }
				
			}
			</script>

			<select id="country" name="country" style="margin-left: 100px;border:2px solid Violet;">
				<option value="australia">Control Structure</option>
				<option value="canada">Inheritance</option>
				<option value="usa">Size</option>
				<option value="usa">All Factors</option>
			</select>
			<button  type="button" class="btn warning" style="margin-left: 20px; padding: 12px 20px;" onclick="location.href = 'controlstructure_weight_page.jsp';">Related Weights</button>
			
		</form>
	</div>





<div class="table-responsive">
    <table id="t01" class="table table-bordered" style="overflow: auto;">
      <thead class="tablehead">
        <tr>
          <th>Line No</th>
          <th>Program Statements</th>
          <th>Wtcs</th>
          <th>NC</th>
          <th>Ccspps</th>
          <th>Ccs</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td><script>$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});</script></td>
          <td>1</td>
          <td>35</td>
          <td>2 </td>
          <td>3</td>
        </tr>
      </tbody>
    </table>
  </div>
<br>

</body>
</html>