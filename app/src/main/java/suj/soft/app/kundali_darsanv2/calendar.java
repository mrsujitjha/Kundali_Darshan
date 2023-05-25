package suj.soft.app.kundali_darsanv2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by Admin on 7/22/2017.
 */

public class calendar extends Activity {
    private TextView Cmonth, Iswidate, dn1, dn2, dn3, dn4, dn5, dn6, dn7;
    private TextView cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18;
    private TextView cd19, cd20, cd21, cd22, cd23, cd24, cd25, cd26, cd27, cd28, cd29, cd30, cd31, cd32, cd33, cd34, cd35;
    private TextView cd36, cd37, cd38, cd39, cd40, cd41, cd42;
    private EditText Cyear;
    private static long curyear = 0, iyear = 0, nyear = 0;
    private static int curmonth = 0, imonth = 0, nmonth = 0;
    private static int curdate = 0, idate = 0, ndate = 0;
    ImageView mimageNY, mimagePY, mimageNM, mimagePM;
    ImageButton setdate;
    public static DatabaseHelper dbHelper = null;
    private static DBOperation dboper = null;
    private name_others Fname;
    LinearLayout imageback;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        dbHelper = new DatabaseHelper(this, "Kundali.db", null, 1);
        dboper = new DBOperation();
        Fname = new name_others();
        mimageNY = (ImageView) findViewById(R.id.imageView2);//Next year
        mimagePY = (ImageView) findViewById(R.id.imageView1);//Pre year
        mimageNM = (ImageView) findViewById(R.id.imageView4);//Next month
        mimagePM = (ImageView) findViewById(R.id.imageView3);//Pre Month
        setdate = (ImageButton) findViewById(R.id.imageButton2);//set date

        Cyear = (EditText) findViewById(R.id.editText5);//current year
        Cmonth = (TextView) findViewById(R.id.textView43);//Current Month

        dn1 = (TextView) findViewById(R.id.textView1);
        dn2 = (TextView) findViewById(R.id.textView2);
        dn3 = (TextView) findViewById(R.id.textView3);
        dn4 = (TextView) findViewById(R.id.textView4);
        dn5 = (TextView) findViewById(R.id.textView5);
        dn6 = (TextView) findViewById(R.id.textView6);
        dn7 = (TextView) findViewById(R.id.textView7);

        cd1 = (TextView) findViewById(R.id.textView8);
        cd2 = (TextView) findViewById(R.id.textView9);
        cd3 = (TextView) findViewById(R.id.textView10);
        cd4 = (TextView) findViewById(R.id.textView11);
        cd5 = (TextView) findViewById(R.id.textView12);
        cd6 = (TextView) findViewById(R.id.textView13);
        cd7 = (TextView) findViewById(R.id.textView14);
        cd8 = (TextView) findViewById(R.id.textView15);
        cd9 = (TextView) findViewById(R.id.textView16);
        cd10 = (TextView) findViewById(R.id.textView17);
        cd11 = (TextView) findViewById(R.id.textView18);
        cd12 = (TextView) findViewById(R.id.textView19);
        cd13 = (TextView) findViewById(R.id.textView20);
        cd14 = (TextView) findViewById(R.id.textView21);
        cd15 = (TextView) findViewById(R.id.textView22);
        cd16 = (TextView) findViewById(R.id.textView23);
        cd17 = (TextView) findViewById(R.id.textView24);
        cd18 = (TextView) findViewById(R.id.textView25);
        cd19 = (TextView) findViewById(R.id.textView26);
        cd20 = (TextView) findViewById(R.id.textView27);
        cd21 = (TextView) findViewById(R.id.textView28);
        cd22 = (TextView) findViewById(R.id.textView29);
        cd23 = (TextView) findViewById(R.id.textView30);
        cd24 = (TextView) findViewById(R.id.textView31);
        cd25 = (TextView) findViewById(R.id.textView32);
        cd26 = (TextView) findViewById(R.id.textView33);
        cd27 = (TextView) findViewById(R.id.textView34);
        cd28 = (TextView) findViewById(R.id.textView35);
        cd29 = (TextView) findViewById(R.id.textView36);
        cd30 = (TextView) findViewById(R.id.textView37);
        cd31 = (TextView) findViewById(R.id.textView38);
        cd32 = (TextView) findViewById(R.id.textView39);
        cd33 = (TextView) findViewById(R.id.textView40);
        cd34 = (TextView) findViewById(R.id.textView41);
        cd35 = (TextView) findViewById(R.id.textView42);

