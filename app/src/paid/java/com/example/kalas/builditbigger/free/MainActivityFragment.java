package com.example.kalas.builditbigger.free;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment {
    @BindView(R.id.btn_tell_joke)
    Button mShowJoke;
    private Unbinder mUnbinder;

    public MainActivityFragment() {
        // public Empty Constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        AdView mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mShowJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeAsyncTask(new JokeAsyncTask.OnTaskCompleted() {
                    @Override
                    public void onTaskCompleted(String joke) {
                        Intent intent = new Intent(MainActivityFragment.this.getContext(), JokeActivity.class);
                        intent.putExtra(JOKE_KEY, joke);
                        startActivity(intent);
                    }

                }).execute(MainActivityFragment.this);

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
