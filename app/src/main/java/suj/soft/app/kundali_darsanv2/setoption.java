package suj.soft.app.kundali_darsanv2;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
        import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
        import android.graphics.Typeface;
        import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
        import android.widget.RadioButton;
        import android.widget.Spinner;
import android.widget.TextView;
        import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class setoption  extends Activity {
        public static Context context;
        public static DatabaseHelper dbHelper=null;
        private static DBOperation dboper=null;

        private TextView thelp,T1,T2,T3,T6;
        private EditText password,fontsize,phonenumber;
        private RadioButton FN;
        private RadioButton FE;
        private CheckBox DF;
        public static Spinner spkb;
        public static Spinner spob;
        private Spinner spdk;
        LinearLayout imageback;
        ImageButton mreg,msave,imgsync;
        String regphone;
        private static final String AddPlace_URL="https://ica.edu.np/Dems/API/";
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.setoption);

                imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
                Drawable  backpic  = null;
                if(Public_veriable.OB==0){backpic  =null;}
                if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
                if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
                if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
                imageback.setBackgroundDrawable(backpic);

                context = getApplicationContext();
                T1 = (TextView)findViewById(R.id.textView1);
                T2 = (TextView)findViewById(R.id.textView2);
                T3 = (TextView)findViewById(R.id.textView3);
                T6 = (TextView)findViewById(R.id.textView95);

                thelp = (TextView)findViewById(R.id.TextView01);
                password = (EditText)findViewById(R.id.editText1);
                fontsize = (EditText)findViewById(R.id.editText2);
                phonenumber = (EditText)findViewById(R.id.editTextPhone);


                mreg= (ImageButton)findViewById(R.id.button4);
                msave= (ImageButton)findViewById(R.id.button5);

                FN = (RadioButton) findViewById(R.id.radio0);
                FE = (RadioButton) findViewById(R.id.radio1);



                spob = (Spinner) findViewById(R.id.spinner1);
                spkb = (Spinner) findViewById(R.id.spinner2);
                spdk = (Spinner) findViewById(R.id.spinner3);
                DF= (CheckBox)findViewById(R.id.checkBox1);
                imgsync=(ImageButton)findViewById(R.id.imageButton3);


                if(Public_veriable.FEN==1){
                        Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
                        FN.setTypeface(tf); FE.setTypeface(tf); T1.setTypeface(tf); T2.setTypeface(tf);T3.setTypeface(tf);
                        DF.setTypeface(tf);fontsize.setTypeface(tf);
                      T6.setTypeface(tf);
                        DF.setText("b}lgs kmlnt b]vfpgú;\\ tyf kmlnt km)^ ");
                        FN.setText("g]kfnL km)^ ");FE.setText("c+u|]hL km)^");
                        T1.setText("sÚ)*nLsf]] cfwf/ %fGgú;\\");T2.setText("k%fl*sf] cfwf/ %fGgú;\\");T3.setText("b}lgs kmlnt sÚ)*nL %fGgú;\\");
                        T6.setText("kf;j*{");
                }

               //---create db ---
                dbHelper = new DatabaseHelper(this,"Kundali.db",null,1);
                dboper=new DBOperation();
                loadspinner_Client();
                loadoption();
                loadoptionback();

                spdk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                                Public_veriable.DK =pos;}
                        public void onNothingSelected(AdapterView<?> parent) {  }
                });


                mreg.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Public_veriable.registeKey="-";
                                String supplykey =password.getText().toString();
                                String supplyphone =phonenumber.getText().toString();

                                if(password.getText().length()==0 ||phonenumber.getText().length()==0){
                                        Toast.makeText(getApplicationContext(),"Please enter key and phone number.", Toast.LENGTH_SHORT).show();
                                }else{
                                        Toast.makeText(getApplicationContext(), "Connecting server for login.", Toast.LENGTH_SHORT).show();
                                        if (isNetworkConnected()) {
                                                user_registration(supplykey,supplyphone);
                                        } else { Toast.makeText(getApplicationContext(), "Network not avialable.", Toast.LENGTH_SHORT).show();}

                                     }
                        }});

                msave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Public_veriable.KB =Integer.parseInt((spkb.getSelectedItem().toString().substring(0,1)).trim());
                                Public_veriable.OB =Integer.parseInt((spob.getSelectedItem().toString().substring(0,1)).trim());
                                if(FN.isChecked()){ Public_veriable.FEN=1;}else{Public_veriable.FEN=0;}
                                Public_veriable.FS = Integer.parseInt(fontsize.getText().toString());
                                dboper.Saveoption();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                        }});



                DF.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                if(DF.isChecked()){ Public_veriable.DF =1;}else{Public_veriable.DF =0;}
                        }});
                imgsync.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                password.setText(Public_veriable.registeKey);
                        }});

        }
        public <ViewGroup> void loadspinner_Client(){
                if(Public_veriable.clientlist.length()>0){

                        String[] list =Public_veriable.clientlist.split(",");
                        ArrayAdapter<String> addk = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list)
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
                        spdk.setAdapter(addk);}
        }
        private <ViewGroup>  void loadoption(){
                String Llist="";
                if(Public_veriable.FEN==0){Llist = "0 Black and white,1 Color";}
                if(Public_veriable.FEN==1){Llist = "0 Zofd Zj]t,1 /+uLg";}
                String[] Clist = Llist.split(",");
                ArrayAdapter<String> adkb = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Clist)
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
                        }};
                spkb.setAdapter(adkb);}
        private <ViewGroup>  void loadoptionback(){
                String Llist="";
                if(Public_veriable.FEN==0){Llist = "0 No Back ground,1 Paper,2 Wood,3 sky";}
                if(Public_veriable.FEN==1){Llist = "0 ;fbf,1 k]k/,2 sf& ,3 cfsfz";}
                String[] Olist =Llist.split(",");
                ArrayAdapter<String> adob = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Olist)
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
                        }};
                //  adob.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spob.setAdapter(adob);

                spdk.setSelection(Public_veriable.DK);
                spkb.setSelection(Public_veriable.KB);
                spob.setSelection(Public_veriable.OB);
            DF.setChecked(Public_veriable.DF == 1);
                if( Public_veriable.FEN==1){FN.setChecked(true);}else{FE.setChecked(true);}
                fontsize.setText(Public_veriable.FS+"");
               // password.setText(Public_veriable.registeKey);
        }

        private void user_password_update(String paold,String panew){

               String mdate=new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
                String urlSuffix = "kuserupdate2.php?phone=" + paold+"&pnew="+panew+"&rd="+mdate;
                class userpassword extends AsyncTask<String, Void, String> {
                        // ProgressDialog loading;
                        @Override
                        protected void onPreExecute() {
                                super.onPreExecute();
                                //loading = ProgressDialog.show(getApplicationContext(), "Please Wait", null, true, true);
                        }

                        @Override
                        protected void onPostExecute(String s) {
                                if (s.equals("success")){
                                        Toast.makeText(getApplicationContext(), "Update app successful."  , Toast.LENGTH_SHORT).show();
                                                dboper.setregistration();
                                                Toast.makeText(getApplicationContext(), "Registration Successful.Please Launch kundali_Darshan again.", Toast.LENGTH_SHORT).show();
                                                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                               // startActivity(intent);
                                              //  finish();
                                }else{ Toast.makeText(getApplicationContext(), "Fail to update app!! contact Developer."  , Toast.LENGTH_SHORT).show();
                                        //fail
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
                userpassword ur=new userpassword();
                ur.execute(urlSuffix);
        }
        private void user_registration(String pass,String phone){
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
                                        Toast.makeText(getApplicationContext(), "Registration Fail."  , Toast.LENGTH_SHORT).show();
                                }else{
                                        regphone=s;
                                        Toast.makeText(getApplicationContext(), "Connection to server.. successful."  , Toast.LENGTH_SHORT).show();
                                        Random random = new Random();
                                        int randomNumber = random.nextInt(999999999-100000000) + 100000000;
                                        Public_veriable.registeKey=devicekey(randomNumber+"");//generate random id
                                        Public_veriable.regphone=regphone;
                                        // update cloud table with random id api,if success update in table also
                                        user_password_update(regphone,Public_veriable.registeKey);
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

        String devicekey(String din){
                String mkey="";
                if (din==null){mkey ="";}else{
                        int x = din.length();
                        int y = x/2;
                        int z=0;
                        String SA=din.substring(0,y);
                        String SB=din.substring(y,x);
                        SA = SA.replaceAll("[^\\d.]", "");
                        SB = SB.replaceAll("[^\\d.]", "");
                        long A = Long.parseLong(SA);
                        long B = Long.parseLong(SB);
                        String C= (A+B+x)/2+"";
                        x = C.length();
                        if (x>8){z=x-8;}
                        String P = "QW5RE45ReVvcx40gfG8BGHTkKLlRr";
                        for (int i =z;i <x;i++){
                                int n=Integer.parseInt(C.substring(i,i+1));
                                mkey += P.substring(n,n+1) ;
                                mkey += P.substring(n*2,n*2+1) ;}
                }
                return mkey;    	 }
}
