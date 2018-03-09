package com.gzmantis.tyassistant.utils;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LONG on 2018/3/7.
 */

public class TextUtils {
    public static final boolean canConversionToNumber(String paramString) {
        boolean flag = false;
        int i = 0;
        if (!isNull(paramString)) {
            if (Pattern.compile("[^\\d+]").matcher(paramString).find()) {
                flag = true;
            }
        }

        return flag;
    }

    public static final String converToIntType(String paramString) {
        String str = "0";
        if (!isNull(paramString)) {
            StringBuilder localStringBuilder = new StringBuilder();
            for (int i = 0; i < paramString.length(); i++) {
                char c = paramString.charAt(i);
                if (c > '9' || c < '0') {
                    if (c == '.') {
                        localStringBuilder.append('.');
                    }
                } else {
                    localStringBuilder.append(c);
                }
            }
            str = localStringBuilder.toString();
        }

        return str;
    }

    @SuppressLint({"NewApi"})
    public static void copy(String paramString, Context paramContext) {
        ((ClipboardManager) paramContext.getSystemService(Context.CLIPBOARD_SERVICE)).setText(paramString.trim());
    }

    public static String getDateFormat(int paramInt) {
        return new DecimalFormat("00").format(paramInt);
    }

    public static SpannableString getTextSize(String paramString1, String paramString2, int paramInt) {
        paramString1.indexOf(paramString2);
        SpannableString localSpannableString = new SpannableString(paramString1);
        localSpannableString.setSpan(new AbsoluteSizeSpan(18), -1 + paramString1.length(), paramString1.length(), 33);
        return localSpannableString;
    }

    public static final boolean isE(String paramString) {
        boolean flag = false;
        if (!isNull(paramString)) {
            flag = paramString.matches("[a-zA-Z0-9_]{3,16}");
        }

        return flag;
    }

    public static final boolean isNull(String paramString) {
        return ((paramString == null)
                || (paramString.length() == 0)
                || (paramString.equals("null"))
                || (paramString.trim().length() == 0));
    }

    public static final boolean isTelephoneNumber(String paramString) {
        boolean flag = false;
        if ((paramString != null) && (paramString.length() > 0)) {
            flag = paramString.matches("\\d{11}");
        }

        return flag;
    }

    public static final boolean isvalidNumber(double paramDouble) {
        boolean flag = true;
        if ((!Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
            flag = false;
        }

        return flag;
    }

    @SuppressLint({"NewApi"})
    public static String paste(Context paramContext) {
        return ((ClipboardManager) paramContext.getSystemService(Context.CLIPBOARD_SERVICE)).getText().toString().trim();
    }

    public static final String shield(String paramString) {
        return new Shield(paramString).dispose();
    }

    public static double strToDouble(String paramString) {
        double d1 = 0.0D;
        if ((paramString != null) && (!paramString.isEmpty())) {
            try {
                d1 = Double.parseDouble(paramString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return d1;
    }

    public static float strToFloat(String paramString) {
        float f1 = -1.0F;
        if ((paramString != null) && (!paramString.isEmpty())) {
            try {
                f1 = Float.parseFloat(paramString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return f1;
    }

    public static int strToInt(String paramString) {
        int i = -1;
        if ((paramString != null) && (!paramString.isEmpty())) {
            try {
                i = Integer.parseInt(paramString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return i;
    }

    private static class Shield {
        private String str;

        public Shield(String paramString) {
            if (paramString == null) {
                paramString = "";
            }

            this.str = paramString;
        }

        public String dispose() {
            return "";
        }
//        public String dispose() {
//            switch (this.str.length()) {
//                default:
//                case 0:
//                case 1:
//                case 2:
//                case 11:
//            }
//
//            for (String str1 = this.str.substring(0, 1) + "*" + this.str.substring(-1 + this.str.length(), this.str.length()); ; str1 = this.str.substring(0, 3) + "*****" + this.str.substring(-3 + this.str.length(), this.str.length()))
//                while (true) {
//                    return str1;
//                    str1 = "***";
//                    continue;
//                    str1 = this.str + "**";
//                    continue;
//                    str1 = this.str.substring(0, 1) + "*" + this.str.substring(1, 2);
//                }
//        }
    }
}