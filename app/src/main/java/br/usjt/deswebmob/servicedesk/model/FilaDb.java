package br.usjt.deswebmob.servicedeskcco.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import static br.usjt.deswebmob.servicedeskcco.model.FilaDbContract.FilaBanco;
/**
 * Created by Guilheme Varela on 11/04/2018.
 */

public class FilaDb {
    private FilaDbHelper dbHelper;

    public FilaDb(Context context) {
        dbHelper = new FilaDbHelper(context);
    }

    public void inserirFila(ArrayList<Fila> filas){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (Fila fila:filas){
            values.put(FilaBanco.ID_FILA, fila.getId());
            values.put(FilaBanco.NM_FILA, fila.getNome());
            values.put(FilaBanco.NM_FIGURA, fila.getFigura());

            db.insert(FilaBanco.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Fila> listaFilas(){
        ArrayList<Fila> filas = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] colunas = {FilaBanco.ID_FILA, FilaBanco.NM_FILA, FilaBanco.NM_FIGURA};

        String orderBy = FilaBanco.ID_FILA;

        Cursor cursor;
        cursor = db.query(FilaBanco.TABLE_NAME, colunas, null, null, null, null, orderBy);

        while(cursor.moveToNext()){
            Fila fila = new Fila();
            fila.setId(cursor.getInt(cursor.getColumnIndex(FilaBanco.ID_FILA)));
            fila.setNome(cursor.getString(cursor.getColumnIndex(FilaBanco.NM_FILA)));
            fila.setFigura(cursor.getString(cursor.getColumnIndex(FilaBanco.NM_FIGURA)));
            filas.add(fila);
        }
        cursor.close();
        db.close();
        return filas;
    }
}
