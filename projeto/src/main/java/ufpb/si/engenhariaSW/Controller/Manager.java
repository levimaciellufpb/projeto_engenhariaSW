package ufpb.si.engenhariaSW.Controller;

import ufpb.si.engenhariaSW.Model.AlterarHistorico;
import ufpb.si.engenhariaSW.Model.Crianca;
import ufpb.si.engenhariaSW.Model.Historico;
import ufpb.si.engenhariaSW.Model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    private final HashMap<String, Usuario> usuarios;
    private DadosProjeto dadosProjeto;

    public Manager(){
        usuarios = new HashMap<>();
        dadosProjeto = new DadosProjeto("dados.txt");
    }

    //Possíveis métodos
    //adicionar e remover usuário,adicionar criança, verDadosDaCriança (to string?) ,
    // AlterarDadosDaCriança (deixar em off por enquanto) verHistórico, alterarHistórico
    // Ideal é trocar todos os retornos null por exceções personalizadas

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

    public Historico alterarHistoricoDaCrianca(Usuario usuario, Crianca crianca, String alteracao,
                                               AlterarHistorico opcao){

        //Algoritmo: pesquisar se existe usuário e criança, e pegar o histórico da criança
        //Dependendo de um enum, alterar o campo correto do histórico.
        //usuario deve existir e criança também, se não retornar null

        if(!usuarioExiste(usuario) && !criancaExiste(usuario, crianca))
            return null;

        Historico historicoEncontrado = usuario.getCrianca(crianca).getHistorico();

        switch (opcao){

            case DOENCAS:
                historicoEncontrado.setDoencas(alteracao);
                return historicoEncontrado;

            case MEDICACOES:
                historicoEncontrado.setMedicacoes(alteracao);
                return historicoEncontrado;

            case CONSULTAS:
                historicoEncontrado.setConsultas(alteracao);
                return historicoEncontrado;

            case ALERGIAS:
                historicoEncontrado.setAlergias(alteracao);
                return historicoEncontrado;

            case DENTICOES:
                historicoEncontrado.setDenticoes(alteracao);
                return historicoEncontrado;

            case OUTROS:
                historicoEncontrado.setOutros(alteracao);
                return historicoEncontrado;

            default:
                return null;
        }
    }

    public HashMap<String, Usuario> carregarDados(){
        return null;
    }

    public void escreverDados(){
        List<String> dadosEmString = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        String nomeU, email, senha;

        for(Usuario u: usuarios.values()){

            nomeU = u.getNome();
            email = u.getEmail();
            senha = u.getSenha();

            builder.append(nomeU).append(email).append(senha);

            dadosEmString.add(builder.toString());

            //Limpar o builder
            builder.setLength(0);
        }
        try{
            dadosProjeto.writeDados(dadosEmString);
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }

    }



    private boolean usuarioExiste(Usuario usuario){
       return usuarios.containsValue(usuario);
    }

    private boolean criancaExiste(Usuario usuario, Crianca crianca){
        return usuarioExiste(usuario) && usuario.getCriancas().contains(crianca);
    }









    //Getter Somente para fins de teste!
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
