package com.app.tracknmebackend.repository;

import com.app.tracknmebackend.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

    List<FuncionarioModel> findByOrderById();
    List<FuncionarioModel> findByCep(String cep);
}
