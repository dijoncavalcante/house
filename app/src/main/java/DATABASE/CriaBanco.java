package DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dijon on 07/08/2016.
 */
public class CriaBanco extends SQLiteOpenHelper {
    //
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "tb_fornecedor";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String DESCRICAO = "descricao";
    public static final String ENDERECO = "endereco";
    private static final int VERSAO = 1;

    //
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    //
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*é chamado quando a aplicação cria o banco de dados pela primeira vez. Nesse método devem
        * ter todas as diretrizes de criaçãoepopulação inicial do banco.
        * Permite que o desenvolvedor escreva COMANDOS SQL em seu código e posteriormente chama um método
        * que executará esse comando no banco, ou seja, o comando de criação da tabela deve ser escrito no código*/
        String sql = "CREATE TABLE " + TABELA + "("
                + ID + " integer primary key autoincrement, "
                + NOME + " text, "
                + DESCRICAO + " text, "
                + ENDERECO + " text "
                + " )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*tem um comando sql que apaga a tabela, se ela existir, e
        * posteriormente invoca o método onCreate(), para que recrie
        * a tabela com as alterações feitas.*/
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
