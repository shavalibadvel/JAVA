package Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IPLClass {
    // Simple CSV loader: skips the header, returns each row as String[]
    static List<String[]> readCSV(String path) throws IOException {
        List<String[]> rows = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        br.readLine(); // skip header
        String line;
        while ((line = br.readLine()) != null) {
            rows.add(line.split(","));
        }
        br.close();
        return rows;
    }

    public static void main(String[] args) throws IOException {
        List<String[]> matches    = readCSV("/Users/shavali/Documents/Java Learning/IPL-project/src/Solution/archive/matches.csv");
        List<String[]> deliveries = readCSV("/Users/shavali/Documents/Java Learning/IPL-project/src/Solution/archive/deliveries.csv");

        // Column indices in matches.csv
        final int M_ID = 0, M_SEASON = 1, M_WINNER = 10;

        // Column indices in deliveries.csv
        final int D_MATCH_ID = 0, D_BOWLING_TEAM = 3, D_BOWLER = 8,
                D_WIDE = 10, D_NOBALL = 13, D_BATSMAN_RUNS = 15, D_EXTRA = 16;

        // ---------- 1. Matches played per year ----------
        Map<String, Integer> matchesPerYear = new HashMap<>();
        for (String[] m : matches) {
            matchesPerYear.merge(m[M_SEASON], 1, Integer::sum);
        }
        System.out.println("1. Matches per year: " + matchesPerYear);

        // ---------- 2. Matches won by each team ----------
        Map<String, Integer> winsPerTeam = new HashMap<>();
        for (String[] m : matches) {
            String winner = m[M_WINNER];
            if (!winner.isEmpty()) winsPerTeam.merge(winner, 1, Integer::sum);
        }
        System.out.println("2. Matches won per team: " + winsPerTeam);

        // Build sets of match IDs for 2016 and 2015
        Set<String> ids2016 = new HashSet<>();
        Set<String> ids2015 = new HashSet<>();
        for (String[] m : matches) {
            if (m[M_SEASON].equals("2016")) ids2016.add(m[M_ID]);
            if (m[M_SEASON].equals("2015")) ids2015.add(m[M_ID]);
        }

        // ---------- 3. Extra runs conceded per team in 2016 ----------
        Map<String, Integer> extras2016 = new HashMap<>();
        for (String[] d : deliveries) {
            if (ids2016.contains(d[D_MATCH_ID])) {
                extras2016.merge(d[D_BOWLING_TEAM], Integer.parseInt(d[D_EXTRA]), Integer::sum);
            }
        }
        System.out.println("3. Extra runs conceded in 2016: " + extras2016);

        // ---------- 4. Top economical bowlers in 2015 ----------
        Map<String, Integer> runs  = new HashMap<>();
        Map<String, Integer> balls = new HashMap<>();
        for (String[] d : deliveries) {
            if (!ids2015.contains(d[D_MATCH_ID])) continue;
            try {
                int wide   = Integer.parseInt(d[D_WIDE]);
                int noball = Integer.parseInt(d[D_NOBALL]);
                int conceded = Integer.parseInt(d[D_BATSMAN_RUNS]) + wide + noball;
                runs.merge(d[D_BOWLER], conceded, Integer::sum);
                if (wide == 0 && noball == 0) {
                    balls.merge(d[D_BOWLER], 1, Integer::sum);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing: " + String.join(",", d));
            }
        }
        List<Map.Entry<String, Double>> economy = new ArrayList<>();
        for (String bowler : runs.keySet()) {
            int b = balls.getOrDefault(bowler, 0);
            if (b == 0) continue;
            economy.add(new AbstractMap.SimpleEntry<>(bowler, runs.get(bowler) / (b / 6.0)));
        }
        economy.sort(Map.Entry.comparingByValue());
        System.out.println("4. Top 10 economical bowlers 2015:");
        economy.stream().limit(10).forEach(e ->
                System.out.printf("   %-25s %.2f%n", e.getKey(), e.getValue()));

        // ---------- 5. Custom scenario: top run-scorers ----------
        Map<String, Integer> batsmanRuns = new HashMap<>();
        for (String[] d : deliveries) {
            batsmanRuns.merge(d[5], Integer.parseInt(d[D_BATSMAN_RUNS]), Integer::sum); // col 5 = batsman
        }
        System.out.println("5. Top 10 run-scorers:");
        batsmanRuns.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(e -> System.out.printf("   %-25s %d%n", e.getKey(), e.getValue()));
    }
}
