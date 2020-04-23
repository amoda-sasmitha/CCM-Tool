<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>	
<%@page import="model.Size" %>	
<%ArrayList<Size> sizedetails = (ArrayList<Size>) request.getAttribute("sizedetails"); %>
<%String filename = (String) request.getAttribute("filename"); %>
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
.none{
	display: none !important;
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

			<input type="text" name="flname" value="<%=filename%>" class="flname" placeholder="Your file name" style="border:2px solid Violet;">
			<button type="button" class="btn btn-danger" style="margin-left: 20px; padding: 12px 45px;" onclick=alertt()>Remove</button>
			
			<script type="text/javascript">
			function alertt() {
				//alert("Are you sure to resubmit a File again   ");
				var txt;
				  var r = confirm("Are you sure to remove uploaded file ?");
				  if (r == true) {
				    alert("File Removed Successfuly ");
				    location.href = '/CCM-Tool/';
				  }
				
			}
			</script>

			<select id="st_val"  style="margin-left: 100px;border:2px solid Violet;">
				<option selected value="#control_structure">Control Structure</option>
				<option value="#variables">Variables</option>
				<option value="#size">Size</option>
				<option value="#methods">methods</option>
			</select>
			<button id="msg"  type="button" class="btn btn-success btn-lg ml-5">Messure</button>
			
		</form>
	</div>

<!-- normal code table -->
<div id="normal_code"  class="table-responsive ">
    <table id="t01" class="table table-bordered" style="overflow: auto;">
      <thead class="tablehead">
        <tr>
          <th>Line</th>
        </tr>
      </thead>
      <tbody>
	 <% for (Size size : sizedetails){ %>
           <tr> 
               <td><%=size.getLine()%></td>    
       <% }%>
      </tbody>
    </table>
  </div>
  
<!-- control_structure table -->
<div id="control_structure"  class="table-responsive none">
    <table id="t01" class="table table-bordered" style="overflow: auto;">
      <thead class="tablehead">
        <tr>
          <th>Line No</th>
          <th>Nkw</th>
          <th>Nid</th>
          <th>Nop</th>
          <th>Nnv</th>
          <th>Nsl</th>
          <th>CS</th>
        </tr>
      </thead>
      <tbody>
	  <!--add rows here  -->
	  <tr>
		  <td>control_structure</td>
	  </tr>
      </tbody>
    </table>
  </div>

  <!--variables table  -->
  <div id="variables"  class="table-responsive none">
    <table id="t01" class="table table-bordered" style="overflow: auto;">
      <thead class="tablehead">
        <tr>
          <th>Line No</th>
          <th>Nkw</th>
          <th>Nid</th>
          <th>Nop</th>
          <th>Nnv</th>
          <th>Nsl</th>
          <th>CS</th>
        </tr>
      </thead>
      <tbody>
	   <!--add rows here  -->
	   <tr>
		<td>variables</td>
	</tr>
      </tbody>
    </table>
  </div>

<!-- size table -->
<div id="size"  class="table-responsive none">
    <table id="t01" class="table table-bordered" style="overflow: auto;">
      <thead class="tablehead">
        <tr>
          <th>Line No</th>
          <th>Nkw</th>
          <th>Nid</th>
          <th>Nop</th>
          <th>Nnv</th>
          <th>Nsl</th>
          <th>CS</th>
        </tr>
      </thead>
      <tbody>
	   <!--add rows here  -->
	   <tr>
		<td>size</td>
	</tr>
      </tbody>
    </table>
  </div>

  <!--methods table  -->
  <div id="methods"  class="table-responsive none">
    <table id="t01" class="table table-bordered" style="overflow: auto;">
      <thead class="tablehead">
        <tr>
          <th>Line No</th>
          <th>Nkw</th>
          <th>Nid</th>
          <th>Nop</th>
          <th>Nnv</th>
          <th>Nsl</th>
          <th>CS</th>
        </tr>
      </thead>
      <tbody>
	   <!--add rows here  -->
	   <tr>
		<td>methods</td>
	</tr>
      </tbody>
    </table>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
	  $("#msg").click(function(){
		
		console.log("Hello");
		var value = $("#st_val").val();
		let array = ["#control_structure" , "#variables" , "#size" , "#methods" , "#normal_code"].filter( item => item !== value  );

		console.log(value);
		console.log(array);
		 $(value).removeClass("none");
		array.forEach( element => {
			$(element).addClass("none");
		})

		});
  </script>


<br>

</body>
</html>