package com.example.sce.controller;

import com.example.sce.dominio.Produto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProdutoController {

    public boolean isProdutoValido(Produto produto) {
        DateFormat fabricacaoFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fabricacaoStr = fabricacaoFormat.format(produto.getFabricacao());
        return isNomeValido(produto) && isMarcaValido(produto) && validarFabricacao(fabricacaoStr) && validarPreco(String.valueOf(produto.getPreco()));
    }

    private boolean isNomeValido(Produto produto) {
        if ((produto.getNome().isEmpty()) || produto.getNome().length() < 3) {
            return false;
        }

        return true;
    }

    private boolean isMarcaValido(Produto produto){
        if ((produto.getMarca().isEmpty())|| produto.getMarca().length() < 2){
            return false;
        }

        return true;
    }

    public boolean validarFabricacao(String dataStr) {
        try {
            DateTimeFormatter fabricacao = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate data = LocalDate.parse(dataStr, fabricacao);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    public boolean validarPreco(String precoStr) {
        try {
            float preco = Float.parseFloat(precoStr);
            return Float.isFinite(preco);
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}