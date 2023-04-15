package ufpb.si.engenhariaSW.Application;
import javax.swing.*;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        JPasswordField passwordField = new JPasswordField();

        Object[] opcoes = {"Login", "Cadastrar", "Sair"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Meu JOptionPane",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
        switch(opcaoSelecionada) {
            case 0:
                String emailLogin = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);
                int senhaLogin = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null,"Login feito com sucesso!");
                Object[] opcoes1 = {"Doenças", "Medicações", "Dentições", "Consultas Médicas", "Alergias", "Outros", "Sair"};
                int opcaoSelecionadaCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Panel",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes1, opcoes1[0]);
                break;
            case 1:
                String nomeCad = JOptionPane.showInputDialog(null, "Digite seu nome: ", "Nome", JOptionPane.PLAIN_MESSAGE);
                String emailCad = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);
                int senhaCad = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null,"Usuário cadastrado");

                break;
            case 2:
                System.out.println("Sair selecionado.");
                break;
            default:
                System.out.println("Opção inválida selecionada.");
                break;
        }


    }

}

