<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JOB SEEKER LOGIN</title>
<%@include file ="component/allcss.jsp" %>

<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

   <%@include file="component/navbar.jsp" %>
   
   <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">JOB SEEKER LOGIN</p>

					

						<form action="GetJobSeeker" method="get">
							<div class="mb-3">
								<label class="form-label">Email address</label> <input required
									name="email" type="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
                             <input type="hidden" name="actionType" value="login"/>
							<button class="btn bg-danger text-white col-md-12">Login</button>
						</form>

						<br> Don't have an account? <a href="JobSeekerRegistration.jsp"
							class="text-decoration-none"> create one</a>

					</div>
				</div>
			</div>
		</div>
	</div>
   

</body>
</html>