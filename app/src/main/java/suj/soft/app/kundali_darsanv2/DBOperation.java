package suj.soft.app.kundali_darsanv2;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.FileReader;
        import java.nio.channels.FileChannel;

        import android.content.ContentValues;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Environment;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;
        import android.widget.Toast;

public class DBOperation {
    DatabaseHelper dbHelper = null;
    private static name_others Fname;
    public DBOperation() {	dbHelper = MainActivity.dbHelper;}

    public void FindLatlong(Spinner spinner,Spinner spinnerM){

        String conid =  spinner.getSelectedItem().toString();
        int CID =Integer.parseInt((conid.substring(0,3)).trim());
        String selectQuery = "SELECT * FROM Country Where(Country._ID="+ CID +")";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        Public_veriable.Clong = cursor.getString(2).trim();
        cursor.close();
        String placeid =  spinnerM.getSelectedItem().toString();
        int pt =placeid.length();
        Public_veriable.Clientpob =Integer.parseInt((placeid.substring(pt-10,pt)).trim());


        selectQuery = "SELECT * FROM Place WHERE(Place.SN="+ Public_veriable.Clientpob +")";//use country code to filter Place._ID="+ CID +" && ....

        cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        Public_veriable.Plong = cursor.getString(3).trim();

        if (Public_veriable.Nyr <2042 && Public_veriable.Clong.equals("86E15")){ Public_veriable.Clong ="85E00";}

        Public_veriable.Plat = cursor.getString(2).trim();
        cursor.close();
        db.close();

    }
    public void getLatlong(){

        String conid =  MainActivity.spinner.getSelectedItem().toString();
        int CID =Integer.parseInt((conid.substring(0,3)).trim());
        String selectQuery = "SELECT * FROM Country Where(Country._ID="+ CID +")";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        Public_veriable.Clong = cursor.getString(2).trim();

        cursor.close();
        selectQuery = "SELECT * FROM Place WHERE(Place.SN="+ Public_veriable.Clientpob +")";//use country code to filter Place._ID="+ CID +" && ....

        cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        Public_veriable.Plong = cursor.getString(3).trim();

        if (Public_veriable.Nyr <2042 && Public_veriable.Clong.equals("86E15")){ Public_veriable.Clong ="85E00";}

        Public_veriable.Plat = cursor.getString(2).trim();
        cursor.close();
        db.close();

    }

    public void getnepmonthday(long myear){

        String selectQuery = "SELECT * FROM Calendar Where(Calendar.Year="+ myear +")";
        Public_veriable.monthday ="";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        for ( int i=0 ; i< 16 ; i++) {
            Public_veriable.monthday += cursor.getString(i)+ " ";
        }

        cursor.close();
        db.close();
        String[] Sectext = Public_veriable.monthday.split(" ");
        Public_veriable.Tyerdays=Long.parseLong(Sectext[13]);
        Public_veriable.CorrectAhargan =Integer.parseInt(Sectext[14]);
    }



