package ufpb.si.engenhariaSW.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private List<Crianca> criancas;

    public Usuario(String email, String senha, String nome){
        //tratamento de erro básico
        //Possivelmente validar email e validar senha
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        List<Crianca> criancas = new ArrayList<>();
    }

    public void addCrianca(Crianca crianca){
        //crianca não pode ser null
        criancas.add(crianca);
    }

    public Crianca getCrianca(String nomeCrianca){
        //nomeCrianca não pode ser null
        //Se n achar, retornar null
        for(Crianca c : criancas){
            if (c.getNome().equalsIgnoreCase(nomeCrianca))
                return c;
        }
        return null;
    }

    public String getNome() {
        return nome;
    }
}
