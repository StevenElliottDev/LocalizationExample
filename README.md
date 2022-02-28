# LocalizationExample
Localization Example to demo capabilities


- App will default to english regardless of devices locale on start
- Locale can be independently changed to Spanish, English, or French
- French demostrates a non supported locale
- Once locale is selected it is presisted
- Localization files setup for Spanish and English. 
- XmlFragment demonstrates localization using XML layouts
- ComposeFragment decomstrates localization using Compose layouts


One difficulty is to manage/changing the locale in app. This requires attaching a new base context with the correct configiration onto the application that is running.
This means two things: 
1. This will be one of the more error prone errors across version of Android as the way the base context configiration is managed has evolved over time. 
2. The changing of locale is a configuration change so activity lifecycle is restarted

The app uses [locale-helper-android](https://github.com/zeugma-solutions/locale-helper-android) for managing the locale at runtime
