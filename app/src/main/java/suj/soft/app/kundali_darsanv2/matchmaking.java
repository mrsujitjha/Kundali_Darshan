package suj.soft.app.kundali_darsanv2;
        import android.app.Activity;
        import android.graphics.Color;
        import android.graphics.Typeface;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.text.method.ScrollingMovementMethod;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;
        import android.widget.Spinner;
        import android.widget.TextView;


public class matchmaking extends Activity {
    private static DBOperation dboper=null;
    private SuryaSiddhanta Ssidhanta=null;
    private option getopt=null;
    private name_others getnm=null;
    ImageButton matchbutton;

    LinearLayout imageback;
    private int maleid,femaleid,boyn,girln,boyr,girlr;
    private String B1,B2,B3,B4,B5,B6,B7,B8;
    private String G1,G2,G3,G4,G5,G6,G7,G8;
    private String mwords ="";
    private double V1,V2,V3,V4,V5,V6,V7,V8;
    public static Spinner spmale,spfemale;

    TextView T0,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10;
    TextView BT0,BT1,BT2,BT3,BT4,BT5,BT6,BT7,BT8;
    TextView GT0,GT1,GT2,GT3,GT4,GT5,GT6,GT7,GT8;
    TextView MT0,MT1,MT2,MT3,MT4,MT5,MT6,MT7,MT8;
    TextView ST0,ST1,ST2,ST3,ST4,ST5,ST6,ST7,ST8;
    TextView TOTALT,TOTALM,TOTALS,TRESULT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matchmaking);
        dboper=new DBOperation();

        imageback = (LinearLayout)findViewById(R.id.linearlayout1);
        spmale = (Spinner) findViewById(R.id.spinner1);
        spfemale = (Spinner) findViewById(R.id.spinner2);
        matchbutton = (ImageButton) findViewById(R.id.button1);

        T9=(TextView)findViewById(R.id.textView2);
        T10=(TextView)findViewById(R.id.textView3);

        T0=(TextView)findViewById(R.id.TextView01);
        T1=(TextView)findViewById(R.id.TextView06);
        T2=(TextView)findViewById(R.id.TextView11);
        T3=(TextView)findViewById(R.id.TextView16);
        T4=(TextView)findViewById(R.id.TextView21);
        T5=(TextView)findViewById(R.id.TextView26);
        T6=(TextView)findViewById(R.id.TextView31);
        T7=(TextView)findViewById(R.id.TextView36);
        T8=(TextView)findViewById(R.id.TextView41);

        BT0=(TextView)findViewById(R.id.TextView02);
        BT1=(TextView)findViewById(R.id.TextView07);
        BT2=(TextView)findViewById(R.id.TextView12);
        BT3=(TextView)findViewById(R.id.TextView17);
        BT4=(TextView)findViewById(R.id.TextView22);
        BT5=(TextView)findViewById(R.id.TextView27);
        BT6=(TextView)findViewById(R.id.TextView32);
        BT7=(TextView)findViewById(R.id.TextView37);
        BT8=(TextView)findViewById(R.id.TextView42);

        GT0=(TextView)findViewById(R.id.TextView03);
        GT1=(TextView)findViewById(R.id.TextView08);
        GT2=(TextView)findViewById(R.id.TextView13);
        GT3=(TextView)findViewById(R.id.TextView18);
        GT4=(TextView)findViewById(R.id.TextView23);
        GT5=(TextView)findViewById(R.id.TextView28);
        GT6=(TextView)findViewById(R.id.TextView33);
        GT7=(TextView)findViewById(R.id.TextView38);
        GT8=(TextView)findViewById(R.id.TextView43);

        MT0=(TextView)findViewById(R.id.TextView04);
        MT1=(TextView)findViewById(R.id.TextView09);
        MT2=(TextView)findViewById(R.id.TextView14);
        MT3=(TextView)findViewById(R.id.TextView19);
        MT4=(TextView)findViewById(R.id.TextView24);
        MT5=(TextView)findViewById(R.id.TextView29);
        MT6=(TextView)findViewById(R.id.TextView34);
        MT7=(TextView)findViewById(R.id.TextView39);
        MT8=(TextView)findViewById(R.id.TextView44);

        ST0=(TextView)findViewById(R.id.TextView05);
        ST1=(TextView)findViewById(R.id.TextView10);
        ST2=(TextView)findViewById(R.id.TextView15);
        ST3=(TextView)findViewById(R.id.TextView20);
        ST4=(TextView)findViewById(R.id.TextView25);
        ST5=(TextView)findViewById(R.id.TextView30);
        ST6=(TextView)findViewById(R.id.TextView35);
        ST7=(TextView)findViewById(R.id.TextView40);
        ST8=(TextView)findViewById(R.id.TextView45);

        TOTALT=(TextView)findViewById(R.id.TextView48);
        TOTALM=(TextView)findViewById(R.id.TextView49);
        TOTALS=(TextView)findViewById(R.id.TextView50);
        TRESULT=(TextView)findViewById(R.id.textView1);

        Drawable  backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);

        if(Public_veriable.FEN==0){
            mwords="Kshatriya Baisya Sudra Bipra Chatuspada Dwipad Jala Kit Manu Ashwa Elephant Aja Sarpa Swan Marjar Musaka Gau Buffalo Byaghra Mriga Banar Nakula Nar Lion Dewa Rakchasa Adya Antya Madhya Preta Agnikunda Kamal Kalash Kak Shila Mayur Dola Hansa Kachchhapa Mula Sayan Aadhak Brikha Bhadrapitha Balaba Chakra Mekha";
        }else{    //   0       1      2     3      4        5     6    7   8     9     10      11   12    13   14     15    16   17      18      19     20  21    22   23   24   25       26   27    28     29    30         31    32    33  34    35    36   37    38         39   40    41    42      43           44     45    46
            mwords="IfqLo j}Zo z'b| ljk| rtÚikb låkb hn ls^ dgÚ cZj uh ch ;k{ Zjfg dfh{f/ d'ifs uf} dlxif Jof# d[u jfg/ gsÚn g/ l;+x b]j /fIf; cfB cGTo dWo k]|t clUgsÚ+* sdn snz sfs lznf doÚ/ bf]n x+; sR%k d'n zog cf(s j[if eb|kL& afna rqm d]v";
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
            T0.setTypeface(tf);T1.setTypeface(tf);T2.setTypeface(tf);T3.setTypeface(tf);T4.setTypeface(tf);T5.setTypeface(tf);T6.setTypeface(tf);T7.setTypeface(tf);T8.setTypeface(tf);
            BT0.setTypeface(tf);BT1.setTypeface(tf);BT2.setTypeface(tf);BT3.setTypeface(tf);BT4.setTypeface(tf);BT5.setTypeface(tf);BT6.setTypeface(tf);BT7.setTypeface(tf);BT8.setTypeface(tf);
            GT0.setTypeface(tf);GT1.setTypeface(tf);GT2.setTypeface(tf);GT3.setTypeface(tf);GT4.setTypeface(tf);GT5.setTypeface(tf);GT6.setTypeface(tf);GT7.setTypeface(tf);GT8.setTypeface(tf);
            MT0.setTypeface(tf);MT1.setTypeface(tf);MT2.setTypeface(tf);MT3.setTypeface(tf);MT4.setTypeface(tf);MT5.setTypeface(tf);MT6.setTypeface(tf);MT7.setTypeface(tf);MT8.setTypeface(tf);
            ST0.setTypeface(tf);ST1.setTypeface(tf);ST2.setTypeface(tf);ST3.setTypeface(tf);ST4.setTypeface(tf);ST5.setTypeface(tf);ST6.setTypeface(tf);ST7.setTypeface(tf);ST8.setTypeface(tf);
            TOTALT.setTypeface(tf);TOTALM.setTypeface(tf);TOTALS.setTypeface(tf);TRESULT.setTypeface(tf);
          //  matchbutton.setTypeface(tf);
            T9.setTypeface(tf);T10.setTypeface(tf);
            //show nepali text
            TOTALT.setText("hDdf");T9.setText("s]^fsf] gfd %fGgú;");T10.setText("s]^Lsf] gfd %fGgú;");

            T0.setText(";dúx");T1.setText("j)f{");T2.setText("jZo"); T3.setText("tf/f lbg"); T4.setText("of]lg");
            T5.setText("u|x d}qL");T6.setText("u)f");T7.setText("esÚ^"); T8.setText("gf*L");
            BT0.setText("s]^f");GT0.setText("s]^L");MT0.setText("clwstd c+s");ST0.setText("c+s");
          //  matchbutton.setText("sÚ^ldnfgsf] a:tÚlylt");
        }
        load_Client_name();
        spmale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                maleid=pos;
            }
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        spfemale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                femaleid=pos;
            }
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        matchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dowork();
            }});

    }
    private <ViewGroup> void load_Client_name(){

        if(Public_veriable.clientlist.length()>0){
            String[] list =Public_veriable.clientlist.split(",");
            ArrayAdapter<String> adapterclient = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list)
            {
                public View getView(int position, View convertView, android.view.ViewGroup parent) {

                    Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/HIMALI.otf");
                    if(Public_veriable.FEN==0){font = Typeface.DEFAULT;}
                    TextView v = (TextView) super.getView(position, convertView, parent);
                    v.setTypeface(font);
                    v.setTextColor(Color.BLUE);
                    return v;
                }

                public View getDropDownView(int position, View convertView, android.view.ViewGroup parent) {
                    TextView v = (TextView) super.getView(position, convertView, parent);
                    Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/HIMALI.otf");
                    if(Public_veriable.FEN==0){font = Typeface.DEFAULT;}
                    v.setTypeface(font);
                    v.setTextColor(Color.BLUE);
                    return v;
                }
            };
            spmale.setAdapter(adapterclient);
            spfemale.setAdapter(adapterclient);}
    }
    int get_vern_val(String Vt) {
        int vv =0;
        String[] mtext = mwords.split(" ");
        if(Vt.equalsIgnoreCase(mtext[0])){vv=3;}
        if(Vt.equalsIgnoreCase(mtext[1])){vv=2;}
        if(Vt.equalsIgnoreCase(mtext[2])){vv=1;}
        if(Vt.equalsIgnoreCase(mtext[3])){vv=4;}
        return vv;
    }
    double get_vasya_val(String BV,String GV) {
        double vv =0;
        String[] mtext = mwords.split(" ");
        if( BV.equalsIgnoreCase (GV)){vv=2;} else{
            if(BV.equalsIgnoreCase(mtext[4])||BV.equalsIgnoreCase(mtext[6])){if(GV.equalsIgnoreCase(mtext[5])||GV.equalsIgnoreCase(mtext[8])){vv=0.5;}else{vv=2;}}
            if(BV.equalsIgnoreCase(mtext[7])){if(GV.equalsIgnoreCase(mtext[5])||GV.equalsIgnoreCase(mtext[8])){vv=1;}else{vv=2;}}
            if(BV.equalsIgnoreCase(mtext[5])){
                if(GV.equalsIgnoreCase(mtext[4])){vv=0.5;}
                if(GV.equalsIgnoreCase(mtext[6])){vv=0.5;}
                if(GV.equalsIgnoreCase(mtext[7])){vv=1;}
                if(GV.equalsIgnoreCase(mtext[8])){vv=2;}
            }
            if(BV.equalsIgnoreCase(mtext[8])){
                if(GV.equalsIgnoreCase(mtext[4])){vv=0.5;}
                if(GV.equalsIgnoreCase(mtext[6])){vv=0.5;}
                if(GV.equalsIgnoreCase(mtext[7])){vv=1;}
                if(GV.equalsIgnoreCase(mtext[5])){vv=2;}
            }
        }
        return vv;
    }
    double get_Gan_val(String BV,String GV) {
        double vv =0;//22 nar 24 dev 25 rakchas
        String[] mtext = mwords.split(" ");
        if( BV.equalsIgnoreCase (GV)){vv=6;} else{
            if(BV.equalsIgnoreCase(mtext[24])&& GV.equalsIgnoreCase(mtext[22])){vv=6;}
            if(BV.equalsIgnoreCase(mtext[24])&& GV.equalsIgnoreCase(mtext[25])){vv=0;}
            if(BV.equalsIgnoreCase(mtext[22])&& GV.equalsIgnoreCase(mtext[24])){vv=5;}
            if(BV.equalsIgnoreCase(mtext[22])&& GV.equalsIgnoreCase(mtext[25])){vv=0;}
            if(BV.equalsIgnoreCase(mtext[25])&& GV.equalsIgnoreCase(mtext[24])){vv=1;}
            if(BV.equalsIgnoreCase(mtext[25])&& GV.equalsIgnoreCase(mtext[22])){vv=0;}
        }
        return vv;
    }
    double get_Tara_val(int BV,int GV) {
        double vv =0;
        int bnv = GV-BV+1;
        if(bnv<0){bnv=bnv+27;}
        int gnv =29-bnv;
        int bs=bnv%9;
        int gs=gnv%9;
        if(bs==1||bs==2||bs==4||bs==6||bs==8||bs==0){
            if(gs==1||gs==2||gs==4||gs==6||gs==8||gs==0){vv=3;}else{vv=1.5;}}else{
            if(gs==3||gs==5||gs==7){vv=0;}else{vv=1.5;}
        }
        return vv;
    }
    double get_Bhakut_val(int bs,int gs) {
        double vv =0;
        if(bs==1){if(gs==1||gs==3||gs==4||gs==7||gs==10||gs==11){vv=7;}else{vv=0;}}
        if(bs==2){if(gs==2||gs==4||gs==5||gs==8||gs==11||gs==12){vv=7;}else{vv=0;}}
        if(bs==3){if(gs==1||gs==3||gs==5||gs==6||gs==9||gs==12){vv=7;}else{vv=0;}}
        if(bs==4){if(gs==1||gs==2||gs==4||gs==6||gs==7||gs==10){vv=7;}else{vv=0;}}//
        if(bs==5){if(gs==2||gs==3||gs==5||gs==7||gs==8||gs==11){vv=7;}else{vv=0;}}
        if(bs==6){if(gs==3||gs==4||gs==6||gs==8||gs==9||gs==12){vv=7;}else{vv=0;}}
        if(bs==7){if(gs==1||gs==4||gs==5||gs==7||gs==9||gs==10){vv=7;}else{vv=0;}}
        if(bs==8){if(gs==2||gs==5||gs==6||gs==8||gs==10||gs==11){vv=7;}else{vv=0;}}
        if(bs==9){if(gs==3||gs==6||gs==7||gs==9||gs==11||gs==12){vv=7;}else{vv=0;}}
        if(bs==10){if(gs==1||gs==4||gs==10||gs==7||gs==8||gs==12){vv=7;}else{vv=0;}}
        if(bs==11){if(gs==1||gs==2||gs==5||gs==8||gs==9||gs==11){vv=7;}else{vv=0;}}
        if(bs==12){if(gs==2||gs==3||gs==6||gs==9||gs==10||gs==12){vv=7;}else{vv=0;}}

        return vv;
    }
    double get_Grahmaitri_val(int boyr,int girlr) {
        double vv =0;
        if( boyr == 5 ){
            if( girlr == 3 || girlr == 6 ){ vv=4;}
            if( girlr == 2 || girlr == 7 ){ vv=0;}
            if( girlr == 10 || girlr == 11 ){ vv=0;}
            if( girlr == 5 || girlr == 4 ){ vv=5;}
            if( girlr == 1 || girlr == 8 ){ vv=5;}
            if( girlr == 9 || girlr == 12 ){ vv=5;}
        }
        if( boyr == 4 ){
            if( girlr == 5 || girlr == 4 ){ vv=5;}
            if( girlr == 1 || girlr == 8 ){ vv=4;}
            if( girlr == 9 || girlr == 12 ){ vv=4;}
            if( girlr == 3 || girlr == 6 ){ vv=1;}
            if( girlr == 2 || girlr == 7 ){ vv=0.5;}
            if( girlr == 10 || girlr == 11 ){ vv=0.5;}
        }

        if( boyr == 1 || boyr == 8 ){
            if( girlr == 5 ){ vv=5;}
            if( girlr == 4 ){ vv=4;}
            if( girlr == 1 || girlr == 8 ){ vv=5;}
            if( girlr == 9 || girlr == 12 ){ vv=5;}
            if( girlr == 3 || girlr == 6 ){ vv=0.5;}
            if( girlr == 2 || girlr == 7 ){ vv=3;}
            if( girlr == 10 || girlr == 11 ){ vv=0.5;}
        }

        if( boyr == 9 || boyr == 12 ){
            if( girlr == 5 ){ vv=5;}
            if( girlr == 4 ){ vv=4;}
            if( girlr == 1 || girlr == 8 ){ vv=5;}
            if( girlr == 9 || girlr == 12 ){ vv=5;}
            if( girlr == 3 || girlr == 6 ){ vv=0.5;}
            if( girlr == 2 || girlr == 7 ){ vv=0.5;}
            if( girlr == 10 || girlr == 11 ){ vv=3;}
        }
        if( boyr == 3 || boyr == 6 ){
            if( girlr == 5 ){ vv=4;}
            if( girlr == 4 ){ vv=1;}
            if( girlr == 1 || girlr == 8 ){ vv=0.5;}
            if( girlr == 9 || girlr == 12 ){ vv=0.5;}
            if( girlr == 3 || girlr == 6 ){ vv=5;}
            if( girlr == 2 || girlr == 7 ){ vv=5;}
            if( girlr == 10 || girlr == 11 ){ vv=4;}
        }

        if( boyr == 2 || boyr == 7 ){
            if( girlr == 5 ){ vv=0;}
            if( girlr == 4 ){ vv=0.5;}
            if( girlr == 1 || girlr == 8 ){ vv=3;}
            if( girlr == 9 || girlr == 12 ){ vv=0.5;}
            if( girlr == 3 || girlr == 6 ){ vv=5;}
            if( girlr == 2 || girlr == 7 ){ vv=5;}
            if( girlr == 10 || girlr == 11 ){ vv=5;}
        }

        if( boyr == 10 || boyr == 11 ){
            if( girlr == 5 ){ vv=0;}
            if( girlr == 4 ){ vv=0.5;}
            if( girlr == 1 || girlr == 8 ){ vv=0.5;}
            if( girlr == 9 || girlr == 12 ){ vv=3;}
            if( girlr == 3 || girlr == 6 ){ vv=4;}
            if( girlr == 2 || girlr == 7 ){ vv=5;}
            if( girlr == 10 || girlr == 11 ){ vv=5;}
        }

        return vv;
    }
    double get_yoni_val(int Boyn,int Girln) {
        int Yoni =0;

        if( (Boyn == 1 || Boyn == 24) && (Girln == 1 || Girln == 24) ){ Yoni=4;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 13 || Girln == 15) ){ Yoni=1;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 23 || Girln == 25) ){ Yoni=1;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 17 || Girln == 18) ){ Yoni=3;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 14 || Girln == 16) ){ Yoni=1;}
        if( (Boyn == 1 || Boyn == 24) && (Girln == 12 || Girln == 26) ){ Yoni=3;}

        if( (Boyn == 13 || Boyn == 15) && (Girln == 1 || Girln == 24) ){ Yoni=1;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 13 || Girln == 15) ){ Yoni=4;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 23 || Girln == 25) ){ Yoni=3;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 2 || Girln == 27) ){ Yoni=3;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 14 || Girln == 16) ){ Yoni=1;}
        if( (Boyn == 13 || Boyn == 15) && (Girln == 12 || Girln == 26) ){ Yoni=3;}


        if( (Boyn == 23 || Boyn == 25) && (Girln == 1 || Girln == 24) ){ Yoni=1;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 13 || Girln == 15) ){ Yoni=3;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 23 || Girln == 25) ){ Yoni=4;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 2 || Girln == 27) ){ Yoni=0;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 3 || Girln == 8) ){ Yoni=1;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 20 || Girln == 22) ){ Yoni=3;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 4 || Girln == 5) ){ Yoni=1;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 6 || Girln == 19) ){ Yoni=1;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 10 || Girln == 11) ){ Yoni=1;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 14 || Girln == 16) ){ Yoni=2;}
        if( (Boyn == 23 || Boyn == 25) && (Girln == 12 || Girln == 26) ){ Yoni=1;}


        if( (Boyn == 2 || Boyn == 27) && (Girln == 1 || Girln == 24) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 13 || Girln == 15) ){ Yoni=3;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 23 || Girln == 25) ){ Yoni=0;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 2 || Girln == 27) ){ Yoni=4;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 20 || Girln == 22) ){ Yoni=3;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 14 || Girln == 16) ){ Yoni=2;}
        if( (Boyn == 2 || Boyn == 27) && (Girln == 12 || Girln == 26) ){ Yoni=2;}


        if( (Boyn == 3 || Boyn == 8) && (Girln == 1 || Girln == 24) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 13 || Girln == 15) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 23 || Girln == 25) ){ Yoni=1;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 2 || Girln == 27) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 3 || Girln == 8) ){ Yoni=4;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 20 || Girln == 22) ){ Yoni=0;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 21) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 4 || Girln == 5) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 17 || Girln == 18) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 7 || Girln == 9) ){ Yoni=3;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 14 || Girln == 16) ){ Yoni=1;}
        if( (Boyn == 3 || Boyn == 8) && (Girln == 12 || Girln == 26) ){ Yoni=3;}

        if( (Boyn == 20 || Boyn == 22) && (Girln == 1 || Girln == 24) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 23 || Girln == 25) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 3 || Girln == 8) ){ Yoni=0;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 20 || Girln == 22) ){ Yoni=4;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 14 || Girln == 16) ){ Yoni=1;}
        if( (Boyn == 20 || Boyn == 22) && (Girln == 12 || Girln == 26) ){ Yoni=2;}

        if( (Boyn == 21) && (Girln == 1 || Girln == 24) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 23 || Girln == 25) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 21) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 21) ){ Yoni=4;}
        if( (Boyn == 21) && (Girln == 4 || Girln == 5) ){ Yoni=0;}
        if( (Boyn == 21) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 14 || Girln == 16) ){ Yoni=2;}
        if( (Boyn == 21) && (Girln == 12 || Girln == 26) ){ Yoni=3;}

        if( (Boyn == 4 || Boyn == 5) && (Girln == 1 || Girln == 24) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 23 || Girln == 25) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 21) ){ Yoni=0;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 4 || Girln == 5) ){ Yoni=4;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 10 || Girln == 11) ){ Yoni=1;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 14 || Girln == 16) ){ Yoni=2;}
        if( (Boyn == 4 || Boyn == 5) && (Girln == 12 || Girln == 26) ){ Yoni=1;}

        if( (Boyn == 17 || Boyn == 18) && (Girln == 1 || Girln == 24) ){ Yoni=3;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 23 || Girln == 25) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 17 || Girln == 18) ){ Yoni=4;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 6 || Girln == 19) ){ Yoni=0;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 14 || Girln == 16) ){ Yoni=2;}
        if( (Boyn == 17 || Boyn == 18) && (Girln == 12 || Girln == 26) ){ Yoni=3;}

        if( (Boyn == 6 || Boyn == 19) && (Girln == 1 || Girln == 24) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 23 || Girln == 25) ){ Yoni=1;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 3 || Girln == 8) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 17 || Girln == 18) ){ Yoni=0;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 6 || Girln == 19) ){ Yoni=4;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 7 || Girln == 9) ){ Yoni=1;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 10 || Girln == 11) ){ Yoni=1;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 14 || Girln == 16) ){ Yoni=1;}
        if( (Boyn == 6 || Boyn == 19) && (Girln == 12 || Girln == 26) ){ Yoni=2;}


        if( (Boyn == 7 || Boyn == 9) && (Girln == 1 || Girln == 24) ){ Yoni=3;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 23 || Girln == 25) ){ Yoni=2;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 2 || Girln == 27) ){ Yoni=3;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 6 || Girln == 19) ){ Yoni=1;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 7 || Girln == 9) ){ Yoni=4;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 10 || Girln == 11) ){ Yoni=0;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 14 || Girln == 16) ){ Yoni=1;}
        if( (Boyn == 7 || Boyn == 9) && (Girln == 12 || Girln == 26) ){ Yoni=2;}


        if( (Boyn == 10 || Boyn == 11) && (Girln == 1 || Girln == 24) ){ Yoni=3;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 13 || Girln == 15) ){ Yoni=2;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 23 || Girln == 25) ){ Yoni=1;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 2 || Girln == 27) ){ Yoni=3;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 3 || Girln == 8) ){ Yoni=1;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 4 || Girln == 5) ){ Yoni=1;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 17 || Girln == 18) ){ Yoni=2;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 6 || Girln == 19) ){ Yoni=1;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 7 || Girln == 9) ){ Yoni=0;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 10 || Girln == 11) ){ Yoni=4;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 14 || Girln == 16) ){ Yoni=2;}
        if( (Boyn == 10 || Boyn == 11) && (Girln == 12 || Girln == 26) ){ Yoni=2;}

        if( (Boyn == 14 || Boyn == 16) && (Girln == 1 || Girln == 24) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 13 || Girln == 15) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 23 || Girln == 25) ){ Yoni=2;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 2 || Girln == 27) ){ Yoni=2;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 3 || Girln == 8) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 20 || Girln == 22) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 21) ){ Yoni=2;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 4 || Girln == 5) ){ Yoni=2;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 17 || Girln == 18) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 6 || Girln == 19) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 7 || Girln == 9) ){ Yoni=1;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 14 || Girln == 16) ){ Yoni=4;}
        if( (Boyn == 14 || Boyn == 16) && (Girln == 12 || Girln == 26) ){ Yoni=0;}

        if( (Boyn == 12 || Boyn == 26) && (Girln == 1 || Girln == 24) ){ Yoni=3;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 13 || Girln == 15) ){ Yoni=3;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 23 || Girln == 25) ){ Yoni=1;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 2 || Girln == 27) ){ Yoni=3;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 3 || Girln == 8) ){ Yoni=3;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 20 || Girln == 22) ){ Yoni=2;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 21) ){ Yoni=3;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 4 || Girln == 5) ){ Yoni=1;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 17 || Girln == 18) ){ Yoni=3;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 6 || Girln == 19) ){ Yoni=2;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 7 || Girln == 9) ){ Yoni=2;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 10 || Girln == 11) ){ Yoni=2;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 14 || Girln == 16) ){ Yoni=0;}
        if( (Boyn == 12 || Boyn == 26) && (Girln == 12 || Girln == 26) ){ Yoni=4;}

        return Yoni;
    }

    int findmangalic(double mv,int lv){
        int mang=0;
        int lv1 =lv+3;if(lv1>12){lv1=lv1-12;}
        int lv2 =lv+6;if(lv2>12){lv2=lv2-12;}
        int lv3 =lv+7;if(lv3>12){lv3=lv3-12;}
        int lv4 =lv+11;if(lv4>12){lv4=lv4-12;}
        int mv1=(int) (mv%30);if(mv1>0){mv1=(int) (mv/30+1);}else{mv1=(int) (mv/30);}
        if(mv1==lv||mv1==lv1||mv1==lv2||mv1==lv3||mv1==lv4){mang=1;}else{mang=0;}

        return mang;
    }
    void dowork(){
        getopt = new option();
        getnm=new name_others();
        if (maleid>=0 &&femaleid>=0 ) 	{
            //preparing male kundali
            Public_veriable.Clientno=maleid;
            dboper.getClient();
            Public_veriable.EN = Public_veriable.datemod == 0;
            Public_veriable.Prepare_Kundali();
            Ssidhanta=new SuryaSiddhanta();
            Ssidhanta.Getstarted();
            getopt.Abkahadachakra();
            //save required detail
            boyr=(int) (SuryaSiddhanta.pastchandra /30+1);
            boyn= SuryaSiddhanta.GatNakchatra;
            B1=getopt.A4;//varn
            B2=getopt.A5;//vasya
            B3=getnm.TARA(boyn);
            B4=getopt.A5;//yoni
            B5=getnm.Rashiswami(boyr);
            B6=getopt.A8;//gan
            B7=boyr+"";
            B8=getopt.A9;//nadi
            int mangb = findmangalic(SuryaSiddhanta.pastmangal,(int) SuryaSiddhanta.Eastrasi +1);
            //preparing Female kundali
            Public_veriable.Clientno=femaleid;
            dboper.getClient();
            Public_veriable.EN = Public_veriable.datemod == 0;
            Public_veriable.Prepare_Kundali();
            Ssidhanta=new SuryaSiddhanta();
            Ssidhanta.Getstarted();
            getopt.Abkahadachakra();
            //save required detail
            girlr=(int) (SuryaSiddhanta.pastchandra /30+1);
            girln= SuryaSiddhanta.GatNakchatra;
            G1=getopt.A4;//varn
            G2=getopt.A5;//vasya
            G3=getnm.TARA(girln);
            G4=getopt.A5;//yoni
            G5=getnm.Rashiswami(girlr);
            G6=getopt.A8;//gan
            G7=girlr+"";
            G8=getopt.A9;//nadi
            int mangg = findmangalic(SuryaSiddhanta.pastmangal,(int) SuryaSiddhanta.Eastrasi +1);
            // Start Match making now
            if(get_vern_val(B1)>=get_vern_val(G1))
            {V1=1;}else{V1=0;}
            V2=get_vasya_val(B2,G2);
            V3=get_Tara_val(boyn,girln);
            V4=get_yoni_val(boyn,girln);
            V5=get_Grahmaitri_val(boyr,girlr);
            V6=get_Gan_val(B6,G6);
            V7=get_Bhakut_val(boyr,girlr);
            if( B8.equalsIgnoreCase (G8)){V8=0;} else{V8=8;}
            // Display the value
            ST1.setText(V1+"");
            ST2.setText(V2+"");
            ST3.setText(V3+"");
            ST4.setText(V4+"");
            ST5.setText(V5+"");
            ST6.setText(V6+"");
            ST7.setText(V7+"");
            ST8.setText(V8+"");
            double gt=(V8+V7+V6+V5+V4+V3+V2+V1);
            TOTALS.setText(gt+"");

            BT1.setText(B1);
            BT2.setText(B2);
            BT3.setText(B3);
            BT4.setText(B4);
            BT5.setText(B5);
            BT6.setText(B6);
            BT7.setText(B7);
            BT8.setText(B8);

            GT1.setText(G1);
            GT2.setText(G2);
            GT3.setText(G3);
            GT4.setText(G4);
            GT5.setText(G5);
            GT6.setText(G6);
            GT7.setText(G7);
            GT8.setText(G8);
            String getfal="";
            if(Public_veriable.FEN==0){
                getfal="Result on Match making"+"\n"+"\n";
                if (gt>=18){getfal= getfal+"Match making score calculated good hence there is no problem for future relation."+"\n"+"\n";}else{
                    getfal= getfal+"Match making score calculated as less than the minimum hence it seems not a good relation exist."+"\n"+"\n";
                }
                getfal=getfal+"Result on Mangalik issue"+"\n"+"\n";
                if(mangb==mangg) {
                    if(mangb==1){getfal=getfal+"Both Boy and Girl kundali has Mangalik issue hence there is no issue.";}
                    if(mangb==0){getfal=getfal+"Both Boy and Girl kundali does not has Mangalik issue hence there is no issue.";}
                }else{
                    if(mangb==0){getfal=getfal+"Boy is manglic free but Girl's kundali has Manglik hence it is suggested to go for Good astrologer guidence.";}
                    if(mangb==1){getfal=getfal+"Girl is manglic free but Boy's kundali has Manglik hence it is suggested to go for Good astrologer guidence.";}

                }

            }else{
                getfal="d]nfks ;fl/)fL ljrf/"+"\n"+"\n";
                if (gt>=18){getfal= getfal+"s'^ ldnfgsf] :sf]/ /fd|f] ePsf]n] ljjfxdf s'g} afwf kg]{ b]lvb}g."+"\n"+"\n";}else{
                    getfal= getfal+"s'^ ldnfgsf] :sf]/ ;fwf/)feGbf klg sd % ."+ "cyf{t\" 18 u')f eGbf sd ePsf]n] of] ljjfx pko'Qm b]lvb}g"+"\n"+"\n";
                }
                getfal=getfal+"df+ulns bf]if ljrf/"+"\n"+"\n";
                if(mangb==mangg) {
                    if(mangb==1){getfal=getfal+"s]^f / s]^L b'j}df df+ulns bf]if ePsf]n] df+ulns bf]ifsf sf/)f ljjfxdf s'g} afwf %}g";}
                    if(mangb==0){getfal=getfal+"s]^f / s]^L b'j}df df+ulns bf]if gePsf]n] df+ulns bf]ifsf sf/)f ljjfxdf s'g} afwf %}g";}
                }else{
                    if(mangb==0){getfal=getfal+"s]^fdf df+ulns bf]if %}g t/ s]^Ldf df+ulns bf]if ePsf]n] /fd|f] Hof]ltifLsf] ;Nnfx lnP/ dfq ljjfx ug'{ plrt x'g]% ";}
                    if(mangb==1){getfal=getfal+"s]^fdf df+ulns bf]if % t/ s]^Ldf df+ulns bf]if %}g . ctM ljjfxdf s]xL afwf b]lvPsf]n] /fd|f] Hof]ltifLsf] ;Nnfx lng' plrt x'g]%";}

                }
            }
            TRESULT.setMovementMethod(new ScrollingMovementMethod());
            TRESULT.setText(getfal);
        }
    }

}
