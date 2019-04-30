<%@ include file="templates/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <div class="panel-heading"> Home Page</div>
    <div class="panel-body">




        <form:form id="consulta" action="/gerar/recomendacoes" name="consulta" method="GET">


            <div class="form-group">
                <label for="companhia">Com quem você irá assistir o filme? </label>
                <select class="form-control" id="companhia" name="companhia">
                    <option value="FAMILIA" ${companhia == 'FAMILIA' ? 'selected' : ''}> Família </option>
                    <option value="AMIGOS" ${companhia == 'AMIGOS' ? 'selected' : ''}> Amigos </option>
                    <option value="SOZINHO" ${companhia == 'SOZINHO' ? 'selected' : ''}> Sozinho </option>
                    <option value="NAMORAD" ${companhia == 'NAMORAD' ? 'selected' : ''}> Namorado(a) </option>
                    <option value="FILHOS" ${companhia == 'FILHOS' ? 'selected' : ''}> Filhos </option>
                </select>
            </div>

            <div class="form-group">
                <label for="avaliacao">Para você é importante o filme ser bem avaliado?</label>
                <select class="form-control" id="avaliacao" name="avaliacao">
                    <option value="UM" ${avaliacao == 'UM' ? 'selected' : ''}> Nem um pouco </option>
                    <option value="DOIS" ${avaliacao == 'DOIS' ? 'selected' : ''}> um pouco </option>
                    <option value="TRES" ${avaliacao == 'TRES' ? 'selected' : ''}> mais ou menos</option>
                    <option value="QUATRO" ${avaliacao == 'QUATRO' ? 'selected' : ''}> Importante </option>
                    <option value="CINCO" ${avaliacao == 'CINCO' ? 'selected' : ''}> Muito importante</option>
                </select>
            </div>


            <div class="form-group">
                <label for="oscar">Para você quão importante é um filme ter ganhado o Oscar?</label>
                <select class="form-control" id="oscar" name="oscar">
                    <option value="UM" ${oscar == 'UM' ? 'selected' : ''}> Nem um pouco </option>
                    <option value="DOIS" ${oscar == 'DOIS' ? 'selected' : ''}> Um pouco </option>
                    <option value="TRES" ${oscar == 'TRES' ? 'selected' : ''}> Mais ou menos</option>
                    <option value="QUATRO" ${oscar == 'QUATRO' ? 'selected' : ''}> Importante </option>
                    <option value="CINCO" ${oscar == 'CINCO' ? 'selected' : ''}> Muito importante</option>
                </select>
            </div>


            <div class="form-group">
                <label for="recente">Você gostaria que o filme fosse recente?</label>
                <select class="form-control" id="recente" name="recente">
                    <option value="UM" ${recente == 'UM' ? 'selected' : ''}> Nem um pouco </option>
                    <option value="DOIS" ${recente == 'DOIS' ? 'selected' : ''}> Um pouco </option>
                    <option value="TRES" ${recente == 'TRES' ? 'selected' : ''}> Mais ou menos</option>
                    <option value="QUATRO" ${recente == 'QUATRO' ? 'selected' : ''}> Gostaria </option>
                    <option value="CINCO" ${recente == 'CINCO' ? 'selected' : ''}> Gostaria Muito </option>
                </select>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <div class="col-md-12" align="center">
                <button type="submit" class="btn btn-primary" style="width: 80%"> Gerar Recomendações </button>
            </div>

        </form:form>


        <div class="col-md-12" style="margin-left: 5%">

            <c:forEach var="recomendacao" items="${recomendacoes}">

                <div class="col-md-2" style="margin-top: 20px">
                    <table class="table table-striped">
                        <tr>
                            <td>

                                <c:if test="${empty recomendacao.url}">
                                    <img src="/resources/fotos/${recomendacao.key}.jpg" width="140" height="180">
                                </c:if>
                                <c:if test="${not empty recomendacao.url}">
                                    <img src="${recomendacao.url}" width="140" height="180">
                                </c:if>

                            </td>
                        </tr>
                        <tr> <td align="center" style="${recomendacao.value.equals(maior) ? 'background-color: #74f58d' : 'background-color: #98dee1'}; border-radius: 3px"><span style="font-size: large">${recomendacao.value}%</span></td></tr>
                    </table>
                </div>

            </c:forEach>
        </div>

    </div>

    <div class="panel-footer"> @IA-PROJECT - Iago Machado </div>
</div>
<%@ include file="templates/footer.jsp"%>