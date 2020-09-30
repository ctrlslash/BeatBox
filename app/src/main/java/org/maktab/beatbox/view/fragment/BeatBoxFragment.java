package org.maktab.beatbox.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import org.maktab.beatbox.R;
import org.maktab.beatbox.databinding.FragmentBeatBoxBinding;
import org.maktab.beatbox.viewmodel.MainViewModel;

public class BeatBoxFragment extends Fragment {

    public static final int SPAN_COUNT = 3;
    public static final String TAG = "BBF";

    private FragmentBeatBoxBinding mBeatBoxBinding;
    private MainViewModel mMainViewModel;
//    private BeatBoxRepository mRepository;

    public BeatBoxFragment() {
        // Required empty public constructor
    }

    public static BeatBoxFragment newInstance() {
        BeatBoxFragment fragment = new BeatBoxFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCrete");

        setRetainInstance(true);
        mMainViewModel = new MainViewModel(getActivity());
//        mRepository = BeatBoxRepository.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mBeatBoxBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_beat_box,
                container,
                false);

        Log.d(TAG, "onCreteView");
        initViews();

        return mBeatBoxBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

        mMainViewModel.releaseSoundPool();
//        mRepository.getSoundPool().release();
    }

    private void initViews() {
        mBeatBoxBinding.recyclerViewBeatBox
                .setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
        initUI();
    }

    private void initUI() {
        /*List<Sound> sounds = mRepository.getSounds();
        SoundAdapter adapter = new SoundAdapter(sounds);*/
        mBeatBoxBinding.recyclerViewBeatBox.setAdapter(mMainViewModel.createAdapter());
    }
}