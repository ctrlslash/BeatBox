package org.maktab.beatbox.viewmodel;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.maktab.beatbox.services.model.Sound;
import org.maktab.beatbox.services.repository.BeatBoxRepository;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SoundViewModelTest {

    private BeatBoxRepository mRepository;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mRepository = Mockito.mock(BeatBoxRepository.class);
        mSubject = new SoundViewModel(mRepository);

        mSound = new Sound("assetPath/fileName.ext");
        mSubject.setSound(mSound);
    }

    @Test
    public void exposeSoundNameAsTitle() {
        String title = mSubject.getTitle();
        MatcherAssert.assertThat(title, Matchers.is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked() throws Exception {
        mSubject.onPlayButtonClicked();
        Mockito.verify(mRepository).play(mSound);
    }
}