package com.tms.customfragmentdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class FragmentDialog extends AppCompatDialogFragment {

    private EditText editTextUserName, editTextPassword;

    private  FragmentDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog, null);

        editTextUserName = view.findViewById(R.id.editUsername);
        editTextPassword = view.findViewById(R.id.editPassword);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userName = editTextUserName.getText().toString();
                        String password = editTextPassword.getText().toString();
                        listener.applyText(userName, password);
                    }
                });


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (FragmentDialogListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface FragmentDialogListener {
        public void applyText(String username, String password);
    }
}
