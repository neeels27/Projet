package com.example.projet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;






public class MainActivity extends AppCompatActivity {

    //déclaration des buttons
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bmoins, betoile, bdiv, bc, begal, bpoint;
    EditText res;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);

        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        bplus = (Button) findViewById(R.id.buttonPlus);
        bmoins = (Button) findViewById(R.id.buttonMoins);
        betoile = (Button) findViewById(R.id.buttonMultiplier);
        bdiv = (Button) findViewById(R.id.buttonDivision);
        bc = (Button) findViewById(R.id.buttonC);
        begal = (Button) findViewById(R.id.buttonEgal);
        bpoint = (Button) findViewById(R.id.buttonPoint);

        res = (EditText) findViewById(R.id.EditText01);

        // opération d'addition
        bplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        //opération Mopins
        bmoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });


        //opération multiplication
        betoile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etoileClick();
            }
        });

        // opération de division
        bdiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });


        bc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });

        begal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        bpoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });


        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

    }

    public void chiffreClick(String str) {
        if (update) {
            update = false;
        } else {
            if (!res.getText().equals("0"))
                str = res.getText() + str;
        }
        res.setText(str);


    }


    public void plusClick() {

        if (clicOperateur) {
            calcul();
            res.setText(String.valueOf(chiffre1));
        } else {
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }


    public void moinsClick() {
        if (clicOperateur) {
            calcul();
            res.setText(String.valueOf(chiffre1));
        } else {
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }


    public void etoileClick() {
        if (clicOperateur) {
            calcul();
            res.setText(String.valueOf(chiffre1));
        } else {
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }


    public void divClick() {
        if (clicOperateur) {
            calcul();
            res.setText(String.valueOf(chiffre1));
        } else {
            chiffre1 = Double.valueOf(res.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }



    public void egalClick() {
        calcul();
        update = true;
        clicOperateur = false;
    }


    public void resetClick() {
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        res.setText("");
    }


    private void calcul() {
        if (operateur.equals("+")) {
            chiffre1 = chiffre1 + Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if (operateur.equals("-")) {
            chiffre1 = chiffre1 - Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if (operateur.equals("*")) {
            chiffre1 = chiffre1 * Double.valueOf(res.getText().toString()).doubleValue();
            res.setText(String.valueOf(chiffre1));
        }

        if (operateur.equals("/")) {
            try {
                chiffre1 = chiffre1 / Double.valueOf(res.getText().toString()).doubleValue();
                res.setText(String.valueOf(chiffre1));
            } catch (ArithmeticException e) {
                res.setText("0");
            }
        }
    }
}