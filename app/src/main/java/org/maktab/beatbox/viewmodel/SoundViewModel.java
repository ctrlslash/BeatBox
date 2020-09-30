package org.maktab.beatbox.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import org.maktab.beatbox.services.model.Sound;
import org.maktab.beatbox.services.repository.BeatBoxRepository;
import org.maktab.beatbox.utils.SoundUtils;

public class SoundViewModel extends BaseObservable {

    private BeatBoxRepository mRepository;
    private Sound mSound;

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;

        notifyChange();
    }

    public SoundViewModel(Context context) {
        mRepository = BeatBoxRepository.getInstance(context);
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public void playSound() {
        try {
            SoundUtils.play(mRepository.getSoundPool(), mSound);
        } catch (Exception e) {
            Log.e(BeatBoxRepository.TAG, e.getMessage(), e);
        }
    }
}
