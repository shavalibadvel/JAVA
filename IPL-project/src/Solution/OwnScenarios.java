package Solution;

import java.util.*;

public class OwnScenarios {
    static void highestIndividualScoreOfTeam(List<String[]> deliveries,List<String[]> matches,int season){
        String seasonName=season+"";
        Set<String> seasonIds=new HashSet<>();
        for(String[] match:matches){
            if(match[1].equals(seasonName)){
                seasonIds.add(match[0]);
            }
        }
        Map<String,Map<String,int[]>> teamHighScorers=new HashMap<>();
        final int MATCH_INDEX=0,INNINGS=1;
        final int BATRUNS_INDEX=15;
        final int BATSMEN_NAME=6;
        final int TEAM_NAME=2;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[0])) continue;
            String teamName=delivery[TEAM_NAME];
            int runs=Integer.parseInt(delivery[BATRUNS_INDEX]);
            String player=delivery[BATSMEN_NAME];
            int  innings=Integer.parseInt(delivery[INNINGS]);
            int matchId=Integer.parseInt(delivery[MATCH_INDEX]);
            int wide=Integer.parseInt(delivery[10]);
            String key=player+"|"+matchId+"|"+innings;
            int[] res=teamHighScorers.computeIfAbsent(teamName,k->new HashMap<>()).computeIfAbsent(key,k->new int[2]);
            if(wide==0){
                res[0]+=1;
            }res[1]+=runs;
        }
        Map<String,String> teamHighScorars=new HashMap<>();
        for(Map.Entry<String,Map<String,int[]>> entry:teamHighScorers.entrySet()){
            String teamName=entry.getKey();
            String playerName="";
            int bestScore=-1;
            int bestStrikeRate=-1;
            for(Map.Entry<String,int[]> entry2:entry.getValue().entrySet()){
                int runs=entry2.getValue()[1];
                int balls=entry2.getValue()[0];
                int strikeRate=(runs*100)/balls;
                if(runs==bestScore){
                    if(strikeRate>bestStrikeRate){
                        bestStrikeRate=strikeRate;
                        playerName=entry2.getKey().split("\\|", 3)[0];
                        bestScore=runs;
                    }
                }
                else if(runs>bestScore){
                    bestStrikeRate=strikeRate;
                    playerName=entry2.getKey().split("\\|", 3)[0];
                    bestScore=runs;
                }

            }
            if(bestScore>=0){
                teamHighScorars.put(teamName,String.format(" %s --> High Score: %3d   SR:%3d",playerName,bestScore,bestStrikeRate));

            }
        }
       for(String teamName:teamHighScorars.keySet()){
           System.out.println(teamName+"---->"+teamHighScorars.get(teamName));
       }



    }
    // Highest wicket take of  one innings and per Team
    static void highestWicketTakerTeam(List<String[]> deliveries,List<String[]> matches,int season){
        String seasonName=season+"";
        Set<String> seasonIds=new HashSet<>();
        for(String[] match:matches){
            if(match[1].equals(seasonName)){
                seasonIds.add(match[0]);
            }
        }
        Map<String,Map<String,int[]>> teamWicketers=new HashMap<>();
        final int MATCH_ID=0,INNINGS=1,BOW_TEAM=3,WIDE=10,NOBALL=13,RUN_INDEX=15,WIC_INDEX=19,B_NAME=8;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[0].trim())) continue;
            String bowlerName=delivery[B_NAME].trim();
            int innings=Integer.parseInt(delivery[INNINGS]);
            int matchId=Integer.parseInt(delivery[MATCH_ID]);
            String key=matchId+"|"+innings+"|"+bowlerName;
            int[] res=teamWicketers.computeIfAbsent(delivery[BOW_TEAM],k->new HashMap<>()).computeIfAbsent(key,k->new int[3]);
            int wides=Integer.parseInt(delivery[WIDE]);
            int noBallRuns=Integer.parseInt(delivery[NOBALL]);
            if(wides==0 && noBallRuns==0){
                res[0]+=1;
            }
            int runs=Integer.parseInt(delivery[RUN_INDEX]);
            //System.out.println("runs: "+runs+"  wides: "+wides+"  noBall: "+noBallRuns);
            if(!delivery[WIC_INDEX].isEmpty() && !delivery[WIC_INDEX].trim().equals("run out")){
                res[2]+=1;
            }
            res[1]+=runs+wides+noBallRuns;
            //System.out.println(key+"      "+res[1]);
        }

        Map<String, String> wicketersPerTeam=new HashMap<>();
        for(Map.Entry<String,Map<String,int[]>> entry:teamWicketers.entrySet()){

            String teamName=entry.getKey();
            int wickets=-1;
            int runsGiven=-1;
            String PlayerName="";
            int ballsT=-1;
            for(Map.Entry<String,int[]> entry2:entry.getValue().entrySet()){

                int runs=entry2.getValue()[1];
                int balls=entry2.getValue()[0];
                int wicketStaken=entry2.getValue()[2];
                if(wicketStaken>wickets){
                    runsGiven=runs;
                    wickets=wicketStaken;
                    PlayerName=entry2.getKey().split("\\|", 3)[2];

                }else if(wickets==wicketStaken){
                    if(runs>runsGiven){
                        runsGiven=runs;
                        wickets=wicketStaken;
                        PlayerName=entry2.getKey().split("\\|", 3)[0];;
                    }

                }
            }
            if(!PlayerName.isEmpty()){
                wicketersPerTeam.put(teamName,String.format("%s  Best: %2d - %2d",PlayerName,wickets,runsGiven));
            }

        }
        for(String teamName:wicketersPerTeam.keySet()){
            System.out.println(teamName+" ---->  "+wicketersPerTeam.get(teamName));

        }


    }
    static void most100And50PerTeam(List<String[]> deliveries,List<String[]> matches,int season){
        String seasonName=season+"";
        Set<String> seasonIds=new HashSet<>();
        for(String[] match:matches){
            if(match[1].equals(seasonName)){
                seasonIds.add(match[0]);
            }
        }
        Map<String,Map<String,int[]>> teamScorers=new HashMap<>();
        final int MATCH_ID=0,TEAM_ID=2,INNINGS=1,BATSMAN=6,BATRUNS=15,SUPER_OVER=9;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[MATCH_ID]))continue;
            int superOver=Integer.parseInt(delivery[SUPER_OVER]);
            if(superOver==1) continue;
            String teamName=delivery[TEAM_ID];
            String playerName=delivery[BATSMAN];
            int matchId=Integer.parseInt(delivery[MATCH_ID]);
            int innings=Integer.parseInt(delivery[INNINGS]);
            int runs=Integer.parseInt(delivery[BATRUNS]);
            String key=matchId+"|"+playerName+"|"+innings;
            int[] res=teamScorers.computeIfAbsent(teamName,k->new HashMap<>()).computeIfAbsent(key,k->new int[2]);
            res[0]+=runs;

        }
        System.out.println("teamScorers:"+teamScorers);
        Map<String,Map<String,int[]>> team100s50s=new HashMap<>();
        for(Map.Entry<String,Map<String,int[]>> entry:teamScorers.entrySet()){
            String teamName=entry.getKey();

            for(String player:entry.getValue().keySet()){
                String playerName=player.split("\\|",3)[1];
                int score=entry.getValue().get(player)[0];
                int[] count=team100s50s.computeIfAbsent(teamName,k->new HashMap<>()).computeIfAbsent(playerName,k->new int[2]);
                if(score>=50 && score<100){
                    count[0]++;
                }else if(score>100){
                    count[1]++;
                }

            }



        }
        Map<String,String> scorers=new HashMap<>();

        for(Map.Entry<String,Map<String,int[]>> entry:team100s50s.entrySet()){
            String teamName=entry.getKey();
            String top50Name="",top100Name="";
            int top50=0,top100=0;
            for(var playerData:entry.getValue().entrySet()){
                int[] c=playerData.getValue();
                if(c[0]>top50){
                    top50Name= playerData.getKey();
                    top50=c[0];
                }
                if(c[1]>top100){
                    top100Name=playerData.getKey();
                    top100=c[1];
                }
            }

            scorers.put(teamName,String.format(" 50s : %s (%2d ) , 100s : %s (%2d )", top50Name,top50,top100Name,top100));
        }
        for(String teamName:scorers.keySet()){
            System.out.println(teamName+" ---->  "+scorers.get(teamName));
        }

    };






    static void bestEconomyPerTeam(List<String[]> deliveries,List<String[]> matches,int season){
        String seasonName=season+"";
        Set<String> seasonIds=new HashSet<>();
        for(String[] match:matches){
            if(match[1].trim().equals(seasonName)){
                seasonIds.add(match[0]);
            }
        }
        Map<String,Map<String,int[]>> bowlersData=new HashMap<>();
        int BOW_TEAM=3, BOWLER=8,WIDE=10,NOBALL=13,BATRUNS=15;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[0].trim()))continue;

            int wides=Integer.parseInt(delivery[WIDE].trim());
            int noballs=Integer.parseInt(delivery[NOBALL].trim());
            int runs=Integer.parseInt(delivery[BATRUNS].trim());
            String bowler=delivery[BOWLER].trim();
            String teamName=delivery[BOW_TEAM].trim();
            int[] res=bowlersData.computeIfAbsent(teamName,k->new HashMap<>()).computeIfAbsent(bowler,k->new int[2]);
            if(wides==0 && noballs==0){
                res[0]+=1;
            }
            res[1]+=runs+wides+noballs;

        }
        //System.out.println("bowlersData:"+bowlersData);
        Map<String,String> teamPlayers=new HashMap<>();
        for(Map.Entry<String,Map<String,int[]>> team:bowlersData.entrySet()){
            String teamName=team.getKey();
            double bestEconomy= Double.MAX_VALUE;
            String bestBowler="";
            for(String player:team.getValue().keySet()){
                int[] val=team.getValue().get(player);
                //System.out.println("ball"+val[0]+" , runs"+val[1]);
                if(val[0]>=60){

                    double playerEconomy=(val[1]*6.0)/val[0];
                    //System.out.println(player+" ---->  "+playerEconomy);
                    if(playerEconomy<bestEconomy){
                        bestEconomy=playerEconomy;
                        bestBowler=player;
                    }
                }

            }
            //System.out.println("Bowler:"+bestBowler+"    Economy:"+bestEconomy);
            teamPlayers.put(teamName,String.format("%s  -  Economy - %.2f",bestBowler,bestEconomy));
        }
        for(String teamName:teamPlayers.keySet()){
            System.out.println(teamName+" ----  "+teamPlayers.get(teamName));
        }
    }
    static void bestPlayerOfPowerplayPerTeam(List<String[]> deliveries,List<String[]> matches,int season){

        String seasonName=season+"";
        Set<String> seasonIds=new HashSet<>();
        for(String[] match:matches){
            if(match[1].trim().equals(seasonName)){
                seasonIds.add(match[0]);
            }

        }
        Map<String,Map<String,Integer>> batsmanData=new HashMap<>();
        final int BAT_TEAM=2, BATSMAN=6,WIDE=10,BATRUNS=15,MATCHID=0,OVER=4;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[0].trim()))continue;
            int over=Integer.parseInt(delivery[OVER].trim());
            if(over>6) continue;
            //int wides=Integer.parseInt(delivery[WIDE].trim());
            String batTeam=delivery[BAT_TEAM].trim();
            String batsman=delivery[BATSMAN].trim();
            int batruns=Integer.parseInt(delivery[BATRUNS].trim());
            int matchId=Integer.parseInt(delivery[MATCHID].trim());
            String key=matchId+"|"+batsman;
            batsmanData.computeIfAbsent(batTeam,k->new HashMap<>()).merge(key,batruns,Integer::sum);
        }
        Map<String,String> teamPlayers=new HashMap<>();
        for(Map.Entry<String,Map<String,Integer>> team:batsmanData.entrySet()){
            String teamName=team.getKey();
            String bestPlayer="";
            int BestRuns=0;
            for(String player:team.getValue().keySet()){
                String playerName=player.split("\\|",2)[1];
                int runs= team.getValue().get(player);
                if(runs>BestRuns||(runs==BestRuns && bestPlayer.compareTo(playerName)<0)){
                    BestRuns=runs;
                    bestPlayer=playerName;
                }

            }
            teamPlayers.put(teamName,String.format(" %s  Runs: %3d",bestPlayer,BestRuns));
        }
        for(String teamName:teamPlayers.keySet()){
            System.out.println(teamName+" ----  "+teamPlayers.get(teamName));
        }

    }

    static void mostDotBallBowler(List<String[]> deliveries,List<String[]> matches,int season){
        String seasonName=season+"";
        Set<String> seasonIds=new HashSet<>();
        for(String[] match:matches){
            if(match[1].trim().equals(seasonName)){
                seasonIds.add(match[0]);
            }
        }
        Map<String,Map<String,int[]>> bowlerData=new HashMap<>();
        final int BOWLER=8,BOW_TEAM=3,EXTRAS=16,BATRUNS=15,WIDES=10,NOBALL=13;
        for(String[] delivery:deliveries){
            if(!seasonIds.contains(delivery[0].trim()))continue;
            String BowlerName=delivery[BOWLER].trim();
            String teamName=delivery[BOW_TEAM].trim();
            int extras=Integer.parseInt(delivery[EXTRAS].trim());
            int noball=Integer.parseInt(delivery[NOBALL].trim());
            int wides=Integer.parseInt(delivery[WIDES].trim());
            int runs=Integer.parseInt(delivery[BATRUNS].trim());
            int[] res=bowlerData.computeIfAbsent(teamName,k->new HashMap<>()).computeIfAbsent(BowlerName,k->new int[2]);
            if(wides==0 && noball==0 ){
                res[0]+=1;
            }
            if(runs==0 && extras==0 ){
                res[1]+=1;
            }
        }
        Map<String,String> bestBowlers=new HashMap<>();
        for(Map.Entry<String,Map<String,int[]>> team:bowlerData.entrySet()){
            String teamName=team.getKey();
            String bestPlayer="";
            int bestDots=0;
            int bestBalls= Integer.MAX_VALUE;
            for(String player:team.getValue().keySet()){
                int[] val=team.getValue().get(player);
                int dots=val[1];
                int balls=val[0];
                if(dots>bestDots ||(dots==bestDots && bestBalls>balls)){
                    bestDots=dots;
                    bestPlayer=player;
                    bestBalls=balls;
                }
            }
            bestBowlers.put(teamName,String.format(" %s  Dots: %3d, Total Balls Bowled:%3d",bestPlayer,bestDots,bestBalls));
        }
        for(String teamName:bestBowlers.keySet()){
            System.out.println(teamName+" ----  "+bestBowlers.get(teamName));
        }
    }
}
