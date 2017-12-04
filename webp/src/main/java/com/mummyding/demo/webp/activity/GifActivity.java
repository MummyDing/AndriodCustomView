package com.mummyding.demo.webp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.mummyding.demo.webp.R;

public class GifActivity extends AppCompatActivity {

    private SimpleDraweeView mNormalGif;
    private SimpleDraweeView mWebpGif;
    private SimpleDraweeView mNormalTransGif;
    private SimpleDraweeView mWebpTransGif;
    private SimpleDraweeView mWebpTransImage;

    public static void launch(Context context) {
        Intent intent = new Intent(context, GifActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        mNormalGif = findViewById(R.id.normal_gif);
        mWebpGif = findViewById(R.id.webp_gif);
        mNormalTransGif = findViewById(R.id.normal_trans_gif);
        mWebpTransGif = findViewById(R.id.webp_trans_gif);
        mWebpTransImage = findViewById(R.id.webp_trans_img);


        ImageRequest request = ImageRequestBuilder.newBuilderWithResourceId(R.raw.test_gifimage).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(request.getSourceUri())
                .setAutoPlayAnimations(true)
                .build();
        mNormalGif.setController(controller);

        request = ImageRequestBuilder.newBuilderWithResourceId(R.raw.test_gifimage_webp).build();
        controller = Fresco.newDraweeControllerBuilder()
                .setUri(request.getSourceUri())
                .setAutoPlayAnimations(true)
                .build();
        mWebpGif.setController(controller);


        request = ImageRequestBuilder.newBuilderWithResourceId(R.raw.test_trans_gif).build();
        controller = Fresco.newDraweeControllerBuilder()
                .setUri(request.getSourceUri())
                .setAutoPlayAnimations(true)
                .build();
        mNormalTransGif.setController(controller);

        request = ImageRequestBuilder.newBuilderWithResourceId(R.raw.test_trans_gif_webp).build();
        controller = Fresco.newDraweeControllerBuilder()
                .setUri(request.getSourceUri())
                .setAutoPlayAnimations(true)
                .build();
        mWebpTransGif.setController(controller);


        Uri uri = new Uri.Builder().scheme("res")
                .path(String.valueOf(R.drawable.test_trans_image_webp))
                .build();
        mWebpTransImage.setImageURI(uri);
    }
}

