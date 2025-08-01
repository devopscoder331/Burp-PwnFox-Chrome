package com.burp;

import com.burp.preferences.PwnFoxChromePreferences;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;


public class PwnFoxChrome implements BurpExtension {
    public MontoyaApi montoyaApi;
    public PwnFoxChromePreferences pwnChromiumPreferences;


    @Override
    public void initialize(MontoyaApi api) {
        this.montoyaApi = api;
        montoyaApi.extension().setName("PwnFox Chrome");

        try {
            this.pwnChromiumPreferences = new PwnFoxChromePreferences(
                montoyaApi.persistence().preferences()
            );
        } catch (Exception e) {
            montoyaApi.logging().logToOutput("PwnFox Chrome - Error loading preferences");
            montoyaApi.logging().logToError(e);
        }
        montoyaApi.logging().logToOutput("PwnFox Chrome - Preferences loaded...");

        if (this.pwnChromiumPreferences != null) {
            montoyaApi.userInterface().registerSuiteTab(
                "PwnFox Chrome",
                new PwnFoxChromeUI(this).getUI()
            );
        } else {
            montoyaApi.logging().logToOutput("PwnFox Chrome - Skipping UI registration due to preferences error");
        }
        montoyaApi.logging().logToOutput("PwnFox Chrome - Suite Tab loaded...");
        
        montoyaApi.proxy().registerRequestHandler(
            new PwnFoxChromeRequestHandler()
        );
        montoyaApi.logging().logToOutput("PwnFox Chrome - Request Interceptor loaded...");
    }
}