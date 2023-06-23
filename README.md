# ChatLink

A simple mod to link your server and discord chat

## Versions

| Mod Version | Supported Mod Loaders | Supported Minecraft Versions  |
|-------------|-----------------------|-------------------------------|
| 1.0.0       | Spigot, Paper, Purpur | 1.19.x, 1.20.x                |

## Download

The latest version of ChatLink can be downloaded via [this link](https://nightly.link/sidgames5/chatlink/workflows/maven/bukkit/chatlink.jar.zip)...

...or download the latest unofficial version of ChatLink via [this link](https://nightly.link/LeWolfYT/chatlink/workflows/maven/bukkit/chatlink.jar.zip).

## Installation

1. Download a version
2. Place it in the `plugins` folder of your server
3. Run your server to generate config files
4. Make a bot for the integration in the discord developer portal
5. Make a webhook in the channel you would like to use the integration in
6. Open the config file in `plugins/chatlink/config.yml`
7. Get the channel ID for the channel you created the webhook in
8. Place all of the required information inside the config file
9. Restart your server
10. Done!

## Building

1. Download the source code
2. LINUX USERS ONLY: run `chmod +x ./gradlew`
3. Run `./gradlew build`
4. Find your jar file in `build/libs`

## Contributing

If you would like to help with the project, create a fork and create a pull request when you have made significant changes.
