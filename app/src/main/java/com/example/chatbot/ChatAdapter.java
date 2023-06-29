package com.example.chatbot;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Chat> chatList;
    private ChatAdapterEventListener eventListener;

    public ChatAdapter(ChatAdapterEventListener eventListener) {
        this.chatList = new ArrayList<>();
        this.eventListener = eventListener;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ChatViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        final Chat chat = this.chatList.get(position);
        holder.textViewChat.setText(chat.getChat());
        Glide.with(holder.rootView.getContext()).load(chat.getImage()).into(holder.imageView);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eventListener != null) eventListener.onChatClicked(chat.getId());
            }
        });

        holder.rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (eventListener != null) {
                    eventListener.onChatLongClicked(chat.getId());
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }

        public void refreshList (List < Chat > newChatList) {
            this.chatList = newChatList;
            notifyDataSetChanged();
        }

        public class ChatViewHolder extends RecyclerView.ViewHolder{

            private View rootView;
            public TextView textViewChat;
            private TextView textViewMessage;
            private ImageView imageView;

            public ChatViewHolder(@NonNull View itemView) {
                super(itemView);

                textViewChat = itemView.findViewById(R.id.textView);
                imageView = itemView.findViewById(R.id.imageView);
                this.rootView = itemView;
            }
        }

    public interface ChatAdapterEventListener {
        void onChatClicked(int chatId);
        void onChatLongClicked(int chatId);
    }
}
