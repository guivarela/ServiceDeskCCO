package br.usjt.deswebmob.servicedesk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String FILA = "br.usjt.deswebmob.servicedesk.fila";
    private EditText txtFila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFila = (EditText) findViewById(R.id.buscar_fila);
    }

    public void buscarChamados(View view) {
        String fila = txtFila.getText().toString();
        Intent intent = new Intent(this, ListarChamadosActivity.class);
        intent.putExtra(FILA, fila);
        startActivity(intent);
    }
}
