<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <div class="panel-heading"> Home Page</div>
    <div class="panel-body">




        <form:form id="consulta" action="/gerar/recomendacoes" name="consulta" method="GET">

        <div class="form-group">
            <label for="avaliacao">Para você é importante o filme ser bem avaliado?</label>
            <select class="form-control" id="avaliacao" name="avaliacao">
                <option value="UM"> Nem um pouco </option>
                <option value="DOIS"> um pouco </option>
                <option value="TRES"> mais ou menos</option>
                <option value="QUATRO"> Importante </option>
                <option value="CINCO"> Muito importante</option>
            </select>
        </div>

        <div class="form-group">
            <label for="companhia">Com quem você irá assistir o filme? </label>
            <select class="form-control" id="companhia" name="companhia">
                <option value="FAMILIA"> Família </option>
                <option value="AMIGOS"> Amigos </option>
                <option value="SOZINHO"> Sozinho </option>
                <option value="NAMORAD"> Namorado(a) </option>
                <option value="FILHOS"> Filhos </option>
            </select>
        </div>

        <div class="form-group">
            <label for="oscar">Para você quão importante é um filme ter ganhado o Oscar?</label>
            <select class="form-control" id="oscar" name="oscar">
                <option value="UM"> Nem um pouco </option>
                <option value="DOIS"> Um pouco </option>
                <option value="TRES"> Mais ou menos</option>
                <option value="QUATRO"> Importante </option>
                <option value="CINCO"> Muito importante</option>
            </select>
        </div>


        <div class="form-group">
            <label for="recente">Você gostaria que o filme fosse recente?</label>
            <select class="form-control" id="recente" name="recente">
                <option value="UM"> Nem um pouco </option>
                <option value="DOIS"> Um pouco </option>
                <option value="TRES"> Mais ou menos</option>
                <option value="QUATRO"> Gostaria </option>
                <option value="CINCO"> Gostaria Muito </option>
            </select>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

         <div class="col-md-12" align="center">
             <button type="submit" class="btn btn-primary" style="width: 80%"> Gerar Recomendações </button>
         </div>

        </form:form>
    </div>

    <div class="col-md-12">

        <table class="table table-striped">
            <tr>
                <th> Filme </th>
                <th> Recomendação </th>
            </tr>

            <c:forEach var="recomendacao" items="${recomendacoes}">
                <tr>
                    <td> <img src="/resources/fotos/${recomendacao.key}.jpg" width="110" height="160"> </td>                           </td>
                    <td> ${recomendacao.value}% </td>
                </tr>
            </c:forEach>

        </table>
    </div>



    <div class="panel-footer"> @IA-PROJECT - Iago Machado </div>
 </div>
<%@ include file="templates/footer.jsp"%>