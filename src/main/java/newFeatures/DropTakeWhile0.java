package newFeatures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DropTakeWhile0 {

    public static void main(String[] args) throws IOException {
        new DropTakeWhile0().run();
    }

    void run() {

        var list = Stream.of(0, 0, 1, 0, 0).dropWhile(i -> i == 0).toList();
        System.out.println(list);

        list = Stream.of(0, 0, 1, 0, 0).takeWhile(i -> i == 0).toList();
        System.out.println(list);
    }
}
