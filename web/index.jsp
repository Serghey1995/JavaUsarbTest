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


<c:forEach var = "Person" items="${listPersons}" >

    <tr>
        <td><input type="checkbox"></td>
        <td>
            <! картинка >
        </td>
    <td>
        <c:out value = "${Person.firstName}"/>
        <c:out value = "${Person.lastName}"/>
    </td>
        <td><c:out value = "${Person.dateOfBirth}"/></td>
        <td><c:out value = "${String.valueOf(Person.gender)}"/></td>
        <td> <c:out value = "${Person.mail}"/></td>
        <td>
            <c:out value = "${Person.address.country}"/>
         <c:out value = "${Person.address.city}"/>
         <c:out value = "${Person.address.address}"/>
        </td>
        <td>
    <c:forEach var = "Phone" items="${Person.phones}" >
            <c:out value = "${Phone.type.name}"/>
            <c:out value = "${Phone.value}"/>
        <br/>
    </c:forEach>


        </td>
        <td><c:out value = "${Person.libraryAbonament.status}"/></td>
        <td>
            <! mark >
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
