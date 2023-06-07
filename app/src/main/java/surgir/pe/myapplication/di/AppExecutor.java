package surgir.pe.myapplication.di;

import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppExecutor {
    private ExecutorService networkIO;
    private ExecutorService multipleQuery;
    private Executor mainThread;
    private ExecutorService diskIO;

    public AppExecutor(ExecutorService networkIO, ExecutorService diskIO, Executor mainThread, ExecutorService multipleQuery) {
        this.networkIO = networkIO;
        this.mainThread = mainThread;
        this.diskIO = diskIO;
        this.multipleQuery = multipleQuery;
    }

    @Inject
    public AppExecutor() {
        this(Executors.newFixedThreadPool(5), Executors.newSingleThreadExecutor(), new MainThreadExecutor(), Executors.newFixedThreadPool(5));
    }

    public ExecutorService getNetworkIO() {
        if (networkIO.isShutdown()) {
            this.networkIO = Executors.newFixedThreadPool(4);
        }
        return networkIO;

    }

    public ExecutorService getDiskIO() {
        if (diskIO.isShutdown()) {
            this.diskIO = Executors.newSingleThreadExecutor();
        }
        return diskIO;
    }

    private static class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(Objects.requireNonNull(Looper.myLooper()));

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
