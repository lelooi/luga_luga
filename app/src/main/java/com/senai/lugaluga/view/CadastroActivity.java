package com.senai.lugaluga.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;
import com.senai.lugaluga.controller.UsuarioController;
import com.senai.lugaluga.model.Usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {

    private Spinner spinnerUf;

    private TextInputLayout inputNome , inputCpf , inputDataNasc , inputCep ,
                            inputCidade,inputLogradouro, inputNumero , inputComplemento , inputBairro,
                            inputEmail, inputSenha;
    private Button botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cadastro");
        setSupportActionBar(myToolbar);

        spinnerUf = (Spinner) findViewById(R.id.spinner_uf);
        inputNome = findViewById(R.id.input_nome);
        inputCpf = findViewById(R.id.input_cpf);
        inputDataNasc = findViewById(R.id.input_data);
        inputCep = findViewById(R.id.input_cep);
        inputCidade = findViewById(R.id.input_cidade);
        inputLogradouro = findViewById(R.id.input_logradouro);
        inputNumero = findViewById(R.id.input_numero);
        inputComplemento = findViewById(R.id.input_complemento);
        inputBairro = findViewById(R.id.input_bairro);
        inputEmail = findViewById(R.id.input_email);
        inputSenha = findViewById(R.id.input_senha);
        botao = findViewById(R.id.btn_cadastrar);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioController crud = new UsuarioController(getApplicationContext());

                Usuario usuario = new Usuario();
                usuario.setNome(inputNome.getEditText().getText().toString());
                usuario.setCpf(inputCpf.getEditText().getText().toString());
                usuario.setDataNasc(inputDataNasc.getEditText().getText().toString());
                usuario.setCep(inputCep.getEditText().getText().toString());
                usuario.setMunicipio(inputCidade.getEditText().getText().toString());
                usuario.setUf(spinnerUf.getSelectedItem().toString());
                usuario.setLogradouro(inputLogradouro.getEditText().getText().toString());
                usuario.setNumero(inputNumero.getEditText().getText().toString());
                usuario.setComplemento(inputComplemento.getEditText().getText().toString());
                usuario.setBairro(inputBairro.getEditText().getText().toString());
                usuario.setEmail(inputEmail.getEditText().getText().toString());
                usuario.setSenha(inputSenha.getEditText().getText().toString());

                String resultado;
                resultado = crud.insereDados(usuario.getNome(), usuario.getCpf(),
                        usuario.getDataNasc(), usuario.getCep(),
                        usuario.getMunicipio(), usuario.getUf(),
                        usuario.getLogradouro(), usuario.getNumero(),
                        usuario.getComplemento(), usuario.getBairro(),
                        0, usuario.getEmail(), usuario.getSenha());

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            }
        });
    inputEmail = findViewById(R.id.input_email);

    inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Pattern pattern;
            Matcher matcher;
            String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            pattern = Pattern.compile(EMAIL_PATTERN);
            CharSequence cs = (CharSequence) s;
            matcher = pattern.matcher(cs);
            if (!(matcher.matches() == true)) {
                inputEmail.setError("Invalid email");
            } else {
                inputEmail.setError("");
            }
        }
    });

    }
}
