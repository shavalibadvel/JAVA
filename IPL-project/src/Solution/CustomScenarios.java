package Solution;

import java.awt.image.ImageProducer;
import java.util.*;

public class CustomScenarios {
    //every year top scorer
    static Map<String,Integer> getEachSeasonHighestRunScorer(List<String[]> deliveries, List<String[]> matches){

        return null;
    }
    static Map<String, Integer> getSeasonTopScorer(List<String[]> deliveries, List<String[]> matches,String season){
        Set<String> seasonIds=new HashSet<>();
        for(String[] d:matches){
            if(d[1].equals(season)){
                seasonIds.add(d[0]);
            }
        }
        int index=6;
        Map<String,Integer> topScores=new HashMap<>();
        for(String[] d:deliveries){
            if(seasonIds.contains(d[0])){
                topScores.merge(d[index],Integer.parseInt(d[15].trim()),Integer::sum);
            }
        }
        Map<String,Integer> seasonTopScorer=new HashMap<>();
        int topScore=0;
        String player="";
        for(String key :topScores.keySet()){
            if(topScores.get(key)>topScore){
                topScore=topScores.get(key);
                player=key;
            }
        }
        seasonTopScorer.put(player,topScore);
        return seasonTopScorer;
    }


    static void playerTookMostCatchesByTeam(List<String[]> deliveries,List<String[]> matches){
        Set<String> seasonIds=new HashSet<>();
        String season="2015";
        for(String[] match:matches){
            if(season.equals(match[1]))seasonIds.add(match[0]);
        }
        Map<String,Map<String,Integer>> catchesByTeam=new HashMap<>();
        int wicketTypeIndex=19;
        int catcherIndex=20;
        int bowlingTeamIndex=3;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[0]))continue;
            String wicketType=delivery[wicketTypeIndex].trim();
            Map<String,Integer> player=new HashMap<>();
            if(!wicketType.equals("caught") && !wicketType.equals("caught and bowled")){
//                player.put(delivery[catcherIndex],1);
                continue;
            }
            String team=delivery[bowlingTeamIndex].trim();
            String catcher=delivery[catcherIndex].trim();
            Map<String,Integer> byCatcher=catchesByTeam.computeIfAbsent(team,k -> new HashMap<>());
            byCatcher.merge(catcher,1,Integer::sum);

        }

        Map<String,String> TeamCatcher=new HashMap<>();
        for(Map.Entry<String, Map<String, Integer>> player:catchesByTeam.entrySet()){
            //System.out.println(player.getKey()+" "+player.getValue());

            String playerName="";
            int catches=0;

            for(Map.Entry<String, Integer> player1:player.getValue().entrySet()){
                if(player1.getKey().isEmpty()) continue;
                if(player1.getValue()>catches){
                    playerName=player1.getKey();
                    catches=player1.getValue();
                }

            }
            TeamCatcher.put(player.getKey(),String.format("Player : %s     Catches---%d",playerName,catches));
        }
        for(String key:TeamCatcher.keySet()){
            System.out.println(key+" -> "+TeamCatcher.get(key));
        }

    }
    static void highestStrikeRatePlayerEachTeam(List<String[]> deliveries,List<String[]> matches){
        Set<String> seasonIds=new HashSet<>();
        String season="2015";
        for(String[] match:matches){
            if(season.equals(match[1]))seasonIds.add(match[0]);
        }
        Map<String,Map<String,int[]>> strikeRates=new HashMap<>();
        int batsManIndex=6;
        int runsScoresIndex=15;
        int wideIndex=10;
        int TeamIndex=2;
        //int noBallIndex=13;
        for(String[] delivery:deliveries) {
            if (!seasonIds.contains(delivery[0])) continue;
            String batsmanName = delivery[batsManIndex].trim();
            String TeamName = delivery[TeamIndex].trim();
            int wideRuns = Integer.parseInt(delivery[wideIndex].trim());
            int batsmanRuns = Integer.parseInt(delivery[runsScoresIndex].trim());
            if (wideRuns > 0) {
                continue;
            }
            int[] stats = strikeRates.computeIfAbsent(TeamName, k -> new HashMap<>()).computeIfAbsent(batsmanName, k -> new int[2]);
            stats[0] += batsmanRuns;
            stats[1]++;



            //teamTopSR.forEach((t, s) -> System.out.println(t + " -> " + s));
            //System.out.println(teamTopSR);
        }
        final int MIN_BALLS = 100;
        Map<String, String> teamTopSR = new HashMap<>();

        for (Map.Entry<String, Map<String, int[]>> teamEntry : strikeRates.entrySet()) {
            String team = teamEntry.getKey();
            String bestName = "";
            double bestSR = -1;
            int bestRuns = 0, bestBalls = 0;

            for (Map.Entry<String, int[]> p : teamEntry.getValue().entrySet()) {
                int runs  = p.getValue()[0];
                int balls = p.getValue()[1];

                if (balls < MIN_BALLS) continue;          // ← FIXED (was >=, inverted)

                double sr = runs * 100.0 / balls;
                if (sr > bestSR ||
                        (sr == bestSR && runs > bestRuns)) {  // tie-break: more runs
                    bestSR    = sr;
                    bestName  = p.getKey();
                    bestRuns  = runs;
                    bestBalls = balls;
                }
            }
            if (!bestName.isEmpty()) {
                teamTopSR.put(team, String.format("%s : %.2f (%d Runs/%d Balls)",
                        bestName, bestSR, bestRuns, bestBalls));
            }
        }

        for(String team:teamTopSR.keySet()){
            System.out.println(team+" -> "+teamTopSR.get(team));
        }

    }
}
