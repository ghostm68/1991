!/bin/bash

echo "=== InkRealm Mirror Project Verification ==="
echo

# Check if gradlew exists and is executable
if [ -f "./gradlew" ] && [ -x "./gradlew" ]; then
    echo "✅ Gradle wrapper is executable"
else
    echo "❌ Gradle wrapper not found or not executable"
    exit 1
fi

# Check if build.gradle exists
if [ -f "./build.gradle" ]; then
    echo "✅ Root build.gradle found"
else
    echo "❌ Root build.gradle not found"
    exit 1
fi

# Check if app build.gradle exists
if [ -f "./app/build.gradle" ]; then
    echo "✅ App build.gradle found"
else
    echo "❌ App build.gradle not found"
    exit 1
fi

# Check if AndroidManifest.xml exists
if [ -f "./app/src/main/AndroidManifest.xml" ]; then
    echo "✅ AndroidManifest.xml found"
else
    echo "❌ AndroidManifest.xml not found"
    exit 1
fi

# Check if main activity exists
if [ -f "./app/src/main/java/com/inkrealm/mirror/MainActivity.java" ]; then
    echo "✅ MainActivity.java found"
else
    echo "❌ MainActivity.java not found"
    exit 1
fi

# Check if loading activity exists
if [ -f "./app/src/main/java/com/inkrealm/mirror/LoadingActivity.java" ]; then
    echo "✅ LoadingActivity.java found"
else
    echo "❌ LoadingActivity.java not found"
    exit 1
fi

# Check if GitHub Actions workflow exists
if [ -f "./.github/workflows/android-build.yml" ]; then
    echo "✅ GitHub Actions workflow found"
else
    echo "❌ GitHub Actions workflow not found"
    exit 1
fi

# Check if README exists
if [ -f "./README.md" ]; then
    echo "✅ README.md found"
else
    echo "❌ README.md not found"
    exit 1
fi

# Check if LICENSE exists
if [ -f "./LICENSE" ]; then
    echo "✅ LICENSE found"
else
    echo "❌ LICENSE not found"
    exit 1
fi

# Check if assets directory exists
if [ -d "./app/src/main/assets" ]; then
    echo "✅ Assets directory found"
else
    echo "❌ Assets directory not found"
    exit 1
fi

# Check if offline.html exists
if [ -f "./app/src/main/assets/offline.html" ]; then
    echo "✅ offline.html found"
else
    echo "❌ offline.html not found"
    exit 1
fi

echo
echo "🎉 Project structure verification completed successfully!"
echo
echo "To build the project, run:"
echo "  ./gradlew build"
echo
echo "To install debug APK on connected device:"
echo "  ./gradlew installDebug"
echo
echo "To build release APK:"
echo "  ./gradlew assembleRelease"
