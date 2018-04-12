package br.usjt.deswebmob.servicedeskcco.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.deswebmob.servicedeskcco.model.FilaDbContract.FilaBanco;
/**
 * Created by Guilherme Varela on 11/04/2018.
 */

public class FilaDbHelper extends SQLiteOpenHelper{
    public static final String SQL_CREATE_FILA =
            "CREATE TABLE " + FilaBanco.TABLE_NAME + "( " +
            FilaBanco._ID + " INTEGER PRIMARY KEY, " +
            FilaBanco.ID_FILA + " INTEGER, " +
            FilaBanco.NM_FILA + " TEXT, " +
            FilaBanco.NM_FIGURA + " TEXT, " +
            FilaBanco.IMG_FIGURA + "BLOB)";

    public static final String SQL_DROP_FILA =
            "DROP TABLE IF EXISTS " + FilaBanco.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Fila.db";

    public FilaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FILA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_FILA);
        db.execSQL(SQL_CREATE_FILA);
    }
}
