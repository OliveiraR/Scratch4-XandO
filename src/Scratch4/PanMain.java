package Scratch4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanMain extends JPanel {

    BtnSquare arBtnSquares[] = new BtnSquare[9];
    String sIndex;

    public PanMain() {
        //setusable(true);
        this.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < arBtnSquares.length; i++) {
            arBtnSquares[i] = new BtnSquare(i);
            arBtnSquares[i].setText(" ");
            add(arBtnSquares[i]);
            Click click = new Click();

            arBtnSquares[i].addActionListener(click);
            sIndex = String.valueOf(i);

        }
    }

    public class Click implements ActionListener {

        int nCheck;
        public int nStatus = 1;  //used to see whose turn it is
        //nStatus updates 1 button only
        //Starts at -1 since it *-1 each time to get next peice, this will make x go first

        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < arBtnSquares.length; i++) {
                nCheck = 0;
                if(arBtnSquares[i].isEnabled()){
                    nStatus*=-1;
                }
                if (e.getSource() == arBtnSquares[i]) { //arBtnSquares[i] was clicked
                    nCheck = i;                         // Helped from http://stackoverflow.com/questions/13548299/how-do-i-tell-which-button-is-being-clicked-in-an-array-of-buttons
                    //nStatus *= -1;
                    if (nStatus == 1) { //if nStatus=1, X is shown on button
                        arBtnSquares[i].setText("X");
                    }
                    else if (nStatus == -1) { //if nStatus=-1, O is shown on button
                        arBtnSquares[i].setText("O");
                    }
                }
            }
        }
    }
}
