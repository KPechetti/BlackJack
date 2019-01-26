package com.example.anil6066.blackjack;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class ButtonGridAndTextView extends GridLayout {
    private int side;
    private TextView [][] labels;
    private Button button;
    int green = 0x32CD32;

    public ButtonGridAndTextView(Context context, int width, int newSide,
                                 OnClickListener listener ) {
        super( context );
        side = newSide;
        // Set # of rows and columns of this GridLayout
        setColumnCount( side );
        setRowCount( side + 1 );

        // Create the buttons and add them to this GridLayout
        labels = new TextView[1][side];
            for( int col = 0; col < side; col++ ) {
                labels[0][col] = new TextView( context );
                labels[0][col].setTextSize( ( int ) ( width * .2 ) );
                if(col <2)
                    labels[0][col].setBackgroundColor(Color.parseColor("#32CD32"));
                labels[0][col].setText("");
                addView( labels[0][col], width, width );
        }

        // set up layout parameters of 4th row of gridLayout
        button = new Button( context );
        button.setOnClickListener( listener );
        Spec rowSpec = GridLayout.spec( side, 1 );
        Spec columnSpec = GridLayout.spec( 0, side );
        LayoutParams lpStatus
                = new LayoutParams( rowSpec, columnSpec );
        button.setLayoutParams( lpStatus );

        // set up status' characteristics
        button.setWidth( side * width );
        button.setHeight( width );
        button.setGravity( Gravity.CENTER );
        button.setBackgroundColor( Color.CYAN );
        button.setTextSize( ( int ) ( width * .15 ) );
        button.setText("Play!!");
        addView( button );
    }

    public void setButtonText( String text ) {
        button.setText( text );
    }
    public int getLabelText( int row, int col ) {
        return Integer.parseInt(""+ labels[row][col]);
    }

    public void setStatusBackgroundColor( int color ) {
        button.setBackgroundColor( color );
    }
    public void setLabelBackgroundColor(int row, int column, int color ) {
        labels[row][column].setBackgroundColor( color );
    }


    public void setLabelText( int row, int column, String text ) {
        labels[row][column].setText( text );
    }

    public boolean isButton( Button b ) {
        return ( b == button );
    }

    public void resetLabels( ) {
        for( int row = 0; row < side; row++ )
            for( int col = 0; col < side; col++ )
                labels[row][col].setText( "" );
    }

    public void enableButtons( boolean enabled ) {
        for( int row = 0; row < side; row++ )
            for( int col = 0; col < side; col++ )
                labels[row][col].setEnabled( enabled );
    }
}
