package com.sst.sstopenhouse2017;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sst.sstopenhouse2017.boothCodes.CodeVerifier;

import java.util.Locale;

public class RedemptionActivity extends AppCompatActivity {

    private boolean redeemCode(String code) {
        CodeVerifier codeVerifier = new CodeVerifier(code, this);
        switch (codeVerifier.redeem()) {
            case CodeVerifier.CHALLENGE_FAILED_INVALID_CODE_LENGTH:
                createErrorDialog(getResources().getString(
                        R.string.redemption_dialog_error_invalid_code));
                break;
            case CodeVerifier.CHALLENGE_FAILED_NO_SUCH_CODE:
                createErrorDialog(getResources().getString(
                        R.string.redemption_dialog_error_no_such_code));
                break;
            case CodeVerifier.CHALLENGE_FAILED_CODE_REDEEMED:
                createErrorDialog(getResources().getString(
                        R.string.redemption_dialog_error_code_redeemed));
                break;
            case CodeVerifier.CHALLENGE_PASSED:
                return true;
        }
        return false;
    }

    private void createErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.redemption_dialog_error_header)
                .setMessage(message);

        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                createRedeemDialog();
            }
        });

        builder.create().show();
    }

    private String fetchRedeemedCodesText() {
        return String.format(Locale.ENGLISH, "%d", CodeVerifier.fetchRedeemedCodes(this));
    }

    private void createRedeemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.redemption_dialog_header)
               .setMessage(R.string.redemption_dialog_description);

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        input.setFilters(new InputFilter[] { new InputFilter.LengthFilter(4) });
        input.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        input.setAllCaps(true);

        builder.setView(input);

        builder.setPositiveButton("Redeem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (redeemCode(input.getText().toString())) {
                    redeemedCodes.setText(fetchRedeemedCodesText());
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(
                getResources().getColor(R.color.colorPrimaryFontDark));
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(
                getResources().getColor(R.color.colorPrimaryFontDark));
    }

    private TextView redeemedCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redemption);

        this.redeemedCodes = (TextView) findViewById(R.id.redemption_count);
        redeemedCodes.setText(fetchRedeemedCodesText());

        Button redeemButton = (Button) findViewById(R.id.redemption_button);
        redeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRedeemDialog();
            }
        });
    }
}
