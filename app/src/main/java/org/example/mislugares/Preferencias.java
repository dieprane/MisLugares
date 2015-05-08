package org.example.mislugares;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Diego_Trabajo on 06/05/2015.
 */
public class Preferencias extends PreferenceActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }

}