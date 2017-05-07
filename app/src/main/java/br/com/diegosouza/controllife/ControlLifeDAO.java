package br.com.diegosouza.controllife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ControlLifeDAO {

    private static SQLiteDatabase db;
    private static CriaBanco banco;

    public ControlLifeDAO(Context context) {
        banco = new CriaBanco(context);
    }

    public static String salvarMedicamento(Medicamento medicamento) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(banco.DESCRICAO, medicamento.getDescricao());
        valores.put(banco.OBSERVACAO, medicamento.getObservacao());
        valores.put(banco.PERIODICIDADE, medicamento.getPeridicidade());
        valores.put(banco.HORARIO, medicamento.getHorario());

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao asalvar medicamento.";
        else
            return "Medicameto salvo com sucesso.";

    }

    public List<Medicamento> getAllItens() {
        db = banco.getWritableDatabase();
        String selectQuery = "SELECT * FROM medicamento";
        Cursor cursor = db.rawQuery(selectQuery, null);

        List<Medicamento> itens = new ArrayList<>();

        try {
            if (cursor.moveToFirst()) {
                do {

                    Medicamento medicamento = new Medicamento();
                    medicamento.setDescricao(cursor.getString(cursor.getColumnIndex(banco.DESCRICAO)));
                    medicamento.setObservacao(cursor.getString(cursor.getColumnIndex(banco.OBSERVACAO)));
                    medicamento.setPeridicidade(cursor.getString(cursor.getColumnIndex(banco.PERIODICIDADE)));
                    medicamento.setHorario(cursor.getString(cursor.getColumnIndex(banco.HORARIO)));

                    // Adding contact to list
                    itens.add(medicamento);
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException e) {
            Log.d("SQL Error", e.getMessage());
            return null;
        } finally {
            cursor.close();
            db.close();
        }
        return itens;
    }

   /* public Cursor buscarItemPorId(int id) {
        db = banco.getWritableDatabase();

        Cursor cursor;
        String[] campos = {
                banco.ID,
                banco.NOME,
                banco.DESCRICAO,
                banco.OBSERVACAO,
                banco.HORARIO,

                banco.QUANTIDADE,
                banco.VALOR_TOTAL,

                banco.NOME_METADE_2,
                banco.DESCRICAO_METADE_2,
                banco.OBSERVACAO_METADE_2,
                banco.REF_IMG_METADE_2,
                banco.VALOR_UNIT_METADE_2,
        };


        String where = CriaBanco.ID + "=" + id;
        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public static void updateItem(String id, ItemPedido item) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + " = " + id;

        valores = new ContentValues();
        valores.put(CriaBanco.QUANTIDADE, item.getQuantidade());
        valores.put(CriaBanco.HORARIO, item.getValor_unit());
        valores.put(CriaBanco.VALOR_TOTAL, item.getValor_total());

        Log.println(Log.ERROR, "ITEM:", "" + valores.getAsString(CriaBanco.QUANTIDADE));

        db.update(CriaBanco.TABELA, valores, where, null);
        db.close();
    }

    public static void atualizarItens(List<ItemPedido> itens_pedido) {
        db = banco.getWritableDatabase();
        String selectQuery = "SELECT * FROM itemPedido";
        Cursor cursor = db.rawQuery(selectQuery, null);
        String codigo;

        for (int i = 0; i < itens_pedido.size(); i++) {
            cursor.moveToPosition(i);
            codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));

            Log.println(Log.ERROR, "ID: ", codigo);
            updateItem(codigo, itens_pedido.get(i));
        }
    }

    public void deletarItem(int position, List<ItemPedido> itens) {
        db = banco.getWritableDatabase();
        String selectQuery = "SELECT * FROM itemPedido";
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToPosition(position);
        String codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));

        Log.println(Log.ERROR, "ID: ", codigo);

        String where = CriaBanco.ID + " = " + codigo;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA, where, null);
        db.close();
    }*/

}
