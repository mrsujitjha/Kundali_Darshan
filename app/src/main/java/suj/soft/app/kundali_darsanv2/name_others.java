package suj.soft.app.kundali_darsanv2;
public class name_others {

    public String replaced(String mstr){
        String Rstr = "";
        if(Public_veriable.FEN==0){Rstr=mstr;}else{
            if(mstr.indexOf("N")>0){Rstr =mstr.replace("N", " pQ/ ");}
            if(mstr.indexOf("S")>0){Rstr =mstr.replace("S", " blIf)f ");}
            if(mstr.indexOf("E")>0){Rstr =mstr.replace("E", " kÚj{ ");}
            if(mstr.indexOf("W")>0){Rstr =mstr.replace("W", " klZrd ");}
        }
        return Rstr;
    }
    public String find_yoga_name(int dnum, double Nav,double bhukta){
        int X = 0 , p ;
        double abhi;
        String yname = null;
        //dividing 21 and 22 for 3 part as 21,22,23
        abhi = Nav * 13.3333333333333 - bhukta / 60 * 13.3333333333333;

        if( Nav > 20 && Nav < 23){
            p = (int)Nav;
            if( abhi > 266.6666667 && abhi <= 276.6666667){ p = 21;}
            if( abhi > 276.6666667 && abhi <= 280.8888889 ){ p = 22;}
            if( abhi > 280.8888889 && abhi < 293.3333333 ){ p = 23;}
        }else{
            p = (int)Nav;
            if( p > 22) {
                p = p + 1;
            }
        }
        switch(dnum) {
            case 1:  X = p; break;
            case 2:  X = p+24; break;
            case 3:  X = p+20; break;
            case 4:  X = p+16; break;
            case 5:  X = p+12; break;
            case 6:  X = p+8; break;
            case 7:  X = p+4; break;
        }
        if( X > 28){ X = X - 28;}

        switch(X) {
            case 1: yname = "cfgGb";break;
            case 2: yname = "sfn";break;
            case 3: yname = "w'd|";break;
            case 4: yname = "wftf";break;
            case 5: yname = ";f}Do";break;
            case 6: yname = "Wjf+If";break;
            case 7: yname = "Wjh";break;
            case 8: yname = ">LjT;";break;
            case 9: yname = "jh|";break;
            case 10: yname = "d'bu/";break;
            case 11: yname = "%q";break;
            case 12: yname = "ldq";break;
            case 13: yname = "dfg;";break;
            case 14: yname = "kß";break;
            case 15: yname = "n'Da";break;
            case 16: yname = "pTkft";break;
            case 17: yname = "d[To'";break;
            case 18: yname = "sf)f";break;
            case 19: yname = "l;l$";break;
            case 20: yname = "z'e";break;
            case 21: yname = "cd[t ";break;
            case 22: yname = "d'zn";break;
            case 23: yname = "ub";break;
            case 24: yname = "dft+u";break;
            case 25: yname = "/If";break;
            case 26: yname = "r/";break;
            case 27: yname = "l:y/ ";break;
            case 28: yname = "k|jw{ ";break;

        }
        return yname;
    }
    public String changefont(String mstr){
        String Rstr = "";
        if(mstr.indexOf("1")>0){Rstr =mstr.replace("1", "!");}
        if(mstr.indexOf("2")>0){Rstr =mstr.replace("2", "@");}
        if(mstr.indexOf("3")>0){Rstr =mstr.replace("3", "#");}
        if(mstr.indexOf("4")>0){Rstr =mstr.replace("4", "$");}
        if(mstr.indexOf("5")>0){Rstr =mstr.replace("5", "%");}
        if(mstr.indexOf("6")>0){Rstr =mstr.replace("6", "^");}
        if(mstr.indexOf("7")>0){Rstr =mstr.replace("7", "&");}
        if(mstr.indexOf("8")>0){Rstr =mstr.replace("8", "*");}
        if(mstr.indexOf("9")>0){Rstr =mstr.replace("9", "(");}
        return Rstr;
    }
    public String changefontback(String mstr){
        String Rstr = "";
        if(mstr.indexOf("!")>0){Rstr =mstr.replace("!", "1");}
        if(mstr.indexOf("@")>0){Rstr =mstr.replace("@", "2");}
        if(mstr.indexOf("#")>0){Rstr =mstr.replace("#", "3");}
        if(mstr.indexOf("$")>0){Rstr =mstr.replace("$", "4");}
        if(mstr.indexOf("%")>0){Rstr =mstr.replace("%", "5");}
        if(mstr.indexOf("^")>0){Rstr =mstr.replace("^", "6");}
        if(mstr.indexOf("&")>0){Rstr =mstr.replace("&", "7");}
        if(mstr.indexOf("*")>0){Rstr =mstr.replace("*", "8");}
        if(mstr.indexOf("(")>0){Rstr =mstr.replace("(", "9");}
        return Rstr;
    }


