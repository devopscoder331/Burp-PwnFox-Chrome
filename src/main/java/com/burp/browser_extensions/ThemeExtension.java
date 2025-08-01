package com.burp.browser_extensions;

import com.burp.common.ProfileColors;

import java.io.IOException;

public class ThemeExtension extends ColorExtension {
    public ThemeExtension(String extensionDir, ProfileColors profileColor) {
        super(extensionDir, profileColor);
    }

    @Override
    void load() throws IOException {
        copyJarColorResource(
                "browser-extensions/theme-template/manifest.json",
                "manifest.json"
        );
    }
}
