package www.akashchhetaeasyaccessible.com.accessibleeasyview.validation;

import android.content.Context;
import android.util.AttributeSet;

public class NullOrEqualEditText extends android.support.v7.widget.AppCompatEditText {
    public NullOrEqualEditText(Context context) {
        super(context);
    }

    public NullOrEqualEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NullOrEqualEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isEmpty() {
        return this.getText().toString().trim().equals("") ? true : false;
    }

    public boolean isEqual(String text) {
        if (!text.trim().equals("")) {
            return text.equals(this.getText().toString().trim()) ? true : false;
        }
        return false;
    }
}
