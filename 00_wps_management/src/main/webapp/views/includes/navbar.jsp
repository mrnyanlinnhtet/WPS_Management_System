<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"
	integrity="sha512-BnbUDfEUfV0Slx6TunuB042k9tuKe3xrD6q4mg5Ed72LTgzDIcLPxg6yI2gcMFRyomt+yJJxE+zJwNmxki6/RA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<c:url value="/home" var="home"></c:url>
<c:url value="/website" var="web"></c:url>
<c:url value="/passowrd" var="pass"></c:url>
<c:url value="/logout" var="logout"></c:url>

<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
 <div class="container">
 <a href="${home}" class="navbar-brand"><b><i class="fas fa-tv mx-2"></i> WPS Management System</b></a>
 <ul class="navbar-nav">
 
  <li class="nav-item mx-3">
  <a href="${home}" class="nav-link ${param.view eq 'home'?' active' : '' }"><i class="fas fa-home"></i> Home</a>
  </li>
  
  <li class="nav-item mx-3">
  <a href="${web}" class="nav-link ${param.view eq 'web'?' active' : '' } "><i class="fas fa-globe"></i>  Web-Data</a>
  </li>
  
  <li class="nav-item mx-3">
  <a href="${pass}" class="nav-link ${param.view eq 'password'?' active' : '' }  "><i class="fas fa-key"></i>  Password-Saver</a>
  </li>
  
  <li class="nav-item">
  <a href="${logout}" class="nav-link"><i class="fas fa-lock-open"></i> Logout</a>
  </li>
  
  
 </ul>
 </div>
</nav>