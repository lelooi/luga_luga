package com.senai.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<AdapterProduto.ViewHolder> {

    private List<Produto> produtoList;

    public AdapterProduto(List<Produto> produtoList) {  d
        this.produtoList = produtoList;
    }

    @NonNull
    @Override
    public AdapterProduto.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listaProdutos = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduto.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nomeProd, precoProd, descProd;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProd = itemView.findViewById(R.id.tv_nomeProduto);
            precoProd = itemView.findViewById(R.id.tv_Preco);
            descProd = itemView.findViewById(R.id.tv_Descricao);

        }
    }
}
