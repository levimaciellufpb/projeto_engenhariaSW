package ufpb.si.engenhariaSW.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Crianca getCrianca(Crianca crianca){
        //nomeCrianca não pode ser null
        //Se n achar, retornar null
        for(Crianca c : criancas){
            if (c.equals(crianca))
                return c;
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public List<Crianca> getCriancas() {
        return criancas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
