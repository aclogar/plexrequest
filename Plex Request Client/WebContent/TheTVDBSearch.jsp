<%@page import="java.util.List"%>
<%@page import="com.aclogar.plex.tools.tvdb.Lookup"%>
<%@page import="com.aclogar.plex.tools.tvdb.Series"%>
<%@page import="com.aclogar.plex.tools.sickrage.API"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=request.getParameter("query")%></title>
</head>
<body>

	<%
		if (request.getParameter("query") != null && !request.getParameter("query").isEmpty()) {

			List<Series> series = Lookup.getSeries(request.getParameter("query"));

			if (series.size() > 0) {
	%>
	<form class="webdesigntuts-workshop-form">
		<table>
			<tr>
				<td>Title</td>
				<td>Series ID</a></td>
				<td>First Aired Date</td>
				<td>Anime?</td>
				<td></td>
			</tr>

			<%
				for (Series s : series) {
			%>
			<tr>
				<td><%=s.getSeries()%></td>
				<td><a
					href="https://www.thetvdb.com/?tab=series&id=<%=s.getId()%>"><%=s.getId()%></a></td>
				<td><%=s.getFirstAir()%></td>
				<td><input type="checkbox" name="anime"/></td>
				<td><button>Add</button></td>
				<input type="hidden" name="series" value="<%=s.getId()%>" />
			</tr>
			<%
				}
			%>
		</table>
	</form>
	<%
		}
		} else {
			API api = new API();
			boolean anime = request.getParameter("anime") != null && request.getParameter("anime").equals("on");
			System.out.print("Anime value = "+ anime);
			
			String result = api.addNewShow(request.getParameter("series"), "wanted", anime);
	%>
	<p><%=result%></p>

	<%
		}
	%>


</body>
</html>