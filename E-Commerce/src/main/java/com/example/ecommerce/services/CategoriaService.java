package com.example.ecommerce.services;

import com.example.ecommerce.DTOs.CategoriaDTO;
import com.example.ecommerce.entities.Categoria;
import com.example.ecommerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public String criarCategoria(CategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        return "Categoria criada com sucesso";
    }

    public CategoriaDTO buscarCatId(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    public String delete(long id) {
        categoriaRepository.deleteById(id);
        return "excluido com sucesso";
    }

    public List<Categoria> buscarTodasCat(){
        return categoriaRepository.findAll();
    }

    public CategoriaDTO atualizarCat(Long id, CategoriaDTO dto){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaDTO cdto = new CategoriaDTO();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        cdto.setId(categoria.getId());
        cdto.setNome(categoria.getNome());
        return cdto;
    }
}
