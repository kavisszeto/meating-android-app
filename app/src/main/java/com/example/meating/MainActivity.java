package com.example.meating;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.meating.ui.addvalue.AddValueFragment;
import com.example.meating.ui.member.MemberFragment;
import com.example.meating.ui.shop.Meat;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;
import com.example.meating.databinding.ActivityMainBinding;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity implements LogInOutListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    public boolean hasBeenLoggedIn;
    public HashMap<Integer, Meat> meat;
    public Meat meatForProductDialog;
    public LinkedHashMap<Meat, Float> selectedMeats;
    public ArrayList<AbstractMap.SimpleEntry<Long, Float>> records;
    public float currentCash = 1000.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hasBeenLoggedIn = false;
        selectedMeats = new LinkedHashMap<Meat, Float>();
        records = new ArrayList<AbstractMap.SimpleEntry<Long, Float>>();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Must be put after setupWithNavController
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = 0;
                if (item.getItemId() == R.id.nav_map) id=1;
                if (item.getItemId() == R.id.action_search) id=2;
                if (item.getItemId() == R.id.action_comment) id=3;
                switch (id) {
                    case 1:
                        callMap();
                        break;
                    case 2:
                        callSearch();
                        break;
                    case 3:
                        callMail();
                        break;
                    default:
                        NavigationUI.onNavDestinationSelected(item, navController);
                        break;
                }

                drawer.close();

                return true;
            }
        });

        // Load products data
        meat = new HashMap<Integer, Meat>();

        try {
            XmlResourceParser xrp = getResources().getXml(R.xml.products);
            xrp.next();

            int eventType = xrp.getEventType();
            String tag = "";
            Meat m = null;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        tag = xrp.getName();

                        if (tag.equalsIgnoreCase("product")) {
                            m = new Meat();
                            m.id = xrp.getAttributeValue(null, "id");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if(!xrp.getText().equals("")) {
                            switch (tag) {
                                case "name":
                                    m.name = xrp.getText();
                                    break;

                                case "image":
                                    m.image = xrp.getText();
                                    break;

                                case "priceShort":
                                    m.priceShort = Float.parseFloat(xrp.getText());
                                    break;

                                case "priceSmall":
                                    m.priceSmall = Float.parseFloat(xrp.getText());
                                    break;

                                case "priceMedium":
                                    m.priceMedium = Float.parseFloat(xrp.getText());
                                    break;

                                case "priceLarge":
                                    m.priceLarge = Float.parseFloat(xrp.getText());
                                    break;

                                default:
                                    break;
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (xrp.getName().equalsIgnoreCase("product")) {
                            switch (m.id) {
                                case "m1":
                                    meat.put(R.id.m1, m);
                                    break;
                                case "m2":
                                    meat.put(R.id.m2, m);
                                    break;
                                case "m3":
                                    meat.put(R.id.m3, m);
                                    break;
                                case "m4":
                                    meat.put(R.id.m4, m);
                                    break;
                                case "m5":
                                    meat.put(R.id.m5, m);
                                    break;
                                case "m6":
                                    meat.put(R.id.m6, m);
                                    break;
                                case "m7":
                                    meat.put(R.id.m7, m);
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;

                    default:
                        break;
                }

                eventType = xrp.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = 0;
        if (item.getItemId() == R.id.nav_map) id=1;
        if (item.getItemId() == R.id.action_search) id=2;
        if (item.getItemId() == R.id.action_comment) id=3;
        switch (item.getItemId()) {
            case 1:
                callMap();
                return true;
            case 2:
                callSearch();
                return true;
            case 3:
                callMail();
                break;
            default:
                NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
                return NavigationUI.onNavDestinationSelected(item, navController)
                        || super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void logIn() {
        DialogFragment newFragment = new LoginDiaLogFrament();
        newFragment.show(getSupportFragmentManager(), "Login");
    }

    public void logOut() {
        onLogOutSucceeded();
    }

    @Override
    public void onLogInSucceeded() {
        hasBeenLoggedIn = true;

        if (MemberFragment.instance != null)
            MemberFragment.instance.onLogOutSucceeded();
    }

    @Override
    public void onLogOutSucceeded() {
        hasBeenLoggedIn = false;

        if (MemberFragment.instance != null)
            MemberFragment.instance.onLogOutSucceeded();
    }

    public void onBtnClick(View view) {
        int id = 0;
        if (view.getId() == R.id.btn_logIn) id=1;
        if (view.getId() == R.id.btn_signUp) id=2;
        if (view.getId() == R.id.btn_logOut) id=3;
        switch (id) {
            case 1:
                logIn();
                break;

            case 2:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;

            case 3:
                logOut();
                break;

            default:
                break;
        }
    }

    public void onClickAddValue(View view) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_addvalue);
    }

    public void onClickRecord(View view) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_record);
    }

    public void onClickPersonal(View view) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_personal);
    }

    public void onClickProduct(View view) {
        meatForProductDialog = meat.get(view.getId());
        ProductDialogFragment newFragment = new ProductDialogFragment();
        newFragment.show(getSupportFragmentManager(), "Product");
    }

    public void callShop() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.nav_shop);
    }

    private void callMap() {
        Uri location = Uri.parse("geo:0,0?q=國立高雄科技大學第一校區管理學院");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    private void callSearch() {
        Uri webpage = Uri.parse("https://www.google.com/search?q=TaiwanGooGooGood");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    private void callMail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"C110134148@nkust.edu.tw"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Meating Mail Testing");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "This is Mail Testing.");

        startActivity(emailIntent);
    }

    public void onPurchaseBtnClick(View view) {
        float total = 0.0f;

        for (Map.Entry<Meat, Float> set : selectedMeats.entrySet()) {
            total += set.getValue();
        }

        float cashAfter = currentCash - total;

        if (cashAfter < 0.0f) {
            Toast.makeText(this, "購買失敗", Toast.LENGTH_SHORT).show();
        } else {
            currentCash -= total;

            Date d = new Date();
            records.add(new AbstractMap.SimpleEntry<Long, Float>(d.getTime(), total));
            selectedMeats.clear();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.nav_home);
            Toast.makeText(this, "購買成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void onAddvalueClick(View view) {
        if(AddValueFragment.instance.getAddAmount() > 0.0f) {
            currentCash += AddValueFragment.instance.getAddAmount();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.nav_member);
            Toast.makeText(this, "加值成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "錯誤數值", Toast.LENGTH_SHORT).show();
        }
    }
}