package com.example.openapiexecicio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class RetornaIdade extends AppCompatActivity {
    private TextView nome;
    private TextView idade;
    private String nomeEnvia;

    private ProgressDialog load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorna_idade);
        DownloadPessoa download = new DownloadPessoa();
        nome = (TextView) findViewById(R.id.textView5);
        idade = (TextView) findViewById(R.id.textView7);
        nomeEnvia = (String) getIntent().getExtras().get("nome");

                //Chama Async Task
                download.execute();
            }

            private class DownloadPessoa extends AsyncTask<Void, Void, com.example.openapiexecicio.Pessoa> {

                @Override
                protected void onPreExecute() {

                    //inicia o dialog
                    load = ProgressDialog.show(RetornaIdade.this,
                            "Aguarde ...", "Obtendo Informações...");
                }

                @Override
                protected com.example.openapiexecicio.Pessoa doInBackground(Void... params) {
                    com.example.openapiexecicio.Conversor util = new com.example.openapiexecicio.Conversor();
                    return util.getInformacao("https://api.agify.io/?name=" + nomeEnvia);
                }
                @Override
                protected void onPostExecute(com.example.openapiexecicio.Pessoa pessoa){
                    //System.out.println(pessoa);
                    nome.setText(nomeEnvia);
                    idade.setText(pessoa.getIdade());

                    load.dismiss(); //deleta o dialog
                }

            }
}
