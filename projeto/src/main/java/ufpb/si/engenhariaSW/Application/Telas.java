//package ufpb.si.engenhariaSW.Application;
//
//import javax.swing.*;
//
//public class Telas {
//
//    private int escolha;
//
//    public static void PrimeiraTela() {
//        Object[] opcoes = {"Login", "Cadastrar", "Sair"};
//
//        boolean sair = false;
//
//        while (!sair) {
//            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Histórico de saúde", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
//            if (opcaoSelecionada == 0) {
//                LoginECadastro.FazerLogin();
//                Telas.SegundaTela();
//            } else if (opcaoSelecionada == 1) {
//                LoginECadastro.FazerCadastro();
//            } else if (opcaoSelecionada == 2) {
//                JOptionPane.showMessageDialog(null, "Até mais!");
//                sair = true;
//            }
//        }
//
//    }
//
//    public static void SegundaTela() {
//
//        Object[] opcoes1 = {"Doenças", "Medicações", "Dentições", "Consultas Médicas", "Alergias", "Outros", "Voltar"};
//
//        boolean sair = false;
//
//        while (!sair) {
//            int opcaoSelecionadaCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Panel",
//                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes1, opcoes1[0]);
//            if (opcaoSelecionadaCadastro == 6) {
//                sair = true;
//            }
//        }
//    }
//}
//
