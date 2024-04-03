package com.projeto.servicoviajem.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.projeto.servicoviajem.util.DiasUtil;
import com.projeto.servicoviajem.util.MoedaUtil;
import com.projeto.servicoviajem.R;
import com.projeto.servicoviajem.util.ResourcesUtil;
import com.projeto.servicoviajem.model.Pacote;

import java.util.List;

public class ListaPacoteAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacoteAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        mostraLocal(viewCriada, pacote);
        //erro ao carregar imagem!!
        //mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraValor(viewCriada, pacote);
        return viewCriada;
    }

    @NonNull
    private void mostraValor(View viewCriada, Pacote pacote) {
        TextView valor = viewCriada.findViewById(R.id.item_pacote_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getValor());
        valor.setText(moedaBrasileira);
    }



    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourcesUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_cidade);
        local.setText(pacote.getLocal());
    }
}
