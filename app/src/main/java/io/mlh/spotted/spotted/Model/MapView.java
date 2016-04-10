package io.mlh.spotted.spotted.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wisienkas on 4/10/16.
 */
public class MapView extends SubsamplingScaleImageView implements Observer {


    private int strokeWidth;

    private long delta_update = 10000;
    private long lastUpdate = System.currentTimeMillis();
    private List<PointF> cachedCircles = Arrays.asList(new PointF(522.7679697949027f, 175.97223709038803f),
            new PointF(929.4326568220673f, 243.37484540403486f),
            new PointF(231.48704182925175f, 786.7016830006975f),
            new PointF(192.57153850764678f, 1385.9278682507786f),
            new PointF(515.472494775478f, 1063.1703584001586f),
            new PointF(414.80213052562584f, 1078.4042414823557f),
            new PointF(729.330296226741f, 1759.1295384097825f),
            new PointF(171.55854862581475f, 229.2820952748969f),
            new PointF(213.30526391221804f, 1647.6317745354975f),
            new PointF(223.87521307373788f, 1288.35207198808f)
            );
    private PointF latlonDiff = new PointF(
            (float)Math.abs(56.172592 - 56.171099),
            (float)Math.abs(10.187319 - 10.190999)
    );
    private PointF latlonmin = new PointF(
            (float)Math.min(56.172592, 56.171099),
            (float)Math.min(10.187319, 10.190999)
    );

    public MapView(Context context) {
        this(context, null);
        refreshCircles();
    }

    public MapView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        strokeWidth = (int)(density/60f);
        Connections.getINSTANCE().addObserver(this);
        refreshCircles();
    }

    private void refreshCircles() {
        Connections.getINSTANCE().update();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady()) {
            return;
        }

        drawCircle(canvas, new PointF(getWidth() / 3, getHeight() / 2), Color.YELLOW);

        // printCoords(cachedCircles);
        for(PointF point : cachedCircles) {
            drawCircle(canvas, point, Color.RED);
        }
    }

    private void drawCircle(Canvas canvas, PointF mapPoint, int color) {
        PointF vCenter = sourceToViewCoord(mapPoint);
        float radius = (getScale() * getSWidth()) * 0.02f;

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
        canvas.drawCircle(vCenter.x, vCenter.y, radius, paint);
    }

    @Override
    public void update(Observable observable, Object data) {
//        ParseQuery<ParseUser> query = new ParseQuery<>("_User");
//        List<String> friends = matchesFriends((List<ParseObject>) data);
//        query.whereContainedIn("username", friends);
//        Log.i("PARSE-FETCH", "Fetching matching users");
//        query.findInBackground(new FindCallback<ParseUser>() {
//            @Override
//            public void done(List<ParseUser> objects, ParseException e) {
//                if(objects != null) {
//                    List<PointF> points = new ArrayList<PointF>();
//                    for (ParseUser pu : objects) {
//                        points.add(calcPoint(pu.getParseGeoPoint("location")));
//                    }
//                    printCoords(points);
//                    cachedCircles = points;
//                }
//            }
//        });
    }

    private void printCoords(List<PointF> points) {
        Log.i("COORD", "Found: " + points + " Coords, Current user: " + User.user.getUsername());
        for(PointF pf : points) {
            Log.i("COORD", "point at {" + pf.x + ", " + pf.y + "}");
        }
    }


    private PointF calcPoint(ParseGeoPoint location) {
        PointF scalar = new PointF(getWidth() / latlonDiff.x, getHeight() / latlonDiff.y);
        float x_coord = (float) (Math.min(location.getLatitude() - latlonmin.x, 0) * scalar.x);
        float y_coord = (float) (Math.min(location.getLatitude() - latlonmin.y, 0) * scalar.y);

        return new PointF(x_coord, y_coord);
    }

    public List<String> matchesFriends(List<ParseObject> connections) {
        List<String> list = new ArrayList<>();
        for (ParseObject po : connections) {
            if(po.getString("user1").equalsIgnoreCase(User.user.getString("username"))) {
                list.add(po.getString("user2"));
            } else if(po.getString("user2").equalsIgnoreCase(User.user.getString("username"))) {
                list.add(po.getString("user1"));
            }
        }
        return list;
    }
}
