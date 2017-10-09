package ke.co.emichira.muziki.utils;

import android.content.ContentUris;
import android.net.Uri;

/**
 * Created by michira on 10/8/17.
 */

public class MuzikiUtils {

    public static Uri getAlbumArtUri(long paramInt)
    {
        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), paramInt);
    }
}
