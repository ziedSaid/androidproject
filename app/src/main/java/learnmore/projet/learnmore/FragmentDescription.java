package learnmore.projet.learnmore;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by khalil on 27/03/2018.
 */


public class FragmentDescription extends Fragment {
    View view;
    TextView textView, textView2;
    String title, description;

    public FragmentDescription() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.description_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.dtitle);
        textView.setText(title);
        textView2 = (TextView) view.findViewById(R.id.dtext);
        textView2.setText(description);
        Log.v("view :",view.toString());
        return view;
    }

    public void setText(String title, String description){
        this.title = title;
        this.description = description;

    }
}
