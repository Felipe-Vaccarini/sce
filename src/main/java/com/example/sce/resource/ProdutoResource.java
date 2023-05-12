package com.example.sce.resource;

import com.example.sce.dominio.Produto;
import com.example.sce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/list")
    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        produto = produtoRepository.save(produto);

        return new ResponseEntity(produto, HttpStatus.OK);
    }

}
