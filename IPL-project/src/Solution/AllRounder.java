package Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllRounder {
    static void bestAllRounderOfSeason(List<String[]> matches,List<String[]> deliveries,String season){
        Set<Integer> teamCatcherSet = new HashSet<>();
        for(String[] match:matches){
            int s_id=Integer.parseInt(match[0]);
            if((match[1].trim()).equals(season)){
                teamCatcherSet.add(s_id);
            }
        }
        Map<String,Map<String,int[]>> allRoundersData=new HashMap<>();
        int BowlerIndex=8;
        int Team_index=3;
        int wideIndex=10;
        int noBallIndex=13;
        int batsmanIndex=15;
        int wicketIndex=19;
        int battingPlayerIndex=6;
        int battingTeamIndex=2;
        int battingRunsIndex=15;
        final int BowRuns=1;
        final int BowBall=0;
        final int wickets=2;
        final int BatRuns=4;
        final int BatBalls=3;
        for(String[] delivery:deliveries){
            int s_id=Integer.parseInt(delivery[0]);
            if(!teamCatcherSet.contains(s_id))continue;
            String teamNameBowling=delivery[Team_index].trim();
            String bowlerName=delivery[BowlerIndex].trim();
            String wicket=delivery[wicketIndex].trim();
            int wides=Integer.parseInt(delivery[wideIndex].trim());
            int noBall=Integer.parseInt(delivery[noBallIndex].trim());
            int batRuns=Integer.parseInt(delivery[batsmanIndex].trim());
            int[] data=allRoundersData.computeIfAbsent(teamNameBowling,k->new HashMap<>()).computeIfAbsent(bowlerName,k->new int[5]);
            if(wides==0 && noBall==0){
                data[BowBall]+=1;
            }
            data[BowRuns]+=wides+noBall+batRuns;
            if(!wicket.equals("run out") && !wicket.isEmpty() ){
                data[wickets]+=1;
            }

            String battingTeam=delivery[battingTeamIndex].trim();
            String battingPlayer=delivery[battingPlayerIndex].trim();
            int[] data2=allRoundersData.computeIfAbsent(battingTeam,k->new HashMap<>()).computeIfAbsent(battingPlayer,k->new int[5]);
            if(wides!=0){
                data2[BatBalls]+=1;
            }
            data2[BatRuns]+=batRuns;

        }
        final int MIN_RUNS=100;
        final int MIN_WICKETS=5;
        Map<String,String> bestAllRounderOfTeam=new HashMap<>();
        for(Map.Entry<String,Map<String,int[]>> entry:allRoundersData.entrySet()){
            String teamName=entry.getKey();
            String playerName="";
            int runs=0;
            int totalWickets=0;
            double bestRating=-1;
            for(Map.Entry<String,int[]> entry2:entry.getValue().entrySet()){
                int runsGot=entry2.getValue()[BatRuns];
                String playerName2=entry2.getKey();
                int wicketsGot=entry2.getValue()[wickets];
                if(runsGot>=MIN_RUNS && wicketsGot>=MIN_WICKETS){
                    double rating=runs/25.0 + wicketsGot;
                    if(rating>bestRating){
                        bestRating=rating;
                        playerName=playerName2;
                        runs=runsGot;
                        totalWickets=wicketsGot;
                    }
                }
//                else{
//                    if(runsGot>=MIN_RUNS &&  wicketsGot>=1){
//                        double rating=runs/25.0 + wicketsGot;
//                        if(rating>bestRating){
//                            bestRating=rating;
//                            playerName=playerName2;
//                            runs=runsGot;
//                            totalWickets=wicketsGot;
//                        }
//                    }else if(wicketsGot>=MIN_WICKETS && runsGot>=50){
//                        double rating=runs/25.0 + wicketsGot;
//                        if(rating>bestRating){
//                            bestRating=rating;
//                            playerName=playerName2;
//                            runs=runsGot;
//                            totalWickets=wicketsGot;
//                        }
//                    }
//                }




            }
            if(!playerName.isEmpty()){
                bestAllRounderOfTeam.put(teamName,String.format(" %s :--> Runs Scores: %3d , Wicket took: %2d ",playerName,runs,totalWickets));

            }

        }
        for(String teamName:bestAllRounderOfTeam.keySet()){
            System.out.println(teamName+" -> "+bestAllRounderOfTeam.get(teamName));
        }
    }
}
