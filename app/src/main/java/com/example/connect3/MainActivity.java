package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int game_state[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int winning_positions[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4 ,8}, {2, 4, 6}};
    int active_player = 1;
    boolean game_ative = true;

    public void drop_in(View view){
        ImageView counter = (ImageView) view;
        int tapped_counter = Integer.parseInt(counter.getTag().toString());
        if(game_state[tapped_counter] == 0 && game_ative){
            game_state[tapped_counter] = active_player;
            Toast.makeText(this, Arrays.toString(game_state), Toast.LENGTH_SHORT).show();
            counter.setTranslationY(-1500);
            if(active_player == 2){
                counter.setImageResource(R.drawable.yellow);
                active_player = 1;
            }else{
                counter.setImageResource(R.drawable.red);
                active_player = 2;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for(int winning_position[]: winning_positions){
                if(game_state[winning_position[0]] == game_state[winning_position[1]] && game_state[winning_position[1]] == game_state[winning_position[2]] && game_state[winning_position[0]] != 0){
                    game_ative = false;
                    String winner = "Yellow";
                    if(active_player == 2){
                        winner = "Red";
                    }
//                    Toast.makeText(this, winner + " has won!!!", Toast.LENGTH_SHORT).show();

                    Button playAgainButton = (Button) findViewById(R.id.playAgain);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerText);

                    winnerTextView.setText(winner + " has won!!!");
                    playAgainButton.setVisibility(view.VISIBLE);
                    winnerTextView.setVisibility(view.VISIBLE);
                }
            }
        }
    }

    public void play_again(View view){
        Button playAgainButton = (Button) findViewById(R.id.playAgain);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerText);

        ImageView child = (ImageView) findViewById(R.id.imageView1);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView2);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView3);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView4);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView5);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView6);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView7);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView8);
        child.setImageDrawable(null);
        child = (ImageView) findViewById(R.id.imageView9);
        child.setImageDrawable(null);

        for(int i = 0; i < game_state.length; i++){
            game_state[i] = 0;
        }

        active_player = 1;
        game_ative = true;

        playAgainButton.setVisibility(view.INVISIBLE);
        winnerTextView.setVisibility(view.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
