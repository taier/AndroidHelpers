[ ![Download](https://api.bintray.com/packages/deniss-kaibagarovs/Maven/AndroidHelpers/images/download.svg?version=0.0.2) ](https://bintray.com/deniss-kaibagarovs/Maven/AndroidHelpers/0.0.2/link)
# Android Helpers
Collection of utility classes, that simplify Android development.

## Table of contents
- DKAdHelper - simplify AdMob integration into App

## DKAdHelper

### Install
1. Add in **gradle**
```
implementation 'com.kaibagarovs:android_helpers:0.0.2'
implementation 'com.google.android.gms:play-services-ads:15.0.0'
```
2. Add in **Manifest**
```
<uses-permission android:name="android.permission.INTERNET" />
```

### How to use

**Add in Activity** (for example in onCreate)
```
DKAdHelper adHelper = new DKAdHelper(this, "ca-app-pub-XXXXX"); // your publisher ID, obtained from AdMob console
adHelper.bannerAdUnitID = "ca-app-pub-XXXXX"; // your banner ID, obtained from AdMob console
adHelper.containerForAD = adContainer; // container to put ad into

if (BuildConfig.DEBUG) { // on debug show test ad 
    adHelper.showTestAdBanner();
} else {
    adHelper.showAdBanner();
}
```

Optional: **Add in Layout** 
```
<LinearLayout
        android:id="@+id/adContainer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
</LinearLayout>
```