        cd36 = (TextView) findViewById(R.id.textView46);
        cd37 = (TextView) findViewById(R.id.textView47);
        cd38 = (TextView) findViewById(R.id.textView48);
        cd39 = (TextView) findViewById(R.id.textView49);
        cd40 = (TextView) findViewById(R.id.textView50);
        cd41 = (TextView) findViewById(R.id.textView51);
        cd42 = (TextView) findViewById(R.id.textView52);

        Iswidate = (TextView) findViewById(R.id.textView44);
        imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);
        if (Public_veriable.FEN == 1) {
            Typeface tf = Typeface.createFromAsset(getAssets(), "Fonts/HIMALI.otf");
            cd1.setTypeface(tf);
            cd19.setTypeface(tf);
            cd2.setTypeface(tf);
            cd20.setTypeface(tf);
            cd3.setTypeface(tf);
            cd21.setTypeface(tf);
            cd4.setTypeface(tf);
            cd22.setTypeface(tf);
            cd5.setTypeface(tf);
            cd23.setTypeface(tf);
            cd6.setTypeface(tf);
            cd24.setTypeface(tf);
            cd7.setTypeface(tf);
            cd25.setTypeface(tf);
            cd8.setTypeface(tf);
            cd26.setTypeface(tf);
            cd9.setTypeface(tf);
            cd27.setTypeface(tf);
            cd10.setTypeface(tf);
            cd28.setTypeface(tf);
            cd11.setTypeface(tf);
            cd29.setTypeface(tf);
            cd12.setTypeface(tf);
            cd30.setTypeface(tf);
            cd13.setTypeface(tf);
            cd31.setTypeface(tf);
            cd14.setTypeface(tf);
            cd32.setTypeface(tf);
            cd15.setTypeface(tf);
            cd33.setTypeface(tf);
            cd16.setTypeface(tf);
            cd34.setTypeface(tf);
            cd17.setTypeface(tf);
            cd35.setTypeface(tf);
            cd18.setTypeface(tf);
            Cyear.setTypeface(tf);
            cd36.setTypeface(tf);
            cd37.setTypeface(tf);
            cd38.setTypeface(tf);
            cd39.setTypeface(tf);
            cd40.setTypeface(tf);
            cd41.setTypeface(tf);
            cd42.setTypeface(tf);
            Cmonth.setTypeface(tf);
            Iswidate.setTypeface(tf);
            dn1.setTypeface(tf);
            dn2.setTypeface(tf);
            dn3.setTypeface(tf);
            dn4.setTypeface(tf);
            dn5.setTypeface(tf);
            dn6.setTypeface(tf);
            dn7.setTypeface(tf);
            dn1.setText("cfOt");
            dn2.setText(";f]d");
            dn3.setText("d+un");
            dn4.setText("aÚ’w");
            dn5.setText("uÚ?");
            dn6.setText("zÚqm");
            dn7.setText("z’lg");
        }
            loadstartnepdate();

        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Public_veriable.loadcal==0) {
                    Public_veriable.Clientdob = Public_veriable.setnepdate;
                    dboper.Savecurrent();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    /// intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }
                finish();

            }
        });

        Cyear.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                if(Cyear.getText().toString().length()==4){
                    curyear = Integer.parseInt(Cyear.getText().toString());
                    Display_calendar();}
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        mimageNY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    curyear = Integer.parseInt(Cyear.getText().toString());
                    curyear = curyear + 1;
                    if (curyear > 1900 && curyear < 2180) {
                        Display_calendar();
                        Cyear.setText(curyear + "");
                    } else {
                        Toast.makeText(calendar.this, "Can't view for this year.", Toast.LENGTH_LONG).show();
                    }
                }
            });



            mimagePY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    curyear = Integer.parseInt(Cyear.getText().toString());
                    curyear = curyear - 1;
                    if (curyear > 1900 && curyear < 2180) {
                        Display_calendar();
                        Cyear.setText(curyear + "");
                    } else {
                        Toast.makeText(calendar.this, "Can't view for this year.", Toast.LENGTH_LONG).show();
                    }
                }
            });

            mimagePM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    curmonth = curmonth - 1;
                    if (curmonth == 0) {
                        curmonth = 12;
                        curyear = curyear - 1;
                    }
                    Display_calendar();
                }
            });
            mimageNM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    curmonth = curmonth + 1;
                    if (curmonth == 13) {
                        curmonth = 1;
                        curyear = curyear + 1;
                    }
                    Display_calendar();
                }
            });




            cd1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd1.getText().toString().length() > 0) {
                        clearbackground();
                        cd1.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd1.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));

                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);

                    }
                }
            });
            cd2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearbackground();
                    if (cd2.getText().toString().length() > 0) {
                        cd2.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd2.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));

                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });

            cd3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearbackground();
                    if (cd3.getText().toString().length() > 0) {
                        cd3.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd3.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));

                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearbackground();
                    if (cd4.getText().toString().length() > 0) {
                        cd4.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd4.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));

                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearbackground();
                    if (cd5.getText().toString().length() > 0) {
                        cd5.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd5.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clearbackground();
                    if (cd6.getText().toString().length() > 0) {
                        cd6.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd6.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd7.getText().toString().length() > 0) {
                        clearbackground();
                        cd7.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd7.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd8.getText().toString().length() > 0) {
                        clearbackground();
                        cd8.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd8.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd9.getText().toString().length() > 0) {
                        clearbackground();
                        cd9.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd9.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd10.getText().toString().length() > 0) {
                        clearbackground();
                        cd10.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd10.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd11.getText().toString().length() > 0) {
                        clearbackground();
                        cd11.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd11.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd12.getText().toString().length() > 0) {
                        clearbackground();
                        cd12.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd12.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd13.getText().toString().length() > 0) {
                        clearbackground();
                        cd13.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd13.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd14.getText().toString().length() > 0) {
                        clearbackground();
                        cd14.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd14.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd15.getText().toString().length() > 0) {
                        clearbackground();
                        cd15.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd15.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd16.getText().toString().length() > 0) {
                        clearbackground();
                        cd16.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd16.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd17.getText().toString().length() > 0) {
                        clearbackground();
                        cd17.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd17.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd18.getText().toString().length() > 0) {
                        clearbackground();
                        cd18.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd18.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd19.getText().toString().length() > 0) {
                        clearbackground();
                        cd19.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd19.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd20.getText().toString().length() > 0) {
                        clearbackground();
                        cd20.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd20.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd21.getText().toString().length() > 0) {
                        clearbackground();
                        cd21.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd21.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd22.getText().toString().length() > 0) {
                        clearbackground();
                        cd22.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd22.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd23.getText().toString().length() > 0) {
                        clearbackground();
                        cd23.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd23.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd24.getText().toString().length() > 0) {
                        clearbackground();
                        cd24.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd24.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd25.getText().toString().length() > 0) {
                        clearbackground();
                        cd25.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd25.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd26.getText().toString().length() > 0) {
                        clearbackground();
                        cd26.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd26.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd27.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd27.getText().toString().length() > 0) {
                        clearbackground();
                        cd27.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd27.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd28.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd28.getText().toString().length() > 0) {
                        clearbackground();
                        cd28.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd28.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd29.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd29.getText().toString().length() > 0) {
                        clearbackground();
                        cd29.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd29.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd30.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd30.getText().toString().length() > 0) {
                        clearbackground();
                        cd30.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd30.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd31.getText().toString().length() > 0) {
                        clearbackground();
                        cd31.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd31.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd32.getText().toString().length() > 0) {
                        clearbackground();
                        cd32.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd32.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd33.getText().toString().length() > 0) {
                        clearbackground();
                        cd33.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd33.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd34.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd34.getText().toString().length() > 0) {
                        clearbackground();
                        cd34.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd34.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd35.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd35.getText().toString().length() > 0) {
                        clearbackground();
                        cd35.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd35.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd36.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd36.getText().toString().length() > 0) {
                        clearbackground();
                        cd36.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd36.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd37.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd37.getText().toString().length() > 0) {
                        clearbackground();
                        cd37.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd37.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd38.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd38.getText().toString().length() > 0) {
                        clearbackground();
                        cd38.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd38.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd39.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd39.getText().toString().length() > 0) {
                        clearbackground();
                        cd39.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd39.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd40.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd40.getText().toString().length() > 0) {
                        clearbackground();
                        cd40.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd40.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd41.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd41.getText().toString().length() > 0) {
                        clearbackground();
                        cd41.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd41.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });
            cd42.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd42.getText().toString().length() > 0) {
                        clearbackground();
                        cd42.setBackgroundResource(R.color.yellow);
                        curdate = Integer.parseInt(cd42.getText().toString());
                        Public_veriable.setnepdate =(curyear + Public_veriable.DS + Chdigit(curmonth) + Public_veriable.DS + Chdigit(curdate));
                        changeNIswidate(curyear, curmonth, curdate);
                        Iswidate.setText(Chdigit(idate) + Public_veriable.DS + Fname.monthname_eng(imonth) + Public_veriable.DS + iyear);
                    }
                }
            });




    }

    void loadstartnepdate() {
        final Calendar CC = Calendar.getInstance();
        changeENdate(CC.get(Calendar.YEAR), CC.get(Calendar.MONTH) + 1, CC.get(Calendar.DAY_OF_MONTH));
        nyear = curyear;
        nmonth = curmonth;
        ndate = curdate;
        Iswidate.setText(Chdigit(CC.get(Calendar.DAY_OF_MONTH)) + Public_veriable.DS + Fname.monthname_eng(CC.get(Calendar.MONTH) + 1) + Public_veriable.DS + (CC.get(Calendar.YEAR)));
        Display_calendar();
        Cyear.setText(curyear + "");
    }


    private static String Chdigit(int value) {
        if (value < 10)
            return "0" + value;
        else
            return String.valueOf(value);
    }

    void changeENdate(long y1, int m1, int d1) {
        int m;
        double TD, FD, YD = 0, NE;
        long NEP;
        m = m1 - 1;
        TD = 365.25 * (y1 - 1);

        if (y1 % 4 == 0) {
            String someWords = "0 31 60 91 121 152 182 213 244 274 305 335 366";
            String[] Sectext = someWords.split(" ");
            TD = TD + Integer.parseInt(Sectext[m]);
        } else {
            String someWords = "0 31 59 90 120 151 181 212 243 273 304 334 365";
            String[] Sectext = someWords.split(" ");
            TD = TD + Integer.parseInt(Sectext[m]);
        }

        FD = 20735 + (long) TD + d1;
        NE = (long) FD / 365.25;

        for (NEP = (int) (NE - 4); NEP < (int) (NE + 4); NEP++) {
            if (FD - (366 + (NEP - 2) * 365.25875876) <= 366) {
                curyear = NEP;
                break;
            }
        }

        dboper.getnepmonthday(curyear);
        String[] Sectext = Public_veriable.monthday.split(" ");
        YD = FD + 1112210 - Integer.parseInt(Sectext[14]);
        long cmd = 0;
        long cmdP = 0;
        for (int i = 1; i < 13; i++) {
            cmd += Integer.parseInt(Sectext[i]);
            if (cmd >= YD) {
                curmonth = i;
                curdate = (int) (YD - cmdP);
                break;
            }
            cmdP += Integer.parseInt(Sectext[i]);
        }

    }

    void changeNIswidate(long y1, int m1, int d1) {
        dboper.getnepmonthday(y1);
        long cmd = 0;
        double TD, FD = 0, NE;
        long NEP;
        String[] Sectext = Public_veriable.monthday.split(" ");
        for (int i = 2; i < m1 + 1; i++) {
            cmd += Integer.parseInt(Sectext[i - 1]);
        }
        TD = cmd - 20735 - 1112210 + d1 + Integer.parseInt(Sectext[14]);
        NE = (long) TD / 365;
        for (NEP = (int) (NE - 4); NEP < (int) (NE + 4); NEP++) {
            if (TD - ((NEP - 1) * 365.25) <= 366) {
                iyear = NEP;
                FD = TD - (int) (365.25 * (NEP - 1));
                break;
            }
        }
        String mwords;
        if (iyear % 4 == 0) {
            mwords = "0 31 60 91 121 152 182 213 244 274 305 355 366";
        } else {
            mwords = "0 31 59 90 120 151 181 212 243 273 304 334 365";
        }

        cmd = 0;
        long cmdp = 0;
        String[] mtext = mwords.split(" ");

        for (int i = 1; i < 13; i++) {
            cmd = Integer.parseInt(mtext[i]);
            cmdp = Integer.parseInt(mtext[i - 1]);
            if (cmd >= FD) {
                imonth = i;
                idate = (int) (FD - cmdp);
                break;
            }

        }
    }

    void Display_calendar() {

        clearbackground();
        Cmonth.setText(Fname.monthname_nep(curmonth));
        dboper.getnepmonthday(curyear);
        String[] Sectext = Public_veriable.monthday.split(" ");
        String[] mtext = new String[42];
        int std = Integer.parseInt(Sectext[15]);
        int tday = Integer.parseInt(Sectext[curmonth]);

        int m = 1;
        int Tld = 0;
        for (int i = 1; i < curmonth; i++) {
            Tld = Tld + Integer.parseInt(Sectext[i]);
        }
        if (curmonth != 1) {
            std = (Tld + std) % 7;
        }
        if (std == 0) {
            std = 7;
        }
        for (int i = 0; i < 42; i++) {
            if (i >= std - 1 && m <= tday) {
                mtext[i] = m + "";
                m = m + 1;
            } else {
                mtext[i] = "";
            }
        }

        cd1.setText(mtext[0]);
        cd2.setText(mtext[1]);
        cd3.setText(mtext[2]);
        cd4.setText(mtext[3]);
        cd5.setText(mtext[4]);
        cd6.setText(mtext[5]);
        cd7.setText(mtext[6]);
        cd8.setText(mtext[7]);
        cd9.setText(mtext[8]);
        cd10.setText(mtext[9]);
        cd11.setText(mtext[10]);
        cd12.setText(mtext[11]);
        cd13.setText(mtext[12]);
        cd14.setText(mtext[13]);
        cd15.setText(mtext[14]);
        cd16.setText(mtext[15]);
        cd17.setText(mtext[16]);
        cd18.setText(mtext[17]);
        cd19.setText(mtext[18]);
        cd20.setText(mtext[19]);
        cd21.setText(mtext[20]);
        cd22.setText(mtext[21]);
        cd23.setText(mtext[22]);
        cd24.setText(mtext[23]);
        cd25.setText(mtext[24]);
        cd26.setText(mtext[25]);
        cd27.setText(mtext[26]);
        cd28.setText(mtext[27]);
        cd29.setText(mtext[28]);
        cd30.setText(mtext[29]);
        cd31.setText(mtext[30]);
        cd32.setText(mtext[31]);
        cd33.setText(mtext[32]);
        cd34.setText(mtext[33]);
        cd35.setText(mtext[34]);
        cd36.setText(mtext[35]);
        cd37.setText(mtext[36]);
        cd38.setText(mtext[37]);
        cd39.setText(mtext[38]);
        cd40.setText(mtext[39]);
        cd41.setText(mtext[40]);
        cd42.setText(mtext[41]);

        if (curyear == nyear && curmonth == nmonth) {
            setcolor_to_todaydate();
        }
    }

    void setcolor_to_todaydate() {
        if (cd1.getText().toString().length() > 0 && Integer.parseInt(cd1.getText().toString()) == ndate) {
            cd1.setBackgroundResource(R.color.leaf_green);
        }
        if (cd2.getText().toString().length() > 0 && Integer.parseInt(cd2.getText().toString()) == ndate) {
            cd2.setBackgroundResource(R.color.leaf_green);
        }
        if (cd3.getText().toString().length() > 0 && Integer.parseInt(cd3.getText().toString()) == ndate) {
            cd3.setBackgroundResource(R.color.leaf_green);
        }
        if (cd4.getText().toString().length() > 0 && Integer.parseInt(cd4.getText().toString()) == ndate) {
            cd4.setBackgroundResource(R.color.leaf_green);
        }
        if (cd5.getText().toString().length() > 0 && Integer.parseInt(cd5.getText().toString()) == ndate) {
            cd5.setBackgroundResource(R.color.leaf_green);
        }
        if (cd6.getText().toString().length() > 0 && Integer.parseInt(cd6.getText().toString()) == ndate) {
            cd6.setBackgroundResource(R.color.leaf_green);
        }
        if (cd7.getText().toString().length() > 0 && Integer.parseInt(cd7.getText().toString()) == ndate) {
            cd7.setBackgroundResource(R.color.leaf_green);
        }
        if (cd8.getText().toString().length() > 0 && Integer.parseInt(cd8.getText().toString()) == ndate) {
            cd8.setBackgroundResource(R.color.leaf_green);
        }
        if (cd9.getText().toString().length() > 0 && Integer.parseInt(cd9.getText().toString()) == ndate) {
            cd9.setBackgroundResource(R.color.leaf_green);
        }
        if (cd10.getText().toString().length() > 0 && Integer.parseInt(cd10.getText().toString()) == ndate) {
            cd10.setBackgroundResource(R.color.leaf_green);
        }
        if (cd11.getText().toString().length() > 0 && Integer.parseInt(cd11.getText().toString()) == ndate) {
            cd11.setBackgroundResource(R.color.leaf_green);
        }
        if (cd12.getText().toString().length() > 0 && Integer.parseInt(cd12.getText().toString()) == ndate) {
            cd12.setBackgroundResource(R.color.leaf_green);
        }
        if (cd13.getText().toString().length() > 0 && Integer.parseInt(cd13.getText().toString()) == ndate) {
            cd13.setBackgroundResource(R.color.leaf_green);
        }
        if (cd14.getText().toString().length() > 0 && Integer.parseInt(cd14.getText().toString()) == ndate) {
            cd14.setBackgroundResource(R.color.leaf_green);
        }
        if (cd15.getText().toString().length() > 0 && Integer.parseInt(cd15.getText().toString()) == ndate) {
            cd15.setBackgroundResource(R.color.leaf_green);
        }
        if (cd16.getText().toString().length() > 0 && Integer.parseInt(cd16.getText().toString()) == ndate) {
            cd16.setBackgroundResource(R.color.leaf_green);
        }
        if (cd17.getText().toString().length() > 0 && Integer.parseInt(cd17.getText().toString()) == ndate) {
            cd17.setBackgroundResource(R.color.leaf_green);
        }
        if (cd18.getText().toString().length() > 0 && Integer.parseInt(cd18.getText().toString()) == ndate) {
            cd18.setBackgroundResource(R.color.leaf_green);
        }
        if (cd19.getText().toString().length() > 0 && Integer.parseInt(cd19.getText().toString()) == ndate) {
            cd19.setBackgroundResource(R.color.leaf_green);
        }
        if (cd20.getText().toString().length() > 0 && Integer.parseInt(cd20.getText().toString()) == ndate) {
            cd20.setBackgroundResource(R.color.leaf_green);
        }
        if (cd21.getText().toString().length() > 0 && Integer.parseInt(cd21.getText().toString()) == ndate) {
            cd21.setBackgroundResource(R.color.leaf_green);
        }
        if (cd22.getText().toString().length() > 0 && Integer.parseInt(cd22.getText().toString()) == ndate) {
            cd22.setBackgroundResource(R.color.leaf_green);
        }
        if (cd23.getText().toString().length() > 0 && Integer.parseInt(cd23.getText().toString()) == ndate) {
            cd23.setBackgroundResource(R.color.leaf_green);
        }
        if (cd24.getText().toString().length() > 0 && Integer.parseInt(cd24.getText().toString()) == ndate) {
            cd24.setBackgroundResource(R.color.leaf_green);
        }
        if (cd25.getText().toString().length() > 0 && Integer.parseInt(cd25.getText().toString()) == ndate) {
            cd25.setBackgroundResource(R.color.leaf_green);
        }
        if (cd26.getText().toString().length() > 0 && Integer.parseInt(cd26.getText().toString()) == ndate) {
            cd26.setBackgroundResource(R.color.leaf_green);
        }
        if (cd27.getText().toString().length() > 0 && Integer.parseInt(cd27.getText().toString()) == ndate) {
            cd27.setBackgroundResource(R.color.leaf_green);
        }
        if (cd28.getText().toString().length() > 0 && Integer.parseInt(cd28.getText().toString()) == ndate) {
            cd28.setBackgroundResource(R.color.leaf_green);
        }
        if (cd29.getText().toString().length() > 0 && Integer.parseInt(cd29.getText().toString()) == ndate) {
            cd29.setBackgroundResource(R.color.leaf_green);
        }
        if (cd30.getText().toString().length() > 0 && Integer.parseInt(cd30.getText().toString()) == ndate) {
            cd30.setBackgroundResource(R.color.leaf_green);
        }
        if (cd31.getText().toString().length() > 0 && Integer.parseInt(cd31.getText().toString()) == ndate) {
            cd31.setBackgroundResource(R.color.leaf_green);
        }
        if (cd32.getText().toString().length() > 0 && Integer.parseInt(cd32.getText().toString()) == ndate) {
            cd32.setBackgroundResource(R.color.leaf_green);
        }
        if (cd33.getText().toString().length() > 0 && Integer.parseInt(cd33.getText().toString()) == ndate) {
            cd33.setBackgroundResource(R.color.leaf_green);
        }
        if (cd34.getText().toString().length() > 0 && Integer.parseInt(cd34.getText().toString()) == ndate) {
            cd34.setBackgroundResource(R.color.leaf_green);
        }
        if (cd35.getText().toString().length() > 0 && Integer.parseInt(cd35.getText().toString()) == ndate) {
            cd35.setBackgroundResource(R.color.leaf_green);
        }
        if (cd36.getText().toString().length() > 0 && Integer.parseInt(cd36.getText().toString()) == ndate) {
            cd36.setBackgroundResource(R.color.leaf_green);
        }
        if (cd37.getText().toString().length() > 0 && Integer.parseInt(cd37.getText().toString()) == ndate) {
            cd37.setBackgroundResource(R.color.leaf_green);
        }
        if (cd38.getText().toString().length() > 0 && Integer.parseInt(cd38.getText().toString()) == ndate) {
            cd38.setBackgroundResource(R.color.leaf_green);
        }
        if (cd39.getText().toString().length() > 0 && Integer.parseInt(cd39.getText().toString()) == ndate) {
            cd39.setBackgroundResource(R.color.leaf_green);
        }
        if (cd40.getText().toString().length() > 0 && Integer.parseInt(cd40.getText().toString()) == ndate) {
            cd40.setBackgroundResource(R.color.leaf_green);
        }
        if (cd41.getText().toString().length() > 0 && Integer.parseInt(cd41.getText().toString()) == ndate) {
            cd41.setBackgroundResource(R.color.leaf_green);
        }
        if (cd42.getText().toString().length() > 0 && Integer.parseInt(cd42.getText().toString()) == ndate) {
            cd42.setBackgroundResource(R.color.leaf_green);
        }

    }

    void clearbackground() {
        cd1.setBackgroundDrawable(null);
        cd19.setBackgroundDrawable(null);
        cd2.setBackgroundDrawable(null);
        cd20.setBackgroundDrawable(null);
        cd3.setBackgroundDrawable(null);
        cd21.setBackgroundDrawable(null);
        cd4.setBackgroundDrawable(null);
        cd22.setBackgroundDrawable(null);
        cd5.setBackgroundDrawable(null);
        cd23.setBackgroundDrawable(null);
        cd6.setBackgroundDrawable(null);
        cd7.setBackgroundDrawable(null);
        cd24.setBackgroundDrawable(null);
        cd8.setBackgroundDrawable(null);
        cd25.setBackgroundDrawable(null);
        cd9.setBackgroundDrawable(null);
        cd26.setBackgroundDrawable(null);
        cd10.setBackgroundDrawable(null);
        cd27.setBackgroundDrawable(null);
        cd11.setBackgroundDrawable(null);
        cd28.setBackgroundDrawable(null);
        cd12.setBackgroundDrawable(null);
        cd29.setBackgroundDrawable(null);
        cd13.setBackgroundDrawable(null);
        cd30.setBackgroundDrawable(null);
        cd14.setBackgroundDrawable(null);
        cd31.setBackgroundDrawable(null);
        cd15.setBackgroundDrawable(null);
        cd32.setBackgroundDrawable(null);
        cd16.setBackgroundDrawable(null);
        cd33.setBackgroundDrawable(null);
        cd17.setBackgroundDrawable(null);
        cd34.setBackgroundDrawable(null);
        cd18.setBackgroundDrawable(null);
        cd35.setBackgroundDrawable(null);
        cd36.setBackgroundDrawable(null);
        cd37.setBackgroundDrawable(null);
        cd38.setBackgroundDrawable(null);
        cd39.setBackgroundDrawable(null);
        cd40.setBackgroundDrawable(null);
        cd41.setBackgroundDrawable(null);
        cd42.setBackgroundDrawable(null);
    }


}
