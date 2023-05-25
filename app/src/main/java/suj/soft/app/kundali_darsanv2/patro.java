package suj.soft.app.kundali_darsanv2;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;



public class patro extends Activity {

    private static long curyear = 0;
    private static int curmonth = 0;
    private static int curdate = 0;
    public static DatabaseHelper dbHelper = null;
    private static DBOperation dboper = null;
    private name_others Fname; private option moption;

    private EditText Cyear;
    private TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,Iswidate;
    private TextView Gn1,Gn2,Gn3,Gn4,Gn5,Gn6,Gn7,Gn8,Gn9,Gn10,Gn11,Gn12;
    private ImageView mimageND,mimagePD;
    ImageButton  searchPD;
    LinearLayout imagekund;
    LinearLayout imageback;
    private final SuryaSiddhanta Ssidhanta=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patro);
        dbHelper = new DatabaseHelper(this, "Kundali.db", null, 1);
        dboper = new DBOperation();
        Fname = new name_others();
        moption = new option();
        Iswidate = (TextView) findViewById(R.id.textView93);
        Cyear= (EditText) findViewById(R.id.editText9);
        p1 = (TextView)findViewById(R.id.textView101);  p11 = (TextView)findViewById(R.id.textView1011);
        p2 = (TextView)findViewById(R.id.textView102);  p12 = (TextView)findViewById(R.id.textView1012);
        p3 = (TextView)findViewById(R.id.textView103);  p13 = (TextView)findViewById(R.id.textView1013);
        p4 = (TextView)findViewById(R.id.textView104);  p8 = (TextView)findViewById(R.id.textView108);
        p5 = (TextView)findViewById(R.id.textView105);  p9 = (TextView)findViewById(R.id.textView109);
        p6 = (TextView)findViewById(R.id.textView106);  p10 = (TextView)findViewById(R.id.textView1010);
        p7 = (TextView)findViewById(R.id.textView107);

        Gn1 = (TextView)findViewById(R.id.textView2);
        Gn2 = (TextView)findViewById(R.id.textView3);
        Gn3 = (TextView)findViewById(R.id.textView4);
        Gn4 = (TextView)findViewById(R.id.textView5);
        Gn5 = (TextView)findViewById(R.id.textView6);
        Gn6 = (TextView)findViewById(R.id.textView7);
        Gn7 = (TextView)findViewById(R.id.textView8);
        Gn8 = (TextView)findViewById(R.id.textView9);
        Gn9 = (TextView)findViewById(R.id.textView10);
        Gn10 = (TextView)findViewById(R.id.textView11);
        Gn11 = (TextView)findViewById(R.id.textView12);
        Gn12 = (TextView)findViewById(R.id.textView1);



        mimagePD=(ImageView)findViewById(R.id.imageView101);
        mimageND=(ImageView)findViewById(R.id.imageView102);
        searchPD=(ImageButton)findViewById(R.id.imageButton);

        imagekund = (LinearLayout)findViewById(R.id.linear1);//Pre kundali
        Drawable drawable  = null;
        if(Public_veriable.KB==0){
            drawable  = getResources().getDrawable(R.drawable.kundali);}else{
            drawable  = getResources().getDrawable(R.drawable.kundalicolor);
        }
        imagekund.setBackgroundDrawable(drawable);

        imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable  backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);



        if(Public_veriable.FEN==1)  {
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
            p1.setTypeface(tf); p2.setTypeface(tf); p3.setTypeface(tf); p4.setTypeface(tf); p5.setTypeface(tf);
            p6.setTypeface(tf); p7.setTypeface(tf); p8.setTypeface(tf); p9.setTypeface(tf); p10.setTypeface(tf);
            p11.setTypeface(tf); p12.setTypeface(tf); p13.setTypeface(tf);
            Gn1.setTypeface(tf); Gn2.setTypeface(tf); Gn3.setTypeface(tf); Gn4.setTypeface(tf);
            Gn5.setTypeface(tf); Gn6.setTypeface(tf); Gn7.setTypeface(tf); Gn8.setTypeface(tf);
            Gn9.setTypeface(tf); Gn10.setTypeface(tf); Gn11.setTypeface(tf); Gn12.setTypeface(tf);

        }
        loadstartnepdate();

        Public_veriable.DS = "-";
            searchPD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Cyear.getText().toString().length()==8){
                        String str =Cyear.getText().toString();
                        curyear= Integer.parseInt(str.substring(0,4));
                        curmonth=Integer.parseInt(str.substring(4,6));
                        curdate=Integer.parseInt(str.substring(6,8));

                        dboper.getnepmonthday(curyear);
                        String[] Sectext = Public_veriable.monthday.split(" ");
                        long cmd = 0;
                        for (int i = 1; i < curmonth; i++) {
                            cmd += Integer.parseInt(Sectext[i]);
                        }

                    Public_veriable.patroday = (int) (long)cmd+curdate;
                    Cyear.setText(curyear + "");

                    Getdaily_patro();}else{
                    Toast.makeText(getApplicationContext(), "Fill format YYYYMMDD to view Panchang.", Toast.LENGTH_SHORT).show();
                    }
                }});

           mimagePD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {Public_veriable.patroday = Public_veriable.patroday-1;
                    if(Public_veriable.patroday==0){Public_veriable.patroday =1;}
                    Getdaily_patro();

                }});
            mimageND.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {Public_veriable.patroday = Public_veriable.patroday+1;
                    if(Public_veriable.patroday==0){Public_veriable.patroday =1;}
                    Getdaily_patro();

                }});

        Iswidate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Public_veriable.Nyr=Integer.parseInt(Cyear.getText().toString());
                    AlertDialog YNbox = preparepatro(Public_veriable.Nyr);
                    YNbox.show();
                }
            });
        }

    private void load_patro(){
        String[] patrotext = Public_veriable.patrdetail.split("!,");
        p1.setText(patrotext[0]);//2072 baisakha 21 gate
        p2.setText(patrotext[1]);//2015 april 12 tarikha
        p3.setText(patrotext[2]);//2015 srisakhe --sukla pakcha mangalbar
        p4.setText(patrotext[3]);//aayan ---  and sambat sar---
        p5.setText(patrotext[4]);//Tithi,gp,samay
        p6.setText(patrotext[5]);//Nakchatra,gp,samay
        p7.setText(patrotext[6]);//yog,gp,samay
        p8.setText(patrotext[7]);//karan,gp
        p9.setText(patrotext[8]);//yog nam
        p10.setText(patrotext[9]);//chandra rashi
        p11.setText(patrotext[10]);//Dinman
        p12.setText(patrotext[11]);//suryoday
        p13.setText(patrotext[12]);//suryata
        SuryaSiddhanta.pastsurya = Double.parseDouble( patrotext[13]);
        SuryaSiddhanta.pastchandra = Double.parseDouble( patrotext[14]);
        SuryaSiddhanta.pastmangal = Double.parseDouble( patrotext[15]);
        SuryaSiddhanta.pastbudha = Double.parseDouble( patrotext[16]);
        SuryaSiddhanta.pastguru = Double.parseDouble( patrotext[17]);
        SuryaSiddhanta.pastsukra = Double.parseDouble( patrotext[18]);
        SuryaSiddhanta.pastsani = Double.parseDouble( patrotext[19]);
        SuryaSiddhanta.pastrahu = Double.parseDouble( patrotext[20]);
        SuryaSiddhanta.pastKetu=SuryaSiddhanta.pastrahu+180;
        if(SuryaSiddhanta.pastKetu >360){ SuryaSiddhanta.pastKetu = SuryaSiddhanta.pastKetu - 360;}
    }
    void Getdaily_patro(){
        Public_veriable.Nyr = Integer.parseInt(Cyear.getText().toString());
        dboper.getpatro(Public_veriable.Nyr);
        load_patro();
        moption.definelagna(100);
        load_kundali();
    }

    private void load_kundali(){
        Gn1.setText(Public_veriable.GrahG1);
        Gn2.setText(Public_veriable.GrahG2);
        Gn3.setText(Public_veriable.GrahG3);
        Gn4.setText(Public_veriable.GrahG4);
        Gn5.setText(Public_veriable.GrahG5);
        Gn6.setText(Public_veriable.GrahG6);
        Gn7.setText(Public_veriable.GrahG7);
        Gn8.setText(Public_veriable.GrahG8);
        Gn9.setText(Public_veriable.GrahG9);
        Gn10.setText(Public_veriable.GrahG10);
        Gn11.setText(Public_veriable.GrahG11);
        Gn12.setText(Public_veriable.GrahG12);
    }
    void loadstartnepdate() {
        final Calendar CC = Calendar.getInstance();
        changeENdate(CC.get(Calendar.YEAR), CC.get(Calendar.MONTH) + 1, CC.get(Calendar.DAY_OF_MONTH));
        Cyear.setText(curyear + "");
        Public_veriable.patroday=1;
        Getdaily_patro();
    }
    void changeENdate(long y1, int m1, int d1) {
        int m;
        double TD, FD, YD = 0, NE;
        long NEP;
        m = m1 - 1;
        TD = 365.25 * (y1 - 1);

        if (y1 % 4 == 0) {
            String someWords = "0 31 60 91 121 152 182 213 244 274 305 355 366";
            String[] Sectext = someWords.split(" ");
            TD = TD + Integer.parseInt(Sectext[m]);
        } else {
            String someWords = "0 31 59 90 120 151 181 212 243 273 304 334 365";
            String[] Sectext = someWords.split(" ");
            TD = TD + Integer.parseInt(Sectext[m]);
        }

        FD = 20735 + (long) TD + d1;
        NE = (long) FD / 365.25;

        for (NEP = (int) (NE - 4); NEP < (int) (NE + 4); NEP++) {
            if (FD - (366 + (NEP - 2) * 365.25875876) <= 366) {
                curyear = NEP;
                break;
            }
        }

        dboper.getnepmonthday(curyear);
        String[] Sectext = Public_veriable.monthday.split(" ");
        YD = FD + 1112210 - Integer.parseInt(Sectext[14]);
        long cmd = 0;
        long cmdP = 0;
        for (int i = 1; i < 13; i++) {
            cmd += Integer.parseInt(Sectext[i]);
            if (cmd >= YD) {
                curmonth = i;
                curdate = (int) (YD - cmdP);
                break;
            }
            cmdP += Integer.parseInt(Sectext[i]);
        }

    }
    public AlertDialog preparepatro(final long cyr) {
        AlertDialog preparepatro = new AlertDialog.Builder(this)

                .setTitle("Prepare patro for Selected year " + cyr)
                .setMessage("Click YES to prepare patro...")

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int Sb) {
                        dboper.preparepatro(cyr + "");
                        new patro.preparepatrobackground().execute("");
                        Toast.makeText(getApplicationContext(), "Patro preparation started....", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("View", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int Sb) {
                        Public_veriable.patroday =1;
                        Getdaily_patro();

                    }
                })
                .create();
        return preparepatro;
    }

    //================================================================================
    private class preparepatrobackground extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                for (int num = 1; num < Public_veriable.Tyerdays + 1; num++) {
                    Public_veriable.prepare_patro(num);
                    publishProgress(num + "");
                }

            } catch (Exception e) {
                Thread.interrupted();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Cyear.setText(Public_veriable.Nyr+"");
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Cyear.setText(values[0]+"/"+Public_veriable.Nyr);
        }
    }

 }
