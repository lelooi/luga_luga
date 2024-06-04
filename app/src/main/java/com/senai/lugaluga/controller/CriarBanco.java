package com.senai.lugaluga.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CriarBanco extends SQLiteOpenHelper {


    private static final String NOME_BANCO = "banco.db";
    public static final String NOME_TABELA = "usuario";
    private static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String CPF = "cpf";
    public static final String DATA_NASC = "dataNasc";
    public static final String CEP = "cep";
    public static final String MUNICIPIO = "municipio";
    public static final String UF = "uf";
    public static final String LOGRADOURO = "logradouro";
    public static final String NUMERO = "numero";
    public static final String COMPLEMENTO = "complemento";
    public static final String BAIRRO = "bairro";
    public static final String TELEFONE = "telefone";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    public static final Integer VERSAO = 1;

    public CriarBanco(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + NOME_TABELA + " ( " +
           ID + " INTEGER PRYMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " +
                CPF + " TEXT, " +
                DATA_NASC + " TEXT, " +
                CEP + " TEXT, " +
                MUNICIPIO + " TEXT, " +
                UF + " TEXT, " +
                LOGRADOURO + " TEXT, " +
                NUMERO + " TEXT, " +
                BAIRRO + " TEXT, " +
                TELEFONE + " TEXT, " +
                EMAIL + " TEXT, " +
                SENHA + " TEXT ";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
