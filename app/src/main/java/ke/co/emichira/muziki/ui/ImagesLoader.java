package ke.co.emichira.muziki.ui;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by michira on 10/6/17.
 */

public class ImagesLoader extends Application {

    private static ImagesLoader mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(localImageLoaderConfiguration);


    }

    public static synchronized ImagesLoader getInstance() {
        return mInstance;
    }

}
