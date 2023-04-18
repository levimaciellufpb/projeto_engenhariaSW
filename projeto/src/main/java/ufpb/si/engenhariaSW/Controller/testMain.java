package ufpb.si.engenhariaSW.Controller;

import ufpb.si.engenhariaSW.Model.Usuario;

import java.util.Scanner;

public class testMain {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        Manager manager = new Manager();

        while(continuar){
            System.out.println("Isso é um sistema de testes!");
            System.out.println("[0] cadastrar usuario");
            System.out.println("[1] remover usuario");
            System.out.println("[2] ver todos usuarios");
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

                    Usuario u = new Usuario("", "", "");

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
