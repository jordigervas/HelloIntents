package com.example.jgervas.thellointents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class HelloIntentsActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.jgervas.thellointents.MESSAGE";

    final static String EXTRA_NUMBER = "com.example.jgervas.thellointents.NUMBER";
    static final int REQUEST_CODE1 = 1; // The request code
    static final int REQUEST_CODE2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_intents);
    }

    public void clickInput(View v)
    {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = getResources().getString(R.string.message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }


    public void clickOutput(View v)
    {
        Intent intent = new Intent(this, GetNumberActivity.class);
        startActivityForResult(intent, REQUEST_CODE1);

    }

    public void clickOutput2(View v)
    {
        Intent intent = new Intent(this, GetNumberActivity.class);
        startActivityForResult(intent, REQUEST_CODE2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            int myNumber = data.getIntExtra(EXTRA_NUMBER,0);
            switch (requestCode)
            {
                case  REQUEST_CODE1:
                    Toast.makeText(getBaseContext(), "RQ1: " + myNumber, Toast.LENGTH_SHORT ).show();
                    break;
                case REQUEST_CODE2:
                    Toast.makeText(getBaseContext(), "RQ2: " + myNumber, Toast.LENGTH_SHORT ).show();
                    break;
            }

        }
        else
            Toast.makeText(getBaseContext(), getResources().getString(R.string.cancel), Toast.LENGTH_SHORT ).show();

    }

    public void clickPhone(View v)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" +  getResources().getString(R.string.phoneNumber)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void clickAudio(View v)
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        Intent.createChooser(intent, getResources().getString(R.string.select));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
