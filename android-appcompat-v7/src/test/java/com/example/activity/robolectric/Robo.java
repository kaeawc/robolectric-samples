package com.example.activity.robolectric;

import android.app.Activity;

import org.junit.runners.model.InitializationError;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

import java.io.File;

public class Robo extends RobolectricTestRunner {

    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC = 18;
    private static final int MIN_SDK_SUPPORTED_BY_MULTIDEX = 4;

    // Paths to create Robolectric's App Manifest
    private static final String MANIFEST_PATH = "src/main/AndroidManifest.xml";
    private static final String RESOURCES_PATH = "src/main/res";
    private static final String ASSETS_PATH = "src/main/assets";
    private static final String PROJECT_NAME = "android-appcompat-v7";

    // Required for appcompat-v7 Activities
    private static final String ACTIVITY_THEME = "@style/RoboAppTheme";

    public Robo(Class<?> testClass)
            throws InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {

        String manifestPath = MANIFEST_PATH;
        String resourcesPath = RESOURCES_PATH;
        String assetsPath = ASSETS_PATH;

        if (!new File(manifestPath).exists()) {
            manifestPath = PROJECT_NAME + "/" + MANIFEST_PATH;
            resourcesPath = PROJECT_NAME + "/" + RESOURCES_PATH;
            assetsPath = PROJECT_NAME + "/" + ASSETS_PATH;
        }

        return new AndroidManifest(
            Fs.fileFromPath(manifestPath),
            Fs.fileFromPath(resourcesPath),
            Fs.fileFromPath(assetsPath));
    }
}

