package ufpb.si.engenhariaSW.Application;

import javax.swing.*;


public class LoginECadastro {




    public static void FazerCadastro(){
        JPasswordField passwordField = new JPasswordField();
        String nomeCad = JOptionPane.showInputDialog(null, "Digite seu nome: ", "Nome", JOptionPane.PLAIN_MESSAGE);
        String emailCad = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);
        int senhaCad = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Cadastro feito com sucesso!");



    }

    public static void FazerLogin(){
        JPasswordField passwordField = new JPasswordField();
        String emailLogin = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);
        int senhaLogin = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Login feito com sucesso!");
    }



}
