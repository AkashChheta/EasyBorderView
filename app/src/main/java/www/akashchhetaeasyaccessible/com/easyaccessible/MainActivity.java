package www.akashchhetaeasyaccessible.com.easyaccessible;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import www.akashchhetaeasyaccessible.com.accessibleeasyview.border.BorderButton;
import www.akashchhetaeasyaccessible.com.accessibleeasyview.border.BorderEditText;
import www.akashchhetaeasyaccessible.com.accessibleeasyview.border.BorderTextView;

public class MainActivity extends AppCompatActivity {
    private BorderTextView mBorderTextView;
    private BorderButton mBorderButton;
    private BorderEditText mBorderEditText; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBorderButton = (BorderButton) i(R.id.borderbutton);
        mBorderTextView = (BorderTextView) i(R.id.bordertextview);

        //BorderTextView
        mBorderTextView.setBorderColor(getResources().getColor(android.R.color.black));
        mBorderTextView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mBorderTextView.setUnderLine(true);
        mBorderTextView.setBorderRadius(10);
        mBorderTextView.setBorderWidth(2);

        //BorderButton
        mBorderButton.setBorderColor(getResources().getColor(android.R.color.black));
        mBorderButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mBorderButton.setUnderLine(true);
        mBorderButton.setBorderRadius(10);
        mBorderButton.setBorderWidth(2);

        //BorderEditText
        mBorderEditText.setBorderColor(getResources().getColor(android.R.color.black));
        mBorderEditText.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mBorderEditText.setUnderLine(true);
        mBorderEditText.setBorderRadius(10);
        mBorderEditText.setBorderWidth(2);
    }

    private View i(int id) {
        return findViewById(id);
    }
}
