<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Sign On</title>
</head>

<body>

	<h3>access to weibo</h3>
	<s:form action="Bind" namespace="/weiboAction" method="post">
		<s:submit name="execute" value="access" />
	</s:form>

</body>
</html>
