package com.example.juanro.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.graphics.Color;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Integer [] status = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
    Integer pointer = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yourBtn = (Button)findViewById(R.id.block1);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block2);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block3);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block4);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block5);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block6);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block7);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block8);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block9);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block10);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block11);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block12);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block13);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block14);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.block15);
        yourBtn.setOnClickListener(this);
        yourBtn = (Button)findViewById(R.id.space);
        yourBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        String text_inButton;
        text_inButton = (String) ( (TextView) v).getText();
        if (text_inButton.equals("_")) System.out.println("Space pressed");
        else {
            int number = Integer.parseInt(text_inButton);
            if (validMove(number)) {
                ( (TextView) v).setText("_");
                System.out.println("Block " + number + " pressed");
                Button yourBtn = (Button) findViewById(R.id.space);
                yourBtn.setText(text_inButton);
                yourBtn.setId(((Button) v).getId());
                Integer indexofZ = Arrays.asList(status).indexOf(0);
                Integer indexofN = Arrays.asList(status).indexOf(number);
                status[indexofN] = 0;
                pointer = indexofN;
                status[indexofZ] = number;
                ( (Button) v).setId(R.id.space);
                ((Button) v ).setTextColor(Color.parseColor("#ff0000"));
                System.out.println(Arrays.toString(status));
            } else {
                System.out.println("Not valid move");
            }
        }

    }

    public boolean validMove(int input) {
        int indexofN = Arrays.asList(status).indexOf(input);
        System.out.println(input);
        switch (indexofN) {
            case 15:
                return status[14] == 0 || status[11] == 0;
            case 0:
                return status[1] == 0 || status[4] == 0;
            case 3:
                return status[2] == 0 || status[7] == 0;
            case 12:
                return status[13] == 0 || status[8] == 0;
            case 4:
                return status[0] == 0 || status[5] == 0 || status[8] == 0;
            case 8:
                return status[4] == 0 || status[9] == 0 || status[12] == 0;
            case 7:
                return status[3] == 0 || status[6] == 0 || status[11] == 0;
            case 11:
                return status[7] == 0 || status[10] == 0 || status[15] == 0;
            case 1:
                return status[0] == 0 || status[5] == 0 || status[2] == 0;
            case 2:
                return status[1] == 0 || status[6] == 0 || status[3] == 0;
            case 13:
                return status[12] == 0 || status[9] == 0 || status[14] == 0;
            case 14:
                return status[13] == 0 || status[10] == 0 || status[15] == 0;
        }
        return status[indexofN-1]==0 || status[indexofN+1]==0 || status[indexofN-4]==0 || status[indexofN+4]==0;
    }

}
