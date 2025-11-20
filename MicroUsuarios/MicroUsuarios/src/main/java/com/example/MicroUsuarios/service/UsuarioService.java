package com.example.MicroUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroUsuarios.model.Roles;
import com.example.MicroUsuarios.model.Usuario;
import com.example.MicroUsuarios.repository.UsuarioRepository;
import com.example.MicroUsuarios.utils.PasswordEncoder;
import com.example.MicroUsuarios.validations.EmailValidator;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarXid(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        // Validar email
        emailValidator.validarEmail(usuario.getEmail());
        
        // Encriptar password antes de guardar
        String passwordEncriptado = passwordEncoder.encriptarPassword(usuario.getPassword());
        usuario.setPassword(passwordEncriptado);
        
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        // Validar email
        emailValidator.validarEmail(usuarioActualizado.getEmail());
        
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        
        // Encriptar password si se esta actualizando
        if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
            String passwordEncriptado = passwordEncoder.encriptarPassword(usuarioActualizado.getPassword());
            usuario.setPassword(passwordEncriptado);
        }
        
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setRol(usuarioActualizado.getRol());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarUsuariosPorRol(Roles rol) {
        return usuarioRepository.findByRol(rol);
    }
    
}