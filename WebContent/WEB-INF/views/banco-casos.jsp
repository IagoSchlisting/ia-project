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


                    <a href="" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
                        Adicionar Caso Manualmente
                    </a>

                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form:form>


            <!-- Modal -->
            <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
        <div class="panel-footer"> @IA-PROJECT - Iago Machado </div>
    </div>
<%@ include file="templates/footer.jsp"%>