package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddChatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, AddChatActivity.class);
        intent.putExtra("Key1", 100);
        intent.putExtra("Key2", "Uma String Qualquer");
        context.startActivity(intent);
    }

    private EditText editTextName;
    private EditText editTextMessage;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        this.editTextName = findViewById(R.id.editTextName);
        this.editTextMessage = findViewById(R.id.editTextMessage);
        this.addButton = findViewById(R.id.button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String message = editTextMessage.getText().toString();

                Chat newChat = new Chat(0, name, message);

                AppDatabase.getInstance(AddChatActivity.this).getChatDao().insert(newChat);
                finish();
            }
        });
    }
}