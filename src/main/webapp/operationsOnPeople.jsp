<%@ page import="java.util.List" %>
<%@ page import="com.example.jpaexercise.model.Person" %>
<%@ page import="com.example.jpaexercise.dao.person.PersonDAO" %><%--
  Created by IntelliJ IDEA.
  User: nextre
  Date: 11/9/2022
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operations on People</title>
</head>
<body>
<h1>
  <%= "Operations on People" %>
</h1>
<h2>
  <%= "Retrieve person by id" %>
</h2>
<form action="${pageContext.request.contextPath}/operations-on-people">
  <label>Insert personId:</label><br>
  <input type="text" id="personId" name="personIdText">
  <br>
  <button type="submit" name="idButton">Confirm</button>
  <br>
</form>
<c:if test="${request.getAttribute("person-info") != null}"></c:if>
<%
  if (request.getAttribute("person-info") != null)
  {
%>
<%= "Person's info: " + request.getAttribute("person-info") %>
<% }
%>
<br>
<h2>
  <%= "Delete person by id" %>
</h2>
<form action="${pageContext.request.contextPath}/operations-on-people">
  <label>Insert personId:</label><br>
  <input type="text" id="personToDeleteId" name="personToDeleteIdText">
  <br>
  <button type="submit" name="deleteButton">Confirm</button>
  <br>
</form>
<br>
<h2>
  <%= "Update person name" %>
</h2>
<form action="${pageContext.request.contextPath}/operations-on-people">
  <label>Insert personId:</label><br>
  <input type="text" id="personToUpdateId" name="personToUpdateIdText">
  <br>
  <label>Insert new name:</label><br>
  <input type="text" id="newName" name="newNameText">
  <br>
  <button type="submit" name="updateButton">Confirm</button>
  <br>
</form>
<br>
<h2>
  <%= "People list here!" %>
</h2>
<ul>
  <% for(Person person : (List<Person>) request.getAttribute("peopleList")) {%>
  <li><%= person.toString() %></li>
  <% } %>
</ul>
</body>
</html>
