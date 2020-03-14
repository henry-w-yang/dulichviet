
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
public class StopPoint$$Parcelable
    implements Parcelable, ParcelWrapper<com.akexorcist.googledirection.model.StopPoint>
{

    private com.akexorcist.googledirection.model.StopPoint stopPoint$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static StopPoint$$Parcelable.Creator$$12 CREATOR = new StopPoint$$Parcelable.Creator$$12();

    public StopPoint$$Parcelable(android.os.Parcel parcel$$0) {
        com.akexorcist.googledirection.model.StopPoint stopPoint$$2;
        if (parcel$$0 .readInt() == -1) {
            stopPoint$$2 = null;
        } else {
            stopPoint$$2 = readcom_akexorcist_googledirection_model_StopPoint(parcel$$0);
        }
        stopPoint$$0 = stopPoint$$2;
    }

    public StopPoint$$Parcelable(com.akexorcist.googledirection.model.StopPoint stopPoint$$4) {
        stopPoint$$0 = stopPoint$$4;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$1, int flags) {
        if (stopPoint$$0 == null) {
            parcel$$1 .writeInt(-1);
        } else {
            parcel$$1 .writeInt(1);
            writecom_akexorcist_googledirection_model_StopPoint(stopPoint$$0, parcel$$1, flags);
        }
    }

    private com.akexorcist.googledirection.model.StopPoint readcom_akexorcist_googledirection_model_StopPoint(android.os.Parcel parcel$$2) {
        com.akexorcist.googledirection.model.StopPoint stopPoint$$1;
        stopPoint$$1 = new com.akexorcist.googledirection.model.StopPoint();
        stopPoint$$1 .name = parcel$$2 .readString();
        com.akexorcist.googledirection.model.Coordination coordination$$1;
        if (parcel$$2 .readInt() == -1) {
            coordination$$1 = null;
        } else {
            coordination$$1 = readcom_akexorcist_googledirection_model_Coordination(parcel$$2);
        }
        stopPoint$$1 .location = coordination$$1;
        return stopPoint$$1;
    }

    private com.akexorcist.googledirection.model.Coordination readcom_akexorcist_googledirection_model_Coordination(android.os.Parcel parcel$$3) {
        com.akexorcist.googledirection.model.Coordination coordination$$0;
        coordination$$0 = new com.akexorcist.googledirection.model.Coordination();
        coordination$$0 .latitude = parcel$$3 .readDouble();
        coordination$$0 .longitude = parcel$$3 .readDouble();
        return coordination$$0;
    }

    private void writecom_akexorcist_googledirection_model_StopPoint(com.akexorcist.googledirection.model.StopPoint stopPoint$$3, android.os.Parcel parcel$$4, int flags$$0) {
        parcel$$4 .writeString(stopPoint$$3 .name);
        if (stopPoint$$3 .location == null) {
            parcel$$4 .writeInt(-1);
        } else {
            parcel$$4 .writeInt(1);
            writecom_akexorcist_googledirection_model_Coordination(stopPoint$$3 .location, parcel$$4, flags$$0);
        }
    }

    private void writecom_akexorcist_googledirection_model_Coordination(com.akexorcist.googledirection.model.Coordination coordination$$2, android.os.Parcel parcel$$5, int flags$$1) {
        parcel$$5 .writeDouble(coordination$$2 .latitude);
        parcel$$5 .writeDouble(coordination$$2 .longitude);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.akexorcist.googledirection.model.StopPoint getParcel() {
        return stopPoint$$0;
    }

    public final static class Creator$$12
        implements Creator<StopPoint$$Parcelable>
    {


        @Override
        public StopPoint$$Parcelable createFromParcel(android.os.Parcel parcel$$6) {
            return new StopPoint$$Parcelable(parcel$$6);
        }

        @Override
        public StopPoint$$Parcelable[] newArray(int size) {
            return new StopPoint$$Parcelable[size] ;
        }

    }

}
