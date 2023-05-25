package suj.soft.app.kundali_darsanv2;
        import android.app.Activity;
        import android.graphics.Typeface;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.text.method.ScrollingMovementMethod;
        import android.util.TypedValue;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;


public class kundali extends Activity{

    private static DBOperation dboper=null;
    private displayformat mformat;
    private name_others mname;
    private option moption;
    private TextView Gn1;
    private TextView Gn2;
    private TextView Gn3;
    private TextView Gn4;
    private TextView Gn5;
    private TextView Gn6;
    private TextView Gn7;
    private TextView Gn8;
    private TextView Gn9;
    private TextView Gn10;
    private TextView Gn11;
    private TextView Gn12;
    private TextView Gdetail;
    private TextView Kname;
    private TextView Gfal;

    private String Gdetailshow="";
    ImageView mimageNK;
    ImageView mimagePK;
    LinearLayout imagekund;
    LinearLayout imageback;
    int X;
    String xx ="";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kundali);

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
        Kname = (TextView)findViewById(R.id.textView14);
        Gdetail = (TextView)findViewById(R.id.textView15);
        Gfal = (TextView)findViewById(R.id.textView13);
        Gfal.setMovementMethod(new ScrollingMovementMethod());
        Gdetail.setMovementMethod(new ScrollingMovementMethod());

        mimageNK = (ImageView)findViewById(R.id.imageView2);//Next kundali
        mimagePK = (ImageView)findViewById(R.id.imageView1);//Pre kundali
        imagekund = (LinearLayout)findViewById(R.id.linear1);//Pre kundali
        Drawable  drawable  = null;

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

        if(Public_veriable.FEN==1){
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");

            Gn1.setTypeface(tf); Gn2.setTypeface(tf); Gn3.setTypeface(tf); Gn4.setTypeface(tf);
            Gn5.setTypeface(tf); Gn6.setTypeface(tf); Gn7.setTypeface(tf); Gn8.setTypeface(tf);
            Gn9.setTypeface(tf); Gn10.setTypeface(tf); Gn11.setTypeface(tf); Gn12.setTypeface(tf);
            Kname.setTypeface(tf); Gdetail.setTypeface(tf);
            Gdetail.setHint("u|xsf] cj:yf x]g{ u|xsf] sf]&fdf yLRgÚ;");

        }
        dboper=new DBOperation();
        moption = new option();
        mname = new name_others();
        mformat= new displayformat();
        Gfal.setTextSize(TypedValue.COMPLEX_UNIT_SP,Public_veriable.FS);
        Gdetail.setTextSize(TypedValue.COMPLEX_UNIT_SP,Public_veriable.FS/2+4);

        load_kundali();
        Kname.setText(mname.Kundaliname(Public_veriable.kundnumber));
        mimageNK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Public_veriable.kundnumber=Public_veriable.kundnumber+1;
                if( Public_veriable.kundnumber>108){ Public_veriable.kundnumber=100;}
                moption.definelagna(Public_veriable.kundnumber);
                Kname.setText(mname.Kundaliname(Public_veriable.kundnumber));
                load_kundali();
            }});
        mimagePK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Public_veriable.kundnumber=Public_veriable.kundnumber-1;
                if( Public_veriable.kundnumber<100){ Public_veriable.kundnumber=108;}
                moption.definelagna(Public_veriable.kundnumber);
                Kname.setText(mname.Kundaliname(Public_veriable.kundnumber));
                load_kundali();
            }});

        Gn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn1.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn1.getText().toString()+ " 0").split(" ");
                    if(Public_veriable.FEN==0){
                        Gdetailshow=mname.grahname((int)SuryaSiddhanta.Eastrasi+1)+" Lagna with value "+mformat.dis_rgpb(SuryaSiddhanta.Eastrasi*30)+"\n";
                    }else{
                        Gdetailshow=mname.grahname((int)SuryaSiddhanta.Eastrasi+1)+" nUg tyf l*u|L "+mformat.dis_rgpb(SuryaSiddhanta.Eastrasi*30)+"\n";
                         X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval((int)SuryaSiddhanta.Eastrasi+1));
                        if( X < 10){xx = "H010" + X;}else{xx = "H01" + X;}
                        Gfal.setText( dboper.getfal(xx));
                    }
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn2.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn2.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H020" + X;}else{xx = "H02" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});

        Gn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn3.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn3.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H030" + X;}else{xx = "H03" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn4.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn4.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H040" + X;}else{xx = "H04" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn5.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn5.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H050" + X;}else{xx = "H05" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn6.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn6.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H060" + X;}else{xx = "H06" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn7.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn7.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H070" + X;}else{xx = "H07" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn8.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn8.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H080" + X;}else{xx = "H08" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn9.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn9.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H090" + X;}else{xx = "H09" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn10.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn10.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H100" + X;}else{xx = "H10" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});

        Gn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn11.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn11.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H110" + X;}else{xx = "H11" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
        Gn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Gn12.getText().toString().length()>0 && Public_veriable.kundnumber==100){
                    String[] mtext = (Gn12.getText().toString()+ " 0").split(" ");

                    X = Gpos((int)SuryaSiddhanta.Eastrasi+1,Getval(Integer.parseInt(mtext[0])));
                    if( X < 10){xx = "H120" + X;}else{xx = "H12" + X;}
                    Gfal.setText( dboper.getfal(xx));

                    Gdetailshow="";
                    for (int i =1;i<10;i++){
                        String Gs =mtext[i];
                        if(Gs.equalsIgnoreCase("0")){break;}
                        Gdetailshow +=   Find_grahadetail(Gs,mtext[0])+"\n" ;}
                    Gdetail.setText(Gdetailshow);
                }}});
    }

    String Find_rasistatus(String Gp,int GN){
        String Rstatus = "";

        int rn = Integer.parseInt(Gp);
        if(GN==1){
            if (rn==1){Rstatus="Uchha";}
            if (rn==7){Rstatus="Nichha";}
            if (rn==5){Rstatus="Swagrahi";}
        }
        if(GN==2){
            if (rn==2){Rstatus="Uchha";}
            if (rn==8){Rstatus="Nichha";}
            if (rn==4){Rstatus="Swagrahi";}
        }

        if(GN==3){
            if (rn==10){Rstatus="Uchha";}
            if (rn==4){Rstatus="Nichha";}
            if (rn==1 && rn==8){Rstatus="Swagrahi";}
        }
        if(GN==4){
            if (rn==6){Rstatus="Uchha";}
            if (rn==12){Rstatus="Nichha";}
            if (rn==3 || rn==6){Rstatus="Swagrahi";}
        }
        if(GN==5){
            if (rn==4){Rstatus="Uchha";}
            if (rn==10){Rstatus="Nichha";}
            if (rn==9 || rn==12){Rstatus="Swagrahi";}
        }
        if(GN==6){
            if (rn==12){Rstatus="Uchha";}
            if (rn==6){Rstatus="Nichha";}
            if (rn==2 || rn==7){Rstatus="Swagrahi";}
        }
        if(GN==7){
            if (rn==7){Rstatus="Uchha";}
            if (rn==1){Rstatus="Nichha";}
            if (rn==10 || rn==11){Rstatus="Swagrahi";}
        }
        if(GN==8 ||GN==9){Rstatus="";  }
        if(Public_veriable.FEN==1){
            if(Rstatus.equalsIgnoreCase("Uchha") ){Rstatus="pRr"; }
            if(Rstatus.equalsIgnoreCase("Nichha") ){Rstatus="gLRr"; }
            if(Rstatus.equalsIgnoreCase("Swagrahi") ){Rstatus=":ju[xL"; }
        }


        return Rstatus;
    }
    String Find_grahadetail(String Gn,String Gp){
        String Gdetail = null;
        if(Public_veriable.FEN==0){
            if(Gn.equalsIgnoreCase("Su")){Gdetail="Surya pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastsurya)+" Gati " +mformat.dis_gpb(SuryaSiddhanta.suryapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,1)+"\n";}
            if(Gn.equalsIgnoreCase("Ch")){Gdetail="Chandra pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastchandra)+ " Gati " +mformat.dis_gpb(SuryaSiddhanta.chandrapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,2)+"\n";}
            if(Gn.equalsIgnoreCase("Ma")){Gdetail="Mangal pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastmangal)+ " Gati " +mformat.dis_gpb(SuryaSiddhanta.mangalpastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,3)+"\n";}
            if(Gn.equalsIgnoreCase("Bu")){Gdetail="Budha pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastbudha)+ " Gati " +mformat.dis_gpb(SuryaSiddhanta.budhapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,4)+"\n";}
            if(Gn.equalsIgnoreCase("Gu")){Gdetail="Guru pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastguru)+" Gati " +mformat.dis_gpb(SuryaSiddhanta.gurupastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,5)+"\n";}
            if(Gn.equalsIgnoreCase("Suk")){Gdetail="Sukra pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastsukra)+" Gati " +mformat.dis_gpb(SuryaSiddhanta.sukrapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,6)+"\n";}
            if(Gn.equalsIgnoreCase("Sa")){Gdetail="Sani pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastsani)+" Gati " +mformat.dis_gpb(SuryaSiddhanta.sanipastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,7)+"\n";}
            if(Gn.equalsIgnoreCase("Ra")){Gdetail="Rahu pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastrahu)+" Gati " +mformat.dis_gpb(SuryaSiddhanta.rahupastgati)+" ";}
            if(Gn.equalsIgnoreCase("Ke")){Gdetail="Ketu pasta " +mformat.dis_rgpb(SuryaSiddhanta.pastKetu);}
        }else{
            if(Gn.equalsIgnoreCase(";Ò=")){Gdetail=";Ò=o{ki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastsurya)+" utL " +mformat.dis_gpb(SuryaSiddhanta.suryapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,1)+"\n";}
            if(Gn.equalsIgnoreCase("r+=")){Gdetail="r+Gb|ki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastchandra)+ " utL " +mformat.dis_gpb(SuryaSiddhanta.chandrapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,2)+"\n";}
            if(Gn.equalsIgnoreCase("d+=")){Gdetail="d+unki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastmangal)+ " utL " +mformat.dis_gpb(SuryaSiddhanta.mangalpastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,3)+"\n";}
            if(Gn.equalsIgnoreCase("aÚ=")){Gdetail="aÚwki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastbudha)+ " utL " +mformat.dis_gpb(SuryaSiddhanta.budhapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,4)+"\n";}
            if(Gn.equalsIgnoreCase("uÚ=")){Gdetail="uÚ?ki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastguru)+" utL " +mformat.dis_gpb(SuryaSiddhanta.gurupastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,5)+"\n";}
            if(Gn.equalsIgnoreCase("zÚ=")){Gdetail="zÚqmki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastsukra)+" utL " +mformat.dis_gpb(SuryaSiddhanta.sukrapastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,6)+"\n";}
            if(Gn.equalsIgnoreCase("z+=")){Gdetail="zlgki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastsani)+" utL " +mformat.dis_gpb(SuryaSiddhanta.sanipastgati)+" ";
                Gdetail+= Find_rasistatus(Gp,7)+"\n";}
            if(Gn.equalsIgnoreCase("/f=")){Gdetail="/fxÚki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastrahu)+" utL " +mformat.dis_gpb(SuryaSiddhanta.rahupastgati)+" ";}
            if(Gn.equalsIgnoreCase("s]=")){Gdetail="s]tÚki^  " +mformat.dis_rgpb(SuryaSiddhanta.pastKetu);}
        }
        return Gdetail;
    }

    public double Getval(int Gno){
        double Gmalikval = 0;
        if(Gno == 1 || Gno == 8 ){ Gmalikval = SuryaSiddhanta.pastmangal;}
        if (Gno == 2 || Gno == 7 ){ Gmalikval =SuryaSiddhanta.pastsukra;}
        if (Gno == 3 || Gno == 6 ){ Gmalikval = SuryaSiddhanta.pastbudha;}
        if (Gno == 4 ){ Gmalikval = SuryaSiddhanta.pastchandra;}
        if (Gno == 5 ){ Gmalikval = SuryaSiddhanta.pastsurya;}
        if (Gno == 10 || Gno == 11 ){ Gmalikval = SuryaSiddhanta.pastsani;}
        if (Gno == 9 || Gno == 12 ){ Gmalikval = SuryaSiddhanta.pastguru;}
        return Gmalikval;
    }
    public int Gpos(int Lno,double Grawdegree) {
        int Lagna;
        int Nlno;
        int Find_Gpos=0;
        Lagna = (int)(Grawdegree / 30);
        Lagna = Lagna + 1;
        if (Lagna > 12) {
            Lagna = Lagna - 12;
        }
        if (Lno == Lagna) {
            Find_Gpos = 1;
        } else {
            for (int i = 1; i < 12; i++) {
                Nlno = Lno + i;
                if (Nlno > 12) {Nlno = Nlno - 12;}
                if (Nlno == Lagna) {Find_Gpos = i + 1;
                    break;}
            }
        }
       return Find_Gpos;
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
        Gdetail.setText("");
        Gfal.setText("");
        Typeface ts = Typeface.createFromAsset(getAssets(), "Fonts/Times_Reg.otf");
        Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
        Gfal.setTypeface(ts);
        if(Public_veriable.kundnumber==102)	{ //bhab kundali sandhi detail
            String labvalue="";
            Gfal.setTypeface(tf);
            for (int i =0;i<24;i++){
                labvalue += mformat.dis_rgpb(SuryaSiddhanta.Bhab[i]*30)+ "   " + mname.Bhabsandhi(i+1)+"\n";}
            Gfal.setText(labvalue);
        }
    }

}
