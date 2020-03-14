
package com.akexorcist.googledirection.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2015-12-05T20:03+0700")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class TimeInfo$$Parcelable
    implements Parcelable, ParcelWrapper<com.akexorcist.googledirection.model.TimeInfo>
{

    private com.akexorcist.googledirection.model.TimeInfo timeInfo$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static TimeInfo$$Parcelable.Creator$$13 CREATOR = new TimeInfo$$Parcelable.Creator$$13();

    public TimeInfo$$Parcelable(android.os.Parcel parcel$$0) {
        com.akexorcist.googledirection.model.TimeInfo timeInfo$$2;
        if (parcel$$0 .readInt() == -1) {
            timeInfo$$2 = null;
        } else {
            timeInfo$$2 = readcom_akexorcist_googledirection_model_TimeInfo(parcel$$0);
        }
        timeInfo$$0 = timeInfo$$2;
    }

    public TimeInfo$$Parcelable(com.akexorcist.googledirection.model.TimeInfo timeInfo$$4) {
        timeInfo$$0 = timeInfo$$4;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$1, int flags) {
        if (timeInfo$$0 == null) {
            parcel$$1 .writeInt(-1);
        } else {
            parcel$$1 .writeInt(1);
            writecom_akexorcist_googledirection_model_TimeInfo(timeInfo$$0, parcel$$1, flags);
        }
    }

    private com.akexorcist.googledirection.model.TimeInfo readcom_akexorcist_googledirection_model_TimeInfo(android.os.Parcel parcel$$2) {
        com.akexorcist.googledirection.model.TimeInfo timeInfo$$1;
        timeInfo$$1 = new com.akexorcist.googledirection.model.TimeInfo();
        timeInfo$$1 .timeZone = parcel$$2 .readString();
        timeInfo$$1 .text = parcel$$2 .readString();
        timeInfo$$1 .value = parcel$$2 .readString();
        return timeInfo$$1;
    }

    private void writecom_akexorcist_googledirection_model_TimeInfo(com.akexorcist.googledirection.model.TimeInfo timeInfo$$3, android.os.Parcel parcel$$3, int flags$$0) {
        parcel$$3 .writeString(timeInfo$$3 .timeZone);
        parcel$$3 .writeString(timeInfo$$3 .text);
        parcel$$3 .writeString(timeInfo$$3 .value);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.akexorcist.googledirection.model.TimeInfo getParcel() {
        return timeInfo$$0;
    }

    public final static class Creator$$13
        implements Creator<TimeInfo$$Parcelable>
    {


        @Override
        public TimeInfo$$Parcelable createFromParcel(android.os.Parcel parcel$$4) {
            return new TimeInfo$$Parcelable(parcel$$4);
        }

        @Override
        public TimeInfo$$Parcelable[] newArray(int size) {
            return new TimeInfo$$Parcelable[size] ;
        }

    }

}
