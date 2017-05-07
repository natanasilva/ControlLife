package br.com.diegosouza.controllife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btnAcessar);
        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView tLogin = (TextView) findViewById(R.id.edtUsuario);
                TextView tSenha = (TextView) findViewById(R.id.edtSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                if (login.equals("diego") && senha.equals("0303")) {
                    alert("Login realizado com sucesso");
                    Intent it = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(it);
                } else {
                    alert("Login ou senha incorreto ");
                }
            }
        });
    }
    public void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
