package br.com.diegosouza.controllife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadMedicacaoActivity extends AppCompatActivity {

    EditText descricao, periodicidade, horarios, observacao;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_medicacao);

        descricao = (EditText) findViewById(R.id.descricao);
        periodicidade = (EditText) findViewById(R.id.periodicidade);
        horarios = (EditText) findViewById(R.id.horarios);
        observacao = (EditText) findViewById(R.id.observacao);

        salvar = (Button) findViewById(R.id.salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Medicamento medicamento = new Medicamento();
                medicamento.setDescricao(descricao.getText().toString());
                medicamento.setDescricao(periodicidade.getText().toString());
                medicamento.setDescricao(horarios.getText().toString());
                medicamento.setDescricao(observacao.getText().toString());

                String resultado = ControlLifeDAO.salvarMedicamento(medicamento);

                Toast.makeText(CadMedicacaoActivity.this, resultado, Toast.LENGTH_LONG);
            }
        });

    }

}
