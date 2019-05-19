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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.usingle.R;
import com.usingle.activities.HomeActivity;
import com.usingle.models.Account;
import com.usingle.models.DataBase;
import com.usingle.models.RelationshipProvider;
import com.usingle.util.ContextBoundMethod;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    // This is the method that should be run when a contact is selected by the user.
    private ContextBoundMethod contextBoundMethod;

    // This is the only constructor.
    public MatchesAdapter(ContextBoundMethod contextBoundMethod) {
        this.contextBoundMethod = contextBoundMethod;
    }

    // Represents a view for each item in the RecyclerView.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // These are the views which are used to display the contact.
        private CardView cardView;
        private ImageView imageView;
        private TextView textView;
        private Button checkMark, cross;

        // This is the contact's position.
        int position;

        // This stores a reference to the list of contacts.
        String basicStats;

        // This is the only constructor.
        public ViewHolder(View view, String basicStats) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.matches_list_card_view);
            imageView = (ImageView) view.findViewById(R.id.matches_image);
            textView = (TextView) cardView.findViewById(R.id.matches_text);
            checkMark = (Button) cardView.findViewById(R.id.check_mark_match);
            cross = (Button) cardView.findViewById(R.id.cross_match);
            this.basicStats = basicStats;

            // This sets up an onclick listener for the checkbox.
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something
                }
            });

            checkMark.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Account which = RelationshipProvider.getRelationShips(DataBase.getUser()).getCompatible().get(position);
                     RelationshipProvider.getRelationShips(DataBase.getUser()).formConnection(which);
                     HomeActivity.matchesAdapter.notifyDataSetChanged();
                     HomeActivity.connectionsAdapter.notifyDataSetChanged();
                 }});

            cross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Account which = RelationshipProvider.getRelationShips(DataBase.getUser()).getCompatible().get(position);
                    RelationshipProvider.getRelationShips(DataBase.getUser()).removeCompatible(which);
                    HomeActivity.matchesAdapter.notifyDataSetChanged();
                    HomeActivity.connectionsAdapter.notifyDataSetChanged();
                }});
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
                .inflate(R.layout.matches_list_item, parent, false);
        return new ViewHolder(itemView, "");
    }

    // This replaces the contents of a view (and is invoked by the layout manager).
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.getCardView();

        // The following sets up views accordingly.
        TextView textView = (TextView) cardView.findViewById(R.id.matches_text);
        textView.setText(RelationshipProvider.getRelationShips(DataBase.getUser()).getCompatible().get(position).toStringShort());
        holder.bind(position);
    }

    // Return the size of the dataset (and is invoked by the layout manager).
    @Override
    public int getItemCount() {
        // return TemporaryMatchesProvider.getNumberOfMatches();
        return RelationshipProvider.getRelationShips(DataBase.getUser()).getCompatible().size();
    }
}
