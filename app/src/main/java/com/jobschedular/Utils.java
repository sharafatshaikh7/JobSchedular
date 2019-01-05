package com.jobschedular;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

public class Utils {

    @TargetApi(Build.VERSION_CODES.M)
    public static void scheduleJob(Context context){
        ComponentName componentName= new ComponentName(context,TestJobService.class);
        JobInfo.Builder builder= new JobInfo.Builder(0,componentName);
        builder.setMinimumLatency(1000);
        builder.setOverrideDeadline(3000);
        //builder.setRequiredNetwork(JobInfo.NETWORK_TYPE_UNMETERED);
        //builder.setRequiresDeviceIdle(false);
        //builder.setRequiresCharging(false);

        JobScheduler jobScheduler= context.getSystemService(JobScheduler.class);
        jobScheduler.schedule(builder.build());
    }
}
