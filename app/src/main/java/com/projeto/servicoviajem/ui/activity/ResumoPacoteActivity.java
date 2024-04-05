package com.projeto.servicoviajem.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projeto.servicoviajem.R;
import com.projeto.servicoviajem.model.Pacote;
import com.projeto.servicoviajem.util.DataUtil;
import com.projeto.servicoviajem.util.DiasUtil;
import com.projeto.servicoviajem.util.MoedaUtil;
import com.projeto.servicoviajem.util.ResourcesUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResumoPacoteActivity extends AppCompatActivity{

    public static final String TITULO_APPBAR = "Detalhes da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APPBAR);
        Pacote pacoteSaoPaulo = new Pacote("são paulo", "sao_paulo_sp", 5, new BigDecimal("255.55"));

        mostraLocal(pacoteSaoPaulo);
        mostraDias(pacoteSaoPaulo);
        mostraValor(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraValor(Pacote pacote) {
        TextView valor = findViewById(R.id.resumo_pacote_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getValor());
        valor.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_cidade);
        local.setText(pacote.getLocal());
    }

}
