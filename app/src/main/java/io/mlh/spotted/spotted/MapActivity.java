package io.mlh.spotted.spotted;

import android.app.Activity;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class MapActivity extends Activity {

    private SubsamplingScaleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_map);

//        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        imageView = (SubsamplingScaleImageView) findViewById(R.id.imageView);
        //imageView.setImage(ImageSource.resource(R.drawable.roskilde));
        imageView.setImage(ImageSource.asset("roskilde.jpg"));
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP);

        
    }
}
