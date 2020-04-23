<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
input[type=text], select {
	width: 10%;
	padding: 8px 10px;
	margin-left: 10px; display : inline-block;
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

}
.buttona{
background-color: #4CAF50;
}

.buttonreset {
  border: none;
  color: black;
 
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  float: left;
  width:95%;
  margin-left: 20px;
  border-radius: 4px;
  background-color: orange;
}

.buttonreset:hover {
  background-color: #FF8C00;
}
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
	<button type="button" class="btn btn-primary" style="margin-left: 20px;padding: 12px 20px;" onclick="goBack()">BACK</button>
 	<script>
		function goBack() {
 			window.history.back();
		}

	</script>
	
	<label style="margin-left: 250px;font-size: 30px;">CODE COMPLEXITY MEASURING TOOL</label>
	<button type="button" class="btn btn-primary" style="margin-right: 20px;float: right;padding: 12px 20px;">HOME</button>
	<br><br>


	<div>
	<label style="font-size: 20px;;margin-top: 5px;margin-bottom: -20px"><font color="#F4A316">Weights related to Control Structure</font></label>
	</div>





<div class="table-responsive">
<form action="">
    <table id="t01" class="table table-bordered" ">
      <thead class="tablehead">
        <tr>
          <th>Control Structure Type</th>
          <th >Weight</th>
          
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>A conditional control structure such as an if or else-if condition </td>
          <td><input type="text" value="2"></td>
        </tr>
        <tr>
          <td>An iterative control structure such as a for, while, or do-while loop  </td>
          <td><input type="text" value="3"></td>
        </tr>
        <tr>
          <td>The switch statement in a switch-case control structure </td>
          <td><input type="text" value="2"></td>
        </tr>
        <tr>
          <td>Each case statement in a switch-case control structure  </td>
          <td><input type="text" value="1"></td>
        </tr>
       
      </tbody>
    </table>
  
  	</div>
  
	<br>
	
	<script type="text/javascript">
			function saveWeights() {
				//alert("Are you sure to resubmit a File again   ");
				var txt;
				  var r = confirm("Confirm the changes ?");
				  if (r == true) {
				    alert("Weights are updated Successfuly ");
				  }
				
			}
	</script>
			
	<button type="button" class="btn btn-primary" style="width:95%;margin-left: 20px;margin-right: 20px;padding: 12px 20px;" onclick="saveWeights()">SAVE</button>	
	<button class="buttonreset" style="margin-bottom: 10px;margin-top: 10px;padding: 12px 20px;" value="reset" >RESET TO DEFAULT</button>
</form>

</body>
</html>