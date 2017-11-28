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
				<td><%=m.getOriginal_title()%></td>
				
				<td><%=m.getYear()%></td>
				<td><%= m.getMpaa() %></td>
				<td><a
					href="https://www.themoviedb.org/movie/<%=m.getTmdbid()%>"><%=m.getTmdbid()%></a></td>
				<td><button>Add</button></td>
				<input type="hidden" name="movieid" value="<%=m.getTmdbid()%>" />
			</tr>
			<%
				}
			%>
		</table>
	</form>
	<%
		}
		} else {
			/*API api = new API();
			boolean anime = request.getParameter("anime") != null && request.getParameter("anime").equals("on");
			System.out.print("Anime value = "+ anime);
			
			String result = api.addNewShow(request.getParameter("series"), "wanted", anime);*/
		%> 
		<p>Still need to add the Api to add this movie.</p>
		<%
		}
	%>


</body>
</html>