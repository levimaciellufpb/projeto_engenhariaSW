package ufpb.si.engenhariaSW.Controller;

import ufpb.si.engenhariaSW.Exceptions.UsuarioException;
import ufpb.si.engenhariaSW.Model.AlterarHistorico;
import ufpb.si.engenhariaSW.Model.Crianca;
import ufpb.si.engenhariaSW.Model.Historico;
import ufpb.si.engenhariaSW.Model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    //Adiciona um usuário
    public void addUsuario(Usuario usuario) throws UsuarioException {
        //usuario não pode ser null
        if(usuario == null || usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null)
            throw new RuntimeException("addUsuario: Usuario não pode ser null! Nem seus atributos");

        //Nenhum de seu atributos podem ser strings vazias
        if(usuario.getNome().equals("") || usuario.getEmail().equals("")|| usuario.getSenha().equals(""))
            throw new RuntimeException("addUsusrio: Usuario não pode ter seu atributos string vazia!");

        //talvez não permitir adicionar usuários de mesmo nome para evitar bugs
        if(usuarios.containsKey(usuario.getNome()))
            throw new UsuarioException("addUsuario: Não é possível adicionar usuários de mesmo nome");

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

    public void carregarDados(){

        String nomeU, email, senha;
        String nomeC, genero, nomePai, nomeMae;
        String doencas, medicacoes, denticoes, consultas, alergias, outros;
        int idade, numCriancas, dataNascimento, rg, cpf;


        try {
            List<String> dadosCarregados = dadosProjeto.readDados();

            for(String s : dadosCarregados){

                String [] splitted = s.split(",", -1);

                int cont = 0;

                nomeU = splitted[cont++];
                email = splitted[cont++];
                senha = splitted[cont++];

                numCriancas = Integer.parseInt(splitted[cont++]);

                Usuario newUsuario = new Usuario(nomeU, email, senha);
                Crianca newCrianca;


                for(int i = 0; i < numCriancas; i++){
                    nomeC = splitted[cont++];
                    idade = Integer.parseInt(splitted[cont++]);
                    dataNascimento = Integer.parseInt(splitted[cont++]);
                    genero = splitted[cont++];
                    rg = Integer.parseInt(splitted[cont++]);
                    cpf = Integer.parseInt(splitted[cont++]);
                    nomeMae = splitted[cont++];
                    nomePai = splitted[cont++];

                    newCrianca = new Crianca(nomeC,idade,dataNascimento,genero,rg,cpf,nomeMae,nomePai);
                    Historico hist = newCrianca.getHistorico();

                    doencas = splitted[cont++];
                    hist.setDoencas(doencas);

                    medicacoes  = splitted[cont++];
                    hist.setMedicacoes(medicacoes);

                    denticoes = splitted[cont++];
                    hist.setDenticoes(denticoes);

                    consultas = splitted[cont++];
                    hist.setConsultas(consultas);

                    alergias = splitted[cont++];
                    hist.setAlergias(alergias);

                    outros = splitted[cont++];
                    hist.setOutros(outros);


                    newUsuario.addCrianca(newCrianca);

                }

                usuarios.put(newUsuario.getNome(), newUsuario);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void escreverDados(){
        List<String> dadosEmString = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        String nomeU, email;
        String senha;

        for(Usuario u: usuarios.values()){

            nomeU = u.getNome();
            email = u.getEmail();
            senha = u.getSenha();

            builder.append(nomeU).append(",").append(email).append(",").append(senha);

            //Impasse, visto que cada usuário tem uma lista de criancas




            //atributos de criança
            String nomeC, genero, nomeDoPai, nomeDaMae;
            int idade, dataNascimento, rg, cpf;

            //atributos de histórico
            Historico historico;
            String doencas, medicacoes, denticoes, consultas, alergias, outros;

            if(u.getCriancas() != null){
                //Ideia: add um contador da lista para saber quantas crianças tem
                builder.append(",").append(u.getCriancas().size()).append(",");

                for(Crianca c: u.getCriancas()){
                    nomeC = c.getNome();
                    idade = c.getIdade();
                    dataNascimento = c.getDataNascimento();
                    genero = c.getGenero();
                    rg = c.getRg();
                    cpf = c.getCpf();
                    nomeDoPai = c.getNomeDoPai();
                    nomeDaMae = c.getNomeDaMae();

                    builder.append(nomeC).append(",").append(idade).append(",").append(dataNascimento).append(",").append(genero).append(",")
                            .append(rg).append(",").append(cpf).append(",").append(nomeDoPai).append(",")
                            .append(nomeDaMae).append(",");

                    //Necessário escrever cada atributo do histórico
                    historico = c.getHistorico();
                    doencas = historico.getDoencas();
                    medicacoes = historico.getMedicacoes();
                    denticoes = historico.getDenticoes();
                    consultas = historico.getConsultas();
                    alergias = historico.getAlergias();
                    outros = historico.getOutros();

                    builder.append(doencas).append(",").append(medicacoes).append(",").append(denticoes).append(",")
                            .append(consultas).append(",").append(alergias).append(",").append(outros).append(",");


                }

            }

            //builder.append("\n");


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
    private boolean usuarioExiste(String username){return usuarios.containsKey(username);}

    public Usuario getUsuario(String nomeUsuario){

        if(!usuarioExiste(nomeUsuario))
            return null;

        return usuarios.get(nomeUsuario);

    }


    private boolean criancaExiste(Usuario usuario, Crianca crianca){
        return usuarioExiste(usuario) && usuario.getCriancas().contains(crianca);
    }

    public boolean validarUsuario(String email, String senha){

        if(email == null || senha == null)
            throw new RuntimeException("ValidarUsuario: email ou senha são nulos");

        for(Usuario u: usuarios.values()){
            if(u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha))
                return true;
        }

        return false;
    }








    //Getter Somente para fins de teste!
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
