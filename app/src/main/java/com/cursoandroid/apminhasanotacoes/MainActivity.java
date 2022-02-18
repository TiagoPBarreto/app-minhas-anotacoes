package com.cursoandroid.apminhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cursoandroid.apminhasanotacoes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());


        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar se foi escrito algo pelo usuario
                String textoRecuperado = editAnotacao.getText().toString();
                if (textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG)
                            .show();
                } else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG)
                            .show();

                }

            }
        });

            //recuperar anotação
        String anotacao = preferencias.recuperarAnotacao();
            preferencias.recuperarAnotacao();
            if (!anotacao.equals("")){
                editAnotacao.setText( anotacao);
            }
    }

}