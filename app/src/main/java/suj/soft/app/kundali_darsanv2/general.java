package suj.soft.app.kundali_darsanv2;
        import android.app.Activity;
        import android.graphics.Typeface;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.widget.TableLayout;
        import android.widget.TextView;


public class general  extends Activity {
    private name_others Fname;
    private displayformat mformat;
    private String bm1,bm2,bm3,bm4,bm5;
    TextView T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19;
    TextView G1,G2,G3,G4,G5,G6,G7,G8,G9;
    TextView B3,B4,B5,B6,B7,B8,B9;
    TextView N1,N2,N3,N4,N5,N6,N7,N8,N9;
    TextView P1,P2,P3,P4,P5,P6,P7,P8,P9;
    TextView NS1,NS2,NS3,NS4,NS5,NS6,NS7,NS8,NS9;
    TextView RS1,RS2,RS3,RS4,RS5,RS6,RS7,RS8,RS9;
    TextView BS1,BS2,BS3,BS4,BS5,BS6,BS7,BS8,BS9;
    TextView SS1,SS2,SS3,SS4,SS5,SS6,SS7,SS8,SS9;
    TableLayout imageback;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general);

        imageback = (TableLayout)findViewById(R.id.LinearLayout1);//Pre kundali

        Drawable  backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);


        T1 = (TextView)findViewById(R.id.textView1);
        T2 = (TextView)findViewById(R.id.textView2);
        T3 = (TextView)findViewById(R.id.textView3);
        T4 = (TextView)findViewById(R.id.textView4);
        T5 = (TextView)findViewById(R.id.textView5);
        T6 = (TextView)findViewById(R.id.textView6);
        T7 = (TextView)findViewById(R.id.textView7);
        T8 = (TextView)findViewById(R.id.textView8);
        T9 = (TextView)findViewById(R.id.textView9);
        T10 = (TextView)findViewById(R.id.textView10);
        T11 = (TextView)findViewById(R.id.textView19);
        T12 = (TextView)findViewById(R.id.textView28);
        T13 = (TextView)findViewById(R.id.textView37);
        T14 = (TextView)findViewById(R.id.textView46);
        T15 = (TextView)findViewById(R.id.textView55);
        T16 = (TextView)findViewById(R.id.textView64);
        T17 = (TextView)findViewById(R.id.textView73);
        T18 = (TextView)findViewById(R.id.textView82);
        T19 = (TextView)findViewById(R.id.textView91);

        G1 = (TextView)findViewById(R.id.textView11);
        G2 = (TextView)findViewById(R.id.textView20);
        G3 = (TextView)findViewById(R.id.textView29);
        G4 = (TextView)findViewById(R.id.textView38);
        G5 = (TextView)findViewById(R.id.textView47);
        G6 = (TextView)findViewById(R.id.textView56);
        G7 = (TextView)findViewById(R.id.textView65);
        G8 = (TextView)findViewById(R.id.textView74);
        G9 = (TextView)findViewById(R.id.textView83);

        B3 = (TextView)findViewById(R.id.textView30);
        B4 = (TextView)findViewById(R.id.textView39);
        B5 = (TextView)findViewById(R.id.textView48);
        B6 = (TextView)findViewById(R.id.textView57);
        B7 = (TextView)findViewById(R.id.textView66);
        B8 = (TextView)findViewById(R.id.textView75);
        B9 = (TextView)findViewById(R.id.textView84);

        N1 = (TextView)findViewById(R.id.textView13);
        N2 = (TextView)findViewById(R.id.textView22);
        N3 = (TextView)findViewById(R.id.textView31);
        N4 = (TextView)findViewById(R.id.textView40);
        N5 = (TextView)findViewById(R.id.textView49);
        N6 = (TextView)findViewById(R.id.textView58);
        N7 = (TextView)findViewById(R.id.textView67);
        N8 = (TextView)findViewById(R.id.textView76);
        N9 = (TextView)findViewById(R.id.textView85);

        P1 = (TextView)findViewById(R.id.textView14);
        P2 = (TextView)findViewById(R.id.textView23);
        P3 = (TextView)findViewById(R.id.textView32);
        P4 = (TextView)findViewById(R.id.textView41);
        P5 = (TextView)findViewById(R.id.textView50);
        P6 = (TextView)findViewById(R.id.textView59);
        P7 = (TextView)findViewById(R.id.textView68);
        P8 = (TextView)findViewById(R.id.textView77);
        P9 = (TextView)findViewById(R.id.textView86);

        NS1 = (TextView)findViewById(R.id.textView15);
        NS2 = (TextView)findViewById(R.id.textView24);
        NS3 = (TextView)findViewById(R.id.textView33);
        NS4 = (TextView)findViewById(R.id.textView42);
        NS5 = (TextView)findViewById(R.id.textView51);
        NS6 = (TextView)findViewById(R.id.textView60);
        NS7 = (TextView)findViewById(R.id.textView69);
        NS8 = (TextView)findViewById(R.id.textView78);
        NS9 = (TextView)findViewById(R.id.textView87);

        RS1 = (TextView)findViewById(R.id.textView16);
        RS2 = (TextView)findViewById(R.id.textView25);
        RS3 = (TextView)findViewById(R.id.textView34);
        RS4 = (TextView)findViewById(R.id.textView43);
        RS5 = (TextView)findViewById(R.id.textView52);
        RS6 = (TextView)findViewById(R.id.textView61);
        RS7 = (TextView)findViewById(R.id.textView70);
        RS8 = (TextView)findViewById(R.id.textView79);
        RS9 = (TextView)findViewById(R.id.textView88);

        BS1 = (TextView)findViewById(R.id.textView17);
        BS2 = (TextView)findViewById(R.id.textView26);
        BS3 = (TextView)findViewById(R.id.textView35);
        BS4 = (TextView)findViewById(R.id.textView44);
        BS5 = (TextView)findViewById(R.id.textView53);
        BS6 = (TextView)findViewById(R.id.textView62);
        BS7 = (TextView)findViewById(R.id.textView71);
        BS8 = (TextView)findViewById(R.id.textView80);
        BS9 = (TextView)findViewById(R.id.textView89);

        SS1 = (TextView)findViewById(R.id.textView18);
        SS2 = (TextView)findViewById(R.id.textView27);
        SS3 = (TextView)findViewById(R.id.textView36);
        SS4 = (TextView)findViewById(R.id.textView45);
        SS5 = (TextView)findViewById(R.id.textView54);
        SS6 = (TextView)findViewById(R.id.textView63);
        SS7 = (TextView)findViewById(R.id.textView72);
        SS8 = (TextView)findViewById(R.id.textView81);
        SS9 = (TextView)findViewById(R.id.textView90);
        B8.setText("Bakri ");
        B9.setText("Bakri ");
        if(Public_veriable.FEN==1){
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
            T1.setTypeface(tf); T2.setTypeface(tf);T3.setTypeface(tf);T4.setTypeface(tf);T5.setTypeface(tf);T16.setTypeface(tf);
            T6.setTypeface(tf); T7.setTypeface(tf);T8.setTypeface(tf);T9.setTypeface(tf);T10.setTypeface(tf);T17.setTypeface(tf);
            T11.setTypeface(tf); T12.setTypeface(tf);T13.setTypeface(tf);T14.setTypeface(tf);T15.setTypeface(tf);T18.setTypeface(tf);T19.setTypeface(tf);
            G1.setTypeface(tf); G2.setTypeface(tf);G3.setTypeface(tf);G4.setTypeface(tf);G5.setTypeface(tf);G6.setTypeface(tf);G7.setTypeface(tf);G8.setTypeface(tf);G9.setTypeface(tf);
            B3.setTypeface(tf);B4.setTypeface(tf);B5.setTypeface(tf);B6.setTypeface(tf);B7.setTypeface(tf);B8.setTypeface(tf);B9.setTypeface(tf);
            N1.setTypeface(tf); N2.setTypeface(tf);N3.setTypeface(tf);N4.setTypeface(tf);N5.setTypeface(tf);N6.setTypeface(tf);N7.setTypeface(tf);N8.setTypeface(tf);N9.setTypeface(tf);
            P1.setTypeface(tf); P2.setTypeface(tf);P3.setTypeface(tf);P4.setTypeface(tf);P5.setTypeface(tf);P6.setTypeface(tf);P7.setTypeface(tf);P8.setTypeface(tf);P9.setTypeface(tf);
            NS1.setTypeface(tf); NS2.setTypeface(tf);NS3.setTypeface(tf);NS4.setTypeface(tf);NS5.setTypeface(tf);NS6.setTypeface(tf);NS7.setTypeface(tf);NS8.setTypeface(tf);NS9.setTypeface(tf);
            RS1.setTypeface(tf); RS2.setTypeface(tf);RS3.setTypeface(tf);RS4.setTypeface(tf);RS5.setTypeface(tf);RS6.setTypeface(tf);RS7.setTypeface(tf);RS8.setTypeface(tf);RS9.setTypeface(tf);
            BS1.setTypeface(tf); BS2.setTypeface(tf);BS3.setTypeface(tf);BS4.setTypeface(tf);BS5.setTypeface(tf);BS6.setTypeface(tf);BS7.setTypeface(tf);BS8.setTypeface(tf);BS9.setTypeface(tf);
            SS1.setTypeface(tf); SS2.setTypeface(tf);SS3.setTypeface(tf);SS4.setTypeface(tf);SS5.setTypeface(tf);SS6.setTypeface(tf);SS7.setTypeface(tf);SS8.setTypeface(tf);SS9.setTypeface(tf);

            //typing text
            T1.setText("");T2.setText(" u|x:ki^"); T3.setText("a=df="); T4.setText("gIfq"); T5.setText("kfb "); T6.setText("g=:jf="); T7.setText("/f=:jf=");T8.setText("af=c=");T9.setText("z=c=");
            T10.setText(" ;úo{"); T11.setText(" rGb|");T12.setText(" d+un");T13.setText(" aÚw");T14.setText(" uÚ?");T15.setText(" zÚqm");T16.setText(" zlg");T17.setText(" /fxÚ");T18.setText(" s]tÚ");
            B8.setText("aqmL ");
            B9.setText("aqmL ");

        }
        loadDoc();
    }

    private void loadDoc(){
        Fname= new name_others();
        mformat= new displayformat();

        G1.setText (mformat.dis_rgpb(SuryaSiddhanta.pastsurya)+" ");
        G2.setText(mformat.dis_rgpb(SuryaSiddhanta.pastchandra)+" ");
        G3.setText(mformat.dis_rgpb(SuryaSiddhanta.pastmangal)+" ");
        G4.setText(mformat.dis_rgpb(SuryaSiddhanta.pastbudha)+" ");
        G5.setText(mformat.dis_rgpb(SuryaSiddhanta.pastguru)+" ");
        G6.setText(mformat.dis_rgpb(SuryaSiddhanta.pastsukra)+" ");
        G7.setText(mformat.dis_rgpb(SuryaSiddhanta.pastsani)+" ");
        G8.setText(mformat.dis_rgpb(SuryaSiddhanta.pastrahu)+" ");
        G9.setText(mformat.dis_rgpb(SuryaSiddhanta.pastKetu)+" ");

        if(Public_veriable.FEN==1){
            if(SuryaSiddhanta.MangalBakrimargi.equalsIgnoreCase("Bakri")){bm1="aqmL";}else{bm1="dfuL{";}
            if(SuryaSiddhanta.BudhaBakrimargi.equalsIgnoreCase("Bakri")){bm2="aqmL";}else{bm2="dfuL{";}
            if(SuryaSiddhanta.guruBakrimargi.equalsIgnoreCase("Bakri")){bm3="aqmL";}else{bm3="dfuL{";}
            if(SuryaSiddhanta.sukraBakrimargi.equalsIgnoreCase("Bakri")){bm4="aqmL";}else{bm4="dfuL{";}
            if(SuryaSiddhanta.saniBakrimargi.equalsIgnoreCase("Bakri")){bm5="aqmL";}else{bm5="dfuL{";}

        }


        B3.setText(bm1+" ");
        B4.setText(bm2+" ");
        B5.setText(bm3+" ");
        B6.setText(bm4+" ");
        B7.setText(bm5+" ");


        N1.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastsurya/13.33333+1))+" ");
        N2.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastchandra/13.33333+1))+" ");
        N3.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastmangal/13.33333+1))+" ");
        N4.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastbudha/13.33333+1))+" ");
        N5.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastguru/13.33333+1))+" ");
        N6.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastsukra/13.33333+1))+" ");
        N7.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastsani/13.33333+1))+" ");
        N8.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastrahu/13.33333+1))+" ");
        N9.setText(Fname.nakchtraname((int) (SuryaSiddhanta.pastKetu/13.33333+1))+" ");

        P1.setText(((int) ((SuryaSiddhanta.pastsurya%13.33333)/3.33333)+1)+" ");
        P2.setText(((int) ((SuryaSiddhanta.pastchandra%13.33333)/3.33333)+1)+" ");
        P3.setText(((int) ((SuryaSiddhanta.pastmangal%13.33333)/3.33333)+1)+" ");
        P4.setText(((int) ((SuryaSiddhanta.pastbudha%13.33333)/3.33333)+1)+" ");
        P5.setText(((int) ((SuryaSiddhanta.pastguru%13.33333)/3.33333)+1)+" ");
        P6.setText(((int) ((SuryaSiddhanta.pastsukra%13.33333)/3.33333)+1)+" ");
        P7.setText(((int) ((SuryaSiddhanta.pastsani%13.33333)/3.33333)+1)+" ");
        P8.setText(((int) ((SuryaSiddhanta.pastrahu%13.33333)/3.33333)+1)+" ");
        P9.setText(((int) ((SuryaSiddhanta.pastKetu%13.33333)/3.33333)+1)+" ");

        NS1.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastsurya/13.33333+1))+" ");
        NS2.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastchandra/13.33333+1))+" ");
        NS3.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastmangal/13.33333+1))+" ");
        NS4.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastbudha/13.33333+1))+" ");
        NS5.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastguru/13.33333+1))+" ");
        NS6.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastsukra/13.33333+1))+" ");
        NS7.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastsani/13.33333+1))+" ");
        NS8.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastrahu/13.33333+1))+" ");
        NS9.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastKetu/13.33333+1))+" ");

        RS1.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastsurya/30+1))+" ");
        RS2.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastchandra/30+1))+" ");
        RS3.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastmangal/30+1))+" ");
        RS4.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastbudha/30+1))+" ");
        RS5.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastguru/30+1))+" ");
        RS6.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastsukra/30+1))+" ");
        RS7.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastsani/30+1))+" ");
        RS8.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastrahu/30+1))+" ");
        RS9.setText(Fname.Nakchhatraswami((int) (SuryaSiddhanta.pastKetu/30+1))+" ");

        BS1.setText (Fname.Balwastha(SuryaSiddhanta.pastsurya)+" ");
        BS2.setText(Fname.Balwastha(SuryaSiddhanta.pastchandra)+" ");
        BS3.setText(Fname.Balwastha(SuryaSiddhanta.pastmangal)+" ");
        BS4.setText(Fname.Balwastha(SuryaSiddhanta.pastbudha)+" ");
        BS5.setText(Fname.Balwastha(SuryaSiddhanta.pastguru)+" ");
        BS6.setText(Fname.Balwastha(SuryaSiddhanta.pastsukra)+" ");
        BS7.setText(Fname.Balwastha(SuryaSiddhanta.pastsani)+" ");
        BS8.setText(Fname.Balwastha(SuryaSiddhanta.pastrahu)+" ");
        BS9.setText(Fname.Balwastha(SuryaSiddhanta.pastKetu)+" ");

        SS1.setText (Fname.Sayanwastha(1,SuryaSiddhanta.pastsurya));
        SS2.setText (Fname.Sayanwastha(2,SuryaSiddhanta.pastchandra));
        SS3.setText (Fname.Sayanwastha(3,SuryaSiddhanta.pastmangal));
        SS4.setText (Fname.Sayanwastha(4,SuryaSiddhanta.pastbudha));
        SS5.setText (Fname.Sayanwastha(5,SuryaSiddhanta.pastguru));
        SS6.setText (Fname.Sayanwastha(6,SuryaSiddhanta.pastsukra));
        SS7.setText (Fname.Sayanwastha(7,SuryaSiddhanta.pastsani));
        SS8.setText (Fname.Sayanwastha(8,SuryaSiddhanta.pastrahu));
        SS9.setText (Fname.Sayanwastha(9,SuryaSiddhanta.pastKetu));

        if(Public_veriable.FEN==1){
            T19.setText (" nUg ki^ "+mformat.dis_rgpb(SuryaSiddhanta.Eastrasi*30));
        }else{
            T19.setText (" Lagna pasta "+mformat.dis_rgpb(SuryaSiddhanta.Eastrasi*30));
        }
    }


}
