package ufpb.si.engenhariaSW.Controller;

import ufpb.si.engenhariaSW.Model.Crianca;
import ufpb.si.engenhariaSW.Model.Historico;
import ufpb.si.engenhariaSW.Model.Usuario;

import java.util.HashMap;
import java.util.List;

public class Manager {

    private final HashMap<String, Usuario> usuarios;

    public Manager(){
        usuarios = new HashMap<>();
    }

    //Possíveis métodos
    //adicionar e remover usuário,adicionar criança, verDadosDaCriança (to string?) ,
    // AlterarDadosDaCriança (deixar em off por enquanto) verHistórico, alterarHistórico

    public void addUsuario(Usuario usuario){
        //usuario não pode ser null
        //talvez não permitir adicionar usuários de mesmo nome para evitar bugs
        usuarios.put(usuario.getNome(), usuario);
    }

    public Usuario removerUsuario(String nomeUsuario){
        //caso não seja encontrado um usuário, retornar null

        if(!usuarios.containsKey(nomeUsuario)){
            return null;
        }

         return usuarios.remove(nomeUsuario);
    }

    //Metodo tem retorno, pois esta pode ser add ou não
    public Crianca addCrianca(Usuario usuario, Crianca crianca){
        //Nem criança, nem Usuario devem ser null!
        //Não devem existir crianças iguais também ao se add

        if(!usuarios.containsValue(usuario))
            return null;

        usuarios.get(usuario.getNome()).addCrianca(crianca);
        return crianca;
    }

    public List<Crianca> getCriancas(String nomeUsuario){
        if(!usuarios.containsKey(nomeUsuario))
            return null;

        return usuarios.get(nomeUsuario).getCriancas();
    }

    public List<Crianca> getCriancas(Usuario usuario){
        return getCriancas(usuario.getNome());
    }

    public String getDadosdeCrianca(Usuario usuario, Crianca crianca){
        //usuario e criança não podem ser null!
        //retornar null caso não tenha algum dos itens

        if(!usuarios.containsKey(usuario.getNome()))
            return null;

        List<Crianca> criancas = getCriancas(usuario);
        for(Crianca c: criancas){
            if(c.equals(crianca))
                return c.toString();
        }
        return null;
    }

    public Historico getHistoricoDaCrianca(Usuario usuario, Crianca crianca){
        //usuario e crianca não podem ser null

        //Se getCriancas for null, ou usuário não existe ou não tem crianças
        if(getCriancas(usuario) == null || getCriancas(usuario).isEmpty())
            return null;

        List<Crianca> criancas = getCriancas(usuario);

        for(Crianca c: criancas){
            if(c.equals(crianca))
                return c.getHistorico();
        }

        return null;
    }

    




    //Getter Somente para fins de teste!
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
