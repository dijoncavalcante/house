package DAO;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import DATABASE.CriaBanco;
import layout.CE.CE_Fornecedor;

/**
 * Created by dijon on 07/08/2016.
 */
public class DAO_Fornecedor {
    private SQLiteDatabase db;
    private CriaBanco banco;

    //
    public DAO_Fornecedor(Context context) {
        banco = new CriaBanco(context);
    }

    public DAO_Fornecedor() {

    }

    public String Inserir(CE_Fornecedor objeto) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, objeto.getNome());
        valores.put(CriaBanco.DESCRICAO, objeto.getDescricao());
        valores.put(CriaBanco.ENDERECO, objeto.getEndereco());
        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro.";
        else
            return "Registro Inserido com sucesso.";
        /*StringBuilder str = new StringBuilder();
        str.append("insert into tb_fornecedor");
        str.append("(id, nome, descricao, endereco)");
        str.append("values(1, 'DB', 'DISTRIBUIDORA DB DISTRITO','DISTRITO INDUSTRIAL' )");*/
    }

    public Cursor CarregarDados() {
        Cursor cursor;
        String[] campos = { banco.NOME};//banco.ID,
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public List<CE_Fornecedor> Obter(CE_Fornecedor objeto) {
        StringBuilder str = new StringBuilder();
        str.append("select * from tb_fornecedor");
        List<CE_Fornecedor> lista = new ArrayList<CE_Fornecedor>();
        return lista;
    }


    public void Alterar(CE_Fornecedor objeto) {
        StringBuilder str = new StringBuilder();
        str.append("update tb_fornecedor set valores");
        str.append("where id = " + objeto.getId());
    }

    public void Excluir(CE_Fornecedor objeto) {
        StringBuilder str = new StringBuilder();
        str.append("Delete   from   tv_fornecedor");
        str.append("where id = " + objeto.getId());
    }

    public Long ObterSequence() {
        StringBuilder str = new StringBuilder();
        str.append("select sequenceFornecedor.nextval fom dual");
        return Long.parseLong("1");
    }
/*10/08/2016  -  saq dep - cod 01 ag 10420523 ms -1237,49   0,00*/

}
