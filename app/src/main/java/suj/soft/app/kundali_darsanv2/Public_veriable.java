package suj.soft.app.kundali_darsanv2;

public class Public_veriable{
    //client detail
    public static String Clientname;
    public static String Clientdob;
    public static String Clientdob2;
    public static String setnepdate;
    public static String Clienttob;
    public static int Clientcob;
    public static int Clientpob;
    public static int datemod;
    public static int gender;
    public static int tgp;
    public static int Clientno=0;
    public static String Stext="";
    public static String Ptext="";
    public static int PRno=0;
    public static int CRno=0;
    public static boolean nodata=false;
    public static int registered=0;
    public static String registeKey="";
    public static String regphone="";

    public static int kundnumber=100;
    public static boolean patroexist=false;

    public static double samaydiff =0;
    public static double newtimecal=0;
    public static double Stimecal=0;
    public static Boolean EN;
    public static String monthday;
    public static long Tyerdays;
    public static double CorrectAhargan;
    public static int patroday=0;
    public static String patrdetail="";

    public static double chvalorg=0 ;
    public static String Chname =null ;
    public static String mpass="QW5RE45ReVvcx40gfG8BGHTkKLlRr";
    public static  String Plat;
    public static  String Plong;
    public static  String Clong;
    public static  double plongcal;
    public static  double platcal;


    public static  long Nyr;
    public static  int Nmn;
    public static  int Ndt;
    public static  long Iyr;
    public static  int Imn;
    public static  int Idt;

    // BISOTTARI DASA
    public static int BDN=0;
    public static int Dtype=0;
    //Kundali grah group

    public static String GrahG1,GrahG2,GrahG3,GrahG4,GrahG5,GrahG6,GrahG7,GrahG8,GrahG9,GrahG10,GrahG11,GrahG12;
    public static String DS = "-",TS = ":";
    public static String clientlist = "";
    public static String AMPM = "";
    // option
    public static int FEN=0;//0 = english font,1 = Nepali
    public static int KB=0;//kundali back ground
    public static int OB=0;//Other back ground
    public static int DK=0;//Default Kundali
    public static int DF=0;//Daily Falit
    public static int FS=0;//Falit font size
    public static int FalT=0,BDNUM=0;//Fal type
    public static String GN="";//general falit for GAN
    public static int loadcal=0;//load nepali calendar date
    private static DBOperation dboper=null;
    private static name_others Fname;
    private static displayformat dformat;
    private static SuryaSiddhanta ssidhant;

    public static void Prepare_Kundali(){
        dboper=new DBOperation();
        Fname= new name_others();
        dformat= new displayformat();
        ssidhant= new SuryaSiddhanta();
        if (EN){
            Ndt = Integer.parseInt(Clientdob.substring(8,10));
            Nmn = Integer.parseInt(Clientdob.substring(5,7));
            Nyr= Integer.parseInt(Clientdob.substring(0,4));
            // change and get Indian date
            changeNEdate(Nyr,Nmn,Ndt);
        }else {
            Iyr = Integer.parseInt(Clientdob.substring(6,10));
            Imn = Integer.parseInt(Clientdob.substring(3,5));
            Idt= Integer.parseInt(Clientdob.substring(0,2));
            // change and get Nepali date
            changeENdate(Iyr,Imn,Idt);
        }
        dboper.getLatlong();
        Find_samayantar();

    }
    public static void find_patroday(long cyr,int cm,int cd){
        dboper=new DBOperation();
        dboper.getnepmonthday(cyr);
        String[] Sectext = monthday.split(" ");
        long cmd = 0;
        for (int i =1;i<cm;i++){
            cmd +=Integer.parseInt(Sectext[i]);
        }
        patroday=(int) (cmd+cd);
    }

