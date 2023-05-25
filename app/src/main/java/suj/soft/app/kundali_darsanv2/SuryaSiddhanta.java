package suj.soft.app.kundali_darsanv2;
public class SuryaSiddhanta {
    public static double Char =0;
    public static double Belantar=0;
    public static double Dinman =0;
    public static double Chabelan =0;
    public static double  Ahargan=0;
    public static double madyamgati = 0.9856026545889309;//== 4320000 / 1577917828 *360 surya madyam gati
    public static double pastsurya = 0;
    public static double pastchandra = 0;
    public static double pastmangal=0;
    public static double pastbudha=0;
    public static double pastguru=0;
    public static double pastsukra=0;
    public static double pastsani=0;
    public static double pastrahu=0;
    public static double pastKetu=0;

    public static double suryapastgati=0,chandrapastgati=0,mangalpastgati=0,budhapastgati=0,gurupastgati=0,sukrapastgati=0,sanipastgati=0,rahupastgati=0.053002777;
    public static double madyamsurya =0;
    public static double madyamKgati=(4320000 - 0.387) / 1577917828 * 360;
    public static double madyamchandra =0;
    public double madyammangal =0;
    public double madyambudha =0;
    public double madyamguru =0;
    public double madyamsukra =0;
    public double madyamsani =0;
    public static int Suryarasi=0;
    public static double Suryaansa=0;

    public static String MangalBakrimargi="",BudhaBakrimargi="",guruBakrimargi="",sukraBakrimargi="",saniBakrimargi="";


    public static double Eastkal,Bhabeastkal,Janmeast;
    public static double Eastrasi,Bhabrasi, Crasi;//Eastrasi is Lagna
    public static double EastAnsa,BhabAnsa, CAnsa;
    public double Checkeast;
    public double udayman;
    public double RD0,RD1,RD2,RD3,RD4,RD5,RD6,RD7,RD8,RD9,RD10,RD11;
    public static double [] Bhab;

    public  double B,pdesval=0;//to be used for panchang calculation with destantar option
    public static  double SuryodayTime =0;
    public static double SuryastTime =0;
    public static int Dayno =0;
    public static int RasiNo=0;
    public static int KRN=0;//karan no
    public static double karanvalue=0;

    public static int Gattithi=0;
    public static int TodayTith=0;
    public static double TodayTithAnsa=0;
    public static double TithiBhukta=0;
    public static double TithiBhabog=0;
    public static int GatNakchatra=0;
    public static double NakBhukta=0;
    public static double NakBhabog=0;
    public static int Npau=0;
    public static double CalculatedNak=0;
    public static int GatYoga=0;
    public static double YogaAnsa =0;
    double Janmtime,Btime,Bhr,Bmin,Bsec;

    public static double NetAhargan =0;

