package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
