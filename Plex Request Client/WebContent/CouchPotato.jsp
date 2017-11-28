<%@page import="java.util.List"%>
<%@page import="com.aclogar.plex.tools.couchpotato.Movie"%>
<%@page import="com.aclogar.plex.tools.couchpotato.API"%>

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

			List<Movie> movies = API.searchMovies(request.getParameter("query"));

			if (movies.size() > 0) {
	%>
	<form class="webdesigntuts-workshop-form">
		<table>
			<tr>
				<td>Title</td>
				<td>Year</td>
				<td>mpaa</td>
				<td>Movie ID</td>
				<td></td>
			</tr>

			<%
				for (Movie m : movies) {
			%>
			<tr>
				<form>
					<td><%=m.getOriginal_title()%></td>
					
					<td><%=m.getYear()%></td>
					<td><%= m.getMpaa() %></td>
					<td><a
						href="http://www.imdb.com/title/<%=m.getImdb()%>"><%=m.getImdb()%></a></td>
					<td><button>Add</button></td>
					<input type="hidden" name="movieid" value="<%=m.getImdb() %>" />
				</form>
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
			String id = request.getParameter("movieid");
			System.out.print("Adding movie with id of "+ id);
			if(id != null){
				String result = api.addMovie(id);
				%> 
				<p><%= result %></p>
				<%
			}else{
				%> 
				<p>Movie ID was null.</p>
				<%
			}
		}
	%>


</body>
</html>