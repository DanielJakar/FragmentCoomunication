package android.course.fragmentcoomunication;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.VolumeProviderCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment implements View.OnClickListener {



    private FrameLayout f;
    private OnColorChangedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnColorChangedListener){
            this.listener = (OnColorChangedListener) context;
        }else {
            throw new RuntimeException("Must implement OnColorChangedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_color, container, false);

        f = (FrameLayout) v.findViewById(R.id.colorLayout);
        f.setOnClickListener(this);

        return v;
    }

    public interface OnColorChangedListener{
        void onColorChanged(int color);
    }


    @Override
    public void onClick(View v) {
        Random r = new Random();
        int color = Color.rgb(r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256));

        f.setBackgroundColor(color);

        //get a reference to MainActivity:

        listener.onColorChanged(color);

    }
}
