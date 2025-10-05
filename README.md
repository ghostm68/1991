# InkRealm Mirror - Android App

An Android application that mirrors the content from [inkrealm.info/1991](https://inkrealm.info/1991) with automatic updates, featuring an MGM lion roar loading screen and film marker app icon.

## Features

- 🎬 **MGM Lion Roar Loading Screen**: Cinematic loading animation with roaring lion
- 🎞️ **Film Marker App Icon**: Professional movie production aesthetic
- 🔄 **Automatic Updates**: Content syncs every 5 minutes when online
- 📱 **WebView Integration**: Seamless browsing of inkrealm.info/1991
- 🌐 **Offline Support**: Cached content available when offline
- ⚡ **Swipe to Refresh**: Pull-to-refresh functionality
- 🔔 **Auto-Start Service**: Updates continue after device reboot

## Project Structure

```
InkRealm-Mirror/
├── app/
│   ├── src/main/
│   │   ├── java/com/inkrealm/mirror/
│   │   │   ├── MainActivity.java          # Main WebView activity
│   │   │   ├── LoadingActivity.java       # MGM lion roar loading screen
│   │   │   ├── UpdateReceiver.java        # Broadcast receiver for updates
│   │   │   └── UpdateService.java         # Background update service
│   │   ├── res/                           # Android resources
│   │   └── assets/offline.html           # Offline fallback page
│   └── build.gradle                      # App-level build configuration
├── .github/workflows/
│   └── android-build.yml                 # CI/CD pipeline
├── build.gradle                          # Project-level build configuration
└── README.md                            # This file
```

## Getting Started

### Prerequisites

- Android Studio Arctic Fox (2020.3.1) or later
- Android SDK 24 (Android 7.0) or higher
- Java Development Kit (JDK) 17 or later

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/inkrealm-mirror.git
   cd inkrealm-mirror
   ```

2. **Open in Android Studio**:
   - Launch Android Studio
   - Select "Open an existing project"
   - Choose the `inkrealm-mirror` directory

3. **Build the project**:
   ```bash
   ./gradlew build
   ```

4. **Run on emulator or device**:
   ```bash
   ./gradlew installDebug
   ```

### Building Release APK

1. **Generate signed APK**:
   ```bash
   ./gradlew assembleRelease
   ```

2. **The APK will be located at**:
   ```
   app/build/outputs/apk/release/app-release.apk
   ```

## Configuration

### Customizing Update Interval

Modify the refresh interval in `MainActivity.java`:
```java
private static final long REFRESH_INTERVAL = 5 * 60 * 1000; // 5 minutes
```

### Changing Target URL

Update the target URL in `MainActivity.java`:
```java
private static final String TARGET_URL = "https://inkrealm.info/1991";
```

### Modifying Loading Duration

Adjust the loading screen duration in `LoadingActivity.java`:
```java
private static final int LOADING_DURATION = 3000; // 3 seconds
```

## CI/CD Pipeline

The project includes a GitHub Actions workflow (`.github/workflows/android-build.yml`) that:

- **Automated Builds**: Triggers on push to main/develop branches
- **Daily Update Checks**: Scheduled to check for website changes at 2 AM UTC
- **Multi-Stage Pipeline**: Debug build, tests, lint checks, and release build
- **Artifact Upload**: APK files and test results are saved as artifacts
- **Release Automation**: Creates GitHub releases with signed APKs

### Setting Up CI/CD

1. **Add secrets to your GitHub repository**:
   - `SIGNING_KEY`: Base64 encoded signing key
   - `ALIAS`: Key alias
   - `KEY_STORE_PASSWORD`: Keystore password
   - `KEY_PASSWORD`: Key password

2. **Enable workflows** in repository settings

3. **Push to trigger the pipeline**:
   ```bash
   git push origin main
   ```

## Development

### Code Style

The project follows standard Android development conventions:
- Java coding standards
- Material Design guidelines
- Android best practices for WebView

### Testing

Run unit tests:
```bash
./gradlew test
```

Run instrumentation tests:
```bash
./gradlew connectedAndroidTest
```

### Debugging

Enable WebView debugging in `MainActivity.java`:
```java
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    WebView.setWebContentsDebuggingEnabled(true);
}
```

## Deployment

### Google Play Store

1. **Build signed release APK**:
   ```bash
   ./gradlew assembleRelease
   ```

2. **Upload to Google Play Console**:
   - Create a new app in Google Play Console
   - Upload the signed APK
   - Fill in store listing information
   - Submit for review

### Direct Distribution

1. **Build debug APK**:
   ```bash
   ./gradlew assembleDebug
   ```

2. **Distribute the APK**:
   - Share `app/build/outputs/apk/debug/app-debug.apk`
   - Users must enable "Unknown Sources" to install

## Troubleshooting

### Common Issues

1. **WebView not loading content**:
   - Check internet connection
   - Verify URL is accessible
   - Check WebView settings in MainActivity

2. **Build failures**:
   - Ensure JDK 17 is installed
   - Check Android SDK is properly configured
   - Verify Gradle wrapper permissions

3. **App crashes on startup**:
   - Check logcat for error messages
   - Verify all permissions are granted
   - Ensure WebView is properly initialized

### Performance Optimization

- **Enable WebView caching**: Already configured in MainActivity
- **Optimize images**: Use WebP format for better compression
- **Minimize JavaScript**: Reduce heavy scripts on loaded pages

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- **inkrealm.info** for the original content
- **Android WebView** team for the excellent documentation
- **Material Design** team for UI guidelines

## Support

For issues and feature requests, please use the [GitHub Issues](https://github.com/yourusername/inkrealm-mirror/issues) page.

---

**Built with ❤️ for the inkrealm community**