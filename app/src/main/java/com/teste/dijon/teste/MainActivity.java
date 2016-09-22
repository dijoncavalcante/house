package com.teste.dijon.teste;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button buttonManterProduto;
    Button buttonManterFornecedor;
    Button buttonEstoque;
    Button buttonLista;
    Button buttonRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando os ids dos botoes
        buttonManterProduto = (Button) findViewById(R.id.manter_produto);
        buttonManterFornecedor = (Button) findViewById(R.id.buttonManterFornecedor);
        buttonEstoque = (Button) findViewById(R.id.estoque);
        buttonLista = (Button) findViewById(R.id.listaDeCompras);
        buttonRelatorio =(Button) findViewById(R.id.relatorio);

        //Evento de click do botao
        buttonManterProduto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       //Intent intent = new Intent(MainActivity.this,vwProduto.class);
                        Intent intent = new Intent(MainActivity.this, vwNovoProduto.class);
                        startActivity(intent);
                    }
                }
        );

        buttonManterFornecedor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, ManterFornecedorActivity.class);
                        startActivity(intent);
                    }
                }
        );

        buttonEstoque.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        MensagemDeAlerta();
                    }
                }
        );

        buttonLista.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        MensagemDeAlerta();
                    }
                }
        );

        buttonRelatorio.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        MensagemDeAlerta();
                    }
                }
        );
    }

    public void MensagemDeAlerta() {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Atenção!");
        alertDialog.setMessage("Em construção");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int which) {
                //add funcções
            }
        });
        //alertDialog.setIcon(R.drawable.abc_ab_bottom_solid_dark_holo);
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
