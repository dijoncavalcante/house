package com.teste.dijon.teste;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.ScatteringByteChannel;

import BO.BO_Fornecedor;
import DAO.DAO_Fornecedor;
import layout.CE.CE_Fornecedor;

/**
 * Created by dijon on 06/08/2016.
 */
public class VW_Fornecedor extends ActionBarActivity {
//    BO_Fornecedor boFornecedor = new BO_Fornecedor(getBaseContext());

    //
    Button buttonSalvar;
    EditText editTextNovoNomeFornecedor;
    EditText editTextNovoDescricaoFornecedor;
    EditText editTextNovoEnderecoFornecedor;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vw_novo_fornecedor);
        //
        //Aqui é o botão voltar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //
        buttonSalvar = (Button) findViewById(R.id.buttonSalvarNovoFornecedor);
        editTextNovoNomeFornecedor = (EditText) findViewById(R.id.editTextNovoNomeFornecedor);
        editTextNovoDescricaoFornecedor = (EditText) findViewById(R.id.editTextNovoDescricaoFornecedor);
        editTextNovoEnderecoFornecedor = (EditText) findViewById(R.id.editTextNovoEnderecoFornecedor);
        //
        buttonSalvar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            ValidarAoSalvar();
                            CE_Fornecedor ceFornecedor = new CE_Fornecedor();
                            ceFornecedor.setNome(editTextNovoNomeFornecedor.getText().toString());
                            ceFornecedor.setDescricao(editTextNovoDescricaoFornecedor.getText().toString());
                            ceFornecedor.setEndereco(editTextNovoEnderecoFornecedor.getText().toString());
                            String resultado;
                            DAO_Fornecedor daoFornecedor = new DAO_Fornecedor(getBaseContext());
                            resultado = daoFornecedor.Inserir(ceFornecedor);
                            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
                        } catch (Exception ex) {
                            Toast.makeText(VW_Fornecedor.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void ValidarAoSalvar() {
        if (editTextNovoNomeFornecedor.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Nome.");
        }
        if (editTextNovoDescricaoFornecedor.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Descrição");
        }
        if (editTextNovoEnderecoFornecedor.getText().toString().isEmpty()) {
            throw new RuntimeException("Preencha o campo Endereço.");
        }
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
