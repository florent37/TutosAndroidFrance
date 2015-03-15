package com.tutosandroidfrance.RetrofitSample;

import retrofit.RetrofitError;

/**
 * Created by florentchampigny on 15/03/15.
 */
public class NotAllowedException extends Throwable {
    public NotAllowedException(RetrofitError cause) {
        super(cause);
    }
}
