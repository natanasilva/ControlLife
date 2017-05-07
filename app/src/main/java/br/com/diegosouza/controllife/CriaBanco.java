package br.com.diegosouza.controllife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "controllife.db";

    public static final String TABELA = "medicamento";
    public static final String ID_MEDICAMENTO = "_id";
    public static final String DESCRICAO = "descricao";
    public static final String PERIODICIDADE = "peroidicidade";
    public static final String HORARIO = "horario";
    public static final String OBSERVACAO = "observacao";


    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID_MEDICAMENTO + " integer primary key autoincrement,"
                + DESCRICAO + " text, "
                + PERIODICIDADE + " text, "
                + HORARIO + " text, "
                + OBSERVACAO + " text, "

                +")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(sqLiteDatabase);
    }

}
