import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class DKAdHelper {

    private AdView mAdView;
    private Context context;
    private String test_banner_id = "ca-app-pub-3940256099942544/6300978111";

    /**
     * Layout where you would like to show AD
     */
    public ViewGroup containerForAD;

    /**
     * ID of a banner to show in production (obtain from AdMob console)
     */
    public String bannerAdUnitID;

    /**
     * Init AdHelper with your publisher ID (obtain from AdMob console)
     * @param context context
     * @param publisherID your publisher ID
     */
    public DKAdHelper(Context context, String publisherID) {
        MobileAds.initialize(context, publisherID);
        this.context = context;
    }

    /**
     * Show Ad Banner if containerForAD and bannerAdUnitID is set
     */
    public void showAdBanner() {
        if (this.containerForAD != null
                && this.bannerAdUnitID != null) {
            showAdBanner(containerForAD, bannerAdUnitID);
        }
    }

    /**
     * Show test Ad Banner if containerForAD is set
     */
    public void showTestAdBanner() {
        if (this.containerForAD != null) {
            showTestAdBanner(this.containerForAD);
        }
    }

    /**
     * Show test Ad Banner in dedicated layout
     * @param containerForAd Layout where you would like to show AD
     */
    public void showTestAdBanner(final ViewGroup containerForAd) {
        this.showAdBanner(containerForAd, test_banner_id);
    }

    /**
     * Show Ad Banner if containerForAd and adUnitID was not set
     * @param containerForAd Layout where you would like to show AD
     * @param adUnitID ID of a banner to show in production (obtain from AdMob console)
     */
    public void showAdBanner(ViewGroup containerForAd, String adUnitID) {

        this.containerForAD = containerForAd;
        this.bannerAdUnitID = adUnitID;

        // Create a banner ad
        if(mAdView == null) {
            mAdView = new AdView(this.context);
            mAdView.setAdSize(AdSize.SMART_BANNER);
            mAdView.setAdUnitId(adUnitID);
            containerForAD.addView(mAdView);
        }

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                mAdView.setVisibility(View.VISIBLE);
                containerForAD.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                mAdView.setVisibility(View.GONE);
                containerForAD.setVisibility(View.GONE);
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }
}

