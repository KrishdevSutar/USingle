package com.usingle.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.usingle.R;
import com.usingle.chat.ChatImageMessage;
import com.usingle.chat.ChatImageUrlMessage;
import com.usingle.chat.ChatImageViewHolder;
import com.usingle.chat.ChatMessage;
import com.usingle.chat.ChatTextMessage;
import com.usingle.chat.ChatTextViewHolder;
import com.usingle.chat.ChatViewHolder;

import java.util.ArrayList;
import java.util.List;


public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private final List<ChatMessage> mMessages = new ArrayList<>();

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        switch (getMessageType(viewType)) {
            case TEXT:
                return new ChatTextViewHolder(
                        (ViewGroup) View.inflate(context, R.layout.chat_text_view, null));
            case IMAGE:
                return new ChatImageViewHolder(context,
                        (ViewGroup) View.inflate(context, R.layout.chat_image_view, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        ChatMessage message = getMessage(position);

        holder.setIsFromMe(message.isFromMe());
        if (message instanceof ChatImageMessage) {
            ((ChatImageViewHolder) holder).setDrawable(
                    ((ChatImageMessage) message).getDrawableResId());
        } else if (message instanceof ChatImageUrlMessage) {
            ((ChatImageViewHolder) holder).setImageUrl(
                    ((ChatImageUrlMessage) message).getImageUrl(),
                    ((ChatImageUrlMessage) message).getPreview());
        } else if (message instanceof ChatTextMessage) {
            ((ChatTextViewHolder) holder).setText(
                    ((ChatTextMessage) message).getText());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return getMessage(position).getType().ordinal();
    }

    @Override
    public long getItemId(int position) {
        // Chats don't change
        return getPositionInMessages(position);
    }

    @Override
    public void onViewRecycled(ChatViewHolder holder) {
        if (holder instanceof ChatImageViewHolder) {
            ((ChatImageViewHolder) holder).recycle();
        }
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public void add(ChatMessage message) {
        mMessages.add(message);
        notifyDataSetChanged();
    }

    private ChatMessage getMessage(int position) {
        return mMessages.get(getPositionInMessages(position));
    }

    private int getPositionInMessages(int position) {
        // messages are stored in reverse order
        return mMessages.size() - 1 - position;
    }

    private static ChatMessage.Type getMessageType(int viewType) {
        return ChatMessage.Type.values()[viewType];
    }
}
