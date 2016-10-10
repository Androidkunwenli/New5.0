package com.kunkun.optcolor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.Vibrant)
    TextView Vibrant;
    @Bind(R.id.Vibrantdark)
    TextView Vibrantdark;
    @Bind(R.id.Vibrantlight)
    TextView Vibrantlight;
    @Bind(R.id.Muted)
    TextView Muted;
    @Bind(R.id.Muteddark)
    TextView Muteddark;
    @Bind(R.id.Mutedlighr)
    TextView Mutedlighr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // 获取ImageView的背景bitmap
        Bitmap bitmap = ((BitmapDrawable) imageView.getBackground()).getBitmap();


        //取色
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 获取6种颜色，并设置给TextView,默认值为红色
                Mutedlighr.setBackgroundColor(palette.getLightMutedColor(Color.RED));
                Muted.setBackgroundColor(palette.getMutedColor(Color.RED));
                Muteddark.setBackgroundColor(palette.getDarkMutedColor(Color.RED));
                Vibrantlight.setBackgroundColor(palette.getLightVibrantColor(Color.RED));
                Vibrant.setBackgroundColor(palette.getVibrantColor(Color.RED));
                Vibrantdark.setBackgroundColor(palette.getDarkVibrantColor(Color.RED));

            }
        });

    }
}
