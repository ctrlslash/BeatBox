package org.maktab.beatbox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.maktab.beatbox.R;
import org.maktab.beatbox.databinding.ListItemSoundBinding;
import org.maktab.beatbox.services.model.Sound;
import org.maktab.beatbox.viewmodel.SoundViewModel;

import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundHolder> {

    private List<Sound> mSounds;
    private Context mContext;

    public List<Sound> getSounds() {
        return mSounds;
    }

    public void setSounds(List<Sound> sounds) {
        mSounds = sounds;
    }

    public SoundAdapter(Context context, List<Sound> sounds) {
        mContext = context;
        mSounds = sounds;
    }

    @NonNull
    @Override
    public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ListItemSoundBinding soundBinding =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.list_item_sound,
                        parent,
                        false);

        return new SoundHolder(soundBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundHolder holder, int position) {
        Sound sound = mSounds.get(position);
        holder.bindSound(sound);
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }

    class SoundHolder extends RecyclerView.ViewHolder {

        private ListItemSoundBinding mSoundBinding;

        public SoundHolder(ListItemSoundBinding soundBinding) {
            super(soundBinding.getRoot());
            this.mSoundBinding = soundBinding;

            SoundViewModel soundViewModel = new SoundViewModel(mContext);
            mSoundBinding.setSoundViewModel(soundViewModel);
        }

        public void bindSound(Sound sound) {
            mSoundBinding.getSoundViewModel().setSound(sound);

            // bind the variable to the layout right now.
            mSoundBinding.executePendingBindings();

            /*mSoundBinding.setSound(sound);
            mSoundBinding.setSoundHolder(this);*/
        }
    }
}