    public void getClient(){

        String selectQuery = "SELECT * FROM Client";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToPosition(Public_veriable.Clientno);
        Public_veriable.Clientname =cursor.getString(0);
        Public_veriable.Clientdob =cursor.getString(1);
        Public_veriable.Clienttob =cursor.getString(2);
        Public_veriable.Clientcob =Integer.parseInt(cursor.getString(3));
        Public_veriable.Clientpob =Integer.parseInt(cursor.getString(4));
        Public_veriable.datemod =Integer.parseInt(cursor.getString(5));
        if( Integer.parseInt(cursor.getString(6))>9 ){
            Public_veriable.gender =1;
            Public_veriable.tgp =Integer.parseInt(cursor.getString(6))% 10;
        }else{
            Public_veriable.gender =0;
            Public_veriable.tgp =Integer.parseInt(cursor.getString(6));
        }
        cursor.close();
        db.close();

    }
    public String getfal(String Snf){
        String myfal="";
        String selectQuery = "SELECT * FROM Fal Where(Fal.field1=='"+Snf+"')";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        myfal= cursor.getString(1)+"\n\n"+cursor.getString(2);
        cursor.close();
        db.close();
        return myfal;
    }
    public void loadcurrent(){

        String selectQuery = "SELECT * FROM current";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst ();
        Public_veriable.Clientname =cursor.getString(1);
        Public_veriable.Clientdob =cursor.getString(2);
        Public_veriable.Clienttob =cursor.getString(3);
        Public_veriable.Clientcob =Integer.parseInt(cursor.getString(4));
        Public_veriable.Clientpob =Integer.parseInt(cursor.getString(5));
        Public_veriable.datemod =Integer.parseInt(cursor.getString(6));
        if( Integer.parseInt(cursor.getString(7))>9 ){
            Public_veriable.gender =1;
            Public_veriable.tgp =Integer.parseInt(cursor.getString(7))% 10;
        }else{
            Public_veriable.gender =0;
            Public_veriable.tgp =Integer.parseInt(cursor.getString(7));
        }
        cursor.close();
        db.close();

    }
    public void getregistration(){
        String selectQuery = "SELECT * FROM option";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Public_veriable.DK=0;
        if ( cursor.moveToFirst () ) {
            String[] userreg = cursor.getString(0).split(":");
                   Public_veriable.regphone =userreg[1];
                    Public_veriable.registeKey =userreg[0];
        Public_veriable.FEN =Integer.parseInt(cursor.getString(1));
        Public_veriable.KB =Integer.parseInt(cursor.getString(2));
        Public_veriable.OB =Integer.parseInt(cursor.getString(3));
        Public_veriable.DK =Integer.parseInt(cursor.getString(4));
        Public_veriable.DF =Integer.parseInt(cursor.getString(5));
    }

        cursor.close();
        db.close();
    }
    public void setregistration(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM option";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            ContentValues cv = new ContentValues();
            cv.put("key", Public_veriable.registeKey +":"+Public_veriable.regphone);
            db.update("option",cv,"key<> ?", new String [] {Public_veriable.registeKey});
        }
        cursor.close();
        db.close();
    }

    public void DelClient(){
        if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature.", Toast.LENGTH_SHORT).show();}

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.delete("Client","name= ?", new String [] {String.valueOf(Public_veriable.Clientname)});

        db.close();
        Loadoption_kud();
    }
    public void Delcountry(int Cid){
        if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature.", Toast.LENGTH_SHORT).show();}
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.delete("Country","_ID= ?", new String [] {String.valueOf(Cid)});
        db.delete("Place","ID= ?", new String [] {String.valueOf(Cid)});
        db.close();
        Toast.makeText(MyApp.getContext(),"Country and all place of country deleted sucessfully", Toast.LENGTH_SHORT).show();

    }
    public void DelPlace(int Pid){
        if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature.", Toast.LENGTH_SHORT).show();}
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.delete("Place","SN= ?", new String [] {String.valueOf(Pid)});
        db.close();
        Toast.makeText(MyApp.getContext(),"Place delete sucessfully", Toast.LENGTH_SHORT).show();

    }



    public void Loadoption_kud(){
        Public_veriable.clientlist="";
        String selectQuery = "SELECT * FROM Client";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if ( cursor.moveToFirst () ) {
            Public_veriable.nodata=true;
            do {
                if(Public_veriable.clientlist.length()>0){Public_veriable.clientlist=Public_veriable.clientlist+",";}
                Public_veriable.clientlist+= cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }
    public void Saveoption(){
        if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature and disable options.", Toast.LENGTH_LONG).show();}

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM option";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            ContentValues cv = new ContentValues();
            cv.put("F1", Public_veriable.FEN);
            cv.put("F2", Public_veriable.KB);
            cv.put("F3", Public_veriable.OB);
            cv.put("F4", Public_veriable.DK);
            cv.put("F5", Public_veriable.DF);
            cv.put("F6", Public_veriable.FS);
            db.update("option",cv,"key= ?", new String [] { Public_veriable.registeKey +":"+Public_veriable.regphone});
            Toast.makeText(MyApp.getContext(),"Option set sucessfully", Toast.LENGTH_SHORT).show();
        }
    }
    public void loadoption(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM option";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            Public_veriable.FEN= cursor.getInt(1);
            Public_veriable.KB= cursor.getInt(2);
            Public_veriable.OB= cursor.getInt(3);
            Public_veriable.DK= cursor.getInt(4);
            Public_veriable.DF= cursor.getInt(5);
            Public_veriable.FS= cursor.getInt(6);
        }
        cursor.close();
        db.close();
    }
    public void savecountry(int Cid,String Cname,String Clong){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM Country WHERE(_ID=='"+Cid+"')";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature and disable options.", Toast.LENGTH_LONG).show();}
            ContentValues cv = new ContentValues();
            cv.put("Name",Cname);
            cv.put("Zone", Clong);
            db.update("Country",cv,"_ID= ?", new String [] {String.valueOf(Cid)});
            Toast.makeText(MyApp.getContext(),"Country Detail Edited", Toast.LENGTH_SHORT).show();

        }else{
            if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature.", Toast.LENGTH_SHORT).show();}
            db = dbHelper.getReadableDatabase();
            selectQuery = "Select * FROM Country ORDER BY _ID ASC";
            cursor = db.rawQuery(selectQuery, null);
            cursor.moveToLast ();
            int ncid = 1+cursor.getInt(0);
            ContentValues cv = new ContentValues();
            cv.put("ID", ncid);
            cv.put("Name",Cname);
            cv.put("Zone", Clong);
            db.insert("Country", null,cv );
            Toast.makeText(MyApp.getContext(),"Country Detail added", Toast.LENGTH_SHORT).show();}

        db.close();
    }
    public void savePlace(int Cid,int Pid,String Pname,String Plat,String Plong){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM Place WHERE(SN=='"+Pid+"')";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature and disable options.", Toast.LENGTH_LONG).show();}
            ContentValues cv = new ContentValues();
            cv.put("ID",Cid);
            cv.put("Name", Pname);
            cv.put("Latitude",Plat);
            cv.put("Longitude", Plong);
            db.update("Place",cv,"SN= ?", new String [] {String.valueOf(Pid)});
            Toast.makeText(MyApp.getContext(),"Place Detail Edited", Toast.LENGTH_SHORT).show();

        }else{
            if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature.", Toast.LENGTH_SHORT).show();}
            db = dbHelper.getReadableDatabase();
            selectQuery = "SELECT * FROM Place ORDER BY SN ASC";
            cursor = db.rawQuery(selectQuery, null);
            cursor.moveToLast ();
            int nPid = 1+cursor.getInt(5);
            ContentValues cv = new ContentValues();
            cv.put("ID",Cid);
            cv.put("Name", Pname);
            cv.put("Latitude",Plat);
            cv.put("Longitude", Plong);
            cv.put("SN",nPid);
            db.insert("Place", null,cv );
            Toast.makeText(MyApp.getContext(),"Place Detail added", Toast.LENGTH_SHORT).show();}

        db.close();
    }

    public void SaveClient(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM Client WHERE(Client.name=='"+Public_veriable.Clientname+"')";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature and disable options.", Toast.LENGTH_LONG).show();}
            ContentValues cv = new ContentValues();
            cv.put("name", Public_veriable.Clientname);
            cv.put("date", Public_veriable.Clientdob);
            cv.put("Time", Public_veriable.Clienttob);
            cv.put("Cid", Public_veriable.Clientcob);
            cv.put("Pid", Public_veriable.Clientpob);
            cv.put("BIS", Public_veriable.datemod);
            cv.put("gender", Public_veriable.gender*10 +Public_veriable.tgp);
            db.update("Client",cv,"name= ?", new String [] {String.valueOf(Public_veriable.Clientname)});
            Toast.makeText(MyApp.getContext(),"Client Detail Edited", Toast.LENGTH_SHORT).show();

        }else{
            if(Public_veriable.registered==0){Toast.makeText(MyApp.getContext(), "Register your Kundali Darsan to use all feature.", Toast.LENGTH_SHORT).show();}

            ContentValues cv = new ContentValues();
            cv.put("name", Public_veriable.Clientname);
            cv.put("date", Public_veriable.Clientdob);
            cv.put("Time", Public_veriable.Clienttob);
            cv.put("Cid", Public_veriable.Clientcob);
            cv.put("Pid", Public_veriable.Clientpob);
            cv.put("BIS", Public_veriable.datemod);
            cv.put("gender", Public_veriable.gender*10 +Public_veriable.tgp);
            db.insert("Client", null,cv );
            Toast.makeText(MyApp.getContext(),"Client Detail saved", Toast.LENGTH_SHORT).show();
            }

        db.close();
    }
    public void Savecurrent(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("ID", 1);
            cv.put("name", Public_veriable.Clientname);
            cv.put("date", Public_veriable.Clientdob);
            cv.put("Time", Public_veriable.Clienttob);
            cv.put("Cid", Public_veriable.Clientcob);
            cv.put("Pid", Public_veriable.Clientpob);
            cv.put("BIS", Public_veriable.datemod);
            cv.put("gender", Public_veriable.gender*10 +Public_veriable.tgp);
            db.update("current",cv,"ID= ?", new String [] {"1"});

        db.close();
    }
    public void getAllcontry(int Crno,ArrayAdapter <CharSequence> adapter){
        adapter.clear();
        // Select All Query
        String selectQuery = "";
        if(Public_veriable.Stext.length()==0){
            selectQuery = "SELECT * FROM Country";}else{
            selectQuery = "SELECT * FROM Country Where(Country.Name LIKE '"+ Public_veriable.Stext +"%')" ;
        }

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int x=0;
        Public_veriable.CRno =1;
        // looping through all rows and adding to list
        if ( cursor.moveToFirst () ) {
            do {
                x=x+1;
                adapter.add(cursor.getString(0)+ "    "  + cursor.getString(1) );
                if (Crno==Integer.parseInt(cursor.getString(0))){Public_veriable.CRno =x-1; }
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();
    }

    public String getcountry(int Crno){
        String cname="";
        String selectQuery = "SELECT * FROM Country WHERE(Country._ID="+ Crno +")";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if ( cursor.moveToFirst () ) {
            if(Public_veriable.FEN==1 && Crno==147){cname="g]kfn";}else{cname=cursor.getString(1);}
        }
        cursor.close();
        db.close();
        return cname;
    }
    public String getplace(int PlID,int Crno){
        String cname="";
        String selectQuery = "SELECT * FROM Place WHERE(Place.SN="+ PlID +")";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if ( cursor.moveToFirst () ) {
            if(Public_veriable.FEN==1 && Crno==147){
                cname=cursor.getString(4);}else{ cname=cursor.getString(1);}
        }
        cursor.close();
        db.close();
        return cname;
    }
    public void getpatro(long yr){
        Fname= new name_others();
        String[] Sectext = Public_veriable.monthday.split(" ");
        long cmd = 0;int mn=1;long dn=1;
        for (int i =1;i<13;i++){
            cmd +=Integer.parseInt(Sectext[i]);
            if (cmd >Public_veriable.patroday)
            {
                mn=i;
                dn=Public_veriable.patroday-cmd+Integer.parseInt(Sectext[i]);
                if(dn==0){
                    dn=Integer.parseInt(Sectext[i-1]);
                    mn=mn-1;}
                break;}
        }
        try{
            String selectQuery = "SELECT * FROM Y"+yr+" Where(Y" + yr+ ".a='"+Public_veriable.patroday+"')";
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            Public_veriable.patrdetail= " " +yr+" " +Fname.monthname_nep( mn)+" "+ dn;//nepali date
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, "+cursor.getString(1);//english date
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, >LzFs] "+(yr-135)+" " +cursor.getString(2);//sake pakcha and bar
            int sambatsar = (int) (yr % 60 + 10);
            if (sambatsar > 60) { sambatsar = sambatsar - 60;}
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, cogM "+cursor.getString(20) + "  ;+jT;/M "+Fname.sambatsarname(sambatsar);
            //tithi
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, ltyL  #k -;do_ "+cursor.getString(3)+" "+cursor.getString(4)+ "-" +cursor.getString(5)+ "_";
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, gIf]q  #k -;do_ "+cursor.getString(6)+" "+cursor.getString(7)+ "-"+cursor.getString(8)+ "_";
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, of]u  #k -;do_ "+cursor.getString(9)+" "+cursor.getString(10)+ "-"+cursor.getString(11)+ "_";
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, s/)f  #k "+cursor.getString(12)+" "+cursor.getString(13);
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, of]u gfd  "+cursor.getString(18);//yog name
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, rGb|/flz  "+cursor.getString(14);//chrashi
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, lbgdfg  "+cursor.getString(15); //dinman
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, ;'of]+bo  "+cursor.getString(16);//suyoday
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!, ;'o{f:t   "+cursor.getString(19)+"!,";//suryasta

            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(21)+"!,";//suryapast
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(22)+"!,";//chandra
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(23)+"!,";//mangal
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(24)+"!,";//budha
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(25)+"!,";//guru
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(26)+"!,";//sukra
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(27)+"!,";//sani
            Public_veriable.patrdetail=Public_veriable.patrdetail+cursor.getString(28);//rahu


            cursor.close();
            db.close();
            Public_veriable.patroexist=true;
        } catch (Exception e){
            Public_veriable.patroexist =false;
            Public_veriable.patrdetail= " " +yr+" " +Fname.monthname_nep( mn)+" "+ dn;//nepali date
            Public_veriable.patrdetail=Public_veriable.patrdetail+"!,-!,-!,-!,-!,-!,-!,-!,-!,-!,-!,-!,-!,0!,0!,0!,0!,0!,0!,0!,0";
        }
    }


    public  void preparepatro(String yr){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.execSQL("DROP TABLE IF EXISTS Y"+yr);
        db.execSQL("CREATE TABLE Y"+yr+" (a TEXT,b TEXT,c TEXT,d TEXT,e TEXT,f TEXT,g TEXT,h TEXT,i TEXT,j TEXT,k TEXT,l TEXT,m TEXT,n TEXT,o TEXT,p TEXT,q TEXT,r TEXT,s TEXT,t TEXT,ayan TEXT,g1 TEXT,g2 TEXT,g3 TEXT,g4 TEXT,g5 TEXT,g6 TEXT,g7 TEXT,g8 TEXT)");
        db.close();
    }
    public void updatepatro(String yr,String x0,String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12,String x13,String x14,String x15,String x16,String x17,String x18,String x19,String x20,String g1,String g2,String g3,String g4,String g5,String g6,String g7,String g8){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("a", x0);
        cv.put("b", x1);
        cv.put("c", x2);
        cv.put("d", x3);
        cv.put("e", x4);
        cv.put("f", x5);
        cv.put("g", x6);
        cv.put("h", x7);
        cv.put("i", x8);
        cv.put("j", x9);
        cv.put("k", x10);
        cv.put("l", x11);
        cv.put("m", x12);
        cv.put("n", x13);
        cv.put("o", x14);
        cv.put("p", x15);
        cv.put("q", x16);
        cv.put("r", x17);
        cv.put("s", x18);
        cv.put("t", x19);
        cv.put("ayan", x20);
        cv.put("g1", g1);
        cv.put("g2", g2);
        cv.put("g3", g3);
        cv.put("g4", g4);
        cv.put("g5", g5);
        cv.put("g6", g6);
        cv.put("g7", g7);
        cv.put("g8", g8);
        db.insert(yr, null,cv );
        db.close();
    }



    public void getAllplace(int Prno,ArrayAdapter <CharSequence> adapterM,Spinner spinner){

        // Select All Query
        adapterM.clear();
        String conid =  spinner.getSelectedItem().toString();
        int CID =Integer.parseInt((conid.substring(0,3)).trim());
        String selectQuery = "";
        if(Public_veriable.Ptext.length()==0){
            selectQuery = "SELECT * FROM Place WHERE(Place.ID="+ CID +")";}else{
            selectQuery = "SELECT * FROM Place Where((Place.ID="+ CID +") AND (Place.Name LIKE '"+ Public_veriable.Ptext +"%'))" ;
        }


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int x=0;
        Public_veriable.PRno =1;
        // looping through all rows and adding to list
        if ( cursor.moveToFirst () ) {
            do {
                x=x+1;
                adapterM.add(cursor.getString(1)+"          "+(cursor.getString(5)));
                if (Prno==Integer.parseInt(cursor.getString(5))){Public_veriable.PRno =x-1; }
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

    }

    //importing database
    public void importDB() {

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data  = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + "suj.soft.app.kundali_darsan" + "//databases//" + "Kundali.db";
                String backupDBPath  = "/Backupdb/Kundali.db";
                File  backupDB= new File(data, currentDBPath);
                File currentDB  = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(MyApp.getContext(),"Data imported.",Toast.LENGTH_SHORT).show(); }
        } catch (Exception e) {Toast.makeText(MyApp.getContext(), e.toString(), Toast.LENGTH_LONG).show();}
    }


    //exporting database
    public void exportDB() {
        File direct = new File(Environment.getExternalStorageDirectory() + "/Backupdb");

        if(!direct.exists()) {
            if(direct.mkdir())
            { Toast.makeText(MyApp.getContext(), "Directory created",Toast.LENGTH_SHORT).show();}
        }

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + "suj.soft.app.kundali_darsan" + "//databases//" + "Kundali.db";
                File currentDB = new File(data, currentDBPath);
                String backupDBPath  = "/Backupdb/Kundali.db";
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(MyApp.getContext(), backupDB.toString(),Toast.LENGTH_LONG).show();}
        } catch (Exception e) {Toast.makeText(MyApp.getContext(), e.toString(), Toast.LENGTH_LONG).show();}
    }
    public String getmemorycarddetail() {
        String memoryid = null;
        //	if (isExteranlStorageAvailable()) {
        try {
            File input = new File("/sys/class/mmc_host/mmc1");
            String cid_directory = null;
            int i = 0;
            File[] sid = input.listFiles();

            for (i = 0; i < sid.length; i++) {
                if (sid[i].toString().contains("mmc1:")) {
                    cid_directory = sid[i].toString();
                    break;
                }
            }
            BufferedReader CID = new BufferedReader(new FileReader(
                    cid_directory + "/cid"));
            memoryid = CID.readLine();

        } catch (Exception e) {
            memoryid=null;
        }
        return memoryid;

        /*	} else {
        	    Toast.makeText(MyApp.getContext(), "External Storage Not available!!",
        	            Toast.LENGTH_SHORT).show();
        	}*/
    }
}