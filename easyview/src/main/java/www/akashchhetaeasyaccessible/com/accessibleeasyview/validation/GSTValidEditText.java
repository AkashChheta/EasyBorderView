package www.akashchhetaeasyaccessible.com.accessibleeasyview.validation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import www.akashchhetaeasyaccessible.com.accessibleeasyview.base.BasePattern;

@SuppressLint("AppCompatCustomView")
public class GSTValidEditText extends EditText {

    public GSTValidEditText(Context context) {
        this(context, null);
        createInit(context, null);
    }

    public GSTValidEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        createInit(context, attrs);
    }

    public GSTValidEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createInit(context, attrs);
    }

    private void createInit(Context context, AttributeSet attrs) {
        if (context != null) {
            this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(BasePattern.getGstLength()), mInputFilter});
        }
    }

    private InputFilter mInputFilter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (source != null && BasePattern.getBlockChar().contains(("" + source))) {
                return "";
            }
            return null;
        }
    };

    private boolean validGST(String s) {
        Pattern pattern = Pattern.compile(BasePattern.getGstPattern()); //"([0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1})"
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGstNo() {
        if (this.getText().toString().trim().equals("")) {
            return false;
        } else {
            if (this.getText().toString().trim().length() == 15) {
                if (validGST(this.getText().toString().trim()) == true) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
