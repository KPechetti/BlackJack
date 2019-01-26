package com.example.anil6066.blackjack;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private BlackJack game;
    private ButtonGridAndTextView tttView;
    int green = 0x32CD32;
    int white = 0xffffff;
    int grey = 0xA9A9A9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        game = new BlackJack( );
        Point size = new Point( );
        getWindowManager().getDefaultDisplay( ).getSize( size );
        int w = size.x / BlackJack.SIDE;
        ButtonHandler bh = new ButtonHandler( );
        tttView = new ButtonGridAndTextView( this, w, BlackJack.SIDE, bh );
        //tttView.setStatusText( game.result( ) );
        setContentView( tttView );
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick( View v ) {
            int A ,B,C;
        if(BlackJack.count ==0) {
            A = game.getRandValue(); B =game.getRandValue();
            tttView.setLabelText(0, 0, "" + A);
            tttView.setLabelText(0, 1, "" + B);
            tttView.setLabelBackgroundColor(0,0,Color.parseColor("#ffffff"));
            tttView.setLabelBackgroundColor(0,1,Color.parseColor("#ffffff"));
            tttView.setLabelBackgroundColor(0,2,Color.parseColor("#32CD32"));
            BlackJack.value = (A+B);
            tttView.setLabelText(0, 3, "" + BlackJack.value);

            if(BlackJack.value>=15) {
                tttView.setButtonText("Game Over");
                tttView.setLabelBackgroundColor(0,1,Color.parseColor("#ffffff"));
                tttView.setStatusBackgroundColor(Color.parseColor("#ff0000"));
                tttView.setLabelBackgroundColor(0,2,Color.parseColor("#ffffff"));
                tttView.setLabelBackgroundColor(0,3,Color.parseColor("#A9A9A9"));
                BlackJack.count =2;
            }
            else {
                tttView.setStatusBackgroundColor(Color.parseColor("#FF1493"));
                tttView.setButtonText("Add One More");
                BlackJack.count++;
            }
        }
        else if(BlackJack.count ==1) {
            C = game.getRandValue();
            tttView.setLabelText(0, 2, "" + C);
            BlackJack.value += C;
            tttView.setLabelText(0, 3, "" +  BlackJack.value);
            tttView.setButtonText("Game Over");
            tttView.setLabelBackgroundColor(0,2,Color.parseColor("#ffffff"));
            tttView.setLabelBackgroundColor(0,3,Color.parseColor("#A9A9A9"));
            tttView.setStatusBackgroundColor(Color.parseColor("#ff0000"));
            BlackJack.count++;
        }
        }
    }
}
