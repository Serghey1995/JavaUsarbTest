<%@ page import="com.usarb.bd.entities.Phone" %>
<%@ page import="com.usarb.bd.entities.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Person List</title>
    <style type="text/css">
        TABLE,TR,TH,TD {
            border: 1px solid black;
        }

    </style>
</head>
<body>
<table>
    <tr>
        <th><input type="checkbox"></th>
        <th>Picture</th>
        <th>Name</th>
        <th>Birth Day</th>
        <th>Gender</th>
        <th>Mail</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Library Abonament</th>
        <th>Marks</th>
        <th>Action</th></tr>


<c:forEach var = "Student" items="${listStudents}" >

    <tr>
        <td><input type="checkbox"></td>
        <td>
            <! картинка >
        </td>
    <td>
        <c:out value = "${Student.firstName}"/>
        <c:out value = "${Student.lastName}"/>
    </td>
        <td><c:out value = "${Student.dateOfBirth}"/></td>
        <td><c:out value = "${String.valueOf(Student.gender)}"/></td>
        <td> <c:out value = "${Student.mail}"/></td>
        <td>
            <c:out value = "${Student.address.country}"/>
         <c:out value = "${Student.address.city}"/>
         <c:out value = "${Student.address.address}"/>
        </td>
        <td>
    <c:if test="${Student.phones.size() !=0}" >
        <c:forEach var = "Phone" items="${Student.phones}" >
            <c:out value = "${Phone.type.name}"/>
            <c:out value = "${Phone.value}"/>
            <br/>
        </c:forEach>
    </c:if>
    <c:if test="${Student.phones.size() ==0}" >
        Numbers doesn`t exists
    </c:if>

        </td>
        <td><c:out value = "${Student.libraryAbonament.status}"/></td>
        <td>
<%--    <c:forEach var = "Student" items="${listAverage}" >--%>
<%--        <c:out value = "${Average}"/>--%>
<%--    </c:forEach>--%>
        </td>
        <td>
             <button type="submit">Edit</button>
             <button type="submit">Add Mark</button>
        </td>
    </tr>
   </c:forEach>

</table>
<button type="submit">Add New</button>
<button type="submit">Delete</button>

</body>
</html>
