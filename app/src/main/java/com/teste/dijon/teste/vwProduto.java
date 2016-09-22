package com.teste.dijon.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class vwProduto extends ActionBarActivity {

    Button buttonNovo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vw_produto);

        //recuperando os ids do botoes
        buttonNovo = (Button) findViewById(R.id.novo);

        //Evento de click do botao
        buttonNovo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(vwProduto.this   , vwNovoProduto.class);
            startActivity(intent);
        }
});
    }

}
