package com.teste.dijon.teste;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ManterFornecedorActivity extends ActionBarActivity {

    Button buttonNovo;
    Button buttonConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_fornecedor);
        //
        buttonNovo = (Button) findViewById(R.id.button_novo_fornecedor);
        buttonConsultar = (Button) findViewById(R.id.button_consultar_fornecedor);
        //
        //Aqui é o botão voltar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //
        buttonNovo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ManterFornecedorActivity.this, VW_Fornecedor.class);
                        startActivity(intent);
                    }
                }
        );
        //
        buttonConsultar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ManterFornecedorActivity.this, VWConsultaFornecedorActivity.class);
                        startActivity(intent);
                    }
                }
        );
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
