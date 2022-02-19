package br.com.dalcy.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe para gerar a criptografia da senha.
 *
 * @author Dalcimar
 */
public class EncriptarPassword {

    public static void main(String[] args) {

        var password = "123";
        System.out.println("password = " + password);
        System.out.println("senha encriptada: " + encriptarPassword(password));
    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
