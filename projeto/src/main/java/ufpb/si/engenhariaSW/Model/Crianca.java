package ufpb.si.engenhariaSW.Model;

import java.util.Objects;

public class Crianca {
    private String nome;
    private int idade;
    private Double dataNascimento;
    private String genero;
    private Double rg;
    private Double cpf;
    private String nomeDoPai;
    private String nomeDaMae;
    private Historico historico = new Historico();

    public Crianca(String nome, int idade, Double dataNascimento, String genero, Double rg, Double cpf,String nomeDaMae, String nomeDoPai){
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.rg = rg;
        this.cpf = cpf;
        this.nomeDaMae = nomeDaMae;
        this.nomeDoPai = nomeDoPai;
    }

    public Historico getHistorico() {
        return historico;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + "\n" +
                "Idade: " + idade  + " Anos\n" +
                "Gênero: " + genero + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "RG: " + rg + "\n" +
                "CPF: " + cpf + "\n" +
                "Nome da Mãe: " + nomeDaMae + "\n" +
                "Nome do Pai: " + nomeDoPai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Double getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Double dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getRg() {
        return rg;
    }

    public void setRg(Double rg) {
        this.rg = rg;
    }

    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crianca crianca = (Crianca) o;
        return Objects.equals(nome, crianca.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
