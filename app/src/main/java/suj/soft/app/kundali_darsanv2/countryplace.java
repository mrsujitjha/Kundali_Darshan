package suj.soft.app.kundali_darsanv2;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;



import android.app.Activity;

import java.util.ArrayList;


public class countryplace extends Activity {
    private MapView         mMapView;
    private MapController   mMapController;

    public static DatabaseHelper dbHelper=null;
    private static DBOperation dboper=null;
    public static Spinner spinner,spinnerM;
    public static ArrayAdapter <CharSequence> adapter,adapterM ;
    private int runapp=1,Cid,Pid;
    private String msgtitle,msgbody;
    private RadioButton RC,RP;
    String madd;
    double mlat;
    double mlong;
    private EditText Sctext,Pctext,lattxt,longtxt,clongtxt;

    LinearLayout imageback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countryplace);
        mMapView = (MapView) findViewById(R.id.mapview);
        mMapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        mMapView.setBuiltInZoomControls(true);
        mMapView.setBuiltInZoomControls(true);
        mMapView.setMultiTouchControls(true);
        mMapController = (MapController) mMapView.getController();
        mMapController.setZoom(13);

        //attach listeners

        dbHelper = new DatabaseHelper(this,"Kundali.db",null,1);
        dboper=new DBOperation();
        Sctext = (EditText)findViewById(R.id.EditText01);//search contry
        Pctext = (EditText)findViewById(R.id.editText4);//search place
        lattxt = (EditText)findViewById(R.id.editText1);//lat place
        longtxt = (EditText)findViewById(R.id.editText2);//long place
        clongtxt = (EditText)findViewById(R.id.editText3);//long place
        RC = (RadioButton) findViewById(R.id.radio0);
        RP = (RadioButton) findViewById(R.id.radio1);

        imageback = (LinearLayout)findViewById(R.id.LinearLayout1);//Pre kundali
        Drawable backpic  = null;
        if(Public_veriable.OB==0){backpic  =null;}
        if(Public_veriable.OB==1){backpic  = getResources().getDrawable(R.drawable.paper);}
        if(Public_veriable.OB==2){backpic  = getResources().getDrawable(R.drawable.lightwood);}
        if(Public_veriable.OB==3){backpic  = getResources().getDrawable(R.drawable.background);}
        imageback.setBackgroundDrawable(backpic);

        getnetgpsstatus();
        loadspinner_Con(147);
        spinner.setSelection(Public_veriable.CRno);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String conid =  spinner.getSelectedItem().toString();
                Public_veriable.Clientcob =Integer.parseInt((conid.substring(0,3)).trim());
                Public_veriable.Stext = "";
                Public_veriable.Ptext = "";
                loadspinner_place(1);
                RC.setChecked(true) ;
                String ctext=(conid.substring(0,3)).trim();
                Sctext.setText(conid.replace(ctext, "").trim());

            }
            public void onNothingSelected(AdapterView<?> parent) {  }
        });

        spinnerM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                dboper.FindLatlong(spinner,spinnerM);
                lattxt.setText(Public_veriable.Plat);
                longtxt.setText(Public_veriable.Plong);
                clongtxt.setText(Public_veriable.Clong);
                double mlat = 0,mlong = 0;
                int i = Public_veriable.Plat.indexOf("S");
                if(i<0){i = Public_veriable.Plat.indexOf("N");}
                mlat = Double.parseDouble(Public_veriable.Plat.substring(0,i).trim());
                mlat +=Double.parseDouble(Public_veriable.Plat.substring(i+1))/60;
                if( Public_veriable.Plat.contains("S")){mlat=mlat*-1;}

                i = Public_veriable.Plong.indexOf("W");
                if(i<0){i = Public_veriable.Plong.indexOf("E");}
                mlong = Double.parseDouble(Public_veriable.Plong.substring(0,i).trim());
                mlong +=Double.parseDouble(Public_veriable.Plong.substring(i+1))/60;

                if( Public_veriable.Plong.contains("W")){mlong=mlong*-1;}

                RP.setChecked(true) ;
                String ptext =  spinnerM.getSelectedItem().toString();
                int pt =ptext.length();
                String ptextid =(ptext.substring(pt-10,pt)).trim();
                Pctext.setText(ptext.replace(ptextid, "").trim());
                madd=spinnerM.getSelectedItem().toString();
                GeoPoint ngPt = new GeoPoint(mlat, mlong);
                mMapController.setCenter(ngPt);

                Drawable marker=getResources().getDrawable(android.R.drawable.star_on);
              // Drawable marker=getResources().getDrawable(R.drawable.yellowpin);

                int markerWidth = marker.getIntrinsicWidth();
                int markerHeight = marker.getIntrinsicHeight();
                marker.setBounds(0, markerHeight, markerWidth, 0);
                ResourceProxy resourceProxy = new DefaultResourceProxyImpl(getApplicationContext());
                myItemizedOverlay    myItemizedOverlay = new myItemizedOverlay(marker, resourceProxy);
                mMapView.getOverlays().add(myItemizedOverlay);
                myItemizedOverlay.addItem(ngPt, ptext, ptext);
                mMapController.setCenter(ngPt);
                  }
            public void onNothingSelected(AdapterView<?> parent) {  }
        });
        Overlay touchOverlay = new Overlay(this){
            ItemizedIconOverlay<OverlayItem> anotherItemizedIconOverlay = null;
            @Override
            protected void draw(Canvas arg0, MapView arg1, boolean arg2) {

            }
            @Override
            public boolean onSingleTapConfirmed(final MotionEvent e, final MapView mapView) {

                final Drawable marker = getApplicationContext().getResources().getDrawable(android.R.drawable.star_on);
                Projection proj = mapView.getProjection();
                GeoPoint loc = (GeoPoint) proj.fromPixels((int)e.getX(), (int)e.getY());
                String longitude = Double.toString(((double)loc.getLongitudeE6())/1000000);
                String latitude = Double.toString(((double)loc.getLatitudeE6())/1000000);
                System.out.println("- Latitude = " + latitude + ", Longitude = " + longitude );

                double plat = ((double)loc.getLongitudeE6())/1000000;
                double plong = ((double)loc.getLatitudeE6())/1000000;
                int glt = Math.abs((int) plat);
                int glo = Math.abs((int) plong);
                int gltm = (int)((Math.abs(plat)-glt)*100);
                int glom = (int)((Math.abs(plong)-glo)*100);
                String NS ="N";
                String EW ="E";
                if(plat<0){NS ="S";}
                if(plong<0){EW ="W";}
                if(RP.isChecked()){
                    lattxt.setText(glt+NS+ gltm);
                    longtxt.setText(glo+EW+glom);}
                if(RC.isChecked()){
                    clongtxt.setText(glo+EW+ glom);}

                ArrayList<OverlayItem> overlayArray = new ArrayList<OverlayItem>();
                OverlayItem mapItem = new OverlayItem("", "", new GeoPoint((((double)loc.getLatitudeE6())/1000000), (((double)loc.getLongitudeE6())/1000000)));
                mapItem.setMarker(marker);
                overlayArray.add(mapItem);
                if(anotherItemizedIconOverlay==null){
                    anotherItemizedIconOverlay = new ItemizedIconOverlay<OverlayItem>(getApplicationContext(), overlayArray,null);
                    mapView.getOverlays().add(anotherItemizedIconOverlay);
                    mapView.invalidate();
                }else{
                    mapView.getOverlays().remove(anotherItemizedIconOverlay);
                    mapView.invalidate();
                    anotherItemizedIconOverlay = new ItemizedIconOverlay<OverlayItem>(getApplicationContext(), overlayArray,null);
                    mapView.getOverlays().add(anotherItemizedIconOverlay);
                }
                //      dlgThread();
                return true;
            }

        };
        mMapView.getOverlays().add(touchOverlay);
    }

   private void getnetgpsstatus(){
        if (isgpsAvailable()==false){
            Toast.makeText(getApplicationContext(), "Start GPS to run this app", Toast.LENGTH_SHORT).show();
            if (runapp==1){runapp=0;}
        }
        if (isNetworkAvailable()==false){
            Toast.makeText(getApplicationContext(), "Internate connection needed to run this app", Toast.LENGTH_SHORT).show();
            if (runapp==1){runapp=0;}
        }
    }
    private boolean isNetworkAvailable() {
        boolean mnet = false;
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo != null){mnet =  activeNetworkInfo.isConnected();}
        return mnet;
    }
    private boolean isgpsAvailable(){
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}
        return gps_enabled;
    }

    public void onclick_search(View view){
        Public_veriable.Stext = Sctext.getText().toString();
        Public_veriable.Ptext = Pctext.getText().toString();
        if(RC.isChecked()){loadspinner_Con(0);}
        if(RP.isChecked()){loadspinner_place(0);}
    }
    public void onclick_delete(View view){
        if(RC.isChecked()){
            msgtitle="Delete Country detail";
            String conid =  spinner.getSelectedItem().toString();
            msgbody="Sure to Delete country and all places detail of " + conid;
            String ctext=(conid.substring(0,3)).trim();
            Cid =Integer.parseInt(ctext);
            AlertDialog YNbox = showYNbox(2);
            YNbox.show();
        }
        if(RP.isChecked()){
            String ptext =  spinnerM.getSelectedItem().toString();
            int pt =ptext.length();
            String ptextid =(ptext.substring(pt-10,pt)).trim();
            Pid =Integer.parseInt(ptextid);
            msgtitle="Delete Place detail";
            msgbody="Sure to delete Place detail";
            AlertDialog YNbox = showYNbox(3);
            YNbox.show();
        }
    }


    public void onclick_addedit(View view){

        if(RC.isChecked()){
            String conid =  spinner.getSelectedItem().toString();
            Cid =100000;
            msgtitle="Add new Country detail";
            msgbody="Sure to add new country detail";
            String ctext=(conid.substring(0,3)).trim();
            conid=conid.replace(ctext, "").trim();
            if( conid.equals(Sctext.getText().toString().trim())){
                Cid =Integer.parseInt(ctext);msgtitle="Edit Country detail";msgbody="Sure to Edit Country detail";}
            AlertDialog YNbox = showYNbox(0);
            YNbox.show();
        }

        if(RP.isChecked()){
            String ptext =  spinnerM.getSelectedItem().toString();
            Pid =1000000;
            int pt =ptext.length();
            msgtitle="Add new Place detail";

            String ptextid =(ptext.substring(pt-10,pt)).trim();
            ptext=ptext.replace(ptextid, "").trim();
            String conid =  spinner.getSelectedItem().toString();
            msgbody="Sure to add new place in country " + conid;
            Cid=Integer.parseInt((conid.substring(0,3)).trim());
            if( ptext.equals(Pctext.getText().toString().trim())){
                Pid =Integer.parseInt(ptextid);msgtitle="Edit Place detail";msgbody="Sure to Edit place of country " + conid;}
            AlertDialog YNbox = showYNbox(1);
            YNbox.show();
        }
    }
    public AlertDialog showYNbox(final int jobid){
        AlertDialog QuitYNbox = new AlertDialog.Builder(this)
                .setTitle(msgtitle)
                .setMessage(msgbody)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int Sb) {
                        if(jobid==0){dboper.savecountry(Cid, Sctext.getText().toString(), clongtxt.getText().toString());}
                        if(jobid==1){dboper.savePlace(Cid,Pid, Pctext.getText().toString(), lattxt.getText().toString(), longtxt.getText().toString());}
                        if(jobid==2){dboper.Delcountry(Cid);}
                        if(jobid==3){dboper.DelPlace(Pid);}
                    }})
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int Sb) {
                        Toast.makeText(getApplicationContext(),"Canceled.", Toast.LENGTH_LONG).show();

                    }})
                .create();
        return QuitYNbox;
    }
    public void loadspinner_Con(int Crno){
        adapter = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dboper.getAllcontry(Crno,adapter);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        if (spinner.getAdapter().getCount()>0){
            loadspinner_place(1); }
    }
    public void loadspinner_place(int Prno){
        adapterM = new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerM = (Spinner) findViewById(R.id.spinner2);
        dboper.getAllplace(Prno,adapterM,spinner);
        spinnerM.setAdapter(adapterM);
    }




}
