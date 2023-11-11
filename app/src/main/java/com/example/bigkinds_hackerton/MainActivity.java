package com.example.bigkinds_hackerton;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    Adapter adapter;
    List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.ic_launcher_background, "dd", "dd", "urlurlrul"));
        models.add(new Model(R.drawable.fluentfood20regular, "dd", "dd"));
        models.add(new Model(R.drawable.ic_launcher_background, "dd", "dd"));

        adapter = new Adapter(models, this);
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter);

        int marginPx = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16,
                getResources().getDisplayMetrics()
        );


        viewPager2.setOffscreenPageLimit(3);

        float pageMarginpx = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        float pagerWidth = getResources().getDimensionPixelOffset(R.dimen.pageWidth);
        float screenWidth = getResources().getDisplayMetrics().widthPixels;
        float offsetPx = screenWidth - pageMarginpx -  pagerWidth;

        viewPager2.setPageTransformer((page, position) -> {
            float translationX = position * -(offsetPx / 7.5f); // offset을 2로 나누어 살짝 보이도록 함
            page.setTranslationX(translationX);

            // Optional: Adjust other properties based on the position if needed
            float scaleFactor = 1 - Math.abs(position) * 0.2f;
            page.setScaleY(scaleFactor);
            page.setScaleX(scaleFactor);
            // Adjust alpha, rotation, or other properties as needed

        });
    }


}