package com.teste.dijon.teste;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
//import  android

import java.text.MessageFormat;

import BO.BO_Produto;
import layout.CE.CE_Fornecedor;
import layout.CE.CE_Produto;

public class vwNovoProduto extends ActionBarActivity {

    BO_Produto boProduto = new BO_Produto();
    //
    EditText editTexNome;
    EditText editTexPreco;
    EditText editTexDescricao;
    EditText editTexTamanho;
    EditText editTexOndeComprou;
    ToggleButton toggleButtonAtivo;
    Spinner spinnerTipoProduto;
    Button buttonSalvar;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vw_novo_produto);
        //Aqui é o botão voltar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //
        //Recuperando os ids dos botoes e editText's
        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        editTexNome = (EditText) findViewById(R.id.editTextNomeProduto);
        editTexPreco = (EditText) findViewById(R.id.editTextValorProduto);
        editTexDescricao = (EditText) findViewById(R.id.editTextDescricaoProduto);
        editTexTamanho = (EditText) findViewById(R.id.editTextTamanhoProduto);
        editTexOndeComprou = (EditText) findViewById(R.id.editTextVendedor);
        toggleButtonAtivo = (ToggleButton) findViewById(R.id.toggleButtonAtivo);
        spinnerTipoProduto = (Spinner) findViewById(R.id.spinnerTipoProduto);
        //criando um ArrayAdapter usando uma string de array e um layout spinner padrao
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerTipoProduto, R.layout.support_simple_spinner_dropdown_item);
        //Especifica o layout para usar quando a lista do appears escolhido
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //Aplica o adapter ao spinner
        spinnerTipoProduto.setAdapter(adapter);
        //Evento de click do botao  e editText's

        // spinnerTipoProduto.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        buttonSalvar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try
                        {
                            ValidarAoSalvar();
                            CE_Produto ceProduto = new CE_Produto();
                            ceProduto.setNome(editTexNome.getText().toString());
                            ceProduto.setPreco(Double.parseDouble(editTexPreco.getText().toString()));
                            ceProduto.setDescricao(editTexDescricao.getText().toString());
                            ceProduto.setTamanho(editTexTamanho.getText().toString());
                            CE_Fornecedor Fornecedor = new CE_Fornecedor();
                            Fornecedor.setNome(editTexOndeComprou.getText().toString());
                            ceProduto.setFornecedor(Fornecedor);
                            //ceProduto.setAtivo(Boolean.parseBoolean(toggleButtonAtivo.getText().toString()));
                            ceProduto.setAtivo(toggleButtonAtivo.getText().toString().equals("Ativo") ? Boolean.TRUE : Boolean.FALSE);
                            ceProduto.setTipo(spinnerTipoProduto.getSelectedItem().toString());
//                        MensagemDeAlerta();
                            boProduto.Inserir(ceProduto);
                        }
                        catch (Exception ex)
                        {
                            Toast.makeText(vwNovoProduto.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }


    private void ValidarAoSalvar()
    {
        if (editTexNome.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Nome.");
        }
        if (editTexPreco.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Preço.");
        }
        if (editTexDescricao.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Descrição.");
        }
        if (editTexTamanho.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Tamanho.");
        }
        if (editTexOndeComprou.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Fornecedor.");
        }
        if (Boolean.parseBoolean(toggleButtonAtivo.getTextOn().toString()) == true) {
            throw new RuntimeException("Preencha o campo Ativo.");
        }
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
        //infla is itens de ação  para utilizar na ActionBar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_produto, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //tratando o click em um dos itens
        switch (item.getItemId())
        {
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_drawer:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Atenção!");
                alertDialog.setMessage("action_drawer");
                alertDialog.show();
                return  true    ;
            case R.id.action_settings:
                final AlertDialog alertDialo = new AlertDialog.Builder(this).create();
                alertDialo.setTitle("Atenção!");
                alertDialo.setMessage("action_settings");
                alertDialo.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
//                return super.startActivity(vwNovoProduto.this, MainActivity.class);
        }

    }

    public void onBackPressed()
    {
        Intent intent = new Intent(vwNovoProduto.this, MainActivity.class);
        startActivity(intent);
    }
}
/*
public class  SpinnerActivity extends Activity implements OnItemSelectedListener
{
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        //An item was selected. You can retrieve the selected item using parent .getItemAtPosition(pos)
    }
    public void onNothingSelected(AdapterView<?> parent)
    {
        //Another interface callback
    }
}
*/