package com.example.sce.resource;

import com.example.sce.controller.ProdutoController;
import com.example.sce.dominio.Produto;
import com.example.sce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> create(@RequestBody Produto produto) {
        ProdutoController produtoController = new ProdutoController();
        if (produtoRepository.existsByNome(produto.getNome())) {
            return new ResponseEntity<>("Já existe um produto com o mesmo nome", HttpStatus.CONFLICT);
        }

        if (!produtoController.isNomeValido(produto)) {
            return new ResponseEntity<>("Nome inválido", HttpStatus.CONFLICT);
        }

        if (!produtoController.isMarcaValido(produto)) {
            return new ResponseEntity<>("Marca inválida", HttpStatus.CONFLICT);
        }

        if (!produtoController.validarPreco(produto)) {
            return new ResponseEntity<>("Preço inválido", HttpStatus.CONFLICT);
        }


        produto = produtoRepository.save(produto);

        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public Optional<Produto> getById(@PathVariable(value = "id") int id) {
        return produtoRepository.findById(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editar(@RequestBody Produto produto) {
        ProdutoController produtoController = new ProdutoController();

        if (produtoRepository.existsByNomeAndIdNot(produto.getNome(), produto.getId())) {
            return new ResponseEntity<>("Já existe um produto com o mesmo nome", HttpStatus.CONFLICT);
        }

        if (!produtoController.isNomeValido(produto)) {
            return new ResponseEntity<>("Nome inválido", HttpStatus.CONFLICT);
        }

        if (!produtoController.isMarcaValido(produto)) {
            return new ResponseEntity<>("Marca inválida", HttpStatus.CONFLICT);
        }

        if (!produtoController.validarPreco(produto)) {
            return new ResponseEntity<>("Preço inválido", HttpStatus.CONFLICT);
        }

        produto = produtoRepository.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping("/total")
    public long getTotal() {
        return produtoRepository.count();
    }

    @DeleteMapping("/remove/{id}")
    public Produto remove(@PathVariable(value = "id") int id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        produtoRepository.delete(optionalProduto.get());
        return optionalProduto.get();
    }

}
