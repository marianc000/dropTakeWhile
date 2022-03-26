package streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    public static Player playerFromLine(String l) {
        String[] vals = l.split("\t");
        return new Player(vals[0], vals[1], Integer.valueOf(vals[2]), vals[3]);
    }

    public static List<Player> loadPlayers(String file) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(
                Players.class.getClassLoader().getResourceAsStream(file)))) {
            return br.lines().map(l -> playerFromLine(l)).limit(15).collect(Collectors.toList());
        }
    }

}
