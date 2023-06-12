<%--
  Created by IntelliJ IDEA.
  User: jawad
  Date: 11/4/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Income Tax Calculator</title>
</head>
<h3>

<h1>Income Tax Calculator</h1>
<br>
<form:form action="calculator" modelAttribute="variables">
    <label for="category">Choose Tax Payer Category</label>>
    <br>
    <form:select name="category" id="category" path="category">
        <option value="g" name="genaral" >Genaral</option>
        <option value="f" name="f/s">Female/Senior citizen</option>
        <option value="d" name="dis">Disabled</option>
        <option value="e" name="fre">Freedom Fighter</option>
    </form:select>
    <form:errors path="category"/>
    <br><br>
    <label for="zone">Zone</label>>
    <br>
    <form:select name="zone" id="zone" path="zone">
    <option value="d" name="dhaka" >Dhaka and Chittagong</option>
    <option value="c" name="f/s">Other city</option>
    <option value="w" name="dis">Rest of the world</option>

    </form:select>
        <form:errors path="category"/>
    <br><br>



<br><br>
    <label for="basic_salary">Basic Salary</label>
    <form:input  path="basic_salary" id="basic_salary"/>

    <form:errors path="basic_salary"/>

            <br>

    <label for="house_rent">House Rent</label>
    <form:input  path="house_rent" id="house_rent"/>
    <form:errors path="house_rent"/>
    <br>
    <label for="Medical">Medical Allowance</label>
    <form:input  path="medical" id="medical"/>
    <form:errors path="medical"/>
    <br>
<label for="con">Conveyance</label>
<form:input  path="con" id="con"/>
<form:errors path="con"/>
    <br>
    <label for="festival">Festible Bonus</label>
    <form:input  path="festival" id="festival"/>
    <form:errors path="festival"/>
    <br>
    <label for="investment">Investment</label>
    <form:input  path="investment" id="investment"/>
    <form:errors path="investment"/>
    <br>
    <input type="submit" value="submit">
</form>
</form:form>
    <h3><c:out value="Taxable income(annually): ${ti}" /></h3><br>
<h3><c:out value="Total tax: ${yearTax}" /></h3><br>
    <h3><c:out value="Monthly tax: ${monthTax}" /></h3>
</body>
</html>
