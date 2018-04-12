package learnmore.projet.learnmore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import learnmore.projet.learnmore.Model.Note;
import learnmore.projet.learnmore.PdfActivity;
import learnmore.projet.learnmore.R;
import learnmore.projet.learnmore.VideoActivity;

/**
 * Created by khalil on 28/03/2018.
 */

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.MyViewHolder> {
    List<Note> myNotes;
    Context myContext;


    public NoteRecyclerViewAdapter(List<Note> myNotes, Context myContext) {
        this.myNotes = myNotes;
        this.myContext = myContext;
    }

    public List<Note> getMyNotes() {
        return myNotes;
    }

    public void setMyNotes(List<Note> myNotes) {
        this.myNotes = myNotes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater =LayoutInflater.from(myContext);
        view = layoutInflater.inflate(R.layout.cardview_note_item, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_note_desc.setText(myNotes.get(position).getDescription());
        holder.tv_note_title.setText(myNotes.get(position).getTitle());
        holder.cv_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myContext, PdfActivity.class);
                  intent.putExtra("url", myNotes.get(position).getNoteUrl());

                myContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myNotes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_note_title;
        TextView tv_note_desc;
        ImageView iv_note_img;
        CardView cv_note;

        public MyViewHolder(View itemView) {
            super(itemView);

            cv_note = (CardView) itemView.findViewById(R.id.note_card);
            tv_note_title = (TextView) itemView.findViewById(R.id.note_tit);
            tv_note_desc = (TextView) itemView.findViewById(R.id.note_des);
            iv_note_img = (ImageView) itemView.findViewById(R.id.note_img);
        }
    }


}