    public static  void changeENdate(long y1,int m1,int d1){
        int m;
        double TD,FD,YD = 0,NE;
        long NEP;
        String disp="";
        if(Public_veriable.FEN==0){disp=":";}else{disp="M";}
        m=m1-1;
        TD=365.25 * (y1- 1);

        if (y1%4 ==0){
            String someWords = "0 31 60 91 121 152 182 213 244 274 305 335 366";
            String[] Sectext = someWords.split(" ");
            TD =TD+ Integer.parseInt(Sectext[m]);
        }else{
            String someWords = "0 31 59 90 120 151 181 212 243 273 304 334 365";
            String[] Sectext = someWords.split(" ");
            TD =TD+ Integer.parseInt(Sectext[m]);
        }

        FD = 20735 + (long)TD + d1;
        NE = (long)FD/365.25;

        for ( NEP = (int) (NE-4); NEP < (int) (NE+4); NEP++) {
            if(FD - (366 + (NEP - 2) * 365.25875876) <= 366){
                Nyr = NEP;
                break;
            }
        }

        dboper.getnepmonthday(Nyr);
        String[] Sectext = monthday.split(" ");
        YD = FD + 1112210 - Integer.parseInt(Sectext[14]);
        long cmd = 0;
        long cmdP = 0;
        for (int i =1;i<13;i++){
            cmd +=Integer.parseInt(Sectext[i]);
            if(cmd >= YD){
                Nmn = i;
                Ndt = (int) (YD-cmdP);
                break;
            }
            cmdP +=Integer.parseInt(Sectext[i]);
        }

        Clientdob2= Nyr + disp + Nmn+disp+Ndt;

    }
    public static  void changeNEdate(long y1,int m1,int d1){
        dboper.getnepmonthday(y1);
        long cmd = 0;
        double TD,FD=0,NE;
        long NEP;
        String disp="";
        if(Public_veriable.FEN==0){disp=":";}else{disp="M";}
        String[] Sectext = monthday.split(" ");
        for (int i =2;i < m1+1;i++){
            cmd +=Integer.parseInt(Sectext[i-1]);
        }
        TD = cmd - 20735 - 1112210 + d1 +Integer.parseInt(Sectext[14]);
        NE = (long)TD/365;
        for ( NEP = (int) (NE-4); NEP < (int) (NE+4); NEP++) {
            if(TD - ((NEP -1) * 365.25) <= 366){
                Iyr = NEP;
                FD = TD - (int)(365.25 * (NEP - 1));
                break;
            }
        }
        String mwords;
        if (Iyr%4 ==0){
            mwords = "0 31 60 91 121 152 182 213 244 274 305 335 366";
        }else{
            mwords = "0 31 59 90 120 151 181 212 243 273 304 334 365";
        }

        cmd = 0;
        long cmdp = 0;
        String[] mtext = mwords.split(" ");

        for (int i =1;i<13;i++){
            cmd =Integer.parseInt(mtext[i]);
            cmdp =Integer.parseInt(mtext[i-1]);
            if(cmd >= FD){
                Imn = i;
                Idt = (int) (FD-cmdp);
                break;
            }

        }
        Clientdob2= Idt + disp + Imn+disp+Iyr;
    }
    public static String getengdate(long y1,int m1,int d1){
        String engdate=null;
        dboper.getnepmonthday(y1);
        long cmd = 0;
        double TD,FD=0,NE;
        long NEP;

        String[] Sectext = monthday.split(" ");
        for (int i =2;i < m1+1;i++){
            cmd +=Integer.parseInt(Sectext[i-1]);
        }
        TD = cmd - 20735 - 1112210 + d1 +Integer.parseInt(Sectext[14]);
        NE = (long)TD/365;
        for ( NEP = (int) (NE-4); NEP < (int) (NE+4); NEP++) {
            if(TD - ((NEP -1) * 365.25) <= 366){
                Iyr = NEP;
                FD = TD - (int)(365.25 * (NEP - 1));
                break;
            }
        }
        String mwords;
        if (Iyr%4 ==0){
            mwords = "0 31 60 91 121 152 182 213 244 274 305 335 366";
        }else{
            mwords = "0 31 59 90 120 151 181 212 243 273 304 334 365";
        }

        cmd = 0;
        long cmdp = 0;
        String[] mtext = mwords.split(" ");

        for (int i =1;i<13;i++){
            cmd =Integer.parseInt(mtext[i]);
            cmdp =Integer.parseInt(mtext[i-1]);
            if(cmd >= FD){
                Imn = i;
                Idt = (int) (FD-cmdp);
                break;
            }

        }
        engdate= Idt + "," + Imn+","+Iyr;
        return engdate;
    }
    private static void Find_samayantar(){
        double Pdes =0;
        double Cdes =0;
        int i = Plong.indexOf("E");
        if(i<0){i = Plong.indexOf("W");}
        Pdes = Integer.parseInt(Plong.substring(0,i).trim())*60;
        Pdes +=Integer.parseInt(Plong.substring(i+1));
        int m = Clong.indexOf("E");
        if(m<0){m = Clong.indexOf("W");}
        Cdes = Integer.parseInt(Clong.substring(0,m).trim())*60;
        Cdes +=Integer.parseInt(Clong.substring(m+1));
        int z = Plat.indexOf("N");
        if(z<0){z = Plat.indexOf("S");}
        platcal = Integer.parseInt(Plat.substring(0,z).trim())*60;
        platcal +=Integer.parseInt(Plat.substring(z+1));

        //Finding place is EW from Country
        boolean CEW = Clong.contains("E");
        boolean PEW = Plong.contains("E");

        if(PEW){plongcal = (Pdes/60- 75.766666667);}else {plongcal =(Pdes/60 + 75.766666667)*-1;}

        samaydiff = Math.abs((Cdes - Pdes) / 900);
        if (CEW ==PEW){
            if(CEW){
                if(Cdes>Pdes){ samaydiff = -1*samaydiff;}
            }else{
                if(Pdes>Cdes){ samaydiff = -1*samaydiff;}
            }
        }else{
            if(CEW){ samaydiff = -1*samaydiff;}

        }
        //Toast.makeText(MainActivity.context,"Samay antar : " +  samaydiff, Toast.LENGTH_SHORT).show();
    }
    //====================================================================================================
    public static  double Get_GP_yog(int neg){
        double Myt,getstep,outputval;
        int Gt;
        if(neg== 1){
            ssidhant.suryasindhata_basic();
            newtimecal= SuryaSiddhanta.SuryodayTime;
            ssidhant.suryasindhata_Aspertime();
        }
        Gt = SuryaSiddhanta.GatYoga;

        newtimecal =Math.round((SuryaSiddhanta.SuryodayTime + SuryaSiddhanta.YogaAnsa / 2.5)*100000.0)/100000.0;//round upto 5 digit

        Myt = newtimecal;
        getstep = 0.005; //Max deviatiion
        ssidhant.suryasindhata_Aspertime();

        if( SuryaSiddhanta.GatYoga != Gt){
            Doyogjob (Myt, Gt, getstep, 0);
        }else{
            Doyogjob (Myt, Gt, getstep, 1);
        }
        if( (newtimecal - SuryaSiddhanta.SuryodayTime) < 0){ Get_GP_yog(1);}
        outputval = (newtimecal- SuryaSiddhanta.SuryodayTime) * 2.5;
        return outputval;
    }

