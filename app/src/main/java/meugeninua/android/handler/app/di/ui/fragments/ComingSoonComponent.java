package meugeninua.android.handler.app.di.ui.fragments;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.ui.fragments.comingsoon.ComingSoonFragment;

@Module
public interface ComingSoonComponent {

    @ContributesAndroidInjector
    ComingSoonFragment bindFragment();
}
