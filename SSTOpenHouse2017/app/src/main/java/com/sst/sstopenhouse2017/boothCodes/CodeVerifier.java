package com.sst.sstopenhouse2017.boothCodes;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sst.sstopenhouse2017.R;

public class CodeVerifier {
    public static final int CHALLENGE_PASSED = 0;
    public static final int CHALLENGE_FAILED_NO_SUCH_CODE = 1;
    public static final int CHALLENGE_FAILED_CODE_REDEEMED = 2;
    public static final int CHALLENGE_FAILED_INVALID_CODE_LENGTH = 3;

    private static final String BOOTH_PREFERENCE_PREFIX = "com.sst.sstopenhouse2017.boothCodes.Booth.";

    private String code;
    private Context context;
    private SharedPreferences preferences;

    public CodeVerifier(String code, Context context) {
        this.code = code;
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static int fetchRedeemedCodes(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int count = 0;
        for (String code : Booth.getAllCodes()) {
            if (preferences.getBoolean(BOOTH_PREFERENCE_PREFIX + code, false)) {
                count++;
            }
        }

        return count;
    }

    public int redeem() {
        int verified = verify();

        if (verify() == 0) {
            this.preferences.edit().putBoolean(BOOTH_PREFERENCE_PREFIX + code, true).apply();

            FirebaseDatabaseAdapter firebaseDatabaseAdapter = new FirebaseDatabaseAdapter();
            firebaseDatabaseAdapter.open(context.getResources().getString(R.string.firebase_database_url));
            firebaseDatabaseAdapter.increment(code);
        }

        return verified;
    }

    public int verify() {
        // Test the length of the code
        if (this.code.length() != 4) {
            return CHALLENGE_FAILED_INVALID_CODE_LENGTH;
        }

        // Test if the code exists
        if (!Booth.getAllCodes().contains(code)) {
            return CHALLENGE_FAILED_NO_SUCH_CODE;
        }

        // Test if the code has been redeemed
        boolean redeemed = this.preferences.getBoolean(BOOTH_PREFERENCE_PREFIX + this.code, false);
        if (redeemed) {
            return CHALLENGE_FAILED_CODE_REDEEMED;
        }

        return CHALLENGE_PASSED;
    }
}
