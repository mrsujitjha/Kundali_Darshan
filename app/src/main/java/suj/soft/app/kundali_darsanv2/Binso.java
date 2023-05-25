package suj.soft.app.kundali_darsanv2;
        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Typeface;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.LinearLayout;
        import android.widget.TextView;

public class Binso extends Activity {
    public int SBDN,GNN;
    int NN=0,GNNS=0;
    double DT1,DT2;
    long DOB;
    double DT4,DT3;
    TextView Tdasa,Tdur;
    TextView D1,D2,D3,D4,D5,D6,D7,D8,D9;
    CheckBox CYN;
    LinearLayout imagekund;
    LinearLayout imageback;
    private option kund;
    private TextView Gn1,Gn2,Gn3,Gn4,Gn5,Gn6,Gn7,Gn8,Gn9,Gn10,Gn11,Gn12;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dasa);

        Tdasa = (TextView)findViewById(R.id.textView1);
        Tdur = (TextView)findViewById(R.id.textView2);
        D1 = (TextView)findViewById(R.id.textView3);
        D2 = (TextView)findViewById(R.id.textView5);
        D3 = (TextView)findViewById(R.id.textView7);
        D4 = (TextView)findViewById(R.id.textView9);
        D5 = (TextView)findViewById(R.id.textView11);
        D6 = (TextView)findViewById(R.id.textView13);
        D7 = (TextView)findViewById(R.id.textView15);
        D8 = (TextView)findViewById(R.id.textView17);
        D9 = (TextView)findViewById(R.id.textView19);
        CYN =(CheckBox)findViewById(R.id.checkBox1);
        //for kundali
        Gn1 = (TextView)findViewById(R.id.textView20);
        Gn2 = (TextView)findViewById(R.id.textView22);
        Gn3 = (TextView)findViewById(R.id.textView23);
        Gn4 = (TextView)findViewById(R.id.textView24);
        Gn5 = (TextView)findViewById(R.id.textView25);
        Gn6 = (TextView)findViewById(R.id.textView26);
        Gn7 = (TextView)findViewById(R.id.textView21);
        Gn8 = (TextView)findViewById(R.id.textView31);
        Gn9 = (TextView)findViewById(R.id.textView30);
        Gn10 = (TextView)findViewById(R.id.textView29);
        Gn11 = (TextView)findViewById(R.id.textView28);
        Gn12 = (TextView)findViewById(R.id.textView27);

        imagekund = (LinearLayout)findViewById(R.id.linear1);//Pre kundali
        Drawable  drawable  = null;
        if(Public_veriable.KB==0){
            drawable  = getResources().getDrawable(R.drawable.kundali);}else{
            drawable  = getResources().getDrawable(R.drawable.kundalicolor);
        } imagekund.setBackgroundDrawable(drawable);

        imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable  backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);

        if(Public_veriable.FEN==1){
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");

            D1.setTypeface(tf); D2.setTypeface(tf); D3.setTypeface(tf); D4.setTypeface(tf);
            D5.setTypeface(tf); D6.setTypeface(tf); D7.setTypeface(tf); D8.setTypeface(tf); D9.setTypeface(tf);
            Tdasa.setTypeface(tf); Tdur.setTypeface(tf);


            Gn1.setTypeface(tf); Gn2.setTypeface(tf); Gn3.setTypeface(tf); Gn4.setTypeface(tf);
            Gn5.setTypeface(tf); Gn6.setTypeface(tf); Gn7.setTypeface(tf); Gn8.setTypeface(tf);
            Gn9.setTypeface(tf); Gn10.setTypeface(tf); Gn11.setTypeface(tf); Gn12.setTypeface(tf);
            CYN.setTypeface(tf);
            CYN.setText("eÚStf]lgt");

        }
        //Public_veriable.BDN = 2;
        DOB=Public_veriable.Nyr*360+Public_veriable.Nmn*30+Public_veriable.Ndt;

        Load_dasa();
        load_kundali();
        if(Public_veriable.Dtype==0||Public_veriable.Dtype==2)	{
            Public_veriable.FalT=Public_veriable.Dtype+1;
            if(Public_veriable.Dtype==2){GNN=8;GNNS=0;SBDN=SBDN-GNN;if(SBDN==8){SBDN=0;}}
            if(Public_veriable.Dtype==0){GNN=7;GNNS=SBDN-GNN; SBDN=SBDN-GNN;if(SBDN==9){SBDN=0;}}


            D1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});
            D2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+1;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});

            D3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+2;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});
            D4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+3;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});

            D5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+4;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});
            D6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+5;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});
            D7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+6;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});
            D8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dnc =GNNS+7;
                    if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                    Public_veriable.BDNUM=(SBDN)*10+(dnc);
                    Intent Fintent = new Intent(view.getContext(), falit.class);
                    startActivity(Fintent);
                }});
            D9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Public_veriable.Dtype==0){
                        int dnc =GNNS+8;
                        if (dnc>GNN+1){dnc=dnc-(GNN+2);}
                        Public_veriable.BDNUM=(SBDN)*10+(dnc);
                        Intent Fintent = new Intent(view.getContext(), falit.class);
                        startActivity(Fintent);
                    }
                }});
        }
    }

    private void load_kundali(){
        kund=new option();
        kund.definelagna(100);
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

    public void Load_dasa(){
        if (Public_veriable.Dtype==0){Load_Binsodasa();}
        if (Public_veriable.Dtype==1){Load_Tridasa();}
        if (Public_veriable.Dtype==2){Load_Yognidasa();}
    }
    public void Load_Yognidasa(){
        Public_veriable.BDN = (SuryaSiddhanta.GatNakchatra+3)%8;
        if(Public_veriable.BDN ==0) {  Public_veriable.BDN =8;}
        String BinDasaarray ="";

        if(Public_veriable.FEN==0){
            BinDasaarray = "MANGALA PINGALA DHANYA BRAMARI BHADRIKA ULKA SIDHHA SANKATA MANGALA PINGALA DHANYA BRAMARI BHADRIKA ULKA SIDHHA SANKATA MANGALA PINGALA DHANYA BRAMARI BHADRIKA ULKA SIDHHA SANKATA";

        }else{
            BinDasaarray = "d+unf lk+unf wfGo e|fd/L elb|sf pNsf l;$f ;+s^f d+unf lk+unf wfGo e|fd/L elb|sf pNsf l;$f ;+s^f d+unf lk+unf wfGo e|fd/L elb|sf pNsf l;$f ;+s^f";

        }
        String[] BinDasaname = BinDasaarray.split(" ");
        String BinDasadur = "1 2 3 4 5 6 7 8 1 2 3 4 5 6 7 8 1 2 3 4 5 6 7 8";
        String[] BinDD = BinDasadur.split(" ");
        DT3=0;

        for (int i=0;i < NN+1;i++){DT3 +=Integer.parseInt(BinDD[Public_veriable.BDN+i-1]);}


        SBDN=Public_veriable.BDN+NN-1;
        if(SBDN>7){SBDN=SBDN-8;}
        Tdasa.setText(  BinDasaname[SBDN] );
        DT1=Integer.parseInt(BinDD[Public_veriable.BDN-1+NN]);
        DT2=DT1;
        if(CYN.isChecked()){
            DT4= (Integer.parseInt(BinDD[Public_veriable.BDN-1])*SuryaSiddhanta.NakBhukta/SuryaSiddhanta.NakBhabog);
            if(NN==0){Tdur.setText(get_dateformat((DT1-DT4)*360));}else{
                Tdur.setText(get_dateformat((DT3-DT4)*360));}
            DT3= (DT3-DT4-Integer.parseInt(BinDD[SBDN]))*360+DOB;
        }else{
            Tdur.setText(get_dateformat(DT3*360));
            DT3=(DT3-Integer.parseInt(BinDD[SBDN]))*360+DOB;
        }

        D1.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D2.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D3.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D4.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D5.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D6.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D7.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D8.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        D9.setText(" ");
    }
    public void Load_Tridasa(){
        Public_veriable.BDN = (SuryaSiddhanta.GatNakchatra+7)%9;
        if(Public_veriable.BDN ==0) {  Public_veriable.BDN =9;}
        String BinDasaarray = "";

        if(Public_veriable.FEN==0){
            BinDasaarray = "SURYA CHANDRA MANGAL RAHU GURU SANI BUDHA KETU SUKRA SURYA CHANDRA MANGAL RAHU GURU SANI BUDHA KETU SUKRA";

        }else{
            BinDasaarray = ";úo{ rGb| d+un /fxÚ uÚ? zlg aÚw s]tÚ zÚqm ;úo{ rGb| d+un /fxÚ uÚ? zlg aÚw s]tÚ zÚqm";

        }

        String[] BinDasaname = BinDasaarray.split(" ");
        String BinDasadur = "12 20 14 36 32 38 34 14 40 12 20 14 36 32 38 34 14 40";
        String[] BinDD = BinDasadur.split(" ");
        DT3=0;

        for (int i=0;i < NN+1;i++){DT3 +=Double.parseDouble(BinDD[Public_veriable.BDN+i-1])/3;}

        SBDN=Public_veriable.BDN+NN-1;
        if(SBDN>8){SBDN=SBDN-9;}

        Tdasa.setText( BinDasaname[SBDN] );
        DT1=Double.parseDouble( BinDD[Public_veriable.BDN-1+NN])/3;
        DT2=DT1;
        if(CYN.isChecked()){
            DT4= (Double.parseDouble(BinDD[Public_veriable.BDN-1])/3*SuryaSiddhanta.NakBhukta/SuryaSiddhanta.NakBhabog);
            if(NN==0){Tdur.setText(get_dateformat((DT1-DT4)*360));}else{
                Tdur.setText(get_dateformat((DT3-DT4)*360));}
            DT3= (DT3-DT4-Double.parseDouble(BinDD[SBDN])/3)*360+DOB;
        }else{
            Tdur.setText(get_dateformat(DT3*360));
            DT3=(DT3-Double.parseDouble(BinDD[SBDN])/3)*360+DOB;
        }

        D1.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D2.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D3.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D4.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D5.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D6.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D7.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D8.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Double.parseDouble(BinDD[SBDN])/3;
        D9.setText( get_dasatime()+ BinDasaname[SBDN]);
    }

    public void Load_Binsodasa(){
        Public_veriable.BDN = (SuryaSiddhanta.GatNakchatra+7)%9;
        if(Public_veriable.BDN ==0) {  Public_veriable.BDN =9;}
        String BinDasaarray = "";
        if(Public_veriable.FEN==0){
            BinDasaarray = "SURYA CHANDRA MANGAL RAHU GURU SANI BUDHA KETU SUKRA SURYA CHANDRA MANGAL RAHU GURU SANI BUDHA KETU SUKRA";
        }else{
            BinDasaarray = ";úo{ rGb| d+un /fxÚ uÚ? zlg aÚw s]tÚ zÚqm ;úo{ rGb| d+un /fxÚ uÚ? zlg aÚw s]tÚ zÚqm";
          }
        String[] BinDasaname = BinDasaarray.split(" ");
        String BinDasadur = "6 10 7 18 16 19 17 7 20 6 10 7 18 16 19 17 7 20";
        String[] BinDD = BinDasadur.split(" ");
        DT3=0;

        for (int i=0;i < NN+1;i++){
            DT3 +=Integer.parseInt(BinDD[Public_veriable.BDN+i-1]);}

        SBDN=Public_veriable.BDN+NN-1;
        if(SBDN>8){SBDN=SBDN-9;}
        Tdasa.setText( BinDasaname[SBDN] );
        DT1=Integer.parseInt(BinDD[Public_veriable.BDN-1+NN]);
        DT2=DT1;
        if(CYN.isChecked()){
            DT4= (Integer.parseInt(BinDD[Public_veriable.BDN-1])*SuryaSiddhanta.NakBhukta/SuryaSiddhanta.NakBhabog);
            if(NN==0){Tdur.setText(get_dateformat((DT1-DT4)*360));}else{
                Tdur.setText(get_dateformat((DT3-DT4)*360));}
            DT3= (DT3-DT4-Integer.parseInt(BinDD[SBDN]))*360+DOB;
        }else{
            Tdur.setText(get_dateformat(DT3*360));
            DT3=(DT3-Integer.parseInt(BinDD[SBDN]))*360+DOB;
        }

        D1.setText(get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D2.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D3.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D4.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D5.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D6.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D7.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D8.setText( get_dasatime()+ BinDasaname[SBDN]);
        SBDN =SBDN+1;
        DT2=DT2+Integer.parseInt(BinDD[SBDN]);
        D9.setText( get_dasatime()+ BinDasaname[SBDN]);
    }

    public void onclick_show(View view){
        Load_dasa();
        if(Public_veriable.Dtype==2){GNN=8;GNNS=0;}
        if(Public_veriable.Dtype==0){GNN=7;GNNS=SBDN-GNN;}SBDN=SBDN-GNN;
    }

    public void onclick_next(View view){
        NN=NN+1;
        if (Public_veriable.Dtype==2){if (NN>15){NN=0;}}
        if (Public_veriable.Dtype==1){if (NN>8){NN=0;}}
        if (Public_veriable.Dtype==0){if (NN>8){NN=0;}}
        Load_dasa();
        if(Public_veriable.Dtype==2){GNN=8;GNNS=0;}
        if(Public_veriable.Dtype==0){GNN=7;GNNS=SBDN-GNN;}SBDN=SBDN-GNN;
    }
    public void onclick_back(View view){
        if (NN>0){NN=NN-1;}
        Load_dasa();
        if(Public_veriable.Dtype==2){GNN=8;GNNS=0;}
        if(Public_veriable.Dtype==0){GNN=7;GNNS=SBDN-GNN;}SBDN=SBDN-GNN;
    }


    public String get_dasatime(){
        String mydate = "";
        String df="";
        if(Public_veriable.FEN==0){ df=":";}else{df="M";}
        int Z=0,DY,DM,DD;
        if (Public_veriable.Dtype==0){Z=(int) (DT1*DT2*3+DT3);}
        if (Public_veriable.Dtype==2){Z=(int) (DT1*DT2*10+DT3);}
        if (Public_veriable.Dtype==1){Z=(int) (DT1*DT2*4.5+DT3);}
        if (DOB>Z){mydate ="";}else{
            DY = Z/360;
            DM = (Z%360)/30;
            DD = (Z%360)%30;
            if(DD==0){DM=DM-1;DD=30;}
            if(DM==0){DY=DY-1;DM=12;}
            mydate = DY + df + Chdigit(DM) + df + Chdigit(DD) + "   ";
        }
        return mydate;
    }
    public String get_dateformat(double Z){
        String mydate = "";
        int DY,DM,DD;
        DY = (int) (Z/360);
        DM = (int) ((Z%360)/30);
        DD = (int) ((Z%360)%30);
        if(Public_veriable.FEN==1){

            mydate = DY + " aif{ " + Chdigit(DM) + " dlxgf "+ Chdigit(DD) + " lbg";
        }else{
            mydate = DY + " Yrs " + Chdigit(DM) + " Month "+ Chdigit(DD) + " Day";
        }
        return mydate;
    }

    private static String Chdigit(long dM) {
        if (dM < 10) return "0" + dM;
        else return String.valueOf(dM);}

}
