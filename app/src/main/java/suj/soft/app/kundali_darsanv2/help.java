package suj.soft.app.kundali_darsanv2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by Admin on 10/15/2017.
 */

public class help extends Activity{
    TextView tv1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.falit);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv1.setText(readRawTextFile(this));
        Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");

        if(Public_veriable.FEN==0){tf = Typeface.DEFAULT;}
        if( Public_veriable.registered==0){tf = Typeface.DEFAULT;}
        tv1.setTypeface(tf);

    }

    public static String readRawTextFile(Context ctx)
    {
        InputStream inputStream =null;
        if(Public_veriable.FEN==0){
            inputStream = ctx.getResources().openRawResource(R.raw.help);}else{
            inputStream = ctx.getResources().openRawResource(R.raw.helpnepali);
        }

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();
        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');}
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }
}
