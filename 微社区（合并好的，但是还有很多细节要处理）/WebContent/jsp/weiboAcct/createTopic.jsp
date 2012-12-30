<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create topic</title>
</head>
<body>
	<h3>let's create a new topic</h3>
	<s:form action="Topic" namespace="/communityAction">
		<table>
			<tr>
				<td><s:textfield name="tpTitle" label="topic name" value="name"/></td>
			</tr>
			<tr style="width: 320px; ">
				<td style="width: 300px; "><s:textfield name="tpContent"
						label="topic content" value="content"/>
			</tr>
			<tr>
				<td><s:submit name="execute" value="create"/>
			</tr>
		</table>
	</s:form>
</body>
</html>