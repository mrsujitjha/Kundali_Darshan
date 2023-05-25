package suj.soft.app.kundali_darsanv2;

public class displayformat {
    public String dis_gpb(double gval){ // +/- ghadi pala bipla
        int ghadi,pala,bipala;
        String gs="",disp="";
        if(Public_veriable.FEN==0){disp=":";}else{disp="M";}
        if(gval<0){gval=gval*-1;
            gs="-";
        }
        ghadi=(int)(gval%30);
        pala=(int)(((gval%30)-ghadi)*60);
        bipala=(int) ((((gval%30)-ghadi)*60 -pala)*60);

        if(bipala >= 60) {
            bipala = bipala - 60;
            pala = pala + 1;}
        if(pala >= 60){
            pala = pala - 60;
            ghadi = ghadi + 1;}
        return gs + ghadi+disp+pala+disp+bipala;
    }
    public String dis_pb(double gval){ // +/-  pala bipla
        int pala,bipala;
        String gs="",disp="";
        if(Public_veriable.FEN==0){disp=":";}else{disp="M";}
        if(gval<0){gval=gval*-1;
            gs="-";
        }
        pala=(int)gval;
        bipala=(int)((gval-pala)*60);
        if(bipala >= 60) {
            bipala = bipala - 60;
            pala = pala + 1;}

        return gs +disp+pala+disp+bipala;
    }
    public String Write_Time_HM(double Mytime, double stime){
        int HR , Min , sec ;
        String newformat=null;
        double sstime ;
        if (Mytime > (24 + stime)) {
            sstime = 24 + stime;}else{
            sstime = Mytime;}
        HR = (int)(sstime*1);

        Min = (int) ((sstime - HR) * 60);
        sec = (int) (((sstime - HR) * 60 - Min) * 60);
        if( sec > 30){sec = 60;}
        if( sec == 60){
            Min = Min + 1;
            sec = 0;
        }
        if( Min == 60){
            HR = HR + 1;
            Min = 0;
        }
        newformat = HR + "M" + Min;
        return newformat;


    }
    public String dis_bdms(double Degree , int bar ){//bar degree min second
        double Min , sec ;
        String Mformat="",disp="";
        if(Public_veriable.FEN==0){disp=":";}else{disp="M";}
        Degree = Math.abs(Degree);
        Min = (Degree - (int)(Degree)) * 60;
        sec = (Min - (int)(Min)) * 60;
        if( sec >= 60){
            Min = Min + 1;
            sec = sec - 60;}
        if( Min >= 60){
            Degree = Degree + 1;
            Min = Min - 60;}

        if( bar>0){
            Mformat = bar + disp + (int)(Degree) + disp+ (int)(Min)+ disp + (int)sec;}else{
            Mformat = (int)(Degree) + disp +(int)(Min) + disp +(int) sec;}
        return Mformat;
    }
    public String dis_rgpb(double gval){//rasi ghadi pala bipla
        int Ras,ghadi,pala,bipala;
        String disp="";
        if(Public_veriable.FEN==0){disp=":";}else{disp="M";}
        Ras=(int) (gval/30);
        ghadi=(int)(gval%30);
        pala=(int)(((gval%30)-ghadi)*60);
        bipala=(int) ((((gval%30)-ghadi)*60 -pala)*60);

        if(bipala >= 60) {
            bipala = bipala - 60;
            pala = pala + 1;}
        if(pala >= 60){
            pala = pala - 60;
            ghadi = ghadi + 1;}
        if(ghadi >= 30){
            ghadi = ghadi - 30;
            Ras = Ras + 1;}
        if(Ras >= 12){Ras = Ras - 12;}

        return Chdigit(Ras) + disp +Chdigit(ghadi)+disp+Chdigit(pala)+disp+Chdigit(bipala);

    }

    private static String Chdigit(int value) {
        if (value < 10)
            return "0" + value;
        else
            return String.valueOf(value);}

}
