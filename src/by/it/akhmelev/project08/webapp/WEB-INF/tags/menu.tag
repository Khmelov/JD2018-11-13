<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"
%><%@ attribute name="command"  required="true" rtexprvalue="true" type="java.lang.String"
%><%@ attribute name="text"  required="true" rtexprvalue="true" type="java.lang.String"
%><%
    if (command.equalsIgnoreCase(request.getParameter("command"))){
        request.setAttribute("menuClassActive"," class='nav-item active'");
    }
    else
    {
        request.removeAttribute("menuClassActive");
    };
%><li${menuClassActive}>
    <a class="nav-link" href="do?command=${command}">${text}</a>
</li>



