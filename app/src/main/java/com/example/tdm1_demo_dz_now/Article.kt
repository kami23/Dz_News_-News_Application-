package com.example.tdm1_demo_dz_now

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_article.*

class Article : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        //to change title of activity val actionBar = supportActionBar
        textView_title.text="Hong Kong paralysé par les manifestants"
        textView_body.text="Lorem Ipsum est un générateur de faux textes aléatoires " +
                "Vous choisissez le nombre de paragraphes," +
                "de mots ou de listes. Vous obtenez alors un texte aléatoire " +
                "que vous pourrez ensuite utiliser librement dans vos maquettes Le texte généré est du pseudo lati et peut donner l'impression d'être du vrai texte Faux-Texte est une réalisation du studio de création de sites internet indépendant \n" +
                "Prélude Prod Vous choisissez le nombre de paragraphes," +
        "de mots ou de listes. Vous obtenez alors un texte aléatoire " +
                "que vous pourrez ensuite utiliser librement dans vos maquettes Le texte généré est du pseudo lati et peut donner l'impression d'être du vrai texte Faux-Texte est une réalisation du studio de création de sites internet indépendant \n" +
                "Prélude Prod "
    }
}
