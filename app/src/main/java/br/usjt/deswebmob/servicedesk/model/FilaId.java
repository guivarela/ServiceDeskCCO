package br.usjt.deswebmob.servicedesk.model;

/**
 * Created by arqdsis on 21/03/2018.
 */

public enum FilaId {
    PROJETO(1, "Novos Projetos"),
    CRMVENDAS(2, "Manuntenção do Sistema de vendas."),
    ERP(3, "Manuntenção do Sistema ERP"),
    SERVIDORES(4, "Servidores"),
    REDES(5, "Redes"),
    TELEFONIA(6, "Telefonia"),
    DESKTOPS(7, "Desktops");

    private final int id;
    private final String nome;

    FilaId(int n, String s){
        id = n;
        nome = s;
    }

    public int id(){
        return id;
    }

    public String nome(){
        return nome;
    }
}
