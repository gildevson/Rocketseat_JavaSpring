package br.com.rocketseat.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * modificador
 * Public
 * private
 * protected
 * */
@RestController
@RequestMapping("/users")
public class UserController {

    /** String texto
     *  Integer (int ) numeros inteiros
     * Double (double) Numero 0.0000
     * Float (float) Números 0.0000
     * char (A C)
     * Date (data)
     * Body
     * */


    @PostMapping("/")
    public void create(@RequestBody UserModel userModel ) {
        System.out.println("Nome do nome: " + userModel.getName());
        System.out.println("Nome do usuario: " + userModel.getUsername());

    }

}
