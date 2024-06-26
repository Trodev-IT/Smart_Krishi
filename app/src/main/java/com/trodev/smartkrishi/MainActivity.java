package com.trodev.smartkrishi;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import com.trodev.smartkrishi.fragment.BooksFragment;
import com.trodev.smartkrishi.fragment.HomeFragment;
import com.trodev.smartkrishi.fragment.ServicesFragment;
import com.trodev.smartkrishi.fragment.ProfileFragment;

import java.util.Objects;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "0cef1653-c181-475a-8e47-7fa04d359f11";
    SmoothBottomBar smoothBottomBar;
    private boolean doubleBackToExitPressedOnce = false;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private long pressedTime;
    RelativeLayout layout;
    Dialog dialog;
    SharedPreferences sharedPreferences;
    private static final String  SHARED_PREF_NAME = "mypref";
    private static final String  KEY_VALUE = "false";
    boolean value = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verbose Logging set to help debug issues, remove before releasing your app.
        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);
        OneSignal.initWithContext(this, ONESIGNAL_APP_ID);
        OneSignal.getUser().getPushSubscription().optIn();

        /*init all drawer layout*/
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        layout = findViewById(R.id.relative);

        /*init views*/
        smoothBottomBar = findViewById(R.id.bottombar);

        // Drawer Layout implement
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // navigation view work process
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        /*When apps start show HomeFragments*/
        setTitle("হোম");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
        fragmentTransaction.commit();


        /*set all status bar, navigation bar, toolbar color*/
        smoothBottomBar.setBarBackgroundColor(Color.parseColor("#008937"));
        getWindow().setNavigationBarColor(Color.parseColor("#008937"));
        getWindow().setStatusBarColor(Color.parseColor("#008937"));


        /*smooth bar working process*/
        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                if (i == 0) {
                    setTitle("হোম");
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#008937"));
                    getWindow().setNavigationBarColor(Color.parseColor("#008937"));
                    getWindow().setStatusBarColor(Color.parseColor("#008937"));

                }

                if (i == 1) {
                    setTitle("কৃষি হাত বই");
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new BooksFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#008937"));
                    getWindow().setNavigationBarColor(Color.parseColor("#008937"));
                    getWindow().setStatusBarColor(Color.parseColor("#008937"));
                }

//                if (i == 2) {
//                    setTitle("কৃষি সুবিধা");
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.frameLayout, new ServicesFragment());
//                    fragmentTransaction.commit();
//
//                    /*set all status bar, navigation bar, toolbar color*/
//                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#008937"));
//                    getWindow().setNavigationBarColor(Color.parseColor("#008937"));
//                    getWindow().setStatusBarColor(Color.parseColor("#008937"));
//                }

                if (i == 2) {
                    setTitle("প্রোফাইল");
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new ProfileFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#008937"));
                    getWindow().setNavigationBarColor(Color.parseColor("#008937"));
                    getWindow().setStatusBarColor(Color.parseColor("#008937"));
                }

                return false;
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        value = sharedPreferences.getBoolean(KEY_VALUE, false);


        /*create pop up menu*/
        if(!value)
            CreatepopUpwindow();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        int itemId = item.getItemId();

//        if (itemId == R.id.menu_notification) {
//            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
//
//        }
        if (itemId == R.id.menu_privacy) {
            Toast.makeText(this, "প্রাইভেসি পলেসি", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, PrivacyPolicy.class));

        } else if (itemId == R.id.menu_share) {
            Toast.makeText(this, "এপ শেয়ার করা হচ্ছে", Toast.LENGTH_SHORT).show();
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Smart Krishi");
                String shareMessage = "\nSmart Krishi App Download now\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));

            } catch (Exception e) {
                Toast.makeText(this, " এপ শেয়ার হচ্ছে না", Toast.LENGTH_SHORT).show();
            }
        } else if (itemId == R.id.menu_rating) {
            Toast.makeText(this, "রেট দিন", Toast.LENGTH_SHORT).show();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                Toast.makeText(this, "রেট দিন", Toast.LENGTH_SHORT).show();
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }

        } else if (itemId == R.id.menu_apps) {
            Toast.makeText(this, "আমাদের এপ সমুহ", Toast.LENGTH_SHORT).show();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6580660399707616800")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6580660399707616800")));
            }

        } else if (itemId == R.id.menu_developer) {
            Toast.makeText(this, "ডেভেলপার", Toast.LENGTH_SHORT).show();
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.contact_bottomsheet_layout);

            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);

        } else if (itemId == R.id.menu_company) {
            Toast.makeText(this, "ওয়েবসাইট", Toast.LENGTH_SHORT).show();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trodev.com/")));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trodev.com/")));
            }

        } else if (itemId == R.id.menu_email) {
            Toast.makeText(this, "আমাদের মেইল করুন", Toast.LENGTH_SHORT).show();
            try {
                Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:" + "help.smartkrishi@gmail.com"));
                //intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Help of");
                intent.putExtra(Intent.EXTRA_TEXT, "Assalamualaikum");
                startActivity(Intent.createChooser(intent, "Dear Sir"));
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "Unable to access email", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    // In this code, android lifecycle exit on 2 times back-pressed.
//    @Override
//    public void onBackPressed() {
//        if (pressedTime + 2000 > System.currentTimeMillis()) {
//            super.onBackPressed();
//            finish();
//        } else {
//            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
//        }
//        pressedTime = System.currentTimeMillis();
//    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        showExitCardViewDialog();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000); // Reset the flag after 2 seconds
    }

    private void showExitCardViewDialog() {
        // Create a custom layout for the exit dialog
        View exitDialogView = LayoutInflater.from(this).inflate(R.layout.cardview, null);

        // Customize the TextView or add more views as needed
        //TextView exitDialogText = exitDialogView.findViewById(R.id.exitDialogText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(exitDialogView).setPositiveButton("হ্যা", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("না", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();

        // Customize the animation if needed
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    private void CreatepopUpwindow() {

        Button yes;

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_screen, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;

        boolean focusable = true;

        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);


        layout.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
            }
        });


        yes = popUpView.findViewById(R.id.yes);
        popUpView.setClickable(true);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                Toast.makeText(MainActivity.this, "ধন্যবাদ সম্মতি প্রদান করার জন্য", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(KEY_VALUE, true);
                editor.apply();
            }
        });
    }
}