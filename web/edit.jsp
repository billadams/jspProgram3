    <%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Practice 2</title>
    <link rel="stylesheet" href="styles/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<div class="container">
    <c:choose>
        <c:when test="${isUpdate == false}">
            <h1>Add new employee</h1>
        </c:when>
        <c:otherwise>
            <h1>Edit employee</h1>
        </c:otherwise>
    </c:choose>
    
    <c:if test="${errorMessages != null}">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <c:forEach var="error_message" items="${errorMessages}">
                <ul>
                    <li>${error_message}</li>
                </ul>
            </c:forEach>
        </div>
    </c:if>  

    <div class="col-md-6">
        <form action="EmployeeEditServlet" method="post">
            <input type="hidden" name="action" value="updateEmployee">
            <input type="hidden" name="employeeID" value="<c:out value='${employee.employeeID}' />">
            
            <div class="form-group row">
                <label for="first-name" class="col-md-3 col-form-label">First name:</label>
                <div class="col-md-9">
                    <input type="text" name="firstName" class="form-control" id="first-name" value="<c:out value='${employee.firstName}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="middle-name" class="col-md-3 col-form-label">Middle name:</label>
                <div class="col-md-9">
                    <input type="text" name="middleName" class="form-control" id="middle-name" value="<c:out value='${employee.middleName}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="last-name" class="col-md-3 col-form-label">Last name:</label>
                <div class="col-md-9">
                    <input type="text" name="lastName" class="form-control" id="last-name" value="<c:out value='${employee.lastName}' />">
                </div>
            </div> <!-- end form-group -->
            
            <div class="form-group row">
                <label for="date-of-birth" class="col-md-3 col-form-label">Date of Birth:</label>
                <div class="col-md-9">
                    
                    <input type="date" name="birthDate" class="form-control" id="date-of-birth" 
                        <c:choose>
                            <c:when test="${employee.birthDate != null}">
                                value="<c:out value='${employee.birthDateFormatted}' />"
                            </c:when>
                            <c:otherwise>
                                value=""
                            </c:otherwise>
                        </c:choose>
                    >
                </div>
            </div> <!-- end form-group -->  
            
            <div class="form-group row">
                <label for="hire-date" class="col-md-3 col-form-label">Hire Date:</label>
                <div class="col-md-9">
                    <input type="date" name="hireDate" class="form-control" id="last-name" 
                           <c:choose>
                               <c:when test="${employee.hireDate != null}">
                                   value="<c:out value='${employee.hireDateFormatted}' />"
                               </c:when>
                               <c:otherwise>
                                   value=""
                               </c:otherwise>
                           </c:choose>
                    >
                </div>
            </div> <!-- end form-group -->   
            
            <c:choose>
                <c:when test="${employee.getClass().simpleName == 'EmpSalary'}">
                    <div class="form-group row">
                        <label for="salary" class="col-md-3 col-form-label">Salary:</label>
                        <div class="col-md-9">
                            <input type="text" name="salary" class="form-control" id="salary"
                                value="<c:out value='${employee.salary}' />"
                            >
                        </div>
                    </div> <!-- end form-group -->
                </c:when>
                <c:when test="${employee.getClass().simpleName == 'EmpHourly'}">
                    <div class="form-group row">
                        <label for="average-weekly-hours" class="col-md-3 col-form-label">Average Hours:</label> 
                        <div class="col-md-9">
                            <input type="text" name="avgWeeklyHours" class="form-control" id="average-weekly-hours"
                                value="<c:out value='${employee.avgWeeklyHours}' />"
                            >
                        </div>
                    </div> <!-- end form-group -->
                    <div class="form-group row">
                        <label for="rate" class="col-md-3 col-form-label">Rate:</label>
                        <div class="col-md-9">
                            <input type="text" name="rate" class="form-control" id="rate"
                                value="<c:out value='${employee.rate}' />"
                            >
                        </div>
                    </div> <!-- end form-group -->
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>
            
            <div class="form-group row">
                <div>
                    <a href="EmployeeListServlet" class="btn btn-danger">Cancel</a>
                    <input class="btn btn-warning" type="reset" value="Reset">
                    <c:choose>
                        <c:when test="${isUpdate == false}">
                            <input class="btn btn-primary" type="submit" value="Add Employee">
                        </c:when>
                        <c:otherwise>
                            <input class="btn btn-primary" type="submit" value="Update Employee">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div> <!-- end form-group -->
            
        </form>
    </div> <!-- end col-md-6 -->

</div> <!-- end container -->
    
</body>
</html>