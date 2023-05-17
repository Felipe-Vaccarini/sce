package com.example.sce.repository;

import com.example.sce.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, long id);
}
