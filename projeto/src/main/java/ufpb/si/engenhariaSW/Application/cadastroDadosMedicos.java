package ufpb.si.engenhariaSW.Application;

import javax.swing.*;
public class cadastroDadosMedicos {
    public static void cadastroDoenca(){
        JPasswordField passwordField = new JPasswordField();
        String doenca = JOptionPane.showInputDialog(null, "Digite o nome da doença: ", "Doença", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Castrado realizado.");
    }

    public static void cadastroMedicamento(){
        JPasswordField passwordField = new JPasswordField();
        String medicamento = JOptionPane.showInputDialog(null, "Digite o nome do medicamento: " , "Medicamento", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Castrado realizado.");
    }

    public static void cadastroDenticao(){
        JPasswordField passwordField = new JPasswordField();
        String dente = JOptionPane.showInputDialog(null, "Digite o nome do dente: ", "Dente", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Castrado realizado.");
    }

    public static void cadastroConsultaMedica(){
        JPasswordField passwordField = new JPasswordField();
        String consultaMedica = JOptionPane.showInputDialog(null, "Digite o nome da consulta médica: ", "Consulta Médica", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Castrado realizado.");
    }

    public static void cadastroAlergias(){
        JPasswordField passwordField = new JPasswordField();
        String alergia = JOptionPane.showInputDialog(null, "Digite o nome da alergia: ", "Alergia", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Castrado realizado.");
    }

    public static void cadastroOutros(){
        JPasswordField passwordField = new JPasswordField();
        String outros = JOptionPane.showInputDialog(null, "Digite o nome do outro cadastro: ", "Outros", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Castrado realizado.");
    }

}
