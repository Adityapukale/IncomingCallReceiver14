package com.example.IncomingCallReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    String state,incommingnumber;
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            state=intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            Toast.makeText(context,"state:"+state,Toast.LENGTH_SHORT).show();
            if(state.equalsIgnoreCase("RINGING"))
            {
                incommingnumber=intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(incommingnumber,null,"I am busy,I will call you Later",null,null);
                Toast.makeText(context,"busy message sent on "+incommingnumber,Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }
    }
}