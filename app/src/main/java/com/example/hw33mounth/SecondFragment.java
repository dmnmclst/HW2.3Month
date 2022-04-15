package com.example.hw33mounth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondFragment extends Fragment {
    private EditText editText;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.edit_text);
        button = view.findViewById(R.id.btn_go);
        Bundle chemodan = getArguments();
        String text = chemodan.getString(MainFragment.KEY);
        editText.setText(text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle chemodan = new Bundle();
                String text = editText.getText().toString();
                chemodan.putString(MainFragment.KEY, text);
                Fragment fragment = new ThreeFragment();
                fragment.setArguments(chemodan);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main , fragment).commit();

            }
        });
    }
}