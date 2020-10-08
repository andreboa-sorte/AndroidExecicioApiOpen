package com.example.openapiexecicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = (TextView) findViewById(R.id.editTextTextPersonName);

        Button botaoNext = (Button) findViewById(R.id.button);
        botaoNext.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick (View v) {

                String nomeValue = nome.getText().toString();

                Intent intent = new Intent( MainActivity.this, RetornaIdade.class );

                intent.putExtra("nome", nomeValue);
                startActivity(intent);
                finish();
            }
        });

    }
}