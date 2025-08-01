package com.burp.preferences;

import burp.api.montoya.persistence.Preferences;

public class PwnFoxChromePreferences {
    private Preferences montoyaPreferences;
    public BrowserPathPreference browserPath;
    public ProfilesDirPreference profilesDir;

    public PwnFoxChromePreferences(Preferences montoyaPreferences) throws Exception {
        this.montoyaPreferences = montoyaPreferences;
        this.browserPath = new BrowserPathPreference();
        this.profilesDir = new ProfilesDirPreference();

        initDefaultPreferences();
    }

    private void initDefaultPreferences() throws Exception {
        if (!preferenceExists(browserPath.getPersistentKey())) {
            set(browserPath, browserPath.getDefault());
        }
        if (!preferenceExists(profilesDir.getPersistentKey())) {
            set(profilesDir, profilesDir.getDefault());
        }
    }

    public String get(Preference preference) {
        return montoyaPreferences.getString(preference.getPersistentKey());
    }

    public void set(Preference preference, String value) {
        montoyaPreferences.setString(preference.getPersistentKey(), value);
    }

    private boolean preferenceExists(String settingName) {
        return montoyaPreferences.getString(settingName) != null;
    }
}
