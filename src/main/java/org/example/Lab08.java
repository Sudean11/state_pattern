package org.example;

import org.example.states.*;

import javax.swing.*;

public class Lab08 extends javax.swing.JFrame
{
    /**
     * State Pattern Lab
     */
    private static final long serialVersionUID = -5614553291522761426L;
    State parkedState;
    State gear1;
    State gear2;
    State gear3;
    State gear4;
    State gear5;
    State state;

    public State getParkedState() {
        return parkedState;
    }

    public State getGear1() {
        return gear1;
    }

    public State getGear2() {
        return gear2;
    }

    public State getGear3() {
        return gear3;
    }

    public State getGear4() {
        return gear4;
    }

    public State getGear5() {
        return gear5;
    }

    public State getGearState() {
        return state;
    }

    public void setState(State state){
        this.state = state;
    }
    public Lab08()
    {
        parkedState = new ParkedState(this);
        gear1 = new Gear1(this);
        gear2 = new Gear2(this);
        gear3 = new Gear3(this);
        gear4 = new Gear4(this);
        gear5 = new Gear5(this);

        state = parkedState;

        // {{INIT_CONTROLS
        setTitle("State pattern lab.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(485,250);
        setVisible(false);
        getContentPane().add(JTextFieldShift);
        JTextFieldShift.setBounds(168,24,216,24);
        getContentPane().add(JTextFieldSpeed);
        JTextFieldSpeed.setBounds(168,60,216,24);
        Shift.setText("Shift");
        getContentPane().add(Shift);
        Shift.setBounds(120,24,36,27);
        JLabel1.setText("Speed");
        getContentPane().add(JLabel1);
        JLabel1.setBounds(120,60,48,27);
        JSlider1.setMinorTickSpacing(1);
        JSlider1.setValue(0);
        JSlider1.setMaximum(70);
        JSlider1.setPaintLabels(true);
        JSlider1.setPaintTicks(true);
        JSlider1.setMajorTickSpacing(10);
        getContentPane().add(JSlider1);
        JSlider1.setBounds(84,132,299,48);
        // }}

        // {{INIT_MENUS
        // }}

        // {{REGISTER_LISTENERS
        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        SymChange lSymChange = new SymChange();
        JSlider1.addChangeListener(lSymChange);
        // }}

    }

    static public void main(String args[])
    {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new Lab08()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }


    //{{DECLARE_CONTROLS
    javax.swing.JTextField JTextFieldShift = new javax.swing.JTextField();
    javax.swing.JTextField JTextFieldSpeed = new javax.swing.JTextField();
    javax.swing.JLabel Shift = new javax.swing.JLabel();
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JSlider JSlider1 = new javax.swing.JSlider();
    //}}

    //{{DECLARE_MENUS
    //}}

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == Lab08.this)
                JFrame1_windowClosing(event);
        }
    }

    void JFrame1_windowClosing(java.awt.event.WindowEvent event)
    {
        // to do: code goes here.

        JFrame1_windowClosing_Interaction1(event);
    }

    void JFrame1_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();

        }
    }

    class SymChange implements javax.swing.event.ChangeListener
    {
        public void stateChanged(javax.swing.event.ChangeEvent event)
        {
            Object object = event.getSource();
            if (object == JSlider1)
                JSlider1_stateChanged(event);
        }
    }

    void JSlider1_stateChanged(javax.swing.event.ChangeEvent event)
    {
        JSlider source = (JSlider)event.getSource();
        if (!source.getValueIsAdjusting()) {
            int mph = (int)source.getValue();
            JTextFieldSpeed.setText(String.valueOf(mph));
            state.changeSpeed(mph);
            JTextFieldShift.setText(String.valueOf(state.getShift()));
        }
    }
}