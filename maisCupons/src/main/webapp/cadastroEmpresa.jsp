<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Cadastro de empresa</title>
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
        <h1>+Cupons</h1> 
        <form action="<%= request.getContextPath() %>/cadastroEmpresaServlet_1" method="post"class="formularioUsuario">  
            <p class="fonteUsuario"> Cadastro de empresa</p>

            <div class="fieldUsuario">
                <label for="nome">Nome:</label>
                <input type="text" id="nomeid" name="nome" placeholder="Digite o nome da empresa" required>
            </div>

            <div class="fieldUsuario">
                <label for="cnpf">CNPJ:</label>
                <input type="number" id="cnpjid" name="cnpj" placeholder="Digite o CNPJ da empresa"required>
            </div>

            <div class="fieldUsuario">
                <label for="telefone">Telefone:</label>
                <input type="tel" id="telid" name="telefone" placeholder="Digite seu telefone"required>
            </div>

            <div class="fieldUsuario">
                <label for="email">Email:</label>
                <input type="email" id="emailid" name="email" placeholder="Digite seu email"required>
            </div>

            <div class="fieldUsuario">
                <label for="senha">Senha:</label>
                <input type="password" id="senhaid" name="senha" placeholder="Digite sua senha "required>
            </div>

            <a href="logEmpresa.jsp"><button type="submit" class="btn btn-warning medio" >Cadastrar empresa</button > </a>
        </form>

    </body>
</html>
