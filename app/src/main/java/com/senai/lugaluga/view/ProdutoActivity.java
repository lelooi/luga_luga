package com.senai.lugaluga.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;

    private Button btnAlugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.nomeProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutoTv);
        precoProduto = findViewById(R.id.precoProdutoTv);
        descProduto = findViewById(R.id.g_descProduto);

        btnAlugar = findViewById(R.id.alugaBtn);

        produto = getIntent().getExtras().getParcelable("produto");

        if (produto.getStatus().equals("Indisponível")){
            btnAlugar.setEnabled(false);
            btnAlugar.setText("Indisponível");
        }

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(String.valueOf(produto.getQtd()));
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());

        btnAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Confirma alugar o produto ?");

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}