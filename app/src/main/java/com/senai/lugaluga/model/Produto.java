package com.senai.lugaluga.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Produto implements Parcelable {

    private String nome;
    private String descricao;
    private Double preco;
    private Integer qtd;
    private String status;

    public Produto(String nome, String descricao, Double preco, Integer qtd, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
        this.status = status;
    }

    protected Produto(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        if (in.readByte() == 0) {
            preco = null;
        } else {
            preco = in.readDouble();
        }
        if (in.readByte() == 0) {
            qtd = null;
        } else {
            qtd = in.readInt();
        }
        status = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(descricao);
        if (preco == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(preco);
        }
        if (qtd == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(qtd);
        }
        parcel.writeString(status);
    }

}
