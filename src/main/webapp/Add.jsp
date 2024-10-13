<%@page import="model.bean.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AddPhone</title>
<style>
.Form {
	max-width: 700px;
	padding: 10px 20px;
	background: #f4f7f8;
	margin: 10px auto;
	padding: 20px;
	background: #f4f7f8;
	border-radius: 8px;
	display: flex;
	justify-content: center;
}

.Form input[type="text"], .Form input[type="date"], .Form input[type="datetime"],
	.Form input[type="email"], .Form input[type="number"], .Form input[type="search"],
	.Form input[type="time"], .Form input[type="url"], .Form textarea,
	.Form select {
	background: rgba(255, 255, 255, 0.1);
	border: none;
	border-radius: 4px;
	font-size: 15px;
	margin: 0;
	outline: 0;
	padding: 10px;
	width: 100%;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	background-color: #e8eeef;
	color: #16222a;
	-webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
	margin-bottom: 20px;
	margin-right: 20px;
	width: 300px;
}

.Form textarea {
	height: 100px;
}

.btn {
	text-align: center;
}
</style>
</head>
<body>
	<div class="Form">
		<form action="AddController" method="post">
			<table>
				<caption style="font-size: 30px">
					<b>Add Phone</b>
				</caption>
				<tr>
					<td><input type="text" name="Name" placeholder="Name" /></td>
					<td><input type="text" name="Screen" placeholder="Screen" /></td>
				</tr>
				<tr>
					<td><input type="text" name="Image" placeholder="Image" /></td>
					<td><input type="text" name="System"
						placeholder="Operating System" /></td>
				</tr>
				<tr>
					<td><input type="text" name="Price" placeholder="Price" /></td>
					<td><input type="text" name="FCamera"
						placeholder="Front Camera" /></td>
				</tr>
				<tr>
					<td><select id="Category" name="Category">
							<%
							List<Category> listC = (List<Category>) request.getAttribute("listC");
							for (int i = 0; i < listC.size(); i++) {
							%>
							<option value="<%=listC.get(i).getId()%>"><%=listC.get(i).getName()%></option>
							<%
							}
							%>
						</select>
					</td>
					<td><input type="text" name="BCamera"
						placeholder="Back Camera" /></td>
				</tr>
				<tr>
					<td><textarea name="Description" placeholder="Description"></textarea>
					</td>
					<td><input type="text" name="Chip" placeholder="Chip" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="RAM" placeholder="RAM" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Capacity" placeholder="Capacity" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Sim" placeholder="Sim" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Battery" placeholder="Battery" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Company" placeholder="Company" /></td>
				</tr>
			</table>
			<div class="btn">
				<button type="submit" name="BtnSubmit"
					style="background-color: aqua; border-radius: 20px; height: 40px; width: 120px; border: none;">
					Submit</button>
			</div>
		</form>
	</div>
</body>
</html>
