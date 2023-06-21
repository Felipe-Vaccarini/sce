package com.example.sce.controller;

import com.example.sce.dominio.Produto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProdutoController {

    public boolean isNomeValido(Produto produto) {
        if ((produto.getNome().isEmpty()) || produto.getNome().length() < 3) {
            return false;
        }

        return true;
    }

    public boolean isMarcaValido(Produto produto){
        if ((produto.getMarca().isEmpty())|| produto.getMarca().length() < 2){
            return false;
        }

        return true;
    }

    public boolean validarPreco(Produto produto) {
        try {
            Float preco = produto.getPreco();
            if (preco == null || preco.isNaN() || preco.isInfinite()) {
                return false;
            }
            return true;
        } catch (org.springframework.http.converter.HttpMessageNotReadableException e) {
            return false;
        }
    }
}