package com.example.task32_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    Button validBtn;
    TextView answerText;
    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.inputText);
        validBtn = findViewById(R.id.validBtn);
        answerText = findViewById(R.id.answerText);
        validBtn.setOnClickListener(v -> {
            //if (!input.isEmpty()) {
            input = inputText.getText().toString().trim();
            answerText.setText("" + isValid(input));
            Log.e("input", input);
            // }
        });
    }

    public boolean isValid(String input) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('<', '>');
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Stack stack = new Stack();

        for (char c : input.toCharArray()) {
            Log.e("-----", String.valueOf(c));
            if (map.containsKey(c)) {
                stack.push(c);
                Log.e("+++++", String.valueOf(stack.top));
            } else if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        Log.e("====", String.valueOf(stack.top));
        return stack.isEmpty();
    }
}
