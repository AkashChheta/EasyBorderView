package www.akashchhetaeasyaccessible.com.accessibleeasyview.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int setLayout();

    protected abstract void onLoad();

    protected abstract void onLoadCompleted();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (setLayout() != 0) {
                setContentView(setLayout());
                onLoad();
                onLoadCompleted();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void Toast(String message) {
        if (this != null)
            Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    protected View id(int id) {
        return id != 0 ? findViewById(id) : null;
    }

    protected EditText idEdittext(int id) {
        return id != 0 ? (EditText) findViewById(id) : null;
    }

    protected TextView idTextView(int id) {
        return id != 0 ? (TextView) findViewById(id) : null;
    }

    protected String eGetText(EditText editText) {
        return editText != null ? editText.getText().toString().trim() : "";
    }

    protected String tGetText(TextView textView) {
        return textView != null ? textView.getText().toString().trim() : "";
    }

    protected void Move(Context context, Class aClass) {
        if (context != null) {
            startActivity(new Intent(context, aClass));
        }
    }

    protected boolean emptyEditText(EditText edt) {
        return edt.getText().toString().trim().equals("") ? true : false;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void softKeybordHide() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    protected void softKeybordShow() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.SHOW_FORCED, 0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    protected int getWindowWidth() {
        return getWindowManager().getDefaultDisplay().getWidth();
    }

    protected int getWindowHeight() {
        return getWindowManager().getDefaultDisplay().getHeight();
    }

    protected void setFullScreen() {
        try {
            View decorView = getWindow().getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
