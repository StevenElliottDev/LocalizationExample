# LocalizationExample
Localization Example to demo capabilities


- App will default to english regardless of devices locale on start
- Locale can be independently changed to Spanish, English, or French
- French demostrates a non supported locale
- Once locale is selected it is presisted


One difficulty is to manage changing the locale during runtime. This requires attaching a new base context onto the activity that is running.
This means two things: 
1. This will likley be one of the more error prone errors across version of Android
2. The changing of locale is a configuration change so activity lifecycle is restarted

The app uses [locale-helper-android](https://github.com/zeugma-solutions/locale-helper-android) for managing the locale at runtime
