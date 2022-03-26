package newFeatures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DropTakeWhile {

    public static void main(String[] args) throws IOException {
        new DropTakeWhile().run();
    }

    record Line(String txt, int x, boolean bold) {

    }

    List<Line> getConclusion(List<Line> pdf) {
        return pdf.stream().dropWhile(l -> !(l.txt.equals("Conclusions") && l.bold()))
                .takeWhile(l -> l.x == 0)
                .skip(1).toList();
    }

    void run() {

        var pdf = List.of(
                new Line("Indications", 0, true),
                new Line("Analysis is requested because", 0, false),
                new Line("we see something strange", 0, false),
                new Line("Results", 0, true),
                new Line("We observed", 0, false),
                new Line("this and that", 0, false),
                new Line("Conclusions", 0, true),
                new Line("We conclude that", 0, false),
                new Line("it is fine", 0, false),
                new Line("Prof. John Smith", 20, false)); // signature is indented
        System.out.println(pdf.stream().map(l -> l.txt).collect(Collectors.joining("\n")));

        System.out.println("Conclusions: "
                + getConclusion(pdf).stream().map(l -> l.txt)
                        .collect(Collectors.joining(" ")));
    }
}
