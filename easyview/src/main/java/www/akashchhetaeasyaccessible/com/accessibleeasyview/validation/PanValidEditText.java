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
public class PanValidEditText extends EditText {

    public PanValidEditText(Context context) {
        super(context);
        createInit(context, null);
    }

    public PanValidEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        createInit(context, attrs);
    }

    public PanValidEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createInit(context, attrs);
    }

    private void createInit(Context context, AttributeSet attrs) {
        try {
            if (context != null) {
                this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(BasePattern.getPanLength()), mInputfilter});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputFilter mInputfilter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (source != null && BasePattern.getBlockChar().contains(("" + source))) {
                return "";
            }
            return null;
        }
    };

    private boolean validpanno() {
        Pattern pattern = Pattern.compile(BasePattern.getPanPattern());
        Matcher matcher = pattern.matcher(this.getText().toString().trim());
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPanno() {
        if (this.getText().toString().trim().equals("")) {
            return false;
        } else {
            if (this.getText().toString().trim().length() == 10) {
                if (validpanno() == true) {
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
