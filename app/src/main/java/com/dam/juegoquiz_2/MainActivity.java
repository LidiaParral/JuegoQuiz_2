package com.dam.juegoquiz_2;


import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView countLabel, questionLabel;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData [][] = {
            {"¿Dónde tirarías esta lata de coca-cola?","Contenedor amarillo","Contenedor verde","Contenedor gris", "Contenedor azul"},
            {"¿Dónde tirarías este envase de zumo?","Contenedor amarillo","Contenedor verde","Contenedor gris", "Contenedor azul"},
            {"¿En qué contenedor tiraría esta botella de plástico?","Contenedor amarillo","Contenedor verde","Contenedor gris", "Contenedor azul"},
            {"¿Dónde tiraría esta botella de vidrio?","Contenedor verde","Contenedor amarillo","Contenedor gris", "Contenedor azul"},
            {"Los tapones de plástico se tiran en el contenedor azul...","Falso","Verdadero","No lo sé", "Los tapones de plástico no se reciclan"},
            {"¿En que contenedor irían estos restos de comida?","Contenedor gris","Contenedor verde","Contenedor amarillo", "Contenedor azul"},
            {"¿Dónde van estos botes de pintura?","Punto limpio","Contenedor amarillo","Contenedor gris", "Contenedor azul"},
            {"Cuando el bolígrafo se queda sin tinta, ¿dónde se tiraría?","Punto limpio","Contenedor verde","Contenedor gris", "Contenedor azul"},
            {"¿Cuál de estos colores no pertenece a un contenedor de reciclaje?","Rosa","Rojo","Gris", "Azul"},
            {"¿Sabes para qué se utiliza el contenedor rojo?","Desechos peligrosos, como baterías e insecticidas","Residuos de vidrio","Residuos de papel y cartón", "Residuos orgánicos"},
            {"¿Sabes cuánto tarda, de media, en degradarse una botella de plástico?","700 años","20 años","100 años", "350 años"},
            {"¿De qué color es el contenedor destinado al reciclaje del papel y el cartón?","Azul","Amarillo","Gris", "Verde"},
            {"Las baterías, los teléfonos móviles, ordenadores y otros electrodomésticos o aparatos electrónicos,¿Sabes dónde debes depositarlos cuando ya no son útiles?","Punto limpio","Contenedor amarillo","Contenedor gris", "Contenedor verde"},
            {"¿Sabes cuál de estos objetos no deben tirarse en el contenedor verde?","Bombilla","Caja de cartón","Vaso de cristal", "Botella de vino"},
            {"¿Qué son los puntos limpios?","Es una instalación para almacenar residuos peligrosos o muy voluminosos","Es una instalación dónde se puede hacer deporte","Es una instalación para reciclar residuos peligrosos", "Es una instalación destinada a los residuos orgánicos"},
            {"¿Cuál es la función de los puntos limpios?","Separar los residuos de forma adecuada","Mezclar todos los residuos","Separar sólo algunos de los residuos,como el plástico,el vidrio...", "No tienen ninguna función"},
            {"¿Las botellas de plástico de leche son reciclables?","Si, pero antes se debe quitar las etiquetas y enjuagarlas","No son reciclables","No lo sé", "No, porque han estado en con la leche"},
            {"¿Se pueden reciclar los tubos de pasta de dientes?","No, sólo los que estén marcados con el símbolo de aluminio reciclable","No","No lo sé", "Si"},
            {"Por cada tonelada de papel reciclado, estamos salvando _______ árboles.","17 árboles","5 árboles","9 árboles", "35 árboles"},
            {"Cada botella de plástico de 500ml que se recicla ahorra energía como para hacer ______ tostadas.","10","3","Ninguna", "1"},
            {"¿Qué cree que contamina más el ambiente?","Las grandes ciudades","Los aviones","Las fábricas", "Los coches"},
            {"Después de revisar el botiquín de casa,¿dónde se reciclan los medicamentos?","Hay que depositarlos en contenedores especiales, en las farmacias..","Al contenedor gris porque no se reciclan","Se tiran al contenedor amarillo", "Hay que depositarlos en el punto limpio"},
            {"El contenedor azul está destinado al papel pero, ¿dónde reciclarías una servilleta manchada?","En el contenedor de residuos orgánicos","En el contenedor amarillo","Obvio,en el contenedor azul", "En el contenedor verde"},
            {"¿Se puede reciclar el aceite usado de cocina?","Si, hay que transportarlo en bidones al punto limpio","No","Se tira en el fregadero", "El aceite usado se tira al campo porque es biodegradable"},
            {"El reciclaje forma parte de la conocida como regla de las '3R'. ¿Cuáles son?","Reducir, reutilizar y reciclar","Rebajar, reutilizar y reciclar","Reducir, reponer y reciclar", "Reducir, reutilizar y respetar"},
            {"¿En qué contenedor depositarías las pilas?","En el punto limpio, puntos de recogidas en las calles y en algunas tiendas","¿Pilas? Ni idea","No se reciclan", "Al contenedor gris"},
            {"Señala cuál de las siguientes afirmaciones es correcta:","Las bombillas van a los puntos limpios","Los CDs van al contenedor gris","Los papeles plastificados van al contenedor azul", "Los vidrios se depositan en el contenedor amarillos"},
            {"Además de los envases de plástico, ¿qué más productos deben reciclarse en el contenedor amarillo?","Los envases metálicos y los bricks","Sólo los envases metálicos","Sólo los bricks", "Ninguno de los anteriores"},
            {"¿Dónde depositarías un termómetro?","El termómetro debe reciclarse en un punto limpio","El termómetro debe reciclarse en las farmacias, al igual que los medicamentos","El termómetro debe reciclarse en el contenedor gris", "El termómetro no se recicla"},
            {"¿Dónde tirarías un vaso de cristal?","Punto limpio","Contenedor amarillo","Contenedor verde", "Contenedor gris"},
            {"¿Dónde se depositan los periódicos?","Contenedor azul","Contenedor amarillo","Contenedor verde", "Punto limpio"},
            {"Si el contenedor verde estuviese lleno,¿Dónde tirarías el tarro de cristal?","Contenedor gris","Contenedor amarillo","Contenedor azul", "En el suelo, al lado del contenedor verde"},
            {"¿Qué no se debe tirar en el contenedor gris?","Residuos muy luminosos ni escombros","Restos de comida","Trapos viejos", "Ropa rota y vieja"},
            {"¿Cuándo es el día mundial del reciclaje?","El 17 de Mayo","No hay un día específico para eso","El 17 de Marzo", "El 5 de Mayo"},
            {"Las tarrinas de yogurt (incluidas las tapas) deberán depositarse en...","Contenedor amarillo","Contenedor verde","Contenedor azul", "Contenedor gris"},
            {"Según los datos de Ecoembes,en España hay un contenedor...","cada 162 habitantes","cada 75 habitantes","cada 8 habitantes", "cada 253 habitantes"},
            {"Estás preparando un batido de fresas y de repente… ¡se te rompe un vaso! ¿Qué debes hacer con él?","La respuesta anteriores son válidas","Los vasos de cristal hay que depositarlo en un contenedor gris","Depositarlo en un punto limpio", "Quizás tirarlo en el contenedor amarillo"},
            {"A la hora del recreo, al salir de excursión, cuando terminamos el sándwich o bocadillo ¿qué hacemos con el papel film?","Guardar los restos y tras juntarlos llevarlos al punto limpio","Tirarlo en cualquier contenedor","No se puede reciclar", "Siempre al contenedor amarillo"}


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.questionLabel);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);



        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Country
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("Pregunta nº" + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            // Correct
            alertTitle = "¡Correcto!";
            rightAnswerCount++;

        } else {
            // Incorrect
            alertTitle = "¡Oh, Incorrecto!";
        }

        // Create AlertDialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Respuesta correcta : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    // Show Result.
                    Intent intent = new Intent(getApplicationContext(), Result.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

}