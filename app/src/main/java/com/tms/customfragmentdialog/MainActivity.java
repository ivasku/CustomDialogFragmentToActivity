package com.tms.customfragmentdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentDialog.FragmentDialogListener {

    private TextView textViewUserName, textViewPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUserName = findViewById(R.id.textview_username);
        textViewPassword = findViewById(R.id.textview_password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


    }


    private void openDialog() {
        FragmentDialog dialog = new FragmentDialog();
        dialog.show(getSupportFragmentManager(), "Password Dialog");
    }

    @Override
    public void applyText(String username, String password) {
        textViewUserName.setText(username);
        textViewPassword.setText(password);
    }
}