    public String nakchtraname(int nav){
        String Nname = "";
        if(Public_veriable.FEN==0){
            switch(nav) {
                case 1: Nname= "Aswini"; break;
                case 2: Nname= "Bharani";break;
                case 3:Nname= "Kritika";break;
                case 4:Nname= "Rohini";break;
                case 5:Nname= "Mrigasira";break;
                case 6:Nname= "Aardra";break;
                case 7:Nname= "Punarbasu";break;
                case 8:Nname= "Tisya";break;
                case 9:Nname= "Asleshha";break;
                case 10:Nname= "Magha";break;
                case 11:Nname= "PurwaFalguni";break;
                case 12:Nname= "UttaraFalguni";break;
                case 13:Nname= "Hasta";break;
                case 14:Nname= "Chitra";break;
                case 15:Nname= "Swati";break;
                case 16:Nname= "Visakha";break;
                case 17:Nname= "Anuradha";break;
                case 18:Nname= "Jyestha";break;
                case 19:Nname= "Mula";break;
                case 20:Nname= "Purwasadha";break;
                case 21:Nname= "Uttarasadha";break;
                case 22:Nname= "Srawana";break;
                case 23:Nname= "Dhanistha";break;
                case 24:Nname= "shatavishha";break;
                case 25:Nname= "Purwabhadra";break;
                case 26:Nname= "UttaraBhadra";break;
                case 27:Nname= "Rewati";break;

            }
        }else{
            switch(nav) {
                case 1: Nname= "clZjgL"; break;
                case 2: Nname= "e/)fL";break;
                case 3:Nname= "s[lQsf";break;
                case 4:Nname= "/f]lx)fL";break;
                case 5:Nname= "d[uzL/f";break;
                case 6:Nname= "cfb|f{";break;
                case 7:Nname= "k'gj{;Ú";break;
                case 8:Nname= "ltio";break;
                case 9:Nname= "cZn]iff";break;
                case 10:Nname= "d#f";break;
                case 11:Nname= "k'j{kmfNuÚgL";break;
                case 12:Nname= "pQ/kmfNuÚgL";break;
                case 13:Nname= "x:tf";break;
                case 14:Nname= "lrqf";break;
                case 15:Nname= ":jftL";break;
                case 16:Nname= "ljzfvf";break;
                case 17:Nname= "cgÚ/fwf";break;
                case 18:Nname= "Ho]i&f";break;
                case 19:Nname= "d'n";break;
                case 20:Nname= "k'j{iff(f";break;
                case 21:Nname= "pQ/fiff(f";break;
                case 22:Nname= ">j)f";break;
                case 23:Nname= "wlgi&f";break;
                case 24:Nname= "ztleiff";break;
                case 25:Nname= "k'j{efb|";break;
                case 26:Nname= "pQ/efb|";break;
                case 27:Nname= "/]jtL";break;

            }
        }
        return Nname;
    }
    public String sambatsarname(int nav){
        String Nname = "";
        if(Public_veriable.FEN==0){
            switch(nav) {
                case 1: Nname= "Prabhab"; break;
                case 2: Nname= "Viwabha";break;
                case 3:Nname= "Shukla";break;
                case 4:Nname= "Pramoda";break;
                case 5:Nname= "Prajapati";break;
                case 6:Nname= "Angira";break;
                case 7:Nname= "Shrimukha";break;
                case 8:Nname= "Bhawa";break;
                case 9:Nname= "Yuwa";break;
                case 10:Nname= "Dhata";break;
                case 11:Nname= "Ishora";break;
                case 12:Nname= "Bahudhanya";break;
                case 13:Nname= "Pramathi";break;
                case 14:Nname= "Vikrama";break;
                case 15:Nname= "Brishha";break;
                case 16:Nname= "Chitrabhanu";break;
                case 17:Nname= "Subhanu";break;
                case 18:Nname= "Tarana";break;
                case 19:Nname= "Parthiwa";break;
                case 20:Nname= "Abyaya";break;
                case 21:Nname= "Sarwajit";break;
                case 22:Nname= "Sarwadhari";break;
                case 23:Nname= "Virodhi";break;
                case 24:Nname= "Vikriti";break;
                case 25:Nname= "Khara";break;
                case 26:Nname= "Nandana";break;
                case 27:Nname= "Bijaya";break;
                case 28:Nname = "jaya" ;break;
                case 29:Nname = "Manmatha" ;break;
                case 30:Nname = "Durmukha" ;break;
                case 31:Nname = "Hemalamba" ;break;
                case 32:Nname = "Bilamba" ;break;
                case 33:Nname = "Bikari" ;break;
                case 34:Nname = "Sharwari" ;break;
                case 35:Nname = "Plawa" ;break;
                case 36:Nname = "Shubhakrit" ;break;
                case 37:Nname = "Shobhan" ;break;
                case 38:Nname = "Krodhi" ;break;
                case 39:Nname = "Vishwabasu" ;break;
                case 40:Nname = "Parabhab" ;break;
                case 41:Nname = "Plawanga" ;break;
                case 42:Nname = "Kilak" ;break;
                case 43:Nname = "Shaumya" ;break;
                case 44:Nname = "Sadharana" ;break;
                case 45:Nname = "Virodhakrit" ;break;
                case 46:Nname = "Paridhawi" ;break;
                case 47:Nname = "Pramadi" ;break;
                case 48:Nname = "Ananda" ;break;
                case 49:Nname = "Rakshasa" ;break;
                case 50:Nname = "Nala" ;break;
                case 51:Nname = "Pingala" ;break;
                case 52:Nname = "Kalayukta" ;break;
                case 53:Nname = "Siddharthi" ;break;
                case 54:Nname = "Raudra" ;break;
                case 55:Nname = "Durmati" ;break;
                case 56:Nname = "Dundubhi" ;break;
                case 57:Nname = "Rudhirodgari" ;break;
                case 58:Nname = "Raktaksha" ;break;
                case 59:Nname = "Krodhana" ;break;
                case 60:Nname = "Kshaya" ;break;

            }
        }else{
            switch(nav) {
                case 1: Nname= " k|ej "; break;
                case 2: Nname= " ljej ";break;
                case 3:Nname= " zÚSn ";break;
                case 4:Nname= " k|df]b ";break;
                case 5:Nname= " k|hfklt ";break;
                case 6:Nname= " c+lu/f ";break;
                case 7:Nname= ">LdÚv ";break;
                case 8:Nname= "efj ";break;
                case 9:Nname= "o'jf";break;
                case 10:Nname= "wftf";break;
                case 11:Nname= "O{Zj/";break;
                case 12:Nname= "axÚwfGo";break;
                case 13:Nname= "k|dfyL";break;
                case 14:Nname= "ljqmd";break;
                case 15:Nname= "j[if";break;
                case 16:Nname= "lrqefgÚ'''";break;
                case 17:Nname= "ÚefgÚÚ";break;
                case 18:Nname= "tf/)f";break;
                case 19:Nname= "kfly{j";break;
                case 20:Nname= "cJoo";break;
                case 21:Nname="zj{lht";break;
                case 22:Nname= ",j{wf/L";break;
                case 23:Nname= "lj/f]wL";break;
                case 24:Nname= "ljs[lt";break;
                case 25:Nname= "v/";break;
                case 26:Nname= "gGbg";break;
                case 27:Nname= "ljho";break;
                case 28:Nname= "ho";break;
                case 29:Nname= "dGdy";break;
                case 30:Nname= "bÚdÚ{v";break;
                case 31:Nname= "x]dnDa";break;
                case 32:Nname= "ljnDa";break;
                case 33:Nname= "lasf/L";break;
                case 34:Nname= "zj{/L";break;
                case 35:Nname= "Knj";break;
                case 36:Nname= "z'es[t";break;
                case 37:Nname= "zf]eg";break;
                case 38:Nname= "qmf]wL";break;
                case 39:Nname= "ljZjjfzÚ";break;
                case 40:Nname= "k/fej";break;
                case 41:Nname= "Knj+u";break;
                case 42:Nname= "sLns";break;
                case 43:Nname= ";f}Do";break;
                case 44:Nname= "fwf/)f";break;
                case 45:Nname= "lj/f]ws[t";break;
                case 46:Nname= "kl/wfjL";break;
                case 47:Nname= "k|dfbL";break;
                case 48:Nname= "cfgGb";break;
                case 49:Nname="/fIf]z";break;
                case 50:Nname="gn";break;
                case 51:Nname= "lk+un";break;
                case 52:Nname= "sfnoÚQm";break;
                case 53:Nname= "l$fyL{";break;
                case 54:Nname= "/f}b|";break;
                case 55:Nname= "bÚd{lt";break;
                case 56:Nname= "bÚGbÚle";break;
                case 57:Nname= "?lw/f]buf/L";break;
                case 58:Nname= "/QmfIf";break;
                case 59:Nname= "qmf]wg";break;
                case 60:Nname= "Ifo";break;


            }
        }
        return Nname;
    }
    public String monthname_nep(int mav){
        String Nname = "";

        if(Public_veriable.FEN==0){
            switch(mav) {
                case 1: Nname= "Baisakh"; break;
                case 2: Nname= "Jestha";break;
                case 3:Nname= "Ashadh";break;
                case 4:Nname= "Shrawan";break;
                case 5:Nname= "Bhadra";break;
                case 6:Nname= "Aswin";break;
                case 7:Nname= "Kartik";break;
                case 8:Nname= "Mangsir";break;
                case 9:Nname= "Paush";break;
                case 10:Nname= "Magha";break;
                case 11:Nname= "Falgun";break;
                case 12:Nname= "Chaitra";break;
            }
        }else{
            switch(mav) {
                case 1: Nname= "a}zfv"; break;
                case 2: Nname= "Ho]i&";break;
                case 3:Nname= "cfiff(";break;
                case 4:Nname= ">fj)f";break;
                case 5:Nname= "efb|";break;
                case 6:Nname= "cflZjg";break;
                case 7:Nname= "sflt{s";break;
                case 8:Nname= "dfu{";break;
                case 9:Nname= "kf}if";break;
                case 10:Nname= "df#";break;
                case 11:Nname= "kmfNuÚg";break;
                case 12:Nname= "r}q";break;
            }
        }


        return Nname;
    }
    public String monthname_eng(int mav){
        String Nname = "";

        if(Public_veriable.FEN==0){
            switch(mav) {
                case 1: Nname= "January"; break;
                case 2: Nname= "February";break;
                case 3:Nname= "March";break;
                case 4:Nname= "April";break;
                case 5:Nname= "May";break;
                case 6:Nname= "June";break;
                case 7:Nname= "July";break;
                case 8:Nname= "August";break;
                case 9:Nname= "September";break;
                case 10:Nname= "October";break;
                case 11:Nname= "November";break;
                case 12:Nname= "December";break;
            }
        }else{
            switch(mav) {
                case 1: Nname= "hgj/L"; break;
                case 2: Nname= "km/j/L";break;
                case 3:Nname= "dfr{";break;
                case 4:Nname= "clk|n";break;
                case 5:Nname= "d]";break;
                case 6:Nname= "húg";break;
                case 7:Nname= "hÚnfO{";break;
                case 8:Nname= "cu:t";break;
                case 9:Nname= ";]K^]Da/";break;
                case 10:Nname= "cS^Úa/";break;
                case 11:Nname= "gf]j]Da/";break;
                case 12:Nname= "l*;]Da/";break;
            }
        }
        return Nname;
    }
    public String Nakchhatraswami(int Nav){
        String Nswami="";

        if(Public_veriable.FEN==0){
            if(Nav==3||Nav==12||Nav==21){Nswami="Surya";}
            if(Nav==4||Nav==13||Nav==22){Nswami="Chandra";}
            if(Nav==5||Nav==14||Nav==23){Nswami="Mangal";}
            if(Nav==6||Nav==15||Nav==24){Nswami="Rahu";}
            if(Nav==7||Nav==16||Nav==25){Nswami="Guru";}
            if(Nav==8||Nav==17||Nav==26){Nswami="Sani";}
            if(Nav==9||Nav==18||Nav==27){Nswami="Budha";}
            if(Nav==10||Nav==19||Nav==1){Nswami="Ketu";}
            if(Nav==11||Nav==20||Nav==2){Nswami="Sukra";}
        }else{
            if(Nav==3||Nav==12||Nav==21){Nswami=";úo{";}
            if(Nav==4||Nav==13||Nav==22){Nswami="rGb|";}
            if(Nav==5||Nav==14||Nav==23){Nswami="d+un";}
            if(Nav==6||Nav==15||Nav==24){Nswami="/fxÚ";}
            if(Nav==7||Nav==16||Nav==25){Nswami="uÚ?";}
            if(Nav==8||Nav==17||Nav==26){Nswami="zlg";}
            if(Nav==9||Nav==18||Nav==27){Nswami="aÚw";}
            if(Nav==10||Nav==19||Nav==1){Nswami="s]tÚ";}
            if(Nav==11||Nav==20||Nav==2){Nswami="zÚqm";}}
        return Nswami;
    }
    public String grahname(int Nav){
        String Rname="";
        if(Public_veriable.FEN==0){
            if(Nav==1){Rname="Surya";}//
            if(Nav==2){Rname="Chandra";}//
            if(Nav==3){Rname="Mangal";}//
            if(Nav==4){Rname="Budha";}//
            if(Nav==5){Rname="Guru";}//
            if(Nav==6){Rname="Sukra";}//
            if(Nav==7){Rname="Sani";}//
            if(Nav==8){Rname="Rahu";}//
            if(Nav==9){Rname="Ketu";}//
        }else{
            if(Nav==1){Rname=";úo{";}//
            if(Nav==2){Rname="rGb|";}//
            if(Nav==3){Rname="d+un";}//
            if(Nav==4){Rname="aÚw";}//
            if(Nav==5){Rname="uÚ?";}//
            if(Nav==6){Rname="zÚqm";}//
            if(Nav==7){Rname="zlg";}//
            if(Nav==8){Rname="/fxÚ";}//
            if(Nav==9){Rname="s]tÚ";}//
        }
        return Rname;
    }
    public String Rituname(int Nav){
        String Rname="";
        if(Public_veriable.FEN==0){
            if(Nav==12){Rname="BASANTA";}//
            if(Nav==11){Rname="SHISHIR";}//
            if(Nav==10){Rname="SHISHIR";}//
            if(Nav==9){Rname="HEMANT";}//
            if(Nav==8){Rname="HEMANT";}//
            if(Nav==7){Rname="SHARAD";}//
            if(Nav==6){Rname="SHARAD";}//
            if(Nav==5){Rname="BARSA";}//
            if(Nav==4){Rname="BARSA";}//
            if(Nav==3){Rname="GRISHMA";}//
            if(Nav==2){Rname="GRISHMA";}//
            if(Nav==1){Rname="BASANTA";}//
        }else{
            if(Nav==12){Rname="a;Gt";}//
            if(Nav==11){Rname="lzlz";}//
            if(Nav==10){Rname="lzlz";}//
            if(Nav==9){Rname="x]dGt";}//
            if(Nav==8){Rname="x]dGt";}//
            if(Nav==7){Rname="z/b";}//
            if(Nav==6){Rname="z/b";}//
            if(Nav==5){Rname="aiff{";}//
            if(Nav==4){Rname="aiff{";}//
            if(Nav==3){Rname="u|Lid";}//
            if(Nav==2){Rname="u|Lid";}//
            if(Nav==1){Rname="a;Gt";}//
        }
        return Rname;
    }
    public String Ritufalid(int Nav){
        String Rname="";
        if(Nav==12){Rname="RT2";}//
        if(Nav==11){Rname="RT1";}//
        if(Nav==10){Rname="RT1";}//
        if(Nav==9){Rname="RT6";}//
        if(Nav==8){Rname="RT6";}//
        if(Nav==7){Rname="RT5";}//
        if(Nav==6){Rname="RT5";}//
        if(Nav==5){Rname="RT4";}//
        if(Nav==4){Rname="RT4";}//
        if(Nav==3){Rname="RT3";}//
        if(Nav==2){Rname="RT3";}//
        if(Nav==1){Rname="RT2";}//
        return Rname;
    }
    public String Rashiswami(int Nav){
        String Rswami="";
        if(Public_veriable.FEN==0){
            if(Nav==1||Nav==8){Rswami="Mangal";}
            if(Nav==2||Nav==7){Rswami="Sukra";}
            if(Nav==3||Nav==6){Rswami="Budha";}
            if(Nav==4){Rswami="Chandra";}
            if(Nav==5){Rswami="Surya";}
            if(Nav==9||Nav==12){Rswami="Guru";}
            if(Nav==10||Nav==11){Rswami="Sani";}
        }else{
            if(Nav==1||Nav==8){Rswami="d+un";}
            if(Nav==2||Nav==7){Rswami="zÚqm";}
            if(Nav==3||Nav==6){Rswami="aÚw";}
            if(Nav==4){Rswami="rGb|";}
            if(Nav==5){Rswami=";úo{";}
            if(Nav==9||Nav==12){Rswami="uÚ?";}
            if(Nav==10||Nav==11){Rswami="zlg";}
        }
        return Rswami;
    }
    public String pakcha(int Nav){
        String Fpakcha="";
        if(Public_veriable.FEN==0){
            if(Nav<=15){Fpakcha="Sukla";}
            if(Nav>15){Fpakcha="Krisna";}

        }else{
            if(Nav<=15){Fpakcha="zÚSn";}
            if(Nav>15){Fpakcha="s[i)f";}

        }
        return Fpakcha;
    }
    public String Rashiname(int Nav){
        String Rname="";
        if(Public_veriable.FEN==0){
            if(Nav==1){Rname="Mesha";}//
            if(Nav==2){Rname="Vrikha";}//
            if(Nav==3){Rname="Mithuna";}//
            if(Nav==4){Rname="Karkata";}//
            if(Nav==5){Rname="Sinmha";}//
            if(Nav==6){Rname="Kanya";}//
            if(Nav==7){Rname="Tula";}//
            if(Nav==8){Rname="Vrischik";}//
            if(Nav==9){Rname="Dhanu";}//
            if(Nav==10){Rname="Makar";}//
            if(Nav==11){Rname="Kumbha";}//
            if(Nav==12){Rname="Min";}//
        }else{
            if(Nav==1){Rname="d]if";}//
            if(Nav==2){Rname="a[if";}//
            if(Nav==3){Rname="ldyÚg";}//
            if(Nav==4){Rname="ss{^";}//
            if(Nav==5){Rname="l;+x";}//
            if(Nav==6){Rname="sGof";}//
            if(Nav==7){Rname="tÚnf";}//
            if(Nav==8){Rname="a[lZrs";}//
            if(Nav==9){Rname="wgÚ";}//
            if(Nav==10){Rname="ds/";}//
            if(Nav==11){Rname="sÚDe";}//
            if(Nav==12){Rname="dLg";}//
        }
        return Rname;
    }
    public String dayname(int Nav){
        String Rname="";
        if(Public_veriable.FEN==0){
            if(Nav==1){Rname="Sunday";}//
            if(Nav==2){Rname="Monday";}//
            if(Nav==3){Rname="Tuesday";}//
            if(Nav==4){Rname="Wednesday";}//
            if(Nav==5){Rname="Thursday";}//
            if(Nav==6){Rname="Friday";}//
            if(Nav==7){Rname="Saturday";}//
        }else{
            if(Nav==1){Rname="cfOtaf/";}//
            if(Nav==2){Rname=";f]daf/";}//
            if(Nav==3){Rname="d+unaf/";}//
            if(Nav==4){Rname="aÚ’waf/";}//
            if(Nav==5){Rname="uÚ?af/";}//
            if(Nav==6){Rname="zÚqmaf/";}//
            if(Nav==7){Rname="z’lgaf/";}//
        }
        return Rname;
    }

