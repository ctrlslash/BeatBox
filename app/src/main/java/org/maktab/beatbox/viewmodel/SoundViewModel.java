package org.maktab.beatbox.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import org.maktab.beatbox.services.model.Sound;
import org.maktab.beatbox.services.repository.BeatBoxRepository;

public class SoundViewModel extends BaseObservable {

    //dependency
    private BeatBoxRepository mRepository;
    private Sound mSound;

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;

        notifyChange();
    }

    public SoundViewModel(BeatBoxRepository repository) {
        mRepository = repository;
    }

    public SoundViewModel(Context context) {
        mRepository = BeatBoxRepository.getInstance(context);
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public void onPlayButtonClicked() {
        try {
            mRepository.play(mSound);
        } catch (Exception e) {
            Log.e(BeatBoxRepository.TAG, e.getMessage(), e);
        }
    }
}
