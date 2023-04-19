package ufpb.si.engenhariaSW.Controller;

import ufpb.si.engenhariaSW.Model.Crianca;
import ufpb.si.engenhariaSW.Model.Historico;
import ufpb.si.engenhariaSW.Model.Usuario;

import java.util.Scanner;

public class testMain {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        Manager manager = new Manager();
        manager.carregarDados();

        while(continuar){
            System.out.println("Isso é um sistema de testes!");
            System.out.println("[0] cadastrar usuario");
            System.out.println("[1] remover usuario");
            System.out.println("[2] ver todos usuarios");
            System.out.println("[3] cadastrar crianca em usuario");
            System.out.println("[-1] sair");

            int option = Integer.parseInt(sc.nextLine());

            switch (option){
                case 0:
                    System.out.println("Digite nome de usuario");
                    String nome = sc.nextLine();
                    System.out.println("Digite email de usuario");
                    String email = sc.nextLine();
                    System.out.println("Digite senha de usuario");
                    String senha = sc.nextLine();

                    Usuario u = new Usuario(nome, email, senha);

                    manager.addUsuario(u);
                    break;

                case 1:
                    System.out.println("Digite nome de usuario");
                    String nomeR = sc.nextLine();

                    Usuario rem = manager.removerUsuario(nomeR);
                    if(rem == null){
                        System.out.println("Não existe usuário com este nome ");
                    }
                    else{
                        System.out.println("Usuario removido = " + rem.getNome());
                    }
                    break;

                case 2:
                    for(Usuario user : manager.getUsuarios().values()){
                        System.out.println(user.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome de usuário aqui: ");
                    String nomeUsuario = sc.nextLine();
                    Usuario usuarioFound = manager.getUsuario(nomeUsuario);

                    if(usuarioFound == null)
                        System.out.println("usuario não existe");

                    else{
                        String nomeCC, dataNascimento, genero, rg,cpf,nomeDoPai,NomeDaMae;
                        int idade;

                        System.out.println("Digite nome crianca");
                        nomeCC = sc.nextLine();
                        System.out.println("Digite idade crianca");
                        idade = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite data nasciment crianca");
                        dataNascimento = sc.nextLine();
                        System.out.println("Digite genero crianca");
                        genero = sc.nextLine();
                        System.out.println("Digite rg crianca");
                        rg = sc.nextLine();
                        System.out.println("Digite cpf crianca");
                        cpf = sc.nextLine();
                        System.out.println("Digite nome pai crianca");
                        nomeDoPai = sc.nextLine();
                        System.out.println("Digite nome mae crianca");
                        NomeDaMae = sc.nextLine();

                        Crianca criancaAdd = new Crianca(nomeCC, idade, dataNascimento,genero, rg,cpf,NomeDaMae,nomeDoPai);
                        usuarioFound.addCrianca(criancaAdd);
                    }
                    break;


                case -1:
                    System.out.println("saindo...");
                    manager.escreverDados();
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção invalida");
            }
        }

        sc.close();
    }
}
