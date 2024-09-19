<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Atencion Al Cliente</title>
<jsp:include page="encabesado.jsp"></jsp:include>
<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>



</head>
<body>


	<form name="login" id="login"
		action="SeguridadServlet?accion=verificar" method="POST">
		<table border="0" align="center">
			<tbody>
				<tr>
					<td colspan="3" align="center"><h1>
							<b>Ingreso Al Sistema</b>
						</h1></td>
				</tr>
				<tr>
					<td>Usuario :</td>
					<td><input type="text" name="usuario" id="usuario" /></td>
					<td rowspan="2"><h:graphicImage
							value="imagenes/if_Login_73221.png" height="100%" width="100%"
							alt="" /></td>


				</tr>
				<tr>
					<td>Contraseña :</td>
					<td><input type="password" name="contrasena" id="contrasena" /></td>
				</tr>
				<tr>


					<td colspan="3"><input type="submit" value="Verificar"
						name="verificar" id="verificar" style="width: 100%;" /></td>
				</tr>


			</tbody>
		</table>


	</form>
	<div id="mensajeerror"></div>

	<a href="#">Verificar Credenciales</a>
	<a href="#">Registrar Usuario</a>
</body>
</html>