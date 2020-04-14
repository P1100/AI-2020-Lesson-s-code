<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 08/04/2020
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        body, html {
            font-family: "Comic Sans MS", Arial, Georgia, sans-serif;
            background-color: beige;
            padding: 2em;
        }

        .counter {
            background-color: burlywood;
            padding: 0.5em;
            color: black;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
<h1>Esempio di JSP</h1>
<%
    Integer counter;
    synchronized (session) {
    counter = (Integer) session.getAttribute("counter");
    if (counter == null) {
        session.setAttribute("counter", 1);
        counter = 1;
    } else {
        counter = counter + 1;
        session.setAttribute("counter", counter);
        if (counter == 9) {
            session.invalidate();
        }
    }
}%>
<p>Il valore attuale del contatore è <span class="counter"><%= counter%></span></p>
<ul>
    <%for (int i = 0; i < 10; i++) {%>
    <li>Item #<%= i %>
    </li>
    <% } %>
</ul>
</body>
</html>
