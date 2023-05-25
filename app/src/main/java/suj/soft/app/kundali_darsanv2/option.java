package suj.soft.app.kundali_darsanv2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class option extends Activity{
    private name_others Fname;
    private displayformat mformat;
    private static DBOperation dboper=null;
    int Lagna,OLagna,OLagna1,OLagna2,OLagna3,OLagna4,OLagna5,OLagna6,OLagna7,OLagna8,OLagna9,OLagna10,OLagna11;
    int Ktype;
    private TextView AB1,AB2,AB3,AB4,AB5,AB6,AB7,AB8,AB9,AB10;
    private TextView OB1,OB2,OB3,OB4,OB5,OB6,OB7,OB8,OB9,OB10;
    private TextView GC1,GC2,GC3,GC4,GC5,GC6,GC7;

    private TextView S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,S16,S17,S18,S19,S20,S21,S22,S23,S24,S25,S26,S27,S28,S29;

    public String A3 ="";
    public String A4 ="";
    public String A5 ="";
    public String A6 ="";
    public String A7 ="";
    public String A8 ="";
    public String A9 ="";
    public String A10 ="";
    public String A11 ="";
    public String A12 ="";
    public int Nakno=0;
    public int Npau=0;

    private String mwords ="";
    private String varga="";
    private Spinner spinnerM;
    public static ArrayAdapter <CharSequence> adapterM ;
    private Spinner spinnerD;
    public static ArrayAdapter <CharSequence> adapterD ;

    ImageButton vkud,vdasa,vfalit,vgrah;
    LinearLayout imageback;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

        imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable  backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);

        GC1 = (TextView)findViewById(R.id.textView23);GC2 = (TextView)findViewById(R.id.textView25);
        GC3 = (TextView)findViewById(R.id.textView27);GC4 = (TextView)findViewById(R.id.textView29);
        GC5 = (TextView)findViewById(R.id.textView31);GC6 = (TextView)findViewById(R.id.textView33);
        GC7 = (TextView)findViewById(R.id.textView35);

        AB1 = (TextView)findViewById(R.id.textView38);AB2 = (TextView)findViewById(R.id.textView40);
        AB3 = (TextView)findViewById(R.id.textView42);AB4 = (TextView)findViewById(R.id.textView44);
        AB5 = (TextView)findViewById(R.id.textView46);AB6 = (TextView)findViewById(R.id.textView48);
        AB7 = (TextView)findViewById(R.id.textView50);AB8 = (TextView)findViewById(R.id.textView52);
        AB9 = (TextView)findViewById(R.id.textView54);AB10 = (TextView)findViewById(R.id.textView56);

        OB1 = (TextView)findViewById(R.id.textView2);OB2 = (TextView)findViewById(R.id.textView4);
        OB3 = (TextView)findViewById(R.id.textView6);OB4 = (TextView)findViewById(R.id.textView8);
        OB5 = (TextView)findViewById(R.id.textView10);OB6 = (TextView)findViewById(R.id.textView12);
        OB7 = (TextView)findViewById(R.id.textView14);OB8 = (TextView)findViewById(R.id.textView16);
        OB9 = (TextView)findViewById(R.id.textView18);OB10 = (TextView)findViewById(R.id.textView20);

        S1 = (TextView)findViewById(R.id.textView1); S2 = (TextView)findViewById(R.id.textView3);S3 = (TextView)findViewById(R.id.textView5);
        S4 = (TextView)findViewById(R.id.textView7); S5 = (TextView)findViewById(R.id.textView9);S6 = (TextView)findViewById(R.id.textView11);
        S7 = (TextView)findViewById(R.id.textView13); S8 = (TextView)findViewById(R.id.textView15);S9 = (TextView)findViewById(R.id.textView17);
        S10 = (TextView)findViewById(R.id.textView19); S11 = (TextView)findViewById(R.id.textView21);S12 = (TextView)findViewById(R.id.textView22);
        S13 = (TextView)findViewById(R.id.textView24); S14 = (TextView)findViewById(R.id.textView26);S15 = (TextView)findViewById(R.id.textView28);
        S16 = (TextView)findViewById(R.id.textView30); S17 = (TextView)findViewById(R.id.textView32);S18 = (TextView)findViewById(R.id.textView34);
        S19 = (TextView)findViewById(R.id.textView36); S20 = (TextView)findViewById(R.id.textView37);S21 = (TextView)findViewById(R.id.textView39);
        S22 = (TextView)findViewById(R.id.textView41); S23 = (TextView)findViewById(R.id.textView43);S24 = (TextView)findViewById(R.id.textView45);
        S25 = (TextView)findViewById(R.id.textView47); S26 = (TextView)findViewById(R.id.textView49);S27 = (TextView)findViewById(R.id.textView51);
        S28 = (TextView)findViewById(R.id.textView53); S29 = (TextView)findViewById(R.id.textView55);

        vkud = (ImageButton)findViewById(R.id.Button1);
        vdasa = (ImageButton)findViewById(R.id.Button4);

        vfalit = (ImageButton)findViewById(R.id.Button2);
        vgrah = (ImageButton)findViewById(R.id.Button3);

        S11.setBackgroundResource(R.color.leaf_green);
        S19.setBackgroundResource(R.color.leaf_green);

        if(Public_veriable.FEN==1){
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
            GC1.setTypeface(tf); GC2.setTypeface(tf); GC3.setTypeface(tf); GC4.setTypeface(tf); GC5.setTypeface(tf); GC6.setTypeface(tf);
            AB1.setTypeface(tf); AB2.setTypeface(tf); AB3.setTypeface(tf); AB4.setTypeface(tf); AB5.setTypeface(tf); AB6.setTypeface(tf);
            AB7.setTypeface(tf); AB8.setTypeface(tf); AB9.setTypeface(tf); AB10.setTypeface(tf);
            OB1.setTypeface(tf); OB2.setTypeface(tf); OB3.setTypeface(tf); OB4.setTypeface(tf);  OB6.setTypeface(tf);
            OB7.setTypeface(tf); OB8.setTypeface(tf); OB9.setTypeface(tf); OB10.setTypeface(tf);
            if(Public_veriable.Clientcob==147){
                OB5.setTypeface(tf);}//Nepal in nepali font
            S1.setTypeface(tf); S2.setTypeface(tf);S3.setTypeface(tf);S4.setTypeface(tf);S5.setTypeface(tf);S6.setTypeface(tf);S7.setTypeface(tf);
            S8.setTypeface(tf); S9.setTypeface(tf);S10.setTypeface(tf);S11.setTypeface(tf);S12.setTypeface(tf);S13.setTypeface(tf);S14.setTypeface(tf);
            S15.setTypeface(tf); S16.setTypeface(tf);S17.setTypeface(tf);S18.setTypeface(tf);S19.setTypeface(tf);S20.setTypeface(tf);S21.setTypeface(tf);
            S22.setTypeface(tf); S23.setTypeface(tf);S24.setTypeface(tf);S25.setTypeface(tf);S26.setTypeface(tf);S27.setTypeface(tf);S28.setTypeface(tf);
            S29.setTypeface(tf);
            //vkud.setTypeface(tf);  vdasa.setTypeface(tf); vfalit.setTypeface(tf);vgrah.setTypeface(tf);

            //
            S1.setText(" gfd"); S3.setText(" hGdldlt laqmd;+at\\"); S2.setText(" hGdldlt O{=;g\\");
            S4.setText(" hGd;do-Oi^sfn_");S5.setText(" hGd :yfg");S6.setText(" :yfgLo-cIff+z,b]zfGt/_");
            S7.setText(" k|fdfl)fs b]zfGt/");S9.setText(" ;úof{]bo-:yfgLo,k|fdfl)fs_");S8.setText(" ;do ;+:sf/");
            S10.setText(" kIf,ltyL,of]u,s/)f"); S11.setText(" ‘#ftrqm "); S12.setText(" rGb| #ft");
            S13.setText(" gIfq #ft");S14.setText(" af/ #ft");S15.setText(" ltyL #ft");
            S16.setText(" of]u #ft");S17.setText(" s/)f #ft");S18.setText(" nUg #ft");
            S19.setText(" casx*frqm");S20.setText(" /flz");S21.setText(" gIfq");
            S22.setText(" eef]u");S23.setText(" eÚSt");S24.setText(" gIfqkfb");
            S25.setText(" /flz:jfdL");S26.setText(" of]gL,j}/of]gL"); S27.setText(" j)f{ jZo");
            S28.setText(" u)f,gf*L,cfzg"); S29.setText(" ju{,zqÚju{");

            // vkud.setText(" x]g{ú;\\");vdasa.setText(" x]g{ú;\\");vfalit.setText(" ;fwf/)f kmlnt");vgrah.setText(" u|xfj:yf larf/");

        }

        loadspinner_Item();
        loadspinner_Dasa();
        load_basic();
        Public_veriable.FalT=0;
    }
    public void load_basic(){
        Fname= new name_others();
        mformat= new displayformat();
        dboper=new DBOperation();
        Ghatchakra();
        Abkahadachakra();

        AB1.setText(Fname.Rashiname((int)(SuryaSiddhanta.pastchandra/30+1)));
        AB2.setText(Fname.nakchtraname(SuryaSiddhanta.GatNakchatra));
        AB3.setText(mformat.dis_bdms(SuryaSiddhanta.NakBhabog,0));
        AB4.setText(mformat.dis_bdms(SuryaSiddhanta.NakBhukta,0));
        AB5.setText(Npau+"  " +Fname.Adyaakchar(SuryaSiddhanta.GatNakchatra,Npau));
        AB6.setText(A3);
        AB7.setText(A6 + " , " + A7);
        AB8.setText(A4 + " , " + A5);
        AB9.setText(A8 + " , " + A9+ " , " + A10);
        AB10.setText(A11 + " , " + A12);

        if(A8.equals("/fIf;")){Public_veriable.GN = "G03";}
        if(A8.equals("g/")) {Public_veriable.GN = "G02";}
        if(A8.equals("b]j")) {Public_veriable.GN = "G01";}

        OB1.setText(Public_veriable.Clientname);
        if (Public_veriable.EN){
            OB3.setText(Public_veriable.Clientdob + " "+ Fname.dayname(SuryaSiddhanta.Dayno));
            OB2.setText(Public_veriable.Clientdob2);
        }else{
            OB3.setText(Public_veriable.Clientdob2);
            OB2.setText(Public_veriable.Clientdob+ " "+ Fname.dayname(SuryaSiddhanta.Dayno));
        }
        if(Public_veriable.tgp==0){
            OB4.setText(Public_veriable.Clienttob +" , " + mformat.dis_bdms(SuryaSiddhanta.Janmeast* 2.5 / 60,0) );
        }else{
            OB4.setText( mformat.dis_bdms(Public_veriable.newtimecal,0)+" "+ Public_veriable.AMPM +" , " + Public_veriable.Clienttob );
        }
        OB5.setText(dboper.getcountry(Public_veriable.Clientcob) + ","+ dboper.getplace(Public_veriable.Clientpob,Public_veriable.Clientcob));
        OB6.setText(Fname.replaced(Public_veriable.Plat)+","+Fname.replaced(Public_veriable.Plong));
        OB7.setText(Fname.replaced(Public_veriable.Clong));

        OB8.setText(mformat.dis_bdms(Public_veriable.samaydiff ,0));
        OB9.setText(mformat.dis_bdms(SuryaSiddhanta.SuryodayTime,0)+","+mformat.dis_bdms((SuryaSiddhanta.SuryodayTime-Public_veriable.samaydiff),0));

        OB10.setText(Fname.pakcha(SuryaSiddhanta.TodayTith)+ ","+Fname.Tithiname(SuryaSiddhanta.TodayTith)+ ","+Fname.Yogname(SuryaSiddhanta.GatYoga)+","+Fname.Krname(SuryaSiddhanta.KRN));

    }
    public void Ghatchakra(){
        int rno	=(int)(SuryaSiddhanta.pastchandra/30+1);
        switch(rno) {
            case 1:
                GC1.setText(Fname.Rashiname(1));
                GC2.setText(Fname.nakchtraname(10));
                GC3.setText(Fname.dayname(1));
                GC4.setText("1 6 11");
                GC5.setText(Fname.Yogname(1));
                GC6.setText(Fname.Krname(1));
                GC7.setText("1");
                break;
            case 2:
                GC1.setText(Fname.Rashiname(6));
                GC2.setText(Fname.nakchtraname(13));
                GC3.setText(Fname.dayname(7));
                GC4.setText("5 10 15 ");
                GC5.setText(Fname.Yogname(23));
                GC6.setText(Fname.Krname(6));
                GC7.setText("2");

                break;
            case 3:
                GC1.setText(Fname.Rashiname(11));
                GC2.setText(Fname.nakchtraname(15));
                GC3.setText(Fname.dayname(2));
                GC4.setText("2 7 12");
                GC5.setText(Fname.Yogname(19));
                GC6.setText(Fname.Krname(10));
                GC7.setText("4");

                break;
            case 4:
                GC1.setText(Fname.Rashiname(5));
                GC2.setText(Fname.nakchtraname(17));
                GC3.setText(Fname.dayname(4));
                GC4.setText("2 7 12");
                GC5.setText(Fname.Yogname(13));
                GC6.setText(Fname.Krname(7));
                GC7.setText("7");

                break;
            case 5:
                GC1.setText(Fname.Rashiname(10));
                GC2.setText(Fname.nakchtraname(19));
                GC3.setText(Fname.dayname(7));
                GC4.setText("3 8 13");
                GC5.setText(Fname.Yogname(8));
                GC6.setText(Fname.Krname(5));
                GC7.setText("10");

                break;
            case 6:
                GC1.setText(Fname.Rashiname(3));
                GC2.setText(Fname.nakchtraname(22));
                GC3.setText(Fname.dayname(7));
                GC4.setText("5 10 15");
                GC5.setText(Fname.Yogname(9));
                GC6.setText(Fname.Krname(8));
                GC7.setText("12");

                break;
            case 7:
                GC1.setText(Fname.Rashiname(9));
                GC2.setText(Fname.nakchtraname(24));
                GC3.setText(Fname.dayname(5));
                GC4.setText("4 9 14");
                GC5.setText(Fname.Yogname(9));
                GC6.setText(Fname.Krname(9));
                GC7.setText("6");

                break;
            case 8:
                GC1.setText(Fname.Rashiname(2));
                GC2.setText(Fname.nakchtraname(27));
                GC3.setText(Fname.dayname(6));
                GC4.setText("1 6 11");
                GC5.setText(Fname.Yogname(17));
                GC6.setText(Fname.Krname(2));
                GC7.setText("8");

                break;
            case 9:
                GC1.setText(Fname.Rashiname(12));
                GC2.setText(Fname.nakchtraname(2));
                GC3.setText(Fname.dayname(6));
                GC4.setText("3 8 13");
                GC5.setText(Fname.Yogname(18));
                GC6.setText(Fname.Krname(9));
                GC7.setText("9");

                break;
            case 10:
                GC1.setText(Fname.Rashiname(5));
                GC2.setText(Fname.nakchtraname(4));
                GC3.setText(Fname.dayname(3));
                GC4.setText("4 9 14");
                GC5.setText(Fname.Yogname(27));
                GC6.setText(Fname.Krname(6));
                GC7.setText("11");

                break;
            case 11:
                GC1.setText(Fname.Rashiname(9));
                GC2.setText(Fname.nakchtraname(6));
                GC3.setText(Fname.dayname(5));
                GC4.setText("3 8 13");
                GC5.setText(Fname.Yogname(10));
                GC6.setText(Fname.Krname(11));
                GC7.setText("3");

                break;
            case 12:
                GC1.setText(Fname.Rashiname(12));
                GC2.setText(Fname.nakchtraname(9));
                GC3.setText(Fname.dayname(6));
                GC4.setText("5 10 15");
                GC5.setText(Fname.Yogname(18));
                GC6.setText(Fname.Krname(10));
                GC7.setText("5");
                break;

        }
    }

    public void Abkahadachakra(){
        Fname= new name_others();
        if(Public_veriable.FEN==0){
            mwords="Kshatriya Baisya Sudra Bipra Chatuspada Dwipad Jala Kit Manu Ashwa Elephant Aja Sarpa Swan Marjar Musaka Gau Buffalo Byaghra Mriga Banar Nakula Nar Lion Dewa Rakchasa Adya Antya Madhya Preta Agnikunda Kamal Kalash Kak Shila Mayur Dola Hansa Kachchhapa Mula Sayan Aadhak Brikha Bhadrapitha Balaba Chakra Mekha";
            varga="Garuda Sarpa Biralo Muso Lion Mriga Kukura Bhenda";
        }else{    //   0       1      2     3      4           5     6    7  8     9     10      11   12    13   14     15    16   17      18      19     20  21    22   23   24   25       26   27    28     29    30         31    32    33  34    35    36   37    38         39   40    41    42      43           44     45    46
            mwords="IfqLo j}Zo z'b| ljk| rtÚikb låkb hn ls^ dgÚ cZj uh ch ;k{ Zjfg dfh{f/ d'ifs uf} dlxif Jof# d[u jfg/ gsÚn g/ l;+x b]j /fIf; cfB cGTo dWo k]|t clUgsÚ+* sdn snz sfs lznf doÚ/ bf]n x+; sR%k d'n zog cf(s j[if eb|kL& afna rqm d]v";
            varga= "u?* ;k{ dfhf{/ d''ifs l;+x d[u Zjfg d]if";
        }
        Nakno=SuryaSiddhanta.GatNakchatra;
        Npau=SuryaSiddhanta.Npau;
        String[] mtext = mwords.split(" ");
        String[] svarga = varga.split(" ");
        if (Nakno==1){
            A3 	=	Fname.grahname(3);
            A4 	=	mtext[0];
            A5 	=	mtext[4];
            A6 	=	mtext[9];
            A7 	=	mtext[17];
            A8 	=	mtext[24];
            A9 	=	mtext[26];
            A10 =	mtext[9];}
        if (Nakno==	2){
            A3 	=	Fname.grahname(3);
            A4 	=	mtext[0];
            A5 	=	mtext[4];
            A6 	=	mtext[10];
            A7 	=	mtext[23];
            A8 	=	mtext[22];
            A9 	=	mtext[28];
            A10	=	mtext[29];}
        if (Nakno==	3 && Npau==	1){
            A3 	=	Fname.grahname(3);
            A4 	=	mtext[0];
            A5 	=	mtext[4];
            A6 	=	mtext[11];
            A7 	=	mtext[44];
            A8 	=	mtext[25];
            A9 	=	mtext[27];
            A10	=	mtext[30];}
        if (Nakno==	3 && Npau>1){
            A3 	=	Fname.grahname(6);
            A4 	=	mtext[1];
            A5 	=	mtext[4];
            A6 	=	mtext[11];
            A7 	=	mtext[44];
            A8 	=	mtext[25];
            A9 	=	mtext[27];
            A10	=	mtext[30];	}

        if (Nakno==	4){
            A3 	= 	Fname.grahname(6);
            A4 	=	mtext[1];
            A5 	=	mtext[4];
            A6 	=	mtext[12];
            A7 	=	mtext[21];
            A8 	=	mtext[22];
            A9 	=	mtext[27];
            A10	=	mtext[16];}
        if (Nakno==	5 && Npau<3){
            A3 	=	Fname.grahname(6);
            A4 	=	mtext[1];
            A5 	=	mtext[4];
            A6 	=	mtext[12];
            A7 	=	mtext[21];
            A8 	=	mtext[24];
            A9 	=	mtext[28];
            A10	=	mtext[19];	}
        if (Nakno==	5&& Npau>2){
            A3 	=	Fname.grahname(4);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[12];
            A7 	=	mtext[21];
            A8 	=	mtext[24];
            A9 	=	mtext[28];
            A10	=	mtext[19];}
        if (Nakno==	6){
            A3 	=	Fname.grahname(4);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[13];
            A7 	=	mtext[19];
            A8 	=	mtext[22];	}
        if (Nakno==	7 && Npau<4){
            A3 	=	Fname.grahname(4);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[14];
            A7 	=	mtext[15];
            A8 	=	mtext[24];
            A9 	=	mtext[26];
            A10	=	mtext[31];	}
        if (Nakno==7 && Npau==4){
            A3 	=	Fname.grahname(2);
            A4 	=	mtext[3];
            A5 	=	mtext[6];
            A6 	=	mtext[14];
            A7 	=	mtext[15];
            A8 	=	mtext[24];
            A9 	=	mtext[26];
            A10 =	mtext[31];	}
        if (Nakno==	8){
            A3 	=	Fname.grahname(2);
            A4 	=	mtext[3];
            A5 	=	mtext[6];
            A6 	=	mtext[46];
            A7 	=	mtext[22];
            A8 	=	mtext[24];
            A9 	=	mtext[28];
            A10	= 	mtext[32];	}
        if (Nakno==	9){
            A3 	=	Fname.grahname(2);
            A4 	=	mtext[3];
            A5 	=	mtext[6];
            A6 	=	mtext[14];
            A7 	=	mtext[15];
            A8 	=	mtext[25];
            A9 	=	mtext[27];
            A10 =	mtext[33];	}
        if (Nakno==	10){
            A3 	=	Fname.grahname(1);
            A4 	=	mtext[0];
            A5 	=	mtext[4];
            A6 	=	mtext[15];
            A7 	=	mtext[14];
            A8 	=	mtext[25];
            A9 	=	mtext[27];
            A10 =	mtext[17];		}
        if (Nakno==	11){
            A3 	=	Fname.grahname(1);
            A4 	=	mtext[0];
            A5 	=	mtext[4];
            A6 	=	mtext[15];
            A7 	=	mtext[14];
            A8 	=	mtext[22];
            A9 	=	mtext[28];
            A10	=	mtext[34];	}
        if (Nakno==	12 && Npau==1){
            A3 	=	Fname.grahname(1);
            A4 	=	mtext[0];
            A5 	=	mtext[4];
            A6 	=	mtext[16];
            A7 	=	mtext[18];
            A8 	=	mtext[22];
            A9 	=	mtext[26];
            A10	=	mtext[34];	}
        if (Nakno==	12 && Npau>1){
            A3 	=	Fname.grahname(4);
            A4 	=	mtext[1];
            A5 	=	mtext[5];
            A6 	=	mtext[16];
            A7 	=	mtext[18];
            A8 	=	mtext[22];
            A9 	=	mtext[26];
            A10 =	mtext[34];	}
        if (Nakno==	13){
            A3 	= Fname.grahname(4);
            A4 	=	mtext[1];
            A5 	=	mtext[5];
            A6 	=	mtext[17];
            A7 	=	mtext[9];
            A8 	=	mtext[24];
            A9 	=	mtext[26];
            A10	=	mtext[10];	}
        if (Nakno==	14 && Npau<3){
            A3 	=	Fname.grahname(4);
            A4 	=	mtext[1];
            A5 	=	mtext[5];
            A6 	=	mtext[18];
            A7 	=	mtext[16];
            A8 	=	mtext[25];
            A9 	=	mtext[28];
            A10	=	mtext[35];	}
        if (Nakno==	14 && Npau>2){
            A3 	=	Fname.grahname(6);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[18];
            A7 	=	mtext[16];
            A8 	=	mtext[25];
            A9 	=	mtext[28];
            A10	=	mtext[35];}
        if (Nakno==	15 ){
            A3 	=	Fname.grahname(6);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[17];
            A7 	=	mtext[9];
            A8 	=	mtext[24];
            A9 	=	mtext[27];
            A10	=	mtext[36];	}
        if (Nakno==	16 && Npau<4){
            A3 	=	Fname.grahname(6);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[18];
            A7 	=	mtext[16];
            A8 	=	mtext[25];
            A9 	=	mtext[27];
            A10	=	mtext[11];}
        if (Nakno==	16  && Npau	==4){
            A4 	=	mtext[3];
            A5 	=	mtext[7];
            A6 	=	mtext[18];
            A7 	=	mtext[16];
            A8 	=	mtext[25];
            A9 	=	mtext[27];
            A10 =	mtext[11];}
        if (Nakno==	17){
            A3 	=	Fname.grahname(3);
            A4 	=	mtext[3];
            A5 	=	mtext[7];
            A6 	=	mtext[19];
            A7 	=	mtext[13];
            A8 	=	mtext[24];
            A9 	=	mtext[28];
            A10	=	mtext[37];}
        if (Nakno==	18){
            A3 	=	Fname.grahname(3);
            A4 	=	mtext[3];
            A5 	=	mtext[7];
            A6 	=	mtext[19];
            A7 	=	mtext[13];
            A8 	=	mtext[25];
            A9 	=	mtext[26];
            A10	=	mtext[38];}
        if (Nakno==	19){
            A3 	=	Fname.grahname(5);
            A4 	=	mtext[0];
            A5 	=	mtext[8];
            A6 	=	mtext[13];
            A7 	=	mtext[19];
            A8 	=	mtext[25];
            A9 	=	mtext[26];
            A10 =	mtext[39];}
        if (Nakno==	20){
            A3 	=	Fname.grahname(5);
            A4 	=	mtext[0];
            A5 	=	mtext[8];
            A6 	=	mtext[20];
            A7 	=	mtext[46];
            A8 	=	mtext[22];
            A9 	=	mtext[28];
            A10	=	mtext[40];}
        if (Nakno==	21 && Npau	==	1){
            A3 	=	Fname.grahname(5);
            A4 	=	mtext[0];
            A5 	=	mtext[8];
            A6 	=	mtext[21];
            A7 	=	mtext[12];
            A8 	=	mtext[22];
            A9 	=	mtext[27];
            A10	=	mtext[40];}
        if (Nakno==	21 && Npau>1){
            A3 	=	Fname.grahname(7);
            A4 	=	mtext[1];
            A5 	=	mtext[4];
            A6 	=	mtext[21];
            A7 	=	mtext[12];
            A8 	=	mtext[22];
            A9 	=	mtext[27];
            A10	=	mtext[40];}
        if (Nakno==	22){
            A3 	=	Fname.grahname(7);
            A4 	=	mtext[1];
            A5 	=	mtext[4];
            A6 	=	mtext[22];
            A7 	=	mtext[46];
            A8 	=	mtext[24];
            A9 	=	mtext[27];
            A10	=	mtext[22];}
        if (Nakno==	23 && Npau<3){
            A3 	=	Fname.grahname(7);
            A4 	=	mtext[1];
            A5 	=	mtext[4];
            A6 	=	mtext[23];
            A7 	=	mtext[10];
            A8 	=	mtext[25];
            A9 	=	mtext[28];
            A10	=	mtext[41];}
        if (Nakno==	23 && Npau>2){
            A3 	=	Fname.grahname(7);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[23];
            A7 	=	mtext[10];
            A8 	=	mtext[25];
            A9 	=	mtext[28];
            A10 =	mtext[41];}
        if (Nakno==	24){
            A3 	=	Fname.grahname(7);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[9];
            A7 	=	mtext[17];
            A8 	=	mtext[25];
            A9 	=	mtext[26];
            A10	=	mtext[42];}
        if (Nakno==	25  && Npau<4){
            A3 	=	Fname.grahname(7);
            A4 	=	mtext[2];
            A5 	=	mtext[5];
            A6 	=	mtext[23];
            A7 	=	mtext[10];
            A8 	=	mtext[22];
            A9 	=	mtext[26];
            A10 =	mtext[43];}
        if (Nakno==	25 && Npau	==	4){
            A3 	=	Fname.grahname(5);
            A4 	=	mtext[3];
            A5 	=	mtext[6];
            A6 	=	mtext[23];
            A7 	= 	mtext[10];
            A8 	=	mtext[22];
            A9 	=	mtext[26];
            A10 =	mtext[43];	}
        if (Nakno==	26){
            A3 	=	Fname.grahname(5);
            A4 	=	mtext[3];
            A5 	=	mtext[6];
            A6 	=	mtext[16];
            A7 	=	mtext[18];
            A8 	=	mtext[22];
            A9 	=	mtext[28];
            A10	=	mtext[43];}

        if (Nakno==	27){
            A3 	=	Fname.grahname(5);
            A4 	=	mtext[3];
            A5 	=	mtext[6];
            A6 	=	mtext[10];
            A7 	=	mtext[23];
            A8 	=	mtext[24];
            A9 	=	mtext[27];
            A10	=	mtext[45];}
        if (Nakno==3 || (Nakno==4 && Npau==1)){A11=svarga[0];A12=svarga[1];}//5
        if ((Nakno==5 && Npau>2)||(Nakno==6 && Npau<4)||(Nakno==7 && Npau<3)||Nakno==22 ||Nakno==23 ||(Nakno==24 && Npau==1)){A11=svarga[2];A12=svarga[3];}//16
        if ((Nakno==27 && Npau>2)||(Nakno==1 && Npau<4)||(Nakno==6 && Npau==4)||(Nakno==21 && Npau>2)||(Nakno==26 && Npau>2)){A11=svarga[4];A12=svarga[5];}//10
        if ((Nakno==11 && Npau>1)||(Nakno==12 && Npau<3)||(Nakno==13 && Npau>2)||(Nakno==8 && Npau==4)||Nakno==9 ||(Nakno==20 && Npau==4)){A11=svarga[6];A12=svarga[7];}//13

        if (Nakno==16||(Nakno==15 && Npau==4)||(Nakno==25 && Npau>2)||(Nakno==26 && Npau==1)||(Nakno==27 && Npau<3)||(Nakno==6 && Npau==2)||Nakno==17||(Nakno==18 && Npau==1)){A11=svarga[0];A12=svarga[1];}//17
        if ((Nakno==12 && Npau<3)||(Nakno==13 && Npau==1)||(Nakno==14 && Npau>2)||(Nakno==20 && Npau==3)||(Nakno==19 && Npau<3)||(Nakno==20 && Npau==1)||(Nakno==21 && Npau>2)||Nakno==10 ||(Nakno==11 && Npau==1)){A11=svarga[2];A12=svarga[3];}//16
        if ((Nakno==18 && Npau >1)||(Nakno==19 && Npau<3)||(Nakno==14 && Npau>2)||(Nakno==15 && Npau<4)||(Nakno==1 && Npau==4)||Nakno==2||(Nakno==4 && Npau>1)||(Nakno==5 && Npau<3)){A11=svarga[4];A12=svarga[5];}//20
        if ((Nakno==13 && Npau==2)||(Nakno==24 && Npau>1)||(Nakno==25 && Npau<3)||(Nakno==7 && Npau>2)||(Nakno==8 && Npau<4)){A11=svarga[6];A12=svarga[7];}//11


    }

    public void definelagna(int kno){
        int Nrasi=0,Nawance;
        if (kno>=100){
            Ktype =kno-100;}else{Ktype =spinnerM.getSelectedItemPosition();Public_veriable.kundnumber =Ktype+100;}

        if (Ktype==0){OLagna=(int)SuryaSiddhanta.Eastrasi+1;}//Lagna kundali

        if (Ktype==1){
            Nawance=(int)(SuryaSiddhanta.EastAnsa/30*9);
            Nrasi=(int) (SuryaSiddhanta.Eastrasi+1);
            if(Nrasi==1||Nrasi==5||Nrasi==9){Nrasi=1;}
            if(Nrasi==2||Nrasi==6||Nrasi==10){Nrasi=10;}
            if(Nrasi==3||Nrasi==7||Nrasi==11){Nrasi=7;}
            if(Nrasi==4||Nrasi==8||Nrasi==12){Nrasi=4;}
            if((Nawance+Nrasi)>12){Nrasi=Nawance+Nrasi-12;}else{Nrasi=Nawance+Nrasi;}
            OLagna=Nrasi;
        }//Nawamanse kundali
        if (Ktype==2){
            OLagna=(int)SuryaSiddhanta.Eastrasi+1;}//Lagna kundali//Bhab kundali

        if (Ktype==3){
            Nawance=(int)(SuryaSiddhanta.EastAnsa/30*7);
            Nrasi=(int) (SuryaSiddhanta.Eastrasi+1);
            if(Nrasi==2||Nrasi==4||Nrasi==6||Nrasi==8||Nrasi==10||Nrasi==12){Nrasi=6+Nrasi;}
            if((Nawance+Nrasi)>12){Nrasi=Nawance+Nrasi-12;}else{Nrasi=Nawance+Nrasi;}
            OLagna=Nrasi;
        }//Saptanse kundali
        if (Ktype==4){
            Nawance=(int)(SuryaSiddhanta.EastAnsa/30*12);
            Nrasi=(int) (SuryaSiddhanta.Eastrasi+1);
            if((Nawance+Nrasi)>12){Nrasi=Nawance+Nrasi-12;}else{Nrasi=Nawance+Nrasi;}
            OLagna=Nrasi;
        }//Dwadasans kundali
        if (Ktype==5){
            Nawance=(int)(SuryaSiddhanta.EastAnsa%30);
            Nrasi=(int) (SuryaSiddhanta.Eastrasi+1);
            if(Nawance > 10 && Nawance < 20){Nrasi = Nrasi + 4 ;}
            if(Nawance > 20){Nrasi = Nrasi + 8;}
            if((Nrasi)>12){Nrasi=Nrasi-12;}
            OLagna=Nrasi;
        }//Driskan kundali
        if (Ktype==6){
            Nawance=(int)(SuryaSiddhanta.EastAnsa%30);
            Nrasi=(int) (SuryaSiddhanta.Eastrasi+1);
            if(Nrasi==2||Nrasi==4||Nrasi==8||Nrasi==10||Nrasi==12){
                if(Nawance<=5){Nrasi=2;}else{
                    if(Nawance>5 && Nawance<=12){Nrasi=6;}else{
                        if(Nawance>12 && Nawance<=20){Nrasi=12;}else{
                            if(Nawance>20 && Nawance<25){Nrasi=10;} else{ Nrasi=8;}}}}
            }
            if(Nrasi==1||Nrasi==3||Nrasi==7||Nrasi==9||Nrasi==11){
                if(Nawance<=5){Nrasi=1;}else{
                    if(Nawance>5 && Nawance<=10){Nrasi=11;}else{
                        if(Nawance>10 && Nawance<=18){Nrasi=9;}else{
                            if(Nawance>18 && Nawance<25){Nrasi=3;} else{ Nrasi=7;}}}}	}
            if((Nrasi)>12){Nrasi=Nrasi-12;}
            OLagna=Nrasi;
        }//Triskan kundali


        if (Ktype==7){
            Nrasi=(int) ((SuryaSiddhanta.pastchandra)/30);
            OLagna=(int)Nrasi+1;}//Rasi kundali
        if (Ktype==8){//Hora kundali
            Nawance=(int)(SuryaSiddhanta.EastAnsa%30);
            Nrasi=(int) (SuryaSiddhanta.Eastrasi+1);
            OLagna1=0;OLagna2=0;OLagna3=0;OLagna4=0;OLagna5=0;
            OLagna7=0;OLagna8=0;OLagna9=0;OLagna10=0;OLagna11=0;
            if ((Nrasi%2==0 && Nawance>15)||(Nrasi%2==1 && Nawance<15))
            {OLagna=5;OLagna6=4;}else{OLagna=4;OLagna6=5;}

        }else{
            OLagna1=OLagna+1;
            OLagna2=OLagna+2;
            OLagna3=OLagna+3;
            OLagna4=OLagna+4;
            OLagna5=OLagna+5;
            OLagna6=OLagna+6;
            OLagna7=OLagna+7;
            OLagna8=OLagna+8;
            OLagna9=OLagna+9;
            OLagna10=OLagna+10;
            OLagna11=OLagna+11;	}

        if (OLagna1 > 12){OLagna1 = OLagna1 - 12;}
        if (OLagna2 > 12){OLagna2 = OLagna2 - 12;}
        if (OLagna3 > 12){OLagna3 = OLagna3 - 12;}
        if (OLagna4 > 12){OLagna4 = OLagna4 - 12;}
        if (OLagna5 > 12){OLagna5 = OLagna5 - 12;}
        if (OLagna6 > 12){OLagna6 = OLagna6 - 12;}
        if (OLagna7 > 12){OLagna7 = OLagna7 - 12;}
        if (OLagna8 > 12){OLagna8 = OLagna8 - 12;}
        if (OLagna9 > 12){OLagna9 = OLagna9 - 12;}
        if (OLagna10 > 12){OLagna10 = OLagna10 - 12;}
        if (OLagna11 > 12){OLagna11 = OLagna11 - 12;}
        if(Public_veriable.FEN==0){
            Public_veriable.GrahG1 = OLagna +"";
            Public_veriable.GrahG2 = OLagna1 +"";
            Public_veriable.GrahG3 = OLagna2 +"";
            Public_veriable.GrahG4 = OLagna3 +"";
            Public_veriable.GrahG5 = OLagna4 +"";
            Public_veriable.GrahG6 = OLagna5 +"";
            Public_veriable.GrahG7 = OLagna6 +"";
            Public_veriable.GrahG8 = OLagna7 +"";
            Public_veriable.GrahG9 = OLagna8 +"";
            Public_veriable.GrahG10 = OLagna9 +"";
            Public_veriable.GrahG11= OLagna10 +"";
            Public_veriable.GrahG12 = OLagna11 +"";
        }else{
            Public_veriable.GrahG1 =  OLagna +"";
            Public_veriable.GrahG2 =  OLagna1 +"";
            Public_veriable.GrahG3 =  OLagna2 +"";
            Public_veriable.GrahG4 =  OLagna3 +"";
            Public_veriable.GrahG5 =  OLagna4 +"";
            Public_veriable.GrahG6 =  OLagna5 +"";
            Public_veriable.GrahG7 =  OLagna6 +"";
            Public_veriable.GrahG8 =  OLagna7 +"";
            Public_veriable.GrahG9 =  OLagna8 +"";
            Public_veriable.GrahG10 =  OLagna9 +"";
            Public_veriable.GrahG11=  OLagna10 +"";
            Public_veriable.GrahG12 =  OLagna11 +"";
        }


        prepare_kundali (SuryaSiddhanta.pastsurya,SuryaSiddhanta.pastchandra,SuryaSiddhanta.pastmangal,SuryaSiddhanta.pastbudha,SuryaSiddhanta.pastguru,SuryaSiddhanta.pastsukra,SuryaSiddhanta.pastsani,SuryaSiddhanta.pastrahu,SuryaSiddhanta.pastKetu);

    }
    public void prepare_kundali(double surya,double chandra,double mangal,double budha,double guru,double sukra,double sani,double rahu,double ketu){
        if(Public_veriable.FEN==0){
            groupgrah_for_kundali (surya, "Su");
            groupgrah_for_kundali (chandra, "Ch");
            groupgrah_for_kundali (mangal, "Ma");
            groupgrah_for_kundali (budha, "Bu");
            groupgrah_for_kundali (guru, "Gu");
            groupgrah_for_kundali (sukra, "Suk");
            groupgrah_for_kundali (sani, "Sa");
            groupgrah_for_kundali (rahu, "Ra");
            groupgrah_for_kundali (ketu, "Ke");}else{

            groupgrah_for_kundali (surya, ";Ò=");
            groupgrah_for_kundali (chandra, "r+=");
            groupgrah_for_kundali (mangal, "d+=");
            groupgrah_for_kundali (budha, "aÚ=");
            groupgrah_for_kundali (guru, "uÚ=");
            groupgrah_for_kundali (sukra, "zÚ=");
            groupgrah_for_kundali (sani, "z+=");
            groupgrah_for_kundali (rahu, "/f=");
            groupgrah_for_kundali (ketu, "s]=");
        }
    }

    public void groupgrah_for_kundali(double Grawdegree,String Gname){
        int Nrasi=0,Nawance;

        if (Ktype==0){Lagna = (int)(Grawdegree / 30)+1;}//Lagna kundali

        if (Ktype==1){
            Nrasi = (int)(Grawdegree / 30)+1;
            Nawance = (int)(Grawdegree % 30*9/30);
            if(Nrasi==1||Nrasi==5||Nrasi==9){Nrasi=1;}
            if(Nrasi==2||Nrasi==6||Nrasi==10){Nrasi=10;}
            if(Nrasi==3||Nrasi==7||Nrasi==11){Nrasi=7;}
            if(Nrasi==4||Nrasi==8||Nrasi==12){Nrasi=4;}
            Lagna=Nawance+Nrasi;}// Nawance kundali
        if (Ktype==2){

            double diff=0 , labvalue =0;
            int i,myno=1;
            for ( i =0;i<24;i++){
                labvalue = SuryaSiddhanta.Bhab[i];
                if(labvalue < 1 ){labvalue = labvalue + 12;}
                if ((labvalue * 30 - Grawdegree) > 360) { labvalue = labvalue - 12;}

                if(labvalue * 30 > Grawdegree){
                    if( diff > (labvalue * 30 - Grawdegree)||diff==0) {
                        myno = i+1;
                        diff = labvalue * 30 - Grawdegree;}}
            }
            if (myno==1||myno==2){Lagna=OLagna;}
            if (myno==3||myno==4){Lagna=OLagna1;}
            if (myno==5||myno==6){Lagna=OLagna2;}
            if (myno==7||myno==8){Lagna=OLagna3;}
            if (myno==9||myno==10){Lagna=OLagna4;}
            if (myno==11||myno==12){Lagna=OLagna5;}
            if (myno==13||myno==14){Lagna=OLagna6;}
            if (myno==15||myno==16){Lagna=OLagna7;}
            if (myno==17||myno==18){Lagna=OLagna8;}
            if (myno==19||myno==20){Lagna=OLagna9;}
            if (myno==21||myno==22){Lagna=OLagna10;}
            if (myno==23||myno==24){Lagna=OLagna11;}

        }
        if (Ktype==3){
            Nrasi = (int)(Grawdegree / 30)+1;
            Nawance = (int)(Grawdegree % 30*7/30);
            if(Nrasi==2||Nrasi==4||Nrasi==6||Nrasi==8||Nrasi==10||Nrasi==12){Nrasi=6+Nrasi;}
            Lagna=Nawance+Nrasi;}// Saptance kundali
        if (Ktype==4){
            Nrasi = (int)(Grawdegree / 30)+1;
            Nawance = (int)(Grawdegree % 30*12/30);
            Lagna=Nawance+Nrasi;}// Dwadans kundali
        if (Ktype==5){
            Nrasi = (int)(Grawdegree / 30)+1;
            Nawance = (int)(Grawdegree % 30);
            if(Nawance > 10 && Nawance < 20){Nrasi = Nrasi + 4 ;}
            if(Nawance > 20){Nrasi = Nrasi + 8;}
            Lagna=Nrasi;}// Drishkan kundali
        if (Ktype==6){
            Nawance=(int)(Grawdegree%30);
            Nrasi=(int) (Grawdegree/30+1);

            if(Nrasi==2||Nrasi==4||Nrasi==8||Nrasi==10||Nrasi==12){
                if(Nawance<=5){Nrasi=2;}else{
                    if(Nawance>5 && Nawance<=12){Nrasi=6;}else{
                        if(Nawance>12 && Nawance<=20){Nrasi=12;}else{
                            if(Nawance>20 && Nawance<25){Nrasi=10;} else{ Nrasi=8;}}}}
            }
            if(Nrasi==1||Nrasi==3||Nrasi==7||Nrasi==9||Nrasi==11){
                if(Nawance<=5){Nrasi=1;}else{
                    if(Nawance>5 && Nawance<=10){Nrasi=11;}else{
                        if(Nawance>10 && Nawance<=18){Nrasi=9;}else{
                            if(Nawance>18 && Nawance<25){Nrasi=3;} else{ Nrasi=7;}}}}	}
            Lagna=Nrasi;
        }//Triskan kundali
        if (Ktype==7){Lagna = (int)(Grawdegree / 30)+1;}//Rashi kundali

        if (Ktype==8){
            Nawance=(int)(Grawdegree%30);
            Nrasi=(int) (Grawdegree/30+1);
            if ((Nrasi%2==0 && Nawance>15)||(Nrasi%2==1 && Nawance<15)){Lagna=5;}else{Lagna=4;}
        }//Hora kundali




        if (Lagna > 12){Lagna = Lagna - 12;}
        if(OLagna == Lagna) {Public_veriable.GrahG1 = Public_veriable.GrahG1+ " "+Gname;}
        if(OLagna1 == Lagna) {Public_veriable.GrahG2 = Public_veriable.GrahG2+ " "+Gname;}
        if(OLagna2 == Lagna) {Public_veriable.GrahG3 =  Public_veriable.GrahG3+ " "+Gname;}
        if(OLagna3 == Lagna) {Public_veriable.GrahG4 =  Public_veriable.GrahG4+ " "+Gname;}
        if(OLagna4 == Lagna) {Public_veriable.GrahG5 =  Public_veriable.GrahG5+ " "+Gname;}
        if(OLagna5 == Lagna) {Public_veriable.GrahG6 =  Public_veriable.GrahG6+ " "+Gname;}
        if(OLagna6 == Lagna) {Public_veriable.GrahG7 =  Public_veriable.GrahG7+ " "+Gname;}
        if(OLagna7 == Lagna) {Public_veriable.GrahG8 =  Public_veriable.GrahG8+ " "+Gname;}
        if(OLagna8 == Lagna) {Public_veriable.GrahG9 =  Public_veriable.GrahG9+ " "+Gname;}
        if(OLagna9 == Lagna) {Public_veriable.GrahG10 =  Public_veriable.GrahG10+ " "+Gname;}
        if(OLagna10 == Lagna) {Public_veriable.GrahG11 =  Public_veriable.GrahG11+ " "+Gname;}
        if(OLagna11 == Lagna) {Public_veriable.GrahG12 =  Public_veriable.GrahG12+ " "+Gname;}


    }

    public void onclick_show(View view){
        definelagna(0);
        Intent myIntent = new Intent(view.getContext(), kundali.class);
        startActivity(myIntent);
    }
    public void onclick_falit(View view){
        Public_veriable.FalT=0;
        Intent Fintent = new Intent(view.getContext(), falit.class);
        startActivity(Fintent);
    }
    public void onclick_dasa(View view){

        Public_veriable.Dtype =spinnerD.getSelectedItemPosition();
        Intent Bintent = new Intent(view.getContext(), Binso.class);
        startActivity(Bintent);
    }
    public void onclick_grahapasta(View view){
        Intent Gintent = new Intent(view.getContext(), general.class);
        startActivity(Gintent);

    }

    public void loadspinner_Item(){
        String Llist="";
        if(Public_veriable.FEN==0){Llist = "Lagna Kundali,Nawamansa Kundali,Bhab Kundali,Saptamansa Kundali,Dwadasansa Kundali,Drishyank Kundali,Trishyank Kundali,Chandra/Rasi Kundali,Hora Kundali";}
        if(Public_veriable.FEN==1){Llist = "nUg sÚ)*nL,gjdf+z sÚ)*nL,efj  sÚ)*nL,;Ktdf+z sÚ)*nL,åfbzf+z sÚ)*nL,b|]isf)f  sÚ)*nL,lq+zf+z sÚ)*nL,/flz sÚ)*nL,xf]/f sÚ)*nL";}
        String[] Clist = Llist.split(",");
        ArrayAdapter<String> adapterM = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Clist)
        {
            public View getView(int position, View convertView, android.view.ViewGroup parent) {

                Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/HIMALI.otf");
                if(Public_veriable.FEN==0){font = Typeface.DEFAULT;}
                TextView v = (TextView) super.getView(position, convertView, parent);
                v.setTypeface(font);
                v.setTextColor(Color.RED);
                //v.setTextSize(35);
                return v;
            }

            public View getDropDownView(int position, View convertView, android.view.ViewGroup parent) {
                TextView v = (TextView) super.getView(position, convertView, parent);
                Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/HIMALI.otf");
                if(Public_veriable.FEN==0){font = Typeface.DEFAULT;}
                v.setTypeface(font);
                v.setTextColor(Color.RED);
                //v.setTextSize(35);
                return v;
            }
        };

        //adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerM = (Spinner) findViewById(R.id.spinner1);



	    	/*
	    	adapterM.add("Sudarsan Chakra");
	    	adapterM.add("Surya Austabarga");
	    	adapterM.add("Chandra Austabarga");
	    	adapterM.add("Mangal Austabarga");
	    	adapterM.add("Budha Austabarga");
	    	adapterM.add("Guru Austabarga");
	    	adapterM.add("Sukra Austabarga");
	    	adapterM.add("Sani Austabarga");
	    	adapterM.add("Lagna Austabarga");
	    	adapterM.add("Sarba Austabarga");
	    	*/

        spinnerM.setAdapter(adapterM);
    }
    public void loadspinner_Dasa(){
        String Llist="";
        if(Public_veriable.FEN==0){Llist = "Bimsottari Mahadasa,Tribhagi Dasa,Yogani Dasa";}
        if(Public_veriable.FEN==1){Llist = "la+zf]Q/L Dfxfbzf,lqefuL bzf,of]lugL bzf";}
        String[] Clist = Llist.split(",");
        ArrayAdapter<String> adapterD = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Clist)
        {
            public View getView(int position, View convertView, android.view.ViewGroup parent) {

                Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/HIMALI.otf");
                if(Public_veriable.FEN==0){font = Typeface.DEFAULT;}
                TextView v = (TextView) super.getView(position, convertView, parent);
                v.setTypeface(font);
                v.setTextColor(Color.RED);
                //v.setTextSize(35);
                return v;
            }

            public View getDropDownView(int position, View convertView, android.view.ViewGroup parent) {
                TextView v = (TextView) super.getView(position, convertView, parent);
                Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/HIMALI.otf");
                if(Public_veriable.FEN==0){font = Typeface.DEFAULT;}
                v.setTypeface(font);
                v.setTextColor(Color.RED);
                //v.setTextSize(35);
                return v;
            }
        };
        //	adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerD = (Spinner) findViewById(R.id.spinner2);
        spinnerD.setAdapter(adapterD);
    }
}