    public static  double Get_GP_Tithi(int neg){
        double Myt,Addnno,getstep,outputval;
        int Gt;
        newtimecal=0;
        Gt = SuryaSiddhanta.TodayTith;
        if(neg== 1){
            Gt = Gt + 1;
            if( Gt > 30) { Gt = Gt - 30;}
            ssidhant.suryasindhata_basic();
            newtimecal= SuryaSiddhanta.SuryodayTime;
            ssidhant.suryasindhata_Aspertime();
        }

        newtimecal =Math.round((SuryaSiddhanta.SuryodayTime + SuryaSiddhanta.TodayTithAnsa / 2.5)*100000.0)/100000.0;//round upto 5 digit

        Myt = newtimecal;
        getstep = 0.5; //Max deviatiion
        ssidhant.suryasindhata_Aspertime();

        if( SuryaSiddhanta.TodayTith != Gt){
            Dotithijob (Myt, Gt, getstep, 0);
        }else{
            Dotithijob (Myt, Gt, getstep, 1);
        }
        if( (newtimecal - SuryaSiddhanta.SuryodayTime) < 0){ Get_GP_Tithi(1);}
        outputval = (newtimecal- SuryaSiddhanta.SuryodayTime) * 2.5;
        return outputval;
    }


    public static  void Dotithijob(double Myt , int Gt , double A , int adsk ){
        double sast =(SuryaSiddhanta.pastsurya -(int) SuryaSiddhanta.pastsurya);
        double cast= (SuryaSiddhanta.pastchandra -(int) SuryaSiddhanta.pastchandra);
        if((Math.abs(sast-cast)>.00001)||(SuryaSiddhanta.TodayTith != Gt)){
            if( adsk == 1){
                newtimecal = newtimecal + A;
                ssidhant.suryasindhata_Aspertime();
                if (SuryaSiddhanta.TodayTith != Gt){
                    newtimecal =newtimecal - A;
                    Dotithijob (newtimecal, Gt, A / 10, 1);
                }else{
                    Dotithijob (newtimecal, Gt, A, 1);
                }
            }else{
                newtimecal = newtimecal - A;
                ssidhant.suryasindhata_Aspertime();
                if (SuryaSiddhanta.TodayTith == Gt) {
                    newtimecal = newtimecal + A;
                    Dotithijob (newtimecal, Gt, A / 10, 0);
                }else{
                    Dotithijob (newtimecal, Gt, A, 0);
                }
            }
        }

    }
    public static  void Doyogjob(double Myt , int Gt , double A , int adsk ){
        double calNakFD=Math.round(SuryaSiddhanta.YogaAnsa *10000.0)/10000.0;

        if((calNakFD > 0.0) || (SuryaSiddhanta.GatYoga != Gt) ){
            if( adsk == 1){
                newtimecal = newtimecal + A;
                ssidhant.suryasindhata_Aspertime();
                if (SuryaSiddhanta.GatYoga != Gt){
                    newtimecal =newtimecal - A;
                    Doyogjob (newtimecal, Gt, A / 10, 1);
                }else{
                    Doyogjob (newtimecal, Gt, A, 1);
                }
            }else{
                newtimecal = newtimecal - A;
                ssidhant.suryasindhata_Aspertime();
                if (SuryaSiddhanta.GatYoga == Gt) {
                    newtimecal = newtimecal + A;
                    Doyogjob (newtimecal, Gt, A / 10, 0);
                }else{
                    Doyogjob (newtimecal, Gt, A, 0);
                }
            }
        }

    }

