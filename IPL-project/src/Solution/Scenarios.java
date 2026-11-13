package Solution;

import java.util.*;

public class Scenarios {
    static Map<String, Long> matchesPerYear(List<String[]> matches,String[] matchHeaders) {
        Map<String, Long> map = new TreeMap<>();
        String column="season";
        int index=-1;
        for (int i = 0; i < matchHeaders.length; i++) {
            if (matchHeaders[i].equalsIgnoreCase(column)) {
                index = i;
            }
        }
        for (String[] strings : matches) {
            String seasonYear = strings[index];
            map.put(seasonYear,map.getOrDefault(seasonYear,0L)+1);
        }
        return map;
    }

    static Map<String, Long> winsPerTeam(List<String[]> matches,String[] matchHeaders) {
            Map<String, Long> map = new TreeMap<>();
            String column="winner";
            int index=-1;
            for (int i = 0; i < matchHeaders.length; i++) {
                if (matchHeaders[i].equalsIgnoreCase(column)) {
                    index = i;
                }
            }
            for (String[] match : matches) {
                String team = match[index];
                if(team.isEmpty())continue;
                map.put(team,map.getOrDefault(team,0L)+1);

            }
        return map;
    }

    static Map<String, Integer> extraRuns2016(List<String[]> deliveries,List<String[]>matches,String[] deliveryHeaders,String[] matchHeaders) {
        Map<String, Integer> map = new TreeMap<>();
        String season="2016";

        Set<String> seasonIds = new TreeSet<>();
        for (String[] match : matches) {
            if(match[1].equals("2016"))seasonIds.add(match[0]);
        }
        int team_index=3;
        int extraRuns_index=16;


        for (String[] delivery : deliveries) {
            if(seasonIds.contains(delivery[0])){
                String teamName = delivery[team_index];
                int runs = Integer.parseInt(delivery[extraRuns_index]);

                map.put(teamName,map.getOrDefault(teamName,0)+runs);
            }
        }
        return map;
    }
// 4 question
    static List<Map.Entry<String, int[]>> topEconomicalBowlers2015(
            List<String[]> deliveries,
            List<String[]> matches,
            int topN) {

        Set<String> season2015Ids = new HashSet<>(matches.size() * 2);
        for (String[] m : matches) {
            if ("2015".equals(m[1])) season2015Ids.add(m[0]);
        }

        Map<String, int[]> stats = new HashMap<>(deliveries.size() * 2 / 3 + 1);

        final int BOWLER = 8, WIDE = 10, NO_BALL = 13, BAT_RUNS = 15;
        for (String[] d : deliveries) {
            if (!season2015Ids.contains(d[0])) continue;

            int[] s = stats.computeIfAbsent(d[BOWLER], k -> new int[2]);
            int wide   = Integer.parseInt(d[WIDE]);
            int noBall = Integer.parseInt(d[NO_BALL]);
            if (wide == 0 && noBall == 0) s[0]++;
            s[1] += Integer.parseInt(d[BAT_RUNS]) + wide + noBall;
        }

        // 3. Economy comparator (ascending), exact via cross-multiply
        Comparator<Map.Entry<String, int[]>> economyAsc =
                (a, b) -> {
                    int[] va = a.getValue(), vb = b.getValue();
                    int c = Long.compare((long) va[1] * vb[0], (long) vb[1] * va[0]);
                    return c != 0 ? c : a.getKey().compareTo(b.getKey());
                };

        // 4. Bounded min-heap — O(n log topN)
        PriorityQueue<Map.Entry<String, int[]>> heap =
                new PriorityQueue<>(Math.max(1, topN), economyAsc.reversed());

        for (Map.Entry<String, int[]> e : stats.entrySet()) {
            if (e.getValue()[0] < 60) continue;
            heap.offer(e);
            if (heap.size() > topN) heap.poll();
        }

        List<Map.Entry<String, int[]>> result = new ArrayList<>(heap);
        result.sort(economyAsc);
        return result;
    }
    static void playerTookMostCatchesByTeam(List<String[]> deliveries, List<String[]> matches) {
        final String SEASON = "2015";
        final int MATCH_ID = 0, BOWLING_TEAM = 3, BOWLER = 8, DISMISSAL_KIND = 19, FIELDER = 20;

        // 1. Season match IDs
        Set<String> seasonMatchIds = new HashSet<>();
        for (String[] m : matches) {
            if (SEASON.equals(m[1].trim())) seasonMatchIds.add(m[MATCH_ID].trim());
        }

        // 2. team -> (fielder -> count), catches only
        Map<String, Map<String, Integer>> catchesByTeam = new HashMap<>();

        for (String[] d : deliveries) {
            if (!seasonMatchIds.contains(d[MATCH_ID].trim())) continue;

            String kind = d[DISMISSAL_KIND] == null ? "" : d[DISMISSAL_KIND].trim();
            String fielder = d[FIELDER] == null ? "" : d[FIELDER].trim();

            if ("caught and bowled".equals(kind)) {
                fielder = d[BOWLER] == null ? "" : d[BOWLER].trim();   // credit the bowler
            } else if (!"catch".equals(kind)) {
                continue;                                              // not a catch at all
            }
            if (fielder.isEmpty()) continue;

            catchesByTeam
                    .computeIfAbsent(d[BOWLING_TEAM].trim(), k -> new HashMap<>())
                    .merge(fielder, 1, Integer::sum);
        }

        // 3. Top catcher(s) per team, ties included
        Map<String, String> teamCatcher = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> team : catchesByTeam.entrySet()) {
            int max = 0;
            List<String> top = new ArrayList<>();
            for (Map.Entry<String, Integer> p : team.getValue().entrySet()) {
                int c = p.getValue();
                if (c > max)      { max = c; top.clear(); top.add(p.getKey()); }
                else if (c == max) top.add(p.getKey());
            }
            teamCatcher.put(team.getKey(), String.join(" / ", top) + " : " + max);
        }

        teamCatcher.forEach((team, res) -> System.out.println(team + " -> " + res));
    }

}