    public String Balwastha(double Gval){
        String Rawastha="";
        double sv=0;
        int rv=0;
        rv= (int)Gval/30;
        sv = Gval%30;
        if (rv%2==0){
            if( sv <= 6 ) {Rawastha = "Bala";}
            if( sv > 6 && sv <= 12 ) {Rawastha = "Kumar";}
            if( sv > 12 && sv <= 18 ) {Rawastha = "Youwan";}
            if( sv > 18 && sv <= 24 ) {Rawastha = "Bridha";}
            if( sv > 24 && sv <= 30 ) {Rawastha = "Mrita";}
        }else{
            if( sv <= 6 ) {Rawastha = "Mrita";}
            if( sv > 6 && sv <= 12 ) {Rawastha = "Bridha";}
            if( sv > 12 && sv <= 18 ) {Rawastha = "Youwan";}
            if( sv > 18 && sv <= 24 ) {Rawastha = "Kumar";}
            if( sv > 24 && sv <= 30 ) {Rawastha = "Bala";}
        }

        if(Public_veriable.FEN==1 && Rawastha.equalsIgnoreCase("Bala")){Rawastha = "afn";}
        if(Public_veriable.FEN==1 && Rawastha.equalsIgnoreCase("Kumar")){Rawastha = "sÚdf/";}
        if(Public_veriable.FEN==1 && Rawastha.equalsIgnoreCase("Youwan")){Rawastha = "of]jg";}
        if(Public_veriable.FEN==1 && Rawastha.equalsIgnoreCase("Bridha")){Rawastha = "a[#";}
        if(Public_veriable.FEN==1 && Rawastha.equalsIgnoreCase("Mrita")){Rawastha = "d[t";}
        return Rawastha;
    }
    public String Sayanwastha(int B ,double Gval){
        String Find_Sayanastha="";
        int A=0, C=0;
        double D=0;
        double E=0;
        int F=0;
        A=(int)(Gval/13.33333+1);
        C= (int) (Gval%30);
        D=SuryaSiddhanta.GatNakchatra;
        E=SuryaSiddhanta.Janmeast * 2.5 / 60;

        F=(int)(SuryaSiddhanta.Eastrasi+1);
        int Shayan = (int) ((A * B * C + D + E + F)% 12);

        if(Public_veriable.FEN==0){
            if (Shayan== 1 ) {Find_Sayanastha = "Upawesh";}
            if (Shayan== 2 ) {Find_Sayanastha = "Netrapani";}
            if (Shayan== 3 ) {Find_Sayanastha = "Gaman";}
            if (Shayan== 4 ) {Find_Sayanastha = "Shabha";}
            if (Shayan== 5 ) {Find_Sayanastha = "Aagam";}
            if (Shayan== 6 ) {Find_Sayanastha = "Bhojan";}
            if (Shayan== 7 ) {Find_Sayanastha = "Nritya";}
            if (Shayan== 8 ) {Find_Sayanastha = "Kautuka";}
            if (Shayan== 9 ) {Find_Sayanastha = "Nidra";}
            if (Shayan== 10 ) {Find_Sayanastha = "Chesta";}
            if (Shayan== 11 ) {Find_Sayanastha = "Bichesta";}
            if (Shayan== 12 ||Shayan== 0) {Find_Sayanastha = "Shayan";}
        }else{
            if (Shayan== 1 ) {Find_Sayanastha = "pkj]z";}
            if (Shayan== 2 ) {Find_Sayanastha = "g]qkfl)f";}
            if (Shayan== 3 ) {Find_Sayanastha = "udg";}
            if (Shayan== 4 ) {Find_Sayanastha = ";ef";}
            if (Shayan== 5 ) {Find_Sayanastha = "cfud";}
            if (Shayan== 6 ) {Find_Sayanastha = "ef]hg";}
            if (Shayan== 7 ) {Find_Sayanastha = "g[To";}
            if (Shayan== 8 ) {Find_Sayanastha = "sf}tÚs";}
            if (Shayan== 9 ) {Find_Sayanastha = "lgb|f";}
            if (Shayan== 10 ) {Find_Sayanastha = "r]i^f";}
            if (Shayan== 11 ) {Find_Sayanastha = "lar]i^f";}
            if (Shayan== 12 ||Shayan== 0) {Find_Sayanastha = "zog";}
        }
        return Find_Sayanastha;
    }
    public String Tithiname(int Tn){
        String Tname="";
        if(Public_veriable.FEN==0){
            switch(Tn) {
                case 1: Tname="Parewa";break;
                case 2: Tname="Dwitia";break;
                case 3: Tname="Tritiya";break;
                case 4: Tname="Chauthi";break;
                case 5: Tname="Panchami";break;
                case 6: Tname="Shhasthi";break;
                case 7: Tname="Saptami";break;
                case 8: Tname="Astami";break;
                case 9: Tname="Nawami";break;
                case 10: Tname="Dasami";break;
                case 11: Tname="Ekadasi";break;
                case 12: Tname="Dwadasi";break;
                case 13: Tname="Trayodasi";break;
                case 14: Tname="Chaturdashi";break;
                case 15: Tname="Purnima";break;
                case 16: Tname="Parewa";break;
                case 17: Tname="Dwitia";break;
                case 18: Tname="Tritiya";break;
                case 19: Tname="Chauthi";break;
                case 20: Tname="Panchami";break;
                case 21: Tname="Shhasthi";break;
                case 22: Tname="Saptami";break;
                case 23: Tname="Astami";break;
                case 24: Tname="Nawami";break;
                case 25: Tname="Dasami";break;
                case 26: Tname="Ekadasi";break;
                case 27: Tname="Dwadasi";break;
                case 28: Tname="Trayodasi";break;
                case 29: Tname="Chaturdashi";break;
                case 30: Tname="Aunsi";break;}
        }else{
            switch(Tn) {
                case 1: Tname="k/]jf";break;
                case 2: Tname="låtLof";break;
                case 3: Tname="t[tLof";break;
                case 4: Tname="rf}yL";break;
                case 5: Tname="k+rdL";break;
                case 6: Tname="ifi&L";break;
                case 7: Tname=";KtdL";break;
                case 8: Tname="ci^dL";break;
                case 9: Tname="gjdL";break;
                case 10: Tname="bzdL";break;
                case 11: Tname="PsfbzL";break;
                case 12: Tname="åFbzL";break;
                case 13: Tname="qof]bzL";break;
                case 14: Tname="rtÚb{zL";break;
                case 15: Tname="k'l)f{df";break;
                case 16: Tname="k/]jf";break;
                case 17: Tname="låtLof";break;
                case 18: Tname="t[tLof";break;
                case 19: Tname="rf}yL";break;
                case 20: Tname="k+rdL";break;
                case 21: Tname="ifi&L";break;
                case 22: Tname=";KtdL";break;
                case 23: Tname="ci^dL";break;
                case 24: Tname="gjdL";break;
                case 25: Tname="bzdL";break;
                case 26: Tname="PsfbzL";break;
                case 27: Tname="åFbzL";break;
                case 28: Tname="qof]bzL";break;
                case 29: Tname="rtÚb{zL";break;
                case 30: Tname="cf}+;L";break;}
        }
        return Tname;
    }
    public String Yogname(int Yn){
        String Yname="";
        if(Public_veriable.FEN==0){
            switch(Yn) {
                case 1: Yname="Biskumbha";break;
                case 2: Yname="Priti";break;
                case 3: Yname="Ayusman";break;
                case 4: Yname="Saubhagya";break;
                case 5: Yname="Shobhana";break;
                case 6: Yname="Atiganda";break;
                case 7: Yname="Sukarma";break;
                case 8: Yname="Dhriti";break;
                case 9: Yname="shula";break;
                case 10: Yname="ganda";break;
                case 11: Yname="Briddhi";break;
                case 12: Yname="Dhruba";break;
                case 13: Yname="Byaghata";break;
                case 14: Yname="Harshhana";break;
                case 15: Yname="Bajra";break;
                case 16: Yname="Siddhi";break;
                case 17: Yname="Byatipata";break;
                case 18: Yname="Bariyana";break;
                case 19: Yname="Paridha";break;
                case 20: Yname="Shiva";break;
                case 21: Yname="Siddha";break;
                case 22: Yname="Sadhya";break;
                case 23: Yname="Shubha";break;
                case 24: Yname="Shukla";break;
                case 25: Yname="Brahma";break;
                case 26: Yname="Indra";break;
                case 27: Yname="Baidhriti";break;}
        }else{
            switch(Yn) {
                case 1: Yname="laisÚDe";break;
                case 2: Yname="k|Llt";break;
                case 3: Yname="cfoÚidfg";break;
                case 4: Yname=";f}efUo";break;
                case 5: Yname="zf]eg";break;
                case 6: Yname="cltu)*";break;
                case 7: Yname=";Úsd{";break;
                case 8: Yname="w[lt";break;
                case 9: Yname="zÚn";break;
                case 10: Yname="u)*";break;
                case 11: Yname="j[l$";break;
                case 12: Yname="w|Újf";break;
                case 13: Yname="Jof#ft";break;
                case 14: Yname="xif{)f";break;
                case 15: Yname="jh|";break;
                case 16: Yname="l;l$";break;
                case 17: Yname="Joltkft";break;
                case 18: Yname="jl/ofg";break;
                case 19: Yname="kl/#";break;
                case 20: Yname="lzj";break;
                case 21: Yname="l;l$";break;
                case 22: Yname=";fWo";break;
                case 23: Yname="zÚe";break;
                case 24: Yname="zÚSn";break;
                case 25: Yname="a|Dxf";break;
                case 26: Yname="O{Gb|";break;
                case 27: Yname="j}w[lt";break;}
        }
        return Yname;
    }
    public String Adyaakchar(int NN,int PN){
        String Kname="";
        if(Public_veriable.FEN==0){
            if(NN==1){
                switch(PN) {
                    case 1: Kname="CHU";break;
                    case 2: Kname="CHE";break;
                    case 3: Kname="CHO";break;
                    case 4: Kname="LA";break;
                }
            }
            if(NN==2){
                switch(PN) {
                    case 1: Kname="LEE";break;
                    case 2: Kname="LOO";break;
                    case 3: Kname="LE";break;
                    case 4: Kname="LO";break;
                }
            }
            if(NN==3){
                switch(PN) {
                    case 1: Kname="AA";break;
                    case 2: Kname="E";break;
                    case 3: Kname="OO";break;
                    case 4: Kname="AE";break;
                }
            }
            if(NN==4){
                switch(PN) {
                    case 1: Kname="AO";break;
                    case 2: Kname="WAA";break;
                    case 3: Kname="WEE";break;
                    case 4: Kname="WOO";break;
                }
            }

            if(NN==5){
                switch(PN) {
                    case 1: Kname="WE";break;
                    case 2: Kname="WO";break;
                    case 3: Kname="KAA";break;
                    case 4: Kname="KEE";break;
                }
            }
            if(NN==6){
                switch(PN) {
                    case 1: Kname="KOO";break;
                    case 2: Kname="GHA";break;
                    case 3: Kname="ANG";break;
                    case 4: Kname="CHA";break;
                }
            }
            if(NN==7){
                switch(PN) {
                    case 1: Kname="KE";break;
                    case 2: Kname="KO";break;
                    case 3: Kname="HAA";break;
                    case 4: Kname="HI";break;
                }
            }
            if(NN==8){
                switch(PN) {
                    case 1: Kname="HOO";break;
                    case 2: Kname="HE";break;
                    case 3: Kname="HO";break;
                    case 4: Kname="DA";break;
                }
            }
            if(NN==9){
                switch(PN) {
                    case 1: Kname="DEE";break;
                    case 2: Kname="DOO";break;
                    case 3: Kname="DE";break;
                    case 4: Kname="DO";break;
                }
            }
            if(NN==10){
                switch(PN) {
                    case 1: Kname="MAA";break;
                    case 2: Kname="MEE";break;
                    case 3: Kname="MOO";break;
                    case 4: Kname="ME";break;
                }
            }
            if(NN==11){
                switch(PN) {
                    case 1: Kname="MO";break;
                    case 2: Kname="TAA";break;
                    case 3: Kname="TEE";break;
                    case 4: Kname="TOO";break;
                }
            }
            if(NN==12){
                switch(PN) {
                    case 1: Kname="TE";break;
                    case 2: Kname="TO";break;
                    case 3: Kname="PAA";break;
                    case 4: Kname="PEE";break;
                }
            }
            if(NN==13){
                switch(PN) {
                    case 1: Kname="POO";break;
                    case 2: Kname="SHA";break;
                    case 3: Kname="ANR";break;
                    case 4: Kname="THA";break;
                }
            }
            if(NN==14){
                switch(PN) {
                    case 1: Kname="PE";break;
                    case 2: Kname="PO";break;
                    case 3: Kname="RAA";break;
                    case 4: Kname="REE";break;
                }
            }
            if(NN==15){
                switch(PN) {
                    case 1: Kname="ROO";break;
                    case 2: Kname="RE";break;
                    case 3: Kname="RO";break;
                    case 4: Kname="TAA";break;
                }
            }
            if(NN==16){
                switch(PN) {
                    case 1: Kname="TEE";break;
                    case 2: Kname="TOO";break;
                    case 3: Kname="TE";break;
                    case 4: Kname="TO";break;
                }
            }
            if(NN==17){
                switch(PN) {
                    case 1: Kname="NAA";break;
                    case 2: Kname="NEE";break;
                    case 3: Kname="NOO";break;
                    case 4: Kname="NE";break;
                }
            }
            if(NN==18){
                switch(PN) {
                    case 1: Kname="NO";break;
                    case 2: Kname="YAA";break;
                    case 3: Kname="YEE";break;
                    case 4: Kname="YOO";break;
                }
            }
            if(NN==19){
                switch(PN) {
                    case 1: Kname="YE";break;
                    case 2: Kname="YO";break;
                    case 3: Kname="BHAA";break;
                    case 4: Kname="BHEE";break;
                }
            }
            if(NN==20){
                switch(PN) {
                    case 1: Kname="BHOO";break;
                    case 2: Kname="GHA";break;
                    case 3: Kname="PHAA";break;
                    case 4: Kname="DHAA";break;
                }
            }
            if(NN==21){
                switch(PN) {
                    case 1: Kname="BHE";break;
                    case 2: Kname="BHO";break;
                    case 3: Kname="JAA";break;
                    case 4: Kname="JEE";break;
                }
            }
            if(NN==22){
                switch(PN) {
                    case 1: Kname="KHEE";break;
                    case 2: Kname="KHOO";break;
                    case 3: Kname="KHE";break;
                    case 4: Kname="KHO";break;
                }
            }
            if(NN==23){
                switch(PN) {
                    case 1: Kname="GAA";break;
                    case 2: Kname="GEE";break;
                    case 3: Kname="GOO";break;
                    case 4: Kname="GE";break;
                }
            }
            if(NN==24){
                switch(PN) {
                    case 1: Kname="GO";break;
                    case 2: Kname="SAA";break;
                    case 3: Kname="SEE";break;
                    case 4: Kname="SOO";break;
                }
            }
            if(NN==25){
                switch(PN) {
                    case 1: Kname="SE";break;
                    case 2: Kname="SO";break;
                    case 3: Kname="DAA";break;
                    case 4: Kname="DEE";break;
                }
            }
            if(NN==26){
                switch(PN) {
                    case 1: Kname="DOO";break;
                    case 2: Kname="THAA";break;
                    case 3: Kname="JHA";break;
                    case 4: Kname="YAN";break;
                }
            }
            if(NN==27){
                switch(PN) {
                    case 1: Kname="DE";break;
                    case 2: Kname="DO";break;
                    case 3: Kname="CHAA";break;
                    case 4: Kname="CHEE";break;
                }
            }
        }else{
            if(NN==1){
                switch(PN) {
                    case 1: Kname="rú";break;
                    case 2: Kname="r]";break;
                    case 3: Kname="rf]";break;
                    case 4: Kname="nf";break;
                }
            }
            if(NN==2){
                switch(PN) {
                    case 1: Kname="nL";break;
                    case 2: Kname="nú";break;
                    case 3: Kname="n]";break;
                    case 4: Kname="nf]";break;
                }
            }
            if(NN==3){
                switch(PN) {
                    case 1: Kname="cf";break;
                    case 2: Kname="O";break;
                    case 3: Kname="pm";break;
                    case 4: Kname="P";break;
                }
            }
            if(NN==4){
                switch(PN) {
                    case 1: Kname="cf]";break;
                    case 2: Kname="jf";break;
                    case 3: Kname="jL";break;
                    case 4: Kname="jú";break;
                }
            }

            if(NN==5){
                switch(PN) {
                    case 1: Kname="j]";break;
                    case 2: Kname="jf]";break;
                    case 3: Kname="sf";break;
                    case 4: Kname="sL";break;
                }
            }
            if(NN==6){
                switch(PN) {
                    case 1: Kname="sú";break;
                    case 2: Kname="#";break;
                    case 3: Kname="*=";break;
                    case 4: Kname="%";break;
                }
            }
            if(NN==7){
                switch(PN) {
                    case 1: Kname="s]";break;
                    case 2: Kname="sf]";break;
                    case 3: Kname="xf";break;
                    case 4: Kname="xL";break;
                }
            }
            if(NN==8){
                switch(PN) {
                    case 1: Kname="xú";break;
                    case 2: Kname="x]";break;
                    case 3: Kname="xf]";break;
                    case 4: Kname="*f";break;
                }
            }
            if(NN==9){
                switch(PN) {
                    case 1: Kname="*L";break;
                    case 2: Kname="*ú";break;
                    case 3: Kname="*]";break;
                    case 4: Kname="*f]";break;
                }
            }
            if(NN==10){
                switch(PN) {
                    case 1: Kname="df";break;
                    case 2: Kname="dL";break;
                    case 3: Kname="dú";break;
                    case 4: Kname="d]";break;
                }
            }
            if(NN==11){
                switch(PN) {
                    case 1: Kname="df]";break;
                    case 2: Kname="^f";break;
                    case 3: Kname="^L";break;
                    case 4: Kname="^ú";break;
                }
            }
            if(NN==12){
                switch(PN) {
                    case 1: Kname="^]";break;
                    case 2: Kname="^f]";break;
                    case 3: Kname="kf";break;
                    case 4: Kname="kL";break;
                }
            }
            if(NN==13){
                switch(PN) {
                    case 1: Kname="kú";break;
                    case 2: Kname="if";break;
                    case 3: Kname=")f";break;
                    case 4: Kname="&";break;
                }
            }
            if(NN==14){
                switch(PN) {
                    case 1: Kname="k]";break;
                    case 2: Kname="kf]";break;
                    case 3: Kname="/f";break;
                    case 4: Kname="/L";break;
                }
            }
            if(NN==15){
                switch(PN) {
                    case 1: Kname="?";break;
                    case 2: Kname="/]";break;
                    case 3: Kname="/f]";break;
                    case 4: Kname="tf";break;
                }
            }
            if(NN==16){
                switch(PN) {
                    case 1: Kname="tL";break;
                    case 2: Kname="tú";break;
                    case 3: Kname="t]";break;
                    case 4: Kname="tf]";break;
                }
            }
            if(NN==17){
                switch(PN) {
                    case 1: Kname="gf";break;
                    case 2: Kname="gL";break;
                    case 3: Kname="gú";break;
                    case 4: Kname="g]";break;
                }
            }
            if(NN==18){
                switch(PN) {
                    case 1: Kname="gf]";break;
                    case 2: Kname="of";break;
                    case 3: Kname="oL";break;
                    case 4: Kname="oú";break;
                }
            }
            if(NN==19){
                switch(PN) {
                    case 1: Kname="o]";break;
                    case 2: Kname="of]";break;
                    case 3: Kname="ef";break;
                    case 4: Kname="eL";break;
                }
            }
            if(NN==20){
                switch(PN) {
                    case 1: Kname="eú";break;
                    case 2: Kname="wf";break;
                    case 3: Kname="kmf";break;
                    case 4: Kname="(f";break;
                }
            }
            if(NN==21){
                switch(PN) {
                    case 1: Kname="e]";break;
                    case 2: Kname="ef]";break;
                    case 3: Kname="hf";break;
                    case 4: Kname="hL";break;
                }
            }
            if(NN==22){
                switch(PN) {
                    case 1: Kname="vL";break;
                    case 2: Kname="vú";break;
                    case 3: Kname="v]";break;
                    case 4: Kname="vf]";break;
                }
            }
            if(NN==23){
                switch(PN) {
                    case 1: Kname="uf";break;
                    case 2: Kname="uL";break;
                    case 3: Kname="uú";break;
                    case 4: Kname="u]";break;
                }
            }
            if(NN==24){
                switch(PN) {
                    case 1: Kname="uf]";break;
                    case 2: Kname=";f";break;
                    case 3: Kname=";L";break;
                    case 4: Kname=";ú";break;
                }
            }
            if(NN==25){
                switch(PN) {
                    case 1: Kname=";]";break;
                    case 2: Kname=";f]";break;
                    case 3: Kname="bf";break;
                    case 4: Kname="bL";break;
                }
            }
            if(NN==26){
                switch(PN) {
                    case 1: Kname="bú";break;
                    case 2: Kname="yf";break;
                    case 3: Kname="em";break;
                    case 4: Kname="`";break;
                }
            }
            if(NN==27){
                switch(PN) {
                    case 1: Kname="b]";break;
                    case 2: Kname="bf]";break;
                    case 3: Kname="rf";break;
                    case 4: Kname="rL";break;
                }
            }


        }
        return Kname;
    }
    public String Krname(int Kn){
        String Kname="";
        if(Public_veriable.FEN==0){
            switch(Kn) {
                case 1: Kname="BABA";break;
                case 2: Kname="GARA";break;
                case 3: Kname="BHADRA";break;
                case 4: Kname="BALABA";break;
                case 5: Kname="BANIJA";break;
                case 6: Kname="SAKUNI";break;
                case 7: Kname="NAGA";break;
                case 8: Kname="KAULABA";break;
                case 9: Kname="TAITILA";break;
                case 10: Kname="CHATUSPADA";break;
                case 11: Kname="KISTUGHNA";break;}
        }else{
            switch(Kn) {
                case 1: Kname="aa";break;
                case 2: Kname="u/";break;
                case 3: Kname="eb|f";break;
                case 4: Kname="afna";break;
                case 5: Kname="jl)fh";break;
                case 6: Kname="zs'lg";break;
                case 7: Kname="gfu";break;
                case 8: Kname="sf}nj";break;
                case 9: Kname="t}ltn";break;
                case 10: Kname="rt'ikb";break;
                case 11: Kname="ls+:t'#g";break;}
        }
        return Kname;
    }
    public String Kundaliname(int Kn){
        String Kname="";
        if(Public_veriable.FEN==0){
            switch(Kn) {
                case 100: Kname="Lagna Kundali";break;
                case 101: Kname="Nawamansa Kundali";break;
                case 102: Kname="Bhab Kundali";break;
                case 103: Kname="Saptamansa Kundali";break;
                case 104: Kname="Dwadasansa Kundali";break;
                case 105: Kname="Drishyank Kundali";break;
                case 106: Kname="Trishyank Kundali";break;
                case 107: Kname="Chandra/Rasi Kundali";break;
                case 108: Kname="Hora Kundali";break;
            }
        }else{
            switch(Kn) {
                case 100: Kname="nUg sÚ)*nL";break;
                case 101: Kname="gjdf+z sÚ)*nL";break;
                case 102: Kname="efj  sÚ)*nL";break;
                case 103: Kname=";Ktdf+z sÚ)*nL";break;
                case 104: Kname="åfbzf+z sÚ)*nL";break;
                case 105: Kname="b|]isf)f  sÚ)*nL";break;
                case 106: Kname="lq+zf+z sÚ)*nL";break;
                case 107: Kname="/flz sÚ)*nL";break;
                case 108: Kname="xf]/f sÚ)*nL";break;
            }
        }
        return Kname;
    }
    public String Bhabsandhi(int Kn){
        String Kname="";
        if(Public_veriable.FEN==0){
            switch(Kn) {
                case 1: Kname="Pratham Bhab";break;
                case 2: Kname="Pratham Sandhi";break;
                case 3: Kname="Dwitiya Bhab";break;
                case 4: Kname="Dwitiya Sandhi";break;
                case 5: Kname="Tritiya Bhab";break;
                case 6: Kname="Tritiya Sandhi";break;
                case 7: Kname="Chaturtha Bhab";break;
                case 8: Kname="Chaturtha Sandhi";break;
                case 9: Kname="Pancham Bhab";break;
                case 10: Kname="Pancham Sandhi";break;
                case 11: Kname="Khastam Bhab";break;
                case 12: Kname="Khastam Sandhi";break;
                case 13: Kname="Saptam Bhab";break;
                case 14: Kname="Saptam Sandhi";break;
                case 15: Kname="Austam Bhab";break;
                case 16: Kname="Austam Sandhi";break;
                case 17: Kname="Nawam Bhab";break;
                case 18: Kname="Nawam Sandhi";break;
                case 19: Kname="Dasham Bhab";break;
                case 20: Kname="Dasham Sandhi";break;
                case 21: Kname="Ekadash Bhab";break;
                case 22: Kname="Ekadash Sandhi";break;
                case 23: Kname="Dwadash Bhab";break;
                case 24: Kname="Dwadash Sandhi";break;}
        }else{
            switch(Kn) {
                case 1: Kname="k|yd efj";break;
                case 2: Kname="k|yd ;GwL";break;
                case 3: Kname="låtLo efj";break;
                case 4: Kname="låtLo ;GwL";break;
                case 5: Kname="t[tLo efj";break;
                case 6: Kname="t[tLo ;GwL";break;
                case 7: Kname="rt'y{ efj";break;
                case 8: Kname="rt'y{ ;GwL";break;
                case 9: Kname="k+rd efj";break;
                case 10: Kname="k+rd ;GwL";break;
                case 11: Kname="ifi&d efj";break;
                case 12: Kname="ifi&d ;GwL";break;
                case 13: Kname=";Ktd efj";break;
                case 14: Kname=";Ktd ;GwL";break;
                case 15: Kname="ci^d efj";break;
                case 16: Kname="ci^d ;GwL";break;
                case 17: Kname="gjd efj";break;
                case 18: Kname="gjd ;GwL";break;
                case 19: Kname="bzd efj";break;
                case 20: Kname="bzd ;GwL";break;
                case 21: Kname="Psfbz efj";break;
                case 22: Kname="Psfbz ;GwL";break;
                case 23: Kname="åfbz efj";break;
                case 24: Kname="åfbz ;GwL";break;}
        }
        return Kname;
    }
    public String TARA(int NM){
        String Tname = null;
        if(Public_veriable.FEN==0){
            if( NM == 1 || NM == 10 || NM == 19 ){ Tname = "Janma Tara";}
            if( NM == 2 || NM == 11 || NM == 20 ){ Tname = "Sampat Tara";}
            if( NM == 3 || NM == 12 || NM == 21 ){ Tname = "Bipat Tara";}
            if( NM == 4 || NM == 13 || NM == 22 ){ Tname = "Kshema Tara";}
            if( NM == 5 || NM == 14 || NM == 23 ){ Tname = "Pratyari Tara";}
            if( NM == 6 || NM == 15 || NM == 24 ){ Tname = "Sadhaka Tara";}
            if( NM == 7 || NM == 16 || NM == 25 ){ Tname = "Wadha Tara";}
            if( NM == 8 || NM == 17 || NM == 26 ){ Tname = "Mitra Tara";}
            if( NM == 9 || NM == 18 || NM == 27 ){ Tname = "Atimitra Tara";}
        }else{
            if( NM == 1 || NM == 10 || NM == 19 ){Tname= "hGd tf/f";}
            if( NM == 2 || NM == 11 || NM == 20 ){Tname= ";Dkt ttf/f";}
            if( NM == 3 || NM == 12 || NM == 21 ){Tname= "lakt tf/f";}
            if( NM == 4 || NM == 13 || NM == 22 ){Tname= "if(]df tf/f";}
            if( NM == 5 || NM == 14 || NM == 23 ){Tname= "k|Tof/L tf/f";}
            if( NM == 6 || NM == 15 || NM == 24 ){Tname= ";fws tf/f";}
            if( NM == 7 || NM == 16 || NM == 25 ){Tname= "jw tf/f";}
            if( NM == 8 || NM == 17 || NM == 26 ){Tname= "ldq tf/f";}
            if( NM == 9 || NM == 18 || NM == 27 ){Tname= "ctLldq tf/f";}
        }
        return Tname;
    }
}
