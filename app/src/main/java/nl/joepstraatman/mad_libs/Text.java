package nl.joepstraatman.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.widget.TextView;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent = getIntent();
        String text = intent.getStringExtra("story");
        TextView story = (TextView) findViewById(R.id.text);
        story.setText(text);
        story.setMovementMethod(new ScrollingMovementMethod());


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // do something
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
