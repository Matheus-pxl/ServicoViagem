package com.projeto.servicoviajem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.projeto.servicoviajem.R;
import com.projeto.servicoviajem.dao.PacoteDAO;
import com.projeto.servicoviajem.model.Pacote;
import com.projeto.servicoviajem.ui.adapter.ListaPacoteAdapter;
import java.util.List;

public class ListaPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacote);
        setTitle("Pacotes De Viagens");
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();

        listaDePacotes.setAdapter(new ListaPacoteAdapter(pacotes,this));


    }
}