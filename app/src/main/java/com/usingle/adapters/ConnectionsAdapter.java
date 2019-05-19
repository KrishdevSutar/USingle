/**
 * Class: ContactsAdapter
 * Author: Robert Ciborowski
 * Date: 29/05/2018
 * Description: An adapter that handles the searching of the RecyclerView that shows all contacts.
 */

package com.usingle.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.usingle.R;
import com.usingle.models.DataBase;
import com.usingle.models.RelationshipProvider;
import com.usingle.option_providers.TemporaryConnectionsProvider;
import com.usingle.util.ContextBoundMethod;

public class ConnectionsAdapter extends RecyclerView.Adapter<ConnectionsAdapter.ViewHolder> {
    // This is the method that should be run when a contact is selected by the user.
    private ContextBoundMethod contextBoundMethod;

    // This is the only constructor.
    public ConnectionsAdapter(ContextBoundMethod contextBoundMethod) {
        this.contextBoundMethod = contextBoundMethod;
    }

    // Represents a view for each item in the RecyclerView.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // These are the views which are used to display the contact.
        private CardView cardView;
        private ImageView imageView;
        private TextView textView;

        // This is the contact's position.
        int position;

        // This stores a reference to the list of contacts.
        String stats;

        // This is the only constructor.
        public ViewHolder(View view, String stats) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.connections_list_card_view);
            imageView = (ImageView) cardView.findViewById(R.id.connections_image);
            textView = (TextView) cardView.findViewById(R.id.connections_text);
            this.stats = stats;

            // This sets up an onclick listener for the checkbox.
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something
                }
            });
        }

        // This is run when the contact is supposed to show up on screen.
        void bind(int position) {
            this.setPosition(position);
        }

        // The following are getters and setters.
        public void setPosition(int position) {
            this.position = position;
        }

        public CardView getCardView() {
            return cardView;
        }
    }

    // This creates new views (and is invoked by the layout manager).
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.connections_list_item, parent, false);
        return new ViewHolder(itemView, "");
    }

    // This replaces the contents of a view (and is invoked by the layout manager).
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.getCardView();

        // The following sets up views accordingly.
        TextView textView = (TextView) cardView.findViewById(R.id.connections_text);
        textView.setText(RelationshipProvider.getRelationShips(DataBase.getUser()).getConnected().get(position).toStringLong());
        holder.bind(position);

        // Sets the onclick action to the context-bound method.
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contextBoundMethod.setData(new Integer(position));
                contextBoundMethod.run();
            }
        });
    }

    // Return the size of the dataset (and is invoked by the layout manager).
    @Override
    public int getItemCount() {
        return RelationshipProvider.getRelationShips(DataBase.getUser()).getConnected().size();
    }
}
