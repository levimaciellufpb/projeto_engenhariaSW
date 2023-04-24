package ufpb.si.engenhariaSW.Application;

import ufpb.si.engenhariaSW.Controller.Manager;
import ufpb.si.engenhariaSW.Model.Crianca;

import javax.swing.*;

public class CadastrarCria {



    public static Crianca Cadastrar(){

        //tabela de cadastro
        JTextField nomeField = new JTextField(10);
        JTextField idadeField = new JTextField(3);
        JTextField dataDeNascimentoField = new JTextField(10);
        JTextField generoField = new JTextField(10);
        JTextField rgField = new JTextField(10);
        JTextField cpfField = new JTextField(10);
        JTextField nomeDaMaeField = new JTextField(10);
        JTextField nomeDoPaiField = new JTextField(10);

        // Criação do painel com os campos de entrada de texto

        JPanel formularioPanel = new JPanel();

        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS)); //Deixa um abaixo do outro

        formularioPanel.add(new JLabel("Nome:"));
        formularioPanel.add(nomeField);
        formularioPanel.add(Box.createHorizontalStrut(15)); // Espaçamento horizontal
        formularioPanel.add(new JLabel("Idade:"));
        formularioPanel.add(idadeField);
        formularioPanel.add(Box.createHorizontalStrut(15)); // Espaçamento horizontal
        formularioPanel.add(new JLabel("Data de Nascimento:"));
        formularioPanel.add(dataDeNascimentoField);
        formularioPanel.add(new JLabel("Genero:"));
        formularioPanel.add(generoField);
        formularioPanel.add(new JLabel("RG:"));
        formularioPanel.add(rgField);
        formularioPanel.add(new JLabel("CPF:"));
        formularioPanel.add(cpfField);
        formularioPanel.add(new JLabel("Nome da mãe:"));
        formularioPanel.add(nomeDaMaeField);
        formularioPanel.add(new JLabel("Nome do Pai"));
        formularioPanel.add(nomeDoPaiField);

        //Necessário para a Classe Criança


        // Exibição do formulário em uma caixa de diálogo
        int result = JOptionPane.showOptionDialog(null, formularioPanel, "Formulário De Cadastro de criança",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if(result == 2 || result == -1){
            System.out.println(result);
            throw new RuntimeException("Cadastro de criança cancelado");
        }
        if (nomeField.getText().equals(""))
            throw new RuntimeException("Campo nome não pode ser vazio!");
        String nome = nomeField.getText();

        if(idadeField.getText().equals(""))
            throw new RuntimeException("Campo idade não pode ser vazio!");
        int idade = Integer.parseInt(idadeField.getText());

        if(dataDeNascimentoField.getText().equals(""))
            throw new RuntimeException("Campo data de nascimento não pode ser vazio!");
        Double dataDeNascimento = Double.parseDouble(idadeField.getText());

        if(generoField.getText().equals(""))
            throw new RuntimeException("Campo gênero não pode ser vazio!");
        String genero = generoField.getText();

        if (rgField.getText().equals(""))
            throw new RuntimeException("Campo rg não pode ser vazio!");
        Double rg = Double.parseDouble(rgField.getText());

        if(cpfField.getText().equals(""))
            throw new RuntimeException("Campo cpf não pode ser vazio!");
        Double cpf = Double.parseDouble(cpfField.getText());

        if(nomeDaMaeField.getText().equals(""))
            throw new RuntimeException("Campo nome da mãe não pode ser vazio");
        String nomeDaMae = nomeDaMaeField.getText();

        if(nomeDoPaiField.getText().equals(""))
            throw new RuntimeException("Campo nome do pai não pode ser vazio");
        String nomeDoPai = nomeDoPaiField.getText();

        Crianca novaCria = new Crianca(nome, idade, dataDeNascimento, genero, rg, cpf, nomeDaMae, nomeDoPai);

        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null,"Cadastrou");


        } else{
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.", "Formulário De Cadastro", JOptionPane.WARNING_MESSAGE);
        } return novaCria;
    }

}






