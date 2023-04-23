package ufpb.si.engenhariaSW.Application;
import ufpb.si.engenhariaSW.Model.Usuario;
import javax.swing.*;


public class LoginECadastro extends Telas{





    public static Usuario FazerCadastro(){

        //Method not fool-proof

        JPasswordField passwordField = new JPasswordField();

        JPanel formularioPanel = new JPanel();
        JTextField nomeField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JPasswordField senhaField = new JPasswordField(10);
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS)); //Deixa um abaixo do outro

        formularioPanel.add(new JLabel("Nome:"));
        formularioPanel.add(nomeField);
        formularioPanel.add(new JLabel("Email:"));
        formularioPanel.add(emailField);
        formularioPanel.add(new JLabel("Senha:"));
        formularioPanel.add(senhaField);


        int result = JOptionPane.showOptionDialog(null, formularioPanel, "TELA DE CADASTRO",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        String nomeCad = nomeField.getText();
        String emailCad = emailField.getText();
        char[] password = senhaField.getPassword();
        String senhaCad = new String(password.clone());
        Usuario u = new Usuario(nomeCad,emailCad,senhaCad);

        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null,"Cadastrou");
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.", "Formulário De Cadastro", JOptionPane.WARNING_MESSAGE);
        }
        return u;

    }

    public static String FazerLogin(){
        JPasswordField passwordField = new JPasswordField();

        JPanel formularioPanel = new JPanel();
        JTextField emailField = new JTextField(10);
        JPasswordField senhaField = new JPasswordField(10);
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS)); //Deixa um abaixo do outro

        formularioPanel.add(new JLabel("Email:"));
        formularioPanel.add(emailField);

        formularioPanel.add(new JLabel("Senha:"));
        formularioPanel.add(senhaField);

        int result = JOptionPane.showOptionDialog(null, formularioPanel, "TELA DE LOGIN",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
            String emailLogin = emailField.getText();
            char[] password = senhaField.getPassword();
            String senhaLogin = new String(password.clone());
            return emailLogin + "#" + senhaLogin;


        } else {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.", "Formulário De Cadastro", JOptionPane.WARNING_MESSAGE);

        }
        //Retornar null caso o cadastro seja cancelado
        return null;


//        String emailLogin = JOptionPane.showInputDialog(null, "Digite seu endereço de e-mail:", "E-mail", JOptionPane.PLAIN_MESSAGE);
//
//        int senhaLog = JOptionPane.showConfirmDialog(null, passwordField, "Digite sua senha:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//        char[] senhaCharArray = passwordField.getPassword();
//        String senhaLogin = new String(senhaCharArray);
//
//        return emailLogin + "#" + senhaLogin;

    }

}
