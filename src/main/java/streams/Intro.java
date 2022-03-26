package streams;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static streams.Players.loadPlayers;

public class Intro {

    public static void main(String[] args) throws IOException {
        new Intro().run();
    }

    void run() throws IOException {
        List<Player> players = loadPlayers("players.txt");

        List<Player> goodPlayers = players.stream().filter(p -> p.score() > 500).toList();
        System.out.println("goodPlayers: " + goodPlayers);

        Map<String, List<Player>> playersByTeam = players.stream().collect(Collectors.groupingBy(p -> p.team()));
        System.out.println("teams: " + playersByTeam);
    }
}
