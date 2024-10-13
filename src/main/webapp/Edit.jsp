<%@page import="model.bean.ProductDetail"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>EditPhone</title>
<style>
.EditForm {
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

.EditForm input[type="text"], .EditForm input[type="date"], .EditForm input[type="datetime"],
	.EditForm input[type="email"], .EditForm input[type="number"],
	.EditForm input[type="search"], .EditForm input[type="time"], .EditForm input[type="url"],
	.EditForm textarea, .EditForm select {
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

.EditForm textarea {
	height: 100px;
}

.btn {
	text-align: center;
}
</style>
</head>
<body>
	<div class="EditForm">
		<form action="EditProductController" method="post">
			<table>
				<caption style="font-size: 30px">
					<b>Edit Phone</b>
				</caption>
				<%
					List<Product> list = (List<Product>) request.getAttribute("listP");
					List<ProductDetail> listDetail = (List<ProductDetail>) request.getAttribute("listDetail");
					for (int i = 0; i < list.size(); i++) {
					for (int k = 0; k < listDetail.size(); k++) {
				%>
				<tr>
					<td><input type="text" name="Name" placeholder="Name" value="<%= list.get(i).getName()%>"/></td>
					<td><input type="text" name="Screen" placeholder="Screen" value="<%= listDetail.get(k).getScreen()%>"/></td>
				</tr>
				<tr>
					<td><input type="text" name="Image" placeholder="Image" value="<%= list.get(i).getImage()%>"/></td>
					<td><input type="text" name="System"
						placeholder="Operating System" value="<%= listDetail.get(k).getSystem()%>"/></td>
				</tr>
				<tr>
					<td><input type="text" name="Price" placeholder="Price" value="<%= list.get(i).getPrice()%>"/></td>
					<td><input type="text" name="FCamera"
						placeholder="Front Camera" value="<%= listDetail.get(k).getRearcamera()%>"/></td>
				</tr>
				<tr>
					<td><select id="Category" name="Category">
							<%
							List<Category> listC = (List<Category>) request.getAttribute("listC");
							for (int j = 0; j < listC.size(); j++) {
							%>
							<option value="<%=listC.get(j).getId()%>"><%=listC.get(j).getName()%></option>
							<%
							}
							%>
					</select></td>
					<td><input type="text" name="BCamera"
						placeholder="Back Camera" value="<%= listDetail.get(k).getFrontcamera()%>"/></td>
				</tr>
				<tr>
					<td><textarea name="Description" placeholder="Description"><%= list.get(i).getDescription()%></textarea>
					</td>
					<td><input type="text" name="Chip" placeholder="Chip" value="<%= listDetail.get(k).getChip()%>"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="text" name="RAM" placeholder="RAM" value="<%= listDetail.get(k).getRam()%>"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Capacity" placeholder="Capacity" value="<%= listDetail.get(k).getCapacity()%>" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Sim" placeholder="Sim" value="<%= listDetail.get(k).getSim()%>"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Battery" placeholder="Battery" value="<%= listDetail.get(k).getBattery()%>"/></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="text" name="Company" placeholder="Company" value="<%= listDetail.get(k).getCompany()%>"/></td>
				</tr>
				<% }} %>
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
