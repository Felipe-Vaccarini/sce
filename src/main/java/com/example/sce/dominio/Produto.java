package com.example.sce.dominio;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String marca;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fabricacao;

    private Float preco;
}
