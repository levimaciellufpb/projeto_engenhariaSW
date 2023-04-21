package ufpb.si.engenhariaSW.Application;

import ufpb.si.engenhariaSW.Controller.Manager;
import ufpb.si.engenhariaSW.Exceptions.UsuarioException;
import ufpb.si.engenhariaSW.Model.Historico;
import ufpb.si.engenhariaSW.Model.Usuario;

import javax.swing.*;

public class Telas {
    protected static Manager manager = new Manager();
    private int escolha;

    public static void PrimeiraTela() {
        Object[] opcoes = {"Login", "Cadastrar", "Sair"};

        boolean sair = false;

        while (!sair) {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Histórico de saúde", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            if (opcaoSelecionada == 0) {
                LoginECadastro.FazerLogin();
                Telas.SegundaTela();
            }

            else if (opcaoSelecionada == 1) {
                Usuario novoUsuario = LoginECadastro.FazerCadastro();

                try{
                    manager.addUsuario(novoUsuario);
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");

                }
                catch (UsuarioException u){
                    JOptionPane.showMessageDialog(null, "Não foi possível adicionar usuário, pois já existe um usuário com mesmo nome");
                }
            }

            else if (opcaoSelecionada == 2) {
                JOptionPane.showMessageDialog(null, "Até mais!");
                sair = true;
            }
        }
        javax.swing.JDesktopPane jDesktopPane1;

    }

    public static void SegundaTela() {


        Object[] opcoes1 = {"Lista do Histórico", "Cadastar novo arquivo", "Voltar"};
        Object[] opcoes2 = {"Doenças", "Medicações", "Dentições", "Consultas Médicas", "Alergias", "Outros", "Voltar"};

        boolean sair = false;

        while (!sair) {
            int opcaoSelecionadaCadastro = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Painel",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes1, opcoes1[0]);
            if (opcaoSelecionadaCadastro == 0) {
                int opcaoSelecionadaCadastro1 = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Painel",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes2, opcoes2[0]);
                Historico his = new Historico();
                if (opcaoSelecionadaCadastro1 == 0) {
                    JOptionPane.showMessageDialog(null, "Doenças: " + his.getDoencas());
                }
                else if (opcaoSelecionadaCadastro1 == 1) {
                    JOptionPane.showMessageDialog(null, "Medicamentos: " + his.getDoencas());
                }
                else if (opcaoSelecionadaCadastro1 == 2) {
                    JOptionPane.showMessageDialog(null, "Dentições: " + his.getDoencas());
                }
                else if (opcaoSelecionadaCadastro1 == 3) {
                    JOptionPane.showMessageDialog(null, "Consultas Médicas" + his.getDoencas());
                }
                else if (opcaoSelecionadaCadastro1 == 4) {
                    JOptionPane.showMessageDialog(null, "Alergias" + his.getDoencas());
                }
                else if (opcaoSelecionadaCadastro1 == 5) {
                    JOptionPane.showMessageDialog(null, "Outros" + his.getDoencas());
                }

            } else if (opcaoSelecionadaCadastro == 1){
                int opcaoSelecionadaCadastro2 = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Painel",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes2, opcoes2[0]);
                if (opcaoSelecionadaCadastro2 == 0) {
                    cadastroDadosMedicos.cadastroDoenca();
                } else if (opcaoSelecionadaCadastro2 == 1) {
                    cadastroDadosMedicos.cadastroMedicamento();
                } else if (opcaoSelecionadaCadastro2 == 2) {
                    cadastroDadosMedicos.cadastroDenticao();
                } else if (opcaoSelecionadaCadastro2 == 3) {
                    cadastroDadosMedicos.cadastroConsultaMedica();
                } else if (opcaoSelecionadaCadastro2 == 4) {
                    cadastroDadosMedicos.cadastroAlergias();
                } else if (opcaoSelecionadaCadastro2 == 5) {
                    cadastroDadosMedicos.cadastroOutros();
                }

            } else {
                sair = true;
            }
        }
    }
}

