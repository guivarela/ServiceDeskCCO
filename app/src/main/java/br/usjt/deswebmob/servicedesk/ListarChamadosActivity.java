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

import br.usjt.deswebmob.servicedesk.model.Chamado;
import br.usjt.deswebmob.servicedesk.model.ChamadoAdapter;
import br.usjt.deswebmob.servicedesk.model.Data;

public class ListarChamadosActivity extends AppCompatActivity {
    public static final String CHAMADO = "br.usjt.deswebmob.servicedesk.chamado";
    ArrayList<Chamado> chamados;
    ListView listView;
    Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.FILA);
        chamados = Data.buscarChamados(nomeFila);
        listView = findViewById(R.id.lista_chamados);
        ChamadoAdapter adapter = new ChamadoAdapter(this, chamados);
        listView.setAdapter(adapter);
        context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Chamado chamado = chamados.get(i);
                 Intent intent1 = new Intent(context, DetalheChamadoActivity.class);
                 intent1.putExtra(CHAMADO, chamado);
                 startActivity(intent1);
             }
         });
    }


}
