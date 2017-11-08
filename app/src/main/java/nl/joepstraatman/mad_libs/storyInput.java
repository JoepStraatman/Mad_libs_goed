package nl.joepstraatman.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static java.util.logging.Logger.global;

public class storyInput extends AppCompatActivity {
    public Story stor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_input);


        if (savedInstanceState != null) {
            stor = (Story) savedInstanceState.getSerializable("stor");
            // check mObjectA == mObjectA.getObjectBList().get(0).getParent();

        } else {
            Intent intent = getIntent();
            String text = intent.getStringExtra("text");
            InputStream is = null;
            try {
                is = getAssets().open(text);

            } catch (IOException e) {
                e.printStackTrace();
            }

            stor = new Story(is);
        }
        EditText test = (EditText) findViewById(R.id.placeholder);
        test.setHint(stor.getNextPlaceholder());
        TextView left = (TextView) findViewById(R.id.wordLeft);
        left.setText(stor.getPlaceholderRemainingCount() + " word(s) left");
        TextView type = (TextView) findViewById(R.id.type);
        type.setText("Please fill in a " + stor.getNextPlaceholder());

    }

    public void doThings(View view){
        EditText placeholder = (EditText) findViewById(R.id.placeholder);
        if (!placeholder.getText().toString().isEmpty()) {
            stor.fillInPlaceholder(placeholder.getText().toString());
            if (stor.isFilledIn() == true) {
                Intent intent = new Intent(this, Text.class);
                intent.putExtra("story", stor.toString());
                stor.clear();
                startActivity(intent);
                finish();
            } else {
                EditText test = (EditText) findViewById(R.id.placeholder);
                test.setText("");
                test.setHint(stor.getNextPlaceholder());
                TextView left = (TextView) findViewById(R.id.wordLeft);
                left.setText(stor.getPlaceholderRemainingCount() + " word(s) left");
                TextView type = (TextView) findViewById(R.id.type);
                type.setText("Please fill in a " + stor.getNextPlaceholder());
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("stor", stor);
    }

}
