package ufpb.si.engenhariaSW.Application;
import ufpb.si.engenhariaSW.Model.Usuario;
import javax.swing.*;


public class LoginECadastro extends Telas{





    public static Usuario FazerCadastro(){

        //Method not fool-proof

        JPasswordField passwordField = new JPasswordField();


        String nomeCad = JOptionPane.showInputDialog(null, "Digite seu nome: ", "Nome", JOptionPane.PLAIN_MESSAGE);


        String emailCad = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);

        int senhaCad = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] senhaCharArray = passwordField.getPassword();
        String senhaCadastro = new String(senhaCharArray);

        return new Usuario(nomeCad,emailCad,senhaCadastro);
    }

    public static String FazerLogin(){
        JPasswordField passwordField = new JPasswordField();

        String emailLogin = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);

        int senhaLog = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] senhaCharArray = passwordField.getPassword();
        String senhaLogin = new String(senhaCharArray);

        return emailLogin + "#" + senhaLogin;

    }

}
