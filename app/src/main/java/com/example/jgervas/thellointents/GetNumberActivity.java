package com.example.jgervas.thellointents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetNumberActivity extends Activity {

    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_number);
    }

    public void sendNumber(View v)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        result = Integer.parseInt(editText.getText().toString());

        Intent returnIntent = new Intent();
        returnIntent.putExtra(HelloIntentsActivity.EXTRA_NUMBER, result);
        setResult(RESULT_OK,returnIntent);
        finish();

    }

    public void cancelNumber(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}
