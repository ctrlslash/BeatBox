package org.maktab.beatbox.viewmodel;

import android.content.Context;

import org.maktab.beatbox.adapter.SoundAdapter;
import org.maktab.beatbox.services.model.Sound;
import org.maktab.beatbox.services.repository.BeatBoxRepository;

import java.util.List;

public class MainViewModel {

    private BeatBoxRepository mRepository;
    private Context mContext;

    public MainViewModel(Context context) {
        mContext = context;
        mRepository = BeatBoxRepository.getInstance(mContext);
    }

    public void releaseSoundPool() {
        mRepository.getSoundPool().release();
    }

    public SoundAdapter createAdapter() {
        List<Sound> sounds = mRepository.getSounds();
        return new SoundAdapter(mContext, sounds);
    }
}
