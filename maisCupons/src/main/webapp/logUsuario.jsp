<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login do usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                <a class="navbar-brand" href="index.jsp">
                    <img src="kisspng-computer-icons-coupon-voucher-coupon-vector-5adc48be56bb86.7091344415243859823553.png" alt="" width="40" height="34" class="d-inline-block align-text-center">
                    +Cupons
                </a>
            </div>
        </nav>
        <form action="<%= request.getContextPath() %>/logUsuarioServlet"  class="formularioLogin1" method="post"> 
            <p> Login Usuário</p>

            <div class="field">
                <label for="email" class = "email">Email:</label>
                <input type="email" id="emailid" name="email" placeholder="Digite seu Email" required>
            </div>

            <div class="field">
                <label for="senha">Senha:</label>
                <input type="password" id="senhaid" name="senha" placeholder="Digite sua senha"required>

            </div>
            <a><button type="submit" class="btn btn-warning medio" >Entrar</button >
                <a href="cadastroUsuario.jsp"><button type="button" class="btn btn-warning medio" >Cadastrar usuario</button ></a>

        </form>
    </body>
</html>
