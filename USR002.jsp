<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <spring:url value="/resources/test.css" var="testCss" />
        <link href="${testCss}" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Course Registration</title>
</head>

<body>
    <div id="testheader">
        <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="MNU001.html"><h3>Student Registration</h3></a>
        </div>  
        <div class="col-md-6">
            <p>User: USR001 Harry</p>
            
        </div>  
        <div class="col-md-1" >
            <input type="button" class="btn-basic" id="lgnout-button" value="Log Out" onclick="location.href='LGN001.jsp'">
        </div>        
    </div>
</div>

</div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
            <div class="dropdown-container">
          <a href="BUD003.jsp">Course Registration </a>
          <a href="STU001.jsp">Student Registration </a>
          <a href="StudentDisplayServlet">Student Search </a>
        </div>
        <a href="UserDisplayServlet">Users Management</a>
      </div>
      <div class="main_contents">
    <div id="sub_content">
       <form:form action="updateUser" method="post" modelAttribute="userbean">
        
        <marquee direction='up'style=color:red;>${error}</marquee>
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Registration</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <form:label for="username" class="col-md-2 col-form-label" path="userid">UserId</form:label>
                <div class="col-md-4">
                    <form:input type="text" class="form-control" id="username" path="userid"/>
                    <form:errors path="userid" style="color:red;"></form:errors>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <form:label for="username" class="col-md-2 col-form-label" path="username">Username</form:label>
                <div class="col-md-4">
                    <form:input type="text" class="form-control" id="username" path="username"/>
                    <form:errors path="username" style="color:red;"></form:errors>
                </div>
            </div>
            
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <form:label for="email" class="col-md-2 col-form-label" path="email">Email</form:label>
                <div class="col-md-4">
                    <form:input type="email" class="form-control" id="email" path="email"/>
                    <form:errors path="email" style="color:red;"></form:errors>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <form:label for="Passowrd" class="col-md-2 col-form-label" path="password">Passowrd</form:label>
                <div class="col-md-4">
                    <form:input type="password" class="form-control" id="name" path="password"/>
                    <form:errors path="password" style="color:red;"></form:errors>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <form:label for="confirmPassword" class="col-md-2 col-form-label" path="confirmpassword">Confirm Passowrd</form:label>
                <div class="col-md-4">
                    <form:input type="password" class="form-control" id="confirmPassword" path="confirmpassword"/>
                    <form:errors path="confirmpassword" style="color:red;"></form:errors>
                </div>
            </div>
           
               <div class="row mb-4">
                <div class="col-md-2"></div>
                <form:label for="userRole" class="col-md-2 col-form-form:label" path="userrole">User Role</form:label>
                <div class="col-md-4">
                    <form:select class="form-select"  id="userRole" path="userrole">
                        <form:option value="Admin" selected="selected" >Admin</form:option>
                        <form:option value="User"  >User</form:option>
    
    
    
                    </form:select>
                </div>
            </div>
            
    
        <div class="row mb-4">
            <div class="col-md-4"></div>

            <div class="col-md-6">
               

                <button type="submit" class="btn btn-success col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button>
                
    

        </div>
        </form:form>
    </div>
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>
</body>

</html>

    


    
