package ufpb.si.engenhariaSW.Application;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JPasswordField passwordField = new JPasswordField();

        Object[] opcoes = {"Login", "Cadastrar", "Sair"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Histórico de Saúde",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        switch(opcaoSelecionada) {
            case 0:
                LoginECadastro.FazerLogin();
                break;

            case 1:
                LoginECadastro.FazerCadastro();
                // ***** Após o cadastro deve ser possível voltar ao menu inicial ****
                break;
            case 2:
                System.out.println("Sair selecionado.");
                break;
            default:
                System.out.println("Opção inválida selecionada.");
                break;
        }

    }



        /**
         * Opções da segunda tela:
         * Object[] opcoes1 = {"Doenças", "Medicações", "Dentições", "Consultas Médicas", "Alergias", "Outros", "Sair"};
         *                 int opcaoSelecionadaCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Panel",
         *                         JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes1, opcoes1[0]);
         */


}



