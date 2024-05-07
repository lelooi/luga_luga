package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProduto, precoProduto, descProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.nomeProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutoTv);
        precoProduto = findViewById(R.id.precoProdutoTv);
        descProduto = findViewById(R.id.g_descProduto);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(produto.getQtd());
        precoProduto.setText(produto.getPreco());
        descProduto.setText(produto.getDescricao());

    }
}