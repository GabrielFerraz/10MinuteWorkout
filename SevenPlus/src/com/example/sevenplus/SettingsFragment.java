package com.example.sevenplus;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceActivity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.layout.settings);
    }


}
