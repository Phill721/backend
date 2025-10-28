package com.example.MicroUsuarios.validations;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator {
    
    private static final String[] DOMINIOS_PERMITIDOS = {"@gmail.com", "@duocuc.cl"};
    
    public boolean validarDominioEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        String emailLower = email.toLowerCase();
        for (String dominio : DOMINIOS_PERMITIDOS) {
            if (emailLower.endsWith(dominio)) {
                return true;
            }
        }
        return false;
    }
    
    public void validarEmail(String email) {
        if (!validarDominioEmail(email)) {
            throw new RuntimeException("El dominio del email debe ser @gmail.com o @duocuc.cl");
        }
    }
}