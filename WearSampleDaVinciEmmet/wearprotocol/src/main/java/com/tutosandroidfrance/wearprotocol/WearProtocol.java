package com.tutosandroidfrance.wearprotocol;

import java.util.List;

/**
 * Created by florentchampigny on 02/05/15.
 */
public interface WearProtocol {
    void onAndroidVersionsReceived(List<AndroidVersion> androidVersions);
}
