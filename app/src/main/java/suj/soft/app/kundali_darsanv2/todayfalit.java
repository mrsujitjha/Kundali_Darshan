package suj.soft.app.kundali_darsanv2;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;


public class todayfalit extends Activity {
    DatabaseHelper dbHelper = null;
    private name_others mname;
    TextView tv1;
    LinearLayout imageback;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.falit);
        imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable  backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);

        tv1 = (TextView)findViewById(R.id.tv1);
        //loadDoc();
    }

    private void loadDoc(){

        dbHelper = MainActivity.dbHelper;

        String rasifal = "";
        String Nakfal ="";
        String fcode = "";
        String Faltodisplay="";
        mname = new name_others();
        String selectQuery = "SELECT * FROM Fal";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/Times_Reg.otf");

        if(Public_veriable.FEN==0){tf = Typeface.DEFAULT;}
        if( Public_veriable.registered==0){tf = Typeface.DEFAULT;}
        tv1.setTypeface(tf);

        if(Public_veriable.FalT==0){
            int rno =(int)(SuryaSiddhanta.pastchandra/30+1);
            String Otherfal="";
            int coln =3; if(Public_veriable.FEN==1){coln=2;}
            if ( cursor.moveToFirst () ) {
                do {

                    if( Public_veriable.registered==0){tf = Typeface.DEFAULT;rasifal="Register your Kundali app to view falit";}

                    fcode = cursor.getString(0);
                    if (fcode.equals("R"+rno)){
                        if(Public_veriable.FEN==1){rasifal= cursor.getString(1)+"\n\n";}
                        rasifal +=   cursor.getString(coln)+"\n\n" ;}
                    if (fcode.equals("N"+SuryaSiddhanta.GatNakchatra)){
                        if(Public_veriable.FEN==1){Nakfal= cursor.getString(1)+"\n\n";}
                        Nakfal +=cursor.getString(coln)+"\n\n" ;}

                    if(Public_veriable.FEN==1){
                        if (fcode.equals("D"+SuryaSiddhanta.Dayno)){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}

                        if (fcode.equals("M"+Chdigit(Public_veriable.Nmn))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        long sss =Public_veriable.Nyr%60+10;
                        if (sss>60) { sss=sss-60;}
                        if (fcode.equals("S"+Chdigit((int) sss))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}

                        int ttt=SuryaSiddhanta.TodayTith;
                        if (fcode.equals("PK1")&& ttt<=15){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if (fcode.equals("PK2")&& ttt>15){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if(ttt>15){ttt=ttt-15;}
                        if (fcode.equals("T"+Chdigit(ttt))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if (fcode.equals("Z"+Chdigit(SuryaSiddhanta.GatYoga))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if (fcode.equals("K"+Chdigit(SuryaSiddhanta.KRN))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if (fcode.equals("L"+Chdigit((int)SuryaSiddhanta.Eastrasi+1))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if (fcode.equals(Public_veriable.GN)){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                        if (fcode.equals(mname.Ritufalid(Public_veriable.Nmn))){
                            Otherfal +=cursor.getString(1)+"\n\n" ;
                            Otherfal +=cursor.getString(2)+"\n\n" ;}
                    }
                } while (cursor.moveToNext()); }
            Faltodisplay=rasifal + Nakfal+Otherfal;
        }


        if(Public_veriable.FalT==1){
            int coln =3; if(Public_veriable.FEN==1){coln=2;}
            if ( cursor.moveToFirst () ) {
                do {
                    fcode = cursor.getString(0);
                    if (fcode.equals(Public_veriable.BDNUM+"")){
                        if(coln==2){Faltodisplay =cursor.getString(1) + "\n\n";}
                        Faltodisplay +=cursor.getString(coln) ;
                        break;}
                } while (cursor.moveToNext());
            }

            if( Public_veriable.registered==0){tf = Typeface.DEFAULT;Faltodisplay="Register your Kundali app to view falit";}

        }

        if(Public_veriable.FalT==3){
            if(Public_veriable.FEN==1){
                if ( cursor.moveToFirst () ) {
                    do {
                        fcode = cursor.getString(0);
                        if (fcode.equals("Y"+Public_veriable.BDNUM)){
                            Faltodisplay =cursor.getString(1) + "\n\n";
                            Faltodisplay +=cursor.getString(2) ;
                            break;}
                    } while (cursor.moveToNext());
                }

                if( Public_veriable.registered==0){tf = Typeface.DEFAULT;Faltodisplay="Register your Kundali app to view falit";}

            }else {Faltodisplay = "There is no falit included for Yogini in english.";}
        }


        cursor.close();
        db.close();
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,Public_veriable.FS);
        tv1.setText(Faltodisplay);
    }
    private static String Chdigit(int value) {
        if (value < 10)
            return "0" + value;
        else
            return String.valueOf(value);}
}
