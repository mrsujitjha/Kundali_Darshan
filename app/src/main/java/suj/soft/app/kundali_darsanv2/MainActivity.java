package suj.soft.app.kundali_darsanv2;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    private SuryaSiddhanta Ssidhanta=null;
    public static DatabaseHelper dbHelper=null;
    private static DBOperation dboper=null;
    private name_others Fname;
    private EditText Ename,Edate,Etime,Sctext,Pctext;
    private ImageButton prepare,ksave,kdelete,ksearch,kload;
    private TextView dsmid,uname,udob,ubt;
    static int rph,rfl;
    private static final String AddPlace_URL="https://ica.edu.np/Dems/API/";
    private RadioButton DN,DI;
    private CheckBox gend,tgp;
    public static Spinner spinner,spinnerM,spinnerC;
    public static ArrayAdapter<CharSequence> adapter,adapterM ;
    public static Context context;
    private int hour,minute;
    private NavigationView navView ;
    private String deviceID;
    private String Simid;
    private String android_id;
    LinearLayout imagekund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //---create db ---
        dbHelper = new DatabaseHelper(this, "Kundali.db", null, 1);
        dboper = new DBOperation();
        Fname = new name_others();
        dboper.loadoption();
        dboper.Loadoption_kud();


        spinner = (Spinner) findViewById(R.id.spinner1);//country
        spinnerM = (Spinner) findViewById(R.id.spinner2);//place
        spinnerC = (Spinner) findViewById(R.id.spinner3);//client

        imagekund = (LinearLayout) findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable drawable = null;
        if (Public_veriable.OB == 0) {
            drawable = null;
        }
        if (Public_veriable.OB == 1) {
            drawable = getResources().getDrawable(R.drawable.paper);
        }
        if (Public_veriable.OB == 2) {
            drawable = getResources().getDrawable(R.drawable.lightwood);
        }
        if (Public_veriable.OB == 3) {
            drawable = getResources().getDrawable(R.drawable.background);
        }
        imagekund.setBackgroundDrawable(drawable);

        Ename = (EditText) findViewById(R.id.editText1);//get name
        gend = (CheckBox) findViewById(R.id.checkBox1);//get gender
        tgp = (CheckBox) findViewById(R.id.checkBox2);//get gadipala
        Edate = (EditText) findViewById(R.id.editText2);//date
        Etime = (EditText) findViewById(R.id.editText3);//time
        Sctext = (EditText) findViewById(R.id.EditText01);//search contry
        Pctext = (EditText) findViewById(R.id.editText4);//search place

        dsmid = (TextView) findViewById(R.id.textView45);//device sim and memory id viewer
        uname = (TextView) findViewById(R.id.textView94);//name
        udob = (TextView) findViewById(R.id.textView101);//dob
        ubt = (TextView) findViewById(R.id.textView100);//birth time

        DN = (RadioButton) findViewById(R.id.radio0);
        DI = (RadioButton) findViewById(R.id.radio1);
        prepare = (ImageButton) findViewById(R.id.Button1);
        ksave = (ImageButton) findViewById(R.id.Button2);
        kdelete = (ImageButton) findViewById(R.id.Button3);
        ksearch = (ImageButton) findViewById(R.id.Button4);
        kload = (ImageButton) findViewById(R.id.Button5);

        navView = (NavigationView) findViewById(R.id.nav_view);
       // startService(new Intent(getBaseContext(), ClearService.class));
        //  <service android:name="suj.soft.app.kundali_darsanv2.ClearService" android:stopWithTask="false" /> in androidmanifest

        Public_veriable.DS = "-";
        if (Public_veriable.FEN == 1) {
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");

            Public_veriable.DS = "M";
            Public_veriable.TS = "M";
            DN.setTypeface(tf);
            DI.setTypeface(tf);
            Edate.setTypeface(tf);
            Ename.setTypeface(tf);
            Etime.setTypeface(tf);

            Ename.setTypeface(tf);
            Edate.setTypeface(tf);
            Etime.setTypeface(tf);
            gend.setTypeface(tf);
            tgp.setTypeface(tf);
            uname.setTypeface(tf);
            udob.setTypeface(tf);
            ubt.setTypeface(tf);

            DN.setText("ljs|d ;+jt\\");
            DI.setText("O{l:j ;g\\");
            gend.setText("kÚ?if");
            tgp.setText(";do");
            Ename.setHint("gfd");
            Edate.setHint("hGdldtL");
            Etime.setHint("hGd;do");
            uname.setText("gfd");
            udob.setText("hGdldlt");
            ubt.setText("hGd;do");
            Menu m = navView.getMenu();
            for (int i = 0; i < m.size(); i++) {
                MenuItem mi = m.getItem(i);
                if (i == 0) {
                    mi.setTitle("sÒ^ ldnfg");
                }
                if (i == 1) {
                    mi.setTitle("kfqf]");
                }
                if (i == 2) {
                    mi.setTitle("k~rfé");
                }
                if (i == 3) {
                    mi.setTitle("lasNk ldnfpgÒ;\\");
                }
                if (i == 4) {
                    mi.setTitle("cfhsf] kmlnt");
                }
                if (i == 5) {
                    mi.setTitle("b]z :yfg yKgÒ;\\");
                }
                if (i == 6) {
                    mi.setTitle(";xfotf tyf btf{");
                }
                //for aapplying a font to subMenu ...
                SubMenu subMenu = mi.getSubMenu();
                if (subMenu != null && subMenu.size() > 0) {
                    for (int j = 0; j < subMenu.size(); j++) {
                        MenuItem subMenuItem = subMenu.getItem(j);
                        if (j == 0) {
                            subMenuItem.setTitle(";xfotf");
                        }
                        if (j == 1) {
                            subMenuItem.setTitle("btf{");
                        }
                        applyFontToMenuItem(subMenuItem);
                    }
                }
                applyFontToMenuItem(mi);
            }
        }
     if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            rfl = 1;
        } else {
            rfl = 0;
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            rfl = 1;
        } else {
            rfl = 0;
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            rfl = 1;
        } else {
            rfl = 0;
        }
        if (rfl == 1) {
               ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION}, rph);
        }

        if (Public_veriable.registered ==0) {
            dboper.getregistration();
            Etime.setEnabled(false);
            Ename.setEnabled(false);
            ksearch.setEnabled(false);
            ksave.setEnabled(false);
            kdelete.setEnabled(false);
            String DSMIDtext = "To Register Kundali_Darshan Contact: 'Surya Panchang Karyalay.'";
            dsmid.setText(DSMIDtext);

            if (isNetworkConnected()) {
                user_login(Public_veriable.registeKey,Public_veriable.regphone);
            } else {Toast.makeText(getApplicationContext(), "Internet require to login.", Toast.LENGTH_SHORT).show();}
        }

 //  }

      // notification
        /*
         NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
         builder.setTicker("Today Panchang");
         builder.setContentTitle("Panchang of "+Iswidate.getText());
         builder.setContentText("New Post on Android Notification.");
         builder.setSmallIcon(R.drawable.kundali);
         NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
         nm.notify(0, builder.build());
          */

      Public_veriable.Clientno = 0;
      loadspinner_Client();
      dboper.loadcurrent();
      fill_client_detail();

        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Public_veriable.Clientno=pos;
            }
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                    String conid =  MainActivity.spinner.getSelectedItem().toString();
                    Public_veriable.Clientcob =Integer.parseInt((conid.substring(0,3)).trim());
                    loadspinner_place(Public_veriable.Clientpob);}

            public void onNothingSelected(AdapterView<?> parent) {  }
        });

        kload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dboper.getClient();
                fill_client_detail();

            }
        });
    }

   private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }
    public void loadspinner_Con(int Crno){
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dboper.getAllcontry(Crno,adapter);
        spinner.setAdapter(adapter);
       }


    private <ViewGroup> void loadspinner_Client(){
        if(Public_veriable.clientlist.length()>0){
            String[] list =Public_veriable.clientlist.split(",");
            ArrayAdapter<String> adapterC = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list)
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
            spinnerC.setAdapter(adapterC);}
    }

    void fill_client_detail(){
        Ename.setText(Public_veriable.Clientname);
        Edate.setText(Public_veriable.Clientdob);
        Etime.setText(Public_veriable.Clienttob);
        if(Public_veriable.datemod==0){ DN.setChecked(true);doworkdate();}else{DI.setChecked(true);doworkdate();}
        if(Public_veriable.gender==0){ gend.setChecked(false);doworkgender();}else{gend.setChecked(true);doworkgender();}
        if(Public_veriable.tgp==0){ tgp.setChecked(false);doworktgp();}else{tgp.setChecked(true);doworktgp();}

        loadspinner_Con(Public_veriable.Clientcob);
        spinner.setSelection(Public_veriable.CRno);
        loadspinner_place(Public_veriable.Clientpob);
        spinnerM.setSelection(Public_veriable.PRno);
    }
    public void loadspinner_place(int Prno){

        adapterM = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dboper.getAllplace(Prno,adapterM,spinner);
        spinnerM.setAdapter(adapterM);
        spinnerM.setSelection(Public_veriable.PRno);
    }
    public void onclick_save(View view){
        if(Ename.getText().toString().length()==0||Edate.getText().toString().length()==0||Etime.getText().length()==0){
            Toast.makeText(context, "Enter Name,date and Time", Toast.LENGTH_LONG).show();
        }else{
            read_cliend_detail();
            dboper.SaveClient();
            dboper.Savecurrent();
            refressall();

        }
    }
