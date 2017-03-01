package dsardy.in.ticktacktoe;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * Created by Shubham on 2/10/2017.
 */

public class imgButton extends ImageButton {

    public int value = 10;


    public imgButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public imgButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public imgButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void setValue(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
