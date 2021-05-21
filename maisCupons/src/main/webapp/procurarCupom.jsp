<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Procurar cupons</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="persona.css">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="kisspng-computer-icons-coupon-voucher-coupon-vector-5adc48be56bb86.7091344415243859823553.png" alt="" width="40" height="34" class="d-inline-block align-text-center">
                    +Cupons
                </a>
            </div>
        </nav>
        <table class="navbar navbar-light bg-ligh">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Departamento</th>
                    <th>Desconto</th>
                </tr>
            </thead>
            <tbody>
                <!--   for (Todo todo: todos) {  -->
            <c:forEach var="cupom" items="${listCupom}">

                <tr>
                    <td><c:out value="${cupom.id}" /></td>
                <td><c:out value="${cupom.nome}" /></td>
                <td><c:out value="${cupom.departamento}" /></td>
                <td><c:out value="${cupom.desconto}" /></td>
                </tr>
            </c:forEach>
            <!-- } -->
        </tbody>

    </table>

</body>
</html>
