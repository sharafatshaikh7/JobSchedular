package com.jobschedular;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class TestJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Intent intent= new Intent(getApplicationContext(),SampleService.class);
        getApplicationContext().startService(intent);
        Utils.scheduleJob(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
