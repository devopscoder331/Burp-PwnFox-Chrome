## Burp PwnFox Chrome


### How to use the extension


### Installation

1. Download the up-to-date BurpPwnFoxChrome.jar from the [Releases](https://github.com/devopscoder331/Burp-PwnFox-Chrome/releases) tab.
2. Import the BurpPwnFoxChrome.jar into Burp Suite.

### Manual Build

You can build the project manually using Docker:

```sh
docker run --rm -v "$PWD":/workspace -w /workspace gradle:8.7-jdk17 gradle clean jar
```

The built JAR file will be located in the `build/lib/BurpPwnFoxChrome.jar` directory. Then import the BurpSitemapExporter.jar into Burp Suite.