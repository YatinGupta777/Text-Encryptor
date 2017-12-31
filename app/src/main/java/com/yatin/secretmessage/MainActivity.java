package com.yatin.secretmessage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity  {

    EditText encryptEditText;
    TextView encryptTextView;
    EditText decryptEditText;
    TextView decryptTextView;

    Button button1;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encryptEditText = (EditText)findViewById(R.id.encryptEditText);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//deleted PlaceholderFragment class from here

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1 tab1 = new Tab1();
                    return tab1;
                case 1:
                    Tab2 tab2 = new Tab2();
                    return tab2;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ENCRYPT";
                case 1:
                    return "DECRYPT";
            }
            return null;
        }
    }





    public void encrypt(View view){
        encryptEditText = (EditText)findViewById(R.id.encryptEditText);
        String text = encryptEditText.getText().toString();
        String k = "";//keyword

        String data = "";
        encryptTextView = (TextView)findViewById(R.id.encryptTextView);
        int ci; //ciphered text
        int m = 0;//used for keyword length algorithm
        int index = 0 ;
        if(view.getTag().toString().equals(Integer.toString(1)) ){
            k = "AsTGdhfswbibvdskvbkjsbvvsd";
            Snackbar.make(view, "Encryption Code 1", Snackbar.LENGTH_LONG)
                   .setAction("Action", null).show();
        }else if(view.getTag().toString().equals(Integer.toString(2)) ){
            k = "bfdsjbjbsjgvkjsdjniwejfczmlnca";
            Snackbar.make(view, "Encryption Code 2", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(3)) ){
            k = "nahahbcdsjvjavwklfnvkwbgkwjbg";
            Snackbar.make(view, "Encryption Code 3", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(4)) ){
            k = "LODLVfnlsgnksbvksbvgskjdbgkvsdln";
            Snackbar.make(view, "Encryption Code 4", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(5)) ){
            k = "ATHCJDvksdnvlksnvlsnvsklvsvnknnvsdl";
            Snackbar.make(view, "Encryption Code 5", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(6)) ){
            k = "ZsIdaklsnckavnsdlnvnsdvnlklsdsgdg";
            Snackbar.make(view, "Encryption Code 6", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(7)) ){
            k = "YUuDJsaflsvsdlnglslgnlksnglsngls";
            Snackbar.make(view, "Encryption Code 7", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(8)) ){
            k = "hfskdgbskjbgkjsgbsTYHbvskldnvslSDGB";
            Snackbar.make(view, "Encryption Code 8", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        char[] kArray = k.toCharArray();

        for(int i = 0,q = text.length();i < q;i++)//looping characters of text
        {
            char c = text.charAt(i);
            char d;
            if(Character.isLetter(c))
            {
                index = m % k.length();//for matching keyword and text number of letters

                if (Character.isLowerCase(c))//for lower case alphabets
                {
                    if( Character.isLowerCase(kArray[index]))
                    {
                        d  = (char) ((((c-97) + ((kArray[index]-97) % 26))%26) + 97);//cipher algoritm when text and key lowercase
                        data = data + d;
                        encryptTextView.setText(data);
                    }
                  else
                   {
                       d = (char)((((c-97) + ((kArray[index]-65) % 26))%26) + 97);//cipher algoritm when text lowercase key uppercase
                       data = data + d;
                       encryptTextView.setText(data);
                    }
                }
                else
                {
                    if(Character.isLowerCase(kArray[index]))
                    {
                        d = (char)((((c-65) + ((kArray[index]-97) % 26))%26) + 65);
                        data = data + d;
                        encryptTextView.setText(data);
                    }
                    else
                    {
                        d = (char)((((c-65) + ((kArray[index]-65) % 26))%26) + 65);
                        data = data + d;
                        encryptTextView.setText(data);
                    }

                }
                m++;//to use next char of keyword
            }
            else//if text char is not alphabet
           {
               d = c;
               data = data + d;
               encryptTextView.setText(data);
            }

            encryptTextView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("label",encryptTextView.getText().toString() );
                    clipboard.setPrimaryClip(clip);
                    Snackbar.make(view, "Text Copied", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return true;
                }
            });

            encryptEditText.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    String pasteText;

                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        if(clipboard.hasPrimaryClip()== true){
                            ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                            pasteText = item.getText().toString();
                            encryptEditText.setText(pasteText);
                            Snackbar.make(view, "Text pasted from clipboard", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();

                        }else {

                            Toast.makeText(getApplicationContext(), "Nothing to Paste", Toast.LENGTH_SHORT).show();

                        }
                        return true;

            }
            });

    }}
    public void decrypt(View view){
        decryptEditText = (EditText)findViewById(R.id.decryptEditText);
        String text = decryptEditText.getText().toString();
        String k = "";//keyword
        String data = "";
        decryptTextView = (TextView)findViewById(R.id.decryptTextView);
        int ci; //ciphered text
        int m = 0;//used for keyword length algorithm
        int index = 0 ;
        if(view.getTag().toString().equals(Integer.toString(1)) ){
            k = "AsTGdhfswbibvdskvbkjsbvvsd";
            Snackbar.make(view, "Decryption Code 1", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }else if(view.getTag().toString().equals(Integer.toString(2)) ){
            k = "bfdsjbjbsjgvkjsdjniwejfczmlnca";
            Snackbar.make(view, "Decryption Code 2", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(3)) ){
            k = "nahahbcdsjvjavwklfnvkwbgkwjbg";
            Snackbar.make(view, "Decryption Code 3", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(4)) ){
            k = "LODLVfnlsgnksbvksbvgskjdbgkvsdln";
            Snackbar.make(view, "Decryption Code 4", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(5)) ){
            k = "ATHCJDvksdnvlksnvlsnvsklvsvnknnvsdl";
            Snackbar.make(view, "Decryption Code 5", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(6)) ){
            k = "ZsIdaklsnckavnsdlnvnsdvnlklsdsgdg";
            Snackbar.make(view, "Decryption Code 6", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(7)) ){
            k = "YUuDJsaflsvsdlnglslgnlksnglsngls";
            Snackbar.make(view, "Decryption Code 7", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }else if(view.getTag().toString().equals(Integer.toString(8)) ){
            k = "hfskdgbskjbgkjsgbsTYHbvskldnvslSDGB";
            Snackbar.make(view, "Decryption Code 8", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        char[] kArray = k.toCharArray();


        for(int i = 0,q = text.length();i < q;i++)//looping characters of text
        {
            char c = text.charAt(i);
            char d;
            if(Character.isLetter(c))
            {
                index = m % k.length();//for matching keyword and text number of letters

                if (Character.isLowerCase(c))//for lower case alphabets
                {
                    if( Character.isLowerCase(kArray[index]))
                    {
                        if((c-97) - ((kArray[index]-97) % 26) < 0)
                        d  = (char) ((((c-97) - ((kArray[index]-97) % 26) + 26)%26) + 97);
                        else
                            d  = (char) ((((c-97) - ((kArray[index]-97) % 26))%26) + 97);//cipher algoritm when text and key lowercase
                        data = data + d;
                        decryptTextView.setText(data);
                    }
                      else
                         {
                             if((c-97) - ((kArray[index]-65) % 26) < 0)
                                 d  = (char) ((((c-97) - ((kArray[index]-65) % 26) + 26)%26) + 97);
                             else
                                 d  = (char) ((((c-97) - ((kArray[index]-65) % 26))%26) + 97);//cipher algoritm when text and key lowercase
                             data = data + d;
                             decryptTextView.setText(data);
                           }
                       }
                       else
                       {
                          if( Character.isLowerCase(kArray[index]))
                          {
                              if((c-65) - ((kArray[index]-97) % 26) < 0)
                                  d  = (char) ((((c-65) - ((kArray[index]-97) % 26) + 26)%26) + 65);
                              else
                                  d  = (char) ((((c-65) - ((kArray[index]-97) % 26))%26) + 65);//cipher algoritm when text and key lowercase
                              data = data + d;
                              decryptTextView.setText(data);
                        }
                          else
                           {
                               if((c-65) - ((kArray[index]-65) % 26) < 0)
                                   d  = (char) ((((c-65) - ((kArray[index]-65) % 26) + 26)%26) + 65);
                               else
                                   d  = (char) ((((c-65) - ((kArray[index]-65) % 26))%26) + 65);//cipher algoritm when text and key lowercase
                               data = data + d;
                               decryptTextView.setText(data);
                         }

                }
                m++;//to use next char of keyword
            }
             else//if text char is not alphabet
              {
                  d = c;
                  data = data + d;
                  decryptTextView.setText(data);
              }
            decryptTextView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("label",decryptTextView.getText().toString() );
                    clipboard.setPrimaryClip(clip);
                    Snackbar.make(view, "Text Copied", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return true;
                }
            });


            decryptEditText.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    String pasteText;

                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    if(clipboard.hasPrimaryClip()== true){
                        ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                        pasteText = item.getText().toString();
                        decryptEditText.setText(pasteText);
                        Snackbar.make(view, "Text pasted from clipboard", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    }else {

                        Toast.makeText(getApplicationContext(), "Nothing to Paste", Toast.LENGTH_SHORT).show();

                    }
                    return true;

                }
            });


        }
    }
}
