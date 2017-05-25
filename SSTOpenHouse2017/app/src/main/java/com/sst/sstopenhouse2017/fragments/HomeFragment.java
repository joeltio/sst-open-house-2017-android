package com.sst.sstopenhouse2017.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.sst.sstopenhouse2017.BuildConfig;
import com.sst.sstopenhouse2017.MainActivity;
import com.sst.sstopenhouse2017.R;

public class HomeFragment extends Fragment {
    private ReactRootView reactRootView;
    private ReactInstanceManager reactInstanceManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.reactRootView = (ReactRootView) getActivity().findViewById(R.id.react_root_view);
        this.reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getActivity().getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        this.reactRootView.startReactApplication(this.reactInstanceManager, "MainPage", null);
    }

    @Override
    public void onPause() {
        super.onPause();

        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onHostPause(getActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onHostResume(getActivity(), (MainActivity) getActivity());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onHostDestroy(getActivity());
        }
    }

    public void onBackPressed() {
        if (this.reactInstanceManager != null) {
            this.reactInstanceManager.onBackPressed();
        } else {
            ((MainActivity) getActivity()).onBackPressedReactNull();
        }
    }
}
