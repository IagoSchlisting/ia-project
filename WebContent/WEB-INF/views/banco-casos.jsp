<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="templates/messages.jsp"%>

<div class="panel panel-default">
    <div class="panel-heading"> Banco de Casos </div>
    <div class="panel-body">

        <table class="table table-striped">
            <tr>
                <th> id </th>
                <th> Companhia </th>
                <th> Imp.Avaliação </th>
                <th> Imp.Oscar </th>
                <th> Imp.SerRecente </th>
                <th> Filme </th>
                <th> Remover </th>
            </tr>
            <c:forEach var="caso" items="${casos}">
                <tr>
                    <td> ${caso.id} </td>
                    <td> ${caso.companhia} </td>
                    <td> ${caso.importanciaAvaliacao} </td>
                    <td> ${caso.importanciaOscar} </td>
                    <td> ${caso.importanciaSerRecente} </td>
                    <td> ${caso.filme} </td>
                    <td> <a href="/caso/remove/${caso.id}" class="btn btn-danger"> Remover </a> </td>
                </tr>
            </c:forEach>
        </table>

        <div class="col-md-12" style="margin-top: 20px;">
            <form:form id="casoscontrol" action="/adicionar/casos/fixos" name="user" method="post">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary"> Adicionar Casos Fixos </button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form:form>
        </div>
    </div>
        <div class="panel-footer"> @IA-PROJECT - Iago Machado </div>
    </div>
<%@ include file="templates/footer.jsp"%>