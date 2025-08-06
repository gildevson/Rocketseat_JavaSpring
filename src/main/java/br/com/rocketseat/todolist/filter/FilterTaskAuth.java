package br.com.rocketseat.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rocketseat.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        var servletPath = request.getServletPath();

        // O erro estava aqui: a sintaxe do if estava errada.
        if (servletPath.equals("/tasks/")) {
            // Pegar a autenticação (Usuario e senha)
            var authorization = request.getHeader("Authorization");
            var authEncode = authorization.substring("Basic ".length()).trim();
            byte[] authDecode = Base64.getDecoder().decode(authEncode);


            var authString = new String(authDecode);

            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // validar o usuario
            var user = this.userRepository.findByUsername(username);

            if (user == null) {
                // Se o usuário não existe, retorna 401 Unauthorized
               response.sendError(401);
            } else {
                // Verifica a senha usando BCrypt
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

                if (passwordVerify.verified) {
                    // Autenticação bem-sucedida, continua o fluxo
                    filterChain.doFilter(request, response);
                } else {
                    // Senha incorreta, retorna 401 Unauthorized
                    response.sendError(401);
                }
            }
        } else {
            // Não é uma rota de task, continua o fluxo sem autenticar
            filterChain.doFilter(request, response);
        }
    }
}