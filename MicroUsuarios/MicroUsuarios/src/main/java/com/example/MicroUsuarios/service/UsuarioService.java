package com.example.MicroUsuarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroUsuarios.model.Roles;
import com.example.MicroUsuarios.model.Usuario;
import com.example.MicroUsuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarXid(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setPassword(usuarioActualizado.getPassword());
        usuario.setRol(usuarioActualizado.getRol());
        return usuarioRepository.save(usuario);
    }

    // Nuevo método para buscar usuarios por rol
    public List<Usuario> buscarUsuariosPorRol(Roles rol) {
        return usuarioRepository.findByRol(rol);
    }
}