package com.ufcg.es.healthtrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.es.healthtrack.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {}
