package ufpb.si.engenhariaSW.Application;

import javax.swing.*;

public class Telas {

    private int escolha;
    public static void PrimeiraTela (){
        Object[] opcoes = {"Login", "Cadastrar", "Sair"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Histórico de Saúde",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

    }

    public int getEscolha() {
        return escolha;
    }

    public static void SegundaTela(){

        Object[] opcoes1 = {"Doenças", "Medicações", "Dentições", "Consultas Médicas", "Alergias", "Outros", "Sair"};
        int opcaoSelecionadaCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Panel",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes1, opcoes1[0]);
    }

}
