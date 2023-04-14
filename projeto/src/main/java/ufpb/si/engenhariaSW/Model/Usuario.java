package ufpb.si.engenhariaSW.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String email;
    private String senha;
    private List<Crianca> criancas;

    public Usuario(String email, String senha){
        //tratamento de erro básico
        //Possivelmente validar email e validar senha
        this.email = email;
        this.senha = senha;
        List<Crianca> criancas = new ArrayList<>();
    }






}
