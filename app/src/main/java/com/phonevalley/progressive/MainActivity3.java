package com.phonevalley.progressive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.appnext.ads.interstitial.Interstitial;
import com.appnext.banners.BannerAdRequest;
import com.appnext.banners.BannerListener;
import com.appnext.banners.BannerView;
import com.appnext.base.Appnext;
import com.appnext.core.AppnextAdCreativeType;
import com.appnext.core.AppnextError;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnAdOpened;

public class MainActivity3 extends AppCompatActivity {

    private BannerView bannerViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Appnext.init(this);
        bannerViewOne = findViewById(R.id.banner1);
        BannerAdRequest banner_request = new BannerAdRequest();

        banner_request
                .setCategories("category1, category2")
                .setPostback("");

        bannerViewOne.loadAd(banner_request);
        bannerViewOne.setBannerListener(new BannerListener() {
            @Override
            public void onError(AppnextError error) {
                super.onError(error);
                Toast.makeText(getApplicationContext(), "Banner1: " + error.getErrorMessage(), Toast.LENGTH_SHORT).show();
                //System.out.println(error.toString());
            }

            @Override
            public void onAdLoaded(String s, AppnextAdCreativeType creativeType) {
                super.onAdLoaded(s, creativeType);
            }

            @Override
            public void adImpression() {
                super.adImpression();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bannerViewOne.destroy();

    }
}