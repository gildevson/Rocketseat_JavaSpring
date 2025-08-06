package br.com.rocketseat.todolist.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component // oque é ? quer que a CLASSE gerencie
public class FilterTaskAuth implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    //  Executar alguma ação

        System.out.println("Chegou no filtro");
        chain.doFilter(request, response);
    }
}
