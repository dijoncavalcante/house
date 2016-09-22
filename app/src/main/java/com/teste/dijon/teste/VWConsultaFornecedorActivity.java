package com.teste.dijon.teste;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import DAO.DAO_Fornecedor;
import DATABASE.CriaBanco;

public class VWConsultaFornecedorActivity extends ActionBarActivity {

    private ListView lista;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vw_consulta_fornecedor);
        //
        //Aqui é o botão voltar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //
        DAO_Fornecedor daoFornecedor = new DAO_Fornecedor(getBaseContext());
        Cursor cursor = daoFornecedor.CarregarDados();

//        ArrayList<ArrayList> mArrayList = new ArrayList<ArrayList>();
//        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
//            // The Cursor is now set to the right position
//            mArrayList.add(cursor.getString(dbAdapter));
//        }

        String[] nomeCampos = new String[]{ CriaBanco.NOME};//CriaBanco.ID,
        int[] idViews = new int[]{ R.id.nomeFornecedor};//R.id.idFornecedor,
//        SimpleAdapter adapter =
//                new SimpleAdapter(
//                        VWConsultaFornecedorActivity.this
//                        , mArrayList
//                        ,  R.id.listaViewFornecedores
//                        , nomeCampos
//                        , idViews
//                );
        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(
                        getBaseContext()
                        , R.layout.activity_vw_consulta_fornecedor
                        , cursor
                        , nomeCampos
                        , idViews
                        , 0
                );
//        lista = (ListView) findViewById(R.id.listaViewFornecedores);
//        lista.setAdapter(adapter);
     //   setListAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //tratando o clivk em um dos itens
        switch (item.getItemId())
        {
            case R.id.home://botao de voltar
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_settings://botao de configuração
                final AlertDialog alertDialo = new AlertDialog.Builder(this).create();
                alertDialo.setTitle("Atenção!");
                alertDialo.setMessage("action_settings");
                alertDialo.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
