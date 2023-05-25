package suj.soft.app.kundali_darsanv2;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.OverlayItem;
import java.util.ArrayList;
import org.osmdroid.views.overlay.ItemizedOverlay;

public class myItemizedOverlay extends ItemizedOverlay<OverlayItem> {
     private final ArrayList<OverlayItem> overlayItemList = new ArrayList<OverlayItem>();

    public myItemizedOverlay(Drawable pDefaultMarker,
                             ResourceProxy pResourceProxy) {
        super(pDefaultMarker, pResourceProxy);
        // TODO Auto-generated constructor stub

    }

    public void addItem(GeoPoint p, String title, String snippet) {
        OverlayItem newItem = new OverlayItem(title, snippet, p);
        overlayItemList.add(newItem);
        populate();
    }

    @Override
    public boolean onSnapToItem(int arg0, int arg1, Point arg2, IMapView arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected OverlayItem createItem(int arg0) {
        // TODO Auto-generated method stub
        return overlayItemList.get(arg0);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return overlayItemList.size();
    }

    boolean onTap(GeoPoint p, MapView mapView)
    {

         return false;
    }

}


