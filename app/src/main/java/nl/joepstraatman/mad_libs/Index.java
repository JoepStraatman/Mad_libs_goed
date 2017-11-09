package nl.joepstraatman.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static android.R.attr.type;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }
    public void simple(View v){
            Intent intent = new Intent(this, storyInput.class);
            intent.putExtra("text","madlib0_simple.txt");
            startActivity(intent);
            finish();
    }
    public void tarzan(View v){
        Intent intent = new Intent(this, storyInput.class);
        intent.putExtra("text","madlib1_tarzan.txt");
        startActivity(intent);
        finish();
    }
    public void university(View v){
        Intent intent = new Intent(this, storyInput.class);
        intent.putExtra("text","madlib2_university.txt");
        startActivity(intent);
        finish();
    }
    public void clothes(View v){
        Intent intent = new Intent(this, storyInput.class);
        intent.putExtra("text","madlib3_clothes.txt");
        startActivity(intent);
        finish();
    }
    public void dance(View v){
        Intent intent = new Intent(this, storyInput.class);
        intent.putExtra("text","madlib4_dance.txt");
        startActivity(intent);
        finish();
    }
    public void random(View v){
        Random rand = new Random();
        int  n = rand.nextInt(5) + 1;
        if (n == 1){
            Intent intent = new Intent(this, storyInput.class);
            intent.putExtra("text","madlib0_simple.txt");
            startActivity(intent);
            finish();
        }
        else if (n == 2){
            Intent intent = new Intent(this, storyInput.class);
            intent.putExtra("text","madlib1_tarzan.txt");
            startActivity(intent);
            finish();
        }
        else if (n==3){
            Intent intent = new Intent(this, storyInput.class);
            intent.putExtra("text","madlib2_university.txt");
            startActivity(intent);
            finish();
        }
        else if (n == 4){
            Intent intent = new Intent(this, storyInput.class);
            intent.putExtra("text","madlib3_clothes.txt");
            startActivity(intent);
            finish();
        }
        else if (n == 5){
            Intent intent = new Intent(this, storyInput.class);
            intent.putExtra("text","madlib4_dance.txt");
            startActivity(intent);
            finish();
        }
    }
}
