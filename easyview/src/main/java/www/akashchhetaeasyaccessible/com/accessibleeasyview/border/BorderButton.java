package www.akashchhetaeasyaccessible.com.accessibleeasyview.border;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;

import www.akashchhetaeasyaccessible.com.accessibleeasyview.R;

public class BorderButton extends android.support.v7.widget.AppCompatButton {
    private float mBorderRadius;
    private int mBorderWidth, mBorderColor, mBackgroundColor;
    private boolean misUnderLline;
    private GradientDrawable mGd;
    private String mfontType;

    public BorderButton(Context context) {
        this(context, null);
    }

    public BorderButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        createIntit(context, attrs);
    }

    public BorderButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createIntit(context, attrs);
    }

    private void createIntit(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BorderButton, 0, 0);
            mBorderRadius = a.getFloat(R.styleable.BorderTextView_borderRadius, 0);
            mBorderWidth = (int) a.getFloat(R.styleable.BorderTextView_borderWidth, 0);
            mBorderColor = a.getColor(R.styleable.BorderTextView_borderColor, Color.TRANSPARENT);
            misUnderLline = a.getBoolean(R.styleable.BorderTextView_underLine, false);
            mBackgroundColor = a.getColor(R.styleable.BorderTextView_backgroundColor, Color.TRANSPARENT);
            mfontType = a.getString(R.styleable.BorderButton_fonttypeButton);
            mGd = new GradientDrawable();
            if (mGd != null) {
                mGd.setShape(GradientDrawable.RECTANGLE);
                mGd.setColor(mBackgroundColor);
                mGd.setStroke(mBorderWidth, mBorderColor);
                mGd.setCornerRadius(mBorderRadius);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    this.setBackground(mGd);
                }
            }
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), mfontType);
            this.setTypeface(typeface);
            if (misUnderLline == true) {
                this.setPaintFlags(this.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            }
            a.recycle();
        }
    }

    public void setBorderRadius(float borderradius) {
        this.mBorderRadius = borderradius;
        if (mGd != null) {
            mGd.setCornerRadius(borderradius);
        }
        invalidate();
    }

    public void setBorderWidth(int borderwidth) {
        this.mBorderWidth = borderwidth;
        if (mGd != null) {
            mGd.setStroke(borderwidth, getBorderColor());
        }
        invalidate();
    }

    public void setBorderColor(int bordercolor) {
        this.mBorderColor = bordercolor;
        if (mGd != null) {
            mGd.setStroke(getBorderWidth(), bordercolor);
        }
        invalidate();
    }

    public void setBackgroundColor(int backgroundcolor) {
        this.mBackgroundColor = backgroundcolor;
        if (mGd != null) {
            mGd.setColor(backgroundcolor);
        }
        invalidate();
    }

    public void setUnderLine(boolean underline) {
        this.misUnderLline = underline;
        try {
            if (underline == true) {
                this.setPaintFlags(this.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        invalidate();
    }

    public void setFontType(Context context, String fonttype) {
        this.mfontType = fonttype;
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fonttype);
        this.setTypeface(typeface);
    }

    public int getBorderRadius() {
        return (int) mBorderRadius;
    }

    public int getBorderWidth() {
        return (int) mBorderWidth;
    }

    public boolean getUnderLine() {
        return misUnderLline;
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public String getFontType() {
        return mfontType;
    }
}
