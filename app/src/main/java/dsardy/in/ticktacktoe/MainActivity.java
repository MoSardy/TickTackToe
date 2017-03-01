package dsardy.in.ticktacktoe;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    imgButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    boolean isGameOn = false;
    boolean isWinned = false;
    int playcount,whosturn=1 ;
    TextView tv,fact;
    LinearLayout gamebuttons, gamemsg;
    Button playagain;
    ArrayList<String> alist;
    ArrayList<String> ilist;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alist = new ArrayList<>();
        ilist = new ArrayList<>();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference facts = database.getReference("facts");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        facts.child("androidwins").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String ss = dataSnapshot.getValue(String.class);
                Log.e("andfacts",dataSnapshot.toString());
                alist.add(ss);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        facts.child("iphonewins").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String ss = dataSnapshot.getValue(String.class);
                ilist.add(ss);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        imageView = (ImageView)findViewById(R.id.imageView);
       createbuttons();
        tv = (TextView)findViewById(R.id.textView2);
        gamebuttons = (LinearLayout)findViewById(R.id.llbtns);
        gamemsg = (LinearLayout)findViewById(R.id.llmsg);
        playagain = (Button)findViewById(R.id.buttonPlayAgain);
        fact =(TextView)findViewById(R.id.textViewfact);

        intiategame();


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isGameOn){
                    swipeturn();
                }

            }
        });

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recreate();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b1.getValue() == 10) {

                    if(!isGameOn){
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if(whosturn==1){
                        b1.setValue(1);
                        b1.setImageResource(R.drawable.androidmark);
                    }else {
                        b1.setValue(2);
                        b1.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if(!isWinned){
                        swipeturn();
                    }



                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b2.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b2.setValue(1);
                        b2.setImageResource(R.drawable.androidmark);
                    } else {
                        b2.setValue(2);
                        b2.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b3.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b3.setValue(1);
                        b3.setImageResource(R.drawable.androidmark);
                    } else {
                        b3.setValue(2);
                        b3.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b4.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b4.setValue(1);
                        b4.setImageResource(R.drawable.androidmark);
                    } else {
                        b4.setValue(2);
                        b4.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b5.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b5.setValue(1);
                        b5.setImageResource(R.drawable.androidmark);
                    } else {
                        b5.setValue(2);
                        b5.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b6.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b6.setValue(1);
                        b6.setImageResource(R.drawable.androidmark);
                    } else {
                        b6.setValue(2);
                        b6.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b7.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b7.setValue(1);
                        b7.setImageResource(R.drawable.androidmark);
                    } else {
                        b7.setValue(2);
                        b7.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b8.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b8.setValue(1);
                        b8.setImageResource(R.drawable.androidmark);
                    } else {
                        b8.setValue(2);
                        b8.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b9.getValue() == 10) {

                    if (!isGameOn) {
                        startgame();
                    }
                    playcount=playcount+1;

                    //set mark
                    if (whosturn == 1) {
                        b9.setValue(1);
                        b9.setImageResource(R.drawable.androidmark);
                    } else {
                        b9.setValue(2);
                        b9.setImageResource(R.drawable.iphonemark);
                    }

                    //check if anyone winning
                    checkall();

                    if (!isWinned) {
                        swipeturn();
                    }

                }
            }
        });

    }

    private void createbuttons() {
        b1= (imgButton)findViewById(R.id.b1);
        b2= (imgButton)findViewById(R.id.b2);
        b3= (imgButton)findViewById(R.id.b3);
        b4= (imgButton)findViewById(R.id.b4);
        b5= (imgButton)findViewById(R.id.b5);
        b6= (imgButton)findViewById(R.id.b6);
        b7= (imgButton)findViewById(R.id.b7);
        b8= (imgButton)findViewById(R.id.b8);
        b9= (imgButton)findViewById(R.id.b9);
    }

    private void intiategame() {
        //will do all the initial setup and animations
        tv.setText("Android play");
        imageView.setImageResource(R.drawable.androidplaying);



        gamemsg.setVisibility(View.GONE);
        gamebuttons.setVisibility(View.VISIBLE);

    }

    private void swipeturn() {
        if(playcount<9){
            if(whosturn==1){
                whosturn=2;
                imageView.setImageResource(R.drawable.iphoneplaying);
                tv.setText("iPhone play");

            }else {
                whosturn=1;
                imageView.setImageResource(R.drawable.androidplaying);
                tv.setText("Android play");

            }
        }else{
            draww();
        }

    }

    private void checkall() {
        //this method will check all the buttons


        if (b1.getValue() + b2.getValue() + b3.getValue() == 3 || b4.getValue() + b5.getValue() + b6.getValue() == 3 || b7.getValue() + b8.getValue() + b9.getValue() == 3 || b1.getValue() + b4.getValue() + b7.getValue() == 3 || b2.getValue() + b5.getValue() + b8.getValue() == 3 || b3.getValue() + b6.getValue() + b9.getValue() == 3 || b1.getValue() + b5.getValue() + b9.getValue() == 3 || b3.getValue() + b5.getValue() + b7.getValue() == 3) {

            isWinned = true;
            imageView.setImageResource(R.drawable.noplaying);
            androidWins();
        }

        if (b1.getValue() + b2.getValue() + b3.getValue() == 6 || b4.getValue() + b5.getValue() + b6.getValue() == 6 || b7.getValue() + b8.getValue() + b9.getValue() == 6 || b1.getValue() + b4.getValue() + b7.getValue() == 6 || b2.getValue() + b5.getValue() + b8.getValue() == 6 || b3.getValue() + b6.getValue() + b9.getValue() == 6 || b1.getValue() + b5.getValue() + b9.getValue() == 6 || b3.getValue() + b5.getValue() + b7.getValue() == 6) {
            isWinned = true;
            imageView.setImageResource(R.drawable.noplaying);
            iphoneWins();
        }


    }

    private void iphoneWins() {
        tv.setText("iPhone Wins !");


        Random r = new Random();
        int i1 = r.nextInt(ilist.size());
        fact.setText(ilist.get(i1));


        stopgame();
    }

    private void androidWins() {
        tv.setText("Android Wins !");
        Random r = new Random();
        int i1 = r.nextInt(alist.size());
        fact.setText(alist.get(i1));
        stopgame();
    }

    private void draww() {
        imageView.setImageResource(R.drawable.noplaying);
        tv.setText("its a draw !");
        fact.setText("");
        stopgame();

    }

    private void stopgame() {
        isGameOn = false;
        playcount=0;
        gamebuttons.setVisibility(View.GONE);
        gamemsg.setVisibility(View.VISIBLE);
    }

    private void startgame() {
        isGameOn = true;
        playcount=0;
    }

}
