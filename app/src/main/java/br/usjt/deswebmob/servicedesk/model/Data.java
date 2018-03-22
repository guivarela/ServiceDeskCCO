package br.usjt.deswebmob.servicedesk.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by arqdsis on 21/03/2018.
 */

public class Data {


    public static ArrayList<Chamado> buscarChamados(String chave) {
        ArrayList<Chamado> lista = gerarListalista();
        if (chave == null || chave.length() == 0) {
            return lista;
        }
        ArrayList<Chamado> resultado = new ArrayList<>();

        for(Chamado chamado:lista){
            if(chamado.getFila().getNome().toUpperCase().contains(chave.toUpperCase())){
                resultado.add(chamado);
            }
        }
        return resultado;
    }
    public static ArrayList<Chamado> gerarListalista() {
        ArrayList<Chamado> lista = new ArrayList<>();

        Chamado chamado = new Chamado();
        chamado.setNumero(1);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("Computador da secretária quebrado.");
        Fila fila = new Fila();
        fila.setId(FilaId.DESKTOPS.id());
        fila.setNome(FilaId.DESKTOPS.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(2);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("Telefone não funciona.");
        fila = new Fila();
        fila.setId(FilaId.TELEFONIA.id());
        fila.setNome(FilaId.TELEFONIA.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(3);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("troca de senha.");
        fila = new Fila();
        fila.setId(FilaId.DESKTOPS.id());
        fila.setNome(FilaId.DESKTOPS.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(4);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("Ajuste na maquina principal.");
        fila = new Fila();
        fila.setId(FilaId.CRMVENDAS.id());
        fila.setNome(FilaId.CRMVENDAS.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(5);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("Troca de cabos");
        fila = new Fila();
        fila.setId(FilaId.SERVIDORES.id());
        fila.setNome(FilaId.SERVIDORES.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(6);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("criacao de um novo projeto");
        fila = new Fila();
        fila.setId(FilaId.PROJETO.id());
        fila.setNome(FilaId.PROJETO.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(7);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("fechamento do projeto");
        fila = new Fila();
        fila.setId(FilaId.PROJETO.id());
        fila.setNome(FilaId.PROJETO.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(8);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("Troca de cabos de redes");
        fila = new Fila();
        fila.setId(FilaId.REDES.id());
        fila.setNome(FilaId.REDES.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(9);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(chamado.ABERTO);
        chamado.setDescricao("erro contábil");
        fila = new Fila();
        fila.setId(FilaId.ERP.id());
        fila.setNome(FilaId.ERP.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        return lista;
    }
}
