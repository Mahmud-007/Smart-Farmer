package com.example.smartfarmer20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView profile_name,profile_email;
    ImageView profile_image;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FloatingActionButton fab;
    Dialog popAddPost;
    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        profile_email=findViewById(R.id.user_email_id);
        profile_name=findViewById(R.id.user_name_id);
        profile_image=findViewById(R.id.profile_image_ID);
        fab=findViewById(R.id.fabId);


        // Hook up the VideoView to our UI.
        videoBG = (VideoView) findViewById(R.id.video);

        // Build your video Uri
        Uri uri = Uri.parse("android.resource://" // First start with this,
                + getPackageName() // then retrieve your package name,
                + "/" // add a slash,
                + R.raw.options_back); // and then finally add your video resource. Make sure it is stored
        // in the raw folder.

        // Set the new Uri to our VideoView
        videoBG.setVideoURI(uri);
        // Start the VideoView
        videoBG.start();

        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });




        showProfile();



    }



    private void showProfile() {
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        profile_name.setText(firebaseUser.getDisplayName());
        profile_email.setText(firebaseUser.getEmail());

        Glide.with(this).load(firebaseUser.getPhotoUrl()).into(profile_image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.profile_navigation,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.profile){
            Intent intent =new Intent(this,ProfileActivity.class);
            startActivity(intent);

        }
        if (item.getItemId()==R.id.community){
            Intent intent= new Intent(this,CommunityActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.store){
            Intent intent= new Intent(this,MenuActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.learn){
            Intent intent= new Intent(this,LearnActivity.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.about){
            Intent intent= new Intent(this,AboutUsActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.fabId){
            
        }

    }
}
