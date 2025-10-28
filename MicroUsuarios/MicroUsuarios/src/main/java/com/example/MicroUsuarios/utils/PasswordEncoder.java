package com.example.MicroUsuarios.utils;

import org.springframework.stereotype.Component;
import java.security.MessageDigest;
import java.util.Base64;

@Component
public class PasswordEncoder {
    
    public String encriptarPassword(String password) {
        try {
            // Usar SHA-256 para encriptación
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error encriptando password", e);
        }
    }
    
    public boolean verificarPassword(String passwordPlano, String passwordEncriptado) {
        String nuevoHash = encriptarPassword(passwordPlano);
        return nuevoHash.equals(passwordEncriptado);
    }
}