package bd.ac.pstu.cse.classnotification;

import android.widget.TextView;

import java.util.Calendar;

public class routine {
    public void classRoutine(int difference, TextView class1,TextView class2,TextView class3,TextView class4,TextView class5,TextView class6){
        Calendar forday = Calendar.getInstance();
        int isday = (Integer)forday.get(Calendar.DAY_OF_WEEK);

        switch (isday+difference) {
            case Calendar.FRIDAY:
                class1.setText("No Class");
                class2.setText("No Class");
                class3.setText("No Class");
                class4.setText("No Class");
                class5.setText("No Class");
                class6.setText("No Class");
                break;
            case Calendar.SATURDAY:
                class1.setText("No Class");
                class2.setText("No Class");
                class3.setText("No Class");
                class4.setText("No Class");
                class5.setText("No Class");
                class6.setText("No Class");
                break;
            case Calendar.SUNDAY:
                class1.setText("No Class");
                class2.setText("No Class");
                class3.setText("Network\nRouting");
                class4.setText("Compiler\nDesign");
                class5.setText("No Class");
                class6.setText("No Class");
                break;
            case Calendar.MONDAY:
                class1.setText("No Class");
                class2.setText("No Class");
                class3.setText("Network\nRouting");
                class4.setText("No Class");
                class5.setText("No Class");
                class6.setText("No Class");
                break;
            case Calendar.TUESDAY:
                class1.setText("No Class");
                class2.setText("VLSI\nDesign");
                class3.setText("Network\nRouting");
                class4.setText("Algorithm\nEngineering");
                class5.setText("Data\nWarehousing");
                class6.setText("No Class");
                break;
            case Calendar.WEDNESDAY:
                class1.setText("No Class");
                class2.setText("VLSI\nDesign");
                class3.setText("Compiler\nDesign");
                class4.setText("Algorithm\nEngineering");
                class5.setText("No Class");
                class6.setText("No Class");
                break;
            case Calendar.THURSDAY:
                class1.setText("No Class");
                class2.setText("VLSI\n Design");
                class3.setText("Data\nWarehousing");
                class4.setText("Algorithm\nEngineering");
                class5.setText("Compiler\n Design");
                class6.setText("No Class");
                break;
        }

        }
    }

