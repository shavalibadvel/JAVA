package Solution;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import static Solution.CustomScenarios.highestStrikeRatePlayerEachTeam;

public class IPLClass {

    static String[] matchHeaders;
    static String[] deliveryHeaders;
    static List<String[]> matches    = new ArrayList<>();
    static List<String[]> deliveries = new ArrayList<>();
    static void loadMatches(String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            matchHeaders = parseCsvLine(br.readLine());
            String line;
            while ((line = br.readLine()) != null) matches.add(parseCsvLine(line));
        }
    }
    static void loadDeliveries(String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            deliveryHeaders = parseCsvLine(br.readLine());
            String line;
            while ((line = br.readLine()) != null) deliveries.add(parseCsvLine(line));
        }
    }
    static String[] parseCsvLine(String line) {
        if (line == null || line.isEmpty()) return new String[0];
        List<String> fields = new ArrayList<>(24);
        StringBuilder sb = new StringBuilder(64);
        boolean inQuotes = false;

        for (int i = 0, n = line.length(); i < n; i++) {
            char c = line.charAt(i);
            if (inQuotes) {
                if (c == '"') {
                    if (i + 1 < n && line.charAt(i + 1) == '"') { sb.append('"'); i++; }
                    else inQuotes = false;
                } else sb.append(c);
            } else {
                if (c == '"') inQuotes = true;
                else if (c == ',') { fields.add(sb.toString().trim()); sb.setLength(0); }
                else sb.append(c);
            }
        }
        fields.add(sb.toString().trim());
        return fields.toArray(new String[0]);
    }

    // ---------- ACCESSORS ----------
    static int idx(String[] headers, String column) {
        for (int i = 0; i < headers.length; i++)
            if (headers[i].equalsIgnoreCase(column)) return i;
        throw new IllegalArgumentException("column '" + column + "' not found");
    }
    static int mIdx(String c) { return idx(matchHeaders, c); }
    static int dIdx(String c) { return idx(deliveryHeaders, c); }

    static int    intAt(String[] r, int i) { return i < r.length && !r[i].isEmpty() ? Integer.parseInt(r[i]) : 0; }
    static String strAt(String[] r, int i) { return i < r.length ? r[i] : ""; }

    // ---------- VENUE (structural normalization only) ----------
    static String canonicalVenue(String raw) {
        if (raw == null || raw.isEmpty()) return raw;
        int comma = raw.indexOf(',');
        return (comma >= 0 ? raw.substring(0, comma) : raw).trim();
    }



    // ---------- MAIN ----------
    public static void main(String[] args) throws IOException {

        loadMatches("/Users/shavali/Documents/Java Learning/IPL-project/src/Solution/archive/matches.csv");
        loadDeliveries("/Users/shavali/Documents/Java Learning/IPL-project/src/Solution/archive/deliveries.csv");

        //OwnScenarios.highestIndividualScoreOfTeam(deliveries,matches,2016);
        //OwnScenarios.highestWicketTakerTeam(deliveries,matches,2017);
        //OwnScenarios.most100And50PerTeam(deliveries,matches,2016);
        //OwnScenarios.bestEconomyPerTeam(deliveries,matches,2016);
        //OwnScenarios.bestPlayerOfPowerplayPerTeam(deliveries,matches,2016);
//        Comparator<String> x=new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        };
        OwnScenarios.mostDotBallBowler(deliveries,matches,2016);


    }
}