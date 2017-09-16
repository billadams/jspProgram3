<%-- 
    Document   : index
    Created on : Jul 26, 2017, 11:18:14 AM
    Author     : Bill Adams
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<h1>Employee List</h1>

<c:if test="${message != null}">
    <div class="alert alert-success" role="alert">
        <p>${message}</p>
    </div>
</c:if>

<c:if test="${searchDateFormatted != null}">
    <div class="alert alert-success" role="alert">
        <p>Showing all employees hired on or ${searchCriteria} ${searchDateFormatted}.</p>
        <p>Records found: ${listCount}</p>
    </div>
</c:if>

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

<div class="row results">
    <div class="col-md-8">
        <form class="form-inline filter" action="EmployeeListServlet" method="post">
            <input type="hidden" name="action" value="order">
            <div class="form-group">
                <label for="order-by">Order by:</label>
                <select name="orderBy" id="order-by">
                    <option value="">Select a sort order</option>
                    <option value="firstName">First Name</option>
                    <option value="middleName">Middle Name</option>
                    <option value="lastName">Last Name</option>
                    <option value="birthDate">Birth Date</option>
                    <option value="hireDate">Hire Date</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default" title="Doesn't sort searched queries">Sort</button>
        </form>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Birth Date</th>
                    <th>Hire Date</th>
                    <th>Employee Type</th>
                    <th>Yearly Cost</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td><c:out value="${employee.firstName}" /></td>
                        <td><c:out value="${employee.middleName}" /></td>
                        <td><c:out value="${employee.lastName}" /></td>
                        <td><c:out value="${employee.birthDateFormatted}" /></td>
                        <td><c:out value="${employee.hireDateFormatted}" /></td>
                        <td>
                            <c:choose>
                                <c:when test="${employee.getClass().simpleName == 'EmpSalary'}">
                                    Salary
                                </c:when>
                                <c:when test="${employee.getClass().simpleName == 'EmpHourly'}">
                                    Hourly
                                </c:when>
                                <c:otherwise>
                                    None
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${employee.getClass().simpleName == 'EmpSalary'}">
                                    <c:out value="${employee.yearlyPayCurrencyFormat}" />
                                </c:when>
                                <c:when test="${employee.getClass().simpleName == 'EmpHourly'}">
                                    <c:out value="${employee.yearlyPayCurrencyFormat}" />
                                </c:when>
                                <c:otherwise>
                                    None
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <form action="EmployeeEditServlet" method="post">
                                <input type="hidden" name="action" value="editEmployee">
                                <input type="hidden" name="employeeID" 
                                       value="<c:out value='${employee.employeeID}' />">
                                <button class="btn btn-default" type="submit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="col-md-4">
        <form action="EmployeeListServlet" method="post">
            <input type="hidden" name="action" value="searchRequest">
            <div class="form-group">
                <label for="select-hire-date">Search hire date</label>
                <input type="date" name="searchDate" class="form-control" id="select-hire-date" value="<c:out value='${dateInputString}' />">
            </div>
            <div class="radio">
                <label for="before-date">
                    <input type="radio" name="optionsDate" id="before-date" value="before" checked>Before selected date
                </label>
            </div>
            <div class="radio">
                <label for="after-date">
                    <input type="radio" name="optionsDate" id="after-date" value="after">After selected date
                </label>
            </div>

            <button type="submit" class="btn btn-primary">Search</button>
            <button type="reset" class="btn btn-warning">Reset</button>
        </form>
    </div>
</div> <!-- end row -->

<form action="EmployeeListServlet" method="post">
    <input type="hidden" name="action" value="clearSearch">
    <input class="btn btn-primary btn-block" type="submit" value="Clear Search"
        <c:if test="${hasSearched == false}">
            disabled
        </c:if> >
</form>
          
<c:import url="/includes/footer.jsp" />