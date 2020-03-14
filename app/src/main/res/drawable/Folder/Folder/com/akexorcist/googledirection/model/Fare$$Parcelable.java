
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
public class Fare$$Parcelable
    implements Parcelable, ParcelWrapper<com.akexorcist.googledirection.model.Fare>
{

    private com.akexorcist.googledirection.model.Fare fare$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Fare$$Parcelable.Creator$$4 CREATOR = new Fare$$Parcelable.Creator$$4();

    public Fare$$Parcelable(android.os.Parcel parcel$$0) {
        com.akexorcist.googledirection.model.Fare fare$$2;
        if (parcel$$0 .readInt() == -1) {
            fare$$2 = null;
        } else {
            fare$$2 = readcom_akexorcist_googledirection_model_Fare(parcel$$0);
        }
        fare$$0 = fare$$2;
    }

    public Fare$$Parcelable(com.akexorcist.googledirection.model.Fare fare$$4) {
        fare$$0 = fare$$4;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$1, int flags) {
        if (fare$$0 == null) {
            parcel$$1 .writeInt(-1);
        } else {
            parcel$$1 .writeInt(1);
            writecom_akexorcist_googledirection_model_Fare(fare$$0, parcel$$1, flags);
        }
    }

    private com.akexorcist.googledirection.model.Fare readcom_akexorcist_googledirection_model_Fare(android.os.Parcel parcel$$2) {
        com.akexorcist.googledirection.model.Fare fare$$1;
        fare$$1 = new com.akexorcist.googledirection.model.Fare();
        fare$$1 .currency = parcel$$2 .readString();
        fare$$1 .text = parcel$$2 .readString();
        fare$$1 .value = parcel$$2 .readString();
        return fare$$1;
    }

    private void writecom_akexorcist_googledirection_model_Fare(com.akexorcist.googledirection.model.Fare fare$$3, android.os.Parcel parcel$$3, int flags$$0) {
        parcel$$3 .writeString(fare$$3 .currency);
        parcel$$3 .writeString(fare$$3 .text);
        parcel$$3 .writeString(fare$$3 .value);
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.akexorcist.googledirection.model.Fare getParcel() {
        return fare$$0;
    }

    public final static class Creator$$4
        implements Creator<Fare$$Parcelable>
    {


        @Override
        public Fare$$Parcelable createFromParcel(android.os.Parcel parcel$$4) {
            return new Fare$$Parcelable(parcel$$4);
        }

        @Override
        public Fare$$Parcelable[] newArray(int size) {
            return new Fare$$Parcelable[size] ;
        }

    }

}