void read_cliend_detail(){
    Public_veriable.Clientname = Ename.getText().toString();
    Public_veriable.Clientdob = Edate.getText().toString();
    Public_veriable.Clienttob = Etime.getText().toString();
    String conid =  spinnerM.getSelectedItem().toString();
    int pt =conid.length();
    Public_veriable.Clientpob =Integer.parseInt((conid.substring(pt-10,pt)).trim());

    if(DN.isChecked()){ Public_veriable.datemod=0;}else{Public_veriable.datemod=1;}
    if(gend.isChecked()){ Public_veriable.gender=1;}else{Public_veriable.gender=0;}
    if(tgp.isChecked()){ Public_veriable.tgp=1;}else{Public_veriable.tgp=0;}
}

    public void refressall(){
        Sctext.setText("");
        Pctext.setText("");
        Public_veriable.Stext="";
        Public_veriable.Ptext="";
        dboper.Loadoption_kud() ;
        loadspinner_Client();
        //loadspinner_Con(147);
        dboper.loadcurrent();
        fill_client_detail();

    }
    public void onclick_Delete(View view){
        AlertDialog YNbox = showYNbox();
        YNbox.show();	}

    public AlertDialog showYNbox(){
        AlertDialog QuitYNbox = new AlertDialog.Builder(this)
                .setTitle("Delete Selected Record?")
                .setMessage("it will delete the selected record.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int Sb) {
                        dboper.DelClient();
                        //loadspinner_Client();
                        Toast.makeText(getApplicationContext(),"Record Deleted.", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());
                    }})
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int Sb) {
                        Toast.makeText(getApplicationContext(),"Record Delete option canceled.", Toast.LENGTH_LONG).show();

                    }})
                .create();
        return QuitYNbox;
    }




   public void onclick_loadcal(View view){
        showDialog(1);
    }

   public void onclick_loadnepcal(View view){
     Public_veriable.loadcal=0;//load nepali calendar
    read_cliend_detail();
    dboper.Savecurrent();
    Intent intent = new Intent( getApplicationContext(), calendar.class );
    startActivity(intent);
    finish();
   }

    public void onclick_loadtime(View view){
        if(!tgp.isChecked()){showDialog(2);}
    }


    public void onclick_prepare(View view){
             if(Ename.getText().toString().length()==0||Edate.getText().toString().length()==0||Etime.getText().length()==0){
                Toast.makeText(getApplicationContext(), "Enter Name,date and Time", Toast.LENGTH_LONG).show();
            }else{

                if (Public_veriable.registered==0){
                    Toast.makeText(getApplicationContext(), "Register your Kundali Darsan to use all feature and disable options.", Toast.LENGTH_LONG).show();
                    spinnerC.setSelection(0);
                }
                read_cliend_detail();
                dboper.Savecurrent();
                Public_veriable.EN =  DN.isChecked();
                Public_veriable.Prepare_Kundali();
                Ssidhanta=new SuryaSiddhanta();
                Ssidhanta.Getstarted();
                Intent myIntent = new Intent(view.getContext(), option.class);
                startActivity(myIntent);
            }
     }
    void doworkgender(){
        if(Public_veriable.FEN==0){
            if(gend.isChecked()){gend.setText("Female");} else{gend.setText("Male");}
        }else{
            if(gend.isChecked()){gend.setText("dlxnf");} else{gend.setText("kÚ?if");}
        }
    }
   public void onclick_searchcp(View view){
        Public_veriable.Stext = Sctext.getText().toString();
        Public_veriable.Ptext = Pctext.getText().toString();
        if(Public_veriable.Stext.length()>0){
            loadspinner_Con(0);}
        if(Public_veriable.Ptext.length()>0){
            loadspinner_place(0);}
    }
    void doworktgp(){
        if(Public_veriable.FEN==0){
            if(tgp.isChecked()){tgp.setText("G.P.");Etime.setHint("Birth in G,P,B");Public_veriable.tgp=1;} else{tgp.setText("Time");Etime.setHint("Birth Time");Public_veriable.tgp=0;}
        }else{
            if(tgp.isChecked()){tgp.setText("w=k=");Etime.setHint("hGd;do-w,k,la_");Public_veriable.tgp=1;} else{tgp.setText(";do");Etime.setHint("hGd;do");Public_veriable.tgp=0;}
        }
    }
    void doworkdate(){
        if(Public_veriable.FEN==1){
            DN.setText("las|d ;+at\\");DI.setText("O{l:j ;g\\");
        }else{
            DN.setText("Bikram Sambat");DI.setText("Iswi");
        }
    }

    public void onclick_gender(View view){
        doworkgender();
    }
    public void onclick_tgp(View view){
        doworktgp();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                final Calendar CC = Calendar.getInstance();
                return new DatePickerDialog(this, pickerListener,CC.get(Calendar.YEAR), CC.get(Calendar.MONTH),CC.get(Calendar.DAY_OF_MONTH));
            case 2:
                return new TimePickerDialog(this, timePickerListener, 12, 15, false);
        }
        return null;
    }

    private final DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            Edate.setText(Chdigit(selectedDay)+ Public_veriable.DS+Chdigit(selectedMonth+1)+ Public_veriable.DS+selectedYear);
            Public_veriable.Clientdob =Edate.getText().toString();}};

    private final TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
            // TODO Auto-generated method stub
            hour   = hourOfDay;
            minute = minutes;
            updateTime(hour,minute);}};

    private static String Chdigit(int value) {
        if (value < 10)
            return "0" + value;
        else
            return String.valueOf(value);}

    // Used to convert 24hr format to 12hr format with AM/PM values
    private void updateTime(int hours, int mins) {
        String timeSet = "";
        if (hours < 12) {
            timeSet = "AM";
            if(Public_veriable.FEN==1){timeSet = "P Pd";}
        }
        if (hours > 12) {
            hours -= 12;
            timeSet = "PM";
            if(Public_veriable.FEN==1){timeSet = "lk Pd";}
        }

        if (hours == 12){
            timeSet = "PM";
            if(Public_veriable.FEN==1){timeSet = "lk Pd";}
        }
        if (hours == 0) {
            hours += 12;
            timeSet = "AM";
            if(Public_veriable.FEN==1){timeSet = "P Pd";}
        }

        String minutes = "";
        if (mins < 10){ minutes = "0" + mins;}else{ minutes = String.valueOf(mins);}
        // Append in a StringBuilder
        String aTime = Chdigit(hours)+ Public_veriable.TS+minutes+ Public_veriable.TS+"00 "+timeSet;
        Etime.setText(aTime);
    }
    String devicekey(){
        String mkey="";// get from cloud if net is on
        return mkey;
    }

   @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
          //  AlertDialog.Builder builder = new AlertDialog.Builder(this);
          //  builder.setTitle("Confirm logout");
         //   builder.setMessage("Are you sure to logout?");
         //   builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
             //   public void onClick(DialogInterface dialog, int which) {
                   user_logout(Public_veriable.registeKey,Public_veriable.regphone);
            //        dialog.dismiss();

             //   }
           // });

            //builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            //    @Override
            //    public void onClick(DialogInterface dialog, int which) {
                    // Do nothing
           //         dialog.dismiss();
           //         moveTaskToBack(true);
          //      }
          //  });
          //  AlertDialog alert = builder.create();
         //   alert.show();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if  (id == R.id.nav_matchmaking) {
            Intent i = new Intent(getApplicationContext(),matchmaking.class);
            startActivity(i);
        } else if (id == R.id.nav_calendar) {
            Public_veriable.loadcal=1;
            Intent i = new Intent(getApplicationContext(),calendar.class);
            startActivity(i);
        } else if (id == R.id.nav_patro) {
            Intent i = new Intent(getApplicationContext(),patro.class);
            startActivity(i);
        } else if (id == R.id.nav_option) {
            Intent i = new Intent(getApplicationContext(),setoption.class);
            startActivity(i);
        } else if (id == R.id.nav_falit) {
            Intent i = new Intent(getApplicationContext(),todayfalit.class);
            startActivity(i);
        } else if (id == R.id.nav_help) {
            Intent i = new Intent(getApplicationContext(),help.class);
            startActivity(i);
        } else if (id == R.id.nav_reg) {
            Intent i = new Intent(getApplicationContext(),setoption.class);
            startActivity(i);
        } else if (id == R.id.nav_conplace) {
            Intent i = new Intent(getApplicationContext(),countryplace.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void user_login(String pass,String phone){
        String urlSuffix = "kuser3.php?pass=" + pass+"&phone="+phone;
        class RegisterUser extends AsyncTask<String, Void, String> {
            // ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loading = ProgressDialog.show(getApplicationContext(), "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                if (s.equals("password wrong")){
                    Toast.makeText(getApplicationContext(), "Login Fail!! Logout From Other Device."  , Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Register your Kundali Darsan to use all features."  , Toast.LENGTH_SHORT).show();
                    Ename.setText("-");
                    final Calendar CC = Calendar.getInstance();
                    int minute = CC.get(Calendar.MINUTE);
                    //24 hour format
                    int hourofday = CC.get(Calendar.HOUR_OF_DAY);
                    updateTime(hourofday, minute);
                }else{
                    Toast.makeText(MainActivity.this, "Kundali Darsan is ready.", Toast.LENGTH_LONG).show();
                    dsmid.setText("");
                    Etime.setEnabled(true);
                    Ename.setEnabled(true);
                    ksearch.setEnabled(true);
                    ksave.setEnabled(true);
                    kdelete.setEnabled(true);
                    Public_veriable.registered = 1;
                }
           }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(AddPlace_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    return  result;
                }catch (Exception e){
                    return null;
                }
            }

        }
        RegisterUser ur=new RegisterUser();
        ur.execute(urlSuffix);
    }
    private void user_logout(String pass,String phone){
        String urlSuffix = "kuser4.php?pass=" + pass+"&phone="+phone;
        class RegisterUser extends AsyncTask<String, Void, String> {
            // ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loading = ProgressDialog.show(getApplicationContext(), "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                if (s.equals("password wrong")){
                    Toast.makeText(getApplicationContext(), "Logout not success."  , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Logout successful."  , Toast.LENGTH_SHORT).show();
                    Public_veriable.registered=0;
                   // MainActivity.this.finish();
                   // System.exit(0);
                }
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferReader=null;
                try {
                    URL url=new URL(AddPlace_URL+s);
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    bufferReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String result;
                    result=bufferReader.readLine();
                    return  result;
                }catch (Exception e){
                    return null;
                }
            }

        }
        RegisterUser ur=new RegisterUser();
        ur.execute(urlSuffix);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}