    public void Getstarted(){
        Refresh_Data();
        Finding_Janmasamay();
        suryasindhata_Aspertime();
        Calculate_bhabog();
        Public_veriable.newtimecal=Janmtime;
        suryasindhata_Aspertime();
        Bhab_lagna();
        Get_Bhabpasta();
    }
    public void Calculate_bhabog(){

        double LNT =0;
        double TET = Janmeast* 2.5 / 60;
        suryasindhata_basic();
        double TNT = Get_GP_Nachatra(0);
        double CalTime = Public_veriable.newtimecal + Public_veriable.samaydiff;

        if(Janmtime >= CalTime){
            Public_veriable.Ndt= Public_veriable.Ndt+1;
            suryasindhata_basic();
            LNT = Get_GP_Nachatra(0);
            NakBhukta = TET - TNT;
            NakBhabog = 60 - TNT + LNT;
            if( NakBhukta < 0){NakBhukta = NakBhabog + NakBhukta;}
            Public_veriable.Ndt= Public_veriable.Ndt-1;
        }else{
            Public_veriable.Ndt= Public_veriable.Ndt-1;
            suryasindhata_basic();
            LNT = Get_GP_Nachatra(0);
            if (LNT < 60){
                NakBhukta = 60 + TET - LNT;
                NakBhabog = 60 + TNT - LNT;
                if( NakBhukta >= NakBhabog){NakBhukta = NakBhukta - NakBhabog;}

                Public_veriable.Ndt= Public_veriable.Ndt+1;
            } else{
                Public_veriable.Ndt= Public_veriable.Ndt-1;
                suryasindhata_basic();
                double lnt2 = Get_GP_Nachatra(0);
                NakBhukta = 120 + TET - lnt2;
                NakBhabog = 60 - lnt2 + LNT;
                if( NakBhukta > NakBhabog){NakBhukta = NakBhukta - 60;}
                Public_veriable.Ndt= Public_veriable.Ndt+2;
            }
        }
        if(NakBhabog > 100){
            Public_veriable.newtimecal=Janmtime;
            suryasindhata_Aspertime();
            FindNakchatra(false);}else{FindNakchatra(true);}

    }
    public void Refresh_Data(){
        suryasindhata_basic();
        Public_veriable.newtimecal=SuryodayTime;

    }
    public double Get_GP_Nachatra(int x){
        double nakv =0;
        double Myt,getstep;
        int Gt=0;
        Public_veriable.newtimecal=0;
        if(x==1){Refresh_Data();}
        if( CalculatedNak >= 55 && x == 0 ){
            Public_veriable.newtimecal = SuryodayTime + 0.05;
            Gt = GatNakchatra - 1;
            if(Gt==0){Gt = 27;}
        }else{
            Public_veriable.newtimecal =Math.round((SuryodayTime + CalculatedNak / 2.5)*100000.0)/100000.0;//round upto 5 digit
            Gt = GatNakchatra;
        }
        Myt = Public_veriable.newtimecal;
        getstep = 0.5; //max deviatiion pre formulla Round(Val(txtNachatra.Text) / 2.5, 5) / 10
        suryasindhata_Aspertime();

        if( GatNakchatra == Gt){
            DoNachatrajob( Myt, Gt, getstep, 1);}else{
            DoNachatrajob (Myt, Gt, getstep, 0);}

        if( (Public_veriable.newtimecal - SuryodayTime) < 0) { Get_GP_Nachatra (1);}
        nakv = (Public_veriable.newtimecal - SuryodayTime) * 2.5;
        return nakv;
    }
    public void DoNachatrajob(double Myt,int GT,double A,int B){
        double calNakFD=Math.round(CalculatedNak*10000.0)/10000.0;

        if((calNakFD > 0.0) || (GatNakchatra != GT) ){
            if(B== 1){
                Public_veriable.newtimecal =Public_veriable.newtimecal + A;
                suryasindhata_Aspertime();
                if(GatNakchatra == GT){
                    DoNachatrajob (Public_veriable.newtimecal, GT, A, 1);
                }else{
                    Public_veriable.newtimecal = Public_veriable.newtimecal - A;
                    DoNachatrajob (Public_veriable.newtimecal,GT, A / 10, 1);
                }
            }else{
                Public_veriable.newtimecal = Public_veriable.newtimecal - A;
                suryasindhata_Aspertime();
                if(GatNakchatra == GT){
                    Public_veriable.newtimecal =Public_veriable.newtimecal + A;
                    DoNachatrajob (Public_veriable.newtimecal,GT, A / 10, 0);
                }else{
                    DoNachatrajob (Public_veriable.newtimecal, GT, A, 0);
                }	 }
        }
    }
    public void suryasindhata_basic(){
        FindTithi();
        FindMangal();
        FindBudha();
        Findguru();
        FindSukra();
        FindSani();
        FindRahu();
    }
    public void Bhab_lagna(){
        double 	MySayansurya,Niryansurya,CEastcal;
        int rasinumber;
        CEastcal =Bhabeastkal * 2.5 / 60;
        //pashimnat
        rasinumber = RasiNo ;
        if (((Dinman / 2) < CEastcal) && ((30 + (Dinman / 2)) > CEastcal)){
            Bhabeastkal = CEastcal - Dinman / 2;
            MySayansurya = B + pastsurya;
            Niryansurya = pastsurya;
        }else{
            //purwanat
            if((Dinman / 2) > CEastcal){Bhabeastkal = Dinman / 2 - CEastcal;}
            if((30 + (Dinman / 2)) < CEastcal){Bhabeastkal = Dinman / 2 + 60 - CEastcal;}
            Bhabeastkal = 30 - Bhabeastkal;
            MySayansurya = B + 180 + pastsurya;
            rasinumber = RasiNo + 6;
            Niryansurya = (180 + pastsurya) * -1;
        }

        checkdata((rasinumber + 1) * 30, (((MySayansurya / 30) - rasinumber) * 30), 278, 299, 323, 323, 299, 278);

        if(Bhabeastkal * 60 > Checkeast){
            Bhabeastkal = Bhabeastkal * 60 - Checkeast;
            Mydata (rasinumber,278, 299, 323, 323, 299, 278);
            if(rasinumber>12) {rasinumber=rasinumber-12;}
            Find_Lagna(Bhabeastkal,rasinumber);
            Bhabrasi=Crasi;
            BhabAnsa=CAnsa;}
        else{
            Bhabeastkal = Math.abs(Bhabeastkal * 30 / udayman + Niryansurya);
            Bhabrasi =  (Bhabeastkal / 30);
            BhabAnsa = Bhabeastkal%30;
        }

    }
    public void Finding_Janmasamay(){
        String AMPM;
        if (Public_veriable.tgp==0){
            Bhr = Integer.parseInt (Public_veriable.Clienttob.substring(0,2));
            Bmin = Integer.parseInt (Public_veriable.Clienttob.substring(3,5));
            Bsec = Integer.parseInt (Public_veriable.Clienttob.substring(6,8));
            AMPM = Public_veriable.Clienttob.substring(9,11);
            Btime = Bhr + Bmin/60 + Bsec/3600  ;
            if (AMPM.equals("PM")||AMPM.equals("lk")){
                if(Btime < 12){Janmtime = Btime+Public_veriable.samaydiff + 12;}else{Janmtime = Btime+Public_veriable.samaydiff;}
            }else{
                if(SuryodayTime >Btime+Public_veriable.samaydiff || Btime > 12){
                    if(Btime < 12){Janmtime = Btime+Public_veriable.samaydiff + 24;}else{Janmtime = Btime+Public_veriable.samaydiff + 12;}
                }else{Janmtime = Btime+Public_veriable.samaydiff;}}
        }else{
            String[] tgpd = Public_veriable.Clienttob.split(",");
            Btime	=Double.parseDouble(tgpd[0])+Double.parseDouble(tgpd[1])/60+Double.parseDouble(tgpd[2])/3600;
            Btime = Btime/2.5+SuryodayTime- Public_veriable.samaydiff ;
            if(Btime>24){Janmtime=Btime-24; if(Public_veriable.FEN==0){Public_veriable.AMPM="AM";}else{Public_veriable.AMPM="P Pd";}
                if(Janmtime<1){Janmtime=Janmtime+12;}
            }else{
                if(Btime>12){Janmtime=Btime-12;if(Public_veriable.FEN==0){Public_veriable.AMPM="PM";}else{Public_veriable.AMPM="lk Pd";}
                    if(Janmtime<1){Janmtime=Janmtime+12;}
                }else{
                    Janmtime = Btime;if(Public_veriable.FEN==0){Public_veriable.AMPM="AM";}else{Public_veriable.AMPM="P Pd";}
                }
            }
        }
        Public_veriable.newtimecal=Janmtime;

    }
    public void suryasindhata_Aspertime(){
        suryasindhata_basic();
        Ahargan =  (Ahargan + (Public_veriable.newtimecal - SuryodayTime) / 24);
        Public_veriable.Stimecal=Public_veriable.newtimecal;
        FindSuryaPasta();
        FindSuryodaya(true);
        FindChandraPasta();

        RasiNo = (int)((B + pastsurya) / 30);
        if (RasiNo > 12){ RasiNo = RasiNo - 12;}
        Eastkal = (Public_veriable.newtimecal - SuryodayTime)*60;
        Janmeast=Eastkal;
        Bhabeastkal=Eastkal;//to use in finding Bhabpast

        PrathamLagna();
        FindMangal();
        FindBudha();
        Findguru();
        FindSukra();
        FindSani();
        FindRahu();
        FindTithi_Today();
        FindYoga();
        FindNakchatra(true);
    }
    public  void FindTithi(){
        FindAhargan();
        Ahargan = Ahargan-1;
        FindSuryaPasta();
        FindSuryodaya(false);
        FindChandraPasta();
        double Spastantar = pastchandra - pastsurya;
        if( Spastantar < 0){Spastantar = Spastantar + 360;}

        Gattithi = (int) ((Spastantar- (Spastantar % 12))/12 + 1);
        if( Gattithi > 30){Gattithi = Gattithi - 30;}

        FindAhargan();
        FindSuryaPasta();
        FindSuryodaya(true);
        Ahargan =  (Ahargan-Char+Chabelan);
        FindChandraPasta();
        FindTithi_Today();
        FindYoga();
        FindNakchatra(true);
    }
    public void Get_Bhabpasta(){
        double Bhabantar,Bhabbridhi;
        double Prathamlag=0,Dasamlag=0,Chaturthlag=0,saptamlag=0;
        Prathamlag= Eastrasi;
        Dasamlag=Bhabrasi;
        Bhab= new double[24];
        //writing pratham Lagna
        if( Prathamlag > 12){Prathamlag = Prathamlag - 12;}
        if( Dasamlag > 12){Dasamlag = Dasamlag - 12;}
        //writing chaturtha Lagna
        Chaturthlag = Dasamlag + 6;
        if( Chaturthlag > 12){Chaturthlag = Chaturthlag - 12;}
        //writing SaptamLagna
        saptamlag = Prathamlag + 6;
        if( saptamlag > 12){saptamlag = saptamlag - 12;}
        Bhabantar = ((Chaturthlag - Prathamlag) / 6);

        if( Bhabantar < 0){Bhabantar = Bhabantar + 2;}

        Bhabbridhi = (1 - Bhabantar);
        //Prepare bhabKundali ========================================


        for (int i =0;i<7;i++){
            Bhab[i]=Prathamlag+Bhabantar *i;
            if(Bhab[i]>12){Bhab[i]=Bhab[i]-12;}
        }
        for (int i =1;i<7;i++){
            Bhab[i+6]=Chaturthlag+Bhabbridhi *i;
            if(Bhab[i+6]>12){Bhab[i+6]=Bhab[i+6]-12;}
        }
        for (int i =1;i<7;i++){
            Bhab[i+12]=saptamlag+Bhabantar *i;
            if(Bhab[i+12]>12){Bhab[i+12]=Bhab[i+12]-12;}
        }
        for (int i =1;i<6;i++){
            Bhab[i+18]=Dasamlag+Bhabbridhi *i;
            if(Bhab[i+18]>12){Bhab[i+18]=Bhab[i+18]-12;}
        }
    }
    public void FindMangal(){
        madyammangal = (Ahargan* 2296832) % 1577917828;
        madyammangal= madyammangal/1577917828*360;
        double madyamgati = 0.5240193787835193;//2296832 / 1577917828 *360;
        double mandkendra =madyamsurya-madyammangal;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Tijyantar=0;
        double BFJ =(235 - Math.sin(Cval)*3) / 360 * Math.sin(Cval);
        double BKFJ =(235 - Math.sin(Cval)*3) / 360 * Math.cos(Cval);
        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        double SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        double SigFJ =BFJ/SighKarna;
        double ArdsigFal =(Math.asin(SigFJ)/2)/ Math.PI * 180;
        double SigFSMB;
        if( mandkendra < 180){SigFSMB = ArdsigFal + madyammangal;}else{SigFSMB = madyammangal - ArdsigFal;}
        //Dwitiya sanskar
        double Mandochha = (Ahargan/ 1577917828 * 0.204) * 360 + 129.96;
        mandkendra = Mandochha - SigFSMB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double NBFJ =(75 - Math.sin(Cval)*3) / 360 * Math.sin(Cval);
        double mandfal = Math.abs( Math.asin(NBFJ)* 180 /  Math.PI)/2;
        double ArdMSFB;
        if( mandkendra > 180){ArdMSFB = SigFSMB - mandfal;}else{ArdMSFB = SigFSMB+ mandfal;}
        //Tritiya sansakar
        mandkendra = Mandochha - ArdMSFB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        NBFJ =(75 - Math.sin(Cval)*3) / 360 * Math.sin(Cval);
        double MangalBFJ1 = (75 - Math.sin(Cval) * 3) / 360 *Math.cos(Cval);
        mandfal = Math.abs( Math.asin(NBFJ)* 180 /  Math.PI);
        if(mandkendra>180){ pastmangal = madyammangal-mandfal;}
        if(mandkendra<=180){ pastmangal = madyammangal+mandfal;}
        //Chaturtha Sansakar
        mandkendra = madyamsurya - pastmangal;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        BFJ =(235 - Math.sin(Cval)*3) / 360 * Math.sin(Cval);
        BKFJ =(235 - Math.sin(Cval)*3) / 360 * Math.cos(Cval);

        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        SigFJ =BFJ/SighKarna;
        ArdsigFal =(Math.asin(SigFJ))/ Math.PI * 180;
        if(mandkendra<=180){ pastmangal = pastmangal+ArdsigFal;}
        if(mandkendra>180){ pastmangal = pastmangal-ArdsigFal;}
        //gati sadhan
        double MandSpastGati=0;
        double kendragati = (2296832 - 0.204) * 360 / 1577917828;
        double MandKGF = MangalBFJ1 * kendragati / Math.cos(mandfal *Math.PI / 180);
        if(mandkendra>90 && mandkendra<270){MandSpastGati = madyamgati + MandKGF;}else{
            MandSpastGati = madyamgati - MandKGF;}

        double Gatyantar = madyamKgati - MandSpastGati;
        double SigraGF = (SighKarna - Math.cos(ArdsigFal * Math.PI/ 180)) * Gatyantar / SighKarna;
        mangalpastgati = Math.abs(MandSpastGati + SigraGF);
        if(SigraGF < 0 && (SigraGF + MandSpastGati) < 0){
            MangalBakrimargi = "Bakri";
            mangalpastgati=mangalpastgati*-1;} else{MangalBakrimargi = "Margi";}
        if(pastmangal<0){ pastmangal = pastmangal+360;}
        if(pastmangal>360){ pastmangal = pastmangal-360;}

    }
    public void FindBudha(){
        madyambudha = (Ahargan* 17937076) % 1577917828;
        madyambudha= madyambudha/1577917828*360;
        double madyamgati = 4.09232169471375;//17937076 / 1577917828 *360;
        double mandkendra =madyambudha-madyamsurya;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Tijyantar=0;
        double BFJ =(133 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double BKFJ =(133 - Math.sin(Cval)) / 360 * Math.cos(Cval);
        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        double SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        double SigFJ =BFJ/SighKarna;
        double ArdsigFal =(Math.asin(SigFJ)/2)/ Math.PI * 180;
        double SigFSMB;
        if( mandkendra < 180){SigFSMB = ArdsigFal + madyamsurya;}else{SigFSMB = madyamsurya - ArdsigFal;}
        //Dwitiya sanskar
        double Mandochha = (Ahargan/ 1577917828 *0.368) * 360 + 220.32;
        mandkendra = Mandochha - SigFSMB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double NBFJ =(30 - Math.sin(Cval)*2) / 360 * Math.sin(Cval);
        double mandfal = Math.abs( Math.asin(NBFJ)/2* 180 /  Math.PI);
        double ArdMSFB;
        if( mandkendra > 180){ArdMSFB = SigFSMB - mandfal;}else{ArdMSFB = SigFSMB+ mandfal;}
        //Tritiya sansakar
        mandkendra = Mandochha - ArdMSFB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        NBFJ =(30 - Math.sin(Cval)*2) / 360 * Math.sin(Cval);
        double budhaBFJ1 = (30 - Math.sin(Cval) * 2) / 360 *Math.cos(Cval);
        mandfal = Math.abs( Math.asin(NBFJ)* 180 /  Math.PI);
        if(mandkendra>180){ pastbudha = madyamsurya-mandfal;}
        if(mandkendra<=180){ pastbudha = madyamsurya+mandfal;}
        //Chaturtha Sansakar
        mandkendra = madyambudha - pastbudha;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        BFJ =(133 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        BKFJ =(133 - Math.sin(Cval)) / 360 * Math.cos(Cval);

        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        SigFJ =BFJ/SighKarna;
        ArdsigFal =(Math.asin(SigFJ))/ Math.PI * 180;
        if(mandkendra<=180){ pastbudha = pastbudha+ArdsigFal;}
        if(mandkendra>180){ pastbudha = pastbudha-ArdsigFal;}
        //gati sadhan
        double MandSpastGati=0;
        double kendragati = (4320000 - 0.368) * 360 / 1577917828;
        double MandKGF = budhaBFJ1 * kendragati / Math.cos(mandfal *Math.PI / 180);
        if(mandkendra>90 && mandkendra<270){MandSpastGati = madyamKgati + MandKGF;}else{
            MandSpastGati = madyamKgati - MandKGF;}

        double Gatyantar = madyamgati - MandSpastGati;
        double SigraGF = (SighKarna - Math.cos(ArdsigFal * Math.PI/ 180)) * Gatyantar / SighKarna;
        budhapastgati = Math.abs(MandSpastGati + SigraGF);
        if(SigraGF < 0 && (SigraGF + MandSpastGati) < 0){
            BudhaBakrimargi = "Bakri";
            budhapastgati=budhapastgati*-1;
        } else{BudhaBakrimargi = "Margi";}
        if(pastbudha<0){ pastbudha = pastbudha+360;}
        if(pastbudha>360){ pastbudha = pastbudha-360;}
    }
    public void Findguru(){
        madyamguru = (Ahargan* 364212) % 1577917828;
        madyamguru= madyamguru/1577917828*360;
        double madyamgati = 0.0830945171373018;//364212 / 1577917828 *360;
        double mandkendra =madyamsurya-madyamguru;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Tijyantar=0;
        double BFJ =(70 + Math.sin(Cval)*2) / 360 * Math.sin(Cval);
        double BKFJ =(70 + Math.sin(Cval)*2) / 360 * Math.cos(Cval);
        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        double SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        double SigFJ =BFJ/SighKarna;
        double ArdsigFal =(Math.asin(SigFJ)/2)/ Math.PI * 180;
        double SigFSMB;
        if( mandkendra < 180){SigFSMB = ArdsigFal + madyamguru;}else{SigFSMB = madyamguru - ArdsigFal;}
        //Dwitiya sanskar
        double Mandochha = (Ahargan/ 1577917828  * 0.9) * 360 + 171;
        mandkendra = Mandochha - SigFSMB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double NBFJ =(33 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double mandfal = Math.abs( Math.asin(NBFJ)/2* 180 /  Math.PI);
        double ArdMSFB;
        if( mandkendra > 180){ArdMSFB = SigFSMB - mandfal;}else{ArdMSFB = SigFSMB+ mandfal;}
        //Tritiya sansakar
        mandkendra = Mandochha - ArdMSFB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        NBFJ =(33 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double guruBFJ1 = (33 - Math.sin(Cval) ) / 360 *Math.cos(Cval);
        mandfal = Math.abs( Math.asin(NBFJ)* 180 /  Math.PI);
        if(mandkendra>180){ pastguru = madyamguru-mandfal;}
        if(mandkendra<=180){ pastguru = madyamguru+mandfal;}
        //Chaturtha Sansakar
        mandkendra = madyamsurya - pastguru;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        BFJ =(70+ Math.sin(Cval)*2) / 360 * Math.sin(Cval);
        BKFJ =(70+ Math.sin(Cval)*2) / 360 * Math.cos(Cval);

        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        SigFJ =BFJ/SighKarna;
        ArdsigFal =(Math.asin(SigFJ))/ Math.PI * 180;
        if(mandkendra<=180){ pastguru = pastguru+ArdsigFal;}
        if(mandkendra>180){ pastguru = pastguru-ArdsigFal;}
        //gati sadhan
        double MandSpastGati=0;
        double kendragati = (364212 - 0.9) * 360  / 1577917828;
        double MandKGF = guruBFJ1 * kendragati / Math.cos(mandfal *Math.PI / 180);
        if(mandkendra>90 && mandkendra<270){MandSpastGati = madyamgati + MandKGF;}else{
            MandSpastGati = madyamgati - MandKGF;}

        double Gatyantar = madyamKgati - MandSpastGati;
        double SigraGF = (SighKarna - Math.cos(ArdsigFal * Math.PI/ 180)) * Gatyantar / SighKarna;
        gurupastgati = Math.abs(MandSpastGati + SigraGF);
        if(SigraGF < 0 && (SigraGF + MandSpastGati) < 0){
            guruBakrimargi = "Bakri";
            gurupastgati=gurupastgati*-1;
        } else{guruBakrimargi = "Margi";}
        if(pastguru<0){ pastguru = pastguru+360;}
        if(pastguru>360){ pastguru = pastguru-360;}
    }
    public void FindSani(){
        madyamsani = (Ahargan* 146580) % 1577917828;
        madyamsani= madyamsani/1577917828*360;
        double madyamgati = 0.0334420456272328;//146580 / 1577917828 *360;
        double mandkendra =madyamsurya-madyamsani;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Tijyantar=0;
        double BFJ =(39 + Math.sin(Cval)) / 360 * Math.sin(Cval);
        double BKFJ =(39+ Math.sin(Cval)) / 360 * Math.cos(Cval);
        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        double SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        double SigFJ =BFJ/SighKarna;
        double ArdsigFal =(Math.asin(SigFJ)/2)/ Math.PI * 180;
        double SigFSMB;
        if( mandkendra < 180){SigFSMB = ArdsigFal + madyamsani;}else{SigFSMB = madyamsani - ArdsigFal;}
        //Dwitiya sanskar
        double Mandochha = (Ahargan/ 1577917828  * 0.039) * 360 + 236.61;
        mandkendra = Mandochha - SigFSMB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double NBFJ =(49 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double mandfal = Math.abs( Math.asin(NBFJ)/2* 180 /  Math.PI);
        double ArdMSFB;
        if( mandkendra > 180){ArdMSFB = SigFSMB - mandfal;}else{ArdMSFB = SigFSMB+ mandfal;}
        //Tritiya sansakar
        mandkendra = Mandochha - ArdMSFB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        NBFJ =(49 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double guruBFJ1 = (49 - Math.sin(Cval) ) / 360 *Math.cos(Cval);
        mandfal = Math.abs( Math.asin(NBFJ)* 180 /  Math.PI);
        if(mandkendra>180){ pastsani = madyamsani-mandfal;}
        if(mandkendra<=180){ pastsani = madyamsani+mandfal;}
        //Chaturtha Sansakar
        mandkendra = madyamsurya - pastsani;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        BFJ =(39+ Math.sin(Cval)) / 360 * Math.sin(Cval);
        BKFJ =(39+ Math.sin(Cval)) / 360 * Math.cos(Cval);

        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        SigFJ =BFJ/SighKarna;
        ArdsigFal =(Math.asin(SigFJ))/ Math.PI * 180;
        if(mandkendra<=180){ pastsani = pastsani+ArdsigFal;}
        if(mandkendra>180){ pastsani = pastsani-ArdsigFal;}
        //gati sadhan
        double MandSpastGati=0;
        double kendragati = (146580 - 0.039)  * 360  / 1577917828;
        double MandKGF = guruBFJ1 * kendragati / Math.cos(mandfal *Math.PI / 180);
        if(mandkendra>90 && mandkendra<270){MandSpastGati = madyamgati + MandKGF;}else{
            MandSpastGati = madyamgati - MandKGF;}

        double Gatyantar = madyamKgati - MandSpastGati;
        double SigraGF = (SighKarna - Math.cos(ArdsigFal * Math.PI/ 180)) * Gatyantar / SighKarna;
        sanipastgati = Math.abs(MandSpastGati + SigraGF);
        if(SigraGF < 0 && (SigraGF + MandSpastGati) < 0){
            saniBakrimargi = "Bakri";
            sanipastgati=sanipastgati*-1;
        } else{saniBakrimargi = "Margi";}
        if(pastsani<0){ pastsani = pastsani+360;}
        if(pastsani>360){ pastsani = pastsani-360;}
    }
    public void FindSukra(){
        madyamsukra = (Ahargan* 7022364) % 1577917828;
        madyamsukra= madyamsukra/1577917828*360;
        double madyamgati = 7022364 / 1577917828 *360;
        double mandkendra =madyamsukra-madyamsurya;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Tijyantar=0;
        double BFJ =(262 - Math.sin(Cval)*2) / 360 * Math.sin(Cval);
        double BKFJ =(262 - Math.sin(Cval)*2) / 360 * Math.cos(Cval);
        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        double SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        double SigFJ =BFJ/SighKarna;
        double ArdsigFal =(Math.asin(SigFJ)/2)/ Math.PI * 180;
        double SigFSMB;
        if( mandkendra < 180){SigFSMB = ArdsigFal + madyamsurya;}else{SigFSMB = madyamsurya - ArdsigFal;}
        //Dwitiya sanskar
        double Mandochha = (Ahargan/ 1577917828  * 0.535) * 360 + 79.65;
        mandkendra = Mandochha - SigFSMB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double NBFJ =(12 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double mandfal = Math.abs( Math.asin(NBFJ)/2* 180 /  Math.PI);
        double ArdMSFB;
        if( mandkendra > 180){ArdMSFB = SigFSMB - mandfal;}else{ArdMSFB = SigFSMB+ mandfal;}
        //Tritiya sansakar
        mandkendra = Mandochha - ArdMSFB;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        NBFJ =(12 - Math.sin(Cval)) / 360 * Math.sin(Cval);
        double sukraBFJ1 = (12 - Math.sin(Cval) ) / 360 *Math.cos(Cval);
        mandfal = Math.abs( Math.asin(NBFJ)* 180 /  Math.PI);
        if(mandkendra>180){ pastsukra = madyamsurya-mandfal;}
        if(mandkendra<=180){ pastsukra = madyamsurya+mandfal;}
        //Chaturtha Sansakar
        mandkendra = madyamsukra - pastsukra;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        BFJ =(262- Math.sin(Cval)*2) / 360 * Math.sin(Cval);
        BKFJ =(262- Math.sin(Cval)*2) / 360 * Math.cos(Cval);

        if( mandkendra > 90 || mandkendra < 270){Tijyantar = (1 - BKFJ);}
        if( mandkendra < 90 || mandkendra > 270){Tijyantar = (1 + BKFJ);}
        SighKarna=Math.sqrt(BFJ*BFJ + Tijyantar*Tijyantar) ;
        SigFJ =BFJ/SighKarna;
        ArdsigFal =(Math.asin(SigFJ))/ Math.PI * 180;
        if(mandkendra<=180){ pastsukra = pastsukra+ArdsigFal;}
        if(mandkendra>180){ pastsukra = pastsukra-ArdsigFal;}
        //gati sadhan
        double MandSpastGati=0;
        double kendragati = (4320000 - 0.535) * 360  / 1577917828;
        double MandKGF = sukraBFJ1 * kendragati / Math.cos(mandfal *Math.PI / 180);
        if(mandkendra>90 && mandkendra<270){MandSpastGati = madyamgati + MandKGF;}else{
            MandSpastGati = madyamgati - MandKGF;}

        double Gatyantar = madyamKgati - MandSpastGati;
        double SigraGF = (SighKarna - Math.cos(ArdsigFal * Math.PI/ 180)) * Gatyantar / SighKarna;
        sukrapastgati = Math.abs(MandSpastGati + SigraGF);
        if(SigraGF < 0 && (SigraGF + MandSpastGati) < 0){
            sukraBakrimargi = "Bakri";
            sukrapastgati=sukrapastgati*-1;
        } else{sukraBakrimargi = "Margi";}
        if(pastsukra<0){ pastsukra = pastsukra+360;}
        if(pastsukra>360){ pastsukra = pastsukra-360;}
    }
    public void FindRahu(){

        double Chepak1;
        double Chepak2;
        double chakra = (Ahargan - 1687850.2)/4016 ;
        double Rahuahargan =(Ahargan - 1687850.2)%4016;
        if(Public_veriable.Nyr < 2063){
            Chepak1 = 212.83333333;
            Chepak2 = 27.63333333 + 0.0017568311;}else{

            Chepak1 = 212.8464233;
            Chepak2 = 27.646072227;}

        double CALCULATE = 360 - (Rahuahargan / 19 + Rahuahargan / 2700);
        double Rahudrub = Chepak1 *(int)chakra;

        if(Rahudrub >360){ Rahudrub = Rahudrub%360;}
        pastrahu = CALCULATE - Rahudrub;
        if(pastrahu < 0){ pastrahu = pastrahu + 360;}

        pastrahu = pastrahu + Chepak2;
        if(pastrahu >360){ pastrahu = pastrahu - 360;}

        pastKetu=pastrahu+180;
        if(pastKetu >360){ pastKetu = pastKetu - 360;}

    }

    public void PrathamLagna(){

        double paic = 3.14159265358979;
        boolean PEW = Public_veriable.Plat.contains("S");
        if (PEW) { paic = paic * -1;}

        double charkhand1 = Math.tan((Public_veriable.platcal/60) / 180 * paic) * 120;
        double charkhand2 = Math.tan((Public_veriable.platcal/60) / 180 * paic) * 96;
        double charkhand3 = Math.tan((Public_veriable.platcal/60) / 180 * paic) * 40;

        checkdata((RasiNo + 1) * 30, ((((B + pastsurya) / 30) - RasiNo) * 30), 278 - (int)charkhand1, 299 - (int)charkhand2, 323 - (int)charkhand3, 323 + (int)charkhand3, 299 + (int)charkhand2, 278 + (int)charkhand1);

        if (Eastkal * 2.5 > Checkeast){
            Eastkal = Eastkal * 2.5 - Checkeast;
            Mydata (RasiNo,278 - (int)charkhand1, 299 - (int)charkhand2, 323 - (int)charkhand3, 323 + (int)charkhand3, 299 + (int)charkhand2, 278 + (int)charkhand1);
            Find_Lagna(Eastkal,RasiNo);//calulate eastrasi and eats ansa
            Eastrasi=Crasi;
            EastAnsa=CAnsa;
        }else{
            Eastkal = Eastkal * 2.5 * 30 / udayman +pastsurya;
            Eastrasi =  (Eastkal / 30);
            EastAnsa = Eastkal%30;
        }

    }

    public void checkdata(int rasival,double ansaval, double aa,double ab,double ac, double ad,double ae,double af){
        int myrasi=rasival;
        double Myansa=ansaval;

        if(Myansa < 0){Myansa = Myansa + 360;}
        if(myrasi > 360){myrasi = myrasi - 360;}

        if(myrasi <= 30){
            Checkeast = (30 - Myansa) * aa / 30;
            udayman = aa;}
        if(myrasi > 30 & myrasi <= 60){
            Checkeast = (30 - Myansa) * ab / 30;
            udayman = aa;}
        if( myrasi > 60 & myrasi <= 90) {
            Checkeast = (30 - Myansa) * ac / 30;
            udayman = ab;}
        if( myrasi > 90 & myrasi <= 120){
            Checkeast = (30 - Myansa) * ad / 30;
            udayman = ac;}
        if( myrasi > 120 & myrasi <= 150){
            Checkeast = (30 - Myansa) * ae / 30;
            udayman = ad;}
        if( myrasi > 150 & myrasi <= 180){
            Checkeast = (30 - Myansa) * af / 30;
            udayman = ae;}

        if( myrasi > 180 & myrasi <= 210){
            Checkeast = (30 - Myansa) * af / 30;
            udayman = af;}

        if(myrasi > 210 & myrasi <= 240){
            Checkeast = (30 - Myansa) * ae / 30;
            udayman = af;}
        if(myrasi > 240 & myrasi <= 270){
            Checkeast = (30 - Myansa) * ad / 30;
            udayman = ae;}
        if(myrasi > 270 & myrasi <= 300){
            Checkeast = (30 - Myansa) * ac / 30;
            udayman = ad;}
        if(myrasi > 300 & myrasi <= 330){
            Checkeast = (30 - Myansa) * ab / 30;
            udayman = ac;}
        if(myrasi > 330 & myrasi <= 360){
            Checkeast = (30 - Myansa) * aa / 30;
            udayman = ab;}
    }
    public void Mydata(int Crasino,double r1,double r2,double r3,double r4,double r5,double r6){
        //Placing Udayman values fordeduction
        double aa1=0, aa2=0, aa3=0, aa4=0, aa5=0, aa6=0,aa7=0, aa8=0, aa9=0, aa10=0, aa11=0, aa12=0;
        if (Crasino == 0){ Crasino = 12;}
        if (Crasino > 12){Crasino = Crasino - 12;}

        if (Crasino == 12){
            aa1 = r1;
            aa2 = r2;
            aa3 = r3;
            aa4 = r4;
            aa5 = r5;
            aa6 = r6;
            aa7 = r6;
            aa8 = r5;
            aa9 = r4;
            aa10 = r3;
            aa11 = r2;
            aa12 = r1;}else
        if (Crasino == 1){
            aa1 = r2;
            aa2 = r3;
            aa3 = r4;
            aa4 = r5;
            aa5 = r6;
            aa6 = r6;
            aa7 = r5;
            aa8 = r4;
            aa9 = r3;
            aa10 = r2;
            aa11 = r1;
            aa12 = r1;}else
        if (Crasino == 2){
            aa1 = r3;
            aa2 = r4;
            aa3 = r5;
            aa4 = r6;
            aa5 = r6;
            aa6 = r5;
            aa7 = r4;
            aa8 = r3;
            aa9 = r2;
            aa10 = r1;
            aa11 = r1;
            aa12 = r2;}else
        if (Crasino == 3){
            aa1 = r4;
            aa2 = r5;
            aa3 = r6;
            aa4 = r6;
            aa5 = r5;
            aa6 = r4;
            aa7 = r3;
            aa8 = r2;
            aa9 = r1;
            aa10 = r1;
            aa11 = r2;
            aa12 = r3;}else
        if (Crasino == 4){
            aa1 = r5;
            aa2 = r6;
            aa3 = r6;
            aa4 = r5;
            aa5 = r4;
            aa6 = r3;
            aa7 = r2;
            aa8 = r1;
            aa9 = r1;
            aa10 = r2;
            aa11 = r3;
            aa12 = r4;}else
        if (Crasino == 5){
            aa1 = r6;
            aa2 = r6;
            aa3 = r5;
            aa4 = r4;
            aa5 = r3;
            aa6 = r2;
            aa7 = r1;
            aa8 = r1;
            aa9 = r2;
            aa10 = r3;
            aa11 = r4;
            aa12 = r5;}else
        if (Crasino == 6){
            aa1 = r6;
            aa2 = r5;
            aa3 = r4;
            aa4 = r3;
            aa5 = r2;
            aa6 = r1;
            aa7 = r1;
            aa8 = r2;
            aa9 = r3;
            aa10 = r4;
            aa11 = r5;
            aa12 = r6;}else
        if (Crasino == 7){
            aa1 = r5;
            aa2 = r4;
            aa3 = r3;
            aa4 = r2;
            aa5 = r1;
            aa6 = r1;
            aa7 = r2;
            aa8 = r3;
            aa9 = r4;
            aa10 = r5;
            aa11 = r6;
            aa12 = r6;}else
        if (Crasino == 8){
            aa1 = r4;
            aa2 = r3;
            aa3 = r2;
            aa4 = r1;
            aa5 = r1;
            aa6 = r2;
            aa7 = r3;
            aa8 = r4;
            aa9 = r5;
            aa10 = r6;
            aa11 = r6;
            aa12 = r5;}else
        if (Crasino == 9){
            aa1 = r3;
            aa2 = r2;
            aa3 = r1;
            aa4 = r1;
            aa5 = r2;
            aa6 = r3;
            aa7 = r4;
            aa8 = r5;
            aa9 = r6;
            aa10 = r6;
            aa11 = r5;
            aa12 = r4;}else
        if (Crasino == 10){
            aa1 = r2;
            aa2 = r1;
            aa3 = r1;
            aa4 = r2;
            aa5 = r3;
            aa6 = r4;
            aa7 = r5;
            aa8 = r6;
            aa9 = r6;
            aa10 = r5;
            aa11 = r4;
            aa12 = r3;}else
        if (Crasino == 11){
            aa1 = r1;
            aa2 = r1;
            aa3 = r2;
            aa4 = r3;
            aa5 = r4;
            aa6 = r5;
            aa7 = r6;
            aa8 = r6;
            aa9 = r5;
            aa10 = r4;
            aa11 = r3;
            aa12 = r2;}


        RD0 = aa2;
        RD1 = aa2 + aa3;
        RD2 = aa2 + aa3 + aa4;
        RD3 = aa2 + aa3 + aa4 + aa5;
        RD4 = aa2 + aa3 + aa4 + aa5 + aa6;
        RD5 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7;
        RD6 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7 + aa8;
        RD7 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7 + aa8 + aa9;
        RD8 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7 + aa8 + aa9 + aa10;
        RD9 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7 + aa8 + aa9 + aa10 + aa11;
        RD10 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7 + aa8 + aa9 + aa10 + aa11 + aa12;
        RD11 = aa2 + aa3 + aa4 + aa5 + aa6 + aa7 + aa8 + aa9 + aa10 + aa11 + aa12 + aa1;

    }
    public void Find_Lagna(double newEast,double Crasino){
        int H=0;
        double K=0;

        if(newEast >=RD11){
            K = RD11 - RD0;
            newEast = newEast - RD11;
            H = 12;}else{

            if(newEast >=RD10){
                K = RD11 - RD10;
                newEast = newEast - RD10;
                H = 11;}else{
                if(newEast >=RD9){
                    K = RD10 - RD9;
                    newEast = newEast - RD9;
                    H = 10;}else{
                    if(newEast >=RD8){
                        K = RD9 - RD8;
                        newEast = newEast - RD8;
                        H = 9;}else{
                        if(newEast >=RD7){
                            K = RD8 - RD7;
                            newEast = newEast - RD7;
                            H = 8;}else{
                            if(newEast >=RD6){
                                K = RD7 - RD6;
                                newEast = newEast - RD6;
                                H = 7;}else{
                                if(newEast >=RD5){
                                    K = RD6 - RD5;
                                    newEast = newEast - RD5;
                                    H = 6;}else{
                                    if(newEast >=RD4){
                                        K = RD5 - RD4;
                                        newEast = newEast - RD4;
                                        H = 5;}else{
                                        if(newEast >=RD3){
                                            K = RD4 - RD3;
                                            newEast = newEast - RD3;
                                            H = 4;}else{
                                            if(newEast >=RD2){
                                                K = RD3 - RD2;
                                                newEast = newEast - RD2;
                                                H = 3;}else{
                                                if(newEast >=RD1){
                                                    K = RD2 - RD1;
                                                    newEast = newEast - RD1;
                                                    H = 2;}else{
                                                    if(newEast >=RD0){
                                                        K = RD1 - RD0;
                                                        newEast = newEast - RD0;
                                                        H = 1;}else{
                                                        K = RD0;
                                                        H = 0; }}}}}}}}}}}}

        if(H+Crasino >= 12){H = (int) (H + Crasino - 12);}else{H = (int) (Crasino + H);}

        Crasi = (((H + 1) * 30 + newEast * 30 / K - B) / 30); //' To get in Rasi
        CAnsa = (Crasi-(int)Crasi)*30;

        if ((int)Crasi >= 12) { Crasi =(int) (Crasi - 12);} //' Removing writing 12 in rasi
    }


    public  void FindAhargan(){
        Ahargan_with_Char(0,0);
        FindSuryaPasta();
        Suryoday_with_Ahar();
        Ahargan_with_Char(Char,Chabelan);
    }
    public static void FindSuryaPasta(){
        madyamsurya = (Ahargan* 4320000) % 1577917828;
        madyamsurya=madyamsurya/1577917828*360;

        double mandochha=(Ahargan/ 1577917828 * 0.387) * 360 + 77.13;
        double mandkendra =mandochha-madyamsurya;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Rmandkendra = mandkendra * Math.PI / 180;
        double Sparidhi =(14 - Math.sin(Cval) / 3) / 360 * Math.sin(Rmandkendra);
        double mandfal = Math.abs( Math.asin(Sparidhi)* 180 /  Math.PI);
        if(mandkendra>90||mandkendra<270){
            suryapastgati = madyamgati + (((14 - Math.sin(Cval) / 3) * Math.cos(Cval)) / 360) /Math.cos(mandfal *  Math.PI / 180) * madyamKgati;
        }
        if(mandkendra<90||mandkendra>270){
            suryapastgati = madyamgati - (((14 - Math.sin(Cval) / 3) * Math.cos(Cval)) / 360) /Math.cos(mandfal *  Math.PI / 180) * madyamKgati;
        }
        if(mandkendra>180){ pastsurya = madyamsurya-mandfal;}
        if(mandkendra<=180){ pastsurya = madyamsurya+mandfal;}
        if(pastsurya<0){ pastsurya = 360+pastsurya;}
        if(pastsurya>=360){ pastsurya = pastsurya-360;}
        Suryaansa=pastsurya%30;
        Suryarasi= (int) pastsurya/30;
    }
    public  void FindSuryodaya(boolean gettime){
        double Ansa,spastsayan,spastsayan2,paramkranti,BisubanschapA;
        int Rasi;
        double mytime =0;

        long A = (Public_veriable.Nyr - 2032);
        B = (23.7551194 + A * 0.0163388);
        B = B + (Ahargan - NetAhargan) * 58.82 / 1314000; //1314000=365*60*60 Dainik ayanance increment
        double  G = Suryaansa + B;
        if( G >= 30 ){
            Ansa = G%30; //SayanSurya Ansa
            Rasi = (int) ((Suryarasi * 30) + G-Ansa); //'SayanSurya Rasi in Degree
        }else{
            Ansa = G;//'SayanSurya Ansa
            Rasi = Suryarasi * 30 ; //SayanSurya Rasi
        }
        RasiNo = Rasi / 30; //  ' use to calculate lagna
        Rasi = (int) (Rasi + Ansa);
        spastsayan = madyamsurya + B;
        if( spastsayan >= 360){spastsayan = spastsayan - 360;}
        spastsayan2 = pastsurya + B;
        if( spastsayan2 >= 360){spastsayan2 = spastsayan2 - 360;}

        paramkranti = 23.44250556 - A * 0.00013004;
        paramkranti = paramkranti / 180 * Math.PI;
        BisubanschapA = Math.atan(Math.tan(spastsayan2 * Math.PI / 180) * Math.cos(paramkranti)) * 180 / Math.PI;
        if(spastsayan2 < 90){Belantar = BisubanschapA - spastsayan;}
        if( spastsayan2 >= 90 && spastsayan2 < 270){Belantar = BisubanschapA - spastsayan + 180;}
        if( spastsayan2 >= 270){Belantar = BisubanschapA - spastsayan + 360;}
        if (Math.abs(Belantar) > 5){Belantar = 360 + Belantar;}
        Chabelan = (Belantar) / 360;
        if(pastsurya < 0){pastsurya = 360 +pastsurya;}
        if(pastsurya >360){pastsurya = pastsurya-360;}

        if(gettime){
            Dinman = 2 * (Char * 60 + 15);
            mytime = ((12 - (Dinman) / 5)) + (Belantar / 15);
            SuryodayTime = mytime+pdesval;
            SuryastTime = Dinman / 2.5 + SuryodayTime;
        }

    }

    public static void FindChandraPasta(){
        madyamchandra = (Ahargan* 57753336) % 1577917828;
        madyamchandra=madyamchandra/1577917828*360;
        double madyamgati =13.17635214652;// 57753336 / 1577917828 *360;

        double mandochha=((Ahargan* 488199)% 1577917828)/1577917828 * 360 +90;
        if(mandochha>=360){mandochha = mandochha-360;}
        double mandkendra =mandochha-madyamchandra;
        if(mandkendra<0){mandkendra+=360;}
        if(mandkendra>=360){mandkendra=mandkendra-360;}
        double Cval =0 ;
        if(mandkendra>=90){Cval = 180 - mandkendra;}else{Cval = mandkendra;}
        if(mandkendra>=180){Cval = mandkendra-180;}
        if(mandkendra>=270){Cval = 360 - mandkendra;}
        Cval = Cval *  Math.PI / 180;
        double Rmandkendra = mandkendra * Math.PI / 180;
        double Sparidhi =(32 - Math.sin(Cval) / 3) / 360 * Math.sin(Rmandkendra);
        double mandfal = Math.abs( Math.asin(Sparidhi)* 180 /  Math.PI);
        if(mandkendra>180){ pastchandra = madyamchandra-mandfal;}
        if(mandkendra<=180){ pastchandra = madyamchandra+mandfal;}

        double madyamKgati= madyamgati- 488199 / 1577917828 * 360;
        double Mandgatifal = Math.abs((((32 - Math.sin(Cval) / 3) * Math.cos(Cval)) / 360) / Math.cos(mandfal *  Math.PI / 180) * madyamKgati);

        if(mandkendra<90||mandkendra>270){
            chandrapastgati = madyamgati-Mandgatifal;
        }else{
            chandrapastgati = madyamgati +Mandgatifal;
        }

        if(pastchandra<0){ pastchandra = 360+pastchandra;}
        if(pastchandra>=360){ pastchandra = pastchandra-360;}

        //Chandraansa= pastchandra%30;
        //Chandrarasi = (int) ((pastchandra-Chandraansa)/30);

    }
    public static void FindTithi_Today(){
        double GatiAntar = chandrapastgati - suryapastgati;
        double Spastantar = pastchandra - pastsurya;
        if( Spastantar < 0){Spastantar = Spastantar + 360;}
        TodayTith = (int) ((Spastantar- (Spastantar % 12))/12 + 1);
        if( TodayTith > 30){TodayTith = TodayTith - 30;}
        TodayTithAnsa=  Math.abs((Spastantar%12-12)*60/GatiAntar);
        TithiBhabog =720/GatiAntar;
        TithiBhukta =(Spastantar/12-(int)Spastantar/12)* 720/GatiAntar;
        KRN=Find_karan();
        karanvalue = Math.abs((((Spastantar% 6) - 6) * 60)/ GatiAntar);


    }
    public static void FindNakchatra(boolean calbhabog){
        GatNakchatra = (int) (pastchandra / 13.3333333333333)+ 1;
        if(GatNakchatra > 27){	GatNakchatra = GatNakchatra - 27;}
        double NachatraAnsa = pastchandra % 13.3333333333333 ;
        CalculatedNak=Math.abs((NachatraAnsa-13.3333333333333)*60/chandrapastgati);
        if(!calbhabog){
            NakBhabog=800 / chandrapastgati;
            NakBhukta = NachatraAnsa * 60 / chandrapastgati;
        }
        double Npos =NakBhabog/4;
        for (int i =1;i<5;i++){
            double Tval = i*Npos;
            if(Tval >= NakBhukta){
                Npau =i;
                break; }
        }
    }

    public static void FindYoga(){
        double SCyog =pastchandra+pastsurya;
        double GatiAntar = chandrapastgati + suryapastgati;
        if(SCyog > 360){SCyog = SCyog - 360;}
        GatYoga = (int) (SCyog / 13.3333333333333)+ 1;
        YogaAnsa=Math.abs(((SCyog % 13.3333333333333)-13.3333333333333)*60/GatiAntar);
        //Find Yoga name

    }
    public static int Find_karan(){
        int KN=0;
        if(TithiBhabog/2<TithiBhukta){
            if(TodayTith==1||TodayTith==8||TodayTith==15||TodayTith==22){KN=1;}
            if(TodayTith==2||TodayTith==9||TodayTith==16||TodayTith==23){KN=8;}
            if(TodayTith==3||TodayTith==10||TodayTith==17||TodayTith==24){KN=2;}
            if(TodayTith==4||TodayTith==11||TodayTith==18||TodayTith==25){KN=3;}
            if(TodayTith==5||TodayTith==12||TodayTith==19||TodayTith==26){KN=4;}
            if(TodayTith==6||TodayTith==13||TodayTith==20||TodayTith==27){KN=9;}
            if(TodayTith==7||TodayTith==14||TodayTith==21||TodayTith==28){KN=5;}
            if(TodayTith==29){KN=6;}
            if(TodayTith==30){KN=7;}
        }else{
            if(TodayTith==2||TodayTith==9||TodayTith==16||TodayTith==23){KN=4;}
            if(TodayTith==3||TodayTith==10||TodayTith==17||TodayTith==24){KN=9;}
            if(TodayTith==4||TodayTith==11||TodayTith==18||TodayTith==25){KN=5;}
            if(TodayTith==5||TodayTith==12||TodayTith==19||TodayTith==26){KN=1;}
            if(TodayTith==6||TodayTith==13||TodayTith==20||TodayTith==27){KN=8;}
            if(TodayTith==7||TodayTith==14||TodayTith==21||TodayTith==28){KN=2;}
            if(TodayTith==8||TodayTith==15||TodayTith==22||TodayTith==29){KN=3;}
            if(TodayTith==30){KN=10;}
            if(TodayTith==1){KN=11;}
        }
        return KN;
    }


    public static void Ahargan_with_Char(double Ch, double Bl){

        if(Public_veriable.CorrectAhargan!=0)
        {NetAhargan=((long)(Public_veriable.CorrectAhargan)-1-Public_veriable.plongcal/360+ 0.25);}
        else{
            NetAhargan= ((Public_veriable.Nyr+3044) * 360) - 2;
            NetAhargan= (long)(NetAhargan+NetAhargan / 69 + NetAhargan / 8703)-1
                    -Public_veriable.plongcal/360+ 0.25 + Ch + Bl;
        }

        String[] Sectext = Public_veriable.monthday.split(" ");
        long cmd = 0;
        for (int i =1;i<Public_veriable.Nmn;i++){
            cmd +=Integer.parseInt(Sectext[i]);
        }
        Ahargan=cmd+Public_veriable.Ndt+NetAhargan;
        Dayno = (int) ((6+Ahargan + (Public_veriable.plongcal - 9.55) / 360)%7);
        if(Dayno==0){Dayno=7;}
    }
    public  void Suryoday_with_Ahar(){
        double Ansa,spastsayan,spastsayan2,Rasi2,Rasi3,paramkranti,BisubanschapA;
        double Rasi,krantiansa;
        double AKS=Public_veriable.platcal/60;
        boolean PEW = Public_veriable.Plat.contains("S");
        if (Public_veriable.platcal/60 != 27.7 && PEW){
            AKS = Public_veriable.platcal/60 *-1;}


        long A = (Public_veriable.Nyr - 2032);
        B = (23.7551194 + A * 0.0163388);
        B = B + (Ahargan - NetAhargan) * 58.82 / 1314000; //1314000=365*60*60 Dainik ayanance increment
        double  G = Suryaansa + B;
        if( G >= 30 ){
            Ansa = G%30; //SayanSurya Ansa
            Rasi =  ((Suryarasi * 30) + G-Ansa); //'SayanSurya Rasi in Degree
        }else{
            Ansa = G;//'SayanSurya Ansa
            Rasi = Suryarasi * 30 ; //SayanSurya Rasi
        }
        RasiNo =(int) Rasi / 30; //  ' use to calculate lagna
        Rasi =  (Rasi + Ansa);
        spastsayan = madyamsurya + B;
        if( spastsayan >= 360){spastsayan = spastsayan - 360;}
        spastsayan2 = pastsurya + B;
        if( spastsayan2 >= 360){spastsayan2 = spastsayan2 - 360;}
        if(Rasi >= 90){Rasi2 = 180 - Rasi;}else{Rasi2 = Rasi;}
        if( Rasi >= 180){Rasi2 = Rasi - 180;}
        if( Rasi >= 270){Rasi2 = 360 - Rasi;}
        if( Rasi >= 360){Rasi2 = Rasi - 360;}
        Rasi3 = Rasi2 *  Math.PI / 180;
        paramkranti = 23.44250556 - A * 0.00013004;
        paramkranti = paramkranti / 180 * Math.PI;
        krantiansa = Math.asin(Math.sin(Rasi3) * Math.sin(paramkranti));
        if(spastsayan2 > 180){krantiansa = krantiansa * -1;}
        double Asin2 = -1 * (Math.cos(90.5 * Math.PI/ 180) - Math.sin(krantiansa) * Math.sin(AKS*Math.PI/180));
        Asin2 = Asin2 / (Math.cos(krantiansa) * Math.cos(AKS*Math.PI/180));
        Char=Math.asin(Asin2)/(Math.PI*2);

        BisubanschapA = Math.atan(Math.tan(spastsayan2 * Math.PI / 180) * Math.cos(paramkranti)) * 180 / Math.PI;
        if(spastsayan2 < 90){Belantar = BisubanschapA - spastsayan;}
        if( spastsayan2 >= 90 && spastsayan2 < 270){Belantar = BisubanschapA - spastsayan + 180;}
        if( spastsayan2 >= 270){Belantar = BisubanschapA - spastsayan + 360;}
        if (Math.abs(Belantar) > 5){Belantar = 360 + Belantar;}
        Chabelan = (Belantar) / 360;

    }

}
