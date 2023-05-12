package com.example.sce.controller;

import com.example.sce.dominio.Produto;
public class ProdutoController {

    public boolean isProdutoValido(Produto produto) {
        return isNomeValido(produto);
    }

    private boolean isNomeValido(Produto produto) {
        if ((produto.getNome().isEmpty()) || produto.getNome().length() < 3) {
            return false;
        }

        return true;
    }

}
