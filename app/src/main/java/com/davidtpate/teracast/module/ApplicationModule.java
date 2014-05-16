package com.davidtpate.teracast.module;

import com.davidtpate.teracast.BaseApplication;
import com.davidtpate.teracast.bus.MainThreadBus;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module(
    complete = false,
    library = true,
    injects = {
        BaseApplication.class
    }
)
public class ApplicationModule {
    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new MainThreadBus( new Bus());
    }
}
