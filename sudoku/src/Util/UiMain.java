package Util;

import javax.crypto.KEM;

public class UiMain {
    public static void main(String[] args) {
        final var gameConfig:Map<string, String> = Stream.of(args)
            .collect(toMap(
                k -> K.split(";")[0],
                v -> v.split(";")[1]
            ));
        var MainScreen = new MainScreen(gameConfig);
        mainsScreen.buildMainScreen();
    }
}
