package com.example.dablyazov.binding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by ablya on 19.11.2017.
 */

public class FinalTime extends BaseObservable {

    private int _StartHour, _EndHour;

    private int _StartMin, _EndMin;

    public void SetHours(int startHour, int endHour) {
    if (checkCorrectionHours(startHour) && checkCorrectionHours(endHour)) {
        _StartHour = startHour;
        _EndHour = endHour;
    }
        notifyPropertyChanged(BR.timeDifference);

    }

    public void SetMins(int startMin, int endMin) {

        if (checkCorrectionMins(startMin)&&checkCorrectionMins(endMin)){
            _StartMin = startMin;
            _EndMin = endMin;
        }

        notifyPropertyChanged(BR.timeDifference);

    }

    @Bindable

    public int getTimeDifference() {
        int startMinutes = _StartHour * 60 + _StartMin;
        int endMinutes = _EndHour * 60 + _EndMin;
        if (endMinutes>startMinutes) {
            return endMinutes - startMinutes;
        }
        else return 0;

    }

    public boolean checkCorrectionMins(int time){
        if (time < 60 && time >= 0)
            return true;
        return false;
    }

    public boolean checkCorrectionHours(int time){
        if (time < 24 && time >= 0)
            return true;
        return false;
    }

}