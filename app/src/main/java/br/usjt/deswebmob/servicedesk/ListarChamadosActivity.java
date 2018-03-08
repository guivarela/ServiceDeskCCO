package br.usjt.deswebmob.servicedesk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarChamadosActivity extends AppCompatActivity {
    public static final String CHAMADO = "br.usjt.deswebmob.servicedesk.chamado";
    ArrayList<String> chamados;
    ListView listView;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.FILA);
        chamados = buscarChamados(nomeFila);
        listView = findViewById(R.id.lista_chamados);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chamados);
        listView.setAdapter(arrayAdapter);
        context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 String chamado = chamados.get(i);
                 Intent intent1 = new Intent(context, DetalheChamadoActivity.class);
                 intent1.putExtra(CHAMADO, chamado);
                 startActivity(intent1);
             }
         });
    }
    private ArrayList<String> buscarChamados(String chave) {
        ArrayList<String> lista = gerarListaChamados();
        if (chave == null || chave.length() == 0) {
            return lista;
        }
        ArrayList<String> resultado = new ArrayList<>();

        for(String chamado:lista){
            if(chamado.toUpperCase().contains(chave.toUpperCase())){
                resultado.add(chamado);
            }
        }
        return resultado;
    }

    private ArrayList<String> gerarListaChamados() {
        ArrayList<String> chamados = new ArrayList<>();
        chamados.add("Desktops: Chamado1");
        chamados.add("Desktops: Computador da secretária quebrado.");
        chamados.add("Telefonia: Telefone não funciona.");
        chamados.add("Redes: Manutenção no proxy.");
        chamados.add("Servidores: Lentidão generalizada.");
        chamados.add("Novos Projetos: CRM");
        chamados.add("Manutenção Sistema ERP: atualizar versão.");
        chamados.add("Novos Projetos: Rede MPLS");
        chamados.add("Manutenção Sistema de Vendas: incluir pipeline.");
        chamados.add("Manutenção Sistema ERP: erro contábil");
        chamados.add("Novos Projetos: Gestão de Orçamento");
        chamados.add("Novos Projetos: Big Data");
        chamados.add("Manoel de Barros");
        chamados.add("Redes: Internet com lentidão");
        chamados.add("Novos Projetos: Chatbot");
        chamados.add("Desktops: troca de senha");
        chamados.add("Desktops: falha no Windows");
        chamados.add("Novos Projetos: ITIL V3");
        chamados.add("Telefonia: liberar celular");
        chamados.add("Telefonia: mover ramal");
        chamados.add("Redes: ponto com defeito");
        chamados.add("Novos Projetos: ferramenta EMM");

        return chamados;
    }
}