    public static void prepare_patro(int num){
        dboper=new DBOperation();
        Fname= new name_others();
        dformat= new displayformat();
        ssidhant= new SuryaSiddhanta();
        Public_veriable.EN =true;
        ssidhant.pdesval= 0.062222222;

        Nmn=1;
        Ndt=num;
        dboper.getLatlong();
        Find_samayantar();
        String edate = getengdate (Nyr, 1, num);
        String[] Sectext = edate.split(",");
        String EYY = Sectext[2];
        int Emm = Integer.parseInt(Sectext[1]);
        String Edd = Sectext[0];
        String  x0,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18,x19,x20;
        String g1,g2,g3,g4,g5,g6,g7,g8;
        if (Tyerdays>= num){
            ssidhant.FindTithi();
            x0=num+"";
            x1=EYY + " " + Fname.monthname_eng(Emm)+ " " + Edd+"";
            x2=Fname.dayname(SuryaSiddhanta.Dayno);
            x3=Fname.Tithiname(SuryaSiddhanta.TodayTith);
            x18 = Fname.find_yoga_name(SuryaSiddhanta.Dayno, SuryaSiddhanta.GatNakchatra, SuryaSiddhanta.CalculatedNak);
            Double Mvsingle = Get_GP_Tithi(0);
            if (Mvsingle > 60){ Mvsingle = 60.0;}
            x4 = dformat.dis_pb(Mvsingle);
            x5 = dformat.Write_Time_HM(newtimecal, SuryaSiddhanta.SuryodayTime);
            ssidhant.FindTithi();
            x6 = Fname.nakchtraname(SuryaSiddhanta.GatNakchatra);
            Mvsingle = ssidhant.Get_GP_Nachatra(0);
            if (Mvsingle > 60){ Mvsingle = 60.0;}
            x7 = dformat.dis_pb(Mvsingle);
            x8 = dformat.Write_Time_HM(newtimecal, SuryaSiddhanta.SuryodayTime);
            ssidhant.FindTithi();
            x9 = Fname.Yogname(SuryaSiddhanta.GatYoga);
            Mvsingle = Get_GP_yog(0);
            if (Mvsingle > 60){ Mvsingle = 60.0;}
            x10 = dformat.dis_pb(Mvsingle);
            x11 = dformat.Write_Time_HM(newtimecal, SuryaSiddhanta.SuryodayTime);

            x15 = dformat.Write_Time_HM(SuryaSiddhanta.Dinman, 60);
            x16 = dformat.Write_Time_HM(SuryaSiddhanta.SuryodayTime, SuryaSiddhanta.SuryodayTime) ;
            x17="";
            x19 = dformat.Write_Time_HM(SuryaSiddhanta.SuryastTime, SuryaSiddhanta.SuryodayTime);

            ssidhant.suryasindhata_basic();
            Get_GP_Tithi(0);
            double tval =newtimecal;
            ssidhant.suryasindhata_basic();
            newtimecal = SuryaSiddhanta.SuryodayTime;
            ssidhant.suryasindhata_basic();
            ssidhant.suryasindhata_Aspertime();

            g1= SuryaSiddhanta.pastsurya +"";
            g2= SuryaSiddhanta.pastchandra +"";
            g3= SuryaSiddhanta.pastmangal +"";
            g4= SuryaSiddhanta.pastbudha +"";
            g5= SuryaSiddhanta.pastguru +"";
            g6= SuryaSiddhanta.pastsukra +"";
            g7= SuryaSiddhanta.pastsani +"";
            g8= SuryaSiddhanta.pastrahu +"";


            Find_karanvalue (1);
            double kv1 =newtimecal;
            int kn1 = SuryaSiddhanta.KRN;
            Find_karanvalue2 (1);
            newtimecal = Stimecal;
            ssidhant.suryasindhata_Aspertime();
            Find_karanvalue (1);
            double kv2 =newtimecal;
            int kn2 = SuryaSiddhanta.KRN;

            if ((tval - kv1) > 10){
                x12 = Fname.Krname(kn1);
                x13 = dformat.dis_pb((kv1 - SuryaSiddhanta.SuryodayTime) * 2.5);
            }else{
                x12 = Fname.Krname(kn2);
                x13 = dformat.dis_pb((kv2 - SuryaSiddhanta.SuryodayTime) * 2.5);
            }

            ssidhant.suryasindhata_basic();
            tval = SuryaSiddhanta.TodayTithAnsa;
            newtimecal = SuryaSiddhanta.SuryodayTime;
            ssidhant.suryasindhata_Aspertime();
            double XX =((int)(SuryaSiddhanta.pastchandra /30) + 1) * 30 - SuryaSiddhanta.pastchandra;

            if( XX < SuryaSiddhanta.chandrapastgati){
                chvalorg = ((int)(SuryaSiddhanta.pastchandra /30) + 1) * 30;
                Find_RZero (chvalorg - SuryaSiddhanta.pastchandra, SuryaSiddhanta.chandrapastgati);
                x14 = Chname;
            }else{
                x14 = Fname.Rashiname((int)(SuryaSiddhanta.pastchandra /30) + 1);
            }

            if (SuryaSiddhanta.pastsurya > 90 && SuryaSiddhanta.pastsurya <= 270) {
                x20 = "blIf)f";}else{
                x20 = "pQ/";}



            dboper.updatepatro("Y"+Nyr,x0,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18,x19,x20,g1,g2,g3,g4,g5,g6,g7,g8);
        }
    }
    public static void Find_RZero(double chval, double Chg){

        if (newtimecal== 0){
            newtimecal = SuryaSiddhanta.SuryodayTime + (chval / Chg) * 24;
        }else{
            newtimecal = newtimecal + (chval / Chg) * 24;
        }
        ssidhant.suryasindhata_Aspertime();
        if(Math.abs(chvalorg - SuryaSiddhanta.pastchandra) < 0.0001 || Math.abs(chvalorg - SuryaSiddhanta.pastchandra -360) < 0.0001){
            Chname = dformat.Write_Time_HM(newtimecal, SuryaSiddhanta.SuryodayTime);
        }else{
            Find_RZero( chvalorg - SuryaSiddhanta.pastchandra, SuryaSiddhanta.chandrapastgati);
        }

    }

    private static void Find_karanvalue(double incr ){
        for (double x =incr;x<10;x=x+incr){
            if (SuryaSiddhanta.karanvalue <= 0.0002 ){
                break;
            }else{
                newtimecal = newtimecal  + x;
                double curkaran = SuryaSiddhanta.karanvalue;
                ssidhant.suryasindhata_Aspertime();
                if( curkaran < SuryaSiddhanta.karanvalue){
                    newtimecal = newtimecal - x;
                    SuryaSiddhanta.karanvalue = curkaran;
                    Find_karanvalue (incr / 10);
                }
            }
        }

    }

    private static void Find_karanvalue2(double incr ){
        for (double x =incr;x<11;x=x+incr){
            if (SuryaSiddhanta.karanvalue < 0.009 && incr <1){
                break;}
            else{
                newtimecal = newtimecal + x;
                double curkaran = SuryaSiddhanta.karanvalue;
                ssidhant.suryasindhata_Aspertime();
                if( curkaran < SuryaSiddhanta.karanvalue){
                    newtimecal = newtimecal - x;
                    SuryaSiddhanta.karanvalue = curkaran;
                    Find_karanvalue (incr / 10);
                }
            }
        }

    }





















}
