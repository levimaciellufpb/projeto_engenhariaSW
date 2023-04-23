package ufpb.si.engenhariaSW.Application;

import javax.swing.*;
public class cadastroDadosMedicos {
    public static String cadastroDoenca(){
        return JOptionPane.showInputDialog(null, "Digite o nome da doença: ", "Doença", JOptionPane.PLAIN_MESSAGE);
    }

    public static String cadastroMedicamento(){
        return JOptionPane.showInputDialog(null, "Digite o nome do medicamento: " , "Medicamento", JOptionPane.PLAIN_MESSAGE);
    }

    public static String cadastroDenticao(){
        return JOptionPane.showInputDialog(null, "Digite o nome do dente: ", "Dente", JOptionPane.PLAIN_MESSAGE);
    }

    public static String cadastroConsultaMedica(){
        return JOptionPane.showInputDialog(null, "Digite o nome da consulta médica: ", "Consulta Médica", JOptionPane.PLAIN_MESSAGE);
    }

    public static String cadastroAlergias(){
        return JOptionPane.showInputDialog(null, "Digite o nome da alergia: ", "Alergia", JOptionPane.PLAIN_MESSAGE);
    }

    public static String cadastroOutros(){
        return JOptionPane.showInputDialog(null, "Digite o nome do outro cadastro: ", "Outros", JOptionPane.PLAIN_MESSAGE);
    }

}
