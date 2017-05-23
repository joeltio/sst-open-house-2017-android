package com.sst.sstopenhouse2017.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sst.sstopenhouse2017.R;
import com.sst.sstopenhouse2017.boothCodes.CodeVerifier;

import java.util.Locale;

public class RedemptionFragment extends Fragment {
    private boolean redeemCode(String code) {
        CodeVerifier codeVerifier = new CodeVerifier(code, getActivity());
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
        return String.format(Locale.ENGLISH, "%d", CodeVerifier.fetchRedeemedCodes(getActivity()));
    }

    private void createRedeemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.redemption_dialog_header)
                .setMessage(R.string.redemption_dialog_description);

        final EditText input = new EditText(getActivity());
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_redemption, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.redeemedCodes = (TextView) getActivity().findViewById(R.id.redemption_count);
        redeemedCodes.setText(fetchRedeemedCodesText());

        Button redeemButton = (Button) getActivity().findViewById(R.id.redemption_button);
        redeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createRedeemDialog();
            }
        });
    }
}
