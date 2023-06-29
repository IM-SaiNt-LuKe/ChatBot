package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ChatTalkActivity extends AppCompatActivity {

    private static final String KEY_CHAT_ID = "chatId";

    public static void startActivity(Context context, int chatId) {
        Intent intent = new Intent(context, ChatTalkActivity.class);
        intent.putExtra(ChatTalkActivity.KEY_CHAT_ID, chatId);
        context.startActivity(intent);
    }

    private Chat chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_talk);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            int chatId = bundle.getInt(KEY_CHAT_ID, -1);

            AppDatabase db = AppDatabase.getInstance(this);
            ChatDao dao = db.getChatDao();
            this.chat = dao.getById(chatId);

            ImageView imageView = findViewById(R.id.imageView);
            TextView textViewChat = findViewById(R.id.textView);

            // Glide.with(this).load(chat.getImage()).into(imageView);
            // textViewChat.setText(chat.getChat());
        } else {
            finish();
        }
    }
}