package ufpb.si.engenhariaSW.Application;
import ufpb.si.engenhariaSW.Model.Usuario;
import javax.swing.*;


public class LoginECadastro extends Telas{





    public static void FazerCadastro(){

        //Method not fool-proof

        JPasswordField passwordField = new JPasswordField();


        String nomeCad = JOptionPane.showInputDialog(null, "Digite seu nome: ", "Nome", JOptionPane.PLAIN_MESSAGE);


        String emailCad = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);

        int senhaCad = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] senhaCharArray = passwordField.getPassword();
        String senhaCadastro = new String(senhaCharArray);

        Usuario novoUsuario = new Usuario(nomeCad,emailCad,senhaCadastro);
    }

    public static void FazerLogin(){
        JPasswordField passwordField = new JPasswordField();

        String emailLogin = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);

        int senhaLog = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        char[] senhaCharArray = passwordField.getPassword();
        String senhaLogin = new String(senhaCharArray);

        JOptionPane.showMessageDialog(null,"Login feito com sucesso!");
    }

    private void cadastrar(Usuario usuario){
        super.manager.addUsuario(usuario);
    }



}
