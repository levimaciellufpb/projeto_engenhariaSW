package ufpb.si.engenhariaSW.Model;

public class Historico {

    private String doencas;
    private String medicacoes;
    private String denticoes;
    private String consultas;
    private String alergias;
    private String outros;

    public Historico(){
        doencas = "";
        medicacoes = "";
        denticoes = "";
        consultas = "";
        alergias = "";
        outros = "";
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getMedicacoes() {
        return medicacoes;
    }

    public void setMedicacoes(String medicacoes) {
        this.medicacoes = medicacoes;
    }

    public String getDenticoes() {
        return denticoes;
    }

    public void setDenticoes(String denticoes) {
        this.denticoes = denticoes;
    }

    public String getConsultas() {
        return consultas;
    }

    public void setConsultas(String consultas) {
        this.consultas = consultas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }
}
