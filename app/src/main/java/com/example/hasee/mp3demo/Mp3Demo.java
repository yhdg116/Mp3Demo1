package com.example.hasee.mp3demo;

import android.media.MediaPlayer;

import android.os.Bundle;

import android.app.Activity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.TextView;


public class Mp3Demo extends Activity

{

    public  String s1="NULL";
    private Button start=null;

    private Button pause=null;

    private Button stop=null;

    private TextView state=null;

    private MediaPlayer mp3;

    private Boolean flag=false;

    @Override

    protected void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);

        super.setContentView(R.layout.activity_mp3_demo);



        start=(Button) super.findViewById(R.id.start);

        pause=(Button) super.findViewById(R.id.pause);

        stop=(Button) super.findViewById(R.id.stop);

        state=(TextView)super.findViewById(R.id.state);



        start.setOnClickListener(new OnClickListenerStart());

        pause.setOnClickListener(new OnClickListenerPause());

        stop.setOnClickListener(new OnClickListenerStop());

        mp3= new MediaPlayer();



        mp3 = MediaPlayer.create(Mp3Demo.this,R.raw.deadorlie);

    }



    private class OnClickListenerStart implements OnClickListener{



        @Override



        public void onClick(View v)

        {



            try

            {

                if (mp3!=null)

                {

                    mp3.stop();

                }

                mp3.prepare();

                mp3.start();

                state.setText("Playing");

            } catch (Exception e)

            {

                state.setText(e.toString());

                e.printStackTrace();
            }

        }

    }



    private class OnClickListenerPause implements OnClickListener{

        @Override

        public void onClick(View v)

        {

            try

            {

                if (flag==false)

                {

                    mp3.pause();

                    flag=true;

                    state.setText("pause");

                }

                else if(flag==true){

                    mp3.start();

                    flag=false;

                    state.setText("Playing");

                }

            } catch (Exception e)

            {

                state.setText(e.toString());

                e.printStackTrace();

            }

        }

    }



    private class OnClickListenerStop implements OnClickListener{

        @Override

        public void onClick(View v)

        {

            try

            {

                if (mp3!=null)

                {

                    mp3.stop();

                    state.setText("stop");

                }

            } catch (Exception e)

            {

                state.setText(e.toString());

                e.printStackTrace();

            }

        }

    }



    protected void onPause(){

        try

        {

            mp3.release();

        } catch (Exception e)

        {

            state.setText(e.toString());

            e.printStackTrace();

        }

        super.onPause();

    }

}