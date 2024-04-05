package com.projeto.servicoviajem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.projeto.servicoviajem.R;
import com.projeto.servicoviajem.model.Pacote;
import com.projeto.servicoviajem.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento");

        Pacote pacoteSaoPaulo = new Pacote("São Paulo","sao_paulo_sp",5,new BigDecimal ("255,55"));

        TextView preco = findViewById(R.id.pagamento_valor);
        MoedaUtil.formataParaBrasileiro(pacoteSaoPaulo.getValor());

    }
}