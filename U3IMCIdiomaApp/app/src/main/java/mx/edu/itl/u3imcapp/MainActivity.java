/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                 Activity que Despliega el Menú de la app de IMC
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Emiliano Cepeda Villarreal 20130792
:*  Fecha       : 09/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripción : Esta app despliega en pantalla el menú de la app que calcula el IMC.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main_activity );
    }
    public void btnIMCClick ( View v ){
        EditText peso = findViewById( R.id.txtPeso );
        EditText altura = findViewById( R.id.txtAltura );

        String Peso = peso.getText().toString();
        String Altura = altura.getText().toString();

        double peso1 = Double.parseDouble(Peso);
        double altura1 = Double.parseDouble(Altura);
        double IMC = peso1 / ( altura1 * altura1 );

        String salud = "";
        if ( IMC < 15 )
            salud = getString( R.string.delgadez_muy_severa );
        if ( IMC >= 15 && IMC <= 15.9 )
            salud = getString( R.string.delgadez_severa );
        if ( IMC >= 16 && IMC <= 18.4 )
            salud = getString( R.string.delgadez );
        if ( IMC >= 18.5 && IMC <= 24.9 )
            salud = getString( R.string.peso_saludable );
        if ( IMC >= 25 && IMC <= 29.9 )
            salud = getString( R.string.sobrepeso );
        if ( IMC >= 30 && IMC <= 34.9 )
            salud = getString( R.string.obesidad_moderada );
        if ( IMC >= 35 && IMC <= 39.9 )
            salud = getString( R.string.obesidad_severa );
        if ( IMC >= 40 )
            salud = getString( R.string.obesidad_morbida );


        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( getString( R.string.alert_title ) )
                .setIcon( R.drawable.itl )
                .setMessage( getString( R.string.imc_es )+ " " + IMC + getString( R.string.salud_es ) + " " + salud )
                .setPositiveButton ( getString( R.string.aceptar ), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                    }
                })
                .create().show();
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent( this, AcercaDeActivity.class);
        startActivity( intent );
        finish();
    }
}