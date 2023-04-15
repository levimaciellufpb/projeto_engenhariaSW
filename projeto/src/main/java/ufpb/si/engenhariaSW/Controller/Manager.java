package ufpb.si.engenhariaSW.Controller;

import ufpb.si.engenhariaSW.Model.Usuario;

import java.util.HashMap;

public class Manager {

    private HashMap<String, Usuario> usuarios;

    public Manager(){
        usuarios = new HashMap<>();
    }

    //Possíveis métodos
    //adicionar e remover usuário, verDadosDaCriança, AlterarDadosDaCriança
    //verHistórico, alterarHistórico

    public void addUsuario(Usuario usuario){
        //usuario não pode ser null
        usuarios.put(usuario.getNome(), usuario);
    }

    public Usuario removerUsuario(String nomeUsuario){
        //caso não seja encontrado um usuário, retornar null

        if(!usuarios.containsKey(nomeUsuario)){
            return null;
        }

         return usuarios.remove(nomeUsuario);

    }

    //Getter Somente para fins de teste!
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
