package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
