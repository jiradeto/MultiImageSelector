package me.nereo.multi_image_selector;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class FullscreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        initInstance();
    }

    public static final String IMAGE_PATH = "IMAGE_PATH";

    ImageView mImageView;
    PhotoViewAttacher mAttacher;

    private void initInstance() {

        mImageView = (ImageView) findViewById(R.id.imv_fullscreen);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {


            String imagePath = bundle.getString(IMAGE_PATH);
            Drawable bitmap = Drawable.createFromPath(imagePath);
            mImageView.setImageDrawable(bitmap);


//            Picasso.with(FullscreenActivity.this)
//                    .load(imagePath)
//                    .placeholder(R.drawable.default_error)
//                    .tag(MultiImageSelectorFragment.TAG)
//                    .into(mImageView);

            mAttacher = new PhotoViewAttacher(mImageView);
        }

    }
}
