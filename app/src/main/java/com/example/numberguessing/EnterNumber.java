package com.example.numberguessing;

import static com.example.numberguessing.R.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EnterNumber extends AppCompatActivity {
    int result;
    int turn=10;
    ImageView imageView4;
    Dialog dialog;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random() * (max - min)) + min);
    }
    public void makeToast(String str)
    {
        Toast.makeText(EnterNumber.this,str, Toast.LENGTH_SHORT).show();
    }
    public void clickFunction(View view)
    {

        AlertDialog.Builder alert = new AlertDialog.Builder(EnterNumber.this);
        dialog=new Dialog(this);
        int userGuessing;
        EditText variable = (EditText)findViewById(id.editTextText);
        userGuessing = Integer.parseInt(variable.getText().toString());
        if(turn>1)
        {
            turn=turn-1;
            if((userGuessing>0)&&(userGuessing<101))
            {
                if (userGuessing < result) {
                    openHigherThink();
                }
                else if (userGuessing > result) {
                    openLowerThink();
                }
                else {
                    openWinDialogue();
                }
                Toast.makeText(getApplicationContext(), "Turns remaining :"+turn
                        , Toast.LENGTH_SHORT).show();

            }
            else
            {
                openInvalidIP();
            }
        }
        else {
            openLooseLayout();
        }
    }

    private void openLooseLayout() {
        dialog.setContentView(layout.loss_layout);
        ImageView dialogueImage=dialog.findViewById(R.id.dialogueImage);
        TextView invalidip=dialog.findViewById(id.Hint);
        Button tryagain=dialog.findViewById(id.tryagain);
        Button exit=dialog.findViewById(id.exit);
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),EnterNumber.class);
                startActivity(i);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        dialog.show();
    }

    private void openInvalidIP() {
        dialog.setContentView(layout.invalid_ip);
        ImageView dialogueImage=dialog.findViewById(R.id.dialogueImage);
        TextView invalidip=dialog.findViewById(id.Hint);
        Button invalid=dialog.findViewById(id.okButt);
        invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void openHigherThink() {
        dialog.setContentView(layout.higher_think);
        ImageView dialogueImage=dialog.findViewById(R.id.dialogueImage);
        TextView highertxt=dialog.findViewById(id.hightxt);
        Button ok=dialog.findViewById(id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void openLowerThink() {
        dialog.setContentView(layout.lower_think);
        ImageView dialogueImage=dialog.findViewById(R.id.dialogueImage);
        TextView lowtxt=dialog.findViewById(id.lowtxt);
        Button ok=dialog.findViewById(id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void openWinDialogue() {
        dialog.setContentView(layout.win_layout);
        ImageView dialogueImage=dialog.findViewById(R.id.dialogueImage);
        TextView winner=dialog.findViewById(R.id.winner);
        Button playagain=dialog.findViewById(R.id.playagain);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),StartPage.class);
                startActivity(i);
            }
        });
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_enter_number);
        imageView4=findViewById(id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        Toast.makeText(getApplicationContext(), "Turns remaining :"+turn
                , Toast.LENGTH_SHORT).show();
        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
    }


}
